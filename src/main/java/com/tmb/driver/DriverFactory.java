package com.tmb.driver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.internal.PropertyUtils;

import com.tmb.Constants.FrameworkConstants;
import com.tmb.enums.ConfigProperties;
import com.tmb.exception.BrowserInvocationFailedException;
import com.tmb.factories.DriverManagerFactory;
import com.tmb.utils.PropertiesFileUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class DriverFactory {
	private DriverFactory() {

	}

	@SuppressWarnings("deprecation")
	public static void initDriver(String browser) {
		
		if (Objects.isNull(DriverManager.getDriver())) {
			
			try {
				DriverManager.setDriver(DriverManagerFactory.getDriver(browser));
			} catch (MalformedURLException e) {
				throw new BrowserInvocationFailedException("Browser Invocation failed, Please check the capabilities",e);
			}
			
					

			DriverManager.getDriver().manage().window().maximize();
			DriverManager.getDriver().get(PropertiesFileUtil.getValue(ConfigProperties.URL));
		}

	}

	public static void quitDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}

	}
}
