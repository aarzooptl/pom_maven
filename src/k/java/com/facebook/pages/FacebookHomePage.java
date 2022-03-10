package com.facebook.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.facebook.base.FacebookBase;

public class FacebookHomePage extends FacebookBase{
	
	@FindBy(xpath="//span[contains(text(), \"Aarzoo Patel\")]")
	WebElement userNameLable;
	
	@FindBy(xpath="//input[@aria-label='Search Facebook']")
	WebElement searchfacebook;
	
	@FindBy(xpath ="//span[contains(text(),'Friends')]")
	WebElement friends;
	
	@FindBy(xpath="//span[contains(text(),'Groups')]")
	WebElement groups;
	
	@FindBy(xpath = "//span[contains(text(),'Aarzoo Patel')]")
	WebElement profile;

	public FacebookHomePage() {

		 PageFactory.initElements(driver, this);
		}
		
		public String VerifyHomePageTitle() {
			return driver.getTitle();
		}
		
		public boolean UserNamedisplayed() {
			return userNameLable.isDisplayed();
		}
		
		public boolean GroupsLinkdisplayed()
		{
			return groups.isDisplayed();
		}
		
		public boolean FriendsLinkdisplayed() {
			return friends.isDisplayed();
		}
		
		public FacebookProfilePage ProfileLink() {
			profile.click();
			return new FacebookProfilePage();
		}
}
