package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage {
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	@FindBy(id="input-email")
	private WebElement emailFailed;
	
	public void enterEmail(String emailText) {
		emailFailed.sendKeys(emailText);
	}
	
	@FindBy(id="input-password")
	private WebElement passwordFailed;
	
	public void enterPassword(String passwordText) {
		passwordFailed.sendKeys(passwordText);
	}
	
	
	@FindBy(css="input.btn.btn-primary")
	private WebElement loginButton;
	
	
	public void clickOnLoginButton() {
		loginButton.click();
	}
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible)]")
	private WebElement loginWarningMessage;
	
	public String retrieveTextOfLoginWarningMessage() {
		String warningMessage = loginWarningMessage.getText();
		return warningMessage;
	}
	public AccountPage navigateToAccountPage(String emailText ,String passwordText) {
		emailFailed.sendKeys("tariqhaddad1994@gmail.com");
		passwordFailed.sendKeys("hgdreft12");
		loginButton.click();
		return new AccountPage(driver);
	}

}
