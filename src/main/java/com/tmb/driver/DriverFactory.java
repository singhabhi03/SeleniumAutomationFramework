package com.tmb.driver;

import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.tmb.Constants.FrameworkConstants;
import com.tmb.enums.ConfigProperties;
import com.tmb.utils.PropertiesFileUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class DriverFactory {
	private DriverFactory() {
		
	}
	
	public static void initDriver(String browser) {
		if(Objects.isNull(DriverManager.getDriver())) {
			if(browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				WebDriver	driver = new ChromeDriver();
				DriverManager.setDriver(driver);
			}
			else if(browser.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
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
