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
@XmlRootElement(name = "com.bomweb.transaction.xml.FIGWebReqSvc")
public class ServiceInfoRsp {
	
	private TxnResInfo txnResInfo;

	public TxnResInfo getTxnResInfo() {
		return txnResInfo;
	}

	@XmlElement(name = "TxnResInfo")
	public void setTxnResInfo(TxnResInfo txnResInfo) {
		this.txnResInfo = txnResInfo; 
	}
	
}
