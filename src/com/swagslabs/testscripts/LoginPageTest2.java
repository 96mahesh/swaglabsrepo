package com.swagslabs.testscripts;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.swagslabs.pages.LoginPage;
import com.swagslabs.pages.ProductsPage;
import com.swagslabs.utils.Browser;
import com.swagslabs.utils.DataConfigConsatant;
import com.swagslabs.utils.ReadTestData;

public class LoginPageTest2 extends Browser {
	WebDriver driver;
	@BeforeMethod
	@Parameters("browsername")
	public void setup(String browsername)
	{
		driver=launchBrowser(browsername);
		openURL();
	}
	
	@AfterMethod
	public void teardown()
	{
		close();
	}
	
	
	
	
	
	@Test(dataProvider="logindata")
	public void verifyFunctionalityOfLoginBtnWithvalidUsernameAndvalidPassword(String uname,String pass)
	{
		
		
		LoginPage loginpage=new LoginPage(driver,"loginpage");
		loginpage.setUsername(uname);
		loginpage.setPassword(pass);

		loginpage.clickOnLoginBtn();
		
		ProductsPage productspage= new ProductsPage(driver,"productspage");
		Assert.assertTrue(productspage.isSwagLabLabelVisible(), "Test script failed as swaglabs label is not visible");
		Assert.assertTrue(productspage.isProductsLabelVisible(), "Test script failed as Products label is not visible");
	
	}
	
	@DataProvider(name="logindata")
	public Object[][] getData()
	{
		ReadTestData read= new ReadTestData("loginpage");
		String  data[][]=read.getData();
		return data;
	}
	
	
	
}









