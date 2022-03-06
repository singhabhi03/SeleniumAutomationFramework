package com.tmb.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public final class ExtentReport {
	private ExtentReport() {

	}

	private static ExtentReports extent;
	
	public static void initReports() {
		if (Objects.isNull(extent)) {
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter("index.html");
			extent.attachReporter(spark);
			spark.config().setTheme(Theme.STANDARD);
			spark.config().setDocumentTitle("TMB Report");
			spark.config().setReportName("Youtube Training");
		}
	}

	public static void flushReport() throws IOException {
		if(Objects.nonNull(extent)) {
			extent.flush();
			Desktop.getDesktop().browse(new File("index.html").toURI());
		}
		
	}

	public static void createTest(String testCaseName) {
		ExtentTest	test =extent.createTest(testCaseName);
		ExtentManager.setExtentTest(test);
	}
}
