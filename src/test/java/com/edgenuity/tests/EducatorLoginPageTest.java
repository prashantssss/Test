package com.edgenuity.tests;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.edgenuity.base.TestDriver;
import com.edgenuity.config.ConfigurationReader;

public class EducatorLoginPageTest extends TestDriver {
TestDriver test;
WelcomePageTests welcometest;
ConfigurationReader config = new ConfigurationReader();

@BeforeTest
	public void browserstartup(){
		
		test= new TestDriver();
		try {
			test.browserstart();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		}
@DataProvider
public Object[][] configread() throws InvalidFormatException, IOException{
	   Object[][] s= config.configreader();
    return s;
    
    
}

@Test(dataProvider="configread")
public void login(String username, String Password) throws IOException, InvalidFormatException{
	driver.findElement(By.xpath("//a[@class='modern-btn modern-btn-orange w70']")).click();
	driver.findElement(By.id("LoginUsername")).sendKeys(username);
	driver.findElement(By.id("LoginPassword")).sendKeys(Password);
	driver.findElement(By.cssSelector("#LoginSubmit")).click();
	}

@AfterTest
public void driverclose(){
	driver.quit();
	
	}

	

}
