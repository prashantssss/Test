package com.edgenuity.tests;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.edgenuity.base.TestDriver;

public class WelcomePageTests extends TestDriver{
	
	TestDriver test;
	
	public void browserstartup(){
		
		test= new TestDriver();
		try {
			test.browserstart();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	public void OpenURLApp(){
	driver.get("http://learn.education2020.com/");
		}
	}
