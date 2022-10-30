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
@XmlRootElement(name = "FIGWebResSvc")
public class InsuranceResponse {

	private SvcHeader svcHeader;
	private TxnInfo txnInfo;
	private PartyInfo partyInfo;
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

	public PartyInfo getPartyInfo() {
		return partyInfo;
	}

	@XmlElement(name = "PartyInfo")
	public void setPartyInfo(PartyInfo partyInfo) {
		this.partyInfo = partyInfo;
	}

	public ServiceInfo getServiceInfo() {
		return serviceInfo;
	}

	@XmlElement(name = "ServiceInfo")
	public void setServiceInfo(ServiceInfo serviceInfo) {
		this.serviceInfo = serviceInfo;
	}
}
