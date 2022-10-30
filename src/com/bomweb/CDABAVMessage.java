/**
 * 
 */
package com.bomweb;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.bomweb.model.OFFUSTransaction;
import com.bomweb.util.FIUtility;

/**
 * @author SACHIN
 *
 */
public class CDABAVMessage {

	public static String[] isoReqCDA(OFFUSTransaction offusTransaction, String uid) {
		try {
			String[] DE = new String[130];
			DE[1] = ((uid).length() < 10 ? "0" + (uid).length() : (uid).length()) + (uid);
			// DE[2] = offusTransaction.getProcessingCode();
			DE[2] = "210000";
			DE[3] = offusTransaction.getTransactionAmount();
			DE[6] = offusTransaction.getTransactionDateTime();
			DE[10] = offusTransaction.getStan();
			DE[11] = offusTransaction.getTransactionTime();
			DE[12] = offusTransaction.getTransactionDate();
			DE[17] = offusTransaction.getMerchantType();
			DE[21] = offusTransaction.getPosEntryMode();
			DE[24] = offusTransaction.getPosConditionCode();
			DE[31] = ((offusTransaction.getAiic()).length() < 10 ? "0" + (offusTransaction.getAiic()).length()
					: (offusTransaction.getAiic()).length()) + (offusTransaction.getAiic());
			DE[36] = offusTransaction.getRrnNo();
			DE[37] = offusTransaction.getStan();
			DE[40] = offusTransaction.getTerminalID();
//			DE[41] = offusTransaction.getCardAcceptorID();
			DE[41] = "BMU880000002888";
			DE[42] = offusTransaction.getCardAcceptorName();
//			DE[45] = FIUtility.addThreeZeroes(offusTransaction.getAgentsInformation())
//					+ offusTransaction.getAgentsInformation();
			DE[45] = "01518880001|0|0|02";
			DE[48] = offusTransaction.getCurrencyCode();
			DE[72] = date();
			DE[99] = (offusTransaction.getVersion().length() < 10 ? "0" + offusTransaction.getVersion().length()
					: offusTransaction.getVersion().length()) + offusTransaction.getVersion();
			DE[119] = FIUtility.addThreeZeroes(offusTransaction.getResAdditionalDataFT())
					+ offusTransaction.getResAdditionalDataFT();
			DE[122] = FIUtility.addThreeZeroes(offusTransaction.getHmac()) + offusTransaction.getHmac();
			// for (int i = 0; i < DE.length; i++)
			// if (DE[i] != null)
			// System.out.println("[" + (i + 1) + "] ---> " + DE[i]);
			return DE;
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}

	public static String[] isoReqBAV(OFFUSTransaction offusTransaction, String uid) {
		try {
			String[] DE = new String[130];
			DE[1] = ((uid).length() < 10 ? "0" + (uid).length() : (uid).length()) + (uid);
			DE[2] = offusTransaction.getProcessingCode();
			DE[6] = offusTransaction.getTransactionDateTime();
			DE[10] = offusTransaction.getStan();
			DE[11] = offusTransaction.getTransactionTime();
			DE[12] = offusTransaction.getTransactionDate();
			DE[17] = offusTransaction.getMerchantType();
			DE[21] = offusTransaction.getPosEntryMode();
			DE[24] = offusTransaction.getPosConditionCode();
			DE[31] = ((offusTransaction.getAiic()).length() < 10 ? "0" + (offusTransaction.getAiic()).length()
					: (offusTransaction.getAiic()).length()) + (offusTransaction.getAiic());
			DE[36] = offusTransaction.getRrnNo();
			DE[40] = offusTransaction.getTerminalID();
			DE[41] = offusTransaction.getCardAcceptorID();
			DE[45] = FIUtility.addThreeZeroes(offusTransaction.getAgentsInformation())
					+ offusTransaction.getAgentsInformation();
			DE[48] = offusTransaction.getCurrencyCode();
			DE[72] = date();
			DE[99] = (offusTransaction.getVersion().length() < 10 ? "0" + offusTransaction.getVersion().length()
					: offusTransaction.getVersion().length()) + offusTransaction.getVersion();
			DE[101] = "2807008001X009015" + offusTransaction.getRescardAcceptorID();
			DE[102] = DE[101];

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

	public static byte[] getCDARequest(OFFUSTransaction offusTransaction, String uid) {
		String MTI = "1200";
		String[] DE = null;
		DE = isoReqCDA(offusTransaction, uid);
		byte[] isoMessage = Build(DE, MTI);
		return isoMessage;
	}

	public static byte[] getBAVRequest(OFFUSTransaction offusTransaction, String uid) {
		String MTI = "1200";
		String[] DE = null;
		DE = isoReqBAV(offusTransaction, uid);
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
