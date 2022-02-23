package com.tmb.pages;

import org.openqa.selenium.By;

import com.tmb.driver.DriverManager;

public final class OrangeHRMLoginPage {
	private final By textBxUsername = By.xpath("//input[@id='txtUsername']");
	private final By textBxPassword = By.xpath("//input[@id='txtPassword']");
	private final By btnLogin = By.xpath("//input[@id='btnLogin']");

	public OrangeHRMLoginPage enterUserName(String userName) {
		DriverManager.getDriver().findElement(textBxUsername).sendKeys(userName);
		return this;
	}

	public OrangeHRMLoginPage enterPassword(String passWord) {
		DriverManager.getDriver().findElement(textBxPassword).sendKeys(passWord);

		return this;
	}

	public OrangeHRMHomePage clickLogin() {
		DriverManager.getDriver().findElement(btnLogin).click();
		return new OrangeHRMHomePage();

	}
	public String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}

}
