package com.swagslabs.utils;

import java.io.FileInputStream;
import java.util.*;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ReadTestData {

	XSSFSheet sheet;
	public ReadTestData(String filename)
	{
		try {
			String filepath=".//testdata//"+filename+".xlsx";
			FileInputStream instream = new FileInputStream(filepath);
			XSSFWorkbook workbook = new XSSFWorkbook(instream);
			 sheet=workbook.getSheet("Sheet1");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	}
	
	public String getData(int row,int cell)
	{
		return sheet.getRow(row).getCell(cell).getStringCellValue();
	}
	
	public List<String> getData(int row)
	{
		
		List<String> rowdata = new ArrayList<String>();
		int cellsCount=sheet.getRow(row).getLastCellNum(); //count
		for(int i=0;i<cellsCount;i++) {
		String data= sheet.getRow(row).getCell(i).getStringCellValue();
		rowdata.add(data);
		}
		
		return rowdata;
	}
	
	public String[][] getData()
	{
		
		int rows=sheet.getLastRowNum(); // last row index
		int cellsCount=sheet.getRow(0).getLastCellNum(); //count
		
		String info[][]= new String[rows][cellsCount];
		int k=0,l=0;
		
		for(int i=1;i<=rows;i++)
		{
			for(int j=0;j<cellsCount;j++)
			{
				String data= sheet.getRow(i).getCell(j).getStringCellValue();
                  info[k][l]=data;
                  l++;
			}
			k++;
			l=0;
		}
		return info;
		
	}
	
	
	public static void main(String[] args) {
		ReadTestData read = new ReadTestData("loginpage");
		/*String mani[][]=read.getData();
		
		for(int i=0;i<mani.length;i++)
		{
			for(int j=0;j<mani[i].length;j++)
			{
				System.out.print(mani[i][j]+" ");
			}
			System.out.println();
			
		}*/
		/*List<String> rowdata=read.getData(0);
		System.out.println(rowdata);*/
		String data=read.getData(5, 1);
		System.out.println(data);
		
	}
}
/*
1. Workbook
2. Sheet
3. rows
4. cells
*/

/*  0 1
0 A B 
1 C D
2 E F

k=0 l=0 
k=0 l=1
k=1 l=0
k=1 l=1
*/










