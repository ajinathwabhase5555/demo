/**
 * 
 */
package com.bomweb.aadhaarstatus;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

/**
 * @author SACHIN
 *
 */
public class Skey {

	private String ci;
	private String value;

	/**
	 * @return the ci
	 */
	@XmlAttribute(name="ci")
	public String getCi() {
		return ci;
	}

	/**
	 * @param ci
	 *            the ci to set
	 */
	public void setCi(String ci) {
		this.ci = ci;
	}

	/**
	 * @return the value
	 */
	@XmlValue
	public String getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
}
