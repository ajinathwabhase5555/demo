package com.bomweb.ekyc;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.bomweb.service.model.EKycRequest;
import com.bomweb.util.FIUtility;

public class EKYC_ISO8583 {

	// method for building data element ....ISO8583 message
	public static String createISO(EKycRequest in) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("MMddHHmmss");
			String dateTime = dateFormat.format(new Date());
			Date date = new Date();
			dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

			String[] DE = new String[130];
			DE[1] = ((in.getDe2()).length() < 10 ? "0" + (in.getDe2()).length() : (in.getDe2()).length())
					+ (in.getDe2());
			DE[2] = in.getDe3();
			DE[3] = in.getDe4();
			DE[6] = dateFormat.format(date);
			DE[10] = in.getDe37().substring(in.getDe37().length() - 6);;
			DE[11] = dateTime.substring(4);
			DE[12] = dateTime.substring(0, 4);
			DE[16] = dateTime.substring(0, 4);
			DE[17] = "6012";
			DE[21] = "019";
			DE[24] = "05";
			DE[31] = (("200015".length() < 10 ? "0" + ("200015").length() : ("200015").length()) + ("200015"));
			DE[36] = in.getDe37();
			DE[40] = FIUtility.rightPaddedValue(in.getDe41(), 16);
			DE[41] = "BMU088800002888";
			DE[42] = in.getDe43();
			DE[45] = FIUtility.addThreeZeroes(in.getDe46()) + in.getDe46();
			DE[48] = "INR";
			DE[72] = date();
			DE[99] = ("1.8".length() < 10 ? "0" + "1.8".length() : "1.8".length()) + "1.8";

			String xmlData = in.getDe63();
			if (xmlData.length() > 992) {
				DE[111] = "999" + xmlData.substring(0, 999);
				String bio2 = xmlData.substring(999,1998);
				DE[112] = FIUtility.addThreeZeroes(bio2) + bio2;
				String bio3 = xmlData.substring(1998,2997);
				DE[113] = FIUtility.addThreeZeroes(bio3) + bio3;
				String bio4 = xmlData.substring(2997);
				DE[114] = FIUtility.addThreeZeroes(bio4) + bio4;
//				String bio5 = xmlData.substring(3997);
//				DE[114] = FIUtility.addThreeZeroes(bio5) + bio5;
			} 
			
//			for (int i = 0; i < DE.length; i++)
//				if (DE[i] != null)
//					System.out.println("[" + (i + 1) + "] ---> " + DE[i]);

			String isoMessage = Build(DE);
			return isoMessage;
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}

	private static String date() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyMMdd");
		String strDate = formatter.format(date);
		return strDate;
	}

	private static String Build(String[] DE) {
		String newISO = "";
		String newDE1 = "";
		for (int I = 1; I <= 63; I++) {
			if (DE[I] != null && !DE[I].trim().equals("")) {
				newDE1 += "1";
			} else {
				newDE1 += "0";
			}
		}
		newDE1 = "1" + newDE1;
		String newDE2 = "";

		for (int i = 64; i <= 127; i++) {
			if (DE[i] != null) {
				newDE2 = newDE2 + "1";
			} else {
				newDE2 = newDE2 + "0";
			}
		}
		newDE2 = "0" + newDE2;
		for (String str : DE) {
			if (str != null) {
				newISO = newISO + str;
			}
		}

		String hexconString = getHexValue(newDE1).toUpperCase();
		String hexconString2 = getHexValue(newDE2).toUpperCase();
		newISO = hexconString + hexconString2 + newISO;
		newISO = Integer.toString(("1200" + newISO).length()) + "1200" + newISO;
		return newISO;
	}

	public static String getHexValue(String cellValue) {
		BigInteger b = new BigInteger(cellValue, 2);
		String str = b.toString(16);
		while (str.length() < 16) {
			str = "0" + str;
		}
		return str;

	}

}