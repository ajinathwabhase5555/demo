package com.bomweb.transaction.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "com.bomweb.transaction.xml.FIGWebReqSvc")
public class Details {
	private String name;
	private String value;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	@XmlAttribute(name="name")
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	@XmlAttribute(name="value")
	public void setValue(String value) {
		this.value = value;
	}

}
