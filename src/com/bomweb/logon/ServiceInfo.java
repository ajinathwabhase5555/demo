/**
 * 
 */
package com.bomweb.logon;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author SACHIN
 *
 */
@XmlRootElement(name = "com.bomweb.logon.LogonServiceResponse")
public class ServiceInfo {
	
	private LogonResInfo logonResInfo;

	public LogonResInfo getLogonResInfo() {
		return logonResInfo;
	}

	@XmlElement(name = "LogonResInfo")
	public void setLogonResInfo(LogonResInfo logonResInfo) {
		this.logonResInfo = logonResInfo;
	}
	
}
