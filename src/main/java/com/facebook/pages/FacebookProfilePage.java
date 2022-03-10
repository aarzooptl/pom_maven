package com.facebook.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.facebook.base.FacebookBase;

public class FacebookProfilePage extends FacebookBase {


	@FindBy(xpath="//input[@placeholder='Search Facebook']")
	WebElement search;
	
	public FacebookProfilePage() {
		PageFactory.initElements(driver, this);
		}

	public String VerifyProfileTitle() {
		return driver.getTitle();
		}
	
	public FacebookSearchPage SearchforName()
		{
			search.sendKeys(prop.getProperty("search"));
			search.sendKeys(Keys.ENTER);
			return new FacebookSearchPage();
		}
}