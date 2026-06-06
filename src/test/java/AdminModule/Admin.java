package AdminModule;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.BaseClasses.MainBase;
import com.crm.FileUtilityClass.ReadDataFromExcel;
import com.crm.POM.AdminPOM;
import com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent.Fallback;

import JavaUtility.GenerateDynamicData;


@Listeners (com.crm.Listeners.WithScreenshot.class)
public class Admin extends MainBase{
	
	AdminPOM admin ;
	Actions act ;
	@BeforeMethod
	public void adminObject() {
		 admin = new AdminPOM(driver);
		 act = new Actions(driver);
	}	
    @Test  
   public void TC_001() throws InterruptedException {
	    act.click(admin.adminButt()).perform();;
	    String actual_URL = driver.getCurrentUrl();
	    assertEquals(actual_URL, "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers","Not entred in ACutal page ");
	    Reporter.log("Entred in Targeted Page");
   }
    @Test  
    public void TC_002() {
    	admin.adminButt().click();
    	admin.addButt().click();
    	 String expected_URL = driver.getCurrentUrl();
    	 String actual_URL = "https://opensource-demo.orangehrmlive.com/web/index.php/admin/saveSystemUser";
    	 assertEquals(actual_URL,expected_URL,"Not entred into expected Page");
    }
    @Test 
    public void TC_003() {
    	admin.adminButt().click();
    	admin.addButt().click();
    	assertTrue(admin.userRole().isDisplayed(),"User Role Feild is not displayed");
    	assertTrue(admin.status().isDisplayed(),"Status field is not displayed");
    	assertTrue(admin.pass().isDisplayed(),"Password field is not displyed");
    	assertTrue(admin.confPass().isDisplayed(),"Confirm PAssword field is not displayed");
    	assertTrue(admin.userName().isDisplayed(),"Username field is not displyed");
    }
    //thomas713
    @Test 
    public void TC_004() throws EncryptedDocumentException, IOException, InterruptedException {
    	admin.adminButt().click();
    	admin.addButt().click();
    	String empName = ReadDataFromExcel.single("loginCredential", 3, 0);
        String username =ReadDataFromExcel.single("loginCredential", 3, 1);
        String password = GenerateDynamicData.dynamicName(empName.toLowerCase());
    act.click(admin.userRole()).keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).perform();
    act.click(admin.status()).keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).perform();    
    admin.pass().sendKeys(password);  
    act.click(admin.empName()).sendKeys(empName).perform();
    Thread.sleep(2000);
    act.keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).perform();   
    admin.userName().sendKeys(username);   
    admin.confPass().sendKeys(password);
    Thread.sleep(3000);
    admin.saveButt().click();
    Thread.sleep(6000);    
    }
    @Test 
    public void TC_005() throws InterruptedException, EncryptedDocumentException, IOException {
    	admin.adminButt().click();
    	admin.addButt().click();
    	String empName = ReadDataFromExcel.single("loginCredential", 3, 0);
        String username =ReadDataFromExcel.single("loginCredential", 3, 1);
        String password = GenerateDynamicData.dynamicName(empName.toLowerCase());
    Actions act = new Actions(driver);
    act.click(admin.userRole()).keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).perform();
    act.click(admin.status()).keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).perform();    
    admin.pass().sendKeys(password);  
    act.click(admin.empName()).sendKeys(empName).perform();
    Thread.sleep(2000);
    act.keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).perform();   
    admin.userName().sendKeys(username);
    Thread.sleep(2000);
    assertTrue(admin.errorMsgExist().isDisplayed(),"Error messege is not Displayed");
    Reporter.log("Error Msg is Displyed");
    }
    @Test 
    public void TC__006() {
    	admin.adminButt().click();
    	admin.addButt().click();
 
    	 admin.pass().sendKeys("Rohan@123");
    	 String value = admin.pass().getAttribute("value");
    	 assertEquals( value, "Rohan@123","PassWord field doesnt eccept enterd text");
    }
    @Test 
    public void TC_007() {
    	admin.adminButt().click();
    	admin.addButt().click();
    	
    	admin.pass().sendKeys("Rohan@123");
    	admin.confPass().sendKeys("rohaaann");
    	assertTrue(admin.errorMsgPass().isDisplayed(),"Error mgs not displaying");
    }
    @Test 
    public void TC_008() {
    	admin.adminButt().click();
    	admin.addButt().click();
    	
    	act.click(admin.userRole()).keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).perform();
    	String value = admin.userRole().getText();
    	System.out.println(value);
    	assertEquals(value,"Admin" );
    	
    }
    @Test (enabled = false)
    public void TC_009() throws EncryptedDocumentException, IOException, InterruptedException {
    	admin.adminButt().click();
    	
    	String username = ReadDataFromExcel.single("loginCredential", 3, 1);
    	String empname = ReadDataFromExcel.single("loginCredential", 3, 0);
    	admin.add1_userName().sendKeys(username);
    	act.click(admin.add1_userName()).keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).perform();
    	admin.add1_empName().sendKeys(empname);
    	Thread.sleep(2000);
        act.keyDown(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        act.click(admin.add1_status()).keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).perform();
        admin.add1_submitButt().click();
    }
}
