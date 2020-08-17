package com.qa.hubspot.tests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.utils.Constants;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("Epic - 102 : design Home page features..")
@Feature("US - 301 : design Home page title,header and account names module..")

public class HomePageTest extends BaseTest{
	HomePage homePage;
	
	@BeforeClass
	public void homePageSetUp() {
		homePage = loginpage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Description("varify Title Test on home page..")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 2)
	public void varifyHomePageTitle() {
		String title = homePage.getHomePageTitle();
		System.out.println("Homepage title is:" +title);
		Assert.assertEquals(title,Constants.HOME_PAGE_TITLE);
	}
	
	@Description("varify header Test on home page..")
	@Severity(SeverityLevel.MINOR)
	@Test(priority = 1)
	public void varifyHomePageHeader() {
		String header = homePage.getHomepageHeader();
		System.out.println("Homepage header is:" +header);
		Assert.assertEquals(header,Constants.HOME_PAGE_HEADER);
	}
	
}
