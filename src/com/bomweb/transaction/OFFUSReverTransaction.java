/**
 * 
 */
package com.bomweb.transaction;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.sql.Blob;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.sql.rowset.serial.SerialBlob;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.hibernate.Session;

import com.bomweb.model.OFFUSTransactionXML;
import com.bomweb.offustranrevers.xml.ISOReverXML;
import com.bomweb.service.model.Transactionoffus_IN;
import com.bomweb.service.model.Transactionoffus_OUT;
import com.bomweb.transaction.xml.FIGWebResSvc;
import com.bomweb.util.HibernateUtil;

/**
 * @author SACHIN
 *
 */
public class OFFUSReverTransaction {

	static Log log = LogFactory.getLog(OFFUSTransaction.class);
	

	/**
	 * @param in
	 * @return
	 */
	public static Transactionoffus_OUT initiateOffusRever(Transactionoffus_IN in) {
		Transactionoffus_OUT out = new Transactionoffus_OUT();
		byte[] trnReq = ISOReverXML.createXML(in);
		
		OFFUSTransactionXML tranReq = saveOffusreversRequest(trnReq, in);
		byte[] response = postTransaction(tranReq.getTranReq());
		try {
			if (response != null && response.length > 0) {
				tranReq = saveOffusreversResponse(tranReq, response);
				out.setResponseCode(tranReq.getRSP_respCode());
				out.setResponseMsg(tranReq.getRSP_respDesc());
				if (tranReq.getRSP_respCode().equals("00")) {
					out.setCustomerAvailableBalance(tranReq.getRSP_actualBalance());
					out.setAuthCode(tranReq.getRSP_authCode());
					out.setJournalNo(tranReq.getRSP_journalNo());
				}
			} else {
				out.setResponseCode("91");
				out.setResponseMsg("No response from Gateway..!!");
			}
		} catch (Exception e) {
			log.info("Aadhaar Link Status: " + e.getMessage());
			out.setResponseCode("91");
			out.setResponseMsg("No response from Gateway..!!");
		}
		return out;
	}


	private static OFFUSTransactionXML saveOffusreversRequest(byte[] trnReq, Transactionoffus_IN in) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		OFFUSTransactionXML transactionXML = new OFFUSTransactionXML();
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			String date = dateFormat.format(new Date());
			transactionXML.setCurrentDate(dateFormat.parse(date));
			Blob iso = new SerialBlob(trnReq);
			transactionXML.setRequestMsg(iso);
			transactionXML.setTranReq(trnReq);
			transactionXML.setREQ_txnId(in.getRrn());
			transactionXML.setREQ_tspVdrId("88");
			transactionXML.setREQ_txnOrigin("OV");
			transactionXML.setREQ_msgFmtVer("1.0");
			transactionXML.setREQ_appVersion("1103");
			transactionXML.setREQ_funcCode("1200");
			transactionXML.setREQ_pan(in.getPan());
			transactionXML.setREQ_procCode(in.getProcessingCode());
			transactionXML.setREQ_txnDateTime(in.getTxnDateTime());
			transactionXML.setREQ_mcc("");
			transactionXML.setREQ_posEntryMode("");
			transactionXML.setREQ_posCode("");
			transactionXML.setREQ_acqId(in.getPan().substring(0, 6));
			transactionXML.setREQ_track2Data("");
			transactionXML.setREQ_rrn(in.getRrn());
			transactionXML.setREQ_terminalId(in.getTerminalId());
			transactionXML.setREQ_caId(in.getCaId());
			transactionXML.setREQ_caLocn("VISIONINDIA            PUNE         MHIN");
			transactionXML.setREQ_terminalData("");
			transactionXML.setREQ_agentId(in.getAgentId());
			transactionXML.setREQ_serviceChrg("");
			transactionXML.setREQ_txnMode(in.getTxnMode());
			transactionXML.setREQ_orgTxnRefId("");
			transactionXML.setREQ_narration(in.getNarration());
			transactionXML.setREQ_txnHmac(in.getTxnHmac());
			transactionXML.setREQ_uniqueNo(in.getRrn().substring(in.getRrn().length() - 6));
			transactionXML.setREQ_expDate("");
			transactionXML.setREQ_setlDate("");
			transactionXML.setREQ_posCaptCode("00");
			transactionXML.setREQ_refSeq("");
			transactionXML.setREQ_currCode("INR");
			transactionXML.setREQ_partyOrg(in.getPan().substring(0, 6));
			transactionXML.setREQ_partyIdType(in.getTxnMode());
			transactionXML.setREQ_partyIdValue(in.getPan().substring(in.getPan().length() - 12));
			if (!in.getProcessingCode().equals("PC0025") || !in.getProcessingCode().equals("PC0103"))
				transactionXML.setREQ_amount(in.getAmount());
			session.beginTransaction();
			session.saveOrUpdate(transactionXML);
			session.getTransaction().commit();
		} catch (Exception e) {
			log.error(e);
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return transactionXML;
	}

	private static OFFUSTransactionXML saveOffusreversResponse(OFFUSTransactionXML tranReq, byte[] response) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		try {
			File xmlFile = new File("E://BOM/Enrollment/offusreverstxn_rsp" + tranReq.getREQ_rrn() + ".xml");
			if (xmlFile.exists())
				xmlFile.delete();
			xmlFile.createNewFile();
			FileOutputStream fileOutputStream = new FileOutputStream(xmlFile);
			fileOutputStream.write(response);
			fileOutputStream.close();
			JAXBContext context = JAXBContext.newInstance(FIGWebResSvc.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			FIGWebResSvc responseXML = (FIGWebResSvc) unmarshaller
					.unmarshal(new InputStreamReader(new FileInputStream(xmlFile), "ISO-8859-1"));

			Blob rsp = new SerialBlob(response);
			tranReq.setResponseMsg(rsp);
			tranReq.setRSP_respCode(responseXML.getSvcHeaderRsp().getRespCode());
			tranReq.setRSP_respDesc(responseXML.getSvcHeaderRsp().getRespDesc());
			if (responseXML.getSvcHeaderRsp().getRespCode().equals("00")) {
				tranReq.setRSP_funcCode(responseXML.getTxnInfoRsp().getFuncCode());
				tranReq.setRSP_pan(responseXML.getTxnInfoRsp().getPan());
				tranReq.setRSP_procCode(responseXML.getTxnInfoRsp().getProcCode());
				tranReq.setRSP_txnDateTime(responseXML.getTxnInfoRsp().getTxnDateTime());
				tranReq.setRSP_rrn(responseXML.getTxnInfoRsp().getRrn());
				tranReq.setRSP_terminalId(responseXML.getTxnInfoRsp().getTerminalId());
				tranReq.setRSP_agentId(responseXML.getTxnInfoRsp().getAgentId());
				tranReq.setRSP_txnMode(responseXML.getTxnInfoRsp().getTxnMode());
				tranReq.setRSP_narration(responseXML.getTxnInfoRsp().getNarration());
				tranReq.setRSP_txnHmac(responseXML.getTxnInfoRsp().getTxnHmac());
				tranReq.setRSP_gatewayRRN(responseXML.getTxnInfoRsp().getGatewayRRN());
				tranReq.setRSP_track2Data(responseXML.getTxnInfoRsp().getTrack2Data());
				tranReq.setRSP_journalNo(responseXML.getServiceInfoRsp().getTxnResInfo().getJournalNo());
				tranReq.setRSP_authCode(responseXML.getServiceInfoRsp().getTxnResInfo().getAuthCode());
				tranReq.setRSP_partyIdType(
						responseXML.getServiceInfoRsp().getTxnResInfo().getPartyList().getPartyInfo().getPartyIdType());
				tranReq.setRSP_partyIdValue(responseXML.getServiceInfoRsp().getTxnResInfo().getPartyList()
						.getPartyInfo().getPartyIdValue());
				tranReq.setRSP_partyOrg(
						responseXML.getServiceInfoRsp().getTxnResInfo().getPartyList().getPartyInfo().getPartyOrg());
				tranReq.setRSP_actualBalance(
						responseXML.getServiceInfoRsp().getTxnResInfo().getCustom().getDetails().getValue());
			}
			session.beginTransaction();
			session.saveOrUpdate(tranReq);
			session.getTransaction().commit();
			// xmlFile.delete();
		} catch (Exception ex) {
			session.getTransaction().rollback();
			ex.printStackTrace();
		}

		return tranReq;
	}

	public static byte[] postTransaction(byte[] dataSrc) {
		byte[] isoresponse = null;
		try {
			SSLContextBuilder builder = new SSLContextBuilder();
			builder.loadTrustMaterial(null, new TrustStrategy() {
				@Override
				public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
					return true;
				}
			});

			@SuppressWarnings("deprecation")
			SSLConnectionSocketFactory sslSF = new SSLConnectionSocketFactory(builder.build(),
					SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);

			HttpClient httpClient = HttpClients.custom().setSSLSocketFactory(sslSF).build();

			HttpEntity entity = MultipartEntityBuilder.create()
					.addBinaryBody("req.txt", dataSrc, ContentType.MULTIPART_FORM_DATA, "req.txt").build();
			HttpPost httpPost = new HttpPost("http://125.18.108.188:7003/Servlet/TSPGenericServiceProcessorXML");
			httpPost.setEntity(entity);
			HttpResponse httpResponse = httpClient.execute(httpPost);

			HttpEntity responseEntity = httpResponse.getEntity();
			int statusCode = httpResponse.getStatusLine().getStatusCode();
			System.out.println("Status Code : " + statusCode);
			if (statusCode == HttpStatus.SC_OK) {
				String rsp = EntityUtils.toString(responseEntity, "UTF-8");
				System.out.println("*********Response from Bank : *********" + rsp);
				isoresponse = rsp.getBytes();
			}
			log.info("-------- End -------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isoresponse;
	}
	

}
