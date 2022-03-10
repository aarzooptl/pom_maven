package com.facebook.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.facebook.base.FacebookBase;
import com.facebook.pages.FacebookHomePage;
import com.facebook.pages.FacebookLogin;
import com.facebook.pages.FacebookProfilePage;

public class FacebookHomeTest extends FacebookBase{
	
	FacebookHomePage homePage;
	FacebookLogin fbloginpage;
	FacebookProfilePage profilepage;
	
	public FacebookHomeTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		fbloginpage = new FacebookLogin();
		profilepage = new FacebookProfilePage();
		homePage = fbloginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	} 
	
	@Test(priority=1)
	public void HomePageTitleTest() {
		String title = homePage.VerifyHomePageTitle();
		Assert.assertEquals(title, "Facebook", "Home page title not matched");
	}
	
	@Test(priority=2)
	public void VerifyUserNameTest() {
		Assert.assertTrue(homePage.UserNamedisplayed(), "Username is missing");
	}
	
	@Test(priority=3)
	public void VerifyFriendsTest() {
		Assert.assertTrue(homePage.FriendsLinkdisplayed(), "Friends link is missing");
	}
	
	@Test
	public void VerifyGroupsTest() {
		Assert.assertTrue(homePage.GroupsLinkdisplayed(),"Group link is missing");
	}
	
	@Test
	public void clickProfileLink() {
	   profilepage = homePage.ProfileLink();
	}

	@AfterMethod
	public void tearDown() {
	   driver.quit();
	}
}