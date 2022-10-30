package com.bomweb.service;

import java.net.SocketTimeoutException;

import com.bomweb.OFFUSCDABAVTransaction;
import com.bomweb.Transaction;
import com.bomweb.aadhaarstatus.AadhaarStatus;
import com.bomweb.bbps.BBPSService;
import com.bomweb.chequebook.ChequeBookRequest;
import com.bomweb.ekyc.EKycManager;
import com.bomweb.ekyc.EKycManagerXml;
import com.bomweb.ekyc.FileUpload;
import com.bomweb.imps.ImpsTransaction;
import com.bomweb.insurance.SocialScheme;
import com.bomweb.logon.LogonServices;
import com.bomweb.neft.NeftTransaction;
import com.bomweb.rupay.RupayCard;
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
import com.bomweb.transaction.OFFUSReverTransaction;
import com.bomweb.transaction.OFFUSTransaction;
import com.bomweb.transaction.ONUSTransaction;

public class TransactionServiceImpl<EKycManagerXML> {

	public TransactionModel_OUT transactions(TransactionModel_IN in) {
		TransactionModel_OUT out = new TransactionModel_OUT();
		out = Transaction.initiateTransaction(in, out);
		return out;
	}

	public EKycResponse sendEkycRequest(EKYC_IN eKycRequest) {
		EKycResponse eKycResponse = new EKycResponse();
		EKycManagerXml eKycManager = new EKycManagerXml();
		try {
			eKycResponse = eKycManager.sendEKycRequest(eKycRequest);
		} catch (SocketTimeoutException socketTimeoutException) {
			System.err.println(socketTimeoutException.getMessage());
		} catch (Exception exception) {
			System.err.println(exception.getMessage());
		}
		return eKycResponse;
	}

	public PushEnrollment_OUT pushEnrollment(PushEnrollment_IN enrollment_IN) {
		PushEnrollment_OUT out = FileUpload.pushEnrollment(enrollment_IN);
		return out;
	}

	public TransactionModel_OUT initiateReversals(TransactionModel_IN in) {
		TransactionModel_OUT out = new TransactionModel_OUT();
		out = Transaction.reversal(in, out);
		return out;
	}

	public InsuranceOut cifEnquiry(InsuranceIn in) {
		InsuranceOut scheme_OUT = new InsuranceOut();
		scheme_OUT = SocialScheme.initiateCIFEnquiry(in, scheme_OUT);
		return scheme_OUT;
	}

	/**
	 * @param insuranceEnq
	 * @return
	 */
	public InsuranceOut insuranceEnquiry(InsuranceIn in) {
		InsuranceOut scheme_OUT = new InsuranceOut();
		scheme_OUT = SocialScheme.insuranceEnquiry(in, scheme_OUT);
		return scheme_OUT;
	}

	/**
	 * @param insuranceReq
	 * @return
	 */
	public InsuranceOut insuranceRequest(InsuranceIn in) {
		InsuranceOut scheme_OUT = new InsuranceOut();
		scheme_OUT = SocialScheme.insuranceRequest(in, scheme_OUT);
		return scheme_OUT;
	}

	/**
	 * @param in
	 * @return
	 */
	public RupayOut rupayRequest(RupayIn in) {
		RupayOut out = new RupayOut();
		out = RupayCard.rupayTransactionRequest(in, out);
		return out;
	}

	/**
	 * @param in
	 * @return
	 */
	public RupayOut rupayReversal(RupayIn in) {
		RupayOut out = new RupayOut();
		out = RupayCard.rupayReversalRequest(in, out);
		return out;
	}

	/**
	 * @param in
	 * @return
	 */
	public BBPSOUT fetchBill(BBPSIN in) {
		BBPSOUT out = new BBPSOUT();
		out = BBPSService.fetchBillRequest(in, out);
		return out;
	}

	/**
	 * @param in
	 * @return
	 */
	public BBPSOUT payBill(BBPSIN in) {
		BBPSOUT out = new BBPSOUT();
		out = BBPSService.payBillRequest(in, out);
		return out;
	}

	/**
	 * @param in
	 * @return
	 */
	public BBPSOUT checkPaymentStatus(BBPSIN in) {
		BBPSOUT out = new BBPSOUT();
		out = BBPSService.checkBillStatus(in, out);
		return out;
	}

	/**
	 * @param in
	 * @return
	 */
	public AADHAARSTATUSOUT checkAadhaarStatus(AADHAARSTATUSIN in) {
		AADHAARSTATUSOUT out = new AADHAARSTATUSOUT();
		out = AadhaarStatus.aadhaarLinkStatus(in, out);
		return out;
	}

	/**
	 * @param in
	 * @return
	 */
	public CHEQUEBOOKOUT chequeBookService(CHEQUEBOOKIN in) {
		CHEQUEBOOKOUT out = new CHEQUEBOOKOUT();
		out = ChequeBookRequest.chequeBookService(in, out);
		return out;
	}

	/**
	 * @param in
	 * @return
	 */
	public IMPSOUT impsTransaction(IMPSIN in) {
		IMPSOUT out = new IMPSOUT();
		out = ImpsTransaction.impsTransaction(in, out);
		return out;
	}

	/**
	 * @param in
	 * @return
	 */
	public LOGONOUT logonService(LOGONIN in) {
		LOGONOUT out = new LOGONOUT();
		out = LogonServices.logonService(in, out);
		return out;
	}

	/**
	 * @param rrn
	 * @return
	 */
	public TransactionModel_OUT cdaRequest(String rrn, String uid) {
		TransactionModel_OUT out = new TransactionModel_OUT();
		out = OFFUSCDABAVTransaction.cdaRequest(rrn, uid, out);
		return out;
	}

	/**
	 * @param rrn
	 * @return
	 */
	public TransactionModel_OUT verifyBAVRequest(String rrn, String uid) {
		TransactionModel_OUT out = new TransactionModel_OUT();
		out = OFFUSCDABAVTransaction.verifyBAVRequest(rrn, uid, out);
		return out;
	}

	/**
	 * @param in
	 * @return
	 */
	public NEFTOUT neftTransaction(NEFTIN in) {
		NEFTOUT out = new NEFTOUT();
		out = NeftTransaction.neftTransaction(in, out);
		return out;
	}

	/**
	 * @param in
	 * @return
	 */
	public Transaction_OUT onusTransaction(Transaction_IN in) {
		Transaction_OUT out = new Transaction_OUT();
		out = ONUSTransaction.onusTransaction(in);
		return out;
	}
	/**
	 * @param in
	 * @return
	 */
	public Transactionoffus_OUT offusTransaction(Transactionoffus_IN in) {
		Transactionoffus_OUT out = new Transactionoffus_OUT();
		out = OFFUSTransaction.offusTransaction(in);
		return out;
	}

	/**
	 * @param in
	 * @return
	 */
	public Transactionoffus_OUT initiateOffusRever(Transactionoffus_IN in) {
		Transactionoffus_OUT out = new Transactionoffus_OUT();
		out = OFFUSReverTransaction.initiateOffusRever(in);
		return out;
	}

	

}
