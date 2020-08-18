package selenium_Session;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadlessBrowser {
	static String expectedTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";

	public static void main(String[] args) throws InterruptedException {
		try {
			WebDriverManager.chromedriver().setup();

			ChromeOptions co = new ChromeOptions();
			co.addArguments("--headless");

			WebDriver driver = new ChromeDriver(co);// to launch the browser
			driver.get("https://www.amazon.com/");// enter url

			String actualTitle = driver.getTitle();
			System.out.println("page title is:" + actualTitle);

			// validation: expected vs actual result
			if (expectedTitle.equals(actualTitle)) {
				System.out.println("correct title");
			} else
				System.out.println("incorrect title");

			String url = driver.getCurrentUrl();
			System.out.println(url);
			if (url.contains("amazon")) {
				System.out.println("Correct url");
			} else {
				System.out.println("Incorrect url");
			}
			Thread.sleep(3000);
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
