/**
 * 
 */
package com.bomweb.aadhaarstatus;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * @author SACHIN
 *
 */
public class Meta {
	private String rdsId;
	private String rdsVer;
	private String dpId;
	private String dc;
	private String mi;
	private String mc;

	/**
	 * @return the rdsId
	 */
	@XmlAttribute(name="rdsId")
	public String getRdsId() {
		return rdsId;
	}

	/**
	 * @param rdsId
	 *            the rdsId to set
	 */
	public void setRdsId(String rdsId) {
		this.rdsId = rdsId;
	}

	/**
	 * @return the rdsVer
	 */
	@XmlAttribute(name="rdsVer")
	public String getRdsVer() {
		return rdsVer;
	}

	/**
	 * @param rdsVer
	 *            the rdsVer to set
	 */
	public void setRdsVer(String rdsVer) {
		this.rdsVer = rdsVer;
	}

	/**
	 * @return the dpId
	 */
	@XmlAttribute(name="dpId")
	public String getDpId() {
		return dpId;
	}

	/**
	 * @param dpId
	 *            the dpId to set
	 */
	public void setDpId(String dpId) {
		this.dpId = dpId;
	}

	/**
	 * @return the dc
	 */
	@XmlAttribute(name="dc")
	public String getDc() {
		return dc;
	}

	/**
	 * @param dc
	 *            the dc to set
	 */
	public void setDc(String dc) {
		this.dc = dc;
	}

	/**
	 * @return the mi
	 */
	@XmlAttribute(name="mi")
	public String getMi() {
		return mi;
	}

	/**
	 * @param mi
	 *            the mi to set
	 */
	public void setMi(String mi) {
		this.mi = mi;
	}

	/**
	 * @return the mc
	 */
	@XmlAttribute(name="mc")
	public String getMc() {
		return mc;
	}

	/**
	 * @param mc
	 *            the mc to set
	 */
	public void setMc(String mc) {
		this.mc = mc;
	}

}
