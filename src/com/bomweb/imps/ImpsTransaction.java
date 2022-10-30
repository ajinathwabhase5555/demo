/**
 * 
 */
package com.bomweb.imps;

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

import com.bomweb.model.ImpsTxn;
import com.bomweb.service.model.IMPSIN;
import com.bomweb.service.model.IMPSOUT;
import com.bomweb.util.HibernateUtil;

/**
 * @author SACHIN
 *
 */

public class ImpsTransaction {

	static Log log = LogFactory.getLog(ImpsTransaction.class); 
	
	/**
	 * @param in
	 * @param out
	 * @return
	 */
	public static IMPSOUT impsTransaction(IMPSIN in, IMPSOUT out) {
		ImpsTxn impsTxn = saveIMPSRequest(in);
		byte[] response = initiateRequest(impsTxn.getImpsReq());
		try {
			if (response.length != 0) {
				impsTxn = saveIMPSResponse(impsTxn,response);
				out.setResponseCode(impsTxn.getResponseCode());
				out.setResponseDesc(impsTxn.getResponseDesc());
				out.setRrn(impsTxn.getRspRRN());
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
	private static ImpsTxn saveIMPSRequest(IMPSIN in) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		ImpsTxn impsTxn = new ImpsTxn();
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			String date = dateFormat.format(new Date());
			impsTxn.setCurrentDate(dateFormat.parse(date));
			Blob iso = new SerialBlob(in.getReqByte());
			impsTxn.setRequestMsg(iso);
			impsTxn.setImpsReq(in.getReqByte());
			impsTxn.setProcessingCode(in.getProcessingCode());
			impsTxn.setPan(in.getPan());
			impsTxn.setTxnDateTime(in.getTxnDateTime());
			impsTxn.setTrack2Data(in.getTrack2Data());
			impsTxn.setRrn(in.getRRN());
			impsTxn.setTerminalId(in.getTerminalId());
			impsTxn.setAgentId(in.getAgentId());
			impsTxn.setAmount(in.getAmount());
			impsTxn.setRemitAccountNo(in.getRemitAccountNo());
			impsTxn.setRemitCifNo(in.getRemitCifNo());
			impsTxn.setRemitUidNo(in.getRemitUidNo());
			impsTxn.setRemitName(in.getRemitName());
			impsTxn.setRemitSolId(in.getRemitSolId());
			impsTxn.setRemitAddress(in.getRemitAddress());
			impsTxn.setRemitterId(in.getRemitterId());
			impsTxn.setRemitMmid(in.getRemitMmid());
			impsTxn.setRemitMobileNo(in.getRemitMobileNo());
			impsTxn.setBenName(in.getBenName());
			impsTxn.setBenAccountNo(in.getBenAccountNo());
			impsTxn.setBenMobileNo(in.getBenMobileNo());
			impsTxn.setBenIFSC(in.getBenIFSC());
			impsTxn.setBenBankName(in.getBenBankName());
			impsTxn.setBenBranchName(in.getBenBranchName());
			session.beginTransaction();
			session.saveOrUpdate(impsTxn);
			session.getTransaction().commit();
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return impsTxn;
	}
	
	/**
	 * @param impsTxn
	 * @param response
	 * @return
	 */
	private static ImpsTxn saveIMPSResponse(ImpsTxn impsTxn, byte[] response) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		try {
			File xmlFile = new File("E://BOM/Enrollment/IMPS/IMPSResponse_" + impsTxn.getRrn() + ".xml");
			if (xmlFile.exists())
				xmlFile.delete();
			xmlFile.createNewFile();
			FileOutputStream fileOutputStream = new FileOutputStream(xmlFile);
			fileOutputStream.write(response);
			fileOutputStream.close();
			JAXBContext context = JAXBContext.newInstance(IMPSResponse.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			IMPSResponse responseXML = (IMPSResponse) unmarshaller.unmarshal(xmlFile);
			
			Blob rsp = new SerialBlob(response);
			impsTxn.setResponseMsg(rsp);
			impsTxn.setRspRRN(responseXML.getTxnInfo().getRrn());                  
			impsTxn.setResponseCode(responseXML.getSvcHeader().getRespCode()); 
			impsTxn.setResponseDesc(responseXML.getSvcHeader().getRespDesc()); 
//			if(responseXML.getSvcHeader().getRespCode().equals("00")) {
//				impsTxn.setAmount(responseXML.getServiceInfo().getTxnResInfo().getAmount());
//				impsTxn.setRspJournalNo(responseXML.getServiceInfo().getTxnResInfo().getJournalNo());
//			}
			session.beginTransaction();
			session.saveOrUpdate(impsTxn);
			session.getTransaction().commit();
			// xmlFile.delete();
		} catch (SQLException ex) {
			session.getTransaction().rollback();
			ex.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return impsTxn;
	}
	
	
	private static byte[] initiateRequest(byte[] impsReq) {

		log.info("*********IMPS Transaction********" + new String(impsReq));
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
			HttpPost httpPost = new HttpPost("http://125.18.108.188:7003/Servlet/IMPSEaseServiceProcessor");
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
