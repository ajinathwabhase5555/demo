package com.bomweb.model;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class MiniStatementData {
	@XmlElement
	private String txnDate;
	private String txnType;
	private String txnMode;
	private BigDecimal txnValue;

	public String getTxnDate() {
		return txnDate;
	}

	public void setTxnDate(String txnDate) {
		this.txnDate = txnDate;
	}

	public String getTxnType() {
		return txnType;
	}

	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}

	public String getTxnMode() {
		return txnMode;
	}

	public void setTxnMode(String txnMode) {
		this.txnMode = txnMode;
	}

	public BigDecimal getTxnValue() {
		return txnValue;
	}

	public void setTxnValue(BigDecimal txnValue) {
		this.txnValue = txnValue;
	}

}
