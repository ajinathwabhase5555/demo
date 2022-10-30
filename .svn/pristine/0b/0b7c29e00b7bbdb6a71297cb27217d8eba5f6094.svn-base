/**
 * 
 */
package com.bomweb.chequebook;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author SACHIN
 *
 */
@XmlRootElement(name = "com.bomweb.chequebook.TxnResInfo")
public class ChequeDetails {

	private String no;
	private List<Cheque> cheque;

	/**
	 * @return the no
	 */
	@XmlAttribute(name = "no")
	public String getNo() {
		return no;
	}

	/**
	 * @param no
	 *            the no to set
	 */
	public void setNo(String no) {
		this.no = no;
	}

	/**
	 * @return the cheque
	 */
	public List<Cheque> getCheque() {
		return cheque;
	}

	/**
	 * @param cheque
	 *            the cheque to set
	 */
	@XmlElement(name = "Cheque")
	public void setCheque(List<Cheque> cheque) {
		this.cheque = cheque;
	}

}
