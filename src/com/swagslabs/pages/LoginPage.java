package com.swagslabs.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.swagslabs.utils.SmartFunctions;

public class LoginPage extends SmartFunctions {

	
	public LoginPage(WebDriver driver, String filename) {
		super(driver, filename);
		
	}

	public void clickOnLoginBtn()
	{
		this.waitAndclick("loginBtn");
	}
	
	public void setUsername(String username)
	{
		this.waitAndSetText("username",username );
	}
	
	public void setPassword(String password)
	{
		this.waitAndSetText("password",password );
	}
	
	public String getErrorMsg()
	{
		String errormsg=this.getErrorMsg("errorLabel");
		System.out.println(errormsg);
		return errormsg;
	}
	
	public void clickOnCrossSymbol()
	{
		this.waitAndclick("crossBtn");
	}
	
	public boolean isCrossBtnVisible()
	{
		return this.isElementPresent("crossBtn");
	}
	
	public int getCrossIconSize()
	{
		List<WebElement> crossicons=this.getElements("crossIcons");
		return crossicons.size();
	}
}





