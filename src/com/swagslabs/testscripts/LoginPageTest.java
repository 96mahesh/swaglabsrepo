package com.swagslabs.testscripts;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.swagslabs.pages.LoginPage;
import com.swagslabs.pages.ProductsPage;
import com.swagslabs.utils.Browser;
import com.swagslabs.utils.DataConfigConsatant;
import com.swagslabs.utils.ReadTestData;

public class LoginPageTest extends Browser {
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
	
	@Test(enabled = true)
	public void verifyFunctionalityOfLoginBtnWithUsernameAsBlankAndPasswordAsBlank()
	{
		LoginPage loginpage=new LoginPage(driver,"loginpage");
		loginpage.clickOnLoginBtn();
		
		Assert.assertEquals(loginpage.getCrossIconSize(), 2,"Test script Failed as 2 cross icon not displayed");
		Assert.assertTrue(loginpage.isCrossBtnVisible(),"Test script failed as cross btn not visible");
	    Assert.assertEquals(loginpage.getErrorMsg(), DataConfigConsatant.USERNAME_BLANK_ERRORMSG);;
	    System.out.println("Frist Thread id = "+Thread.currentThread().getId());
	}
	
	@Test(enabled = true)
	public void verifyFunctionalityOfLoginBtnWithUsernameAndPasswordAsBlank()
	{
		ReadTestData read= new ReadTestData("loginpage");
		String username=read.getData(5, 0);
		
		LoginPage loginpage=new LoginPage(driver,"loginpage");
		loginpage.setUsername(username);
		loginpage.clickOnLoginBtn();
		Assert.assertEquals(loginpage.getCrossIconSize(), 2,"Test script Failed as 2 cross icon not displayed");
		Assert.assertTrue(loginpage.isCrossBtnVisible(),"Test script failed as cross btn not visible");
	    Assert.assertEquals(loginpage.getErrorMsg(), DataConfigConsatant.PASSWORD_BLANK_ERRORMSG);
	    System.out.println("secound Thread id = "+Thread.currentThread().getId());
	}
	@Test(enabled = true)
	public void verifyFunctionalityOfLoginBtnWithInvalidUsernameAndInvalidPassword()
	{
		ReadTestData read= new ReadTestData("loginpage");
		List<String> rowdata=read.getData(10);
		
		LoginPage loginpage=new LoginPage(driver,"loginpage");
		loginpage.setUsername(rowdata.get(0));
		loginpage.setPassword(rowdata.get(1));

		loginpage.clickOnLoginBtn();
		Assert.assertEquals(loginpage.getCrossIconSize(), 2,"Test script Failed as 2 cross icon not displayed");
		Assert.assertTrue(loginpage.isCrossBtnVisible(),"Test script failed as cross btn not visible");
	    Assert.assertEquals(loginpage.getErrorMsg(), DataConfigConsatant.USERNAME_PASSWORD_INVALID_ERRORMSG);
	    System.out.println("Throd Thread id = "+Thread.currentThread().getId());
	}
	
	@Test(enabled = true)
	public void verifyFunctionalityOfLoginBtnWithvalidUsernameAndvalidPassword()
	{
		ReadTestData read= new ReadTestData("loginpage");
		List<String> rowdata=read.getData(1);
		
		LoginPage loginpage=new LoginPage(driver,"loginpage");
		loginpage.setUsername(rowdata.get(0));
		loginpage.setPassword(rowdata.get(1));

		loginpage.clickOnLoginBtn();
		
		ProductsPage productspage= new ProductsPage(driver,"productspage");
		Assert.assertTrue(productspage.isSwagLabLabelVisible(), "Test script failed as swaglabs label is not visible");
		Assert.assertTrue(productspage.isProductsLabelVisible(), "Test script failed as Products label is not visible");
	
	}
	
	@Test(enabled = true)
	public void verifyFunctionalityOfCrossBtn()
	{
		
		
		LoginPage loginpage=new LoginPage(driver,"loginpage");
		loginpage.clickOnLoginBtn();
		
		Assert.assertEquals(loginpage.getCrossIconSize(), 2,"Test script Failed as 2 cross icon not displayed");
		Assert.assertTrue(loginpage.isCrossBtnVisible(),"Test script failed as cross btn not visible");
	    Assert.assertEquals(loginpage.getErrorMsg(), DataConfigConsatant.USERNAME_BLANK_ERRORMSG);;
	
	    loginpage.clickOnCrossSymbol();
	    Assert.assertEquals(loginpage.getCrossIconSize(), 0,"Test script Failed as 2 cross icon  displayed");
		Assert.assertFalse(loginpage.isCrossBtnVisible(),"Test script failed as cross btn  visible");
	
	}
	
	
	
	
}









