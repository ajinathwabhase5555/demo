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
@XmlRootElement(name = "BillPaymentRes")
public class BBPSPayResponse {

	private BillPayHeader billPayHeader;
	private PayTxnInfo txnInfo;
	private PayResponse response;

	/**
	 * @return the billPayHeader
	 */
	public BillPayHeader getBillPayHeader() {
		return billPayHeader;
	}

	/**
	 * @param billPayHeader
	 *            the billPayHeader to set
	 */
	@XmlElement(name="BillPayHeader")
	public void setBillPayHeader(BillPayHeader billPayHeader) {
		this.billPayHeader = billPayHeader;
	}

	/**
	 * @return the txnInfo
	 */
	public PayTxnInfo getTxnInfo() {
		return txnInfo;
	}

	/**
	 * @param txnInfo
	 *            the txnInfo to set
	 */
	@XmlElement(name="TxnInfo")
	public void setTxnInfo(PayTxnInfo txnInfo) {
		this.txnInfo = txnInfo;
	}

	/**
	 * @return the response
	 */
	public PayResponse getResponse() {
		return response;
	}

	/**
	 * @param response
	 *            the response to set
	 */
	@XmlElement(name="response")
	public void setResponse(PayResponse response) {
		this.response = response;
	}

}
