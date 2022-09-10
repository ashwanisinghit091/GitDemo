package com.Ashwani.ReusableMethodsPackage;

import java.util.concurrent.TimeUnit;






import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class Reusable {
	WebDriver driver;
	public Reusable(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public Reusable() {}

	

	
	
	@FindBy(css= "div [role=\"alertdialog\"]") WebElement VisiblityOfWebElement;
	@FindBy(css= "div [role=\"alertdialog\"]") WebElement InVisiblityOfWebElement;

	
	
	
	
	
	public void visiblityOfWebElement() {
		WebDriverWait wait=new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.visibilityOf(VisiblityOfWebElement));
	}
	
	
	public void inVisiblityOfWebElement() {
		WebDriverWait wait=new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.invisibilityOf(InVisiblityOfWebElement));
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
