/**
 * 
 */
package com.bomweb.insurance;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
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
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.hibernate.Session;

import com.bomweb.model.InsuranceCifEnq;
import com.bomweb.model.InsuranceEnq;
import com.bomweb.model.InsuranceRegistration;
import com.bomweb.service.model.InsuranceIn;
import com.bomweb.service.model.InsuranceOut;
import com.bomweb.util.HibernateUtil;

/**
 * @author SACHIN
 *
 */
public class SocialScheme {

	static Log log = LogFactory.getLog(SocialScheme.class);

	/**
	 * @param insuranceIn
	 * @param scheme_OUT
	 * @return
	 */
	public static InsuranceOut initiateCIFEnquiry(InsuranceIn in, InsuranceOut out) {
		try {
			InsuranceCifEnq cifEnq = saveCIFEnquiryReq(in);
			byte[] response = pushInsurance(cifEnq.getInsuranceReq());
			cifEnq = saveCIFRsp(cifEnq, response);
			out.setResponseCode(cifEnq.getRspCode());
			out.setRrn(cifEnq.getRspRRN());
			out.setResponseDesc(cifEnq.getRspDesc());
			if (cifEnq.getRspCode().equals("00")) {
				out.setAccountList(cifEnq.getAccountList());
			}
		} catch (Exception ex) {
			log.error("****** Exception CIF Enquiry : ", ex);
			out.setResponseCode("EX");
			out.setResponseDesc("Invalid response from FI Gateway");
		}
		return out;
	}

	/**
	 * @param insuranceIn
	 * @param scheme_OUT
	 * @return
	 */
	public static InsuranceOut insuranceEnquiry(InsuranceIn in, InsuranceOut out) {
		try {
			InsuranceEnq insEnq = saveInsuranceEnquiryReq(in);
			byte[] response = pushInsurance(insEnq.getInsuranceReq());
			insEnq = saveEnqResponse(insEnq, response);
			out.setRrn(insEnq.getRspRRN());
			out.setResponseCode(insEnq.getRspCode());
			out.setResponseDesc(insEnq.getRspDesc());
			if (insEnq.getRspCode().equals("00")) {
				out.setCif(insEnq.getCif());
				out.setAddress1(insEnq.getAddress1());
				out.setAddress2(insEnq.getAddress2());
				out.setBranchID(insEnq.getBranchID());
				out.setCity(insEnq.getCity());
				out.setCountry(insEnq.getCountry());
				out.setCustomerName(insEnq.getCustomerName());
				out.setDob(insEnq.getDob());
				out.setEmail(insEnq.getEmail());
				out.setGender(insEnq.getGender());
				out.setMobileNo(insEnq.getMobileNo());
				out.setPan(insEnq.getPanNo());
				out.setUid(insEnq.getUidNo());
			}
		} catch (Exception ex) {
			log.error("****** Exception Insurance Enquiry : ", ex);
			out.setResponseCode("EX");
			out.setResponseDesc("Invalid response from FI Gateway.");
		}
		return out;
	}

	/**
	 * @param insuranceIn
	 * @param scheme_OUT
	 * @return
	 */
	public static InsuranceOut insuranceRequest(InsuranceIn in, InsuranceOut out) {
		try {
			InsuranceRegistration insuranceReg = saveInsuranceRequest(in);
			byte[] response = pushInsurance(insuranceReg.getInsuranceReq());
			insuranceReg = saveRequestResponse(insuranceReg, response);
			out.setRrn(insuranceReg.getRspRRN());
			out.setResponseCode(insuranceReg.getRspCode());
			out.setResponseDesc(insuranceReg.getRspDesc());
			if (insuranceReg.getRspCode().equals("00")) {
				out.setCustomerID(insuranceReg.getCustID());
				out.setDateTime(insuranceReg.getDateTime());
				out.setSchemeEndDate(insuranceReg.getSchemeEndDate());
				out.setSchemeStartDate(insuranceReg.getSchemeStartDate());
				out.setTerminalID(insuranceReg.getTerminalID());
				out.setTransactionDate(insuranceReg.getTransactionDate());
				out.setTransactionID(insuranceReg.getTransactionID());
				out.setTransactionTime(insuranceReg.getTransactionTime());
			}
		} catch (Exception ex) {
			log.error("****** Exception Insurance Req : ", ex);
			out.setResponseCode("EX");
			out.setResponseDesc("Invalid response from FI Gateway.");
		}
		return out;
	}

	/**
	 * @param insuranceReg
	 * @param response
	 * @return
	 */
	private static InsuranceRegistration saveRequestResponse(InsuranceRegistration insuranceReg, byte[] response) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		try {
			File xmlFile = new File("E://BOM/Enrollment/Insurance/InsReqResponse_" + insuranceReg.getRrn() + ".xml");
			if (xmlFile.exists())
				xmlFile.delete();
			xmlFile.createNewFile();
			FileOutputStream fileOutputStream = new FileOutputStream(xmlFile);
			fileOutputStream.write(response);
			fileOutputStream.close();
			JAXBContext context = JAXBContext.newInstance(InsuranceResponse.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			InsuranceResponse responseXML = (InsuranceResponse) unmarshaller
					.unmarshal(new InputStreamReader(new FileInputStream(xmlFile), "ISO-8859-1"));

			Blob rsp = new SerialBlob(response);
			insuranceReg.setResponseMsg(rsp);
			insuranceReg.setRspRRN(responseXML.getSvcHeader().getTxnId());
			insuranceReg.setRspCode(responseXML.getSvcHeader().getRespCode());
			insuranceReg.setRspDesc(responseXML.getSvcHeader().getRespDesc());
			if (responseXML.getSvcHeader().getRespCode().equals("00")) {
				insuranceReg.setCustID(responseXML.getServiceInfo().getSssRegRes().getCustId());
				insuranceReg.setDateTime(responseXML.getTxnInfo().getTxnDateTime());
				insuranceReg.setSchemeEndDate(responseXML.getServiceInfo().getSssRegRes().getSchemeEndDate());
				insuranceReg.setSchemeStartDate(responseXML.getServiceInfo().getSssRegRes().getSchemeStartDate());
				insuranceReg.setTerminalID(responseXML.getServiceInfo().getSssRegRes().getTerminalId());
				insuranceReg.setTransactionDate(responseXML.getServiceInfo().getSssRegRes().getTransactionDate());
				insuranceReg.setTransactionID(responseXML.getServiceInfo().getSssRegRes().getTransactionId());
				insuranceReg.setTransactionTime(responseXML.getServiceInfo().getSssRegRes().getTransactionTime());
			}
			session.beginTransaction();
			session.saveOrUpdate(insuranceReg);
			session.getTransaction().commit();
		} catch (SQLException ex) {
			session.getTransaction().rollback();
			ex.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException exception) {
			exception.printStackTrace();
		}
		return insuranceReg;
	}

	/**
	 * @param insEnq
	 * @param response
	 * @return
	 */
	private static InsuranceEnq saveEnqResponse(InsuranceEnq insEnq, byte[] response) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		String rsps = new String(response).replaceAll("\\P{Print}", " ");
		try {
			File xmlFile = new File("E://BOM/Enrollment/Insurance/InsEnqResponse_" + insEnq.getRrn() + ".xml");
			if (xmlFile.exists())
				xmlFile.delete();
			xmlFile.createNewFile();
			FileOutputStream fileOutputStream = new FileOutputStream(xmlFile);
			fileOutputStream.write(rsps.getBytes());
			fileOutputStream.close();
			JAXBContext context = JAXBContext.newInstance(InsuranceResponse.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			InsuranceResponse responseXML = (InsuranceResponse) unmarshaller
					.unmarshal(new InputStreamReader(new FileInputStream(xmlFile), "ISO-8859-1"));

			Blob rsp = new SerialBlob(response);
			insEnq.setResponseMsg(rsp);
			insEnq.setRspRRN(responseXML.getSvcHeader().getTxnId());
			insEnq.setRspCode(responseXML.getSvcHeader().getRespCode());
			insEnq.setRspDesc(responseXML.getSvcHeader().getRespDesc());
			if (insEnq.getRspCode().equals("00")) {
				insEnq.setCif(responseXML.getServiceInfo().getSssEnqRes().getCif());
				insEnq.setAddress1(responseXML.getServiceInfo().getSssEnqRes().getAddress1());
				insEnq.setAddress2(responseXML.getServiceInfo().getSssEnqRes().getAddress2());
				insEnq.setBranchID(responseXML.getServiceInfo().getSssEnqRes().getBranchId());
				insEnq.setCity(responseXML.getServiceInfo().getSssEnqRes().getCity());
				insEnq.setCountry(responseXML.getServiceInfo().getSssEnqRes().getCountry());
				insEnq.setCustomerName(responseXML.getServiceInfo().getSssEnqRes().getCustomerName());
				insEnq.setDob(responseXML.getServiceInfo().getSssEnqRes().getDob());
				insEnq.setEmail(responseXML.getServiceInfo().getSssEnqRes().getEmail());
				insEnq.setGender(responseXML.getServiceInfo().getSssEnqRes().getGender());
				insEnq.setMobileNo(responseXML.getServiceInfo().getSssEnqRes().getMobileNum());
				insEnq.setPanNo(responseXML.getServiceInfo().getSssEnqRes().getPanNum());
				insEnq.setUidNo(responseXML.getServiceInfo().getSssEnqRes().getUidNum());
			}

			session.beginTransaction();
			session.saveOrUpdate(insEnq);
			session.getTransaction().commit();
		} catch (SQLException ex) {
			session.getTransaction().rollback();
			ex.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException exception) {
			exception.printStackTrace();
		}
		return insEnq;
	}

	/**
	 * @param in
	 * @return
	 */
	private static InsuranceRegistration saveInsuranceRequest(InsuranceIn in) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		InsuranceRegistration insuranceReg = new InsuranceRegistration();
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			String date = dateFormat.format(new Date());
			insuranceReg.setCurrentDate(dateFormat.parse(date));
			Blob iso = new SerialBlob(in.getReqByte());
			insuranceReg.setRequestMsg(iso);
			insuranceReg.setRrn(in.getRrn());
			insuranceReg.setAccountNo(in.getAccountNo());
			insuranceReg.setProcessingCode(in.getProcessingCode());
			insuranceReg.setTransactionDateTime(in.getTransactionDateTime());
			insuranceReg.setTerminalID(in.getTerminalID());
			insuranceReg.setAgentID(in.getAgentID());
			insuranceReg.setInsuranceReq(in.getReqByte());
			insuranceReg.setSchemeCode(in.getSchemeCode());
			insuranceReg.setCustomerName(in.getCustomerName());
			session.beginTransaction();
			session.saveOrUpdate(insuranceReg);
			session.getTransaction().commit();
		} catch (Exception e) {
			log.error(e);
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return insuranceReg;
	}

	/**
	 * @param cifEnq
	 * @param response
	 * @return
	 */
	private static InsuranceCifEnq saveCIFRsp(InsuranceCifEnq cifEnq, byte[] response) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		String rsps = new String(response);
		try {
			if (rsps.startsWith("Y~")) {
				Blob rsp = new SerialBlob(response);
				cifEnq.setResponseMsg(rsp);
				cifEnq.setRspRRN(cifEnq.getRrn());
				cifEnq.setRspCode("IR");
				cifEnq.setRspDesc(rsps);
				session.beginTransaction();
				session.saveOrUpdate(cifEnq);
				session.getTransaction().commit();
			} else {
				try {
					File xmlFile = new File("E://BOM/Enrollment/Insurance/CIFResponse_" + cifEnq.getRrn() + ".xml");
					if (xmlFile.exists())
						xmlFile.delete();
					xmlFile.createNewFile();
					FileOutputStream fileOutputStream = new FileOutputStream(xmlFile);
					fileOutputStream.write(response);
					fileOutputStream.close();
					JAXBContext context = JAXBContext.newInstance(InsuranceResponse.class);
					Unmarshaller unmarshaller = context.createUnmarshaller();
					InsuranceResponse responseXML = (InsuranceResponse) unmarshaller
							.unmarshal(new InputStreamReader(new FileInputStream(xmlFile), "ISO-8859-1"));

					Blob rsp = new SerialBlob(response);
					cifEnq.setResponseMsg(rsp);
					cifEnq.setRspRRN(responseXML.getSvcHeader().getTxnId());
					cifEnq.setRspCode(responseXML.getSvcHeader().getRespCode());
					cifEnq.setRspDesc(responseXML.getSvcHeader().getRespDesc());
					if (responseXML.getSvcHeader().getRespCode().equals("00")) {
						cifEnq.setAccountList(
								responseXML.getServiceInfo().getAccountDetailsRes().getJointAcc().getJoinAccount());
					}
					session.beginTransaction();
					session.saveOrUpdate(cifEnq);
					session.getTransaction().commit();
					xmlFile.delete();
				} catch (SQLException ex) {
					session.getTransaction().rollback();
					ex.printStackTrace();
				} catch (JAXBException e) {
					e.printStackTrace();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			}
		} catch (SQLException ex) {
			session.getTransaction().rollback();
			ex.printStackTrace();
		}
		return cifEnq;
	}

	/**
	 * @param in
	 * @return
	 */
	private static InsuranceCifEnq saveCIFEnquiryReq(InsuranceIn in) {

		Session session = HibernateUtil.getSessionfactory().openSession();
		InsuranceCifEnq cifEnq = new InsuranceCifEnq();
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			String date = dateFormat.format(new Date());
			cifEnq.setCurrentDate(dateFormat.parse(date));
			Blob iso = new SerialBlob(in.getReqByte());
			cifEnq.setRequestMsg(iso);
			cifEnq.setAccountNo(in.getAccountNo());
			cifEnq.setRrn(in.getRrn());
			cifEnq.setProcessingCode(in.getProcessingCode());
			cifEnq.setTransactionDateTime(in.getTransactionDateTime());
			cifEnq.setTerminalID(in.getTerminalID());
			cifEnq.setAgentID(in.getAgentID());
			cifEnq.setInsuranceReq(in.getReqByte());
			session.beginTransaction();
			session.saveOrUpdate(cifEnq);
			session.getTransaction().commit();
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return cifEnq;
	}

	/**
	 * @param in
	 * @return
	 */
	private static InsuranceEnq saveInsuranceEnquiryReq(InsuranceIn in) {

		Session session = HibernateUtil.getSessionfactory().openSession();
		InsuranceEnq insuranceEnq = new InsuranceEnq();
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			String date = dateFormat.format(new Date());
			insuranceEnq.setCurrentDate(dateFormat.parse(date));
			Blob iso = new SerialBlob(in.getReqByte());
			insuranceEnq.setRequestMsg(iso);
			insuranceEnq.setRrn(in.getRrn());
			insuranceEnq.setCif(in.getCifNo());
			insuranceEnq.setAccountNo(in.getAccountNo());
			insuranceEnq.setProcessingCode(in.getProcessingCode());
			insuranceEnq.setTransactionDateTime(in.getTransactionDateTime());
			insuranceEnq.setTerminalID(in.getTerminalID());
			insuranceEnq.setAgentID(in.getAgentID());
			insuranceEnq.setInsuranceReq(in.getReqByte());
			insuranceEnq.setSchemeCode(in.getSchemeCode());
			session.beginTransaction();
			session.saveOrUpdate(insuranceEnq);
			session.getTransaction().commit();
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return insuranceEnq;
	}

	/**
	 * @param sssByte
	 */
	private static byte[] pushInsurance(byte[] sssByte) {

		log.info("*********Insurance Req ********" + new String(sssByte));
		byte[] response = null;
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
					.addBinaryBody("req.txt", sssByte, ContentType.MULTIPART_FORM_DATA, "req.txt").build();
			HttpPost httpPost = new HttpPost("http://125.18.108.188:7003/Servlet/TSPGenericServiceProcessor");
			httpPost.setEntity(entity);
			HttpResponse httpResponse = httpClient.execute(httpPost);

			HttpEntity responseEntity = httpResponse.getEntity();
			int statusCode = httpResponse.getStatusLine().getStatusCode();
			System.out.println("Status Code : " + statusCode);
			if (statusCode == HttpStatus.SC_OK) {
				String rsp = EntityUtils.toString(responseEntity, "UTF-16").replace("??", "");
				System.out.println("*********Response from Bank : *********" + rsp);
				response = rsp.getBytes();
			}
			log.info("-------- End -------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	public static byte[] getFingerArray(String xml) {
		byte[] fingerArray = null;
		try {
			File file = new File("E://Sachin/");
			if (file.isDirectory()) {
				File[] files = file.listFiles(new FilenameFilter() {
					@Override
					public boolean accept(File dir, String xml) {
						return xml.toLowerCase().endsWith(".xml");
					}
				});
				file = files[0];
			}
			if (file.exists()) {
				FileInputStream in = new FileInputStream(file);
				fingerArray = new byte[(int) file.length()];
				in.read(fingerArray);
				in.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fingerArray;
	}

}
