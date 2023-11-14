package page_object_model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	private WebDriver driver;
	@FindBy(linkText="My Account")
	private WebElement myAccountLink;
	@FindBy(linkText="Login")
	private WebElement loginButton;
	public HomePage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements( driver,this);
		
		
	}
	public void clickOnAccountLink() {
		myAccountLink.click();
	}
	public void clickOnLoginButton() {
		loginButton.click();
	}
	

}
