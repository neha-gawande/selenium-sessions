package selenium_Session;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WMTest {

	public static void main(String[] args) {
		
		/*WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");//enter url
		String actualTitle = driver.getTitle();
		System.out.println("page title is:" +actualTitle);
		
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver1 = new FirefoxDriver();
		driver1.get("https://www.amazon.com/");//enter url
		String actualTitle = driver1.getTitle();
		System.out.println("page title is:" +actualTitle);*/
		
		WebDriverManager.iedriver().setup();
		WebDriver driver2 = new InternetExplorerDriver();
		driver2.get("https://www.amazon.com/");//enter url
		String actualTitle = driver2.getTitle();
		System.out.println("page title is:" +actualTitle);
		
		

	}

}
