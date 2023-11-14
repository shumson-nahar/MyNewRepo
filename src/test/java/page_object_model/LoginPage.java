package page_object_model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	private WebDriver driver;
	@FindBy(id="input-email")
	private WebElement usernameField;
	@FindBy(id="input-password")
	private WebElement passwordField;
	@FindBy(css="input.btn-primary")
	private WebElement loginButton;
	
	public LoginPage (WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements( driver , this);
		
		
	}
	public void enterUserName(String name) {
		 usernameField.sendKeys(name);
		
	}
	public void enterpassword(String password) {
		passwordField.sendKeys(password);
		
	}
	public void clickLoginButton() {
		loginButton.click();
	}

}
