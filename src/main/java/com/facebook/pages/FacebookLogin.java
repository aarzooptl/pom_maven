package com.facebook.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.facebook.base.FacebookBase;


public class FacebookLogin extends FacebookBase {
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="pass")
	WebElement password;
	
	@FindBy(name="login")
	WebElement loginbtn;
	
	@FindBy(xpath="//img[@class='fb_logo _8ilh img']")
	WebElement fblogo;
	
	//Initializing the Page Objects:
	public FacebookLogin(){
		PageFactory.initElements(driver, this);
	}
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}	
		
	public boolean validateFbLogo(){
		return fblogo.isDisplayed();
		}
		
	public FacebookHomePage login(String em, String pwd){
			email.sendKeys(em);
			password.sendKeys(pwd);
			loginbtn.click();
			/*
			 * JavascriptExecutor js = (JavascriptExecutor)driver;
			 * js.executeScript("arguments[0].click();", loginBtn);
			 */	
			return new FacebookHomePage();
		}

}
