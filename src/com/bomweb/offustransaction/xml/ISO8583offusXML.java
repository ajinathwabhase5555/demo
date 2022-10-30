/**
 * 
 */
package com.bomweb.offustransaction.xml;

import java.io.File;
import java.nio.file.Files;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.bomweb.service.model.Transactionoffus_IN;

/**
 * @author DATTU
 *
 */
public class ISO8583offusXML {
	static Log log = LogFactory.getLog(ISO8583offusXML.class);

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
			authInfo.setProv("NPCI");
			authInfo.setEnc("00");
			authInfo.setRc("Y");

			Data data = new Data();
			data.setType("X");
			data.setValue(in.getBiometricData());

			Fmt fmt = new Fmt();
			fmt.setType("X");

			Meta meta = new Meta();
			meta.setUdc(in.getUdc());
			meta.setRdsId(in.getRdsId());
			meta.setRdsVer(in.getRdsVer());
			meta.setDpId(in.getDpId());
			meta.setDc(in.getDc());
			meta.setMi(in.getMi());
			meta.setMc(in.getMc());
			meta.setBav("FPD");

			Uses uses = new Uses();
			uses.setPi("n");
			uses.setPa("n");
			uses.setPfa("n");
			uses.setBio("y");
			uses.setBt("FMR");
			uses.setPin("n");
			uses.setOtp("n");

			EncInfo encInfo = new EncInfo();
			encInfo.setAlg("");
			encInfo.setHmac(in.getHmac());

			SecKey key = new SecKey();
			key.setCi(in.getCi());
			key.setKi("");
			key.setValue(in.getSkey());
			encInfo.setSecKey(key);

			authInfo.setData(data);
			authInfo.setFmt(fmt);
			authInfo.setMeta(meta);
			authInfo.setUses(uses);
			authInfo.setEncInfo(encInfo);

			ServiceInfo serviceInfo = new ServiceInfo();
			TxnReqInfo reqInfo = new TxnReqInfo();
			if (!in.getProcessingCode().equals("PC0025") || !in.getProcessingCode().equals("PC0103")
					|| in.getProcessingCode().equals("PC0027"))
				reqInfo.setAmount(in.getAmount());
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
			PartyInfos partyInfos = new PartyInfos();
			partyInfos.setTypes("PERSON");
			partyInfos.setCategs("BENEFICIARY");
			partyInfos.setPartyOrgs(in.getPan().substring(0, 6));
			partyInfos.setPartyIdTypes(in.getTxnModes());
			partyInfos.setPartyIdValue(in.getPans());

			list.setPartyInfo(partyInfo);
			if (in.getProcessingCode().equals("PC0028")) {
				list.setPartyInfos(partyInfos);
			}
			reqInfo.setPartyList(list);
			 AddDataList addData = new AddDataList();
			 AddDataItem addItem =new AddDataItem();
			 AddDataItems addItems =new AddDataItems();
			 addItems.setNames("BENNAME");
			 addItems.setValues(in.getPans());
			 addItem.setName("AdditionalData");
			 addItem.setValue(in.getValue());
			// addItem.setValue("00100245002003UID04502006001910007109571210415990630020106400201065015CIF_957121041599066015CIF_725658332960");

			serviceInfo.setTxnResInfo(reqInfo);
			 reqInfo.setAddDataList(addData);
			 addData.setAddDataItem(addItem);
			 addData.setAddDataItems(addItems);


			
			//serviceInfo.setTxnResInfo(reqInfo);
			// reqInfo.setAddDataList(addData);
			
			reqSvc.setSvcHeader(svcHeader);
			reqSvc.setTxnInfo(info);
			reqSvc.setAuthInfo(authInfo);
			reqSvc.setServiceInfo(serviceInfo);

			JAXBContext jaxbContext = JAXBContext.newInstance(FIGWebReqSvc.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			File file = new File("E://BOM/Enrollment/offustxn_req" + in.getRrn() + ".xml");
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
