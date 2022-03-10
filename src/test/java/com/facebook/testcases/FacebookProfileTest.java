package com.facebook.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.facebook.base.FacebookBase;
import com.facebook.pages.FacebookHomePage;
import com.facebook.pages.FacebookLogin;
import com.facebook.pages.FacebookProfilePage;
import com.facebook.pages.FacebookSearchPage;

public class FacebookProfileTest extends FacebookBase {
	
	FacebookLogin fbloginpage;
	FacebookProfilePage profilepage;
	FacebookHomePage homePage;
	FacebookSearchPage fbsearchpage;
	public FacebookProfileTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		fbloginpage = new FacebookLogin();
		fbsearchpage = new FacebookSearchPage();
		homePage = fbloginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		profilepage = new FacebookProfilePage();
		profilepage= homePage.ProfileLink();
		
	} 
	
	@Test
	public void VerifyProTitle() {
		String title = profilepage.VerifyProfileTitle();
		Assert.assertEquals(title, "Aarzoo Patel | Facebook", "Profile title not matched");
	}
	
	@Test
	public void VerifySearchTest()
	{
		fbsearchpage =  profilepage.SearchforName();
	}
	
	@AfterMethod
	public void tearDown(){
		//driver.quit();
	}

}
