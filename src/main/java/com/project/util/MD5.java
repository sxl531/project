package com.project.util;
import java.security.MessageDigest;
public class MD5 {
	 public static String MD5Encrypt(String pwd) {
	      char hexDigits[] = {'1', 'q', 'a', 'z', '2', 'w', 's', 'x', '3', 'e', 'd', 'c', '4', 'r', 'f', 'v'};
	       try {
	            byte[] strTemp = pwd.getBytes();
	            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
	            mdTemp.update(strTemp);
	            byte[] md = mdTemp.digest();
	            int j = md.length;
	            char str[] = new char[j * 2];
	            int k = 0;
	            for (int i = 0; i < j; i++) {
	                byte byte0 = md[i];
	                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
	                str[k++] = hexDigits[byte0 & 0xf];
	            }
	            return new String(str);
	        } catch (Exception e) {
	            return null;
	        }
	    }
}