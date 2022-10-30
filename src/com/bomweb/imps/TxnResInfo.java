/**
 * 
 */
package com.bomweb.imps;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author SACHIN
 *
 */
public class TxnResInfo {
	private String journalNo;
	private String authCode;
	private String txnType;
	private String gwrrn;
	private String amount;
	private String beneficiaryName;

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
	@XmlElement
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
	@XmlElement
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
	@XmlElement
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
	@XmlElement
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
	@XmlElement
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
	@XmlElement
	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}

}
