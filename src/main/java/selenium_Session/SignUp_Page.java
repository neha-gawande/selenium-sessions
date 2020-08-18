package selenium_Session;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Selenium_Assignment.Frames_Assignment;

public class SignUp_Page {

	public static void main(String[] args) {
		String browser = "Chrome";
		WebdriverFactory wf = new WebdriverFactory();
		WebDriver driver = wf.launchBrowser(browser);
		wf.launchUrl("https://www.orangehrm.com/orangehrm-30-day-trial/");
		System.out.println(wf.gettitle());
		
		By subdomain = By.name("subdomain");
		By fname = By.name("FirstName");
		By lname = By.name("LastName");
		By email = By.name("Email");
		By jobt = By.name("JobTitle");
		By emp = By.name("NoOfEmployees");
		By comp = By.name("CompanyName");
		By industry = By.name("Industry");
		By phone = By.name("Contact");
		By country = By.name("Country");
		By checkbox = By.name("SetDummyData");
		
		ElementUtil util = new ElementUtil(driver);
		
		util.doSendKeys(subdomain, "tom cruise");
		util.doSendKeys(fname, "Tom");
		util.doSendKeys(lname, "Cruise");
		util.doSendKeys(email, "tomcruise08@gmail.com");
		util.doSendKeys(jobt, "Developer");
		util.doSelectByVisibleText(emp, "21 - 25");
		util.doSendKeys(comp, "Global Logic pvt ltd");
		util.doSelectByVisibleText(industry, "Aerospace");
		util.doSendKeys(phone, "98786798");
		util.doSelectByValue(country, "India");
		util.doClick(checkbox);
		
	}

}
