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
@XmlRootElement(name = "AuthRequest")
public class AuthRequest {

	private TransactionInfo transactionInfo;
	private Auth auth;

	/**
	 * @return the transactionInfo
	 */
	@XmlElement(name="TransactionInfo")
	public TransactionInfo getTransactionInfo() {
		return transactionInfo;
	}

	/**
	 * @param transactionInfo
	 *            the transactionInfo to set
	 */
	public void setTransactionInfo(TransactionInfo transactionInfo) {
		this.transactionInfo = transactionInfo;
	}

	/**
	 * @return the auth
	 */
	@XmlElement(name = "Auth")
	public Auth getAuth() {
		return auth;
	}

	/**
	 * @param auth
	 *            the auth to set
	 */
	public void setAuth(Auth auth) {
		this.auth = auth;
	}
}
