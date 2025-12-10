package com.adactinhotelapp.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;

public class BaseTest {
	public static WebDriver driver;
	public static FileInputStream fis1;
	public static Properties configProp;
	public static ExtentReports reports; 

	@BeforeTest
	public void fileSetup() throws IOException {
		fis1 = new FileInputStream("src\\test\\resources\\properties\\config.properties");
		configProp = new Properties();
		configProp.load(fis1);

	}
	@BeforeMethod
	public void setup() {
		String browserName=configProp.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		
		else if(browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		driver.get(configProp.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
