package com.Ashwani.TestCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	
	 WebDriver driver;
		
		public  WebDriver invokeDriver() throws IOException {
			
			FileInputStream fp=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/Resources/ResourcesFile.properties");
		 Properties	 file=new Properties();
			
			file.load(fp);
			
			String DriverName="chrome";
			//String DriverName=System.getProperty("Browser")!=null?System.getProperty("Browser"):file.getProperty("Browser");
		System.out.println(DriverName);
			//String DriverName=file.getProperty("Browser");
			
		if(DriverName.contains("chrome")) {
			ChromeOptions c=new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if(DriverName.contains("Headless")) {
			
			c.addArguments("Headless");}
			 driver=new ChromeDriver(c);
			 driver.manage().window().setSize(new Dimension(1440,900));
			 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			 driver.manage().window().maximize();
			 driver.get(file.getProperty("URL"));
				}
			//return driver;
			

			

			else if (DriverName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver","E:\\geckodriver.exe");
			//WebDriverManager.chromedriver().setup();
			 driver=new FirefoxDriver();
			 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			 driver.manage().window().maximize();
			 driver.get(file.getProperty("URL"));
				}

			else if(DriverName.equalsIgnoreCase("Edgedriver")) {
			
			WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
			 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			 driver.manage().window().maximize();
			 driver.get(file.getProperty("URL"));
				}
			
			
		

			else if(DriverName.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver","E:\\IEDriverServer.exe");
				//System.setProperty("webdriver.ie.driver", "C:\\Users\\Downloads\\Selenium\\IEDriverServer_x64_3.150.1\\IEDriverServer.exe");

				InternetExplorerOptions options = new InternetExplorerOptions().setPageLoadStrategy(PageLoadStrategy.NONE);

				options.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				options.withInitialBrowserUrl("https://rahulshettyacademy.com/client");
				InternetExplorerDriver	 driver=new InternetExplorerDriver(options);
				//driver = new InternetExplorerDriver(ieCapabilities);
				 
			//WebDriverManager.chromedriver().setup();
			// driver=new ChromeDriver();
			 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			 driver.manage().window().maximize();
			 driver.get(file.getProperty("URL"));
				}
		
		
			
			return driver;
				
		}
		
		
		public WebDriver LaunchApplication() throws IOException {
		 driver=invokeDriver();
			
			return driver;
		}
		
		
		public void driverClose() {
			
			driver.close();
		}
		
	
		
		public String getScreensShot(String TestCaseName,WebDriver driver1) throws IOException {
			System.out.println(driver1);
			System.out.println(TestCaseName);
			TakesScreenshot screeShot=(TakesScreenshot)driver1;
		File screenShotFile=	screeShot.getScreenshotAs(OutputType.FILE);
		File filePath=new File(System.getProperty("user.dir")+"//Reports//"+TestCaseName+".png");
	    FileUtils.copyFile(screenShotFile, filePath);
	return System.getProperty("user.dir")+"//Reports//"+TestCaseName+".png";
			
		}
		

	public ExtentReports config() {
	String path=	System.getProperty("user.dir")+"//Reports//index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("TestNg Report");
		reporter.config().setDocumentTitle("WebSite Testing Report");
		reporter.config().setTimeStampFormat("DD/MM/YY");
		ExtentReports ex=new ExtentReports();
		ex.attachReporter(reporter);
		ex.setSystemInfo("Tester", "Ashwin");
		return ex;
		
		
		
	}	
	
}
