package com.bomweb.encryption;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStore.PrivateKeyEntry;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.spec.InvalidParameterSpecException;
import java.util.Collection;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.paddings.PKCS7Padding;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.jce.provider.BouncyCastleProvider;


public class EncryptionBouncyCastle {
	private static final String ekycCertPath = "Auth_Benchmarking_server.cer";
	private static final int AES_KEY_SIZE = 256;
	private static File publicKeyFile;
	private byte[] aesKey;

	public EncryptionBouncyCastle() {
		publicKeyFile = new File(ekycCertPath);
	}

	public EncryptionBouncyCastle(String type) {
		publicKeyFile = new File(ekycCertPath);
	}

	public String getEncryptValue(final byte[] biometric) {
		try {
			String str = "";
			byte[] encryptedMessage;
			Security.addProvider(new BouncyCastleProvider());
			KeyGenerator keygen = KeyGenerator.getInstance("AES");
			keygen.init(AES_KEY_SIZE);
			SecretKey sessionKey = keygen.generateKey();
			aesKey = sessionKey.getEncoded();
			encryptedMessage = encryptUsingSessionKey(aesKey, biometric);
			str = new String(encryptedMessage);
			str = Base64.encodeBase64String(encryptedMessage);
			return str;

		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	public String getdDecryptetValue(final String data) {
		try {
			String str = "";
			byte[] encryptedMessage;
			Security.addProvider(new BouncyCastleProvider());
			InputStream in = new FileInputStream(publicKeyFile);
			CertificateFactory cf = CertificateFactory.getInstance("X.509");
			Collection<? extends Certificate> certs = cf
					.generateCertificates(in);
			in.close();
			Certificate x5092 = null;
			for (Certificate cert : certs) {
				x5092 = cert;
			}
			x5092.getPublicKey().getAlgorithm();
			aesKey = x5092.getPublicKey().getEncoded();
			System.out.println(aesKey.length);
			byte[] bytes = Base64.decodeBase64(data.getBytes());
			encryptedMessage = decryptUsingSessionKey(aesKey, bytes);
			str = new String(encryptedMessage);
			return str;

		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	public String rsaEncrypt() throws InvalidKeyException,
			NoSuchAlgorithmException, NoSuchPaddingException,
			IllegalBlockSizeException, BadPaddingException,
			CertificateException, IOException,
			InvalidAlgorithmParameterException, InvalidParameterSpecException,
			NoSuchProviderException, SignatureException {
		Cipher rsaCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		CertificateFactory cf = CertificateFactory.getInstance("X.509");

		InputStream in = new FileInputStream(publicKeyFile);
		Collection<? extends Certificate> certs = cf.generateCertificates(in);
		in.close();
		Certificate x5092 = null;
		for (Certificate cert : certs) {
			x5092 = cert;
		}
		rsaCipher.init(Cipher.ENCRYPT_MODE, x5092.getPublicKey());
		byte[] encryptedKey = rsaCipher.doFinal(aesKey);
		String string = Base64.encodeBase64String(encryptedKey);
		return string;
	}

	public byte[] decryptSessionKey(String keyStoreFile, char[] keyStorePassword,byte[] encryptedSecretKey) throws InvalidKeyException,
			NoSuchAlgorithmException, NoSuchPaddingException,
			IllegalBlockSizeException, BadPaddingException,
			CertificateException, IOException,
			InvalidAlgorithmParameterException, InvalidParameterSpecException,
			NoSuchProviderException, SignatureException {
		PrivateKeyEntry keyFromFile = getKeyFromFile(keyStoreFile, keyStorePassword);
		try {
			Cipher rsaCipher =Cipher.getInstance("RSA/ECB/PKCS1Padding");

			//PSource pSrc = (new PSource.PSpecified(iv));

//			rsaCipher.init(Cipher.DECRYPT_MODE, keyFromFile.getPrivateKey(),
//					new OAEPParameterSpec(DIGEST_ALGORITHM, MASKING_FUNCTION,
//							MGF1ParameterSpec.SHA256, pSrc));
			rsaCipher.init(Cipher.DECRYPT_MODE, keyFromFile.getPrivateKey());
			return rsaCipher.doFinal(encryptedSecretKey);
		} catch (Exception e) {
			e.printStackTrace();
			//throw new Exception("Failed to decrypt AES secret key using RSA.", e);
		}
		return null;
	}

	public byte[] encryptUsingSessionKey(byte[] skey, byte[] data)
			throws Exception {
		PaddedBufferedBlockCipher cipher = new PaddedBufferedBlockCipher(
				new AESEngine(), new PKCS7Padding());

		cipher.init(true, new KeyParameter(skey));

		int outputSize = cipher.getOutputSize(data.length);

		byte[] tempOP = new byte[outputSize];
		int processLen = cipher.processBytes(data, 0, data.length, tempOP, 0);
		int outputLen = cipher.doFinal(tempOP, processLen);

		byte[] result = new byte[processLen + outputLen];
		System.arraycopy(tempOP, 0, result, 0, result.length);
		return result;

	}

	public byte[] decryptUsingSessionKey(byte[] skey, byte[] data)
			throws Exception {
		PaddedBufferedBlockCipher cipher = new PaddedBufferedBlockCipher(
				new AESEngine(), new PKCS7Padding());
		System.out.println(data.length);
		cipher.init(false, new KeyParameter(skey));
		int outputSize = cipher.getOutputSize(data.length);

		byte[] tempOP = new byte[outputSize];
		int processLen = cipher.processBytes(data, 0, data.length, tempOP, 0);
		int outputLen = cipher.doFinal(tempOP, processLen);

		//byte[] result = new byte[processLen + outputLen];
		//System.arraycopy(tempOP, 0, result, 0, result.length);
		return tempOP;

	}

	private KeyStore.PrivateKeyEntry getKeyFromFile(String keyStoreFile,
			char[] keyStorePassword) {

		try {
			// Load the KeyStore and get the signing key and certificate.
			KeyStore ks = KeyStore.getInstance("PKCS12");
			FileInputStream keyFileStream = new FileInputStream(keyStoreFile);
			ks.load(keyFileStream, keyStorePassword);
			String alias = ks.aliases().nextElement();

			KeyStore.PrivateKeyEntry entry = (KeyStore.PrivateKeyEntry) ks
					.getEntry(alias, new KeyStore.PasswordProtection(
							keyStorePassword));

			if (entry == null)
				throw new Exception("Key not found for the given alias.");

			keyFileStream.close();

			return entry;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
