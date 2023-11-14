package tutorialninja_project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ValidationPage {
	public static WebDriver driver;
	@Test
	public void validationPage() {
		
		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		
		String expectedTitle= "Your Store";
		String expectedCurrentURL = "https://tutorialsninja.com/demo/";
		String actualTitle= driver.getTitle();
		String actualCurrentURL = driver.getCurrentUrl();
		if(actualTitle.equals(expectedTitle)&&actualCurrentURL.equals(expectedCurrentURL) )
			driver.findElement(By.linkText("My Account")).click();
		driver.quit();

	}

}
