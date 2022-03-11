package com.tmb.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tmb.annotations.FrameworkAnnotation;
import com.tmb.enums.CategoryType;
import com.tmb.pages.OrangeHRMHomePage;
import com.tmb.pages.OrangeHRMLoginPage;
import com.tmb.utils.DataProviderUtils;

public final class OrangeHRMLeaveFeatureTest extends BaseTest{
	private OrangeHRMLeaveFeatureTest() {
		
	}
	@FrameworkAnnotation(authors = { "Abhishek" }, testCategory = { CategoryType.REGRESSION})
	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void leaveFeatureTest(Map<String,String> data) {
		
		OrangeHRMLoginPage loginPage = new OrangeHRMLoginPage();
	String leaveMessage=	 loginPage.enterUserName(data.get("username")).enterPassword(data.get("password")).clickLogin().hoverOverLeavemenu().clickApply().getMessage();
		Assert.assertEquals(leaveMessage, "No Leave Types with Leave Balance");
		OrangeHRMHomePage homePage = new OrangeHRMHomePage();
		homePage.clickWelCome().clickLogOut();

	}

}
