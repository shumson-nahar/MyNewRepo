package page_object_model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TutorialsNinjaTest {
	private WebDriver driver;
	private HomePage homepage;
	private  LoginPage loginpage;
	
	@BeforeMethod
	public void setup() {
		driver = new FirefoxDriver();
		 homepage= new HomePage(driver);
		loginpage = new LoginPage(driver);
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		
		
		
	}
	@Test
	public void validLoginCredentials() {
		homepage.clickOnAccountLink();
		homepage.clickOnLoginButton();
		loginpage.enterUserName("naharshumson@gmail.com");
		loginpage.enterpassword("Farabi1234");
		loginpage.clickLoginButton();
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
