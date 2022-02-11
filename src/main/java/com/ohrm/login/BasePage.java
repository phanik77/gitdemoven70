package com.ohrm.login;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static Process process;
	
	public static void LaunchBrowser() {
		BasePage.LoadProperty();
		if(prop.getProperty("BrowserType").equalsIgnoreCase("IE")) {
			System.out.println("IE browser launched");
		}else if (prop.getProperty("BrowserType").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", 
					System.getProperty("user.dir") + "\\src\\main\\resources\\executablejars\\chromedriver.exe");
			
			driver = new ChromeDriver();
		}else if(prop.getProperty("BrowserType").equalsIgnoreCase("firefox")) {
			System.out.println("Firefox browser launched");
		}else if (prop.getProperty("BrowserType").equalsIgnoreCase("edge")) {
			System.out.println("Edge browser launched");
		}
		
		driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}
	// ************************Load config file**********************//
	public static Properties LoadProperty() {
		try {
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\Test Artifacts\\Config.properties");
			prop.load(fis);
			// test.log(Status.PASS, "The properties file loaded successfully");
			return prop;

		} catch (Exception e) {
			e.printStackTrace();
			// test.log(Status.FAIL, "The properties file not able to load");
			return prop;
		}
	}
	//*******************Edit text box************************************//
		public static void enterText(WebElement userName, String Data, String FieldName) {
			try {
				userName.sendKeys(Data);
				//test.log(Status.PASS, "The" + Data + "has been entered " + FieldName + "successfully");
			}
			catch (Exception e) {
				e.printStackTrace();
				//test.log(Status.FAIL, "The" + Data + "has not been entered " + FieldName + "successfully");
			}
		}
		//************************CLick button**********************************//
		
		public static void click(WebElement Object, String FieldName) {
			try {
				Object.click();
				//test.log(Status.PASS, FieldName+LogConstant.CLICKSUCESS);
			}
			catch(Exception e) {
				e.printStackTrace();
				//test.log(Status.FAIL, FieldName+LogConstant.CLICKERROR);
			}
		}
		
		//*************************String compare****************************************//
		public static int strcompare (String str1, String str2 ) {
			if(str1.compareTo(str2)==0) {
				//test.log(Status.PASS, str1 + "is same as" + str2);
				return (str1.compareTo(str2));
			}
			else {
				//test.log(Status.FAIL, str1 + "is not same as" + str2);
				return (str1.compareTo(str2));
			}
		}
		
		//**************************ELEMENT Exists********************************//
		public static boolean elementExists(List<WebElement> Object) {
			if(Object.size() == 0) {
				return true;
			}
			else {
				return false;
			}
		}
		//*****************************Close browser******************************//
		public static void closeBrowser() {
			driver.quit();
			try {
				process = Runtime.getRuntime().exec("taskkill /f /im chrome.exe");
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
}
