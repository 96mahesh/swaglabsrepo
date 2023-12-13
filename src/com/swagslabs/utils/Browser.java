package com.swagslabs.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.testng.annotations.Parameters;

public class Browser {

	private static WebDriver driver;
	
	public static WebDriver launchBrowser(String browsername) //<parameter>
	{
		if(browsername.equals("chrome"))
			driver=new ChromeDriver();
		else if(browsername.equals("Edge"))
			driver=new EdgeDriver();
		else
			driver=new FirefoxDriver();
		return driver;
	}
	
	public static  void openURL()
	{
		driver.get("https://www.saucedemo.com/");
	}
	
	public static void close()
	{
		driver.close();
	}
	
}
