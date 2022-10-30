/**
 * 
 */
package com.bomweb.offustranrevers.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * @author SACHIN
 *
 */
@XmlRootElement(name = "com.bomweb.transaction.FIGWebReqSvc")
public class ServiceInfo {

	private TxnReqInfo txnResInfo;

	public TxnReqInfo getTxnResInfo() {
		return txnResInfo;
	}

	@XmlElement(name = "TxnReqInfo")
	public void setTxnResInfo(TxnReqInfo txnResInfo) {
		this.txnResInfo = txnResInfo;
	}

}
