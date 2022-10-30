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
@XmlRootElement(name = "com.bomweb.insurance.ServiceInfo")
public class QueryAccountDetailsRes {
	private Account account;
	private EligibleCriteria eligibleCriteria;
	private JointAcc jointAcc;

	public Account getAccount() {
		return account;
	}

	@XmlElement(name = "Account")
	public void setAccount(Account account) {
		this.account = account;
	}

	public EligibleCriteria getEligibleCriteria() {
		return eligibleCriteria;
	}

	@XmlElement(name = "EligibleCriteria")
	public void setEligibleCriteria(EligibleCriteria eligibleCriteria) {
		this.eligibleCriteria = eligibleCriteria;
	}

	public JointAcc getJointAcc() {
		return jointAcc;
	}

	@XmlElement(name = "JointAcc")
	public void setJointAcc(JointAcc jointAcc) {
		this.jointAcc = jointAcc;
	}
}
