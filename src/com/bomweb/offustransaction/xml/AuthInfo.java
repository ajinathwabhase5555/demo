/**
 * 
 */
package com.bomweb.offustransaction.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Dattu
 *
 */
@XmlRootElement(name = "com.bomweb.transaction.FIGWebReqSvc")
public class AuthInfo {

	private String prov;
	private String enc;
	private String rc;
	private Data Data;
	private Fmt Fmt;
	private Meta Meta;
	private Uses Uses;
	private EncInfo encInfo;

	/**
	 * @return the prov
	 */
	@XmlAttribute
	public String getProv() {
		return prov;
	}

	/**
	 * @param prov
	 *            the prov to set
	 */
	public void setProv(String prov) {
		this.prov = prov;
	}

	/**
	 * @return the enc
	 */
	@XmlAttribute
	public String getEnc() {
		return enc;
	}

	/**
	 * @param enc
	 *            the enc to set
	 */
	public void setEnc(String enc) {
		this.enc = enc;
	}

	/**
	 * @return the rc
	 */
	@XmlAttribute
	public String getRc() {
		return rc;
	}

	/**
	 * @param rc
	 *            the rc to set
	 */
	public void setRc(String rc) {
		this.rc = rc;
	}

	/**
	 * @return the data
	 */
	@XmlElement(name = "Data")
	public Data getData() {
		return Data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	
	public void setData(Data data) {
		Data = data;
	}

	/**
	 * @return the fmt
	 */
	@XmlElement(name = "Fmt")
	public Fmt getFmt() {
		return Fmt;
	}

	/**
	 * @param fmt
	 *            the fmt to set
	 */
	public void setFmt(Fmt fmt) {
		Fmt = fmt;
	}

	/**
	 * @return the meta
	 */
	@XmlElement(name = "Meta")
	public Meta getMeta() {
		return Meta;
	}

	/**
	 * @param meta
	 *            the meta to set
	 */
	public void setMeta(Meta meta) {
		Meta = meta;
	}

	/**
	 * @return the uses
	 */
	@XmlElement(name = "Uses")
	public Uses getUses() {
		return Uses;
	}

	/**
	 * @param uses
	 *            the uses to set
	 */
	public void setUses(Uses uses) {
		Uses = uses;
	}

	/**
	 * @return the encInfo
	 */
	@XmlElement(name = "EncInfo")
	public EncInfo getEncInfo() {
		return encInfo;
	}

	/**
	 * @param encInfo
	 *            the encInfo to set
	 */
	public void setEncInfo(EncInfo encInfo) {
		this.encInfo = encInfo;
	}

}
