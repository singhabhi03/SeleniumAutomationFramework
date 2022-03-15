package com.tmb.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tmb.annotations.FrameworkAnnotation;
import com.tmb.enums.CategoryType;
import com.tmb.pages.OrangeHRMLoginPage;
import com.tmb.utils.DataProviderUtils;

public final class OrangeHRMTests extends BaseTest {

	private OrangeHRMTests() {

	}
	@FrameworkAnnotation(authors = { "Abhishek" }, testCategory = { CategoryType.SYSTEM})
	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void loginLogOutTest(Map<String,String> data) {
		
		OrangeHRMLoginPage loginPage = new OrangeHRMLoginPage();
		String title = loginPage.enterUserName(data.get("username")).enterPassword(data.get("password")).clickLogin().clickWelCome()
				.clickLogOut().getPageTitle();
		Assert.assertEquals(title, "OrangeHRM");

	}

	
}
