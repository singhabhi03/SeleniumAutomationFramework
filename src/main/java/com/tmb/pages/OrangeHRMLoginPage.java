package com.tmb.pages;

import org.openqa.selenium.By;

import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitStrategy;
import com.tmb.utils.EncodeDecodeUtils;

public final class OrangeHRMLoginPage extends BasePage {
	private final By textBxUsername = By.xpath("//input[@id='txtUsername']");
	private final By textBxPassword = By.xpath("//input[@id='txtPassword']");
	private final By btnLogin = By.xpath("//input[@id='btnLogin']");

	public OrangeHRMLoginPage enterUserName(String userName) {
		doSendKeys(textBxUsername, userName, WaitStrategy.PRESENCE,"UserName");
		return this;
	}

	public OrangeHRMLoginPage enterPassword(String passWord) {
		doSendKeys(textBxPassword, EncodeDecodeUtils.getDecodedString(passWord), WaitStrategy.PRESENCE,"Password",true);
		return this;
	}

	public OrangeHRMHomePage clickLogin() {
		doClick(btnLogin, WaitStrategy.CLICKABLE,"Login button");
		return new OrangeHRMHomePage();

	}

	public String getPageTitle() {
		return getTitle();
	}

}
