package com.bomweb.model;

import java.util.Arrays;
import java.util.HashMap;

public class TransactionModelRequest {
	private String primaryAccountNumber;
	private String processingCode;
	private String transactionAmount;
	private String transactionDateTime;
	private String stan;
	private String localTransactionTime;
	private String localTransactionDate;
	private String merchantType;
	private String aiic;
	private String rrn;
	private String terminalId;
	private String bcDetails;
	private String agentDetails;
	private String currencyCode;
	private byte[] biometricData;
	private String poshEntryMode;
	private String poshConditionCode;
	private String vendorCode;
	private String gateway;
	private String cbsOdAccount;
	private String bcCode;
	private String branchCode;
	private String villageCode;
	private String drcrFlag;
	private byte[] isoMessage;
	private byte[] headerMessage;
	private String beneficiaryAccountNo;
	private String transactionType;
	private byte[] pidBlock;
	private String posh;
	private HashMap<String , byte[]> biometrics;
	private String customerAccountNo;
	
	public byte[] getIsoMessage() {
		return isoMessage;
	}

	public void setIsoMessage(byte[] isoMessage) {
		this.isoMessage = isoMessage;
	}

	public byte[] getHeaderMessage() {
		return headerMessage;
	}

	public void setHeaderMessage(byte[] headerMessage) {
		this.headerMessage = headerMessage;
	}

	public String getPrimaryAccountNumber() {
		return primaryAccountNumber;
	}

	public void setPrimaryAccountNumber(String primaryAccountNumber) {
		this.primaryAccountNumber = primaryAccountNumber;
	}

	public String getProcessingCode() {
		return processingCode;
	}

	public void setProcessingCode(String processingCode) {
		this.processingCode = processingCode;
	}

	public String getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getTransactionDateTime() {
		return transactionDateTime;
	}

	public void setTransactionDateTime(String dateTime) {
		this.transactionDateTime = dateTime;
	}

	public String getStan() {
		return stan;
	}

	public void setStan(String stan) {
		this.stan = stan;
	}

	public String getLocalTransactionTime() {
		return localTransactionTime;
	}

	public void setLocalTransactionTime(String time) {
		this.localTransactionTime = time;
	}

	public String getLocalTransactionDate() {
		return localTransactionDate;
	}

	public void setLocalTransactionDate(String localTransactionDate) {
		this.localTransactionDate = localTransactionDate;
	}

	public String getMerchantType() {
		return merchantType;
	}

	public void setMerchantType(String merchantType) {
		this.merchantType = merchantType;
	}

	public String getAiic() {
		return aiic;
	}

	public void setAiic(String aiic) {
		this.aiic = aiic;
	}

	public String getRrn() {
		return rrn;
	}

	public void setRrn(String rrn) {
		this.rrn = rrn;
	}

	public String getTerminalId() {
		return terminalId;
	}

	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

	public String getBcDetails() {
		return bcDetails;
	}

	public void setBcDetails(String bcDetails) {
		this.bcDetails = bcDetails;
	}

	public String getAgentDetails() {
		return agentDetails;
	}

	public void setAgentDetails(String agentDetails) {
		this.agentDetails = agentDetails;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public byte[] getBiometricData() {
		return biometricData;
	}

	public void setBiometricData(byte[] biometricData) {
		this.biometricData = biometricData;
	}

	public String getPoshEntryMode() {
		return poshEntryMode;
	}

	public void setPoshEntryMode(String poshEntryMode) {
		this.poshEntryMode = poshEntryMode;
	}

	public String getPoshConditionCode() {
		return poshConditionCode;
	}

	public void setPoshConditionCode(String poshConditionCode) {
		this.poshConditionCode = poshConditionCode;
	}

	public String getVendorCode() {
		return vendorCode;
	}

	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}

	public void setGateway(String gateway) {
		this.gateway = gateway;
	}

	public String getGateway() {
		return gateway;
	}

	public void setCbsOdAccount(String cbsOdAccount) {
		this.cbsOdAccount = cbsOdAccount;

	}

	public String getCbsOdAccount() {
		return cbsOdAccount;
	}

	public String getBcCode() {
		return bcCode;
	}

	public void setBcCode(String bcCode) {
		this.bcCode = bcCode;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getVillageCode() {
		return villageCode;
	}

	public void setVillageCode(String villageCode) {
		this.villageCode = villageCode;
	}

	public String getDrcrFlag() {
		return drcrFlag;
	}

	public void setDrcrFlag(String drcrFlag) {
		this.drcrFlag = drcrFlag;
	}

	@Override
	public String toString() {
		return "TransactionModel [primaryAccountNumber=" + primaryAccountNumber
				+ ", processingCode=" + processingCode + ", transactionAmount="
				+ transactionAmount + ", transactionDateTime="
				+ transactionDateTime + ", stan=" + stan
				+ ", localTransactionTime=" + localTransactionTime
				+ ", localTransactionDate=" + localTransactionDate
				+ ", merchantType=" + merchantType + ", aiic=" + aiic
				+ ", rrn=" + rrn + ", terminalId=" + terminalId
				+ ", bcDetails=" + bcDetails + ", agentDetails=" + agentDetails
				+ ", currencyCode=" + currencyCode + ", biometricData="
				+ Arrays.toString(biometricData) + ", poshEntryMode="
				+ poshEntryMode + ", poshConditionCode=" + poshConditionCode
				+ ", vendorCode=" + vendorCode + ", gateway=" + gateway
				+ ", cbsOdAccount=" + cbsOdAccount + ", bcCode=" + bcCode
				+ ", branchCode=" + branchCode + ", villageCode=" + villageCode
				+ ", drcrFlag=" + drcrFlag + "]";
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getBeneficiaryAccountNo() {
		return beneficiaryAccountNo;
	}

	public void setBeneficiaryAccountNo(String beneficiaryAccountNo) {
		this.beneficiaryAccountNo = beneficiaryAccountNo;
	}

	public byte[] getPidBlock() {
		return pidBlock;
	}

	public void setPidBlock(byte[] pidBlock) {
		this.pidBlock = pidBlock;
	}

	public String getPosh() {
		return posh;
	}

	public void setPosh(String posh) {
		this.posh = posh;
	}

	public HashMap<String , byte[]> getBiometrics() {
		return biometrics;
	}

	public void setBiometrics(HashMap<String , byte[]> biometrics) {
		this.biometrics = biometrics;
	}

	public String getCustomerAccountNo() {
		return customerAccountNo;
	}

	public void setCustomerAccountNo(String customerAccountNo) {
		this.customerAccountNo = customerAccountNo;
	}

}
