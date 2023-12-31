package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	public WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(linkText ="My Account")
	private WebElement MyAccountDropDown;
	
	public void clickOnMyAccountDropDown() {
		MyAccountDropDown.click();
	}
	
	@FindBy(linkText ="Login")
	private WebElement LoginOption;
	
	public LoginPage selectLoginOption() {
		LoginOption.click();
		return new LoginPage(driver);
	}
	
	public LoginPage navigateToLoginPage() {
		MyAccountDropDown.click();
		LoginOption.click();
		return new LoginPage(driver);
	}
	
	@FindBy(linkText="Register")
	private WebElement RegisterOption;
	
	public RegisterPage selectRegisterOption() {
		RegisterOption.click();
		return new RegisterPage(driver);
	}
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchBox;
	
	public void enterProductNameInSearchBox(String validProduct) {
		searchBox.click();
		
	}
	
	@FindBy(css="button.btn.btn-default.btn-lg")
	private WebElement searchButton;
	
	public SearchPage clickOnSearchButton() {
		searchButton.click();
		return new SearchPage(driver);	
	}
	
	
public SearchPage navigateToSearchPage(String validProductText) {
	searchBox.sendKeys(validProductText);
	searchButton.click();
	return new SearchPage(driver);
}

		
		
	
	


}
