/**
 * 
 */
package com.bomweb.chequebook;

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
import java.util.Iterator;

import javax.sql.rowset.serial.SerialBlob;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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

import com.bomweb.model.ChequeBook;
import com.bomweb.service.model.CHEQUEBOOKIN;
import com.bomweb.service.model.CHEQUEBOOKOUT;
import com.bomweb.util.HibernateUtil;

/**
 * @author SACHIN
 *
 */
public class ChequeBookRequest {

	static Log log = LogFactory.getLog(ChequeBookRequest.class);

	/**
	 * @param in
	 * @param out
	 * @return
	 */
	public static CHEQUEBOOKOUT chequeBookService(CHEQUEBOOKIN in, CHEQUEBOOKOUT out) {
		ChequeBook chequeBook = saveChequeBookReq(in);
		try {
			byte[] response = initiateRequest(chequeBook.getChequeReq());
			if (response.length != 0) {
				chequeBook = saveChequeBookRsp(chequeBook, response);
				out.setResponseCode(chequeBook.getResponseCode());
				out.setResponseDesc(chequeBook.getResponseDesc());
				out.setCheque1(chequeBook.getRspCheque1());
				out.setCheque2(chequeBook.getRspCheque2());
				out.setCheque3(chequeBook.getRspCheque3());
				out.setCheque4(chequeBook.getRspCheque4());
				out.setCheque5(chequeBook.getRspCheque5());
				out.setChequeList(chequeBook.getChequeList());
			} else {
				out.setResponseCode("91");
			}
		} catch (KeyManagementException | NoSuchAlgorithmException | KeyStoreException | IOException e) {
			e.printStackTrace();
			out.setResponseCode("91");
		}
		System.out.println("*********Response out Rsp Code ***********" + out.getResponseCode());
		System.out.println("*********Response out Rsp Desc ***********" + out.getResponseDesc());
		return out;
	}

	/**
	 * @param in
	 * @return
	 */
	private static ChequeBook saveChequeBookReq(CHEQUEBOOKIN in) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		ChequeBook chequeBook = new ChequeBook();
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			String date = dateFormat.format(new Date());
			chequeBook.setCurrentDate(dateFormat.parse(date));
			Blob req = new SerialBlob(in.getReqByte());
			chequeBook.setRequestMsg(req);
			chequeBook.setPosEntryMode("019");
			chequeBook.setPosCode("05");
			chequeBook.setProcessingCode(in.getProcessingCode());
			chequeBook.setRrn(in.getRrn());
			chequeBook.setTransactionDateTime(in.getTxnDateTime());
			chequeBook.setTerminalID(in.getTerminalID());
			chequeBook.setAgentID(in.getAgentID());
			chequeBook.setChequeReq(in.getReqByte());
			chequeBook.setTxnMode(in.getTxnMode());
			chequeBook.setPan("XXXXXXXX" + in.getPan().substring(in.getPan().length() - 4));
			chequeBook.setPurpose(in.getPurpose());
			chequeBook.setNoOfChequeBook(in.getNoOfChequeBooks());
			chequeBook.setNoOfLeaves(in.getNoOfLeaves());
			chequeBook.setStopReasonCode(in.getStopReasonCode());
			chequeBook.setFromChequeNo(in.getFromChequeNo());
			chequeBook.setToChequeNo(in.getToChequeNo());
			chequeBook.setStopComment(in.getStopComment());
			chequeBook.setOption(in.getOption());
			// if (!in.getPan().equals(""))
			// chequeBook.setAadhaarNo("XXXXXXXX" +
			// in.getAadhaarNo().substring(in.getAadhaarNo().length() - 4));
			// if (!in.getVid().equals(""))
			// chequeBook.setVid("XXXXXXXX" + in.getVid().substring(in.getVid().length() -
			// 8));
			session.beginTransaction();
			session.saveOrUpdate(chequeBook);
			session.getTransaction().commit();
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return chequeBook;
	}

	/**
	 * @param chequeBook
	 * @param response
	 * @return
	 */
	private static ChequeBook saveChequeBookRsp(ChequeBook chequeBook, byte[] response) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		File xmlFile = new File("E://BOM/Enrollment/Cheque/ChequeBookResponse_" + chequeBook.getRrn() + ".xml");
		try {
			if (xmlFile.exists())
				xmlFile.delete();
			xmlFile.createNewFile();
			FileOutputStream fileOutputStream = new FileOutputStream(xmlFile);
			fileOutputStream.write(response);
			fileOutputStream.close();
			JAXBContext context = JAXBContext.newInstance(ChequeBookResponse.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			ChequeBookResponse responseXML = (ChequeBookResponse) unmarshaller.unmarshal(xmlFile);

			Blob rsp = new SerialBlob(response);
			chequeBook.setResponseMsg(rsp);
			chequeBook.setResponseCode(responseXML.getSvcHeader().getRespCode());
			chequeBook.setResponseDesc(responseXML.getSvcHeader().getRespDesc());
			if (responseXML.getSvcHeader().getRespCode().equals("00")) {
				chequeBook.setRspRRN(responseXML.getTxnInfo().getRrn());
				if (responseXML.getServiceInfo().getTxnResInfo().getChequeDetails() != null) {
					if (responseXML.getServiceInfo().getTxnResInfo().getChequeDetails().getCheque().size() != 0) {
						chequeBook.setChequeList(
								responseXML.getServiceInfo().getTxnResInfo().getChequeDetails().getCheque());
						for (Iterator<Cheque> list = responseXML.getServiceInfo().getTxnResInfo().getChequeDetails()
								.getCheque().iterator(); list.hasNext();) {
							for (int i = 0; i < 5; i++) {
								if (list.hasNext()) {
									Cheque cheque = list.next();
									if (i == 0) {
										String cheque1 = "branch : " + cheque.getBranch() + ", " + "cheques : "
												+ cheque.getCheques() + ", " + "chqFrom : " + cheque.getChqFrom() + ", "
												+ "chqTo : " + cheque.getChqTo() + ", " + "date : " + cheque.getDate()
												+ ", " + "pickupBranch : " + cheque.getPickupBranch() + ", "
												+ "Reorder : " + cheque.getReorder() + ", " + "status : "
												+ cheque.getStatus() + ", " + "stopComments : "
												+ cheque.getStopComments() + ", " + "stopReason : "
												+ cheque.getStopReason() + ", " + "stopTime : " + cheque.getStopTime()
												+ ", " + "type : " + cheque.getType();
										chequeBook.setRspCheque1(cheque1);
									}
									if (i == 1) {
										String cheque2 = "branch : " + cheque.getBranch() + ", " + "cheques : "
												+ cheque.getCheques() + ", " + "chqFrom : " + cheque.getChqFrom() + ", "
												+ "chqTo : " + cheque.getChqTo() + ", " + "date : " + cheque.getDate()
												+ ", " + "pickupBranch : " + cheque.getPickupBranch() + ", "
												+ "Reorder : " + cheque.getReorder() + ", " + "status : "
												+ cheque.getStatus() + ", " + "stopComments : "
												+ cheque.getStopComments() + ", " + "stopReason : "
												+ cheque.getStopReason() + ", " + "stopTime : " + cheque.getStopTime()
												+ ", " + "type : " + cheque.getType();
										chequeBook.setRspCheque2(cheque2);
									}
									if (i == 2) {
										String cheque3 = "branch : " + cheque.getBranch() + ", " + "cheques : "
												+ cheque.getCheques() + ", " + "chqFrom : " + cheque.getChqFrom() + ", "
												+ "chqTo : " + cheque.getChqTo() + ", " + "date : " + cheque.getDate()
												+ ", " + "pickupBranch : " + cheque.getPickupBranch() + ", "
												+ "Reorder : " + cheque.getReorder() + ", " + "status : "
												+ cheque.getStatus() + ", " + "stopComments : "
												+ cheque.getStopComments() + ", " + "stopReason : "
												+ cheque.getStopReason() + ", " + "stopTime : " + cheque.getStopTime()
												+ ", " + "type : " + cheque.getType();
										chequeBook.setRspCheque3(cheque3);
									}
									if (i == 3) {
										String cheque4 = "branch : " + cheque.getBranch() + ", " + "cheques : "
												+ cheque.getCheques() + ", " + "chqFrom : " + cheque.getChqFrom() + ", "
												+ "chqTo : " + cheque.getChqTo() + ", " + "date : " + cheque.getDate()
												+ ", " + "pickupBranch : " + cheque.getPickupBranch() + ", "
												+ "Reorder : " + cheque.getReorder() + ", " + "status : "
												+ cheque.getStatus() + ", " + "stopComments : "
												+ cheque.getStopComments() + ", " + "stopReason : "
												+ cheque.getStopReason() + ", " + "stopTime : " + cheque.getStopTime()
												+ ", " + "type : " + cheque.getType();
										chequeBook.setRspCheque4(cheque4);
									}
									if (i == 4) {
										String cheque5 = "branch : " + cheque.getBranch() + ", " + "cheques : "
												+ cheque.getCheques() + ", " + "chqFrom : " + cheque.getChqFrom() + ", "
												+ "chqTo : " + cheque.getChqTo() + ", " + "date : " + cheque.getDate()
												+ ", " + "pickupBranch : " + cheque.getPickupBranch() + ", "
												+ "Reorder : " + cheque.getReorder() + ", " + "status : "
												+ cheque.getStatus() + ", " + "stopComments : "
												+ cheque.getStopComments() + ", " + "stopReason : "
												+ cheque.getStopReason() + ", " + "stopTime : " + cheque.getStopTime()
												+ ", " + "type : " + cheque.getType();
										chequeBook.setRspCheque5(cheque5);
									}
								}
							}
							break;
						}
					}
				}
				session.beginTransaction();
				session.saveOrUpdate(chequeBook);
				session.getTransaction().commit();
				// xmlFile.delete();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			// session.getTransaction().rollback();
			log.error(ex);
		} finally {
			session.close();
		}
		return chequeBook;
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

		log.info("*********Cheque Book Req********\n" + new String(reqByte));
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
		HttpPost httpPost = new HttpPost("http://125.18.108.188:7003/Servlet/EaseServiceProcessor"); // http://125.18.108.188:7003/Servlet/EaseBankingService
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
