/**
 * 
 */
package com.bomweb.service.model;

/**
 * @author SACHIN
 *
 */
public class NEFTOUT {
	private String responseCode;
	private String responseDesc;
	private String rrn;
	private String journalNo;
	private String authCode;
	private String txnType;
	private String gwrrn;
	private String amount;
	private String beneficiaryName;

	/**
	 * @return the responseCode
	 */
	public String getResponseCode() {
		return responseCode;
	}

	/**
	 * @param responseCode
	 *            the responseCode to set
	 */
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	/**
	 * @return the responseDesc
	 */
	public String getResponseDesc() {
		return responseDesc;
	}

	/**
	 * @param responseDesc
	 *            the responseDesc to set
	 */
	public void setResponseDesc(String responseDesc) {
		this.responseDesc = responseDesc;
	}

	/**
	 * @return the rrn
	 */
	public String getRrn() {
		return rrn;
	}

	/**
	 * @param rrn
	 *            the rrn to set
	 */
	public void setRrn(String rrn) {
		this.rrn = rrn;
	}

	/**
	 * @return the journalNo
	 */
	public String getJournalNo() {
		return journalNo;
	}

	/**
	 * @param journalNo
	 *            the journalNo to set
	 */
	public void setJournalNo(String journalNo) {
		this.journalNo = journalNo;
	}

	/**
	 * @return the authCode
	 */
	public String getAuthCode() {
		return authCode;
	}

	/**
	 * @param authCode
	 *            the authCode to set
	 */
	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	/**
	 * @return the txnType
	 */
	public String getTxnType() {
		return txnType;
	}

	/**
	 * @param txnType
	 *            the txnType to set
	 */
	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}

	/**
	 * @return the gwrrn
	 */
	public String getGwrrn() {
		return gwrrn;
	}

	/**
	 * @param gwrrn
	 *            the gwrrn to set
	 */
	public void setGwrrn(String gwrrn) {
		this.gwrrn = gwrrn;
	}

	/**
	 * @return the amount
	 */
	public String getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}

	/**
	 * @return the beneficiaryName
	 */
	public String getBeneficiaryName() {
		return beneficiaryName;
	}

	/**
	 * @param beneficiaryName
	 *            the beneficiaryName to set
	 */
	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}

}
