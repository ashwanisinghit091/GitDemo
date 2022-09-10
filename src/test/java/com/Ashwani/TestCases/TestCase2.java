package com.Ashwani.TestCases;

import java.io.File;
import java.io.IOException;




import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Ashwani.WebPagesPackage.HomePage;
import com.Ashwani.WebPagesPackage.LoginWebPage;

public class TestCase2 extends BaseTest{

	WebDriver driver;
	TestCase2 TestCase2Ref;

	
	@BeforeMethod(alwaysRun=true)
	public void Intialization() throws IOException {
		TestCase2Ref=new TestCase2();
	driver=TestCase2Ref.LaunchApplication();

	}


	@AfterMethod(alwaysRun=true)
	public void closeCurrentWindow() {
		//TestCase2Ref.driverClose();
	}
	
	@Test(groups= {"Smoke"})
	public void identifyUnaddedProductInCart() throws InterruptedException, IOException {
		
		LoginWebPage LoginWebPageRef=new LoginWebPage(driver);

		HomePage HomePageRef=LoginWebPageRef.login("ashwanis824@gmail.com", "Unacademy@50S");
		List<WebElement> ProductAvailable =	HomePageRef.productAvailable();
		HomePageRef.checkProductsInHomePage(ProductAvailable);
		
	//getScreensShot("identifyUnaddedProductInCart", driver);
	}
	
}
