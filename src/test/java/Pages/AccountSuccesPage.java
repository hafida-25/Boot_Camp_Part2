package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccesPage {
	public WebDriver driver;
	
	public AccountSuccesPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy (xpath="//p[text()='Congratulations! Your new account has been successfully created!']")
	private WebElement accountCreatedSuccessfullyMessage;

	public boolean displayStatutsAccountCreatedSuccessfulltMessage() {
		boolean displayStatus = accountCreatedSuccessfullyMessage.isDisplayed();
		return displayStatus;
	}

}
