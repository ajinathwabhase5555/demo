package com.bomweb.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author SACHIN
 *
 */
public class FIUtility {

	public static String rightPaddedValue(String value, int length) {
		while (value.length() < length) {
			value = value + " ";
		}
		return value;
	}

	public static String leftPaddedValue(String value, int length) {
		while (value.length() < length) {
			value = " " + value;
		}
		return value;
	}

	public static String get4Digits() {
		long timeSeed = System.nanoTime();
		double randSeed = Math.random() * 1000; // random number generation
		long midSeed = (long) (timeSeed * randSeed);
		String s = midSeed + "";
		String subStr = s.substring(0, 4);
		return subStr;
	}

	public static String addThreeZeroes(String value) {
		String str = value.length() + "";
		if (value.length() < 10) {
			str = "00" + str;
		} else if (value.length() >= 10 && value.length() < 100) {
			str = "0" + str;
		}
		return str;
	}

	public static String addZero(String value, int length) {
		while (value.length() < length) {
			value = "0" + value;
		}
		return value;
	}
	
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
}
