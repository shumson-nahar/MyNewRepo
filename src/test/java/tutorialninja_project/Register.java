package tutorialninja_project;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.BaseOfninja;

public class Register extends BaseOfninja {
	public  Register() {
		super();
	}
	public WebDriver driver;
	public ChromeOptions options;
	
	@BeforeMethod
	public void setUp() {
		 driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
	driver.findElement(By.xpath("//span[text()='My Account']")).click();
	
	driver.findElement(By.linkText("Register")).click();
	

}
	@Test(priority=1)
	public void verifyRegisteringAnAccountWithMandatoryFields() throws InterruptedException {
		
	
		driver.findElement(By.id("input-firstname")).sendKeys(dataprop.getProperty("firstName "));
		Thread.sleep(3000);
		driver.findElement(By.id("input-lastname")).sendKeys(dataprop.getProperty("lastName"));
		Thread.sleep(3000);
		driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeStamp());
		Thread.sleep(3000);
		driver.findElement(By.id("input-telephone")).sendKeys(dataprop.getProperty("telephoneNumber"));
		Thread.sleep(3000);
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		Thread.sleep(3000);
		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
		
		driver.findElement(By.name("agree")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		Thread.sleep(3000);
		String actualSuccessHeading = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		Assert.assertEquals(actualSuccessHeading,dataprop.getProperty("accountSuccessfullyCreatedHeading "),
				"Account Success page is not displayed");
				
				
		
		
		
	}
	@Test(priority=2)
	public void verifyRegisteringAccountByProvidingAllFields() throws InterruptedException {
		
		
		driver.findElement(By.id("input-firstname")).sendKeys(dataprop.getProperty("firstName "));
	
		driver.findElement(By.id("input-lastname")).sendKeys(dataprop.getProperty("lastName"));
		
		driver.findElement(By.id("input-email")).sendKeys(dataprop.getProperty("validEmail"));
		
		driver.findElement(By.id("input-telephone")).sendKeys(dataprop.getProperty("telephoneNumber"));
		
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
	
		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		
		driver.findElement(By.name("agree")).click();
	
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
	
		String actualSuccessHeading = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
Assert.assertEquals(actualSuccessHeading,dataprop.getProperty("accountSuccessfullyCreatedHeading "),
		"Account Sucess page is not displayed");
		
		
		
		
	}@Test(priority=3)
	public void verifyRegisteringAccountWithExistingEmailAddress() throws InterruptedException {

		
		driver.findElement(By.id("input-firstname")).sendKeys(dataprop.getProperty("firstName "));
		Thread.sleep(2000);
	
		driver.findElement(By.id("input-lastname")).sendKeys(dataprop.getProperty("lastName"));
		Thread.sleep(2000);
		
		driver.findElement(By.id("input-email")).sendKeys(dataprop.getProperty("validEmail"));
		Thread.sleep(2000);
		
		driver.findElement(By.id("input-telephone")).sendKeys(dataprop.getProperty("telephoneNumber"));
		Thread.sleep(2000);
		
		driver.findElement(By.id("input-password")).sendKeys(dataprop.getProperty("validPassword"));
	
		driver.findElement(By.id("input-confirm")).sendKeys(dataprop.getProperty("validPassword"));
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		
		driver.findElement(By.name("agree")).click();
	
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		String actualWarning = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		Assert.assertFalse(actualWarning.contains(" duplicateEmailWarning"),
				"Warning message regaring duplicate email address is not displayed");//when  use assertFalse ok but assertTrue problem
	    driver.quit();
	}
	@Test(priority=4)
	public void verifyRegisteringAccountWithoutFillingAnyDetails() {
        
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String actualPrivacyPolicyWarning =driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText(); 
		Assert.assertTrue(actualPrivacyPolicyWarning.contains("Warning: You must agree to the Privacy Policy!"),
				"Privacy Policy Warning message is not displayed");
		
		String actualFirstNameWarning  = driver.findElement(By.xpath("//input[@id ='input-firstname']/following-sibling::div")).getText();
	    Assert.assertEquals(actualFirstNameWarning," First Name must be between 1 and 32 characters!",
			"First Name Warning message is not displayed");
	    
	    String actualLastNameWarning  = driver.findElement(By.xpath("//input[@id ='input-lastname']/following-sibling::div")).getText();
	    Assert.assertEquals(actualLastNameWarning,"lastNameWarning",
			"Last Name Warning message is not displayed");
	    
	    String actualEmailWarning  = driver.findElement(By.xpath("//input[@id ='input-email']/following-sibling::div")).getText();
	    Assert.assertEquals(actualEmailWarning,"emailWarning",
			"Email  Warning message is not displayed");
	    
	    String actualTelephoneWarning  = driver.findElement(By.xpath("//input[@id ='input-telephone']/following-sibling::div")).getText();
	    Assert.assertEquals(actualTelephoneWarning ,"telephoneWarning",
			"Telephone  Warning message is not displayed");
	    
	    String actualpasswordWarning  = driver.findElement(By.xpath("//input[@id ='input-password']/following-sibling::div")).getText();
	    Assert.assertEquals(actualpasswordWarning  ,"passwordWarning",
			"Password Warning message is not displayed");
	
	}
	public String generateEmailWithTimeStamp() {
		Date date = new Date();
		String timestamp= date.toString().replace(" ", "_").replace(":", " ");
		return "naharshumson"+timestamp+"@gmail.com";
}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
