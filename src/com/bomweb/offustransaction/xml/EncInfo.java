/**
 * 
 */
package com.bomweb.offustransaction.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
/**
 * @author SACHIN
 *
 */
public class EncInfo {

	private String alg;
	private SecKey secKey;
	private String Hmac;

	/**
	 * @return the alg
	 */
	@XmlAttribute
	public String getAlg() {
		return alg;
	}

	/**
	 * @param alg
	 *            the alg to set
	 */
	public void setAlg(String alg) {
		this.alg = alg;
	}

	/**
	 * @return the secKey
	 */
	@XmlElement(name = "SecKey")
	public SecKey getSecKey() {
		return secKey;
	}

	/**
	 * @param secKey
	 *            the secKey to set
	 */
	public void setSecKey(SecKey secKey) {
		this.secKey = secKey;
	}

	/**
	 * @return the hmac
	 */
	@XmlElement(name = "Hmac")
	public String getHmac() {
		return Hmac;
	}

	/**
	 * @param hmac
	 *            the hmac to set
	 */
	public void setHmac(String hmac) {
		Hmac = hmac;
	}

}
