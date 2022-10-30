/**
 * 
 */
package com.bomweb.offustranrevers.xml;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * @author SACHIN
 *
 */
@XmlRootElement(name = "com.bomweb.transaction.FIGWebReqSvc")
public class PartyInfo {

	private String partyIdType;
	private String partyIdValue;
	private String partyOrg;
	private String type;
	private String categ;

	@XmlElement(name = "partyIdType")
	public String getPartyIdType() {
		return partyIdType;
	}

	public void setPartyIdType(String partyIdType) {
		this.partyIdType = partyIdType;
	}

	@XmlElement(name = "partyIdValue")
	public String getPartyIdValue() {
		return partyIdValue;
	}

	public void setPartyIdValue(String partyIdValue) {
		this.partyIdValue = partyIdValue;
	}

	@XmlElement(name = "partyOrg")
	public String getPartyOrg() {
		return partyOrg;
	}

	public void setPartyOrg(String partyOrg) {
		this.partyOrg = partyOrg;
	}

	@XmlAttribute(name = "type")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@XmlAttribute(name = "categ")
	public String getCateg() {
		return categ;
	}

	public void setCateg(String categ) {
		this.categ = categ;
	}


}
