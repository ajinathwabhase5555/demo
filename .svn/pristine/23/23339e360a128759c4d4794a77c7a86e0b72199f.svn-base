package com.bomweb.ekyc;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace ="com.bomweb.ekyc.EKYCResponseXML")
public class UidData {

	private String uid;
	private Poi poi;
	private Poa poa;
	private String pht;
	
	public String getUid() {
		return uid;
	}
	@XmlAttribute
	public void setUid(String uid) {
		this.uid = uid;
	}
	public Poi getPoi() {
		return poi;
	}
	@XmlElement(name="Poi")
	public void setPoi(Poi poi) {
		this.poi = poi;
	}
	public Poa getPoa() {
		return poa;
	}
	@XmlElement(name="Poa")
	public void setPoa(Poa poa) {
		this.poa = poa;
	}
	public String getPht() {
		return pht;
	}
	@XmlElement(name="Pht")
	public void setPht(String pht) {
		this.pht = pht;
	}
	
	
	
}
