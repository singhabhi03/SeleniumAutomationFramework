package com.tmb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitStrategy;

public final class OrangeHRMHomePage extends BasePage {

	private final By linkWelcome = By.id("welcome");
	private final By linkLogout = By.xpath("//a[text()='Logout']");

	public OrangeHRMHomePage clickWelCome() {
		doClick(linkWelcome,WaitStrategy.CLICKABLE);

		return this;
	}

	@SuppressWarnings("deprecation")
	public OrangeHRMLoginPage clickLogOut() {
		//WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 10);
		//wait.until(ExpectedConditions.elementToBeClickable(linkLogout));
		doClick(linkLogout,WaitStrategy.CLICKABLE);
		return new OrangeHRMLoginPage();
	}
}
