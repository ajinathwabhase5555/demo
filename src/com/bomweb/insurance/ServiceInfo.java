/**
 * 
 */
package com.bomweb.insurance;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author SACHIN
 *
 */
@XmlRootElement(name = "com.bomweb.insurance.InsuranceResponse")
public class ServiceInfo {
	private QueryAccountDetailsRes accountDetailsRes;
	private SSSEnqRes sssEnqRes;
	private SSSRegRes sssRegRes;

	public QueryAccountDetailsRes getAccountDetailsRes() {
		return accountDetailsRes;
	}

	@XmlElement(name = "QueryAccountDetailsRes")
	public void setAccountDetailsRes(QueryAccountDetailsRes accountDetailsRes) {
		this.accountDetailsRes = accountDetailsRes;
	}

	public SSSEnqRes getSssEnqRes() {
		return sssEnqRes;
	}

	@XmlElement(name = "SSSEnqRes")
	public void setSssEnqRes(SSSEnqRes sssEnqRes) {
		this.sssEnqRes = sssEnqRes;
	}

	public SSSRegRes getSssRegRes() {
		return sssRegRes;
	}

	@XmlElement(name = "SSSRegRes")
	public void setSssRegRes(SSSRegRes sssRegRes) {
		this.sssRegRes = sssRegRes;
	}

}
