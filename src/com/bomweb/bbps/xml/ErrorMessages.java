/**
 * 
 */
package com.bomweb.bbps.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author SACHIN
 *
 */
@XmlRootElement(name = "com.bomweb.bbps.Response")
public class ErrorMessages {

	private String errCode;
	private String errDesc;

	public String getErrCode() {
		return errCode;
	}

	@XmlElement(name="errCode")
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrDesc() {
		return errDesc;
	}

	@XmlElement(name="errDesc")
	public void setErrDesc(String errDesc) {
		this.errDesc = errDesc;
	}
}
