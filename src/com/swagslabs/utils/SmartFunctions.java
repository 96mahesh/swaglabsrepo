package com.swagslabs.utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SmartFunctions {

	private WebDriver driver;
	private WebDriverWait wait ;
	private ReadLocator read;
	public SmartFunctions(WebDriver driver,String filename)
	{
	this.driver=driver;	
    wait=new WebDriverWait(driver, Duration.ofSeconds(30));
	 read= new ReadLocator(filename);

	}
	
	private WebElement getElement(String locatorname)
	{
		
		String Stringvalue=read.getLocator(locatorname);
		
		By locator=By.xpath(Stringvalue);
		return driver.findElement(locator);
	}
	
	protected List<WebElement> getElements(String locatorname)
	{
		try {
		String Stringvalue=read.getLocator(locatorname);
		
		By locator=By.xpath(Stringvalue);
		return driver.findElements(locator);
		}
		catch(Exception e)
		{
			List<WebElement>  info=new ArrayList<WebElement>();
			return info;
		}
	}
	
	protected void waitAndclick(String locatorname)
	{
		WebElement element =getElement(locatorname);
        wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
	}
	
	protected void waitAndSetText(String locatorname,String testdata)
	{
		WebElement element =getElement(locatorname);
        wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(testdata);
	}
	
	protected String getErrorMsg(String locatorname)
	{
		WebElement element =getElement(locatorname);
        wait.until(ExpectedConditions.visibilityOf(element));
		return element.getText();
	}
	
	protected boolean isElementPresent(String locatorname)
	{try {
		WebElement element =getElement(locatorname);
        wait.until(ExpectedConditions.visibilityOf(element));
		return element.isDisplayed();
	}
	catch(Exception e)
	{
		return false;
	}
	}
	
	
	
	
	
}
