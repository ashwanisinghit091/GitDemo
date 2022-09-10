package com.Ashwani.WebPagesPackage;






import java.util.List;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Ashwani.ReusableMethodsPackage.Reusable;



public class PaymentWebPage extends Reusable {



@FindBy(css="div[class=\"form-group\"] input") WebElement SelectCountry;
@FindBy(css="section[class=\"ta-results list-group ng-star-inserted\"] button span") List<WebElement>CountryList;
@FindBy(xpath="//div[@class=\"actions\"]/a") WebElement Submit;






	WebDriver driver;
	public PaymentWebPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void  selectCountry() throws InterruptedException {
		
		SelectCountry.click();
		SelectCountry.sendKeys("in");
		for(int i=0;i<CountryList.size();i++) {
			SelectCountry.sendKeys(Keys.ARROW_DOWN);
	
		if(CountryList.get(i).getText().equalsIgnoreCase("Dominica")) { 
			Thread.sleep(1000);
			SelectCountry.sendKeys(Keys.ENTER);
			
			break;
		}
	}
	
	}
	
	
	public OrderConfirmationWebPage submit() {
		
	Submit.click();
	return new OrderConfirmationWebPage(driver);
	}
	

	
}
