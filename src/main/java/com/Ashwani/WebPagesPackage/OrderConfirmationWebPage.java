package com.Ashwani.WebPagesPackage;

import org.junit.Assert;











import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Ashwani.ReusableMethodsPackage.Reusable;

public class OrderConfirmationWebPage extends Reusable {

	
	
	
	@FindBy(className="hero-primary") WebElement OrderConfirmationByText;
	@FindBy(css="li button[routerlink=\"/dashboard/cart\"]") WebElement Cart1;
	WebDriver driver;
	
	public OrderConfirmationWebPage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
public OrderConfirmationWebPage orderConfirmationByText() {
	
	Assert.assertTrue(driver.findElement(By.className("hero-primary")).getText().equalsIgnoreCase("Thankyou for the order."));
	
	return new OrderConfirmationWebPage(driver)  ;
	
}
	
public AddCartWebPage cart() {
	
	
	
	Cart1.click();
	
	
	return new AddCartWebPage(driver);
	
	
}
	
}
