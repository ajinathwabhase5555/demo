/**
 * 
 */
package com.bomweb.aadhaarstatus;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author SACHIN
 *
 */
@XmlRootElement(name = "Response_auth")
public class Response {

	private TransactionInfo transactionInfo;
	private AuthRes authRes;

	public TransactionInfo getTransactionInfo() {
		return transactionInfo;
	}

	@XmlElement(name = "TransactionInfo")
	public void setTransactionInfo(TransactionInfo transactionInfo) {
		this.transactionInfo = transactionInfo;
	}

	public AuthRes getAuthRes() {
		return authRes;
	}

	@XmlElement(name = "AuthRes")
	public void setAuthRes(AuthRes authRes) {
		this.authRes = authRes;
	}
}
