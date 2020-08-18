package selenium_Session;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomWait {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://app.hubspot.com/login");
		By emailId = By.id("username");
		By password = By.id("password");
		By loginbutton = By.id("loginBtn");
		//System.out.println(isElemetDisplayed(driver, emailId, 10));
		isWebElemetDisplayed(driver, emailId, 10).sendKeys("snehal@gmail.com");
		
	}
	//using static wait internally under dynamic wait
	public static boolean isElemetDisplayed(WebDriver driver, By locator,int timeout) {
		WebElement element = null;
		boolean flag = false;
		for(int i=0;i<timeout;i++) {
			try {
				element = driver.findElement(locator);
				flag = element.isDisplayed();
				break;
			} catch (Exception e) {
				System.out.println("waiting for element to be present on the page-->" + i +"secs");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					
				}
			}
	     }
		return flag;
}
	public static WebElement isWebElemetDisplayed(WebDriver driver, By locator,int timeout) {
		WebElement element = null;
		boolean flag = false;
		for(int i=0;i<timeout;i++) {
			try {
				element = driver.findElement(locator);
				flag = element.isDisplayed();
				break;
			} catch (Exception e) {
				System.out.println("waiting for element to be present on the page-->" + i +"secs");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					
				}
			}
	     }
		return element;
}
}