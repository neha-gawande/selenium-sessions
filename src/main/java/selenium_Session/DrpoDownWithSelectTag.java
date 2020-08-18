package selenium_Session;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DrpoDownWithSelectTag {
	static WebDriver driver; 
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
//		1.
//		WebElement day = driver.findElement(By.id("day"));
//		Select select = new Select(day);
//		select.selectByVisibleText("8");
//		select.selectByIndex(6);
//		select.selectByValue("17");
//		
//		WebElement month = driver.findElement(By.id("month"));
//		Select select1 = new Select(month);
//		select1.selectByVisibleText("Mar");
		
//		2.
		By day = By.id("day");
		By month = By.id("month");
		By year = By.id("year");
		By emp = By.name("NoOfEmployees");
		By industry = By.name("Industry");
		By country = By.name("Country");
		
//		doSelectByVisibleText(day, "10");
//		doSelectByVisibleText(month, "Mar");
//		doSelectByVisibleText(year, "1994");
		
//		doSelectByValue(day, "5");
//		doSelectByValue(month, "3");
//		doSelectByValue(year, "28");
		
//		doSelectByIndex(day, 6);
//		doSelectByIndex(month, 7);
//		doSelectByIndex(year, 5);
		
		doSelectByVisibleText(emp, "11 - 15");
		doSelectByVisibleText(industry, "Automotive");
		doSelectByVisibleText(country, "India");
		
		Thread.sleep(5000);
		driver.quit();
		
	}
	
	public static void doSelectByVisibleText(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(value);
		
	}
	public static void doSelectByValue(By locator,String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
		
	}
	public static void doSelectByIndex(By locator,int index) {
		Select select = new Select(getElement(locator));
		select.deselectByIndex(index);
	}
	
	public static WebElement getElement(By locator) {
		WebElement element = driver.findElement(locator);
		return element;
		
	}
	
}
