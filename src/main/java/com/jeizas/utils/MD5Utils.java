package com.jeizas.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {

	public static String getMD5(String str, int length) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		md.update(str.getBytes());
		return toHex(md.digest());
	}
	
	public static String MD532(String str) {
		return getMD5(str,32);
	}
	
	private static String toHex(byte buffer[]) {  
        StringBuffer sb = new StringBuffer(buffer.length * 2);  
        for (int i = 0; i < buffer.length; i++) {  
            sb.append(Character.forDigit((buffer[i] & 240) >> 4, 16));  
            sb.append(Character.forDigit(buffer[i] & 15, 16));  
        }  
        return sb.toString();  
    } 
	
	public static void main(String [] args){
		System.out.println(MD5Utils.getMD5("2222", 32));

	}
}