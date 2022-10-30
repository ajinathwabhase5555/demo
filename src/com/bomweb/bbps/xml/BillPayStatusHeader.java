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
@XmlRootElement(name = "com.bomweb.bbps.BillStatusResponse")
public class BillPayStatusHeader {

	private String txnId;
	private String txnOrigin;
	private String tspVdrId;
	private String respCode;
	private String respDesc;

	/**
	 * @return the txnId
	 */
	public String getTxnId() {
		return txnId;
	}

	/**
	 * @param txnId
	 *            the txnId to set
	 */
	@XmlElement(name="txnId")
	public void setTxnId(String txnId) {
		this.txnId = txnId;
	}

	/**
	 * @return the txnOrigin
	 */
	public String getTxnOrigin() {
		return txnOrigin;
	}

	/**
	 * @param txnOrigin
	 *            the txnOrigin to set
	 */
	@XmlElement(name="txnOrigin")
	public void setTxnOrigin(String txnOrigin) {
		this.txnOrigin = txnOrigin;
	}

	/**
	 * @return the tspVdrId
	 */
	public String getTspVdrId() {
		return tspVdrId;
	}

	/**
	 * @param tspVdrId
	 *            the tspVdrId to set
	 */
	@XmlElement(name="tspVdrId")
	public void setTspVdrId(String tspVdrId) {
		this.tspVdrId = tspVdrId;
	}

	/**
	 * @return the respCode
	 */
	public String getRespCode() {
		return respCode;
	}

	/**
	 * @param respCode
	 *            the respCode to set
	 */
	@XmlElement(name="respCode")
	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	/**
	 * @return the respDesc
	 */
	public String getRespDesc() {
		return respDesc;
	}

	/**
	 * @param respDesc
	 *            the respDesc to set
	 */
	@XmlElement(name="respDesc")
	public void setRespDesc(String respDesc) {
		this.respDesc = respDesc;
	}

}
