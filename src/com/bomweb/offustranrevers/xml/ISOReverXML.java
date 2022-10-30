/**
 * 
 */
package com.bomweb.offustranrevers.xml;

import java.io.File;
import java.nio.file.Files;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bomweb.service.model.Transactionoffus_IN;
/**
 * @author SACHIN
 *
 */
public class ISOReverXML {

	static Log log = LogFactory.getLog(ISOReverXML.class);

	/**
	 * @param in
	 * @return
	 */
	public static byte[] createXML(Transactionoffus_IN in) {
		try {

			FIGWebReqSvc reqSvc = new FIGWebReqSvc();
			SvcHeader svcHeader = new SvcHeader();
			svcHeader.setTxnId(in.getRrn());
			svcHeader.setTspVdrId("88");
			svcHeader.setTxnOrigin("OV");
			svcHeader.setMsgFmtVer("1.0");
			svcHeader.setAppVersion("6.3.0");
			svcHeader.setTspAuth("");

			TxnInfo info = new TxnInfo();
			info.setFuncCode("1200");
			info.setPan(in.getPan());
			info.setProcCode(in.getProcessingCode());
			info.setTxnDateTime(in.getTxnDateTime());
			info.setMcc("6012");
			info.setPosEntryMode("019");
			info.setPosCode("05");
			info.setAcqId(in.getPan().substring(0, 6));
			info.setTrack2Data("");
			info.setRrn(in.getRrn());
			info.setTerminalId(in.getTerminalId());
			info.setCaId(in.getCaId());
			info.setCaLocn("VISIONINDIA            PUNE         MHIN");
			info.setTerminalData("");
			info.setAgentId(in.getAgentId());
			info.setServiceChrg("");
			info.setTxnMode(in.getTxnMode());
			info.setOrgTxnRefId("");
			info.setNarration(in.getNarration());
			info.setTxnHmac(in.getTxnHmac());
			info.setUniqueNo(in.getRrn().substring(in.getRrn().length() - 6));
			info.setExpDate("");
			info.setSetlDate("");
			info.setPosCaptCode("00");
			info.setRefSeq("");

			AuthInfo authInfo = new AuthInfo();
			
			ServiceInfo serviceInfo = new ServiceInfo();
			TxnReqInfo reqInfo = new TxnReqInfo();
			if (!in.getProcessingCode().equals("PC0100") )
				//reqInfo.setAmount(in.getAmount());
			reqInfo.setCurrCode("INR");
			PartyList list = new PartyList();
			PartyInfo partyInfo = new PartyInfo();
			partyInfo.setType("PERSON");
			partyInfo.setCateg("CUSTOMER");
			partyInfo.setPartyOrg(in.getPan().substring(0, 6));
			partyInfo.setPartyIdType(in.getTxnMode());
			if (in.getTxnMode().equals("UID")) {
				partyInfo.setPartyIdValue(in.getPan().substring(in.getPan().length() - 12));
			   }
			else {
			      partyInfo.setPartyIdValue(in.getPan().substring(in.getPan().length() - 16));
			     }
			
			list.setPartyInfo(partyInfo);
			
			reqInfo.setPartyList(list);
			serviceInfo.setTxnResInfo(reqInfo);
			
			reqSvc.setSvcHeader(svcHeader);
			reqSvc.setTxnInfo(info);
			reqSvc.setAuthInfo(authInfo);
			reqSvc.setServiceInfo(serviceInfo);

			JAXBContext jaxbContext = JAXBContext.newInstance(FIGWebReqSvc.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			File file = new File("E://BOM/Enrollment/revertxn_req" + in.getRrn() + ".xml");
			if (file.exists())
				file.delete();
			file.createNewFile();
			marshaller.marshal(reqSvc, file);
			return Files.readAllBytes(file.toPath());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


}
