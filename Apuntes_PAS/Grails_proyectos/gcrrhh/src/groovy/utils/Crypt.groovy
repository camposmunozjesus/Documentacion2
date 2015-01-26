package utils

import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

class Crypt {

	public static String encrypt(String message) throws Exception {
		return encode(this.lEncrypt(message))
	}
	
	public static String decrypt(String message) throws Exception
	{				
		return lDecrypt(this.decode(message));		
	}
	/*
	 * 3DES algorithm encrypt
	 */
	private static byte[] lEncrypt(String message)throws Exception {
		final MessageDigest md = MessageDigest.getInstance("md5");
		final byte[] digestOfPassword = md.digest("Giro dimissio. Catalunya nou estat d'Europa".getBytes("utf-8"));
		final byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
		int j = 0, k = 16;
		while (j < 8)
		{
			keyBytes[k++] = keyBytes[j++];
		}

		final SecretKey key = new SecretKeySpec(keyBytes, "DESede");
		final IvParameterSpec iv = new IvParameterSpec(new byte[8]);
		final Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, key, iv);

		final byte[] plainTextBytes = message.getBytes("utf-8");
		final byte[] cipherText = cipher.doFinal(plainTextBytes);

		return cipherText;
	}
	
	/*
	* 3DES algorithm decrypt
	*/
	private static String lDecrypt(byte[] message) throws Exception
	{
		final MessageDigest md = MessageDigest.getInstance("md5");
		final byte[] digestOfPassword = md.digest("Giro dimissio. Catalunya nou estat d'Europa".getBytes("utf-8"));
		final byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
		int j = 0, k = 16;
		while (j < 8) {
				keyBytes[k++] = keyBytes[j++];
		}

		final SecretKey key = new SecretKeySpec(keyBytes, "DESede");
		final IvParameterSpec iv = new IvParameterSpec(new byte[8]);
		final Cipher decipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
		decipher.init(Cipher.DECRYPT_MODE, key, iv);

		final byte[] plainText = decipher.doFinal(message);

		return new String(plainText, "UTF-8");
	}
	
	/**
     * Convert bytes to a base16 string.
     */
    private static String encode(byte[] byteArray) {
        StringBuffer hexBuffer = new StringBuffer(byteArray.length * 2);
		char[] HEX = new char[16];
		HEX[0] = '0';
		HEX[1] = '1';
		HEX[2] = '2';
		HEX[3] = '3';
		HEX[4] = '4';
		HEX[5] = '5';
		HEX[6] = '6';
		HEX[7] = '7';
		HEX[8] = '8';
		HEX[9] = '9';
		HEX[10] = 'a';
		HEX[11] = 'b';
		HEX[12] = 'c';
		HEX[13] = 'd';
		HEX[14] = 'e';
		HEX[15] = 'f';

        for (int i = 0; i < byteArray.length; i++)
            for (int j = 1; j >= 0; j--)
                hexBuffer.append(HEX[(byteArray[i] >> (j * 4)) & 0xF]);
        return hexBuffer.toString();
    }
	
	/**
     * Convert a base16 string into a byte array.
     */
    private static byte[] decode(String s) {				
        int len = s.length();
		byte[] data = new byte[len / 2];
		for (int i = 0; i < len; i += 2) {
			data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                                 + Character.digit(s.charAt(i+1), 16));
		}
		return data;

    }
	
	
	
}
