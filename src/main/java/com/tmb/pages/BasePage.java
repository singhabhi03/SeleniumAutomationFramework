package com.tmb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tmb.Constants.FrameworkConstants;
import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitStrategy;
import com.tmb.factories.ExplicitwaitFactory;
import com.tmb.reports.ExtentLogger;

public class BasePage {

	protected void doClick(By element, WaitStrategy waitStrategy,String elementName) {
	WebElement ele=	ExplicitwaitFactory.performExplicitWait(waitStrategy, element);
	ele.click();
		ExtentLogger.pass(elementName+" is clicked ");

	}

	protected void doSendKeys(By webelement, String value, WaitStrategy waitStrategy,String elementName) {
		WebElement ele =ExplicitwaitFactory.performExplicitWait(waitStrategy, webelement);
		ele.sendKeys(value);
		ExtentLogger.pass(value+" is entered sucessfully in textbox "+ elementName);
	}

	protected String getTitle() {
		return DriverManager.getDriver().getTitle();
	}

	
}
