/**
 * 
 */
package com.bomweb.chequebook;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author SACHIN
 *
 */
@XmlRootElement(name = "com.bomweb.insurance.InsuranceResponse")
public class SvcHeader {

	private String txnId;
	private String tspVdrId;
	private String respCode;
	private String respDesc;

	public String getTxnId() {
		return txnId;
	}

	@XmlElement(name = "txnId")
	public void setTxnId(String txnId) {
		this.txnId = txnId;
	}

	public String getTspVdrId() {
		return tspVdrId;
	}

	@XmlElement(name = "tspVdrId")
	public void setTspVdrId(String tspVdrId) {
		this.tspVdrId = tspVdrId;
	}

	public String getRespCode() {
		return respCode;
	}

	@XmlElement(name = "respCode")
	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	public String getRespDesc() {
		return respDesc;
	}

	@XmlElement(name = "respDesc")
	public void setRespDesc(String respDesc) {
		this.respDesc = respDesc;
	}
}
