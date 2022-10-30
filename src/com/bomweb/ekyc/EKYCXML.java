/**
 * 
 */
package com.bomweb.ekyc;


import java.io.File;
import java.nio.file.Files;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.bomweb.service.model.EKYC_IN;



/**
 * @author Dattu
 *
 */
public class EKYCXML {
	
	static Log log = LogFactory.getLog(EKYCXML.class);

	/**
	 * @param in
	 * @return
	 */
	public static byte[] createXML(EKYC_IN in) {
		try {
			

			Request reqSvc = new Request();

			TransactionInfo info = new TransactionInfo();
			
			info.setBINUID(in.getPan());
			info.setHandleID("O_EKYC");
			info.setDateTime(in.getTxnDateTime().substring(4, 14));
			info.setUniqueNo(in.getRrn().substring(in.getRrn().length() - 6));
			info.setVendorId("88");
			info.setPosEntryMode("019");
			info.setPosConditionCode("05");
			info.setFrmBankCode("200015");
			info.setRetrivalRefNo(in.getRrn());
			info.setTerminalId(in.getTerminalId());
			info.setLocalTime(in.getTxnDateTime().substring(8, 14));
			info.setLocalDate(in.getTxnDateTime().substring(4, 8));
			info.setCaptureDate(in.getTxnDateTime().substring(4, 8));
			info.setCardAcceptorId("BMU0888"+ in.getTerminalId().substring(1, 9));
			info.setTerminalInfo(in.getTerminalInfo());
			info.setAgentsInfo(in.getAgentId()+"|0|02");
			info.setUserType("C");

			info.setprocessingCode(in.getProcessingCode());
			
			KycReqInfo kycInfo = new KycReqInfo();
			kycInfo.setVer("2.5");
			kycInfo.setRa("F");
			kycInfo.setDe("N");
			kycInfo.setLr("N");
			kycInfo.setPfr("Y");
			kycInfo.setRc("Y");					
			

			Auth authInfo = new Auth();
			authInfo.setVer("2.5");
			authInfo.setRc("Y");
			authInfo.setUid(in.getPan().substring(7, 19));
			authInfo.setTid("registered");
			authInfo.setAc("STGBOM0001");
			authInfo.setSa("STGBOM0001");
			authInfo.setTxn("UKC:"+in.getRrn().substring(6, 12));			
			authInfo.setLk("MOA3w4KHeBQxuuM57tDxDn5nLH9Z6Sif1uuTsIgtMZqBnEte-9E4b6M");			
			
			
			Data data = new Data();
			data.setType("X");
			data.setValue(in.getBiometricData());


			Meta meta = new Meta();
			meta.setUdc(in.getUdc());
			meta.setRdsId(in.getRdsId());
			meta.setRdsVer(in.getRdsVer());
			meta.setDpId(in.getDpId());
			meta.setDc(in.getDc());
			meta.setMi(in.getMi());
			meta.setMc(in.getMc());
			//meta.setBav("FPD");

			Uses uses = new Uses();
			uses.setPi("n");
			uses.setPa("n");
			uses.setPfa("n");
			uses.setBio("y");
			uses.setBt("FMR,FIR");
			uses.setPin("n");
			uses.setOtp("n");


			Skey key = new Skey();
			key.setCi(in.getCi());
			key.setValue(in.getSkey());
			
		//	authInfo.setData(data);
		//	authInfo.setMeta(meta);
		//	authInfo.setHmac(in.getHmac());
		//	authInfo.setUses(uses);
			
			kycInfo.setAuth(authInfo);
			authInfo.setUses(uses);
			authInfo.setMeta(meta);
			authInfo.setSkey(key);
			authInfo.setData(data);
			authInfo.setHmac(in.getHmac());
			
			
			reqSvc.setTransactionInfo(info);
			reqSvc.setKycReqInfo(kycInfo);


			
			JAXBContext jaxbContext = JAXBContext.newInstance(Request.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			File file = new File("E://BOM/eKYC/ekyc_req" + in.getRrn() + ".xml");
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
