package com.bomweb.util;

/**
 * @author SACHIN
 *
 */
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MessageParser {
	Log log = LogFactory.getLog(MessageParser.class);

	private int fieldNo = 0;
	private String de2Binary = "";
	String[] DE;

	public String[] parseAEPSMsg(byte[] ISOmsg, String txnType) {
		String rsp = new String(ISOmsg);
		try {
			DE = new String[130];

			String de1Binary = "";

			int myPos = 0;
			int myLenght = 0;
			int len = 0;
			// Get MTI
			if (txnType.equalsIgnoreCase("ekyc") && !rsp.startsWith("0") || rsp.startsWith("00"))
				myPos = 5;
			else
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
				String aadhaarNo = GetStr(ISOmsg, myPos, myLenght);
				String iin = aadhaarNo.substring(0, 7);
				aadhaarNo = aadhaarNo.substring(aadhaarNo.length() - 4);
				DE[fieldNo] = iin + "XXXXXXXX" + aadhaarNo;

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
				myLenght = 3;
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
				myLenght = 16;
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
				myLenght = 3;
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
				myLenght = Integer.parseInt(GetStr(ISOmsg, myPos, len));
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
			// ===CHECK POINT FOR BM# 65 to 128============
			if (de2Binary.toString() == null) {
				return DE;
			}
			// /<----IF DATA ELEMENT <= 64
			if (de2Binary == "0000000000000000000000000000000000000000000000000000000000000000") {
				return DE;
			}

			fieldNo = 65;
			if (de2Field(fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 16;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}
			
			fieldNo = 66;
			if (de2Field(fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 1;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}
			
			fieldNo = 67;
			if (de2Field(fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 2;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}
			
			fieldNo = 68;
			if (de2Field(fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 3;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}
			
			fieldNo = 69;
			if (de2Field(fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 3;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}
			
			fieldNo = 70;
			if (de2Field(fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 3;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}
			
			fieldNo = 71;
			if (de2Field(fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 4;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 72;
			if (de2Field(fieldNo).equals("1")) {
				myPos += myLenght;
				len = 3;
				myLenght = Integer.parseInt(GetStr(ISOmsg, myPos, len));
				myPos += len;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 73;
			if (de2Field(fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 6;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}
			
			fieldNo = 74;
			if (de2Field(fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 10;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 75;
			if (de2Field(fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 10;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 76;
			if (de2Field(fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 10;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 77;
			if (de2Field(fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 10;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 78;
			if (de2Field(fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 10;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 79;
			if (de2Field(fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 10;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 80;
			if (de2Field(fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 10;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 81;
			if (de2Field(fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 10;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 82;
			if (de2Field(fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 12;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 83;
			if (de2Field(fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 12;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 84;
			if (de2Field(fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 12;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 85;
			if (de2Field(fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 12;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 86;
			if (de2Field(fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 15;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 87;
			if (de2Field(fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 15;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 88;
			if (de2Field(fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 15;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 89;
			if (de2Field(fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 15;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 90;
			if (de2Field(fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 42;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 91;
			if (de2Field(fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 1;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 92;
			if (de2Field(fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 2;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 93;
			if (de2Field(fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 5;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 94;
			if (de2Field(fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 7;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 95;
			if (de2Field(fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 42;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 96;
			if (de2Field(fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 8;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 97;
			if (de2Field(fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 16;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 98;
			if (de2Field(fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 25;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 99;
			if (de2Field(fieldNo).equals("1")) {
				myPos += myLenght;
				len = 2;
				myLenght = Integer.parseInt(GetStr(ISOmsg, myPos, len));
				myPos += len;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 100;
			if (de2Field(fieldNo).equals("1")) {
				myPos += myLenght;
				len = 2;
				if (Integer.parseInt(GetStr(ISOmsg, myPos, len)) > 10) {
					len = 1;
				}

				myLenght = Integer.parseInt(GetStr(ISOmsg, myPos, len));
				myPos += len;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 101;
			if (de2Field(fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 17;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 102;
			if (de2Field(fieldNo).equals("1")) {
				myPos += myLenght;
				len = 2;
				myLenght = Integer.parseInt(GetStr(ISOmsg, myPos, len));
				myPos += len;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 103;
			if (de2Field(fieldNo).equals("1")) {
				myPos += myLenght;
				len = 2;
				myLenght = Integer.parseInt(GetStr(ISOmsg, myPos, len));
				myPos += len;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 104;
			if (de2Field(fieldNo).equals("1")) {
				myPos += myLenght;
				len = 3;
				myLenght = Integer.parseInt(GetStr(ISOmsg, myPos, len));
				myPos += len;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 105;
			if (de2Field(fieldNo).equals("1")) {
				myPos += myLenght;
				len = 3;
				myLenght = Integer.parseInt(GetStr(ISOmsg, myPos, len));
				myPos += len;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 106;
			if (de2Field(fieldNo).equals("1")) {
				myPos += myLenght;
				len = 3;
				myLenght = Integer.parseInt(GetStr(ISOmsg, myPos, len));
				myPos += len;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 107;
			if (de2Field(fieldNo).equals("1")) {
				myPos += myLenght;
				len = 3;
				myLenght = Integer.parseInt(GetStr(ISOmsg, myPos, len));
				myPos += len;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 108;
			if (de2Field(fieldNo).equals("1")) {
				myPos += myLenght;
				len = 3;
				myLenght = Integer.parseInt(GetStr(ISOmsg, myPos, len));
				myPos += len;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 109;
			if (de2Field(fieldNo).equals("1")) {
				myPos += myLenght;
				len = 3;
				myLenght = Integer.parseInt(GetStr(ISOmsg, myPos, len));
				myPos += len;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 110;
			if (de2Field(fieldNo).equals("1")) {
				myPos += myLenght;
				len = 3;
				myLenght = Integer.parseInt(GetStr(ISOmsg, myPos, len));
				myPos += len;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 111;
			if (de2Field(fieldNo).equals("1")) {
				myPos += myLenght;
				len = 3;
				myLenght = Integer.parseInt(GetStr(ISOmsg, myPos, len));
				myPos += len;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 112;
			if (de2Field(fieldNo).equals("1")) {
				// Changed for ekyc ... previous value
				myPos += myLenght;
				if (txnType.equalsIgnoreCase("eKyc")) {
					myPos += 3;
					len = 6;
				} else
					len = 3;
				myLenght = Integer.parseInt(GetStr(ISOmsg, myPos, len));
				System.out.println(myLenght);
				myPos += len;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 113;
			if (de2Field(fieldNo).equals("1")) {
				myPos += myLenght;
				len = 3; // changed according to BFD for BOM myLenght =
				Integer.parseInt(GetStr(ISOmsg, myPos, len));
				myPos += len;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 114;
			if (de2Field(fieldNo).equals("1")) {
				myPos += myLenght;
				len = 3;
				myLenght = Integer.parseInt(GetStr(ISOmsg, myPos, len));
				myPos += len;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 115;
			if (de2Field(fieldNo).equals("1")) {
				myPos += myLenght;
				len = 3;
				myLenght = Integer.parseInt(GetStr(ISOmsg, myPos, len));
				myPos += len;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 116;
			if (de2Field(fieldNo).equals("1")) {
				myPos += myLenght;
				len = 3;
				myLenght = Integer.parseInt(GetStr(ISOmsg, myPos, len));
				myPos += len;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 117;
			if (de2Field(fieldNo).equals("1")) {
				myPos += myLenght;
				len = 3;
				myLenght = Integer.parseInt(GetStr(ISOmsg, myPos, len));
				myPos += len;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 118;
			if (de2Field(fieldNo).equals("1")) {
				myPos += myLenght;
				len = 3;
				myLenght = Integer.parseInt(GetStr(ISOmsg, myPos, len));
				myPos += len;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 119;
			if (de2Field(fieldNo).equals("1")) {
				myPos += myLenght;
				len = 3;
				myLenght = Integer.parseInt(GetStr(ISOmsg, myPos, len));
				myPos += len;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 120;
			if (de2Field(fieldNo).equals("1")) {
				myPos += myLenght;
				len = 3;
				myLenght = Integer.parseInt(GetStr(ISOmsg, myPos, len));
				myPos += len;
				if (DE[3].equals("400000")) {
					String beneficiary = GetStr(ISOmsg, myPos, myLenght);
					beneficiary = beneficiary.substring(0, beneficiary.length() - 12);
					beneficiary = beneficiary + "XXXXXXXX";
					DE[fieldNo] = beneficiary;
				} else {
					DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
				}
			}

			fieldNo = 121;
			if (de2Field(fieldNo).equals("1")) {
				myPos += myLenght;
				len = 3;
				myLenght = Integer.parseInt(GetStr(ISOmsg, myPos, len));
				myPos += len;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 122;
			if (de2Field(fieldNo).equals("1")) {
				myPos += myLenght;
				len = 3;
				myLenght = Integer.parseInt(GetStr(ISOmsg, myPos, len));
				myPos += len;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 123;
			if (de2Field(fieldNo).equals("1")) {
				myPos += myLenght;
				len = 3;
				myLenght = Integer.parseInt(GetStr(ISOmsg, myPos, len));
				myPos += len;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 124;
			if (de2Field(fieldNo).equals("1")) {
				myPos += myLenght;
				len = 3;
				myLenght = Integer.parseInt(GetStr(ISOmsg, myPos, len));
				myPos += len;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 125;
			if (de2Field(fieldNo).equals("1")) {
				myPos += myLenght;
				len = 2;
				myLenght = Integer.parseInt(GetStr(ISOmsg, myPos, len));
				myPos += len;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);

			}

			fieldNo = 126;
			if (de2Field(fieldNo).equals("1")) {
				myPos += myLenght;
				len = 3;
				myLenght = Integer.parseInt(GetStr(ISOmsg, myPos, len));
				myPos += len;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 127;
			if (de2Field(fieldNo).equals("1")) {
				myPos += myLenght;
				len = 3;
				myLenght = Integer.parseInt(GetStr(ISOmsg, myPos, len));
				myPos += len;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}

			fieldNo = 128;
			if (de2Field(fieldNo).equals("1")) {
				myPos += myLenght;
				myLenght = 4;
				DE[fieldNo] = GetStr(ISOmsg, myPos, myLenght);
			}
			// -------------------------------------------------
			log.info("DE[1] ------ " + DE[1]);
			for (int i = 2; i < 128; i++) {
				if (i != 111 && i != 112 && i != 113 && i != 114 && i != 115 && i != 116 && i != 117 && i != 118
						&& i != 119)
					if (DE[i] != null)
						log.info("DE[" + i + "] ------ " + DE[i]);
			}
			return DE;
			// ==========================================

		} catch (NumberFormatException ex) {
			ex.printStackTrace();
			if (DE != null)
				for (int i = 0; i < 128; i++) {
					if (i != 111 && i != 112 && i != 113 && i != 114 && i != 115 && i != 116 && i != 117 && i != 118
							&& i != 119)
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
	private String hexToBin(String hex) {
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

	private String GetStr(byte[] iso, int startPos, int lengthStr) {
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

	private String de2Field(int i) {
		return de2Binary.substring(i - 64 - 1, i - 64);
	}

}
