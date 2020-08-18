package selenium_Session;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBasics {
	static String expectedTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","F:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();//to launch the browser
		driver.get("https://www.amazon.com/");//enter url
		
		String actualTitle = driver.getTitle();
		System.out.println("page title is:" +actualTitle);
		
		//validation: expected vs actual result
		if(expectedTitle.equals(actualTitle)) {
			System.out.println("correct title");
		}
		else
			System.out.println("incorrect title");
		
		
		String url = driver.getCurrentUrl();
		System.out.println(url);
		 if(url.contains("amazon")) {
			 System.out.println("Correct url");
		 }
		 else{
			 System.out.println("Incorrect url");
		 }
		  Thread.sleep(3000);
		  driver.quit();

	}

}
