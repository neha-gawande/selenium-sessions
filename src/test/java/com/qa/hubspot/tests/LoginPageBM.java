package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.utils.Constants;
public class LoginPageBM {
	WebDriver driver;
	Properties prop;
	BasePage basepage;
	LoginPage loginpage;
	
	@BeforeMethod
	public void setUp() {
		basepage = new BasePage();
		prop = basepage.init_prop();
		driver = basepage.init_driver(prop);
		loginpage = new LoginPage(driver);
	}
	
	@Test(priority = 1)
	public void varifySignUpLinkTest() {
		Assert.assertEquals(loginpage.isSignUpLinkExist(), true);
	}
	
	@Test(priority = 2)
	public void varifyLoginPageTitleTest() {
		String title = loginpage.getLoginPageTitle();
		System.out.println("the page title is:" +title);
		Assert.assertEquals(title,Constants.LOGIN_PAGE_TITLE);
	}	
	@Test(priority = 3)
	public void loginTest() {
		loginpage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}



