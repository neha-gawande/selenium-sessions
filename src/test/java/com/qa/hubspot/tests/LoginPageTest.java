package com.qa.hubspot.tests;

import org.testng.Assert;

import org.testng.annotations.Test;
import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("Epic - 101 : design Login page features..")
@Feature("US - 201 : design Login page title,signup link and Login form module..")
public class LoginPageTest extends BaseTest {
	
    @Description("varify sign up link on login page..")
    @Severity(SeverityLevel.CRITICAL)
	@Test(priority = 1)
	public void varifySignUpLinkTest() {
		Assert.assertEquals(loginpage.isSignUpLinkExist(), true);
	}
    @Description("varify Login page title on login page..")
    @Severity(SeverityLevel.NORMAL)
	@Test(priority = 2)
	public void varifyLoginPageTitleTest() {
		String title = loginpage.getLoginPageTitle();
		System.out.println("the page title is:" + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}
    
    @Description("varify user is able to login on  login page..")
    @Severity(SeverityLevel.BLOCKER)
	@Test(priority = 3)
	public void loginTest() {
		loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

}
