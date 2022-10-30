package com.bomweb.util;

import java.security.spec.KeySpec;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 * A utility class to create SHA-256 hashes
 * 
 * @author sachin
 *
 */
public class HashGenerator {
	public static String hashing(String data, String salt) {
//		int iterations = 250000;
		int iterations = 50;
		String hash = "";
		SecretKeyFactory factory;
		try {
			factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			char[] passwordChars = data.toCharArray();
			KeySpec spec = new PBEKeySpec(passwordChars, salt.getBytes(), iterations, 256);
			SecretKey key = factory.generateSecret(spec);
			byte[] b = key.getEncoded();
			hash = bytArrayToHex(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hash;
	}

	static String bytArrayToHex(byte[] a) {
		StringBuilder sb = new StringBuilder();
		for (byte b : a)
			sb.append(String.format("%02x", b & 0xff));
		return sb.toString();
	}

}
