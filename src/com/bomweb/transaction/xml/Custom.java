package com.bomweb.transaction.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "com.bomweb.transaction.xml.FIGWebReqSvc")
public class Custom {
	private Details details;

	/**
	 * @return the details
	 */
	public Details getDetails() {
		return details;
	}

	/**
	 * @param details
	 *            the details to set
	 */
	@XmlElement(name="Details")
	public void setDetails(Details details) {
		this.details = details;
	}

}
