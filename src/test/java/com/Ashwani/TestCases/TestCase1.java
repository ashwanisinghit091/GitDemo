package com.Ashwani.TestCases;








import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Ashwani.DataFile.JsonClass;
import com.Ashwani.WebPagesPackage.AddCartWebPage;
import com.Ashwani.WebPagesPackage.HomePage;
import com.Ashwani.WebPagesPackage.LoginWebPage;
import com.Ashwani.WebPagesPackage.OrderConfirmationWebPage;
import com.Ashwani.WebPagesPackage.PaymentWebPage;





public class TestCase1 extends BaseTest  {
	
	
	TestCase1 TestCase1Ref;
	 WebDriver driver;
	 OrderConfirmationWebPage OrderConfirmationWebPageRef;
	 AddCartWebPage AddCartWebPageRef;
	 HomePage HomePageRef;
	 LoginWebPage LoginWebPageRef;
	 PaymentWebPage PaymentWebPageRef;
	 int a;
	 
	 

@Test(groups={"Smoke"},dataProvider ="getDataFromJason")
public void validateLoginWithCorrectCred(HashMap<String,String> details) throws InterruptedException, IOException {
	



    LoginWebPageRef=new LoginWebPage(driver);
    HomePageRef=LoginWebPageRef.login(details.get("Email"), details.get("Password"));
	HomePageRef.SelectDesiredProduct(HomePageRef.productAvailable(),details.get("FirstProductName"),details.get("SecondProductName"));
    AddCartWebPageRef=	HomePageRef.cart();
    PaymentWebPageRef =AddCartWebPageRef.selectProductForOrder(AddCartWebPageRef.addedProductsInCart());
	PaymentWebPageRef.selectCountry();
    OrderConfirmationWebPageRef=PaymentWebPageRef.submit();
	OrderConfirmationWebPageRef.orderConfirmationByText();

	
	
	

	
}


@AfterMethod(alwaysRun=true)
public void closeCurrentWindow() {
	TestCase1Ref.driverClose();
}

@BeforeMethod(alwaysRun=true)
public void nvokeApplication() throws IOException {
	TestCase1Ref=new TestCase1();
	driver=TestCase1Ref.LaunchApplication();
}


@Test(dataProvider ="getDataForLogin",retryAnalyzer=RerunTest.class)
public void validateLoginWithWrongCred(String Usermail, String Password) {
	
	LoginWebPage LoginWebPageRef=new LoginWebPage(driver);
	LoginWebPageRef.inValidLogin(Usermail, Password);
}

@Test(dataProvider ="getDataForLogin")
public void validateLoginWithValidCred(String Usermail, String Password) throws InterruptedException {
	
	LoginWebPage LoginWebPageRef=new LoginWebPage(driver);
	LoginWebPageRef.login(Usermail, Password);
}


@DataProvider()
public Object[][] getData()
{
	HashMap<String,String> hash=new HashMap<String,String>();
	hash.put("Email", "ashwanis824@gmail.com");
	hash.put("Password", "Unacademy@50S");
	hash.put("FirstProductName", "IPHONE 13 PRO");
	hash.put("SecondProductName", "ADIDAS ORIGINAL");
	
	
	HashMap<String,String> hash1=new HashMap<String,String>();
	
	hash1.put("Email", "ashwanis824@gmail.com");
	hash1.put("Password", "Unacademy@50S");
	hash1.put("FirstProductName", "ZARA COAT 3");
	hash1.put("SecondProductName", "ADIDAS ORIGINAL");
	
	Object data [][]={ {hash},{hash1}};

	return data;

}



@DataProvider()
public Object[][] getDataFromJason() throws IOException
{
	JsonClass js=new JsonClass();
	List<HashMap<String,String>> data1=js.dataReader();
	 Object data [][]={ {data1.get(0)},{data1.get(1)}};

	  
	 
	 return  data; }







@DataProvider()
public String[][] getDataForLogin()
{
	
	
	String data [][]={ {"ashwanis824@gmail.com","Unacademy@50S"},{"ashwanis824@gmail.com","Unacademy@50S"}};

	return data;

}



@Test(dataProvider ="getData")
public void CheckCartAfterOrder(HashMap<String,String> details) throws InterruptedException {


	LoginWebPageRef=new LoginWebPage(driver);
    HomePageRef=LoginWebPageRef.login(details.get("Email"), details.get("Password"));
	HomePageRef.SelectDesiredProduct(HomePageRef.productAvailable(),details.get("FirstProductName"),details.get("SecondProductName"));
    AddCartWebPageRef=	HomePageRef.cart();
    PaymentWebPageRef =AddCartWebPageRef.selectProductForOrder(AddCartWebPageRef.addedProductsInCart());
	PaymentWebPageRef.selectCountry();
    OrderConfirmationWebPageRef=PaymentWebPageRef.submit();
    OrderConfirmationWebPageRef=OrderConfirmationWebPageRef.orderConfirmationByText();
    OrderConfirmationWebPageRef.cart();
    
    System.out.println("yes");
    System.out.println("yes");
    System.out.println("yes");
    System.out.println("yes");
    System.out.println("yes");
    System.out.println("yes");

 System.out.println("yup");
    System.out.println("yup");
    System.out.println("yup");
    System.out.println("yup");
    System.out.println("yup");
    System.out.println("yup");

   


}}
