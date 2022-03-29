package com.tmb.factories;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.tmb.driver.DriverManager;
import com.tmb.enums.ConfigProperties;
import com.tmb.utils.PropertiesFileUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class DriverManagerFactory {

	private DriverManagerFactory() {

	}

	public static WebDriver getDriver(String browser) throws MalformedURLException {
		WebDriver driver = null;
		String runmode =PropertiesFileUtil.getValue(ConfigProperties.RUNMODE);
		
			if (browser.equalsIgnoreCase("chrome")) {

				if (runmode.equalsIgnoreCase("Remote")) {

					DesiredCapabilities cap = new DesiredCapabilities();
					cap.setBrowserName(BrowserType.CHROME);

				driver = new  RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
						
					
				}
				else {
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();

			} 
			}else if (browser.equalsIgnoreCase("edge")) {

				if (runmode.equalsIgnoreCase("Remote")) {
					DesiredCapabilities cap = new DesiredCapabilities();
					cap.setBrowserName(BrowserType.EDGE);

					
					driver = new  RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
					
				} else {
					WebDriverManager.edgedriver().setup();
					driver = new EdgeDriver();
				}

			}
			else if (browser.equalsIgnoreCase("firefox")) {

				if (runmode.equalsIgnoreCase("Remote")) {
					DesiredCapabilities cap = new DesiredCapabilities();
					cap.setBrowserName(BrowserType.FIREFOX);

					
					driver = new  RemoteWebDriver(new URL("http://localhost:4445/wd/hub"), cap);
					
				} else {
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
				}

			}

		

	
		return driver;
}
	}
