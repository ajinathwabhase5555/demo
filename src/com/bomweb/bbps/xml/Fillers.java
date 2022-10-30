/**
 * 
 */
package com.bomweb.bbps.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author SACHIN
 *
 */
@XmlRootElement(name = "com.bomweb.bbps.Response")
public class Fillers {

	private List<String> filler;

	public List<String> getFiller() {
		return filler;
	}

	@XmlElement(name = "filler")
	public void setFiller(List<String> filler) {
		this.filler = filler;
	}
}
