package com.bomweb.transaction.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "FIGWebResSvc")
public class FIGWebResSvc {

	private SvcHeaderRsp svcHeaderRsp;
	private TxnInfoRsp txnInfoRsp;
	private ServiceInfoRsp serviceInfoRsp;

	/**
	 * @return the svcHeaderRsp
	 */
	public SvcHeaderRsp getSvcHeaderRsp() {
		return svcHeaderRsp;
	}

	/**
	 * @param svcHeaderRsp
	 *            the svcHeaderRsp to set
	 */
	@XmlElement(name = "SvcHeader")
	public void setSvcHeaderRsp(SvcHeaderRsp svcHeaderRsp) {
		this.svcHeaderRsp = svcHeaderRsp;
	}

	/**
	 * @return the txnInfoRsp
	 */
	public TxnInfoRsp getTxnInfoRsp() {
		return txnInfoRsp;
	}

	/**
	 * @param txnInfoRsp
	 *            the txnInfoRsp to set
	 */
	@XmlElement(name = "TxnInfo")
	public void setTxnInfoRsp(TxnInfoRsp txnInfoRsp) {
		this.txnInfoRsp = txnInfoRsp;
	}

	/**
	 * @return the serviceInfoRsp
	 */
	public ServiceInfoRsp getServiceInfoRsp() {
		return serviceInfoRsp;
	}

	/**
	 * @param serviceInfoRsp
	 *            the serviceInfoRsp to set
	 */
	@XmlElement(name = "ServiceInfo")
	public void setServiceInfoRsp(ServiceInfoRsp serviceInfoRsp) {
		this.serviceInfoRsp = serviceInfoRsp;
	}

}
