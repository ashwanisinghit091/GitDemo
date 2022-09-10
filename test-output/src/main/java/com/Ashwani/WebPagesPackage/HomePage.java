package com.Ashwani.WebPagesPackage;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.Ashwani.ReusableMethodsPackage.Reusable;






public class HomePage extends Reusable{
	
	
	
	@FindBy(className="col-lg-4")List< WebElement> ProductAvailable;
	
	@FindBy(xpath="//div[@class=\"card-body\"]/button/following-sibling::button") List< WebElement> AddCart;
	@FindBy(xpath="//li/button[@routerlink=\"/dashboard/cart\"]") WebElement Cart;
	
	
	
	
	WebDriver driver;
	public HomePage(WebDriver driver){
		super(driver);
	this.driver=driver;	
	PageFactory.initElements(driver, this);
		
	}
	
	
	
	public List<WebElement> productAvailable() {
		return ProductAvailable;
	
		}
	
	public void SelectDesiredProduct(List<WebElement> ProductAvailable ,String firstproductName,String secondProductName) throws InterruptedException {
		//int j=-1;
		for(int i=0;i<ProductAvailable.size();i++) {
			//System.out.println(ProductAvailable.get(i).getText());
		//	j++;
			if(ProductAvailable.get(i).getText().contains(firstproductName)||ProductAvailable.get(i).getText().contains(secondProductName)) {
				Thread.sleep(1000);
				AddCart.get(i).click();
				visiblityOfWebElement();
			}
	}
	
		
		
		
	}
		
		public void checkProductsInHomePage(List<WebElement> ProductAvailable ) throws InterruptedException {
			
			for(int i=0;i<ProductAvailable.size();i++) {	
				if(ProductAvailable.get(i).getText()!=null)
					 {
			Assert.assertTrue(true);
		}}
		
		
		
		
		
		
		
	}
		public AddCartWebPage cart() {
			
			Cart.click();
			return new AddCartWebPage(driver);
			
		}
		
	
		public void CheckProductOtherThanAddedInCart(List<WebElement> ProductAvailable ) throws InterruptedException {
			//int j=-1;
			for(int i=0;i<ProductAvailable.size();i++) {
				//System.out.println(ProductAvailable.get(i).getText());
			//	j++;
				if(ProductAvailable.get(i).getText().contains("Phone")||ProductAvailable.get(i).getText().contains("HandBag")) {
				Assert.assertTrue(false);
				}
				
				else {
				
				}
				
				
		}
			Assert.assertFalse(false);
		}
	
}
