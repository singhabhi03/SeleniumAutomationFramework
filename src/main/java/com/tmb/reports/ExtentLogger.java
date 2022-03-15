package com.tmb.reports;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.tmb.driver.DriverManager;
import com.tmb.enums.ConfigProperties;
import com.tmb.utils.PropertiesFileUtil;
import com.tmb.utils.ScreenShotUtils;

public final class ExtentLogger {

	private ExtentLogger() {

	}

	public static void pass(String message) {
		ExtentManager.getExtentTest().pass(message);
	}

	public static void fail(String message) {
		ExtentManager.getExtentTest().fail(message);
	}

	public static void skip(String message) {
		ExtentManager.getExtentTest().skip(message);
	}

	public static void pass(String message, boolean isScreenShotRequired)  {
		if (PropertiesFileUtil.getValue(ConfigProperties.PASSEDSTEPSSCREENSHOT).equalsIgnoreCase("yes")
				&& isScreenShotRequired) {
			ExtentManager.getExtentTest().pass(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtils.getBase64Image()).build());

		} else {
			pass(message);
		}
	}

	public static void fail(String message, boolean isScreenShotRequired) throws Exception {
		if (PropertiesFileUtil.getValue(ConfigProperties.FAILEDSTEPSSCREENSHOT).equalsIgnoreCase("yes")
				&& isScreenShotRequired) {
			ExtentManager.getExtentTest().fail(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtils.getBase64Image()).build());

		} else {
			fail(message);
		}
	}

	public static void skip(String message, boolean isScreenShotRequired) throws Exception {
		if (PropertiesFileUtil.getValue(ConfigProperties.SKIPPEDSTEPSSCREENSHOT).equalsIgnoreCase("yes")
				&& isScreenShotRequired) {
			ExtentManager.getExtentTest().skip(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtils.getBase64Image()).build());

		} else {
			skip(message);
		}
	}

	
}
