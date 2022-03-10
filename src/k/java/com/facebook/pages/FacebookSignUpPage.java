package com.facebook.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.facebook.base.FacebookBase;

public class FacebookSignUpPage extends FacebookBase{
	
	@FindBy(xpath="//div[@class='mbs _52lq fsl fwb fcb']")
	WebElement signuptitle;
	
	@FindBy(name="firstname")
	WebElement firstname;
	
	@FindBy(name="lastname")
	WebElement lastname;
	
	@FindBy(xpath="//input[@id='u_7_g_h5']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='password_step_input']")
	WebElement password;
	
	@FindBy(id="day")
	WebElement day;
	//Select day = new Select(days);
	//day.selectByValue("19");
	
	@FindBy(id="month")
	WebElement month;
	
	@FindBy(id="year")
	WebElement year;
	
	@FindBy(xpath="//label[contains(text(),'Female')]")
	WebElement gender;
	
	//Initializing the Page Objects:
	public FacebookSignUpPage(){
		PageFactory.initElements(driver, this);
	}
	//Actions:
	public boolean VerifySignupTitle(){
		return signuptitle.isDisplayed();
	}	
		
	public void SignUp(String fname, String lname,String email, String psw, String day, String mon, String year, String gender) {
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		password.sendKeys(psw);
		Select day = 
		return new FacebookHomePage();
		}


}
