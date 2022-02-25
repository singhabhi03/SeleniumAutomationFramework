package com.tmb.Constants;

public final class FrameworkConstants {
	private static final String CHROME_DRIVER_PATH = System.getProperty("user.dir")+"/src/test/resources/executables/chromedriver.exe";
	private static final String CONFIGFILEPATH=System.getProperty("user.dir")+"/src/test/resources/config/config.properties";
	private static final int EXPLICITWAIT=10;
	
	public static int getExplicitwait() {
		return EXPLICITWAIT;
	}
	public static String getChromeDriverPath() {
		return CHROME_DRIVER_PATH;
	}
	public static String getConfigfilepath() {
		return CONFIGFILEPATH;
	}
	
}
