package com.tmb.driver;

import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.tmb.Constants.FrameworkConstants;
import com.tmb.enums.ConfigProperties;
import com.tmb.utils.PropertiesFileUtil;

public final class DriverFactory {
	private DriverFactory() {
		
	}
	
	public static void initDriver(String browser) throws Exception {
		if(Objects.isNull(DriverManager.getDriver())) {
			if(browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriverPath());
				WebDriver	driver = new ChromeDriver();
				DriverManager.setDriver(driver);
			}
			else if(browser.equalsIgnoreCase("edge")) {
				System.setProperty("webdriver.edge.driver", FrameworkConstants.getEdgeDriverPath());
				WebDriver	driver = new EdgeDriver();
				DriverManager.setDriver(driver);
			}
			
			DriverManager.getDriver().manage().window().maximize();
			DriverManager.getDriver().get(PropertiesFileUtil.getValue(ConfigProperties.URL));
		}
		
	}
	
	public static void quitDriver() {
		if(Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
		
	}
}
