package com.swagslabs.pages;

import org.openqa.selenium.WebDriver;

import com.swagslabs.utils.SmartFunctions;

public class ProductsPage extends SmartFunctions {

	public ProductsPage(WebDriver driver, String filename) {
		super(driver, filename);
	}
	
	public boolean isSwagLabLabelVisible()
	{
		return this.isElementPresent("swaglabsLabel");
	}
	
	public boolean isProductsLabelVisible()
	{
		return this.isElementPresent("productslabel");
	}

}
