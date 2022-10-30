package com.bomweb.ekyc;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "KycRes")
public class EKYCResponseXML {

	private  UidData uidData;

	public UidData getUidData() {
		return uidData;
	}

	@XmlElement(name="UidData")
	public void setUidData(UidData uidData) {
		this.uidData = uidData;
	}
}
