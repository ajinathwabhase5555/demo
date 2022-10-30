/**
 * 
 */
package com.bomweb.transaction.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author SACHIN
 *
 */
public class PartyInfos {
	private String partyIdTypes;
	private String partyIdValues;
	private String partyOrgs;
	private String types;
	private String categs;

	@XmlElement(name = "partyIdType")
	public String getPartyIdTypes() {
		return partyIdTypes;
	}

	public void setPartyIdTypes(String partyIdTypes) {
		this.partyIdTypes = partyIdTypes;
	}

	@XmlElement(name = "partyIdValue")
	public String getPartyIdValue() {
		return partyIdValues;
	}

	public void setPartyIdValue(String partyIdValues) {
		this.partyIdValues = partyIdValues;
	}

	@XmlElement(name = "partyOrg")
	public String getPartyOrgs() {
		return partyOrgs;
	}

	public void setPartyOrgs(String partyOrgs) {
		this.partyOrgs = partyOrgs;
	}

	@XmlAttribute(name = "type")
	public String getTypes() {
		return types;
	}

	public void setTypes(String types) {
		this.types = types;
	}

	@XmlAttribute(name = "categ")
	public String getCategs() {
		return categs;
	}

	public void setCategs(String categs) {
		this.categs = categs;
	}

}
