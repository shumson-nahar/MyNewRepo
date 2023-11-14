package tutorialninja_project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.BaseOfninja;

public class Search extends BaseOfninja {
	public Search () {
		super();
	}
	WebDriver driver;
	@BeforeMethod
	public void setup() {
		driver = initializeBrowserAndOpenApplicationURL("chrome");
		
	}
	@Test
	
	public void verifySearchWithValidProduct() {
		driver.findElement(By.name("search")).sendKeys("HP");
		driver.findElement(By.xpath("//div[@id ='search']/descendant::button")).click();
		Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
				
			
		
	}@Test
	
	public void verifySearchWithInvalidProduct() {
		driver.findElement(By.name("search")).sendKeys("Honda");
		driver.findElement(By.xpath("//div[@id ='search']/descendant::button")).click();
String actualSearchMessage = driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::p")).getText();
Assert.assertEquals(actualSearchMessage,"There is no product that matches the search criteria.","No product message in search results is not displayed");
		
		
		
	}
@Test
	
	public void verifySearchWithoutAnyProduct() {
		driver.findElement(By.name("search")).sendKeys("");
		driver.findElement(By.xpath("//div[@id ='search']/descendant::button")).click();
String actualSearchMessage = driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::p")).getText();
Assert.assertEquals(actualSearchMessage,"There is no product that matches the search criteria.",
		"No product message in search results is not displayed");
}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
