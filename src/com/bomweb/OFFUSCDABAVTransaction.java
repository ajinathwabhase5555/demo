/**
 * 
 */
package com.bomweb;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.sql.Blob;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.hibernate.Query;
import org.hibernate.Session;

import com.bomweb.model.OFFUSTransaction;
import com.bomweb.service.model.TransactionModel_OUT;
import com.bomweb.util.HibernateUtil;
import com.bomweb.util.MessageParser;

/**
 * @author SACHIN
 *
 */
public class OFFUSCDABAVTransaction {

	static Log log = LogFactory.getLog(OFFUSCDABAVTransaction.class);

	/**
	 * @param rrn
	 * @param out
	 * @return
	 */
	public static TransactionModel_OUT cdaRequest(String rrn, String uid, TransactionModel_OUT out) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		String hql = "FROM OFFUSTransaction O WHERE O.rrnNo =" + rrn;
		Query query = session.createQuery(hql);
		List<OFFUSTransaction> list = query.list();
		for (OFFUSTransaction offusTransaction : list) {
			byte[] request = CDABAVMessage.getCDARequest(offusTransaction, uid);
			System.out.println("************ CDA Request *************\n" + new String(request));
			offusTransaction = saveCDARequest(request);
			byte[] response = initiateRequest(offusTransaction.getCdaRequest());
			if (response.length != 0) {
				offusTransaction = saveCDAResponse(response, offusTransaction);
				out.setResponseCode(offusTransaction.getResresponseCode());
			} else {
				out.setResponseCode("91");
				out.setResponseMsg("No response from FIGateway..");
			}
		}
		return out;
	}

	/**
	 * @param response
	 * @param offusTransaction
	 * @return
	 */
	private static OFFUSTransaction saveCDAResponse(byte[] response, OFFUSTransaction offusTransaction) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		OFFUSTransaction transactionLog = (OFFUSTransaction) session.load(OFFUSTransaction.class,
				offusTransaction.getId());
		try {
			MessageParser messageParser = new MessageParser();
			System.out.println("*************** CDA Response ********************");
			String[] rsp = messageParser.parseAEPSMsg(response, "transaction");
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			String date = dateFormat.format(new Date());
			transactionLog.setCurrentDate(dateFormat.parse(date));
			Blob iso = new SerialBlob(response);
			transactionLog.setResponseMsg(iso);
			transactionLog.setResaccountNo(rsp[2]);
			transactionLog.setResprocessingCode(rsp[3]);
			transactionLog.setRestransactionDateTime(rsp[7]);
			transactionLog.setResstan(rsp[11]);
			transactionLog.setRestransactionTime(rsp[12]);
			transactionLog.setRestransactionDate(rsp[13]);
			transactionLog.setResrrnNo(rsp[37]);
			transactionLog.setResresponseCode(rsp[39]);
			transactionLog.setResterminalID(rsp[41]);
			transactionLog.setRescardAcceptorID(rsp[42]);
			transactionLog.setResAgentsInformation(rsp[46]);
			transactionLog.setRescurrencyCode(rsp[49]);
			transactionLog.setAuthCode(rsp[62]);
			transactionLog.setResAdditionalDataFT(rsp[120]);
			session.beginTransaction();
			session.saveOrUpdate(transactionLog);
			session.getTransaction().commit();
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return transactionLog;
	}

	/**
	 * @param request
	 * @return
	 */
	private static OFFUSTransaction saveCDARequest(byte[] request) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		OFFUSTransaction transactionLog = new OFFUSTransaction();
		try {
			MessageParser messageParser = new MessageParser();
			String[] req = messageParser.parseAEPSMsg(request, "transaction");
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			String date = dateFormat.format(new Date());
			transactionLog.setCurrentDate(dateFormat.parse(date));
			Blob iso = new SerialBlob(request);
			transactionLog.setRequestMsg(iso);
			transactionLog.setHeader("023202");
			transactionLog.setCdaRequest(request);
			transactionLog.setAccountNo(req[2]);
			transactionLog.setProcessingCode(req[3]);
			transactionLog.setTransactionAmount(req[4]);
			transactionLog.setTransactionDateTime(req[7]);
			transactionLog.setStan(req[11]);
			transactionLog.setTransactionTime(req[12]);
			transactionLog.setTransactionDate(req[13]);
			transactionLog.setMerchantType(req[18]);
			transactionLog.setPosEntryMode(req[22]);
			transactionLog.setPosConditionCode(req[25]);
			transactionLog.setAiic(req[32]);
			transactionLog.setRrnNo(req[37]);
			transactionLog.setTerminalID(req[41]);
			transactionLog.setCardAcceptorID(req[42]);
			transactionLog.setCardAcceptorName(req[43]);
			transactionLog.setAgentsInformation(req[46]);
			transactionLog.setCurrencyCode(req[49]);
			transactionLog.setDatetime(req[73]);
			transactionLog.setVersion(req[100]);
			transactionLog.setAdditionalDataFT(req[120]);
			session.beginTransaction();
			session.saveOrUpdate(transactionLog);
			session.getTransaction().commit();
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return transactionLog;

	}

	/**
	 * @param rrn
	 * @param out
	 * @return
	 */
	public static TransactionModel_OUT verifyBAVRequest(String rrn, String uid, TransactionModel_OUT out) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		String hql = "FROM OFFUSTransaction O WHERE O.rrnNo =" + rrn;
		Query query = session.createQuery(hql);
		List<OFFUSTransaction> list = query.list();
		for (OFFUSTransaction offusTransaction : list) {
			if (offusTransaction.getResresponseCode() == null || offusTransaction.getResresponseCode().equals("")) {
				byte[] request = CDABAVMessage.getBAVRequest(offusTransaction, uid);
				System.out.println("************ Verify BAV Request *************\n" + new String(request));
				offusTransaction = saveVerifyBAVRequest(request);
				byte[] response = initiateRequest(offusTransaction.getVerifyBAVRequest());
				if (response.length != 0) {
					offusTransaction = saveVerifyBAVResponse(response, offusTransaction);
					out.setResponseCode(offusTransaction.getResresponseCode());
				} else {
					out.setResponseCode("91");
					out.setResponseMsg("No response from FIGateway..");
				}
			} else {
				out.setResponseCode(offusTransaction.getResresponseCode());
			}
		}
		return out;
	}

	/**
	 * @param request
	 * @return
	 */
	private static OFFUSTransaction saveVerifyBAVRequest(byte[] request) {

		Session session = HibernateUtil.getSessionfactory().openSession();
		OFFUSTransaction transactionLog = new OFFUSTransaction();
		try {
			MessageParser messageParser = new MessageParser();
			String[] req = messageParser.parseAEPSMsg(request, "transaction");
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			String date = dateFormat.format(new Date());
			transactionLog.setCurrentDate(dateFormat.parse(date));
			Blob iso = new SerialBlob(request);
			transactionLog.setRequestMsg(iso);
			transactionLog.setHeader("023203");
			transactionLog.setVerifyBAVRequest(request);
			transactionLog.setAccountNo(req[2]);
			transactionLog.setProcessingCode(req[3]);
			transactionLog.setTransactionDateTime(req[7]);
			transactionLog.setStan(req[11]);
			transactionLog.setTransactionTime(req[12]);
			transactionLog.setTransactionDate(req[13]);
			transactionLog.setMerchantType(req[18]);
			transactionLog.setPosEntryMode(req[22]);
			transactionLog.setPosConditionCode(req[25]);
			transactionLog.setAiic(req[32]);
			transactionLog.setRrnNo(req[37]);
			transactionLog.setTerminalID(req[41]);
			transactionLog.setCardAcceptorID(req[42]);
			transactionLog.setAgentsInformation(req[46]);
			transactionLog.setCurrencyCode(req[49]);
			transactionLog.setDatetime(req[73]);
			transactionLog.setVersion(req[100]);
			transactionLog.setAccIdentification1(req[102]);
			transactionLog.setAccIdentification1(req[103]);
			session.beginTransaction();
			session.saveOrUpdate(transactionLog);
			session.getTransaction().commit();
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return transactionLog;
	}

	/**
	 * @param response
	 * @param offusTransaction
	 * @return
	 */
	private static OFFUSTransaction saveVerifyBAVResponse(byte[] response, OFFUSTransaction offusTransaction) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		OFFUSTransaction transactionLog = (OFFUSTransaction) session.load(OFFUSTransaction.class,
				offusTransaction.getId());
		try {
			MessageParser messageParser = new MessageParser();
			System.out.println("*************** Verify BAV Response ********************");
			String[] rsp = messageParser.parseAEPSMsg(response, "transaction");
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			String date = dateFormat.format(new Date());
			transactionLog.setCurrentDate(dateFormat.parse(date));
			Blob iso = new SerialBlob(response);
			transactionLog.setResponseMsg(iso);
			transactionLog.setResaccountNo(rsp[2]);
			transactionLog.setResprocessingCode(rsp[3]);
			transactionLog.setRestransactionDateTime(rsp[7]);
			transactionLog.setResstan(rsp[11]);
			transactionLog.setRestransactionTime(rsp[12]);
			transactionLog.setRestransactionDate(rsp[13]);
			transactionLog.setResrrnNo(rsp[37]);
			transactionLog.setResresponseCode(rsp[39]);
			transactionLog.setResterminalID(rsp[41]);
			transactionLog.setRescardAcceptorID(rsp[42]);
			transactionLog.setResAgentsInformation(rsp[46]);
			transactionLog.setRescurrencyCode(rsp[49]);
			transactionLog.setResAdditionalDataFT(rsp[120]);
			session.beginTransaction();
			session.saveOrUpdate(transactionLog);
			session.getTransaction().commit();
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return transactionLog;
	}

	private static byte[] initiateRequest(byte[] request) {
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
					SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);

			HttpClient httpClient = HttpClients.custom().setSSLSocketFactory(sslSF).build();

			HttpEntity entity = MultipartEntityBuilder.create()
					.addBinaryBody("req.txt", request, ContentType.MULTIPART_FORM_DATA, "req.txt").build();
			HttpPost httpPost = new HttpPost("http://125.18.108.188:7003/Servlet/IBSOtherVendorRequestServlet");
			httpPost.setEntity(entity);
			HttpResponse httpResponse = httpClient.execute(httpPost);

			HttpEntity responseEntity = httpResponse.getEntity();
			int statusCode = httpResponse.getStatusLine().getStatusCode();
			System.out.println("Status Code : " + statusCode);
			String rsp = EntityUtils.toString(responseEntity, "UTF-8").trim();
			System.out.println("Response from Bank : " + rsp);
			response = rsp.getBytes();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return response;
	}
}
