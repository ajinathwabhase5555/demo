/**
 * 
 */
package com.bomweb.logon;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.sql.Blob;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.sql.rowset.serial.SerialBlob;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
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

import com.bomweb.chequebook.ChequeBookResponse;
import com.bomweb.model.Logon;
import com.bomweb.service.model.LOGONIN;
import com.bomweb.service.model.LOGONOUT;
import com.bomweb.util.HibernateUtil;

/**
 * @author SACHIN
 *
 */
public class LogonServices {

	/**
	 * @param in
	 * @param out
	 * @return
	 */
	public static LOGONOUT logonService(LOGONIN in, LOGONOUT out) {
		System.out.println("*********Logon Request ***********\n" + new String(in.getReqByte()));
		Logon logon = savelogonServiceRequest(in);
		try {
			byte[] response = initiateRequest(logon.getLogonReq());
			if (response.length != 0 && response != null) {
				logon = saveLogonRsp(logon, response);
				out.setResponseCode(logon.getResponseCode());
				out.setResponseDesc(logon.getResponseDesc());
			} else {
				out.setResponseCode("91");
			}
		} catch (Exception e) {
			e.printStackTrace();
			out.setResponseCode("91");
		}
		System.out.println("*********Response out Rsp Code ***********" + out.getResponseCode());
		return out;
	}

	/**
	 * @param logon
	 * @param response
	 * @return
	 */
	private static Logon saveLogonRsp(Logon logon, byte[] response) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		File xmlFile = new File("E://BOM/Enrollment/Logon/LogonResponse_" + logon.getRrn() + ".xml");
		try {
			if (xmlFile.exists())
				xmlFile.delete();
			xmlFile.createNewFile();
			FileOutputStream fileOutputStream = new FileOutputStream(xmlFile);
			fileOutputStream.write(response);
			fileOutputStream.close();
			JAXBContext context = JAXBContext.newInstance(LogonServiceResponse.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			LogonServiceResponse responseXML = (LogonServiceResponse) unmarshaller.unmarshal(xmlFile);

			Blob rsp = new SerialBlob(response);
			logon.setResponseMsg(rsp);
			logon.setResponseCode(responseXML.getSvcHeader().getRespCode());
			logon.setResponseDesc(responseXML.getSvcHeader().getRespDesc());
			if (responseXML.getSvcHeader().getRespCode().equals("00")) {
				logon.setRspRRN(responseXML.getTxnInfo().getRrn());
				System.out.println("Response Code : " + responseXML.getServiceInfo().getLogonResInfo().getRespcode());
			}
			session.beginTransaction();
			session.saveOrUpdate(logon);
			session.getTransaction().commit();
			// xmlFile.delete();
		} catch (Exception ex) {
			ex.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return logon;
	}

	/**
	 * @param in
	 * @return
	 */
	private static Logon savelogonServiceRequest(LOGONIN in) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		Logon logon = new Logon();
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			String date = dateFormat.format(new Date());
			logon.setCurrentDate(dateFormat.parse(date));
			Blob req = new SerialBlob(in.getReqByte());
			logon.setRequestMsg(req);
			logon.setPosEntryMode("019");
			logon.setPosCode("05");
			logon.setProcessingCode(in.getProcessingCode());
			logon.setRrn(in.getRrn());
			logon.setTransactionDateTime(in.getTxnDateTime());
			logon.setTerminalID(in.getTerminalID());
			logon.setAgentID(in.getAgentID());
			logon.setLogonReq(in.getReqByte());
			logon.setTxnMode(in.getTxnMode());
			logon.setPan("XXXXXXXX" + in.getPan().substring(in.getPan().length() - 4));
			logon.setAccountNo(in.getAccountNo());
			logon.setBranchCode(in.getBranchCode());
			logon.setConsent(in.getConsent());
			logon.setReqCode(in.getRequestCode());
			session.beginTransaction();
			session.saveOrUpdate(logon);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return logon;
	}

	/**
	 * @param reqByte
	 * @return
	 * @throws KeyStoreException
	 * @throws NoSuchAlgorithmException
	 * @throws IOException
	 * @throws ClientProtocolException
	 * @throws KeyManagementException
	 */
	private static byte[] initiateRequest(byte[] reqByte) throws NoSuchAlgorithmException, KeyStoreException,
			ClientProtocolException, IOException, KeyManagementException {

		byte[] response = null;

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
				.addBinaryBody("req.txt", reqByte, ContentType.MULTIPART_FORM_DATA, "req.txt").build();
		HttpPost httpPost = new HttpPost("http://125.18.108.188:7003/Servlet/EaseServiceProcessor");
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
		return response;
	}
}