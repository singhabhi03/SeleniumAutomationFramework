package com.tmb.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.tmb.Constants.FrameworkConstants;
import com.tmb.enums.CategoryType;

public final class ExtentReport {
	private ExtentReport() {

	}

	private static ExtentReports extent;

	public static void initReports() throws Exception {
		if (Objects.isNull(extent)) {
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
			extent.attachReporter(spark);
			spark.config().setTheme(Theme.STANDARD);
			spark.config().setDocumentTitle("TMB Report");
			spark.config().setReportName("Youtube Training");
		}
	}

	public static void flushReport() throws Exception {
		if (Objects.nonNull(extent)) {
			extent.flush();
		}
		ExtentManager.unload();
			Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());

		}
	

	public static void createTest(String testCaseName) {
		ExtentTest test = extent.createTest(testCaseName);
		ExtentManager.setExtentTest(test);
	}
	
	public static void addAuthors(String[] authors) {
		for(String temp:authors) {
			ExtentManager.getExtentTest().assignAuthor(temp);
		}
				
		
	}
public static void testCategory(CategoryType[] categories) {
	for(CategoryType temp:categories) {
		ExtentManager.getExtentTest().assignAuthor(temp.toString());
	}
	}
}
