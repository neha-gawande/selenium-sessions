package Selenium_Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames_Assignment {
	private WebDriver driver;
	    
	    public Frames_Assignment(WebDriver driver) {
			this.driver = driver;
		}
		public WebElement getElement(By locator) {
			WebElement element = null;
			try {
				element = driver.findElement(locator);
				
			} catch (Exception e) {
				System.out.println("WebElement cant not br created");
			}
			return element;
		}
		
		public boolean isDisplayed(By locator) {
			return getElement(locator).isDisplayed();
		}

}
