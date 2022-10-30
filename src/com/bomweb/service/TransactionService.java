package com.bomweb.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.bomweb.service.model.AADHAARSTATUSIN;
import com.bomweb.service.model.AADHAARSTATUSOUT;
import com.bomweb.service.model.BBPSIN;
import com.bomweb.service.model.BBPSOUT;
import com.bomweb.service.model.CHEQUEBOOKIN;
import com.bomweb.service.model.CHEQUEBOOKOUT;
import com.bomweb.service.model.EKYC_IN;
import com.bomweb.service.model.EKycRequest;
import com.bomweb.service.model.EKycResponse;
import com.bomweb.service.model.IMPSIN;
import com.bomweb.service.model.IMPSOUT;
import com.bomweb.service.model.InsuranceIn;
import com.bomweb.service.model.InsuranceOut;
import com.bomweb.service.model.LOGONIN;
import com.bomweb.service.model.LOGONOUT;
import com.bomweb.service.model.NEFTIN;
import com.bomweb.service.model.NEFTOUT;
import com.bomweb.service.model.PushEnrollment_IN;
import com.bomweb.service.model.PushEnrollment_OUT;
import com.bomweb.service.model.RupayIn;
import com.bomweb.service.model.RupayOut;
import com.bomweb.service.model.TransactionModel_IN;
import com.bomweb.service.model.TransactionModel_OUT;
import com.bomweb.service.model.Transaction_IN;
import com.bomweb.service.model.Transaction_OUT;
import com.bomweb.service.model.Transactionoffus_IN;
import com.bomweb.service.model.Transactionoffus_OUT;

@WebService
public class TransactionService {

	@WebMethod
	public TransactionModel_OUT transactions(TransactionModel_IN transactionModel) {
		TransactionServiceImpl bomservice = new TransactionServiceImpl();
		return bomservice.transactions(transactionModel);
	}

	@WebMethod
	public EKycResponse sendEkycRequest(EKYC_IN eKycRequest) {
		TransactionServiceImpl bomservice = new TransactionServiceImpl();
		return bomservice.sendEkycRequest(eKycRequest);
	}

	@WebMethod
	public PushEnrollment_OUT pushEnrollmentFile(PushEnrollment_IN enrollment_IN) {
		TransactionServiceImpl bomservice = new TransactionServiceImpl();
		return bomservice.pushEnrollment(enrollment_IN);
	}

	@WebMethod
	public TransactionModel_OUT initiateReversals(TransactionModel_IN in) {
		TransactionServiceImpl bomservice = new TransactionServiceImpl();
		return bomservice.initiateReversals(in);
	}

	@WebMethod
	public InsuranceOut cifEnquiry(InsuranceIn in) {
		TransactionServiceImpl bomservice = new TransactionServiceImpl();
		return bomservice.cifEnquiry(in);
	}

	@WebMethod
	public InsuranceOut insuranceEnquiry(InsuranceIn in) {
		TransactionServiceImpl bomservice = new TransactionServiceImpl();
		return bomservice.insuranceEnquiry(in);
	}

	@WebMethod
	public InsuranceOut insuranceRequest(InsuranceIn in) {
		TransactionServiceImpl bomservice = new TransactionServiceImpl();
		return bomservice.insuranceRequest(in);
	}

	@WebMethod
	public RupayOut rupayRequest(RupayIn in) {
		TransactionServiceImpl bomservice = new TransactionServiceImpl();
		return bomservice.rupayRequest(in);
	}

	@WebMethod
	public RupayOut rupayReversal(RupayIn in) {
		TransactionServiceImpl bomservice = new TransactionServiceImpl();
		return bomservice.rupayReversal(in);
	}

	@WebMethod
	public BBPSOUT fetchBill(BBPSIN in) {
		TransactionServiceImpl bomservice = new TransactionServiceImpl();
		return bomservice.fetchBill(in);
	}

	@WebMethod
	public BBPSOUT payBill(BBPSIN in) {
		TransactionServiceImpl bomservice = new TransactionServiceImpl();
		return bomservice.payBill(in);
	}

	@WebMethod
	public BBPSOUT checkPaymentStatus(BBPSIN in) {
		TransactionServiceImpl bomservice = new TransactionServiceImpl();
		return bomservice.checkPaymentStatus(in);
	}

	@WebMethod
	public AADHAARSTATUSOUT checkAadhaarStatus(AADHAARSTATUSIN in) {
		TransactionServiceImpl bomservice = new TransactionServiceImpl();
		return bomservice.checkAadhaarStatus(in);
	}

	@WebMethod
	public CHEQUEBOOKOUT chequeBookService(CHEQUEBOOKIN in) {
		TransactionServiceImpl bomservice = new TransactionServiceImpl();
		return bomservice.chequeBookService(in);
	}

	@WebMethod
	public IMPSOUT impsTransaction(IMPSIN in) {
		TransactionServiceImpl bomservice = new TransactionServiceImpl();
		return bomservice.impsTransaction(in);
	}

	@WebMethod
	public LOGONOUT logonService(LOGONIN in) {
		TransactionServiceImpl bomservice = new TransactionServiceImpl();
		return bomservice.logonService(in);
	}

	@WebMethod
	public TransactionModel_OUT cdaRequest(String rrn, String uid) {
		TransactionServiceImpl bomservice = new TransactionServiceImpl();
		return bomservice.cdaRequest(rrn, uid);
	}

	@WebMethod
	public TransactionModel_OUT verifyBAVRequest(String rrn, String uid) {
		TransactionServiceImpl bomservice = new TransactionServiceImpl();
		return bomservice.verifyBAVRequest(rrn, uid);
	}
	
	@WebMethod
	public NEFTOUT neftTransaction(NEFTIN in) {
		TransactionServiceImpl bomservice = new TransactionServiceImpl();
		return bomservice.neftTransaction(in);
	}
	
	@WebMethod
	public Transaction_OUT onusTransaction(Transaction_IN in) {
		TransactionServiceImpl bomservice = new TransactionServiceImpl();
		return bomservice.onusTransaction(in);
	}
	
	@WebMethod
	public Transactionoffus_OUT offusTransaction(Transactionoffus_IN in) {
		TransactionServiceImpl bomservice = new TransactionServiceImpl();
		return bomservice.offusTransaction(in);
	}
	
	@WebMethod
	public Transactionoffus_OUT initiateReversal(Transactionoffus_IN in) {
		TransactionServiceImpl bomservice = new TransactionServiceImpl();
		return bomservice.initiateOffusRever(in);
	}
}
