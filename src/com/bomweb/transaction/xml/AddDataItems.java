/**
 * 
 */
package com.bomweb.transaction.xml;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * @author SACHIN
 *
 */
public class AddDataItems {
	private String names;
	private String values;

	@XmlAttribute(name = "name")
	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	@XmlAttribute(name = "value")
	public String getValues() {
		return values;
	}
	public void setValues(String values) {
		this.values = values;
	}

}
