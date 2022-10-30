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
@XmlRootElement(name = "BillFetchRes")
public class BBPSResponse {

	private FetchBillPayHeader billPayHeader;
	private TxnInfo txnInfo;
	private Response response;

	/**
	 * @return the billPayHeader
	 */
	public FetchBillPayHeader getBillPayHeader() {
		return billPayHeader;
	}

	/**
	 * @param billPayHeader
	 *            the billPayHeader to set
	 */
	@XmlElement(name="BillPayHeader")
	public void setBillPayHeader(FetchBillPayHeader billPayHeader) {
		this.billPayHeader = billPayHeader;
	}

	/**
	 * @return the txnInfo
	 */
	public TxnInfo getTxnInfo() {
		return txnInfo;
	}

	/**
	 * @param txnInfo
	 *            the txnInfo to set
	 */
	@XmlElement(name="TxnInfo")
	public void setTxnInfo(TxnInfo txnInfo) {
		this.txnInfo = txnInfo;
	}

	/**
	 * @return the response
	 */
	public Response getResponse() {
		return response;
	}

	/**
	 * @param response
	 *            the response to set
	 */
	@XmlElement(name="response")
	public void setResponse(Response response) {
		this.response = response;
	}

}
