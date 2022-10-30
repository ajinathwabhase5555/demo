/**
 * 
 */
package com.bomweb.transaction.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author SACHIN
 *
 */
@XmlRootElement(name = "com.bomweb.transaction.xml.FIGWebReqSvc")
public class TxnResInfo {
	private String journalNo;
	private String authCode;
	private Custom custom;
	private String amount;
	private PartyList partyList;

	/**
	 * @return the partyList
	 */
	public PartyList getPartyList() {
		return partyList;
	}

	/**
	 * @param partyList
	 *            the partyList to set
	 */
	@XmlElement(name = "ChequeDetails")
	public void setPartyList(PartyList partyList) {
		this.partyList = partyList;
	}

	/**
	 * @return the amount
	 */
	public String getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	@XmlElement(name = "amount")
	public void setAmount(String amount) {
		this.amount = amount;
	}

	/**
	 * @return the journalNo
	 */
	public String getJournalNo() {
		return journalNo;
	}

	/**
	 * @param journalNo the journalNo to set
	 */
	@XmlElement(name = "journalNo")
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
	 * @param authCode the authCode to set
	 */
	@XmlElement(name = "authCode")
	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	/**
	 * @return the custom
	 */
	public Custom getCustom() {
		return custom;
	}

	/**
	 * @param custom the custom to set
	 */
	@XmlElement(name = "Custom")
	public void setCustom(Custom custom) {
		this.custom = custom;
	}

	
}
