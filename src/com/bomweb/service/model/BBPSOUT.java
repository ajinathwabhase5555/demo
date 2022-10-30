/**
 * 
 */
package com.bomweb.service.model;

import java.util.List;

import com.bomweb.bbps.xml.Fields;
import com.bomweb.bbps.xml.Fillers;

/**
 * @author SACHIN
 *
 */
public class BBPSOUT {

	private String responseCode;
	private String responseDesc;
	private String requestID;
	private String rrn;
	private String billAmount;
	private String billDate;
	private String billDueDate;
	private String billerID;
	private String errorCode;
	private String errorDesc;
	private String partialPayment;
	private String payWithoutBill;
	private String valid;
	private String bbpsReferenceNo;
	private String customerId;
	private String reason;
	private String requestId;
	private String requestType;
	private String timestamp;
	private String transactionId;
	private String filler1;

	/**
	 * @return the responseCode
	 */
	public String getResponseCode() {
		return responseCode;
	}

	/**
	 * @param responseCode
	 *            the responseCode to set
	 */
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	/**
	 * @return the responseDesc
	 */
	public String getResponseDesc() {
		return responseDesc;
	}

	/**
	 * @param responseDesc
	 *            the responseDesc to set
	 */
	public void setResponseDesc(String responseDesc) {
		this.responseDesc = responseDesc;
	}

	/**
	 * @return the requestID
	 */
	public String getRequestID() {
		return requestID;
	}

	/**
	 * @param requestID
	 *            the requestID to set
	 */
	public void setRequestID(String requestID) {
		this.requestID = requestID;
	}

	/**
	 * @return the billAmount
	 */
	public String getBillAmount() {
		return billAmount;
	}

	/**
	 * @param billAmount
	 *            the billAmount to set
	 */
	public void setBillAmount(String billAmount) {
		this.billAmount = billAmount;
	}

	/**
	 * @return the billDate
	 */
	public String getBillDate() {
		return billDate;
	}

	/**
	 * @param billDate
	 *            the billDate to set
	 */
	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}

	/**
	 * @return the billDueDate
	 */
	public String getBillDueDate() {
		return billDueDate;
	}

	/**
	 * @param billDueDate
	 *            the billDueDate to set
	 */
	public void setBillDueDate(String billDueDate) {
		this.billDueDate = billDueDate;
	}

	/**
	 * @return the billerID
	 */
	public String getBillerID() {
		return billerID;
	}

	/**
	 * @param billerID
	 *            the billerID to set
	 */
	public void setBillerID(String billerID) {
		this.billerID = billerID;
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode
	 *            the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorDesc() {
		return errorDesc;
	}

	/**
	 * @param errorMessage
	 *            the errorMessage to set
	 */
	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}

	/**
	 * @return the partialPayment
	 */
	public String getPartialPayment() {
		return partialPayment;
	}

	/**
	 * @param partialPayment
	 *            the partialPayment to set
	 */
	public void setPartialPayment(String partialPayment) {
		this.partialPayment = partialPayment;
	}

	/**
	 * @return the payWithoutBill
	 */
	public String getPayWithoutBill() {
		return payWithoutBill;
	}

	/**
	 * @param payWithoutBill
	 *            the payWithoutBill to set
	 */
	public void setPayWithoutBill(String payWithoutBill) {
		this.payWithoutBill = payWithoutBill;
	}

	/**
	 * @return the valid
	 */
	public String getValid() {
		return valid;
	}

	/**
	 * @param valid
	 *            the valid to set
	 */
	public void setValid(String valid) {
		this.valid = valid;
	}

	public String getRrn() {
		return rrn;
	}

	public void setRrn(String rrn) {
		this.rrn = rrn;
	}

	/**
	 * @return the bbpsReferenceNo
	 */
	public String getBbpsReferenceNo() {
		return bbpsReferenceNo;
	}

	/**
	 * @param bbpsReferenceNo
	 *            the bbpsReferenceNo to set
	 */
	public void setBbpsReferenceNo(String bbpsReferenceNo) {
		this.bbpsReferenceNo = bbpsReferenceNo;
	}

	/**
	 * @return the customerId
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId
	 *            the customerId to set
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * @param reason
	 *            the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}

	/**
	 * @return the requestId
	 */
	public String getRequestId() {
		return requestId;
	}

	/**
	 * @param requestId
	 *            the requestId to set
	 */
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	/**
	 * @return the requestType
	 */
	public String getRequestType() {
		return requestType;
	}

	/**
	 * @param requestType
	 *            the requestType to set
	 */
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	/**
	 * @return the timestamp
	 */
	public String getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp
	 *            the timestamp to set
	 */
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * @return the transactionId
	 */
	public String getTransactionId() {
		return transactionId;
	}

	/**
	 * @param transactionId
	 *            the transactionId to set
	 */
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getFiller1() {
		return filler1;
	}

	public void setFiller1(String filler1) {
		this.filler1 = filler1;
	}
}
