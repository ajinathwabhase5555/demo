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
public class Auth {

	private String ver;
	private String lk;
	private String txn;
	private String sa;
	private String ac;
	private String tid;
	private String uid;
	private String rc;
	private Data Data;
	private Skey Skey;
	private Meta Meta;
	private Uses Uses;
	private String Hmac;

	/**
	 * @return the ver
	 */
	@XmlAttribute
	public String getVer() {
		return ver;
	}

	/**
	 * @param ver
	 *            the ver to set
	 */
	public void setVer(String ver) {
		this.ver = ver;
	}

	/**
	 * @return the lk
	 */
	@XmlAttribute
	public String getLk() {
		return lk;
	}

	/**
	 * @param lk
	 *            the lk to set
	 */
	public void setLk(String lk) {
		this.lk = lk;
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
	 * @return the txn
	 */
	@XmlAttribute
	public String getTxn() {
		return txn;
	}

	/**
	 * @param txn the txn to set
	 */
	public void setTxn(String txn) {
		this.txn = txn;
	}

	/**
	 * @return the sa
	 */
	@XmlAttribute
	public String getSa() {
		return sa;
	}

	/**
	 * @param sa the sa to set
	 */
	public void setSa(String sa) {
		this.sa = sa;
	}

	/**
	 * @return the tid
	 */
	@XmlAttribute
	public String getTid() {
		return tid;
	}

	/**
	 * @param tid the tid to set
	 */
	public void setTid(String tid) {
		this.tid = tid;
	}

	/**
	 * @return the uid
	 */
	@XmlAttribute
	public String getUid() {
		return uid;
	}

	/**
	 * @param uid the uid to set
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}

	/**
	 * @return the ac
	 */
	@XmlAttribute
	public String getAc() {
		return ac;
	}

	/**
	 * @param ac the ac to set
	 */
	public void setAc(String ac) {
		this.ac = ac;
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
	 * @return the Skey
	 */
	@XmlElement(name = "Skey")
	public Skey getSkey() {
		return Skey;
	}
	
	/**
	 * @param hmac
	 *            the hmac to set
	 */
	public void setSkey(Skey skey) {
		Skey = skey;
		}
	

		/**
	 * @return the hmac
	 */
	@XmlElement(name = "Hmac")
	public String getHmac() {
		return Hmac;
	}

	/**
	 * @param hmac the hmac to set
	 */
	public void setHmac(String hmac) {
		Hmac = hmac;
	}

	


}
