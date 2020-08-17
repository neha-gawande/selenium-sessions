package com.qa.hubspot.utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	private WebDriver driver;
	
    //Alt + shift S O
	public ElementUtil(WebDriver driver) {
		this.driver = driver;
		
	}
	/**
	 * This method is used to create WebElement on the basis of locator
	 * @param locator
	 * @return WebElement
	 */
	
	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			element = driver.findElement(locator);
			
		} catch (Exception e) {
			System.out.println("WebElement cant not be created");
		}
		return element;
	}
	public void doGetClick(By locator) {
		getElement(locator).click();
	}
	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	public String doGetText(By locator) {
		return getElement(locator).getText();
	}
	public boolean doIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}
	//*************Actions Utils*******************
	public void doActionClick(By locator) {
		Actions ac = new Actions(driver);
		ac.click(getElement(locator)).perform();
	}
	public void doActionSenkeys(By locator,String value) {
		Actions ac  = new Actions(driver);
		ac.sendKeys(getElement(locator),value).perform();	
	}
	//*************DropDown Utils*******************
	public  List<String> doDropDownOptionsValue(By locator) {
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
	public void doSelectByVisibleText(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(value);
	}
	public void doSelectByValue(By locator,String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}
	public void doSelectByIndex(By locator,int index) {
		Select select = new Select(getElement(locator));
		select.deselectByIndex(index);
	}
	/**
	 * 
	 * @param locator
	 * @param values
	 */
	public void selectValuesFromDropDown(By locator, String values) {
	List<WebElement> dayList = driver.findElements(By.xpath("//*[@id=\"day\"]/option"));
	for(int i=0;i<dayList.size();i++) {
		String text = dayList.get(i).getText();
		if(text.equals(values)) {
		dayList.get(i).click();	
		break;	
		}
	}
	
   }
	//*************Wait Utils*******************
    public String doGetPageTitleWithContains(int timeout,String title) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.titleContains(title)); 
		return driver.getTitle();
	}
    public String doGetPageTitleWithIsTitle(int timeout,String title) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.titleIs(title)); 
		return driver.getTitle();
	}
    public String doGetCurrentPageUrl(int timeout,String urlValue) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.urlContains(urlValue)); 
		return driver.getCurrentUrl();
	}
    public WebElement waitForElementPresent(By locator,int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
    public WebElement waitForElementToBeClickable(By locator,int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
    	return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
    public WebElement waitForElementToBeVisible(By locator,int timeout) {
    	WebElement element = getElement(locator);
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
    public List<WebElement> visibitilyofAllElements(By locator,int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
    public void clickWhenReady(By locator,int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}
    public void waitForAlertPresent(int timeout) {
    	WebDriverWait wait = new WebDriverWait(driver, timeout);
    	Alert alert =  wait.until(ExpectedConditions.alertIsPresent());
//    	Alert alert = driver.switchTo().alert();
		alert.sendKeys("1");
		alert.accept();
		driver.switchTo().defaultContent();
	}
    public static boolean isElemetDisplayed(WebDriver driver, By locator,int timeout) {
		WebElement element = null;
		boolean flag = false;
		for(int i=0;i<timeout;i++) {
			try {
				element = driver.findElement(locator);
				flag = element.isDisplayed();
				break;
			} catch (Exception e) {
				System.out.println("waiting for element to be present on the page-->" + i +"secs");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
				}
			}
	     }
		return flag;
    }
  //*************FluentWait Utils*******************
    public static WebElement waitForElementwithFluentwaitConcept(WebDriver driver,By locator,int timeOut){
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	public static WebElement waitForElementwithFluentwait(WebDriver driver, final By locator,int timeOut) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);
		
		WebElement element = wait.until(new Function<WebDriver,WebElement>(){

			@Override
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		});
		return element;
	}
		
}
