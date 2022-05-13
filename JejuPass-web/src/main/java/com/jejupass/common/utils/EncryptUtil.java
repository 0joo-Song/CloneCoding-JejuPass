package com.jejupass.common.utils;

import java.security.MessageDigest;

/**
 * EncryptUtils	
 * 
 */
public class EncryptUtil {
	public static enum ENCRYPT {
		MD5("MD5"),
		SHA1("SHA-1"),
		SHA256("SHA-256"),
		SHA512("SHA-512");
		
		private ENCRYPT(String name) {
			this.name = name;
		}

		public String name;
	}
	
	public static String hash(ENCRYPT type, String orignal) {
		if (type == null || orignal == null) return null;
		
		String sReturn = null;
		MessageDigest md = null;

		try {
			md = MessageDigest.getInstance(type.name);

			md.update(orignal.getBytes());

			sReturn = byteArrayToHex(md.digest());
		} catch (Exception e) {
		}

		return sReturn;
	}

	/**
	 * hex를 byte array로 변환
	 * 
	 * @param hex
	 * @return
	 */
	private static byte[] hexToByteArray(String hex) {
		if (hex == null || hex.length() == 0) {
			return null;
		}

		byte[] ba = new byte[hex.length() / 2];
		for (int i = 0; i < ba.length; i++) {
			ba[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
		}

		return ba;
	}

	/**
	 * byte array를 hex로 변환
	 * 
	 * @param ba
	 * @return
	 */
	private static String byteArrayToHex(byte[] ba) {
		if (ba == null || ba.length == 0) {
			return null;
		}

		StringBuffer sb = new StringBuffer(ba.length * 2);
		String hexNumber;
		for (int x = 0; x < ba.length; x++) {
			hexNumber = "0" + Integer.toHexString(0xff & ba[x]);

			sb.append(hexNumber.substring(hexNumber.length() - 2));
		}

		return sb.toString();
	}
	
	/**
	 * PW 암호화
	 * @param pw
	 * @return
	 */
	public static String encryptPW(String pw) {
		String encryptStr = "";
		
		encryptStr = EncryptUtil.hash(EncryptUtil.ENCRYPT.SHA1, pw);
		
		encryptStr = EncryptUtil.hash(EncryptUtil.ENCRYPT.SHA256, encryptStr);
		
		return encryptStr;
	}
	
	/**
	 * Key 암호화
	 * @param key
	 * @return
	 */
	public static String encryptKey(String key) {
		String encryptStr = "";
		
		encryptStr = EncryptUtil.hash(EncryptUtil.ENCRYPT.SHA1, key);
		
		encryptStr = EncryptUtil.hash(EncryptUtil.ENCRYPT.SHA256, encryptStr);
		
		return encryptStr;
	}	
	
}
