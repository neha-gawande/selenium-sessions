package selenium_Session;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownSelectConcept {
	static WebDriver driver; 

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		By emp = By.name("NoOfEmployees");
		By industry = By.name("Industry");
		By country = By.name("Country");
		
		List<String> empList = doDropDownOptionsValue(emp);
		System.out.println(empList);
		
		List<String> instryList = doDropDownOptionsValue(industry);
		System.out.println(industry);
		
		List<String>countryList = doDropDownOptionsValue(country);
		System.out.println(countryList);
		

	}
	public static List<String> doDropDownOptionsValue(By locator) {
		Select select = new Select(getElement(locator));
		List <String> optionList = new ArrayList<String>();
		
		List<WebElement> dropList = select.getOptions();
		System.out.println(dropList.size());
		
		for(int i=0;i<dropList.size();i++) {
			String text = dropList.get(i).getText();
			//System.out.println(i+"-->" +text);
			optionList.add(text);
		} 
		return optionList;
	}
	public static WebElement getElement(By locator) {
		WebElement element = driver.findElement(locator);
		return element;
	}
}
