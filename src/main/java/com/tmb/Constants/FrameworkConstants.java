package com.tmb.Constants;

public final class FrameworkConstants {
	private static final String CHROME_DRIVER_PATH = System.getProperty("user.dir")+"/src/test/resources/executables/chromedriver.exe";

	public static String getChromeDriverPath() {
		return CHROME_DRIVER_PATH;
	}
	
}
