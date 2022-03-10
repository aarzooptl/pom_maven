package com.facebook.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.facebook.base.FacebookBase;
import com.facebook.pages.FacebookHomePage;
import com.facebook.pages.FacebookLogin;

public class FacebookLoginTest extends FacebookBase{
	
	FacebookLogin fbloginpage;
	FacebookHomePage homePage;
	
	public FacebookLoginTest(){
		super();
	}

	@BeforeMethod
	public void setUp(){
		initialization();
		fbloginpage = new FacebookLogin();	
	} 
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = fbloginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "Facebook - Log In or Sign Up");
	}
	
	@Test(priority=2)
	public void validateLogoTest() {
		boolean flag = fbloginpage.validateFbLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest(){
		homePage = fbloginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
