package tutorialninja_project;



import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.BaseOfninja;

@Test
public class Login extends BaseOfninja{
	public Login() throws IOException {
		super();
		
	}
	public WebDriver driver;
	public ChromeOptions options;
	
	@BeforeMethod
	public void setUp() {
		
		driver = initializeBrowserAndOpenApplication(Prop.getProperty("browserName"));
		driver.findElement(By.xpath("//span[text()='My Account']")).click();

	
		driver.findElement(By.linkText("Login")).click();
	
	


}
	@Test(priority = 1)//pass
	public void verifyLoginWitValidCredentials() throws InterruptedException {
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		Thread.sleep(2000);
	
		driver.findElement(By.linkText("Login")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("input-email")).sendKeys(Prop.getProperty("validEmail"));
		Thread.sleep(2000);
		
		driver.findElement(By.id("input-password")).sendKeys(Prop.getProperty("validPassword"));
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Thread.sleep(2000);
		
		//Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed(),
			//	"!Warning: No match for E-Mail Address and/or Password.");
		
	}
	@Test(priority = 2)
	public void verifyLoginWithInvalidCredentials() throws InterruptedException {
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		
		driver.findElement(By.linkText("Login")).click();
		
		driver.findElement(By.id("input-email")).sendKeys(Prop.getProperty("InvalidEmail"));
	
		driver.findElement(By.id("input-password")).sendKeys(Prop.getProperty("InvalidPassword"));
		
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		String ActualWarningMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectedWarningMessage = " emailPasswordNoMatchWarning ";
		Assert.assertFalse(ActualWarningMessage.contains( expectedWarningMessage),"Expected Warning message is not displayed" );
		
		
		
	}
	@Test (priority = 3)
	public void verifyLoginWithValidEmailAndInvalidPassword() {
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
		
		driver.findElement(By.linkText("Login")).click();
		
		driver.findElement(By.id("input-email")).sendKeys(Prop.getProperty("validEmail"));
	
		driver.findElement(By.id("input-password")).sendKeys(Prop.getProperty("InvalidPassword"));
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		String ActualWarningMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectedWarningMessage = " emailPasswordNoMatchWarning ";
		Assert.assertFalse(ActualWarningMessage.contains( expectedWarningMessage),"Expected Warning message is not displayed" );
		
		
	}
	@Test (priority = 4)
	public void verifyLoginWithInvalidEmailAndvalidPassword() {
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
		
		driver.findElement(By.linkText("Login")).click();
		
		driver.findElement(By.id("input-email")).sendKeys(Prop.getProperty("InvalidEmail"));
	
		driver.findElement(By.id("input-password")).sendKeys(Prop.getProperty("validPassword"));
		
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		String ActualWarningMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectedWarningMessage = " emailPasswordNoMatchWarning ";
		Assert.assertFalse(ActualWarningMessage.contains( expectedWarningMessage),"Expected Warning message is not displayed" );
	}
	@Test (priority = 5)
	public void verifyLoginWithoutProvidingCredentials() {
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
		
		driver.findElement(By.linkText("Login")).click();
		
		driver.findElement(By.id("input-email")).sendKeys("");
	
		driver.findElement(By.id("input-password")).sendKeys("");
		
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		String ActualWarningMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectedWarningMessage = "emailPasswordNoMatchWarning ";
		Assert.assertFalse(ActualWarningMessage.contains( expectedWarningMessage),"Expected Warning message is not displayed" );
		
		
		
	}
	public String generateEmailWithTimeStamp() {
		Date date = new Date();
		return date.toString().replace(" ", "_").replace(":", " ");
				
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
