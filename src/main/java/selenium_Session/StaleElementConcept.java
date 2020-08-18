package selenium_Session;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaleElementConcept {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		Thread.sleep(5000);
		
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		WebElement element = driver.findElement(By.name("subdomain"));
		element.sendKeys("nehagawande@gmail.com");
		Thread.sleep(3000);
		driver.navigate().refresh();
		
		element = driver.findElement(By.name("subdomain"));
		element.sendKeys("neharaje@gmail.com");
		Thread.sleep(3000);
		
		driver.quit();
		

		

	}

}
