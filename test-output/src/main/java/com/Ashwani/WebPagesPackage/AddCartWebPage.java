package com.Ashwani.WebPagesPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Ashwani.ReusableMethodsPackage.Reusable;

import junit.framework.Assert;











public class AddCartWebPage extends Reusable{
	
	
	
	
	@FindBy(css="[class=\"infoWrap\"]") List<WebElement> AddedProductsInCart;
	@FindBy(css="div [class=\"infoWrap\"] div:last-of-type button:first-of-type") WebElement SelectProductForOrder;
	
	
WebDriver driver;
	public AddCartWebPage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	public  List<WebElement> addedProductsInCart() {
	
		return AddedProductsInCart;
	}
	
	public PaymentWebPage selectProductForOrder(List<WebElement> AddedProductsInCart){ 
	        
		boolean flag=AddedProductsInCart.stream().anyMatch(SelectedProduct->
		SelectedProduct.findElement(By.cssSelector("h3")).getText().equalsIgnoreCase("ADIDAS ORIGINAL"));
		Assert.assertTrue(flag);
		SelectProductForOrder.click();
		return new PaymentWebPage(driver);
	}	
	
	public void remainingProduct(List<WebElement> AddedProductsInCart) {
		
		Assert.assertTrue(AddedProductsInCart.size()>0);
	}
	
}
