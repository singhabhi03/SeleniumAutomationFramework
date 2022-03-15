package com.tmb.listeners;

import java.io.IOException;
import java.util.Arrays;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.tmb.annotations.FrameworkAnnotation;
import com.tmb.reports.ExtentLogger;
import com.tmb.reports.ExtentReport;

public class ListenerClass implements ITestListener,ISuiteListener{
	@Override
	public void onStart(ISuite suite) {
	
			ExtentReport.initReports();
		
	}
	@Override
	public void onFinish(ISuite suite) {
			
		
			ExtentReport.flushReport();
		
	}
	@Override
	public void onTestStart(ITestResult result) {
	ExtentReport.createTest(result.getMethod().getMethodName());
	ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).authors());
	ExtentReport.testCategory(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).testCategory());
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getMethod().getMethodName()+ " is passed");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		
		try {
			ExtentLogger.fail(result.getMethod().getMethodName(), true);
			ExtentLogger.fail(result.getThrowable().toString());
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentLogger.fail(result.getMethod().getMethodName()+ " is skipped");
	}
}
