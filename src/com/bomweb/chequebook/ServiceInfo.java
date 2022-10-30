/**
 * 
 */
package com.bomweb.chequebook;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author SACHIN
 *
 */
@XmlRootElement(name = "com.bomweb.chequebook.ChequeBookResponse")
public class ServiceInfo {
	
	private TxnResInfo txnResInfo;

	public TxnResInfo getTxnResInfo() {
		return txnResInfo;
	}

	@XmlElement(name = "TxnResInfo")
	public void setTxnResInfo(TxnResInfo txnResInfo) {
		this.txnResInfo = txnResInfo;
	}
	
}
