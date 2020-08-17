package com.qa.hubspot.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;

import com.qa.hubspot.utils.OptionsManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	public WebDriver driver;
	public Properties prop;
	public OptionsManager optionsManager;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	@Parameters("browser")
	public WebDriver init_driver(Properties prop) {

		String browsername = prop.getProperty("browser").trim();
		System.out.println("Browser name is :" + browsername);
		optionsManager = new OptionsManager(prop);

		if (browsername.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver(optionsManager.getChromeoptions());
			tlDriver.set(new ChromeDriver(optionsManager.getChromeoptions()));
			
		} else if (browsername.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			//driver = new FirefoxDriver(optionsManager.getFirefoxoptions());
			tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxoptions()));
			
		} else if (browsername.equals("IE")) {
			WebDriverManager.iedriver().setup();
			//driver = new InternetExplorerDriver();
			tlDriver.set(new InternetExplorerDriver());
		} else {
			System.out.println(browsername + "is not found, please pass correct browser name");
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		getDriver().get(prop.getProperty("url"));

		return getDriver();

	}
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

	public Properties init_prop() {
		prop = new Properties();
		String path = null;
		String env = null;
		try {
			env = System.getProperty("env");
			System.out.println("Running on Environment-->" + env);

			if (env == null)
				path = ("F:\\All Applications\\POMdesign\\src\\main\\java\\com\\qa\\hubspot\\config\\config.properties");
			else
				switch (env) {
				case "qa":
					path = ("F:\\All Applications\\POMdesign\\src\\main\\java\\com\\qa\\hubspot\\config\\qa.config.properties");
					break;
				case "dev":
					path = ("F:\\All Applications\\POMdesign\\src\\main\\java\\com\\qa\\hubspot\\config\\dev.config.properties");
					break;

				default:
					System.out.println("please pass correct Environment");
					break;
				}
			FileInputStream ip = new FileInputStream(path);
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	//take screenshot
	public String getScreenshot() {
		File src = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/screenshot/" +System.currentTimeMillis() +".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

}
