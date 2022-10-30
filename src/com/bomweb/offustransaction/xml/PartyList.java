/**
 * 
 */
package com.bomweb.offustransaction.xml;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author SACHIN
 *
 */
public class PartyList {

	private PartyInfo partyInfo;
	private PartyInfos partyInfos;

	/**
	 * @return the partyInfo
	 */
	@XmlElement(name = "PartyInfo")
	public PartyInfo getPartyInfo() {
		return partyInfo;
	}

	/**
	 * @param partyInfo
	 *            the partyInfo to set
	 */
	public void setPartyInfo(PartyInfo partyInfo) {
		this.partyInfo = partyInfo;
	}

	/**
	 * @return the partyInfos
	 */
	@XmlElement(name = "PartyInfo")
	public PartyInfos getPartyInfos() {
		return partyInfos;
	}

	/**
	 * @param partyInfos
	 *            the partyInfos to set
	 */
	public void setPartyInfos(PartyInfos partyInfos) {
		this.partyInfos = partyInfos;
	}

	

}
