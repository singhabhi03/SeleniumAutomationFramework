package com.tmb.pages;

import org.openqa.selenium.By;

import com.tmb.enums.WaitStrategy;

public final class OrangeHRMLeavePage extends BasePage {

	private final By applyLeaveMenu = By.xpath("//a[@id='menu_leave_applyLeave']");
	private final By leaveMessage = By.xpath("//div[@class='message warning']");

	public OrangeHRMLeavePage clickApply() {
		doClick(applyLeaveMenu, WaitStrategy.CLICKABLE, "Apply Link");

		return this;
	}

	public String getMessage() {

		return getText(leaveMessage);
	}

}
