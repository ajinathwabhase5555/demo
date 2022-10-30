/**
 * 
 */
package com.bomweb.ekyc;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.sql.rowset.serial.SerialBlob;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;

import com.bomweb.encryption.DESEncryptUtil;
import com.bomweb.model.CustomerEnrollment;
import com.bomweb.service.model.PushEnrollment_IN;
import com.bomweb.service.model.PushEnrollment_OUT;
import com.bomweb.util.Globals;
import com.bomweb.util.HibernateUtil;
import com.bomweb.util.UploadEnrollment;

/**
 * @author SACHIN
 *
 */
public class FileUpload {

	static Log log = LogFactory.getLog(FileUpload.class);

	public static PushEnrollment_OUT pushEnrollment(PushEnrollment_IN in) {
		PushEnrollment_OUT out = new PushEnrollment_OUT();
		try {
			log.info("********Enrollment File********* " + in.getRrn());
			CustomerEnrollment enrollment = saveEnrollData(in);
			File inFile = new File(Globals.ENROLLMENT_DIR + "/" + in.getRrn() + ".txt");
			File outFile = new File(Globals.ENROLLMENT_ENCRYPTED + "/" + in.getRrn() + ".txt");
			byte[] custFile = in.getFile();
			FileOutputStream outputStream = new FileOutputStream(inFile);
			outputStream.write(custFile);
			outputStream.close();
			DESEncryptUtil.encrypt(inFile, outFile);
			String response = UploadEnrollment.uploadEnrollFileToServer(outFile, in);
			saveResponse(enrollment, response);
			out.setResponse(response);
//			if (inFile.exists())
//				inFile.delete();
//			if (outFile.exists())
//				outFile.delete();
		} catch (Exception e) {
			e.printStackTrace();
			out.setResponse("EX~INVALID RESPONSE");
		}
		return out;
	}

	/**
	 * @param enrollment
	 * @param response
	 */
	private static void saveResponse(CustomerEnrollment enrollment, String response) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		try {
			int id = enrollment.getId();
			CustomerEnrollment customerEnrollment = (CustomerEnrollment) session.load(CustomerEnrollment.class, id);
			customerEnrollment.setResponse(response);
			session.beginTransaction();
			session.saveOrUpdate(customerEnrollment);
			session.getTransaction().commit();
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	/**
	 * @param in
	 * @return
	 */
	private static CustomerEnrollment saveEnrollData(PushEnrollment_IN in) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		CustomerEnrollment enrollment = new CustomerEnrollment();
		try {
			Blob blob = new SerialBlob(in.getFile());
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			String date = dateFormat.format(new Date());
			enrollment.setCurrentDate(dateFormat.parse(date));
			enrollment.setAgentID(in.getAgentID());
			enrollment.setEkycFlag(in.geteKYCFlag());
			enrollment.setRrn(in.getRrn());
			enrollment.setTerminalID(in.getTerminalID());
			enrollment.setEnrollmentFile(blob);
			enrollment.setCustomerName(in.getCustomerName());
			session.beginTransaction();
			session.saveOrUpdate(enrollment);
			session.getTransaction().commit();
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return enrollment;
	}
	
	public static void main(String[] args) {
		DESEncryptUtil.hex2byte("0000000000000000");//21111101
		PushEnrollment_IN in = new PushEnrollment_IN();
		in.setAgentID("18880001");
		in.seteKYCFlag("Y");
		in.setRrn("824017885584");
		in.setTerminalID("000001888");
		in.setVendorID("888");
		pushEnrollment(in);
	}
}
