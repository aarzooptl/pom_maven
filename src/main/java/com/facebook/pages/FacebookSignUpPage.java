package com.facebook.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.facebook.base.FacebookBase;

public class FacebookSignUpPage extends FacebookBase{
	
	
	@FindBy(xpath="//a[contains(@id,'u_0_2_')]")
	WebElement signup;
	
	@FindBy(xpath="//div[@class='mbs _52lq fsl fwb fcb']")
	WebElement signuptitle;
	
	@FindBy(name="firstname")
	WebElement firstname;
	
	@FindBy(name="lastname")
	WebElement lastname;
	
	@FindBy(name="reg_email__")
	WebElement email;
	
	@FindBy(id="password_step_input")
	WebElement password;
	
	@FindBy(id="day")
	WebElement days;
	
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
	public void VerifySignupClick(){
		signup.click();
	}
	  
	 public FacebookProfilePage SignUp(String fname, String lname, String email_id, String psw, String day, String sex) {
	 firstname.sendKeys(fname); 
	 lastname.sendKeys(lname); 
	 email.sendKeys(email_id);
	 password.sendKeys(psw);
	 Select date = new Select(days); 
	 date.selectByValue(day);
	 gender.click();
	 return new FacebookProfilePage();
	 }
	 


}
