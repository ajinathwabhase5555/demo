/**
 * 
 */
package com.bomweb.model;

import java.sql.Blob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author SACHIN
 *
 */
@Entity
@Table(name = "customerenrollment_reqrsp")
public class CustomerEnrollment {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUSTOMERENROLLMENT_SEQ")
	@SequenceGenerator(name = "CUSTOMERENROLLMENT_SEQ", sequenceName = "CUSTOMERENROLLMENT_SEQ", allocationSize = 0)
	@Column(name = "LOG_ID")
	private int id;
	@Column(name = "ENROLL_DATE")
	private Date currentDate;
	@Column(name = "TERMINALID")
	private String terminalID;
	@Column(name = "AGENTID")
	private String agentID;
	@Column(name = "RRN")
	private String rrn;
	@Column(name = "RESPONSE")
	private String response;
	@Column(name = "EKYCFLAG")
	private String ekycFlag;
	@Column(name = "ENROLLMENTFILE")
	private Blob enrollmentFile;
	@Column(name = "CUSTOMERNAME")
	private String customerName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

	public String getTerminalID() {
		return terminalID;
	}

	public void setTerminalID(String terminalID) {
		this.terminalID = terminalID;
	}

	public String getAgentID() {
		return agentID;
	}

	public void setAgentID(String agentID) {
		this.agentID = agentID;
	}

	public String getRrn() {
		return rrn;
	}

	public void setRrn(String rrn) {
		this.rrn = rrn;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public Blob getEnrollmentFile() {
		return enrollmentFile;
	}

	public void setEnrollmentFile(Blob enrollmentFile) {
		this.enrollmentFile = enrollmentFile;
	}

	public String getEkycFlag() {
		return ekycFlag;
	}

	public void setEkycFlag(String ekycFlag) {
		this.ekycFlag = ekycFlag;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
}
