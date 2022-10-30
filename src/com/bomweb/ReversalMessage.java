/**
 * 
 */
package com.bomweb;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.bomweb.model.ReversalRequest;
import com.bomweb.util.FIUtility;

/**
 * @author SACHIN
 *
 */
public class ReversalMessage {

	// method for building data element ....Reversal message
	public static String[] getReversal(ReversalRequest reversalRequest) {
		try {
			String[] DE = new String[130];
			DE[1] = ((reversalRequest.getPrimaryAccountNumber()).length() < 10
					? "0" + (reversalRequest.getPrimaryAccountNumber()).length()
					: (reversalRequest.getPrimaryAccountNumber()).length())
					+ (reversalRequest.getPrimaryAccountNumber());
			DE[2] = reversalRequest.getProcessingCode();
			DE[3] = reversalRequest.getTransactionAmount();
			DE[6] = reversalRequest.getTransactionDateTime();
			DE[10] = reversalRequest.getStan();
			DE[11] = reversalRequest.getLocalTransactionTime();
			DE[12] = reversalRequest.getLocalTransactionDate();
			DE[16] = reversalRequest.getLocalTransactionDate();
			DE[17] = reversalRequest.getMerchantType();
			DE[21] = reversalRequest.getPoshEntryMode();
			DE[24] = reversalRequest.getPoshConditionCode();
			DE[31] = ((reversalRequest.getAiic()).length() < 10 ? "0" + (reversalRequest.getAiic()).length()
					: (reversalRequest.getAiic()).length()) + (reversalRequest.getAiic());
			DE[36] = reversalRequest.getRrn();
			DE[40] = reversalRequest.getTerminalId();
			DE[41] = reversalRequest.getVendorCode();
			DE[42] = reversalRequest.getBcDetails();
			DE[45] = FIUtility.addThreeZeroes(reversalRequest.getAgentDetails()) + reversalRequest.getAgentDetails();
			DE[48] = reversalRequest.getCurrencyCode();
			DE[72] = date(); // in.getRrn().substring(in.getRrn().length() - 6)
			String time = DE[6].substring(DE[6].length() - 6);
			DE[89] = "0420" + reversalRequest.getRrn() + DE[12] + time +"607387          ";
			DE[99] = (reversalRequest.getVersion().length() < 10 ? "0" + reversalRequest.getVersion().length()
					: reversalRequest.getVersion().length()) + reversalRequest.getVersion();
			if (DE[2].equals("400000"))
				DE[119] = reversalRequest.getDe120();

			// for (int i = 0; i < DE.length; i++)
			// if (DE[i] != null)
			// System.out.println("[" + (i + 1) + "] ---> " + DE[i]);
			return DE;
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

	public static byte[] getReversalTrans(ReversalRequest reversalRequest) {
		String MTI = "0420";
		String[] DE = null;
		DE = getReversal(reversalRequest);
		byte[] isoMessage = Build(DE, MTI);
		return isoMessage;
	}

	private static byte[] Build(String[] DE, String MTI) {
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
		int len = MTI.length() + newISO.length();
		String totalLen = FIUtility.addZero(Integer.toString(len), 4);
		newISO = totalLen + MTI + newISO;
		return newISO.getBytes();
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
