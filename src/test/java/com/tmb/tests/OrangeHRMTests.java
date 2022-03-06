package com.tmb.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tmb.pages.OrangeHRMLoginPage;
import com.tmb.reports.ExtentReport;

public final class OrangeHRMTests extends BaseTest {

	private OrangeHRMTests() {

	}

	@Test
	public void loginLogOutTest() {
		
		OrangeHRMLoginPage loginPage = new OrangeHRMLoginPage();
		String title = loginPage.enterUserName("Admin").enterPassword("admin123").clickLogin().clickWelCome()
				.clickLogOut().getPageTitle();
		Assert.assertEquals(title, "OrangeHRM");

	}

}
