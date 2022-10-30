/**
 * 
 */
package com.bomweb.insurance;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author SACHIN
 *
 */
@XmlRootElement(name = "com.bomweb.insurance.InsuranceResponse")
public class PartyInfo {

	private String partyIdType;
	private String partyIdValue;
	private String partyOrg;

	public String getPartyIdType() {
		return partyIdType;
	}

	@XmlElement(name="partyIdType")
	public void setPartyIdType(String partyIdType) {
		this.partyIdType = partyIdType;
	}

	public String getPartyIdValue() {
		return partyIdValue;
	}

	@XmlElement(name="partyIdValue")
	public void setPartyIdValue(String partyIdValue) {
		this.partyIdValue = partyIdValue;
	}

	public String getPartyOrg() {
		return partyOrg;
	}

	@XmlElement(name="partyOrg")
	public void setPartyOrg(String partyOrg) {
		this.partyOrg = partyOrg;
	}

}
