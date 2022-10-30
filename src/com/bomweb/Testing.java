/**
 * 
 */
package com.bomweb;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author SACHIN
 *
 */
public class Testing {

	public static void main(String[] args) throws Exception {
		
		
		String str = createRRN("882012");
//		byte[] data = readBytesFromFile("E:\\req.txt");
//		byte[] str = Base64.encode(AESEncryption.encrypt(data));
//		System.out.println(new String(str));
//		AESEncryption.getEncryptValue("850923373783".getBytes());
		

		// String s= "01061777000000017771061";
		// char[] b= Hex.encodeHex(s.getBytes());
		// System.out.println(b);

//		String mini = "00100207002003UID0050021000635002/06 POS/D/5017000018 C     100.0002/06 POS/W/5017000018 D     100.0002/06 POS/D/5017000011 C     100.0002/06 POS/W/5017000011 D     100.0002/06 POS/D/5017000006 C     100.0002/06 POS/W/5017000006 D     100.0002/07 POS/D/5016000034 C     100.0002/06 POS/W/5016000034 D     100.0002/06 POS/D/NFTRF/9036 C     110.00                   Balance:+2356.25";
//
//		if (mini.length() > 31) {
//			String tt = mini.substring(23, 25);
//			tt = removeZero(tt);
//			String t = mini.substring(25, 28);
//			String l = mini.substring(28, 31);
//			String v1 = mini.substring(31, 66);
//			System.out.println(v1);
//			String v2 = mini.substring(66, 101);
//			System.out.println(v2);
//			String v3 = mini.substring(101, 136);
//			System.out.println(v3);
//			String v4 = mini.substring(136, 171);
//			System.out.println(v4);
//			String v5 = mini.substring(171, 206);
//			System.out.println(v5);
//			String v6 = mini.substring(206, 241);
//			System.out.println(v6);
//			String v7 = mini.substring(241, 276);
//			System.out.println(v7);
//			String v8 = mini.substring(276, 311);
//			System.out.println(v8);
//			String v9 = mini.substring(311, 346);
//			System.out.println(v9);
//			String v10 = mini.substring(346, 381);
//			System.out.println(v10);
//			l = removeZero(l);
//			System.out.println(l);
//		}

	}

	private static String GetStr(byte[] iso, int startPos, int lengthStr) {
		byte[] sr = new byte[lengthStr];
		try {

			System.arraycopy(iso, startPos, sr, 0, lengthStr);
		} catch (Exception ex) {
			ex.printStackTrace();
			sr = new byte[0];
		}
		String string = new String(sr);
		System.out.println(string);
		return string;

	}

	public static String removeZero(String str) {
		// Count leading zeros
		int i = 0;
		while (i < str.length() && str.charAt(i) == '0')
			i++;

		// Convert str into StringBuffer as Strings
		// are immutable.
		StringBuffer sb = new StringBuffer(str);

		// The StringBuffer replace function removes
		// i characters from given index (0 here)
		sb.replace(0, i, "");

		return sb.toString(); // return in String
	}
	// System.out.println(new String(b, "UTF8"));

	// RupayIn in = new RupayIn();
	// in.setAmount("00");
	// in.setPan("6521550002710607");
	// in.setProcessingCode("310001");
	// String stan = "88" + get4Digits();
	// in.setRrn(createRRN(stan));
	// in.setTerminalID("00002888");
	// byte[] request = ISO8583_Rupay.createISO(in);
	//
	// OutputStream os = new FileOutputStream("E://rupay.txt");
	// os.write(request);
	// os.close();
	//
	// Socket s = new Socket("125.17.112.254",7086);
	// OutputStream out = s.getOutputStream();
	//
	//// out.writeInt(request.length); // write length of the message
	// out.write(request);
	//
	// BufferedReader br= new BufferedReader(new
	// InputStreamReader(s.getInputStream()));
	// String response = br.readLine();
	// System.out.println("Response : "+response);
	// s.close();
	// }

	public static String removeLeadingZeroes(String value) {
		while (value.length() > 1 && value.indexOf("0") == 0)
			value = value.substring(1);
		return value;
	}
	
	public static String createRRN(String stan) {
		StringBuilder rrn = new StringBuilder();
		Date now = new Date();
		String date = now.toString();
		SimpleDateFormat dateFormat = new SimpleDateFormat("DDD");
		rrn.append(date.substring(date.length() - 1, date.length()));
		SimpleDateFormat df = new SimpleDateFormat("HH");
		Calendar calobj = Calendar.getInstance();
		rrn.append(dateFormat.format(now));
		rrn.append(df.format(calobj.getTime()));
		rrn.append(stan);
		return rrn.toString();
	}

	public static String get4Digits() {
		long timeSeed = System.nanoTime();
		double randSeed = Math.random() * 1000; // random number generation
		long midSeed = (long) (timeSeed * randSeed);
		String s = midSeed + "";
		String subStr = s.substring(0, 4);
		return subStr;
	}

	public static final int TEST_TYPE_1 = 0x01;
	public static final int TEST_TYPE_2 = 0x02;
	public static final int TEST_TYPE_3 = 0x03;
	public static final int TEST_TYPE_4 = 0x04;
	public static final int TEST_TYPE_5 = 0x05;
	public static final int TEST_TYPE_6 = 0x06;
	public static final int TEST_TYPE_7 = 0x07;
	public static final int TEST_TYPE_8 = 0x08;
	public static final int TEST_TYPE_9 = 0x09;

	// public static void main(String args[]) {
	//
	// TLV box = new TLV();
	// box.putByteValue(TEST_TYPE_1, (byte)1);
	// box.putShortValue(TEST_TYPE_2, (short)2);
	// box.putIntValue(TEST_TYPE_3, (int)3);
	// box.putLongValue(TEST_TYPE_4, (long)4);
	// box.putFloatValue(TEST_TYPE_5, (float)5.67);
	// box.putDoubleValue(TEST_TYPE_6, (double)8.91);
	// box.putStringValue(TEST_TYPE_7, "hello world !");
	// box.putBytesValue(TEST_TYPE_8, new byte[] {1,2,3,4,5,6} );
	//
	// TLV boxes = new TLV();
	// boxes.putObjectValue(TEST_TYPE_9, box);
	//
	// byte[] serialized = boxes.serialize();
	//
	// TLV parsedBox = TLV.parse(serialized, 0, serialized.length);
	// TLV parsedObject = parsedBox.getObjectValue(TEST_TYPE_9);
	//
	// System.out.println("TEST_TYPE_1: " + parsedObject.getByteValue(TEST_TYPE_1));
	// System.out.println("TEST_TYPE_2: " +
	// parsedObject.getShortValue(TEST_TYPE_2));
	// System.out.println("TEST_TYPE_3: " + parsedObject.getIntValue(TEST_TYPE_3));
	// System.out.println("TEST_TYPE_4: " + parsedObject.getLongValue(TEST_TYPE_4));
	// System.out.println("TEST_TYPE_5: " +
	// parsedObject.getFloatValue(TEST_TYPE_5));
	// System.out.println("TEST_TYPE_6: " +
	// parsedObject.getDoubleValue(TEST_TYPE_6));
	// System.out.println("TEST_TYPE_7: " +
	// parsedObject.getStringValue(TEST_TYPE_7));
	//
	// byte[] bytes = parsedObject.getBytesValue(TEST_TYPE_8);
	// for (byte value : bytes) {
	// System.out.println("TEST_TYPE_8: " + value);
	// }
	// }

	public static void split(String str) {
		int len = str.length();

		// if there is only 1 number
		// in the string then
		// it is not possible to split it
		if (len == 1) {
			System.out.println("Not Possible");
			return;
		}

		String s1 = "", s2 = "";
		long num1, num2;

		for (int i = 0; i <= len / 2; i++) {

			int flag = 0;

			// storing the substring from
			// 0 to i+1 to form initial
			// number of the increasing sequence
			s1 = str.substring(0, i + 1);
			num1 = Long.parseLong((s1));
			num2 = num1 + 1;

			// convert string to integer
			// and add 1 and again convert
			// back to string s2
			s2 = Long.toString(num2);
			int k = i + 1;
			while (flag == 0) {
				int l = s2.length();

				// if s2 is not a substring
				// of number than not possile
				if (k + l > len) {
					flag = 1;
					break;
				}

				// if s2 is the next substring
				// of the numeric string
				if ((str.substring(k, k + l).equals(s2))) {
					flag = 0;

					// Incearse num2 by 1 i.e the
					// next number to be looked for
					num2++;
					k = k + l;

					// check if string is fully
					// traversed then break
					if (k == len)
						break;
					s2 = Long.toString(num2);
					l = s2.length();
					if (k + 1 > len) {

						// If next string doesnot occurs
						// in a given numeric string
						// then it is not possible
						flag = 1;
						break;
					}
				}

				else
					flag = 1;
			}

			// if the string was fully traversed
			// and conditions were satisfied
			if (flag == 0) {
				System.out.println("Possible" + " " + s1);
				break;
			}

			// if conditions failed to hold
			else if (flag == 1 && i > len / 2 - 1) {
				System.out.println("Not Possible");
				break;
			}
		}
	}

	
	private static byte[] readBytesFromFile(String filePath) {

        FileInputStream fileInputStream = null;
        byte[] bytesArray = null;

        try {

            File file = new File(filePath);
            bytesArray = new byte[(int) file.length()];

            //read file into bytes[]
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(bytesArray);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        return bytesArray;

    }
	
	
	
}
