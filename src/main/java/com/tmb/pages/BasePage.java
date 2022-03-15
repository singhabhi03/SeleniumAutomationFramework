package com.tmb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tmb.Constants.FrameworkConstants;
import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitStrategy;
import com.tmb.factories.ExplicitwaitFactory;
import com.tmb.reports.ExtentLogger;
import com.tmb.utils.EncodeDecodeUtils;

public class BasePage {

	Actions ac = new Actions(DriverManager.getDriver());

	protected void doClick(By element, WaitStrategy waitStrategy, String elementName) {
		WebElement ele = ExplicitwaitFactory.performExplicitWait(waitStrategy, element);
		ele.click();

		ExtentLogger.pass(elementName + " is clicked ", true);

	}

	protected void doSendKeys(By webelement, String value, WaitStrategy waitStrategy, String elementName) {
		WebElement ele = ExplicitwaitFactory.performExplicitWait(waitStrategy, webelement);
		ele.sendKeys(value);

		ExtentLogger.pass(value + " is entered sucessfully in textbox " + elementName, true);

	}

	protected String getTitle() {
		return DriverManager.getDriver().getTitle();
	}

	protected void doMouseHover(By webelement, WaitStrategy waitStrategy, String elementName) {
		WebElement ele = ExplicitwaitFactory.performExplicitWait(waitStrategy, webelement);
		ac.moveToElement(ele).moveToElement(ele).build().perform();

		ExtentLogger.pass("Able to mousehover over " + elementName + " sucessfully", true);

	}

	protected String getText(By webElement) {

		ExtentLogger.pass("Able to fetch " + "Usage: <b><I>"
				+ DriverManager.getDriver().findElement(webElement).getText() + "<I></b>" + " sucessfully", true);

		return DriverManager.getDriver().findElement(webElement).getText();

	}

	protected void doSendKeys(By webelement, String value, WaitStrategy waitStrategy, String elementName,
			boolean needencodeValue) {
		if (needencodeValue) {
			WebElement ele = ExplicitwaitFactory.performExplicitWait(waitStrategy, webelement);
			ele.sendKeys(value);

			ExtentLogger.pass(
					EncodeDecodeUtils.getEncodedString(value) + " is entered sucessfully in textbox " + elementName, true);
		}
		else {
			doSendKeys( webelement,  value,  waitStrategy,  elementName);
		}
		

	}
}
