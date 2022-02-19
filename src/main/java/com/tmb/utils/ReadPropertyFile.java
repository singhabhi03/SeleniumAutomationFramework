package com.tmb.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;



public class ReadPropertyFile {
	
	private ReadPropertyFile() {
		
	}
	private static   Properties prop = new Properties();
	private static final Map<String, String> CONFIGMAP = new HashMap<>();
	static {
		
		try {
			FileInputStream fip = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/config/config.properties");
			 prop.load(fip);
				for (Map.Entry<Object, Object> entry : prop.entrySet()) {
					CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim());
					}
				
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		  
	}
		}
	public static String getValue(String key) throws Exception {

		if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key))) {
			throw new Exception("Property name " + key + " is not available in config.properties");
		}
		return CONFIGMAP.get(key);

	}
}
