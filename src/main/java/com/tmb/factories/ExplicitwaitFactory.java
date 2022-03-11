package com.tmb.factories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tmb.Constants.FrameworkConstants;
import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitStrategy;

public class ExplicitwaitFactory {
	public static WebElement performExplicitWait(WaitStrategy waitStrategy,By webelement) {
		WebElement element = null;
		if (waitStrategy== WaitStrategy.CLICKABLE) {
			element= new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwait()).
			until(ExpectedConditions.elementToBeClickable(webelement));
		} else if (waitStrategy==WaitStrategy.PRESENCE) {
			element= new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwait())
			.until(ExpectedConditions.presenceOfElementLocated(webelement));
		}
		else if(waitStrategy==WaitStrategy.VISIBILITY) {
		element=	new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwait())
			.until(ExpectedConditions.visibilityOfElementLocated(webelement));
		}
		else if(waitStrategy== WaitStrategy.NONE) {
			element = DriverManager.getDriver().findElement(webelement);
		}
		return element;
	}

}
