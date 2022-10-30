package com.bomweb.encryption;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

/**
 * 
 * @author SACHIN
 *
 */
public class DESEncryptUtil {

	public static SecretKey readKey()
			throws IOException, InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException {
		String masterKey = "F4F7836BF1003BC258912FCEF4F3B305C0DF99A2C60E56A9";
		DESedeKeySpec keySpec = new DESedeKeySpec(hex2byte(masterKey));
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
		SecretKey key = keyFactory.generateSecret(keySpec);
		return key;
	}

	public static void encrypt(File inFile, File outFile) throws Exception {
		SecretKey key = readKey();
		final IvParameterSpec iv = new IvParameterSpec(hex2byte("0000000000000000"));
		Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, key, iv);
		FileInputStream in = new FileInputStream(inFile);
		byte[] b = new byte[(int) inFile.length()];
		in.read(b);
		in.close();
		byte[] doFinal = cipher.doFinal(b);
		FileOutputStream out = new FileOutputStream(outFile);
		out.write(doFinal);
		out.flush();
		out.close();
	}

	public static byte[] hex2byte(String str) {
		byte[] bytes = new byte[str.length() / 2];
		for (int i = 0; i < bytes.length; i++) {
			bytes[i] = (byte) Integer.parseInt(str.substring(2 * i, 2 * i + 2), 16);
		}
		return bytes;
	}
}
