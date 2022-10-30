/**
 * 
 */
package com.bomweb.offustransaction.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author SACHIN
 *
 */
@XmlRootElement(name = "com.bomweb.transaction.FIGWebReqSvc")
public class TxnReqInfo {
	
	private String currCode;
	private String amount;
	private PartyList partyList;
    private AddDataList addDataList;
    
	/**
	 * @return the currCode
	 */
	@XmlElement(name = "currCode")
	public String getCurrCode() {
		return currCode;
	}

	/**
	 * @param currCode
	 *            the currCode to set
	 */
	public void setCurrCode(String currCode) {
		this.currCode = currCode;
	}

	/**
	 * @return the partyList
	 */
	@XmlElement(name = "PartyList")
	public PartyList getPartyList() {
		return partyList;
	}

	/**
	 * @param partyList
	 *            the partyList to set
	 */
	public void setPartyList(PartyList partyList) {
		this.partyList = partyList;
	}

	/**
	 * @return the amount
	 */
	@XmlElement(name = "amount")
	public String getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	
	@XmlElement(name = "AddDataList")
	public AddDataList getAddDataList() {
		return addDataList;
	}

	/**
	 * @param partyList
	 *            the partyList to set
	 */
	public void setAddDataList(AddDataList addDataList) {
		this.addDataList = addDataList;
	}


}
