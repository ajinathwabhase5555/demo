/**
 * 
 */
package com.bomweb.transaction.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

/**
 * @author SACHIN
 *
 */
public class Data {
	private String type;
	private String value;
	
	/**
	 * @return the type
	 */
	@XmlAttribute
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the value
	 */
	@XmlValue
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
}
