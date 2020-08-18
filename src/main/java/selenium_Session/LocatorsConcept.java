package selenium_Session;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorsConcept {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
        //1.
		//driver.findElement(By.name("subdomain")).sendKeys("ankur.wadatkar");
		//driver.findElement(By.name("FirstName")).sendKeys("Ankuri");
		//driver.findElement(By.name("LastName")).sendKeys("Wadatkar");
		//driver.findElement(By.className("action")).click();
		
		//2.
		//WebElement email = driver.findElement(By.id("email"));
		//WebElement password = driver.findElement(By.id("pass"));
		
		//email.sendKeys("ankur.wadatkar@gmail.com");
		//password.sendKeys("sds@124");
		
		//3.
		By email = By.name("subdomain");
	    By Fname = By.name("FirstName");
		By Lname= By.name("LastName");
		By Submit = By.name("action_request");
		
//		driver.findElement(email).sendKeys("Ankuri");
//  	    driver.findElement(Fname).sendKeys("Wadatkar");
//		driver.findElement(Lname).sendKeys("ankur.wadatkar");
//        
		//4.
//	    getElement(email).sendKeys("ankur.wadatkar");
//	    getElement(Fname).sendKeys("Ankuri");
//	    getElement(Lname).sendKeys("Wadatkar");
		
		//5
		doSendkey(email, "ankur.wadatkar");
		doSendkey(Fname, "Ankuri");
		doSendkey(Lname, "Wadatkar");
		doClick( Submit);

	}
	
	public static WebElement getElement(By locator) {
		WebElement element = driver.findElement(locator);
		return element;
	
	}
	
	public static void doSendkey(By locator,String value) {
		getElement(locator).sendKeys(value);
		
	}
	
	public static void doClick(By locator) {
		getElement(locator).click();;
		 
	}

}
