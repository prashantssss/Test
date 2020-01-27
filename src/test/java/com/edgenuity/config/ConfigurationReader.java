package com.edgenuity.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.edgenuity.base.TestDriver;

public class ConfigurationReader extends TestDriver {
    static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	TestDriver test = new TestDriver();;
	
	@Test
	public static Object[][]  configreader() throws IOException, InvalidFormatException{
		
		File f = new File(System.getProperty("user.dir")+"//EdgenuityConfig//studenttestdata.xlsx");
		FileInputStream f1 = new FileInputStream(f);
		XSSFWorkbook wb= new XSSFWorkbook(f1);
		XSSFSheet sb= wb.getSheetAt(0);
		int rw= sb.getLastRowNum();
		int col= sb.getRow(0).getLastCellNum();
		Object[][] s= new Object[rw][col];
		for (int i= 0; i<rw; i++){
			for(int k=0;k<col;k++){
				s[i][k]= sb.getRow(i+1).getCell(k).toString();
			}
		}
		return s;
		
	}


	
}
	


