package com.tmb.Constants;

import com.tmb.enums.ConfigProperties;
import com.tmb.utils.PropertiesFileUtil;

public final class FrameworkConstants {
	private FrameworkConstants() {
		
	}
	private static final String CHROME_DRIVER_PATH = System.getProperty("user.dir")+"/src/test/resources/executables/chromedriver.exe";
	private static final String CONFIGFILEPATH=System.getProperty("user.dir")+"/src/test/resources/config/config.properties";
	private static final int EXPLICITWAIT=10;
	private static final String EXTENTREPORTPATH=System.getProperty("user.dir")+"/extent-test-output/";
	private static String extentReportFilePath="";
	private static final String EXCELPATH=System.getProperty("user.dir")+"/src/test/resources/excel/testdata.xlsx";
	
	
	
	
	public static String getExtentReportFilePath() throws Exception {
		if(extentReportFilePath.isEmpty()) {
			extentReportFilePath=createReportPath();
		}
		return extentReportFilePath;
	}
	public static String createReportPath() throws Exception  {
		if(PropertiesFileUtil.getValue(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
			return EXTENTREPORTPATH+"/"+System.currentTimeMillis()+"index.html";
		}
		else {
			return EXTENTREPORTPATH+"/index.html";
		}
	}
	
	
	public static int getExplicitwait() {
		return EXPLICITWAIT;
	}
	public static String getChromeDriverPath() {
		return CHROME_DRIVER_PATH;
	}
	public static String getConfigfilepath() {
		return CONFIGFILEPATH;
	}
	public static String getExcelpath() {
		return EXCELPATH;
	}
}
