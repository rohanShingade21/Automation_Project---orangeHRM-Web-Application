package com.crm.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePagePom {
@FindBy(xpath = "//a[@class='oxd-main-menu-item active']")
private WebElement admin;
@FindBy(className = "oxd-userdropdown-tab")
private WebElement profile_icon;
@FindBy(xpath = "//a[text()='Logout']")
private WebElement logout;

public HomePagePom(WebDriver driver) {
	PageFactory.initElements(driver,this);
}
public WebElement admin() {
	return admin;
} 
public WebElement profileIcon() {
	return profile_icon;
} 
public WebElement logout() {
	return logout;
}
}
