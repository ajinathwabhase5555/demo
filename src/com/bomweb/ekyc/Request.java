/**
 * 
 */
package com.bomweb.ekyc;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author Dattu
 *
 */
@XmlRootElement(name = "Request")
public class Request {
	private TransactionInfo transactionInfo;
	private KycReqInfo kycReqInfo;
	
	/**
	 * @return the transactionInfo
	 */
	@XmlElement(name="TransactionInfo")
	public TransactionInfo getTransactionInfo() {
		return transactionInfo;
	}
	/**
	 * @param transactionInfo the transactionInfo to set
	 */
	public void setTransactionInfo(TransactionInfo transactionInfo) {
		this.transactionInfo = transactionInfo;
	}
	/**
	 * @return the kycReqInfo
	 */
	@XmlElement(name="KycReqInfo")
	public KycReqInfo getKycReqInfo() {
		return kycReqInfo;
	}
	/**
	 * @param kycReqInfo the kycReqInfo to set
	 */
	public void setKycReqInfo(KycReqInfo kycReqInfo) {
		this.kycReqInfo = kycReqInfo;
	}
	
	
	
	
}
