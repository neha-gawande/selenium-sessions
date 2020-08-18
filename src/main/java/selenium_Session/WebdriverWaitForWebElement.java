package selenium_Session;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebdriverWaitForWebElement {
	
	public static void main(String [] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.freshworks.com/");
		
		By emailId = By.id("username");
		By password = By.id("password");
		By loginbutton = By.id("loginBtn");
		By SignIn = By.name("proceed");
		By footerlinks =By.cssSelector("ul.footer-nav li a");
//		waitForElementPresent(driver, 10, emailId).sendKeys("gawande@gmail.com");;
//		driver.findElement(password).sendKeys("Test12345");
//		
//		wait.until(ExpectedConditions.elementToBeClickable(loginbutton)).click();
//		waitForElementPresent(driver, 10, loginbutton).click();
//		driver.switchTo().alert().accept();
		
//		driver.findElement(By.name("proceed")).click();
		ElementUtil elementutil = new ElementUtil(driver);
		List<WebElement> footerLinksList = elementutil.visibitilyofAllElements(footerlinks, 10);
		System.out.println(footerLinksList.size());
		for (WebElement ele : footerLinksList) {
			System.out.println(ele.getText());	
		}
		
//		System.out.println(elementutil.doGetCurrentPageUrl(10,"login"));
//		elementutil.clickWhenReady(SignIn, 5);
//		Alert alert = waitForAlertPresent(driver, 10);
//		System.out.println(alert.getText());
//		alert.accept();
	}
	public static WebElement waitForElementPresent(WebDriver driver, int timeout,By locator) {
		WebDriverWait wait = new WebDriverWait(driver,timeout);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	public static Alert waitForAlertPresent(WebDriver driver,int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.alertIsPresent());
	}

}
