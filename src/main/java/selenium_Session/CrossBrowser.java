package selenium_Session;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class CrossBrowser {
	static WebDriver driver;

	public static void main(String[] args) {
		
		String browser = "chrome";
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "F:\\geckodriver.exe");
		    driver = new FirefoxDriver();
					
		} 
		else if (browser.equalsIgnoreCase("internetexplorer")) {
			System.setProperty("webdriver.IE.driver", "F:\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			
		}
		else {
			System.out.println("plz pass the correct browser name");
		}
		
		driver.get("https://www.youtube.com/");
		
		System.out.println(driver.getTitle());
		
		driver.quit();

		}

	}


