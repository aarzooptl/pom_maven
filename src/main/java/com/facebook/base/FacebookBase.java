package com.facebook.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.facebook.util.FacebookUtil;

public class FacebookBase {
	
	public static Properties prop;
	public static WebDriver driver;
	
	public FacebookBase() {
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Selenium_WorkSpace\\MavenPageObjectModel\\src\\main\\java\\com\\facebook\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	
	}
	
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\SeleniumJars\\chromedriver.exe");	
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("Firefox")){
			System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");	
			driver = new FirefoxDriver(); 
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(FacebookUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(FacebookUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
}
	
