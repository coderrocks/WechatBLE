/**
 * Copyright 2016-2018, zeico inc. All right reserved.
 * Project: 	WechatBLE
 * Author:  	zhijiakeji
 * Create date:	2016-3-23
 */
package cn.zeico.air.utils;

import java.security.MessageDigest;

/**
 * @author zhijiakeji
 *
 */
public class CommonMethod {
	public static String encodeSHA1(String str) {
		if (str == null) {
			return null;
		}
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
			messageDigest.update(str.getBytes());
			return bytesToHexString(messageDigest.digest());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static String bytesToHexString(byte[] src) {
		StringBuilder stringBuilder = new StringBuilder("");
		if (src == null || src.length <= 0) {
			return null;
		}
		for (int i = 0; i < src.length; i++) {
			int v = src[i] & 0xFF;
			String hv = Integer.toHexString(v);
			if (hv.length() < 2) {
				stringBuilder.append(0);
			}
			stringBuilder.append(hv);
		}
		return stringBuilder.toString();
	}
}
