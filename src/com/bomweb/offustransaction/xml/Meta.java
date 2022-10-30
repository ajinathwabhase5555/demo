/**
 * 
 */
package com.bomweb.offustransaction.xml;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * @author SACHIN
 *
 */
public class Meta {

	private String udc;
	private String rdsId;
	private String rdsVer;
	private String dpId;
	private String dc;
	private String mi;
	private String mc;
	private String bav;

	/**
	 * @return the udc
	 */
	@XmlAttribute
	public String getUdc() {
		return udc;
	}

	/**
	 * @param udc
	 *            the udc to set
	 */
	public void setUdc(String udc) {
		this.udc = udc;
	}

	/**
	 * @return the rdsId
	 */
	@XmlAttribute
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
	@XmlAttribute
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
	@XmlAttribute
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
	@XmlAttribute
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
	@XmlAttribute
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
	@XmlAttribute
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

	/**
	 * @return the bav
	 */
	@XmlAttribute
	public String getBav() {
		return bav;
	}

	/**
	 * @param bav
	 *            the bav to set
	 */
	public void setBav(String bav) {
		this.bav = bav;
	}

}
