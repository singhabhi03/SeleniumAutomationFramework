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

public class BasePage {

	Actions ac = new Actions(DriverManager.getDriver());

	protected void doClick(By element, WaitStrategy waitStrategy, String elementName) {
		WebElement ele = ExplicitwaitFactory.performExplicitWait(waitStrategy, element);
		ele.click();
		try {
			ExtentLogger.pass(elementName + " is clicked ", true);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	protected void doSendKeys(By webelement, String value, WaitStrategy waitStrategy, String elementName) {
		WebElement ele = ExplicitwaitFactory.performExplicitWait(waitStrategy, webelement);
		ele.sendKeys(value);
		try {
			ExtentLogger.pass(value + " is entered sucessfully in textbox " + elementName, true);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	protected String getTitle() {
		return DriverManager.getDriver().getTitle();
	}

	protected void doMouseHover(By webelement, WaitStrategy waitStrategy, String elementName) {
		WebElement ele = ExplicitwaitFactory.performExplicitWait(waitStrategy, webelement);
		ac.moveToElement(ele).moveToElement(ele).build().perform();
		try {
			ExtentLogger.pass("Able to mousehover over " + elementName + " sucessfully", true);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	protected String getText(By webElement) {
		try {
			ExtentLogger.pass("Able to fetch " + "Usage: <b>"+DriverManager.getDriver().findElement(webElement).getText()+"</b>"
					+ " sucessfully", true);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return DriverManager.getDriver().findElement(webElement).getText();

	}

}
