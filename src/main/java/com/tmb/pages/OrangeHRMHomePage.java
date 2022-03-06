package com.tmb.pages;

import org.openqa.selenium.By;

import com.tmb.enums.WaitStrategy;
import com.tmb.reports.ExtentLogger;
import com.tmb.reports.ExtentManager;

public final class OrangeHRMHomePage extends BasePage {

	private final By linkWelcome = By.id("welcome");
	private final By linkLogout = By.xpath("//a[text()='Logout']");

	public OrangeHRMHomePage clickWelCome() {
		doClick(linkWelcome,WaitStrategy.CLICKABLE,"Welcome Link");
		

		return this;
	}

	public OrangeHRMLoginPage clickLogOut() {
		
		doClick(linkLogout,WaitStrategy.CLICKABLE,"Logout button");
		
		return new OrangeHRMLoginPage();
	}
}
