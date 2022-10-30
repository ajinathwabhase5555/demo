/**
 * 
 */
package com.bomweb.ekyc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.sql.Blob;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.sql.rowset.serial.SerialBlob;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.hibernate.Session;

import com.bomweb.encryption.EncryptionBouncyCastle;
import com.bomweb.insurance.InsuranceResponse;
import com.bomweb.model.EkycLog;
import com.bomweb.model.EkycLogXML;
import com.bomweb.service.model.EKYC_IN;
import com.bomweb.service.model.EKycResponse;
import com.bomweb.util.HibernateUtil;
import com.bomweb.util.MessageParser;

/**
 * @author Dattu
 *
 */
public class EKycManagerXml {


	static Log log = LogFactory.getLog(EKycManagerXml.class);

	public EKycResponse sendEKycRequest(EKYC_IN in) throws SocketTimeoutException {
		EKycResponse eKycResponse = new EKycResponse();
		try {
			byte[] trnReq = EKYCXML.createXML(in);
			System.out.println("*********************EKYC REQUEST*********************\n"+new String(trnReq));
			EkycLogXML ekycLog = new EkycLogXML();
			ekycLog = saveEkycRequest(trnReq,in);
			byte[] responseArray = sendRequest(trnReq);
			if (responseArray != null) {
				MessageParser parser = new MessageParser();
				String[] respnseMessage = parser.parseAEPSMsg(responseArray, "ekyc");
				ekycLog = saveEkycResponse(responseArray, respnseMessage, ekycLog.getId());
				eKycResponse.setResponseCode(respnseMessage[39]);
				if (respnseMessage[39].equals("00")) {
					eKycResponse = setClientResponse(respnseMessage, eKycResponse);
				}
			} else {
				eKycResponse.setResponseCode("NL");
			}
		} catch (IOException exception) {
			exception.printStackTrace();
			log.error("e-KYC ********" + exception.getMessage());
			eKycResponse.setResponseCode("EX");
		} catch (Exception exception) {
			exception.printStackTrace();
			log.error("e-KYC ********" + exception.getMessage());
			eKycResponse.setResponseCode("EX");
		} finally {

		}
		return eKycResponse;

			
		
	}

	/**
	 * @param parseData
	 * @return
	 */
	private EkycLogXML saveEkycRequest(byte[] eKycRequest,EKYC_IN in) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		EkycLogXML ekycLog = new EkycLogXML();
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			String date = dateFormat.format(new Date());
			ekycLog.setCurrentDate(dateFormat.parse(date));
			Blob iso = new SerialBlob(eKycRequest);
			ekycLog.setEkycReq(eKycRequest);
			ekycLog.setRequestMsg(iso);			
			ekycLog.setREQ_procCode(in.getProcessingCode());
			ekycLog.setREQ_txnDateTime(in.getTxnDateTime().substring(4, 14));
			ekycLog.setREQ_txnDate(in.getTxnDateTime().substring(4, 8)); 
            ekycLog.setREQ_txnTime(in.getTxnDateTime().substring(8, 14));
			ekycLog.setREQ_posEntryMode("019");
			ekycLog.setREQ_posConditionCode("05");
			ekycLog.setREQ_uniqueNo(in.getRrn().substring(0, 6));
			ekycLog.setREQ_binUid(in.getPan());
			ekycLog.setREQ_terminalID(in.getTerminalId());
			ekycLog.setREQ_terminalInfo(in.getTerminalInfo());
			ekycLog.setREQ_cardAcceptorID("BMU0888"+ in.getTerminalId().substring(1, 9));
			ekycLog.setREQ_rrn(in.getRrn());
			ekycLog.setREQ_agentsInformation(in.getAgentId()+"|0|02");
			ekycLog.setREQ_frmBankCode("200015");		
			ekycLog.setREQ_datetime(in.getTxnDateTime());
			session.beginTransaction();
			session.saveOrUpdate(ekycLog);
			session.getTransaction().commit();
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return ekycLog;
	}

	private EkycLogXML saveEkycResponse(byte[] ekycResponse, String[] response, int id) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		EkycLogXML ekycLog = (EkycLogXML) session.load(EkycLogXML.class, id);
		try {
			Blob ekycRsp = new SerialBlob(ekycResponse);
			ekycLog.setResponseMsg(ekycRsp);
			ekycLog.setRES_procCode(response[3]);
			ekycLog.setRES_txnDateTime(response[7]);
			ekycLog.setREQ_txnTime(response[12]);
			ekycLog.setREQ_txnDate(response[13]);
			ekycLog.setRES_rrn(response[37]);
			ekycLog.setResponseCode(response[39]);
			ekycLog.setRES_terminalID(response[41]);
			ekycLog.setRES_cardAcceptorID(response[42]);
			ekycLog.setREQ_terminalInfo(response[43]);
			if (response[39].equals("00")) {
				Blob xmlData = new SerialBlob(response[112].getBytes());
				ekycLog.setREQ_xmlData(xmlData);
				//ekycLog.setAdditionalData(response[127]);
			}
		
			session.beginTransaction();
			session.saveOrUpdate(ekycLog);
			session.getTransaction().commit();
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return ekycLog;
	}
	
	private EKycResponse setClientResponse(String[] responseArray, EKycResponse eKycResponse) throws Exception {
		String rrn = responseArray[37];
		byte[] field127 = Base64.decodeBase64(responseArray[127]);
		byte[] field112 = Base64.decodeBase64(responseArray[112]);
		String p12File = "E://BOM/Certificate/Bajrangi_ekyc_02082017.p12";
		EncryptionBouncyCastle bouncyCastle = new EncryptionBouncyCastle();
		byte[] decryptSessionKey = bouncyCastle.decryptSessionKey(p12File, "219379".toCharArray(), field127);   // production password "changeit"
		byte[] decryptedData = new String(bouncyCastle.decryptUsingSessionKey(decryptSessionKey, field112)).trim()
				.getBytes();
		File xmlFile = new File("E://BOM/eKYC/eKycResponse_" + rrn + ".xml");
		if (xmlFile.exists())
			xmlFile.delete();
		xmlFile.createNewFile();
		FileOutputStream fileOutputStream = new FileOutputStream(xmlFile);
		fileOutputStream.write(decryptedData);
		fileOutputStream.close();
		JAXBContext context = JAXBContext.newInstance(EKYCResponseXML.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		EKYCResponseXML ekycResponseXML = (EKYCResponseXML) unmarshaller
				.unmarshal(new InputStreamReader(new FileInputStream(xmlFile), "ISO-8859-1"));

		eKycResponse.setUid(ekycResponseXML.getUidData().getUid());
		eKycResponse.setName(ekycResponseXML.getUidData().getPoi().getName());
		eKycResponse.setGender(ekycResponseXML.getUidData().getPoi().getGender());
		eKycResponse.setDob(ekycResponseXML.getUidData().getPoi().getDob());
		eKycResponse.setVtc(ekycResponseXML.getUidData().getPoa().getVtc());
		eKycResponse.setStreet(ekycResponseXML.getUidData().getPoa().getStreet());
		eKycResponse.setState(ekycResponseXML.getUidData().getPoa().getState());
		eKycResponse.setPc(ekycResponseXML.getUidData().getPoa().getPc());
		eKycResponse.setLoc(ekycResponseXML.getUidData().getPoa().getLoc());
		eKycResponse.setHouse(ekycResponseXML.getUidData().getPoa().getHouse());
		eKycResponse.setDist(ekycResponseXML.getUidData().getPoa().getDist());
		eKycResponse.setCountry(ekycResponseXML.getUidData().getPoa().getCountry());
		eKycResponse.setPhoto(ekycResponseXML.getUidData().getPht());
		eKycResponse.setPhone(ekycResponseXML.getUidData().getPoi().getPhone());
		eKycResponse.setLm(ekycResponseXML.getUidData().getPoa().getLm());
		eKycResponse.setRrn(rrn);
//		xmlFile.delete();
		return eKycResponse;
	}



	private byte[] sendRequest(byte[] dataSrc) throws IOException {
		log.info("-------- e-KYC Request Started at Time : --------" + new Timestamp(System.currentTimeMillis()));
		byte[] ekycResponse = null;
		try {

			SSLContextBuilder builder = new SSLContextBuilder();
			builder.loadTrustMaterial(null, new TrustStrategy() {
				@Override
				public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
					return true;
				}
			});

			SSLConnectionSocketFactory sslSF = new SSLConnectionSocketFactory(builder.build(),
					SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);

			HttpClient httpClient = HttpClients.custom().setSSLSocketFactory(sslSF).build();

			HttpEntity entity = MultipartEntityBuilder.create()
					.addBinaryBody("req.txt", dataSrc, ContentType.MULTIPART_FORM_DATA, "req.txt").build();
			HttpPost httpPost = new HttpPost("http://125.18.108.188:7003/Servlet/IBSPOSEKYCRequestServlet"); //OtherVendorEkycServlet
			httpPost.setEntity(entity);
			HttpResponse httpResponse = httpClient.execute(httpPost);

			HttpEntity responseEntity = httpResponse.getEntity();
			int statusCode = httpResponse.getStatusLine().getStatusCode();
			System.out.println("Status Code : " + statusCode);
			if (statusCode == HttpStatus.SC_OK) {
				String response = EntityUtils.toString(responseEntity, "UTF-16");
				
				try {
					if (response != null && (!response.trim().equals(""))) {
						ekycResponse = response.getBytes();
						try {
							if (response.length() < 4) {
								log.error("No Response from Bank Server");
								return ekycResponse;
							}
						} catch (Exception exception) {
							log.error("Exception in bank Response " + exception);
						}
						try {
							ekycResponse = response.trim().getBytes();
							System.out.println("e-KYC Response :"+ new String(ekycResponse));
						} catch (Exception e) {
							log.error("Response Error :::: " + e);
						}
					} else {
						log.error("No Response From Bank");
						return ekycResponse;
					}
				} catch (Exception es) {
					log.error("Error in side response parsing " + es);
				}
			}
		} catch (Exception ex) {
			log.error("Exception : " + ex);
		}
		log.info("-------- End -------------");
		return ekycResponse;
	}

	private String returnMethodCall(HttpRequestBase paramHttpRequestBase) {
		String localObject1 = "";
		InputStream localInputStream = null;
		DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
		try {
			HttpResponse localHttpResponse = localDefaultHttpClient.execute(paramHttpRequestBase);
			String destFileName = "" + "/response.txt";

			File paramFile = new File(destFileName);
			if (!paramFile.exists())
				paramFile.createNewFile();
			FileOutputStream writeData = new FileOutputStream(destFileName);

			log.info("In Method ::: Response from bank :::::::::");
			if (localHttpResponse != null) {
				HttpEntity localHttpEntity = localHttpResponse.getEntity();
				if (localHttpEntity != null) {
					localInputStream = localHttpEntity.getContent();
					if (localInputStream != null) {
						BufferedReader localBufferedReader = new BufferedReader(
								new InputStreamReader(localInputStream));
						String str1 = localBufferedReader.readLine();
						String str2 = "";
						while (str1 != null) {
							str2 = str2 + str1 + System.getProperty("line.separator");
							str1 = localBufferedReader.readLine();
						}
						writeData.write(str2.getBytes());
						writeData.close();
						localBufferedReader.close();
						if (str2.length() > 0)
							localObject1 = str2;
					}
				}

			} else {
				log.info("null response!");
			}
		} catch (UnsupportedEncodingException localIOException2) {

			log.error("Error in 0 ::: " + localIOException2);
			return localIOException2.toString();
		} catch (ClientProtocolException localIOException3) {
			log.error("Error in 1 " + localIOException3);
			return localIOException3.toString();
		} catch (IllegalStateException localIOException4) {
			log.error("Error in 2 " + localIOException4);
			return localIOException4.toString();
		} catch (IOException localIOException6) {
			log.error("Error in 3 " + localIOException6);
			return localIOException6.toString();
		} catch (Exception exception) {
			log.error("Error in 3 " + exception);
			return exception.getMessage();
		} finally {
			if (localInputStream != null)
				try {
					localInputStream.close();
				} catch (IOException localIOException7) {
					log.error("Error in 4 " + localIOException7);
					return localIOException7.toString();
				}
		}
		localDefaultHttpClient.getConnectionManager().shutdown();
		return (String) localObject1;
	}
}
