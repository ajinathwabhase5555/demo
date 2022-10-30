/**
 * 
 */
package com.bomweb.offustranrevers.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * @author SACHIN
 *
 */
@XmlRootElement(name = "com.bomweb.transaction.FIGWebReqSvc")
public class TxnReqInfo {

	private String currCode;
	private PartyList partyList;
    
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

	

}
