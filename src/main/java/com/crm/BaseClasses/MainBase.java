package com.crm.BaseClasses;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.crm.FileUtilityClass.ReadDataFromProperty;
import com.crm.POM.*;



public class MainBase {
	public static WebDriver driver;
	
@BeforeClass
public void precondition() throws IOException {
	
	String browser=ReadDataFromProperty.readProperty("browser");
	String url=ReadDataFromProperty.readProperty("url");
	if(browser.equalsIgnoreCase("chrome")) {
		driver=new ChromeDriver();
	}
	else if (browser.equalsIgnoreCase("Edge")) {
		driver=new EdgeDriver();
	}
	else if (browser.equalsIgnoreCase("firefox")) {
		driver=new FirefoxDriver();
	}
	else if (browser.equalsIgnoreCase("safari")) {
		driver=new SafariDriver();
	}
	else {
		driver=new ChromeDriver();
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get(url);
}
@BeforeMethod 
public void login(Method method) throws IOException {
	
	
	String username=ReadDataFromProperty.readProperty("username");
	String password=ReadDataFromProperty.readProperty("password");
	 LoginPom log = new LoginPom(driver);
	log.username().sendKeys(username);
	log.password().sendKeys(password);
	log.loginButton().click();
}
@AfterMethod
public void logout() {
	HomePagePom home=new HomePagePom(driver);
	home.profileIcon().click();
	home.logout().click();
}
@AfterClass
public void postCondition() {
	driver.quit();
}
}
