package com.crm.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPom {
	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	private WebElement add_plus;
	@FindBy(xpath = "//div[@class='oxd-select-wrapper']")
	private WebElement user_role;
	@FindBy(xpath = "(//div[@class='oxd-select-wrapper'])[2]")
	private WebElement status;
	@FindBy(xpath = "//input[@type='password']")
	private WebElement password;
	@FindBy(xpath = "//input[@placeholder='Type for hints...']")
	private WebElement employee_name;
	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
	private WebElement username;
	@FindBy(xpath = "(//input[@type='password'])[2]")
	private WebElement confirm_password;
	@FindBy(xpath = "//button[@type='submit' and text()=' Save ']")
	private WebElement save;
	public AdminPom(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public WebElement addPlus() {
		return add_plus;
	} 
	public WebElement userRole() {
		return user_role;
	} 
	public WebElement status() {
		return status;
	} 
	public WebElement password() {
		return password;
	} 
	public WebElement employeeName() {
		return employee_name;
	}
	public WebElement username() {
		return username;
	} 
	public WebElement confirmPassword() {
		return confirm_password;
	}
	public WebElement save() {
		return save;
	} 
}
