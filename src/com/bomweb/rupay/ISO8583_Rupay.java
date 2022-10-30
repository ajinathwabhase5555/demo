/**
 * 
 */
package com.bomweb.rupay;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;

import com.bomweb.service.model.RupayIn;
import com.bomweb.util.FIUtility;

/**
 * @author SACHIN
 *
 */
public class ISO8583_Rupay {

	private static byte[] upto35;
	private static byte[] upto42;
	private static byte[] upto52;
	private static byte[] de103;

	public static byte[] createISO(RupayIn in) {
		try {
			String[] DE = new String[130];

			if (in.getProcessingCode().equals("920000")) {
				DE[2] = in.getProcessingCode();
				DE[10] = in.getRrn().substring(in.getRrn().length() - 6);
				DE[23] = "0000";
				upto35 = hexToByte(DE[2] + DE[10] + DE[23]);
				DE[40] = in.getTerminalID();
				DE[41] = "000000000000888";
				upto42 = (DE[40] + DE[41]).getBytes();

			} else {
				DE[1] = ((in.getPan()).length() < 10 ? "0" + (in.getPan()).length() : (in.getPan()).length())
						+ (in.getPan());
				DE[2] = in.getProcessingCode();
				DE[3] = FIUtility.addZero(in.getAmount() + "00", 12);
				DE[10] = in.getRrn().substring(in.getRrn().length() - 6);
				DE[21] = "0021";
				DE[23] = "0200";
				DE[24] = "00";
//				DE[34] = in.getTrackData(); // "376521550002710607D240322648200000000000";
				DE[34] = "374712878100864412D240322631100000000000";								
				upto35 = hexToByte(DE[1] + DE[2] + DE[3] + DE[10] + DE[21] + DE[23] + DE[24] + DE[34]);

				DE[40] = in.getTerminalID();
				DE[41] = "000000000000888";
				upto42 = (DE[40] + DE[41]).getBytes();

				DE[48] = "0356";
				DE[51] = in.getPinBlock(); // "C941EF000D0D7AFD";
				byte[] uptode52 = hexToByte(DE[48] + DE[51] + "11");

				if (in.getProcessingCode().equals("290001")) {
					DE[102] = "00000000000";
					de103 = DE[102].getBytes();
					ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
					try {
						outputStream.write(uptode52);
						outputStream.write(de103);
					} catch (IOException e) {
						e.printStackTrace();
					}
					upto52 = outputStream.toByteArray();
				} else if (in.getProcessingCode().equals("450001")) {
					DE[102] = in.getBeneficiaryAccNo(); // 60197138038
					de103 = DE[102].getBytes();
					ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
					try {
						outputStream.write(uptode52);
						outputStream.write(de103);
					} catch (IOException e) {
						e.printStackTrace();
					}
					upto52 = outputStream.toByteArray();
				} else {
					upto52 = uptode52;
				}
			}
			for (int i = 0; i < DE.length; i++)
				if (DE[i] != null)
					System.out.println("[" + (i + 1) + "] ---> " + DE[i]);

			byte[] isoMessage = Build(DE);
			OutputStream os = new FileOutputStream("E://rupay.txt");
			os.write(isoMessage);
			os.close();

			return isoMessage;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static byte[] Build(String[] DE) {
		String newISO = "";
		String newDE1 = "";
		for (int I = 1; I <= 63; I++) {
			if (DE[I] != null && !DE[I].trim().equals("")) {
				newDE1 += "1";
			} else {
				newDE1 += "0";
			}
		}
		if (DE[2].equals("290001") || DE[2].equals("450001")) {
			newDE1 = "1" + newDE1;
		} else {
			newDE1 = "0" + newDE1;
		}
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

		byte primary[] = null;
		String hexconString = getHexValue(newDE1).toUpperCase();
		if (DE[2].equals("290001") || DE[2].equals("450001")) {
			String hexconString2 = getHexValue(newDE2).toUpperCase();

			byte[] p = hexToByte(hexconString);
			byte[] s = hexToByte(hexconString2);

			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			try {
				outputStream.write(p);
				outputStream.write(s);
			} catch (IOException e) {
				e.printStackTrace();
			}
			primary = outputStream.toByteArray();
		} else {
			primary = hexToByte(hexconString);
		}
		byte[] mti = null;
		String length = null;

		byte[] lgthbyte = null;

		byte[] isomsg = null;
		if (DE[2].equals("920000")) {
			mti = hexToByte("0800");
			length = "600526018A";
			lgthbyte = hexToByte(length);
			isomsg = new byte[lgthbyte.length + mti.length + primary.length + upto35.length + upto42.length];
			System.arraycopy(lgthbyte, 0, isomsg, 0, lgthbyte.length);
			System.arraycopy(mti, 0, isomsg, lgthbyte.length, mti.length);
			System.arraycopy(primary, 0, isomsg, (lgthbyte.length + mti.length), primary.length);
			System.arraycopy(upto35, 0, isomsg, (lgthbyte.length + mti.length + primary.length), upto35.length);
			System.arraycopy(upto42, 0, isomsg, (lgthbyte.length + mti.length + primary.length + upto35.length),
					upto42.length);
		} else {
			mti = hexToByte("0200");
			length = "600526018A";
			lgthbyte = hexToByte(length);
			isomsg = new byte[lgthbyte.length + mti.length + primary.length + upto35.length + upto42.length
					+ upto52.length];
			System.arraycopy(lgthbyte, 0, isomsg, 0, lgthbyte.length);
			System.arraycopy(mti, 0, isomsg, lgthbyte.length, mti.length);
			System.arraycopy(primary, 0, isomsg, (lgthbyte.length + mti.length), primary.length);
			System.arraycopy(upto35, 0, isomsg, (lgthbyte.length + mti.length + primary.length), upto35.length);
			System.arraycopy(upto42, 0, isomsg, (lgthbyte.length + mti.length + primary.length + upto35.length),
					upto42.length);
			System.arraycopy(upto52, 0, isomsg,
					(lgthbyte.length + mti.length + primary.length + upto35.length + upto42.length), upto52.length);
		}

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try {
			String len = Integer.toHexString(isomsg.length);
			len = "00" + len;
			outputStream.write(hexToByte(len));
			outputStream.write(isomsg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] request = outputStream.toByteArray();
		return request;
	}

	public static String getHexValue(String cellValue) {
		BigInteger b = new BigInteger(cellValue, 2);
		String str = b.toString(16);
		while (str.length() < 16) {
			str = "0" + str;
		}
		return str;

	}

	public static byte[] hexToByte(String s) {
		int len = s.length();
		byte[] data = new byte[len / 2];
		for (int i = 0; i < len; i += 2) {
			data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
		}
		return data;
	}
}
