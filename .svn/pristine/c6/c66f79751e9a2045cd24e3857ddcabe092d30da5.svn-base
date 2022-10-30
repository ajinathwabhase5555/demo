/**
 * 
 */
package com.bomweb.insurance;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author SACHIN
 *
 */
@XmlRootElement(name = "com.bomweb.insurance.QueryAccountDetailsRes")
public class JointAcc {
	private List<JoinAccount> joinAccount;
	private String count;

	public List<JoinAccount> getJoinAccount() {
		return joinAccount;
	}

	@XmlElement(name = "Account")
	public void setJoinAccount(List<JoinAccount> joinAccount) {
		this.joinAccount = joinAccount;
	}

	public String getCount() {
		return count;
	}

	@XmlAttribute(name = "count")
	public void setCount(String count) {
		this.count = count;
	}

}
