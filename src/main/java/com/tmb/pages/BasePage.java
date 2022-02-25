package com.tmb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tmb.Constants.FrameworkConstants;
import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitStrategy;
import com.tmb.factories.ExplicitwaitFactory;

public class BasePage {

	protected void doClick(By element, WaitStrategy waitStrategy) {
	WebElement ele=	ExplicitwaitFactory.performExplicitWait(waitStrategy, element);
	ele.click();
		

	}

	protected void doSendKeys(By webelement, String value, WaitStrategy waitStrategy) {
		WebElement ele =ExplicitwaitFactory.performExplicitWait(waitStrategy, webelement);
		ele.sendKeys(value);
	}

	protected String getTitle() {
		return DriverManager.getDriver().getTitle();
	}

	
}
