package com.edgenuity.base;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.edgenuity.config.ConfigurationReader;


public class TestDriver  {

public static WebDriver driver;

public void browserstart() throws IOException{
	
	Properties prop= new Properties();
	File f = new File(System.getProperty("user.dir")+"/EdgenuityConfig/config.properties");
	FileReader f1= new FileReader(f);
	prop.load(f1);
	
	
String browser=  prop.getProperty("browser");
 if ( browser.equalsIgnoreCase("chrome")){
      System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Driver//chromedriver.exe");
      driver= new ChromeDriver();
      driver.get("http://learn.education2020.com/");
}
else {
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//Driver//geckodriver.exe");
		driver= new FirefoxDriver();
		
	}
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
}