package com.bomweb;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.sql.rowset.serial.SerialBlob;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
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
import com.bomweb.model.ONUSTransaction;
import com.bomweb.model.ReversalRequest;
import com.bomweb.model.TransactionModelRequest;
import com.bomweb.service.model.TransactionModel_IN;
import com.bomweb.service.model.TransactionModel_OUT;
import com.bomweb.util.FIUtility;
import com.bomweb.util.HibernateUtil;
import com.bomweb.util.MessageParser;

public class Transaction {

	static Log log = LogFactory.getLog(Transaction.class);

	public static TransactionModel_OUT initiateTransaction(TransactionModel_IN in, TransactionModel_OUT out) {

		TransactionModelRequest objTransactionModelRequest = new TransactionModelRequest();
		objTransactionModelRequest.setPrimaryAccountNumber(in.getUidNo());
		objTransactionModelRequest.setAgentDetails(in.getAgentID() + "|" + "0" + "|" + "02");
		objTransactionModelRequest.setPoshEntryMode(Constant.POSHENTRYMODE);
		objTransactionModelRequest.setVendorCode("BMU8800" + in.getTerinalID().trim().substring(1, 9));
		objTransactionModelRequest.setTransactionAmount(in.getAmount());
		objTransactionModelRequest.setCurrencyCode(Constant.CURRENCYCODE);
		objTransactionModelRequest.setProcessingCode(in.getProcessingCode());
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMddHHmmss");
		String dateTime = dateFormat.format(new Date());
		Date date = new Date();
		dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
		objTransactionModelRequest.setTransactionDateTime(dateFormat.format(date));
		objTransactionModelRequest.setLocalTransactionTime(dateTime.substring(4));
		objTransactionModelRequest.setLocalTransactionDate(dateTime.substring(0, 4));
		objTransactionModelRequest.setMerchantType(Constant.MERCHANTTYPE);
		objTransactionModelRequest.setPoshConditionCode(Constant.POSHCONDITIONCODE);
		objTransactionModelRequest.setAiic(Constant.BANKIIN);
		objTransactionModelRequest.setRrn(in.getRrn());
		objTransactionModelRequest.setStan(in.getRrn().substring(in.getRrn().length() - 6));
		objTransactionModelRequest.setTerminalId(FIUtility.rightPaddedValue(in.getTerinalID(), 16));
		objTransactionModelRequest.setBcDetails(FIUtility.rightPaddedValue("VISIONINDIA", 23)
				+ FIUtility.rightPaddedValue("PUNE", 13) + FIUtility.leftPaddedValue("MH", 2) + Constant.COUNTRY);
		objTransactionModelRequest.setBcCode(in.getAgentID());

		byte[] request = ISO8583_BOSS.createISO(objTransactionModelRequest, in).getBytes();
		try {

			log.info("********ISO Message**********\n");
			System.out.println("************REQ : ******** " + new String(request));
			if (in.getTransactionMode().equalsIgnoreCase("ONUS")) {
				ONUSTransaction onusTransaction = saveRequestMsg(request);
				byte[] respnseMessage = transBOMFile(onusTransaction.getIsoReq());
				if (respnseMessage != null) {
					MessageParser parser = new MessageParser();
					String[] bankResponse = parser.parseAEPSMsg(respnseMessage, "transaction");
					saveTransactionData(respnseMessage, bankResponse, onusTransaction);
					out.setResponseCode(bankResponse[39]);
					System.out.println("Response Code: " + bankResponse[39]);
					if (bankResponse[39].equals("00")) {
						out.setCustomerAvailableBalance(bankResponse[54]);
						out.setAuthCode(bankResponse[62]);
						out.setUidNo("XXXXXXXXXXXX");
						out.setTerminalID(bankResponse[41]);
						out.setAgentID(bankResponse[46].substring(0, 8));
						out.setStan(bankResponse[11]);
						out.setRrnNo(bankResponse[37]);
						if (bankResponse[3].equals("210000") || bankResponse[3].equals("010000")
								|| bankResponse[3].equals("400000")) {
							String ta = onusTransaction.getTransactionAmount();
							String ss = ta.substring(0, ta.length() - 2);
							out.setTransactionAmount(removeLeadingZeroes(ss) + ".00");
						}
						SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
						String strDate = formatter.format(new Date());
						out.setTimestamp(strDate);
						if (bankResponse[3].equals("400000")) {
							String beneficiaryAccNo = bankResponse[120].substring(bankResponse[120].length() - 12);
							out.setBeneficiaryAccNo(beneficiaryAccNo);
						}
						if (bankResponse[3].equals("940000")) {
							String strMinistmt = bankResponse[120];
							/*
							 * List<MiniStatementData> list = new ArrayList<MiniStatementData>(); if
							 * (strMinistmt != null) { int from = 0; int to = 46; MiniStatementData data =
							 * null; while (strMinistmt.length() + 1 > to) { data = new MiniStatementData();
							 * String substring = strMinistmt.substring(from, to);
							 * data.setTxnDate(substring.substring(0, 4) + "/" + substring.substring(4, 6) +
							 * "/" + substring.substring(6, 8)); data.setTxnMode(substring.substring(8, 9));
							 * data.setTxnType(substring.substring(9, 29).trim()); data.setTxnValue(new
							 * BigDecimal(substring.substring(30, 46))); list.add(data); from = to; to +=
							 * 46; } }
							 */
							// out.setMiniStatement(strMinistmt);
						}
					}
				} else {
					out.setResponseCode("91");
				}
			} else if (in.getTransactionMode().equalsIgnoreCase("OFFUS")) {
				OFFUSTransaction offusTransaction = new OFFUSTransaction();
				offusTransaction = saveoffusRequest(request);
				byte[] respnseMessage = transBOMFile(offusTransaction.getIsoReq());
				if (respnseMessage != null) {
					MessageParser parser = new MessageParser();
					String[] bankResponse = parser.parseAEPSMsg(respnseMessage, "transaction");
					saveoffusResponse(respnseMessage, bankResponse, offusTransaction);
					out.setResponseCode(bankResponse[39]);
					if (bankResponse[39].equals("00")) {
						out.setCustomerAvailableBalance(bankResponse[54]);
						out.setAuthCode(bankResponse[62]);
						out.setUidNo("XXXXXXXXXXXX");
						out.setTerminalID(bankResponse[41]);
						out.setAgentID(bankResponse[46].substring(0, 8));
						out.setStan(bankResponse[11]);
						out.setRrnNo(bankResponse[37]);
						if (bankResponse[3].equals("210000") || bankResponse[3].equals("010000")
								|| bankResponse[3].equals("400000")) {
							String ta = offusTransaction.getTransactionAmount();
							String ss = ta.substring(0, ta.length() - 2);
							out.setTransactionAmount(removeLeadingZeroes(ss) + ".00");
						}
						SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
						String strDate = formatter.format(new Date());
						out.setTimestamp(strDate);
						if (bankResponse[3].equals("400000")) {
							String beneficiaryAccNo = bankResponse[120].substring(bankResponse[120].length() - 12);
							out.setBeneficiaryAccNo(beneficiaryAccNo);
						}
						if (bankResponse[3].equals("940000")) {
							String strMinistmt = bankResponse[120];
							/*
							 * List<MiniStatementData> list = new ArrayList<MiniStatementData>(); if
							 * (strMinistmt != null) { int from = 0; int to = 46; MiniStatementData data =
							 * null; while (strMinistmt.length() + 1 > to) { data = new MiniStatementData();
							 * String substring = strMinistmt.substring(from, to);
							 * data.setTxnDate(substring.substring(0, 4) + "/" + substring.substring(4, 6) +
							 * "/" + substring.substring(6, 8)); data.setTxnMode(substring.substring(8, 9));
							 * data.setTxnType(substring.substring(9, 29).trim()); data.setTxnValue(new
							 * BigDecimal(substring.substring(30, 46))); list.add(data); from = to; to +=
							 * 46; } }
							 */
							// out.setMiniStatement(strMinistmt);
						}
					}
				} else {
					out.setResponseCode("91");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return out;
	}

	/**
	 * @param onusRsp
	 * @param onusid
	 * @param in
	 * @param transactionLog
	 * @param response
	 * @return
	 */
	public static void saveTransactionData(byte[] onusRsp, String[] responseMsg, ONUSTransaction onus)
			throws Exception {
		Connection con = FIConnection.getConnection();
		try {
			String squery = "update TRAN_REQRSP_ONUS set RSPDMP = ?, RSP_DE2 = ?, RSP_DE3 = ?, RSP_DE7 = ?, RSP_DE11 = ?, RSP_DE12 = ?, RSP_DE13 = ?, RSP_DE32 = ?, "
					+ "RSP_DE37 = ?, RSP_DE39 = ?, RSP_DE41 = ?, RSP_DE42 = ?, RSP_DE43 = ?, RSP_DE46 = ?, RSP_DE49 = ?, RSP_DE54 = ?, RSP_DE62 = ?, RSP_DE120 = ? "
					+ "where LOG_ID= ? and TRN_DATE = ?";
			PreparedStatement pstmt = con.prepareStatement(squery);
			pstmt.setBytes(1, onusRsp);
			pstmt.setString(2, responseMsg[2]);
			pstmt.setString(3, responseMsg[3]);
			pstmt.setString(4, responseMsg[7]);
			pstmt.setString(5, responseMsg[11]);
			pstmt.setString(6, responseMsg[12]);
			pstmt.setString(7, responseMsg[13]);
			pstmt.setString(8, responseMsg[32]);
			pstmt.setString(9, responseMsg[37]);
			pstmt.setString(10, responseMsg[39]);
			pstmt.setString(11, responseMsg[41]);
			pstmt.setString(12, responseMsg[42]);
			pstmt.setString(13, responseMsg[43]);
			pstmt.setString(14, responseMsg[46]);
			pstmt.setString(15, responseMsg[49]);
			pstmt.setString(16, responseMsg[54]);
			pstmt.setString(17, responseMsg[62]);
			pstmt.setString(18, responseMsg[120]);
			pstmt.setInt(19, onus.getId());
			pstmt.setDate(20, new java.sql.Date(onus.getCurrentDate().getTime()));
			pstmt.executeUpdate();
			con.setAutoCommit(false);
			pstmt.close();
		} catch (Exception exception) {
			log.error(exception);
		} finally {
			con.close();
		}
	}

	/**
	 * @param isomsg
	 */
	private static ONUSTransaction saveRequestMsg(byte[] isomsg) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		ONUSTransaction transactionLog = new ONUSTransaction();
		try {
			MessageParser messageParser = new MessageParser();
			String[] request = messageParser.parseAEPSMsg(isomsg, "transaction");
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			String date = dateFormat.format(new Date());
			transactionLog.setCurrentDate(dateFormat.parse(date));
			Blob iso = new SerialBlob(isomsg);
			transactionLog.setRequestMsg(iso);
			transactionLog.setIsoReq(isomsg);
			transactionLog.setUidNo(request[2]);
			transactionLog.setProcessingCode(request[3]);
			if (request[3].equals("120000"))
				transactionLog.setConsentType("Authentication");
			else if (request[3].equals("310000"))
				transactionLog.setConsentType("Balance Enquiry");
			else if (request[3].equals("210000"))
				transactionLog.setConsentType("Deposit");
			else if (request[3].equals("010000"))
				transactionLog.setConsentType("Withdrawal");
			else if (request[3].equals("400000"))
				transactionLog.setConsentType("Fundtransfer");
			else if (request[3].equals("940000"))
				transactionLog.setConsentType("Ministatement");
			transactionLog.setTransactionAmount(request[4]);
			transactionLog.setTransactionDateTime(request[7]);
			transactionLog.setStan(request[11]);
			transactionLog.setTransactionTime(request[12]);
			transactionLog.setTransactionDate(request[13]);
			transactionLog.setMerchantType(request[18]);
			transactionLog.setPosEntryMode(request[22]);
			transactionLog.setPosConditionCode(request[25]);
			transactionLog.setAiic(request[32]);
			transactionLog.setRrnNo(request[37]);
			transactionLog.setTerminalID(request[41]);
			transactionLog.setCardAcceptorID(request[42]);
			transactionLog.setCardAcceptorName(request[43]);
			transactionLog.setAgentsInformation(request[46]);
			transactionLog.setCurrencyCode(request[49]);
			transactionLog.setDatetime(request[73]);
			transactionLog.setVersion(request[100]);
			transactionLog.setSenderAccountNo(request[102]);
			if (request[103] != null)
				transactionLog.setAccountNo(request[103]);
			transactionLog.setAdditionalDataFT(request[120]);
			transactionLog.setHmac(request[123]);
			transactionLog.setAdditionalData1(request[126]);
			transactionLog.setAdditionalData2(request[127]);
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

	public static void saveoffusResponse(byte[] offusRsp, String[] responseMsg, OFFUSTransaction offus)
			throws Exception {
		Connection con = FIConnection.getConnection();
		try {
			String squery = "update TRAN_REQRSP_OFFUS_25 set RSPDMP = ?, RSP_DE2 = ?, RSP_DE3 = ?, RSP_DE7 = ?, RSP_DE11 = ?, RSP_DE12 = ?, RSP_DE13 = ?, RSP_DE32 = ?, "
					+ "RSP_DE37 = ?, RSP_DE39 = ?, RSP_DE41 = ?, RSP_DE42 = ?, RSP_DE43 = ?, RSP_DE46 = ?, RSP_DE49 = ?, RSP_DE54 = ?, RSP_DE62 = ?, RSP_DE120 = ? "
					+ "where LOG_ID= ? and TRN_DATE = ?";
			PreparedStatement pstmt = con.prepareStatement(squery);
			pstmt.setBytes(1, offusRsp);
			pstmt.setString(2, responseMsg[2]);
			pstmt.setString(3, responseMsg[3]);
			pstmt.setString(4, responseMsg[7]);
			pstmt.setString(5, responseMsg[11]);
			pstmt.setString(6, responseMsg[12]);
			pstmt.setString(7, responseMsg[13]);
			pstmt.setString(8, responseMsg[32]);
			pstmt.setString(9, responseMsg[37]);
			pstmt.setString(10, responseMsg[39]);
			pstmt.setString(11, responseMsg[41]);
			pstmt.setString(12, responseMsg[42]);
			pstmt.setString(13, responseMsg[43]);
			pstmt.setString(14, responseMsg[46]);
			pstmt.setString(15, responseMsg[49]);
			pstmt.setString(16, responseMsg[54]);
			pstmt.setString(17, responseMsg[62]);
			pstmt.setString(18, responseMsg[120]);
			pstmt.setInt(19, offus.getId());
			pstmt.setDate(20, new java.sql.Date(offus.getCurrentDate().getTime()));
			pstmt.executeUpdate();
			con.setAutoCommit(false);
			pstmt.close();
		} catch (Exception exception) {
			log.error(exception);
		} finally {
			con.close();
		}
	}

	/**
	 * @param isomsg
	 */
	private static OFFUSTransaction saveoffusRequest(byte[] isomsg) {

		Session session = HibernateUtil.getSessionfactory().openSession();
		OFFUSTransaction transactionLog = new OFFUSTransaction();
		try {
			MessageParser messageParser = new MessageParser();
			String[] request = messageParser.parseAEPSMsg(isomsg, "transaction");
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			String date = dateFormat.format(new Date());
			transactionLog.setCurrentDate(dateFormat.parse(date));
			Blob iso = new SerialBlob(isomsg);
			transactionLog.setRequestMsg(iso);
			transactionLog.setIsoReq(isomsg);
			transactionLog.setAccountNo(request[2]);
			transactionLog.setProcessingCode(request[3]);
			transactionLog.setTransactionAmount(request[4]);
			transactionLog.setTransactionDateTime(request[7]);
			transactionLog.setStan(request[11]);
			transactionLog.setTransactionTime(request[12]);
			transactionLog.setTransactionDate(request[13]);
			transactionLog.setMerchantType(request[18]);
			transactionLog.setPosEntryMode(request[22]);
			transactionLog.setPosConditionCode(request[25]);
			transactionLog.setAiic(request[32]);
			transactionLog.setRrnNo(request[37]);
			transactionLog.setTerminalID(request[41]);
			transactionLog.setCardAcceptorID(request[42]);
			transactionLog.setCardAcceptorName(request[43]);
			transactionLog.setAgentsInformation(request[46]);
			transactionLog.setCurrencyCode(request[49]);
			transactionLog.setAuthInfo(request[61]);
			transactionLog.setDatetime(request[73]);
			transactionLog.setVersion(request[100]);
			transactionLog.setAdditionalDataFT(request[120]);
			transactionLog.setHmac(request[123]);
			transactionLog.setAdditionalData1(request[126]);
			transactionLog.setAdditionalData2(request[127]);
			if (request[3].equals("310000"))
				transactionLog.setConsentType("Balance Enquiry");
			else if (request[3].equals("320000")) {
				transactionLog.setConsentType("Deposit");
				transactionLog.setHeader("023201");
			} else if (request[3].equals("010000"))
				transactionLog.setConsentType("Withdrawal");
			else if (request[3].equals("400000"))
				transactionLog.setConsentType("Fundtransfer");
			else if (request[3].equals("940000"))
				transactionLog.setConsentType("Ministatement");
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

	public static byte[] transBOMFile(byte[] dataSrc) throws Exception {
		byte[] isoresponse = null;
		try {
			SSLContextBuilder builder = new SSLContextBuilder();
			builder.loadTrustMaterial(null, new TrustStrategy() {
				@Override
				public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
					System.out.println(chain);
					System.out.println(authType);
					return true;
				}
			});

			SSLConnectionSocketFactory sslSF = new SSLConnectionSocketFactory(builder.build(),
					SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);

			HttpClient httpClient = HttpClients.custom().setSSLSocketFactory(sslSF).build();

			HttpEntity entity = MultipartEntityBuilder.create()
					.addBinaryBody("req.txt", dataSrc, ContentType.MULTIPART_FORM_DATA, "req.txt").build();
			HttpPost httpPost = new HttpPost("http://125.18.108.188:7003/Servlet/IBSOtherVendorRequestServlet");
			httpPost.setEntity(entity);
			HttpResponse httpResponse = httpClient.execute(httpPost);

			final RequestConfig params = RequestConfig.custom().setConnectTimeout(91000).setSocketTimeout(91000)
					.build();
			httpPost.setConfig(params);
			HttpEntity responseEntity = httpResponse.getEntity();
			int statusCode = httpResponse.getStatusLine().getStatusCode();
			System.out.println("Status Code : " + statusCode);
			if (statusCode == HttpStatus.SC_OK) {
				String response = EntityUtils.toString(responseEntity, "UTF-8");
				System.out.println("Response from Bank : " + response);

				String data = null;
				try {
					if (response != null && (!response.trim().equals(""))) {
						data = new String(response);
						try {
							if (response.length() < 4) {
								log.info("No Response from Bank Server");
								return isoresponse;
							}
							data = data.substring(4);
						} catch (Exception exception) {
							log.info("Exception in bank Response " + exception);
						}

						try {
							isoresponse = response.trim().getBytes();
						} catch (Exception e) {
							log.info("Response Error :::: " + e);
							e.printStackTrace();
						}
					} else {
						log.info("No Response From Bank");
						return isoresponse;
					}
				} catch (Exception es) {
					log.info("Error in side response parsing " + es);
				} finally {
					responseEntity.getContent().close();
				}
				log.info("-------- End -------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isoresponse;
	}

	public static String removeLeadingZeroes(String value) {
		while (value.length() > 1 && value.indexOf("0") == 0)
			value = value.substring(1);
		return value;
	}

	/**
	 * @param rrnNo
	 * @param out
	 * @return
	 */
	public static TransactionModel_OUT reversal(TransactionModel_IN in, TransactionModel_OUT out) {
		if (in.getTransactionMode().equalsIgnoreCase("ONUS")) {
			out = onusReversal(in, out);
		} else if (in.getTransactionMode().equalsIgnoreCase("OFFUS")) {
			out = offusReversal(in, out);
		}
		return out;
	}

	public static TransactionModel_OUT offusReversal(TransactionModel_IN in, TransactionModel_OUT out) {

		Session session = HibernateUtil.getSessionfactory().openSession();
		String hql = "FROM OFFUSTransaction O WHERE O.rrnNo =" + in.getRrn();
		Query query = session.createQuery(hql);
		List<OFFUSTransaction> list = query.list();
		for (OFFUSTransaction offusTransaction : list) {
			if (offusTransaction.getResresponseCode() == null || offusTransaction.getResresponseCode().equals("")) {
				log.info("*******OFFUS Start Reversal**********");
				System.out.println("Response Code : " + offusTransaction.getResresponseCode());
				ReversalRequest reversalRequest = new ReversalRequest();
				reversalRequest.setPrimaryAccountNumber(in.getUidNo());
				reversalRequest.setTransactionMode(in.getTransactionMode());
				reversalRequest.setStan(offusTransaction.getStan());
				reversalRequest.setAgentDetails(offusTransaction.getAgentsInformation());
				reversalRequest.setPoshEntryMode(offusTransaction.getPosEntryMode());
				reversalRequest.setVendorCode(offusTransaction.getCardAcceptorID());
				reversalRequest.setTransactionAmount(offusTransaction.getTransactionAmount());
				reversalRequest.setCurrencyCode(offusTransaction.getCurrencyCode());
				reversalRequest.setProcessingCode(offusTransaction.getProcessingCode());
				reversalRequest.setTransactionDateTime(offusTransaction.getTransactionDateTime());
				reversalRequest.setLocalTransactionTime(offusTransaction.getTransactionTime());
				reversalRequest.setLocalTransactionDate(offusTransaction.getTransactionDate());
				reversalRequest.setMerchantType(offusTransaction.getMerchantType());
				reversalRequest.setPoshConditionCode(offusTransaction.getPosConditionCode());
				reversalRequest.setAiic(offusTransaction.getAiic());
				reversalRequest.setRrn(offusTransaction.getRrnNo());
				reversalRequest.setTerminalId(FIUtility.rightPaddedValue(offusTransaction.getTerminalID(), 16));
				reversalRequest.setBcDetails(offusTransaction.getCardAcceptorName());
				reversalRequest.setVersion(offusTransaction.getVersion());
				reversalRequest.setDe120(in.getDe120());
				byte[] request = ReversalMessage.getReversalTrans(reversalRequest);
				offusTransaction = saveOFFUSReversalRequest(request);
				System.out.println(new String(offusTransaction.getIsoReq()));
				byte[] response = reversalReq(offusTransaction.getIsoReq());
				if (response != null) {
					MessageParser messageParser = new MessageParser();
					String[] rsp = messageParser.parseAEPSMsg(response, "transaction");
					saveOFFUSReversalResponse(response, offusTransaction, rsp);
					out.setResponseCode(rsp[39]);
					out.setReversalFlag("R");
				} else {
					out.setResponseCode("91");
				}
			} else if (offusTransaction.getResresponseCode().equals("00")) {
				out.setResponseCode(offusTransaction.getResresponseCode());
				out.setCustomerAvailableBalance(offusTransaction.getBalance());
				out.setAuthCode(offusTransaction.getAuthCode());
				// String custuid = respnseMessage[2].substring(7);
				// out.setUidNo(custuid);
				out.setTerminalID(offusTransaction.getTerminalID());
				String agentID = offusTransaction.getAgentsInformation().substring(0, 8);
				out.setAgentID(agentID);
				out.setStan(offusTransaction.getStan());
				out.setRrnNo(offusTransaction.getRrnNo());
				if (offusTransaction.getProcessingCode().equals("210000")
						|| offusTransaction.getProcessingCode().equals("010000")
						|| offusTransaction.getProcessingCode().equals("400000")) {
					String ta = offusTransaction.getTransactionAmount();
					// String ss = ta.substring(0, ta.length() - 2);
					out.setTransactionAmount(removeLeadingZeroes(ta) + ".00");
				}
				out.setTimestamp(offusTransaction.getTransactionDateTime());
				// if (onusTransaction.getProcessingCode().equals("400000")) {
				// String beneficiaryAccNo =
				// respnseMessage[120].substring(respnseMessage[120].length() -
				// 12);
				// out.setBeneficiaryAccNo(beneficiaryAccNo);
				// }
			} else {
				out.setResponseCode(offusTransaction.getResresponseCode());
				out.setAuthCode(offusTransaction.getAuthCode());
				// String custuid = respnseMessage[2].substring(7);
				// out.setUidNo(custuid);
				out.setTerminalID(offusTransaction.getTerminalID());
				String agentID = offusTransaction.getAgentsInformation().substring(0, 8);
				out.setAgentID(agentID);
				out.setStan(offusTransaction.getStan());
				out.setRrnNo(offusTransaction.getRrnNo());
				// out.setTransactionAmount(respnseMessage[4]);
				// SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy
				// hh:mm:ss");
				// String strDate = formatter.format(date);
				out.setTimestamp(offusTransaction.getTransactionDateTime());
			}
		}
		return out;

	}

	/**
	 * @param response
	 * @param offusTransaction
	 * @param rsp
	 * @return
	 */
	private static void saveOFFUSReversalResponse(byte[] response, OFFUSTransaction offus, String[] rsp) {
		try {
			Connection con = FIConnection.getConnection();
			String squery = "update TRAN_REQRSP_OFFUS set RSPDMP = ?, RSP_DE2 = ?, RSP_DE3 = ?, RSP_DE7 = ?, RSP_DE11 = ?, RSP_DE12 = ?, RSP_DE13 = ?, "
					+ "RSP_DE37 = ?, RSP_DE39 = ?, RSP_DE41 = ?, RSP_DE42 = ?, RSP_DE46 = ?, RSP_DE90 = ?, RSP_DE120 = ? "
					+ "where LOG_ID= ? and TRN_DATE = ?";
			PreparedStatement pstmt = con.prepareStatement(squery);
			pstmt.setBytes(1, response);
			pstmt.setString(2, rsp[2]);
			pstmt.setString(3, rsp[3]);
			pstmt.setString(4, rsp[7]);
			pstmt.setString(5, rsp[11]);
			pstmt.setString(6, rsp[12]);
			pstmt.setString(7, rsp[13]);
			pstmt.setString(8, rsp[37]);
			pstmt.setString(9, rsp[39]);
			pstmt.setString(10, rsp[41]);
			pstmt.setString(11, rsp[42]);
			pstmt.setString(12, rsp[46]);
			pstmt.setString(13, rsp[90]);
			pstmt.setString(14, rsp[120]);
			pstmt.setInt(15, offus.getId());
			pstmt.setDate(16, new java.sql.Date(offus.getCurrentDate().getTime()));
			pstmt.executeUpdate();
			con.setAutoCommit(false);
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param reversalRequest
	 * @param request
	 * @param originalRRN
	 * @return
	 */
	private static OFFUSTransaction saveOFFUSReversalRequest(byte[] request) {

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
			transactionLog.setIsoReq(request);
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
			transactionLog.setReversalReqData(req[90]);
			transactionLog.setVersion(req[100]);
			if (req[3].equals("400000"))
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

	public static TransactionModel_OUT onusReversal(TransactionModel_IN in, TransactionModel_OUT out) {

		Session session = HibernateUtil.getSessionfactory().openSession();
		String hql = "FROM ONUSTransaction O WHERE O.rrnNo =" + in.getRrn();
		Query query = session.createQuery(hql);
		List<ONUSTransaction> list = query.list();
		for (ONUSTransaction onusTransaction : list) {
			if (onusTransaction.getResresponseCode() == null || onusTransaction.getResresponseCode().equals("")) {
				System.out.println("Response Code : " + onusTransaction.getResresponseCode());
				log.info("*******ONUS Start Reversal**********");
				ReversalRequest reversalRequest = new ReversalRequest();
				reversalRequest.setPrimaryAccountNumber(in.getUidNo());
				reversalRequest.setTransactionMode(in.getTransactionMode());
				reversalRequest.setStan(onusTransaction.getStan());
				reversalRequest.setAgentDetails(onusTransaction.getAgentsInformation());
				reversalRequest.setPoshEntryMode(onusTransaction.getPosEntryMode());
				reversalRequest.setVendorCode(onusTransaction.getCardAcceptorID());
				reversalRequest.setTransactionAmount(onusTransaction.getTransactionAmount());
				reversalRequest.setCurrencyCode(onusTransaction.getCurrencyCode());
				reversalRequest.setProcessingCode(onusTransaction.getProcessingCode());
				reversalRequest.setTransactionDateTime(onusTransaction.getTransactionDateTime());
				reversalRequest.setLocalTransactionTime(onusTransaction.getTransactionTime());
				reversalRequest.setLocalTransactionDate(onusTransaction.getTransactionDate());
				reversalRequest.setMerchantType(onusTransaction.getMerchantType());
				reversalRequest.setPoshConditionCode(onusTransaction.getPosConditionCode());
				reversalRequest.setAiic(onusTransaction.getAiic());
				reversalRequest.setRrn(in.getRrn());
				reversalRequest.setTerminalId(FIUtility.rightPaddedValue(onusTransaction.getTerminalID(), 16));
				reversalRequest.setBcDetails(onusTransaction.getCardAcceptorName());
				reversalRequest.setVersion(onusTransaction.getVersion());
				reversalRequest.setDe120(in.getDe120());
				byte[] request = ReversalMessage.getReversalTrans(reversalRequest);
				onusTransaction = saveONUSReversalRequest(request);
				System.out.println(new String(onusTransaction.getIsoReq()));
				byte[] response = reversalReq(onusTransaction.getIsoReq());
				if (response != null) {
					MessageParser messageParser = new MessageParser();
					String[] rsp = messageParser.parseAEPSMsg(response, "transaction");
					saveONUSReversalResponse(response, onusTransaction, rsp);
					out.setResponseCode(rsp[39]);
					out.setReversalFlag("R");
				} else {
					out.setResponseCode("91");
				}
			} else if (onusTransaction.getResresponseCode().equals("00")) {
				out.setResponseCode(onusTransaction.getResresponseCode());
				out.setCustomerAvailableBalance(onusTransaction.getBalance());
				out.setAuthCode(onusTransaction.getAuthCode());
				// String custuid = respnseMessage[2].substring(7);
				// out.setUidNo(custuid);
				out.setTerminalID(onusTransaction.getTerminalID());
				String agentID = onusTransaction.getAgentsInformation().substring(0, 8);
				out.setAgentID(agentID);
				out.setStan(onusTransaction.getStan());
				out.setRrnNo(onusTransaction.getRrnNo());
				if (onusTransaction.getProcessingCode().equals("210000")
						|| onusTransaction.getProcessingCode().equals("010000")
						|| onusTransaction.getProcessingCode().equals("400000")) {
					String ta = onusTransaction.getTransactionAmount();
					// String ss = ta.substring(0, ta.length() - 2);
					out.setTransactionAmount(removeLeadingZeroes(ta) + ".00");
				}
				out.setTimestamp(onusTransaction.getTransactionDateTime());
				// if (onusTransaction.getProcessingCode().equals("400000")) {
				// String beneficiaryAccNo =
				// respnseMessage[120].substring(respnseMessage[120].length() -
				// 12);
				// out.setBeneficiaryAccNo(beneficiaryAccNo);
				// }
			} else {
				out.setResponseCode(onusTransaction.getResresponseCode());
				out.setAuthCode(onusTransaction.getAuthCode());
				// String custuid = respnseMessage[2].substring(7);
				// out.setUidNo(custuid);
				out.setTerminalID(onusTransaction.getTerminalID());
				String agentID = onusTransaction.getAgentsInformation().substring(0, 8);
				out.setAgentID(agentID);
				out.setStan(onusTransaction.getStan());
				out.setRrnNo(onusTransaction.getRrnNo());
				// out.setTransactionAmount(respnseMessage[4]);
				// SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy
				// hh:mm:ss");
				// String strDate = formatter.format(date);
				out.setTimestamp(onusTransaction.getTransactionDateTime());
			}
		}
		return out;

	}

	/**
	 * @param reversalRequest
	 * @param request
	 * @param originalRRN
	 * @return
	 */
	private static ONUSTransaction saveONUSReversalRequest(byte[] request) {

		Session session = HibernateUtil.getSessionfactory().openSession();
		ONUSTransaction transactionLog = new ONUSTransaction();
		try {
			MessageParser messageParser = new MessageParser();
			String[] req = messageParser.parseAEPSMsg(request, "transaction");
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			String date = dateFormat.format(new Date());
			transactionLog.setCurrentDate(dateFormat.parse(date));
			Blob iso = new SerialBlob(request);
			transactionLog.setRequestMsg(iso);
			transactionLog.setIsoReq(request);
			transactionLog.setUidNo(req[2]);
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
			transactionLog.setReversalReqData(req[90]);
			transactionLog.setVersion(req[100]);
			if (req[3].equals("400000"))
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
	 * @param response
	 * @param onusTransaction
	 * @param rsp
	 * @return
	 */
	private static void saveONUSReversalResponse(byte[] response, ONUSTransaction onus, String[] rsp) {
		try {
			Connection con = FIConnection.getConnection();
			String squery = "update TRAN_REQRSP_ONUS set RSPDMP = ?, RSP_DE2 = ?, RSP_DE3 = ?, RSP_DE7 = ?, RSP_DE11 = ?, RSP_DE12 = ?, RSP_DE13 = ?, "
					+ "RSP_DE37 = ?, RSP_DE39 = ?, RSP_DE41 = ?, RSP_DE42 = ?, RSP_DE46 = ?, RSP_DE90 = ?, RSP_DE120 = ? "
					+ "where LOG_ID= ? and TRN_DATE = ?";
			PreparedStatement pstmt = con.prepareStatement(squery);
			pstmt.setBytes(1, response);
			pstmt.setString(2, rsp[2]);
			pstmt.setString(3, rsp[3]);
			pstmt.setString(4, rsp[7]);
			pstmt.setString(5, rsp[11]);
			pstmt.setString(6, rsp[12]);
			pstmt.setString(7, rsp[13]);
			pstmt.setString(8, rsp[37]);
			pstmt.setString(9, rsp[39]);
			pstmt.setString(10, rsp[41]);
			pstmt.setString(11, rsp[42]);
			pstmt.setString(12, rsp[46]);
			pstmt.setString(13, rsp[90]);
			pstmt.setString(14, rsp[120]);
			pstmt.setInt(15, onus.getId());
			pstmt.setDate(16, new java.sql.Date(onus.getCurrentDate().getTime()));
			pstmt.executeUpdate();
			con.setAutoCommit(false);
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param request
	 */
	private static byte[] reversalReq(byte[] request) {
		byte[] reversalByte = null;
		try {
			SSLContextBuilder builder = new SSLContextBuilder();
			builder.loadTrustMaterial(null, new TrustStrategy() {
				@Override
				public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
					System.out.println(chain);
					System.out.println(authType);
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
			String response = EntityUtils.toString(responseEntity, "UTF-8");
			System.out.println("Response from Bank : " + response);
			reversalByte = response.getBytes();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return reversalByte;
	}

	public static void main(String[] args) {
		try {
			File file = new File("E://Test/trn.txt");
			byte[] data = Files.readAllBytes(file.toPath());
			reversalReq(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
