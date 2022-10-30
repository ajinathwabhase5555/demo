/**
 * 
 */
package com.bomweb.encryption;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @author SACHIN
 *
 */

import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.paddings.PKCS7Padding;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

public class AESEncryption {

	public static SecretKey readKey()
			throws IOException, InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException {
		String masterKey = "424f4d5f46495f4b494f534b5f504f53424f4d5f46495f4b494f534b5f504f53";
		DESedeKeySpec keySpec = new DESedeKeySpec(hex2byte(masterKey));
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
		SecretKey key = keyFactory.generateSecret(keySpec);
		return key;
	}

	/*public static byte[] getKey() {
		 byte[] skey = null;
		try {
			KeyGenerator keygen = KeyGenerator.getInstance("AES", "BC");
			keygen.init(256);
			SecretKey key = keygen.generateKey();
			skey = sessionKey.getEncoded();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return key;
	}*/

	public static byte[] encrypt(byte[] isoMsg) throws Exception {

		byte[] uid = "850923373783".getBytes();
//		SecretKey key = readKey();
		// Get Cipher Instance
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

		// Create SecretKeySpec
		SecretKeySpec keySpec = new SecretKeySpec(hex2byte("424f4d5f46495f4b494f534b5f504f53424f4d5f46495f4b494f534b5f504f53"), "AES");

		// Create IvParameterSpec
		IvParameterSpec ivSpec = new IvParameterSpec(hex2byte("30303030303030303030303030303030"));

		// Initialize Cipher for ENCRYPT_MODE
		cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);

		// Perform Encryption
		byte[] cipherText = cipher.doFinal(uid);

		return cipherText;
	}
	
	public static byte[] getEncryptValue(final byte[] biometric) {
		try {
			
			KeyParameter keypar = new KeyParameter(hex2byte("424f4d5f46495f4b494f534b5f504f53424f4d5f46495f4b494f534b5f504f53"));
			ParametersWithIV keyIV = new ParametersWithIV(keypar, hex2byte("30303030303030303030303030303030"));
			PaddedBufferedBlockCipher cipher = new PaddedBufferedBlockCipher(
					new AESEngine(), new PKCS7Padding());
			
			cipher.init(true, keyIV);

			int outputSize = cipher.getOutputSize(biometric.length);

			byte[] tempOP = new byte[outputSize];
			int processLen = cipher.processBytes(biometric, 0,
					biometric.length, tempOP, 0);
			int outputLen = cipher.doFinal(tempOP, processLen);

			byte[] result = new byte[processLen + outputLen];
			System.arraycopy(tempOP, 0, result, 0, result.length);
			System.out.println(new String(result));
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * public static String decrypt(byte[] cipherText, SecretKey key, byte[] IV)
	 * throws Exception { // Get Cipher Instance Cipher cipher =
	 * Cipher.getInstance("AES/CBC/PKCS5Padding");
	 * 
	 * // Create SecretKeySpec SecretKeySpec keySpec = new
	 * SecretKeySpec(key.getEncoded(), "AES");
	 * 
	 * // Create IvParameterSpec IvParameterSpec ivSpec = new
	 * IvParameterSpec(hex2byte("0000000000000000"));
	 * 
	 * // Initialize Cipher for DECRYPT_MODE cipher.init(Cipher.DECRYPT_MODE,
	 * keySpec, ivSpec);
	 * 
	 * // Perform Decryption byte[] decryptedText = cipher.doFinal(cipherText);
	 * 
	 * return new String(decryptedText); }
	 */

	public static byte[] hex2byte(String str) {
		byte[] bytes = new byte[str.length() / 2];
		for (int i = 0; i < bytes.length; i++) {
			bytes[i] = (byte) Integer.parseInt(str.substring(2 * i, 2 * i + 2), 16);
		}
		System.out.println("Value : "+ new String(bytes));
		return bytes;
	}
}
