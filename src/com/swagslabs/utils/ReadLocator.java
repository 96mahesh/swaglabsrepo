package com.swagslabs.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
public class ReadLocator {

	Properties pro;
	public ReadLocator(String filename) 
	{
		try {
		String filepath=".//locators//"+filename+".properties";
		FileInputStream instream = new FileInputStream(filepath);
		pro= new Properties();
		pro.load(instream);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public String getLocator(String locatorname)
	{
		return pro.getProperty(locatorname);
	}
	
	public static void main(String[] args) {
		ReadLocator read = new ReadLocator("loginpage");
		String locatorvalue=read.getLocator("crossIcons");
		System.out.println(locatorvalue);
	}
	/*
	 1. Location
	 2. Read Action
	 3. Load
	 4. get
	 */
	
}
