/**
 * 
 */
package com.bomweb.insurance;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author SACHIN
 *
 */
public class ReadFile {
	public static void main(String[] args) {

		try {
			File xml = new File("C://Users/SACHIN/Videos/InsEnqResponse_833114885608.xml");
			Reader fileReader = new FileReader(xml);
			BufferedReader bufReader = new BufferedReader(fileReader);
			StringBuilder sb = new StringBuilder();
			String line = bufReader.readLine();
			while (line != null) {
				sb.append(line).append("\n");
				line = bufReader.readLine();
			}
//			String xml2String = sb.toString().replaceAll("\\P{Print}","");
			
			String xml2String1 = sb.toString();
			xml2String1 = xml2String1.replaceAll("[^\\p{ASCII}]", "");
			System.out.println("After removing non ASCII chars:");
			System.out.println(xml2String1);
//			xml2String1.startsWith("<address1>");
			
//			System.out.println("XML to String using BufferedReader : ");
//			System.out.println(xml2String);
			
//			File xmlFile = new File("C://Users/SACHIN/Videos/rsp.xml");
//			if (xmlFile.exists())
//				xmlFile.delete();
//			xmlFile.createNewFile();
//			FileOutputStream fileOutputStream = new FileOutputStream(xmlFile);
//			fileOutputStream.write(xml2String.getBytes("UTF-8"));
//			fileOutputStream.close();

			// FileInputStream fis = new
			// FileInputStream("C://Users/SACHIN/Videos/InsEnqResponse_833114885608.xml");
			// InputStreamReader input = new InputStreamReader(fis);
			// BufferedReader br = new BufferedReader(input);
			// String data;
			// String result = new String();
			// while ((data = br.readLine()) != null) {
			// result = result.concat(data + "");
			// }
			// System.out.println();
			//
			// // String xmlString = "<message>HELLO!</message> ";
			// JAXBContext jc = JAXBContext.newInstance(String.class);
			// Unmarshaller unmarshaller = jc.createUnmarshaller();
			// StreamSource xmlSource = new StreamSource(new StringReader(result));
			// JAXBElement<String> je = unmarshaller.unmarshal(xmlSource, String.class);
			// System.out.println(je.getValue());

			// try {
			//
			 File fXmlFile = new
			 File("C://Users/SACHIN/Videos/rsp.txt");
			 DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			 DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			 Document doc = dBuilder.parse(fXmlFile);
			
			 //optional, but recommended
			 //read this -
			 http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			 doc.getDocumentElement().normalize();
			
			 System.out.println("Root element :" +
			 doc.getDocumentElement().getNodeName());
			
			 NodeList nList = doc.getElementsByTagName("staff");
			
			 System.out.println("----------------------------");
			
			 for (int temp = 0; temp < nList.getLength(); temp++) {
			
			 Node nNode = nList.item(temp);
			
			 System.out.println("\nCurrent Element :" + nNode.getNodeName());
			
			 if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			
			 Element eElement = (Element) nNode;
			
			 System.out.println("Staff id : " + eElement.getAttribute("id"));
			 System.out.println("First Name : " +
			 eElement.getElementsByTagName("firstname").item(0).getTextContent());
			 System.out.println("Last Name : " +
			 eElement.getElementsByTagName("lastname").item(0).getTextContent());
			 System.out.println("Nick Name : " +
			 eElement.getElementsByTagName("nickname").item(0).getTextContent());
			 System.out.println("Salary : " +
			 eElement.getElementsByTagName("salary").item(0).getTextContent());
			
			 }
			 }
//			 } catch (Exception e) {
//			 e.printStackTrace();
//			 }
//			 }

			// try {
			// FileInputStream fis = new
			// FileInputStream("C://Users/SACHIN/Videos/InsEnqResponse_833114885608.xml");
			// InputStreamReader input = new InputStreamReader(fis);
			// BufferedReader br = new BufferedReader(input);
			// String data;
			// String result = new String();
			// while ((data = br.readLine()) != null) {
			// result = result.concat(data + "");
			// }
			// //
			// System.out.println(result);
			// String result1 = StringEscapeUtils.unescapeXml(result);
			// System.out.println("\nRES : "+result1);
			//
//			File xmlFile = new File("C://Users/SACHIN/Videos/rsp.xml");
//			if (xmlFile.exists())
//				xmlFile.delete();
//			xmlFile.createNewFile();
//			FileOutputStream fileOutputStream = new FileOutputStream(xmlFile);
//			fileOutputStream.write(result1.getBytes());
//			fileOutputStream.close();
			//
			//
			//
			//
			// ByteArrayInputStream in = new ByteArrayInputStream(result.getBytes());
			// JAXBContext context = JAXBContext.newInstance(InsuranceResponse.class);
			// Unmarshaller unmarshaller = context.createUnmarshaller();
			// InsuranceResponse responseXML = (InsuranceResponse)
			// unmarshaller.unmarshal(in);
			// System.out.println(responseXML.getServiceInfo().getSssEnqRes().getAddress1());
			// System.out.println(responseXML.getServiceInfo().getSssEnqRes().getAddress2());
			// System.out.println(responseXML.getServiceInfo().getSssEnqRes().getCustomerName());
			// System.out.println(responseXML.getSvcHeader().getRespCode());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
