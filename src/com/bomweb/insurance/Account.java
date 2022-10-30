/**
 * 
 */
package com.bomweb.insurance;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author SACHIN
 *
 */
@XmlRootElement(name = "com.bomweb.insurance.QueryAccountDetailsRes")
public class Account {

	private String AcctBalance;
	private String AcctBranch;
	private String AcctFreezeStatus;
	private String CustomerId;
	private String LinkAadhar;
	private String LinkMobile;

	public String getAcctBalance() {
		return AcctBalance;
	}

	@XmlElement(name="AcctBalance")
	public void setAcctBalance(String acctBalance) {
		AcctBalance = acctBalance;
	}

	public String getAcctBranch() {
		return AcctBranch;
	}

	@XmlElement(name="AcctBranch")
	public void setAcctBranch(String acctBranch) {
		AcctBranch = acctBranch;
	}

	public String getAcctFreezeStatus() {
		return AcctFreezeStatus;
	}

	@XmlElement(name="AcctFreezeStatus")
	public void setAcctFreezeStatus(String acctFreezeStatus) {
		AcctFreezeStatus = acctFreezeStatus;
	}

	public String getCustomerId() {
		return CustomerId;
	}

	@XmlElement(name="CustomerId")
	public void setCustomerId(String customerId) {
		CustomerId = customerId;
	}

	public String getLinkAadhar() {
		return LinkAadhar;
	}

	@XmlElement(name="LinkAadhar")
	public void setLinkAadhar(String linkAadhar) {
		LinkAadhar = linkAadhar;
	}

	public String getLinkMobile() {
		return LinkMobile;
	}

	@XmlElement(name="LinkMobile")
	public void setLinkMobile(String linkMobile) {
		LinkMobile = linkMobile;
	}
}
