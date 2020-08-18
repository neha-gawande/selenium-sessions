package selenium_Session;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TagNameConcept {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		
//		List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"SIvCob\"]/a"));
		List<WebElement> elements = driver.findElements(By.tagName("a"));
		System.out.println(elements.size());
		for(int i=0;i<elements.size();i++) {
			String text = elements.get(i).getText();
		if(!text.isEmpty())
			System.out.println(text);
			
		}

	}
	} 
	
	


