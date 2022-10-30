/**
 * 
 */
package com.bomweb.transaction.xml;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author SACHIN
 *
 */
public class AddDataList {
	
	 private AddDataItem addDataItem;
	 private AddDataItems addDataItems;
		/**
		 * @return the currCode
		 */
		@XmlElement(name = "AddDataItem")
		public AddDataItem getAddDataItem() {
			return addDataItem;
		}

		/**
		 * @param partyInfo
		 *            the partyInfo to set
		 */
		public void setAddDataItem(AddDataItem addDataItem) {
			this.addDataItem = addDataItem;
		}

		@XmlElement(name = "AddDataItem")
		public AddDataItems getAddDataItems() {
			return addDataItems;
		}

		/**
		 * @param partyInfo
		 *            the partyInfo to set
		 */
		public void setAddDataItems(AddDataItems addDataItems) {
			this.addDataItems = addDataItems;
		}

}
