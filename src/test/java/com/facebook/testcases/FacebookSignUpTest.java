package com.facebook.testcases;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.facebook.base.FacebookBase;
import com.facebook.pages.FacebookProfilePage;
import com.facebook.pages.FacebookSignUpPage;

public class FacebookSignUpTest extends FacebookBase {
	
	FacebookSignUpPage fbsignup;
	FacebookProfilePage profilepage;
	
	public FacebookSignUpTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();	
		fbsignup = new FacebookSignUpPage();
	}
	
	@Test(priority=1)
	public void ClickOnSignUp(){
		fbsignup.VerifySignupClick();
	}
	
	@Test(priority=2)
	public void SignUpByUser(){
		fbsignup.VerifySignupClick();
		profilepage = fbsignup.SignUp(prop.getProperty("firstname"), prop.getProperty("lastname"), prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("days"), prop.getProperty("gender"));
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
