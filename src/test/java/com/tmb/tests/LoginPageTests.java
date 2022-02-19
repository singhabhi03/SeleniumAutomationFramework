package com.tmb.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.tmb.driver.DriverFactory;
import com.tmb.driver.DriverManager;

public final class LoginPageTests extends BaseTest {
	private LoginPageTests() {
		
	}

	@Test
	public void test1() throws InterruptedException {

		DriverManager.getDriver().findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		DriverManager.getDriver().findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
		DriverManager.getDriver().findElement(By.xpath("//input[@id='btnLogin']")).click();
		Thread.sleep(5000);

	}

	
}
