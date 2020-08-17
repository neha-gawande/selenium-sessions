package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage extends BasePage{
	private WebDriver driver;
	ElementUtil elementUtil;
	
	By emailID = By.id("username");
	By passsword = By.id("password");
	By loginButton = By.id("loginBtn");
	By signuplink = By.linkText("Sign up");
	
	//Constructor of LoginPage
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}
	//Page action:
	@Step("getting login page title..")
	public String getLoginPageTitle() {
		return elementUtil.doGetPageTitleWithIsTitle(10,Constants.LOGIN_PAGE_TITLE);
	}
	
	@Step("getting sign up link presence..")
	public boolean isSignUpLinkExist() {
		return elementUtil.doIsDisplayed(signuplink);
	}
	
	@Step("login with username : {0} and password : {1}")
	public HomePage doLogin(String username, String password) {
		elementUtil.waitForElementToBeVisible(emailID, 10);
		elementUtil.doSendKeys(emailID, username);
		elementUtil.doSendKeys(passsword, password);
		elementUtil.doGetClick(loginButton);
		
		return new HomePage(driver);
	}

}
