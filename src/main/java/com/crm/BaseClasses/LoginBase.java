package com.crm.BaseClasses;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import com.crm.FileUtilityClass.*;
import com.crm.POM.LoginPom;

public class LoginBase {
	public static WebDriver driver;
	public static LoginPom login;
	@BeforeMethod
	public void precondition() throws IOException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		String browser=ReadDataFromProperty.readProperty("browser");
		String url=ReadDataFromProperty.readProperty("url");
		if(browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver(option);
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
		login = new LoginPom(driver);
	}
	
	@AfterMethod
	public void postcondition() {
		driver.quit();
	}
}
