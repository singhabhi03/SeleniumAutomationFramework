package com.tmb.tests;

import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.tmb.driver.DriverFactory;

public class BaseTest {
	
	protected BaseTest() {
		
	}
	

	@BeforeMethod
	protected void setUp(Object[] data) throws Exception  {
		Map<String,String> map = (Map<String,String>)data[0];
		
		DriverFactory.initDriver(map.get("browser"));
	}

	@AfterMethod

	protected void tearDown() {
		 DriverFactory.quitDriver(); 
	}
}
