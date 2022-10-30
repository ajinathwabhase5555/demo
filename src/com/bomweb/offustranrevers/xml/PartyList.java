/**
 * 
 */
package com.bomweb.offustranrevers.xml;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author SACHIN
 *
 */
public class PartyList {

	private PartyInfo partyInfo;

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


}
