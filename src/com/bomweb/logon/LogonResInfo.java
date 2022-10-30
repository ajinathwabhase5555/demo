/**
 * 
 */
package com.bomweb.logon;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author SACHIN
 *
 */
@XmlRootElement(name = "com.bomweb.logon.LogonServiceResponse")
public class LogonResInfo {

	private String respcode;
	private String TxnRefNo;

	/**
	 * @return the respcode
	 */
	public String getRespcode() {
		return respcode;
	}

	/**
	 * @param respcode
	 *            the respcode to set
	 */
	@XmlElement(name = "respcode")
	public void setRespcode(String respcode) {
		this.respcode = respcode;
	}

	/**
	 * @return the txnRefNo
	 */
	public String getTxnRefNo() {
		return TxnRefNo;
	}

	/**
	 * @param txnRefNo
	 *            the txnRefNo to set
	 */
	@XmlElement(name = "TxnRefNo")
	public void setTxnRefNo(String txnRefNo) {
		TxnRefNo = txnRefNo;
	}

}
