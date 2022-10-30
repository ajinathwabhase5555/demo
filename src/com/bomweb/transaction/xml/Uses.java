/**
 * 
 */
package com.bomweb.transaction.xml;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * @author SACHIN
 *
 */
public class Uses {

	private String pi;
	private String pa;
	private String pfa;
	private String bio;
	private String bt;
	private String pin;
	private String otp;

	/**
	 * @return the pi
	 */
	@XmlAttribute
	public String getPi() {
		return pi;
	}

	/**
	 * @param pi
	 *            the pi to set
	 */
	public void setPi(String pi) {
		this.pi = pi;
	}

	/**
	 * @return the pa
	 */
	@XmlAttribute
	public String getPa() {
		return pa;
	}

	/**
	 * @param pa
	 *            the pa to set
	 */
	public void setPa(String pa) {
		this.pa = pa;
	}

	/**
	 * @return the pfa
	 */
	@XmlAttribute
	public String getPfa() {
		return pfa;
	}

	/**
	 * @param pfa
	 *            the pfa to set
	 */
	public void setPfa(String pfa) {
		this.pfa = pfa;
	}

	/**
	 * @return the bio
	 */
	@XmlAttribute
	public String getBio() {
		return bio;
	}

	/**
	 * @param bio
	 *            the bio to set
	 */
	public void setBio(String bio) {
		this.bio = bio;
	}

	/**
	 * @return the bt
	 */
	@XmlAttribute
	public String getBt() {
		return bt;
	}

	/**
	 * @param bt
	 *            the bt to set
	 */
	public void setBt(String bt) {
		this.bt = bt;
	}

	/**
	 * @return the pin
	 */
	@XmlAttribute
	public String getPin() {
		return pin;
	}

	/**
	 * @param pin
	 *            the pin to set
	 */
	public void setPin(String pin) {
		this.pin = pin;
	}

	/**
	 * @return the otp
	 */
	@XmlAttribute
	public String getOtp() {
		return otp;
	}

	/**
	 * @param otp
	 *            the otp to set
	 */
	public void setOtp(String otp) {
		this.otp = otp;
	}

}
