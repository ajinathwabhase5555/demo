/**
 * 
 */
package com.bomweb.neft;

import java.io.File;
import java.io.FileOutputStream;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.sql.rowset.serial.SerialBlob;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.hibernate.Session;

import com.bomweb.model.NeftTxn;
import com.bomweb.service.model.NEFTIN;
import com.bomweb.service.model.NEFTOUT;
import com.bomweb.util.HibernateUtil;

/**
 * @author SACHIN
 *
 */

public class NeftTransaction {

	static Log log = LogFactory.getLog(NeftTransaction.class);

	/**
	 * @param in
	 * @param out
	 * @return
	 */
	public static NEFTOUT neftTransaction(NEFTIN in, NEFTOUT out) {
		NeftTxn neftTxn = saveNEFTRequest(in);
		byte[] response = initiateRequest(neftTxn.getNeftReq());
		try {
			if (response != null && response.length != 0) {
				// neftTxn = saveNEFTResponse(neftTxn,response);
				// out.setResponseCode(neftTxn.getResponseCode());
				// out.setResponseDesc(neftTxn.getResponseDesc());
				// out.setRrn(neftTxn.getRspRRN());
			} else {
				out.setResponseCode("91");
			}
		} catch (Exception e) {
			e.printStackTrace();
			out.setResponseCode("91");
		}
		return out;
	}

	/**
	 * @param in
	 * @return
	 */
	private static NeftTxn saveNEFTRequest(NEFTIN in) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		NeftTxn neftTxn = new NeftTxn();
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			String date = dateFormat.format(new Date());
			neftTxn.setCurrentDate(dateFormat.parse(date));
			Blob iso = new SerialBlob(in.getReqByte());
			neftTxn.setRequestMsg(iso);
			neftTxn.setNeftReq(in.getReqByte());
			neftTxn.setAcqId("200015");
			neftTxn.setCaId("BMU088800002888");
			neftTxn.setMcc("6012");
			neftTxn.setPosCode("05");
			neftTxn.setPosEntryMode("019");
			neftTxn.setProcessingCode(in.getProcessingCode());
			neftTxn.setPan(in.getPan());
			neftTxn.setTxnDateTime(in.getTxnDateTime());
			neftTxn.setRrn(in.getRRN());
			neftTxn.setTerminalId(in.getTerminalId());
			neftTxn.setAgentId(in.getAgentId());
			neftTxn.setAmount(in.getAmount());
			neftTxn.setRemitAccountNo(in.getRemitAccountNo());
			neftTxn.setRemitUidNo(in.getRemitUidNo());
			neftTxn.setRemitName(in.getRemitName());
			neftTxn.setRemitSolId(in.getRemitSolId());
			neftTxn.setRemitAddress(in.getRemitAddress());
			neftTxn.setRemitterId(in.getRemitterId());
			neftTxn.setRemitMmid(in.getRemitMmid());
			neftTxn.setRemitMobileNo(in.getRemitMobileNo());
			neftTxn.setBenName(in.getBenName());
			neftTxn.setBenAccountNo(in.getBenAccountNo());
			neftTxn.setBenMobileNo(in.getBenMobileNo());
			neftTxn.setBenIFSC(in.getBenIFSC());
			neftTxn.setBenBankName(in.getBenBankName());
			neftTxn.setBenBranchName(in.getBenBranchName());
			session.beginTransaction();
			session.saveOrUpdate(neftTxn);
			session.getTransaction().commit();
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return neftTxn;
	}

	/**
	 * @param impsTxn
	 * @param response
	 * @return
	 */
	/*
	 * private static NeftTxn saveNEFTResponse(NeftTxn neftTxn, byte[] response) {
	 * Session session = HibernateUtil.getSessionfactory().openSession(); try { File
	 * xmlFile = new File("E://BOM/Enrollment/IMPS/IMPSResponse_" + neftTxn.getRrn()
	 * + ".xml"); if (xmlFile.exists()) xmlFile.delete(); xmlFile.createNewFile();
	 * FileOutputStream fileOutputStream = new FileOutputStream(xmlFile);
	 * fileOutputStream.write(response); fileOutputStream.close(); JAXBContext
	 * context = JAXBContext.newInstance(IMPSResponse.class); Unmarshaller
	 * unmarshaller = context.createUnmarshaller(); IMPSResponse responseXML =
	 * (IMPSResponse) unmarshaller.unmarshal(xmlFile);
	 * 
	 * Blob rsp = new SerialBlob(response); neftTxn.setResponseMsg(rsp);
	 * neftTxn.setRspRRN(responseXML.getTxnInfo().getRrn());
	 * neftTxn.setResponseCode(responseXML.getSvcHeader().getRespCode());
	 * neftTxn.setResponseDesc(responseXML.getSvcHeader().getRespDesc()); //
	 * if(responseXML.getSvcHeader().getRespCode().equals("00")) { //
	 * impsTxn.setAmount(responseXML.getServiceInfo().getTxnResInfo().getAmount());
	 * // impsTxn.setRspJournalNo(responseXML.getServiceInfo().getTxnResInfo().
	 * getJournalNo()); // } session.beginTransaction();
	 * session.saveOrUpdate(neftTxn); session.getTransaction().commit(); //
	 * xmlFile.delete(); } catch (SQLException ex) {
	 * session.getTransaction().rollback(); ex.printStackTrace(); } catch
	 * (JAXBException e) { e.printStackTrace(); } catch (Exception exception) {
	 * exception.printStackTrace(); } return neftTxn; }
	 */

	private static byte[] initiateRequest(byte[] impsReq) {

		log.info("*********NEFT Transaction********" + new String(impsReq));
		byte[] response = null;
		try {
			SSLContextBuilder builder = new SSLContextBuilder();
			builder.loadTrustMaterial(null, new TrustStrategy() {
				@Override
				public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
					return true;
				}
			});

			SSLConnectionSocketFactory sslSF = new SSLConnectionSocketFactory(builder.build(),
					NoopHostnameVerifier.INSTANCE);
			HttpClient httpClient = HttpClients.custom().setSSLSocketFactory(sslSF).build();

			HttpEntity entity = MultipartEntityBuilder.create()
					.addBinaryBody("req.txt", impsReq, ContentType.MULTIPART_FORM_DATA, "req.txt").build();
//			HttpPost httpPost = new HttpPost("http://125.18.108.188:7003/Servlet/IMPSEaseServiceProcessor");
			HttpPost httpPost = new HttpPost("http://125.18.108.188:7003/Servlet/TSPGenericServiceProcessor");
			httpPost.setEntity(entity);
			HttpResponse httpResponse = httpClient.execute(httpPost);

			HttpEntity responseEntity = httpResponse.getEntity();
			int statusCode = httpResponse.getStatusLine().getStatusCode();
			System.out.println("Status Code : " + statusCode);
			if (statusCode == HttpStatus.SC_OK) {
				String rsp = EntityUtils.toString(responseEntity, "UTF-8");
				System.out.println("Response from Bank : " + rsp);
				response = rsp.getBytes();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
}
