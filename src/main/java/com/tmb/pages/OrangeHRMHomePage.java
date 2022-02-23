package com.tmb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tmb.driver.DriverManager;

public final class OrangeHRMHomePage {

	private final By linkWelcome = By.id("welcome");
	private final By linkLogout = By.xpath("//a[text()='Logout']");

	public OrangeHRMHomePage clickWelCome() {
		DriverManager.getDriver().findElement(linkWelcome).click();

		return this;
	}

	@SuppressWarnings("deprecation")
	public OrangeHRMLoginPage clickLogOut() {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 10);
		wait.until(ExpectedConditions.elementToBeClickable(linkLogout));
		DriverManager.getDriver().findElement(linkLogout).click();
		return new OrangeHRMLoginPage();
	}
}
