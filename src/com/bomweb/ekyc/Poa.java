package com.bomweb.ekyc;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "com.bomweb.ekyc.UidData")
public class Poa {

	private String vtc;
	private String street;
	private String state;
	private String pc;
	private String loc;
	private String house;
	private String dist;
	private String country;
	private String lm;

	public String getVtc() {
		return vtc;
	}

	@XmlAttribute
	public void setVtc(String vtc) {
		this.vtc = vtc;
	}

	public String getStreet() {
		return street;
	}

	@XmlAttribute
	public void setStreet(String street) {
		this.street = street;
	}

	public String getState() {
		return state;
	}

	@XmlAttribute
	public void setState(String state) {
		this.state = state;
	}

	public String getPc() {
		return pc;
	}

	@XmlAttribute
	public void setPc(String pc) {
		this.pc = pc;
	}

	public String getLoc() {
		return loc;
	}

	@XmlAttribute
	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String getHouse() {
		return house;
	}

	@XmlAttribute
	public void setHouse(String house) {
		this.house = house;
	}

	public String getDist() {
		return dist;
	}

	@XmlAttribute
	public void setDist(String dist) {
		this.dist = dist;
	}

	public String getCountry() {
		return country;
	}

	@XmlAttribute
	public void setCountry(String country) {
		this.country = country;
	}

	public String getLm() {
		return lm;
	}

	public void setLm(String lm) {
		this.lm = lm;
	}

}
