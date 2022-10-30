/**
 * 
 */
package com.bomweb.ekyc;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Dattu
 *
 */
@XmlRootElement(name = "com.bomweb.ekyc.Request")
public class KycReqInfo {
	private String rc;
	private String pfr;
	private String lr;
	private String de;
	private String ra;
	private String ver;
	private Auth Auth;
	/**
	 * @return the auth
	 */
	@XmlElement(name = "Auth")
	public Auth getAuth() {
		return Auth;
	}
	/**
	 * @param auth the auth to set
	 */
	
	public void setAuth(Auth auth) {
		Auth = auth;
	}
	/**
	 * @return the rc
	 */
	@XmlAttribute
	public String getRc() {
		return rc;
	}
	/**
	 * @param rc the rc to set
	 */
	public void setRc(String rc) {
		this.rc = rc;
	}
	/**
	 * @return the pfr
	 */
	@XmlAttribute
	public String getPfr() {
		return pfr;
	}
	/**
	 * @param pfr the pfr to set
	 */
	public void setPfr(String pfr) {
		this.pfr = pfr;
	}
	/**
	 * @return the lr
	 */
	@XmlAttribute
	public String getLr() {
		return lr;
	}
	/**
	 * @param lr the lr to set
	 */
	public void setLr(String lr) {
		this.lr = lr;
	}
	/**
	 * @return the de
	 */
	@XmlAttribute
	public String getDe() {
		return de;
	}
	/**
	 * @param de the de to set
	 */
	public void setDe(String de) {
		this.de = de;
	}
	/**
	 * @return the ra
	 */
	@XmlAttribute
	public String getRa() {
		return ra;
	}
	/**
	 * @param ra the ra to set
	 */
	public void setRa(String ra) {
		this.ra = ra;
	}
	/**
	 * @return the ver
	 */
	@XmlAttribute
	public String getVer() {
		return ver;
	}
	/**
	 * @param ver the ver to set
	 */
	public void setVer(String ver) {
		this.ver = ver;
	}

}
