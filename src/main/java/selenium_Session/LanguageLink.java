package selenium_Session;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LanguageLink {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.co.in/");
		List<WebElement> lanlink = driver.findElements(By.xpath("//*[@id=\"SIvCob\"]/a"));
		
		System.out.println(lanlink.size());
		for(int i=0;i<lanlink.size();i++) {
			lanlink.get(i).click();
			
			lanlink = driver.findElements(By.xpath("//*[@id=\"SIvCob\"]/a"));
		}
			
		 
		

	}

}
