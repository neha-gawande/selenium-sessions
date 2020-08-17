package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.pages.ContactsPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ExcelUtil;

public class ContactsPageTest extends BaseTest {
	HomePage homePage;
	ContactsPage contactsPage;

	@BeforeClass
	public void homePageSetUp() {
		homePage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.goToContactsPage();
	}

	@Test(priority = 1)
	public void varifyContactsPageTitle() {
		String title = contactsPage.getContactsPageTitle();
		System.out.println("Contactspage title is:" + title);
		Assert.assertEquals(title, Constants.CONTACTS_PAGE_TITLE);
	}

	@Test(priority = 2)
	public void varifyContactsPageHeader() {
		String headerValue = contactsPage.getContactsPageHeader();
		System.out.println("Contactspage header is:" + headerValue);
		Assert.assertEquals(headerValue, Constants.CONTACTS_PAGE_HEADER);
	}

	@DataProvider
	public Object[][] getContactsTestData() {
		Object data[][] = ExcelUtil.getTestData(Constants.CONTACTS_SHEET_NAME);
		
		return data;
	}

	@Test(priority = 3, dataProvider = "getContactsTestData")
	public void createNewContactTest(String emailID, String fname, String lname, String jobTitle) {
		String contacts = contactsPage.createContact(emailID, fname, lname, jobTitle);
		
		System.out.println("======================");
		System.out.println("returned=" + contacts);
		System.out.println("======================");
		Assert.assertEquals(contacts, fname+" "+lname);
		
	}
	
}
