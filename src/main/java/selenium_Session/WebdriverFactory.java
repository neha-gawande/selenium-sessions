package selenium_Session;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebdriverFactory {
	public WebDriver driver;
	/**
	 * This method is used to launch the browser
	 * @param browser
	 * @return driver		
	 */
	public WebDriver launchBrowser(String browser) {
	
	System.out.println();
	if(browser.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	else if (browser.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
	    driver = new FirefoxDriver();
				
	} 
	else if (browser.equalsIgnoreCase("internetexplorer")) {
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();
		
	}
	else {
		System.out.println("plz pass the correct browser name" +browser);
	}
	return driver;
	}
	/**
	 * This method is used to launch the url on the basis of given browser name
	 * @param url
	 */
	public void launchUrl(String url) {
		driver.get(url);
	}
	/**
	 * This methos is used to get the title
	 * @return page title
	 */
	public String gettitle() {
		return driver.getTitle();
	}
	/**
	 * This method is used to get current url of page
	 * @param url
	 */
	public void getPageCurrentUrl(String url) {
		driver.getCurrentUrl();
	}
	/**
	 * This method is used to close the browser
	 */
	public void closeBrowser() {
		driver.quit();
		
	}
}
