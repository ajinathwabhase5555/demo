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
@XmlRootElement(name = "BillStatusRes")
public class BillStatusResponse {

	private BillPayStatusHeader billPayHeader;
	private PayStatusTxnInfo txnInfo;
	private PayStatusResponse response;

	/**
	 * @return the billPayHeader
	 */
	public BillPayStatusHeader getBillPayHeader() {
		return billPayHeader;
	}

	/**
	 * @param billPayHeader
	 *            the billPayHeader to set
	 */
	@XmlElement(name="BillPayHeader")
	public void setBillPayHeader(BillPayStatusHeader billPayHeader) {
		this.billPayHeader = billPayHeader;
	}

	/**
	 * @return the txnInfo
	 */
	public PayStatusTxnInfo getTxnInfo() {
		return txnInfo;
	}

	/**
	 * @param txnInfo
	 *            the txnInfo to set
	 */
	@XmlElement(name="TxnInfo")
	public void setTxnInfo(PayStatusTxnInfo txnInfo) {
		this.txnInfo = txnInfo;
	}

	/**
	 * @return the response
	 */
	public PayStatusResponse getResponse() {
		return response;
	}

	/**
	 * @param response
	 *            the response to set
	 */
	@XmlElement(name="response")
	public void setResponse(PayStatusResponse response) {
		this.response = response;
	}

}
