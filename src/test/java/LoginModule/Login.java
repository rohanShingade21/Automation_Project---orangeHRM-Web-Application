package LoginModule;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.BaseClasses.LoginBase;
import com.crm.FileUtilityClass.ReadDataFromExcel;
import com.crm.FileUtilityClass.ReadDataFromProperty;

@Listeners (com.crm.Listeners.WithScreenshot.class)
public class Login extends LoginBase {
	 @Test (priority = 1)
	   public void TC_001() throws IOException {
		   assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		   Reporter.log("Entered Into Targeted Page",true);
		   
	   }
	   @Test  (priority = 2)
	   public void TC_002() throws EncryptedDocumentException, IOException {
		   String username = ReadDataFromExcel.single("logincre",1 ,0 );
		   String pass = ReadDataFromExcel.single("logincre", 1, 1);
		   login.username().sendKeys(username);
		   login.password().sendKeys(pass);
		   login.loginButton().click();
		   
	   }
	   @Test  (priority = 3)
	   public void TC_003() throws EncryptedDocumentException, IOException, InterruptedException {
		   String username = ReadDataFromExcel.single("logincre",1 ,0 );
		   String pass = ReadDataFromExcel.single("logincre", 1, 1);
		   login.username().sendKeys(username);
		   login.password().sendKeys(pass);
		   login.loginButton().click();
		   String homeUrl = ReadDataFromProperty.readProperty("homepageUrl");
		   assertEquals(driver.getCurrentUrl(),homeUrl,"Not Entred into Home Page");
		   Reporter.log("Enter Into HOmePage",true);
     }
	   @Test  (priority = 4)
	   public void TC_004() throws EncryptedDocumentException, IOException {
		   String username = ReadDataFromExcel.single("logincre",1 ,0 );
		   System.out.println(username);
		   String pass = ReadDataFromExcel.single("logincre", 1, 1);
		   System.out.println(pass);
		   login.username().sendKeys(username);
		   String userVlaue =login.username().getAttribute("value");
		   assertEquals(username,userVlaue,"Notexpected" );
		   Reporter.log("Username as Expected",true);
		   login.password().sendKeys(pass);
		   String passVlaue = login.password().getAttribute("value");
		   assertEquals(pass,passVlaue,"Not expected");	   
		   Reporter.log("Password as Expected",true);
	   }
	   @Test  (priority = 5)
	   public void TC_005() throws EncryptedDocumentException, IOException {
		   String username = ReadDataFromExcel.single("logincre",1 ,0 );
		   String pass = ReadDataFromExcel.single("logincre", 1, 1);
		   login.username().sendKeys(username);
		   login.password().sendKeys(pass);
		   String passType = login.password().getAttribute("type");
		   assertEquals(passType,"password","Not expected");
		   Reporter.log("Password is Hidden",true);
	   }
	   @Test  (priority = 6)
	   public void TC_006() {
		   assertTrue(login.forgotPass().isDisplayed(), "Forget pass Not displayed");
		   Reporter.log("Link dispayed",true);
	   }
	   @Test  (priority = 7)
	   public void TC_007() throws IOException {
		   login.forgotPass().click();
		   String url = ReadDataFromProperty.readProperty("forgotpass");
		   assertEquals(driver.getCurrentUrl(), url,"Not opened Forgot Pass page");
		   Reporter.log("Enter into Forgot Password Page",true);
	   }
	  
	   @Test  (priority = 8)
	   public void TC_008() throws EncryptedDocumentException, IOException {
//		   String inValidUser = ReadDataFromExcel.single("invalidCre", 1, 0);
		   String passValid = ReadDataFromExcel.single("logincre",1,1);
		    login.username().sendKeys("Mohan");
		    login.password().sendKeys(passValid);
		    login.loginButton().click();
		    WebElement msg = driver.findElement(By.xpath("//div[@role='alert']"));
		    assertTrue(msg.isDisplayed(),"Error msg Not displyed");
		    Reporter.log("Error msg Displyed",true);
	   }
	   @Test (priority = 9)
	   public void TC_009() throws EncryptedDocumentException, IOException {
	   String validUser = ReadDataFromExcel.single("logincre", 1, 0);
//		   String passInvalid = ReadDataFromExcel.single("logincre",1,1);
		    login.username().sendKeys(validUser);
		    login.password().sendKeys("mohan123");
		    login.loginButton().click();
		    WebElement msg = driver.findElement(By.xpath("//div[@role='alert']"));
		    assertTrue(msg.isDisplayed(),"Error msg Not displyed");
		    Reporter.log("Error msg Displyed",true);
	   }
	   @Test  (priority = 10)
	   public void TC_10() throws EncryptedDocumentException, IOException {
//		   String validUser = ReadDataFromExcel.single("logincre", 1, 0);
//		   String passInvalid = ReadDataFromExcel.single("logincre",1,1);
		    login.username().sendKeys("Mohan");
		    login.password().sendKeys("mohan123");
		    login.loginButton().click();
		    WebElement msg = driver.findElement(By.xpath("//div[@role='alert']"));
		    assertTrue(msg.isDisplayed(),"Error msg Not displyed");
		    Reporter.log("Error msg Displyed",true);
	   } 
	   @Test  (priority = 11)
	   public void TC_011() throws EncryptedDocumentException, IOException {
		   String pass = ReadDataFromExcel.single("logincre", 1, 1);
		   login.username().clear();
		    login.password().sendKeys(pass);
		    login.loginButton().click();
		    WebElement msg = driver.findElement(By.xpath("//span[text()='Required']"));
		    assertTrue(msg.isDisplayed(),"Error msg Not displyed");
		    Reporter.log("Error msg Displyed",true);
	   }
	   @Test  (priority = 12)
	   public void TC_012() throws EncryptedDocumentException, IOException {
		   String username = ReadDataFromExcel.single("logincre", 1, 0);
		   login.username().sendKeys(username);
		    login.password().clear();
		    login.loginButton().click();
		    WebElement msg = driver.findElement(By.xpath("//span[text()='Required']"));
		    assertTrue(msg.isDisplayed(),"Error msg Not displyed");
		    Reporter.log("Error msg Displyed",true);
	   }
	   @Test  (priority = 13)
	   public void TC_013() {
		   login.username().clear();
		    login.password().clear();
		    login.loginButton().click();
		    WebElement msg = driver.findElement(By.xpath("//span[text()='Required']"));
		    assertTrue(msg.isDisplayed(),"Error msg Not displyed");
		    Reporter.log("Error msg Displyed",true);
	   }
	   @Test  (priority = 14)
	   public void TC_014() {
		   WebElement logo = driver.findElement(By.className("orangehrm-login-branding"));
		   assertTrue(logo.isDisplayed(),"Logo not displayed");
		   Reporter.log("Logo is diplayed Properly",true);
	   }
	  
	   @Test  (priority = 15)
	   public void TC_015() throws EncryptedDocumentException, IOException {
		   login.forgotPass().click();
//		   String name=ReadDataFromExcel.single("logincre",3,0);
		   WebElement username = driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--active']"));
		   username.sendKeys("Suraj");
		   String uName = username.getAttribute("value");
		   assertEquals(uName, "Suraj","Name not input");
	       Reporter.log("Name successFully entred");	
	     
	   } 
	   @Test  (priority = 16)
	   public void TC_016() {
		   login.forgotPass().click();
//		   String name=ReadDataFromExcel.single("logincre",3,0);
		   WebElement username = driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--active']"));
		   username.sendKeys("Suraj");
		   String uName = username.getAttribute("value");
		   assertEquals(uName, "Suraj","Name not input");
	       Reporter.log("Name successFully entred");	
	       driver.findElement(By.xpath("//button[@type='submit']")).click();
	        WebElement msg = driver.findElement(By.xpath("//div[@class='orangehrm-card-container']"));
	        assertTrue(msg.isDisplayed(),"Messege is not displyed");
	        Reporter.log("Messge Displyed",true);
	   }
	   @Test (priority = 17)
	   public void TC_017() throws IOException {
		   login.forgotPass().click();	
	       driver.findElement(By.xpath("//button[@type='button']")).click();
	       String url = ReadDataFromProperty.readProperty("url");
	        assertEquals(url,driver.getCurrentUrl(),"Not moved back");
	        Reporter.log("Moved back",true);
	   }
}
