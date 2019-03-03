package tools;

import java.math.*;
import java.security.*;
public class encryption {

	public static String MD5(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(input.getBytes());
			BigInteger number = new BigInteger(1,messageDigest);
			String hashtext=number.toString(16);
			while(hashtext.length()<32) {
				hashtext="0"+hashtext;
			}
			return hashtext;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static String SHA1(String input){
		try {
			MessageDigest mDigest=MessageDigest.getInstance("SHA1");
			byte[] result = mDigest.digest(input.getBytes());
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < result.length; i++) {
				sb.append(Integer.toString((result[i]&0xff)+0x100,16).substring(1));
			}
			return sb.toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}	
}
