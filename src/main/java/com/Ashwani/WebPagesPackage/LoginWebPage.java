package com.Ashwani.WebPagesPackage;









import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Ashwani.ReusableMethodsPackage.Reusable;







public class LoginWebPage extends Reusable{
	
	
	
	@FindBy(id="userEmail") WebElement userEmail;
	@FindBy(id="userPassword") WebElement userPassword;		
	@FindBy(id="login") WebElement LoginClick;
    @FindBy(css="div[id=\"toast-container\"] div div") WebElement InvalidLoginMessage;
WebDriver driver;
	
	public LoginWebPage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	




	public HomePage login(String UserEmail,String UserPassword) throws InterruptedException {
	
		userEmail.click();
		userEmail.sendKeys(UserEmail);
		userPassword.click();
		userPassword.sendKeys(UserPassword);
		LoginClick.click();
	
	    return new HomePage(driver);
		
	}
	
	
	public void inValidLogin(String UserEmail,String UserPassword) {
		
		userEmail.click();
		userEmail.sendKeys(UserEmail);
		userPassword.click();
		userPassword.sendKeys(UserPassword);
		LoginClick.click();
	    InvalidLoginMessage.getText();
	    Assert.assertEquals(" Incorrect email or password. ", InvalidLoginMessage.getText());
	}
	
	
}
