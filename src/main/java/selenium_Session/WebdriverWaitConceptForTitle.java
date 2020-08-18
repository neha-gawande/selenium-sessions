package selenium_Session;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebdriverWaitConceptForTitle {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		
		String title = doGetPageTitleWithContains(driver, 10, "Amazon");
		System.out.println(title);
		
		System.out.println(doGetCurrentPageUrl(driver, 5, "amazon"));
		
		//wait.until(ExpectedConditions.titleIs("HubSpot Login"));
		//(tried for 2 second(s) with 500 milliseconds interval)
		//-->Timeout Exception if title is not found within given time
	}
	
	public static String doGetPageTitleWithContains(WebDriver driver,int timeout,String title) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.titleContains(title)); 
		return driver.getTitle();
	}
    public static String doGetPageTitleWithIs(WebDriver driver,int timeout,String title) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.titleIs(title)); 
		return driver.getTitle();
	}
    public static String doGetCurrentPageUrl(WebDriver driver,int timeout,String urlValue) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.urlContains(urlValue)); 
		return driver.getCurrentUrl();
	}
	

}
