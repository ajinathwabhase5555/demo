/**
 * 
 */
package com.bomweb.insurance;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author SACHIN
 *
 */
@XmlRootElement(name = "com.bomweb.insurance.QueryAccountDetailsRes")
public class EligibleCriteria {

	private String custType;
	private String panNumber;
	private String form60Flag;
	private String form61Flag;
	private String occupationCode;

	public String getCustType() {
		return custType;
	}

	@XmlElement(name="custType")
	public void setCustType(String custType) {
		this.custType = custType;
	}

	public String getPanNumber() {
		return panNumber;
	}

	@XmlElement(name="panNumber")
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getForm60Flag() {
		return form60Flag;
	}

	@XmlElement(name="form60Flag")
	public void setForm60Flag(String form60Flag) {
		this.form60Flag = form60Flag;
	}

	public String getForm61Flag() {
		return form61Flag;
	}

	@XmlElement(name="form61Flag")
	public void setForm61Flag(String form61Flag) {
		this.form61Flag = form61Flag;
	}

	public String getOccupationCode() {
		return occupationCode;
	}

	@XmlElement(name="occupationCode")
	public void setOccupationCode(String occupationCode) {
		this.occupationCode = occupationCode;
	}
}
