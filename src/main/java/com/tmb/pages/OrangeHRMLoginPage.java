package com.tmb.pages;

import org.openqa.selenium.By;

import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitStrategy;

public final class OrangeHRMLoginPage extends BasePage {
	private final By textBxUsername = By.xpath("//input[@id='txtUsername']");
	private final By textBxPassword = By.xpath("//input[@id='txtPassword']");
	private final By btnLogin = By.xpath("//input[@id='btnLogin']");

	public OrangeHRMLoginPage enterUserName(String userName) {
		doSendKeys(textBxUsername, userName, WaitStrategy.PRESENCE);
		return this;
	}

	public OrangeHRMLoginPage enterPassword(String passWord) {
		doSendKeys(textBxPassword, passWord, WaitStrategy.PRESENCE);
		return this;
	}

	public OrangeHRMHomePage clickLogin() {
		doClick(btnLogin, WaitStrategy.CLICKABLE);
		return new OrangeHRMHomePage();

	}

	public String getPageTitle() {
		return getTitle();
	}

}
