package com.bm2i.security.action;

import java.security.MessageDigest;

import org.jboss.seam.annotations.Name;

@Name("passwordManager")
public class PasswordManager {

	private String digestAlgorithm = "md5";
	private String charset = "UTF-8";

	public String getDigestAlgorithm() {
		return this.digestAlgorithm;
	}

	public void setDigestAlgorithm(String algorithm) {
		this.digestAlgorithm = algorithm;
	}

	public String getCharset() {
		return this.charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public String hash(String plainTextPassword) {
		try {
			MessageDigest digest = MessageDigest.getInstance(digestAlgorithm);
			digest.update(plainTextPassword.getBytes(charset));
			byte[] rawHash = digest.digest();
			return new String(org.jboss.seam.util.Hex.encodeHex(rawHash));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// public static void doEncrypt(String amalgam) {
	// try {
	// KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
	// SecretKey secretKey = keyGenerator.generateKey();
	// Cipher cipher = Cipher.getInstance("DES");
	//
	// //Encrypt
	// cipher.init(Cipher.ENCRYPT_MODE, secretKey);
	// byte[] stringBytes = amalgam.getBytes("UTF8");
	// byte[] raw = cipher.doFinal(stringBytes);
	// BASE64Encoder encoder = new BASE64Encoder();
	// String base64 = encoder.encode(raw);
	// System.err.println("=========================================the encrypted data is:"
	// + base64);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }

	// private static void doDecrypt(Key key, String text) {
	// try {
	// //Get a cipher object
	// Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
	//
	// // Decrypt
	// cipher.init(Cipher.DECRYPT_MODE, key);
	// BASE64Decoder decoder = new BASE64Decoder();
	// byte[] raw = decoder.decodeBuffer(text);
	// byte[] stringBytes = cipher.doFinal(raw);
	// String result = new String(stringBytes, "UTF8");
	// System.out.println("=====================================the decrypted data is: "
	// + result);
	//
	// } catch (Exception d) {
	// d.printStackTrace();
	// }
	// }

}
