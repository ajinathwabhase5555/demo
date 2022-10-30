/**
 * 
 */
package com.bomweb.transaction.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author SACHIN
 *
 */
@XmlRootElement(name = "FIGWebReqSvc")
public class FIGWebReqSvc {

	private SvcHeader svcHeader;
	private TxnInfo txnInfo;
	private AuthInfo authInfo;
	private ServiceInfo serviceInfo;

	/**
	 * @return the svcHeader
	 */
	@XmlElement(name="SvcHeader")
	public SvcHeader getSvcHeader() {
		return svcHeader;
	}

	/**
	 * @param svcHeader
	 *            the svcHeader to set
	 */
	public void setSvcHeader(SvcHeader svcHeader) {
		this.svcHeader = svcHeader;
	}

	/**
	 * @return the txnInfo
	 */
	@XmlElement(name="TxnInfo")
	public TxnInfo getTxnInfo() {
		return txnInfo;
	}

	/**
	 * @param txnInfo
	 *            the txnInfo to set
	 */
	public void setTxnInfo(TxnInfo txnInfo) {
		this.txnInfo = txnInfo;
	}

	/**
	 * @return the authInfo
	 */
	@XmlElement(name="AuthInfo")
	public AuthInfo getAuthInfo() {
		return authInfo;
	}

	/**
	 * @param authInfo
	 *            the authInfo to set
	 */
	public void setAuthInfo(AuthInfo authInfo) {
		this.authInfo = authInfo;
	}

	/**
	 * @return the serviceInfo
	 */
	@XmlElement(name="ServiceInfo")
	public ServiceInfo getServiceInfo() {
		return serviceInfo;
	}

	/**
	 * @param serviceInfo
	 *            the serviceInfo to set
	 */
	public void setServiceInfo(ServiceInfo serviceInfo) {
		this.serviceInfo = serviceInfo;
	}

}
