/**
 * 
 */
package com.bomweb.rupay;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;

import com.bomweb.model.RupayModel;

/**
 * @author SACHIN
 *
 */
public class RupayReversal {

	private static byte[] upto35;
	private static byte[] upto42;
	private static byte[] upto90;

	public static byte[] createISO(RupayModel in) {
		try {
			String[] DE = new String[130];

			DE[1] = ((in.getPan()).length() < 10 ? "0" + (in.getPan()).length() : (in.getPan()).length())
					+ (in.getPan());
			DE[2] = in.getProcessingCode();
			DE[3] = in.getTransactionAmount();
			DE[10] = in.getRrn().substring(in.getRrn().length() - 6);
			DE[21] = "0021";
			DE[23] = "0200";
			DE[24] = "00";
			upto35 = hexToByte(DE[1] + DE[2] + DE[3] + DE[10] + DE[21] + DE[23] + DE[24] + DE[34]);

			DE[40] = in.getTerminalId();
			DE[41] = "000000000000888";
			upto42 = (DE[40] + DE[41]).getBytes();

			DE[48] = "0356";
			DE[61] = "006006110";
			DE[89] = "";
			upto90 = hexToByte(DE[48] + DE[51] + DE[61] + DE[89]);

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
					+ upto90.length];
			System.arraycopy(lgthbyte, 0, isomsg, 0, lgthbyte.length);
			System.arraycopy(mti, 0, isomsg, lgthbyte.length, mti.length);
			System.arraycopy(primary, 0, isomsg, (lgthbyte.length + mti.length), primary.length);
			System.arraycopy(upto35, 0, isomsg, (lgthbyte.length + mti.length + primary.length), upto35.length);
			System.arraycopy(upto42, 0, isomsg, (lgthbyte.length + mti.length + primary.length + upto35.length),
					upto42.length);
			System.arraycopy(upto90, 0, isomsg,
					(lgthbyte.length + mti.length + primary.length + upto35.length + upto42.length), upto90.length);
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
