/**
 * 
 */
package com.bomweb.aadhaarstatus;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author SACHIN
 *
 */
@XmlRootElement(name="com.bomweb.aadhaarstatus.AuthRequest")
public class Auth {

	private String uid;
	private String rc;
	private String tid;
	private String ac;
	private String sa;
	private String ver;
	private String txn;
	private String lk;
	private Uses uses;
	private Meta meta;
	private Skey skey;
	private Data data;
	private String hmac;

	/**
	 * @return the uid
	 */
	@XmlAttribute(name ="uid")
	public String getUid() {
		return uid;
	}

	/**
	 * @param uid
	 *            the uid to set
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}

	/**
	 * @return the rc
	 */
	@XmlAttribute(name ="rc")
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
	 * @return the tid
	 */
	@XmlAttribute(name ="tid")
	public String getTid() {
		return tid;
	}

	/**
	 * @param tid
	 *            the tid to set
	 */
	public void setTid(String tid) {
		this.tid = tid;
	}

	/**
	 * @return the ac
	 */
	@XmlAttribute(name ="ac")
	public String getAc() {
		return ac;
	}

	/**
	 * @param ac
	 *            the ac to set
	 */
	public void setAc(String ac) {
		this.ac = ac;
	}

	/**
	 * @return the sa
	 */
	@XmlAttribute(name ="sa")
	public String getSa() {
		return sa;
	}

	/**
	 * @param sa
	 *            the sa to set
	 */
	public void setSa(String sa) {
		this.sa = sa;
	}

	/**
	 * @return the ver
	 */
	@XmlAttribute(name ="ver")
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
	 * @return the txn
	 */
	@XmlAttribute(name ="txn")
	public String getTxn() {
		return txn;
	}

	/**
	 * @param txn
	 *            the txn to set
	 */
	public void setTxn(String txn) {
		this.txn = txn;
	}

	/**
	 * @return the lk
	 */
	@XmlAttribute(name ="lk")
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
	 * @return the uses
	 */
	@XmlElement(name ="Uses")
	public Uses getUses() {
		return uses;
	}

	/**
	 * @param uses
	 *            the uses to set
	 */
	public void setUses(Uses uses) {
		this.uses = uses;
	}

	/**
	 * @return the meta
	 */
	@XmlElement(name="Meta")
	public Meta getMeta() {
		return meta;
	}

	/**
	 * @param meta the meta to set
	 */
	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	/**
	 * @return the skey
	 */
	@XmlElement(name="Skey")
	public Skey getSkey() {
		return skey;
	}

	/**
	 * @param skey the skey to set
	 */
	public void setSkey(Skey skey) {
		this.skey = skey;
	}

	/**
	 * @return the data
	 */
	@XmlElement(name="Data")
	public Data getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Data data) {
		this.data = data;
	}

	/**
	 * @return the hmac
	 */
	@XmlElement(name="Hmac")
	public String getHmac() {
		return hmac;
	}

	/**
	 * @param hmac the hmac to set
	 */
	public void setHmac(String hmac) {
		this.hmac = hmac;
	}
	
}
