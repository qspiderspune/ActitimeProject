package com.atitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	 @FindBy(id="username")
		private WebElement UnTextBx;     //declaration
	    @FindBy(name="pwd")
		private WebElement PwTextBx;
	    @FindBy(xpath="//div[.='Login ']")
		private WebElement LgBtn;
	    
		public  LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);   //initialisation
		}
		
		//business logic method
		public void setUser(String un,String pw) {
			UnTextBx.sendKeys(un);       //utilisation
			PwTextBx.sendKeys(pw);
			LgBtn.click();
		}
}
