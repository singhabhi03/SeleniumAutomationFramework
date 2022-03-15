package com.tmb.utils;

import java.util.Base64;

public final class EncodeDecodeUtils {
	
	public static  String getDecodedString(String encodedString) {
		return new String(Base64.getDecoder().decode(encodedString.getBytes()));
		
	}
	
	public static String getEncodedString(String valueTobeEncoded) {
		return Base64.getEncoder().encodeToString(valueTobeEncoded.getBytes());
		
	}

}
