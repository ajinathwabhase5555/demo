/**
 * 
 */
package com.bomweb.logon;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.bomweb.logon.ServiceInfo;
import com.bomweb.logon.SvcHeader;
import com.bomweb.logon.TxnInfo;

/**
 * @author SACHIN
 *
 */
@XmlRootElement(name = "FIGWebResSvc")
public class LogonServiceResponse {

	private SvcHeader svcHeader;
	private TxnInfo txnInfo;
	private ServiceInfo serviceInfo;

	public SvcHeader getSvcHeader() {
		return svcHeader;
	}

	@XmlElement(name = "SvcHeader")
	public void setSvcHeader(SvcHeader svcHeader) {
		this.svcHeader = svcHeader;
	}

	public TxnInfo getTxnInfo() {
		return txnInfo;
	}

	@XmlElement(name = "TxnInfo")
	public void setTxnInfo(TxnInfo txnInfo) {
		this.txnInfo = txnInfo;
	}

	public ServiceInfo getServiceInfo() {
		return serviceInfo;
	}

	@XmlElement(name = "ServiceInfo")
	public void setServiceInfo(ServiceInfo serviceInfo) {
		this.serviceInfo = serviceInfo;
	}
}
