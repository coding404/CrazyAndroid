package com.jaydenxiao.common.security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密类
 */
public class Md5Security {
	/**
	 * md5加密
	 * @param info
	 * @return
	 */
	public static String getMD5(String info)
	{
		try
		{
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(info.getBytes("UTF-8"));
			byte[] encryption = md5.digest();

			StringBuilder strBuf = new StringBuilder();
			for (byte b : encryption) {
				if (Integer.toHexString(0xff & b).length() == 1) {
					strBuf.append("0").append(Integer.toHexString(0xff & b));
				} else {
					strBuf.append(Integer.toHexString(0xff & b));
				}
			}

			return strBuf.toString();
		}
		catch (NoSuchAlgorithmException e)
		{
			return "";
		}
		catch (UnsupportedEncodingException e)
		{
			return "";
		}
	}
}
