package AdminModule;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.BaseClasses.MainBase;
import com.crm.FileUtilityClass.ReadDataFromExcel;
import com.crm.POM.*;

import JavaUtility.GenerateDynamicData;

public class Admin extends MainBase {
	@Test
public void tc_0020() throws EncryptedDocumentException, IOException, InterruptedException {
	HomePagePom home = new HomePagePom(driver);
	home.admin().click();
	AdminPom admin = new AdminPom(driver);
	admin.addPlus().click();
	Actions act=new Actions(driver);
	act.click(admin.userRole()).keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).perform();
	act.click(admin.status()).keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).perform();
	String password = ReadDataFromExcel.single("Sheet1", 1, 2);
	admin.password().sendKeys(password);
	String empName=ReadDataFromExcel.single("Sheet1", 1, 3);
	admin.employeeName().sendKeys(empName);
	Thread.sleep(2000);
	act.keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).perform();	
	String username=GenerateDynamicData.dynamicName(ReadDataFromExcel.single("Sheet1", 1, 4));
	System.out.println(username);
	admin.username().sendKeys(username);
	admin.confirmPassword().sendKeys(password);
	admin.save().click();
	List<WebElement> adminUser = driver.findElements(By.xpath("//div[text()='"+username+"']"));
	assertTrue(adminUser.size()>0,"Admin is not created");
	Reporter.log("Admin is created Successfully....",true);
}
}
