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
public class TxnResInfo {
	private String status;
	private ChequeDetails chequeDetails;

	public String getStatus() {
		return status;
	}

	@XmlElement(name = "status")
	public void setStatus(String status) {
		this.status = status;
	}

	public ChequeDetails getChequeDetails() {
		return chequeDetails;
	}

	@XmlElement(name = "ChequeDetails")
	public void setChequeDetails(ChequeDetails chequeDetails) {
		this.chequeDetails = chequeDetails;
	}
}
