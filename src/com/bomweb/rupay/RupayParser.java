package com.bomweb.rupay;

/**
 * @author SACHIN
 *
 */
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class RupayParser {
	static Log log = LogFactory.getLog(RupayParser.class);

	private static int fieldNo = 0;
	private static String de2Binary = "";
	static String[] DE;

	public static String[] parseMsg(byte[] ISOmsg) {
		try {
			DE = new String[130];

			String de1Binary = "";

			int myPos = 0;
			int myLenght = 0;
			int len = 0;
			myPos = 4;
			myLenght = 4;

			String MTI = GetStr(ISOmsg, myPos, myLenght);
			// ========BM 129 is the MTI============
			fieldNo = 129;
			DE[fieldNo] = MTI;
			// ========================================
			// Get BitMap 1a
			myPos += myLenght;
			myLenght = 16;
			DE[0] = GetStr(ISOmsg, myPos, myLenght);
			// Convert BM0 to Binary
			de1Binary = hexToBin(new String(DE[0]));

			fieldNo = 1;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 16;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
				de2Binary = hexToBin(new String(DE[fieldNo]));
				DE[0] = de1Binary + de2Binary;
			}

			fieldNo = 2;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = Integer.parseInt(GetStr(ISOmsg, myPos, 2));
				myPos += 2;
				String aadhaarNo = GetStr(ISOmsg, myPos, myLenght).substring(0, 7);
				aadhaarNo = aadhaarNo + "XXXXXXXXXXXX";
				DE[fieldNo] = aadhaarNo;

			}

			fieldNo = 3;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 6;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 4;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 12;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 5;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 12;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 6;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 12;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 7;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 10;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 8;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 8;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 9;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 8;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 10;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 8;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 11;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 6;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 12;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 6;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 13;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 4;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 14;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 4;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 15;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 4;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 16;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 4;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 17;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 4;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 18;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 4;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 19;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 3;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 20;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 3;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 21;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 3;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 22;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 3;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 23;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 3;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 24;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 2;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 25;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 2;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 26;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 2;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 27;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 1;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 28;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 8;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 29;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 8;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 30;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 8;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 31;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 8;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 32;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = Integer.parseInt(GetStr(ISOmsg, myPos, 2));
				myPos += 2;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 33;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = Integer.parseInt(GetStr(ISOmsg, myPos, 2));
				myPos += 2;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 34;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = Integer.parseInt(GetStr(ISOmsg, myPos, 2));
				myPos += 2;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 35;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				len = 2;
				myLenght = Integer.parseInt(GetStr(ISOmsg, myPos, len));
				myPos += len;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 36;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				len = 3;
				myLenght = Integer.parseInt(GetStr(ISOmsg, myPos, len));
				myPos += len;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 37;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 12;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 38;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 6;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 39;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 2;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 40;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 3;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 41;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 8;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 42;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 15;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 43;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 40;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 44;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				len = 2;
				myLenght = Integer.parseInt(GetStr(ISOmsg, myPos, len));
				myPos += len;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 45;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				len = 2;
				myLenght = Integer.parseInt(GetStr(ISOmsg, myPos, len));
				myPos += len;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 46;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				len = 3;
				myLenght = Integer.parseInt(GetStr(ISOmsg, myPos, len));
				myPos += len;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 47;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				len = 3;
				myLenght = Integer.parseInt(GetStr(ISOmsg, myPos, len));
				myPos += len;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 48;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				len = 3;
				myLenght = Integer.parseInt(GetStr(ISOmsg, myPos, len));
				myPos += len;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 49;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 2;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 50;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 3;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 51;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 3;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 52;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 16;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 53;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 18;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 54;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				// len = 3;
				len = 2; // This is changed according to bank
				// myLenght = Integer.parseInt(GetStr(ISOmsg, myPos, len));
				myLenght = 20;
				myPos += len;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 55;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				len = 3;
				myLenght = Integer.parseInt(GetStr(ISOmsg, myPos, len));
				myPos += len;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 56;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				len = 3;
				myLenght = Integer.parseInt(GetStr(ISOmsg, myPos, len));
				myPos += len;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 57;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				len = 3;
				myLenght = Integer.parseInt(GetStr(ISOmsg, myPos, len));
				myPos += len;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 58;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				len = 3;
				myLenght = Integer.parseInt(GetStr(ISOmsg, myPos, len));
				myPos += len;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 59;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				len = 3;
				myLenght = Integer.parseInt(GetStr(ISOmsg, myPos, len));
				myPos += len;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 60;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				len = 1;
				myLenght = Integer.parseInt(GetStr(ISOmsg, myPos, len));
				myPos += len;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 61;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				len = 3;
				myLenght = Integer.parseInt(GetStr(ISOmsg, myPos, len));
				myPos += len;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 62;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				len = 3;
				myLenght = Integer.parseInt(GetStr(ISOmsg, myPos, len));
				myPos += len;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 63;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				len = 3;
				myLenght = Integer.parseInt(GetStr(ISOmsg, myPos, len));
				myPos += len;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 64;
			if (de1Binary.substring(fieldNo - 1, fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 4;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

//			log.info("DE[1] ------ " + DE[1]);
			for (int i = 2; i < 63; i++) {
				if (DE[i] != null)
					log.info("DE[" + i + "] ------ " + DE[i]);
			}
			return DE;
			// ==========================================

		} catch (NumberFormatException ex) {
			ex.printStackTrace();
			if (DE != null)
				for (int i = 0; i < 63; i++) {
					if (DE[i] != null)
						log.info("DE[" + i + "] ------ " + DE[i]);
				}
			return DE;
		} catch (Exception ex) {
			log.error("Error in DE " + ex);
			ex.printStackTrace();
			return null;
		}

	}

	// End Binary Parser
	private static String hexToBin(String hex) {
		String bin = "";
		String binFragment = "";
		int iHex;
		hex = hex.trim();
		hex = hex.replaceFirst("0x", "");

		for (int i = 0; i < hex.length(); i++) {
			iHex = Integer.parseInt("" + hex.charAt(i), 16);
			binFragment = Integer.toBinaryString(iHex);

			while (binFragment.length() < 4) {
				binFragment = "0" + binFragment;
			}
			bin += binFragment;
		}

		return bin;
	}

	private static String GetStr(byte[] iso, int startPos, int lengthStr) {
		byte[] sr = new byte[lengthStr];
		try {

			System.arraycopy(iso, startPos, sr, 0, lengthStr);

		} catch (Exception ex) {
			log.error("Exception in getstr " + ex);
			sr = new byte[0];
		}
		String string = new String(sr);
		return string;

	}

}
