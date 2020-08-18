package selenium_Session;

import java.util.List;

import javax.xml.soap.Text;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class selectValueWithoutSelectClass {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		By day = By.name("birthday_day");
		By month = By.name("birthday_month");
		By year = By.name("birthday_year");
		
		List<WebElement> dayList = driver.findElements(By.xpath("//*[@id=\"day\"]/option"));
		System.out.println(dayList.size());
		
		for(int i=0;i<dayList.size();i++) {
			String text = dayList.get(i).getText();
			System.out.println(text);
			if(text.equals("8")) {
			dayList.get(i).click();	
			break;	
			}
		}
	}
}
