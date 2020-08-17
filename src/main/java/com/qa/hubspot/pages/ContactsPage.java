package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;

public class ContactsPage extends BasePage {
	private WebDriver driver;
	ElementUtil elementUtil;

	By header = By.xpath("//i18n-string[contains(text(),'Contacts')]");
	By creatContactPri = By.xpath("//span[contains(text(),'Create contact')]");
	By email = By.xpath("//input[@data-field='email']");
	By fname = By.xpath("//input[@data-field='firstname']");
	By lname = By.xpath("//input[@data-field='lastname']");
	By jobTitle = By.xpath("//input[@data-field='jobtitle']");
	By createContactSec = By.xpath("//span[@class][contains(text(),'Create contact')]");
	By contact = By.xpath("//span[@data-selenium-test='highlightTitle']");
	By contactsBackLink = By.xpath("(//*[text()='Contacts'][position()=1])");
	By selectAll = By.xpath("//div[@class='private-checkbox private-checkbox--flush private-checkbox--unlabeled private-checkbox--align-center']");
	By deleteAll = By.xpath("//button[@data-selenium-test='bulk-action-delete']");
	By delContact = By.xpath("//textarea[@data-selenium-test='delete-dialog-match']");
	By delete = By.xpath("//button[@data-confirm-button='accept']");

	public ContactsPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}

	public String getContactsPageTitle() {
		return elementUtil.doGetPageTitleWithIsTitle(10, Constants.CONTACTS_PAGE_TITLE);
	}

	public String getContactsPageHeader() {
		elementUtil.waitForElementPresent(header, 10);
		return elementUtil.doGetText(header);

	}

	public String createContact(String emailId, String fname, String lname, String jobTitle) {
		elementUtil.clickWhenReady(creatContactPri, 10);
		elementUtil.doSendKeys(this.email, emailId);
		elementUtil.doSendKeys(this.fname, fname);
		elementUtil.doSendKeys(this.lname, lname);
		elementUtil.doSendKeys(this.jobTitle, jobTitle);
		elementUtil.doGetClick(createContactSec);
		String value = elementUtil.doGetText(contact);
		elementUtil.clickWhenReady(contactsBackLink, 10);
		elementUtil.doGetClick(selectAll);
		elementUtil.doGetClick(deleteAll);
		elementUtil.doSendKeys(delContact, "1");
		elementUtil.doGetClick(delete);
		return value;

	}
		
}
	


