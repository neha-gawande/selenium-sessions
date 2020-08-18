package selenium_Session;

import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryDropDownConcept {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.findElement(By.id("justAnInputBox")).click();
		By allchoices = By.cssSelector("span.comboTreeItemTitle");
		selectChoiceValues(allchoices,"choice 2","choice 6","choice 7","choice 4","choice 6 2");
		

	}
	public static void selectChoiceValues(By locator,String... Value) {
		List<WebElement> choicelist = driver.findElements(locator);
		for(int i=0;i<choicelist.size();i++) {
			String text = choicelist.get(i).getText();
			System.out.println(text);
			
			for(int k=0;k<Value.length;k++) {
				if(text.equals(Value[k])) {
					choicelist.get(i).click();
					break;
				}
			}
			
		}
	}
}
