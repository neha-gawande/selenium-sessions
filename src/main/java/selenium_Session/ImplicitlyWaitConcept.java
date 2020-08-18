package selenium_Session;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitlyWaitConcept {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("https://app.hubspot.com/login");
	//	System.out.println(driver.getTitle());
		
		driver.findElement(By.id("username")).sendKeys("Neha Gawande");//15
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("password")).sendKeys("Neha@1234");//5
		driver.findElement(By.id("loginBtn")).click();
		
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);//nullifying the implicit wait
//		webelment 4
//		e5
//		e6
		

	}

}
