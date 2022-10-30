/**
 * 
 */
package com.bomweb.chequebook;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author SACHIN
 *
 */
@XmlRootElement(name = "com.bomweb.chequebook.ChequeDetails")
public class Cheque {
	private String branch;
	private String cheques;
	private String chqFrom;
	private String chqTo;
	private String date;
	private String pickupBranch;
	private String reorder;
	private String status;
	private String stopComments;
	private String stopReason;
	private String stopTime;
	private String type;

	/**
	 * @return the branch
	 */
	public String getBranch() {
		return branch;
	}

	/**
	 * @param branch
	 *            the branch to set
	 */
	@XmlElement(name = "branch")
	public void setBranch(String branch) {
		this.branch = branch;
	}

	/**
	 * @return the cheques
	 */
	public String getCheques() {
		return cheques;
	}

	/**
	 * @param cheques
	 *            the cheques to set
	 */
	@XmlElement(name = "cheques")
	public void setCheques(String cheques) {
		this.cheques = cheques;
	}

	/**
	 * @return the chqFrom
	 */
	public String getChqFrom() {
		return chqFrom;
	}

	/**
	 * @param chqFrom
	 *            the chqFrom to set
	 */
	@XmlElement(name = "chqFrom")
	public void setChqFrom(String chqFrom) {
		this.chqFrom = chqFrom;
	}

	/**
	 * @return the chqTo
	 */
	public String getChqTo() {
		return chqTo;
	}

	/**
	 * @param chqTo
	 *            the chqTo to set
	 */
	@XmlElement(name = "chqTo")
	public void setChqTo(String chqTo) {
		this.chqTo = chqTo;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	@XmlElement(name = "date")
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the pickupBranch
	 */
	public String getPickupBranch() {
		return pickupBranch;
	}

	/**
	 * @param pickupBranch
	 *            the pickupBranch to set
	 */
	@XmlElement(name = "pickupBranch")
	public void setPickupBranch(String pickupBranch) {
		this.pickupBranch = pickupBranch;
	}

	/**
	 * @return the reorder
	 */
	public String getReorder() {
		return reorder;
	}

	/**
	 * @param reorder
	 *            the reorder to set
	 */
	@XmlElement(name = "Reorder")
	public void setReorder(String reorder) {
		reorder = reorder;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	@XmlElement(name = "status")
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the stopComments
	 */
	public String getStopComments() {
		return stopComments;
	}

	/**
	 * @param stopComments
	 *            the stopComments to set
	 */
	@XmlElement(name = "stopComments")
	public void setStopComments(String stopComments) {
		this.stopComments = stopComments;
	}

	/**
	 * @return the stopReason
	 */
	public String getStopReason() {
		return stopReason;
	}

	/**
	 * @param stopReason
	 *            the stopReason to set
	 */
	@XmlElement(name = "stopReason")
	public void setStopReason(String stopReason) {
		this.stopReason = stopReason;
	}

	/**
	 * @return the stopTime
	 */
	public String getStopTime() {
		return stopTime;
	}

	/**
	 * @param stopTime
	 *            the stopTime to set
	 */
	@XmlElement(name = "stopTime")
	public void setStopTime(String stopTime) {
		this.stopTime = stopTime;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	@XmlElement(name = "type")
	public void setType(String type) {
		this.type = type;
	}

}
