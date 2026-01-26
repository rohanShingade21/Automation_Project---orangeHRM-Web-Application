package com.crm.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPom {
@FindBy(name = "username")
private WebElement username;
@FindBy(name = "password")
private WebElement password;
@FindBy(css="button[type='submit']")
private WebElement login_button;
@FindBy(xpath = "//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']")
private WebElement forgot_pass;



public LoginPom(WebDriver driver) {
	PageFactory.initElements(driver,this);

}

public WebElement username() {
	return username;
} 
public WebElement password() {
	return password;
} 
public WebElement loginButton() {
	return login_button;
} 
public WebElement forgotPass() {
	return forgot_pass;
}

}




