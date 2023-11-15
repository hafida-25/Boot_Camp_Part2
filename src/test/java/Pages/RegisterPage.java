package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
public WebDriver driver;

public RegisterPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
}

@FindBy (xpath="//input[@id='input-firstname']")
private WebElement firstNameField;

public void enterFirstName(String firstName) {
	firstNameField.sendKeys(firstName);
}

@FindBy(id="input-lastname")
private WebElement lastNameField;
 
public void enterLastName(String lastName) {
	lastNameField.sendKeys(lastName);
}


@FindBy(id="input-email")
private WebElement emailField;
 
public void enterEmail(String email) {
	emailField.sendKeys(email);
}

@FindBy(id="input-telephone")
private WebElement telephoneField;

public void enterTelephone(String telephone) {
	telephoneField.sendKeys(telephone);
}

@FindBy(xpath="//input[@id='input-password']")
private WebElement passwordField;

public void enterPasswordField(String password) {
	passwordField.sendKeys(password);
}

@FindBy(xpath="//input[@id='input-confirm']")
private WebElement confirmPasswordField;

public void enterConfrinPassword(String confirmPassword) {
	confirmPasswordField.sendKeys(confirmPassword);
}

@FindBy(css="label.radio-inline:nth-child(1) > input")
private WebElement newletterRadiobutton;

public void clickNewsLetterRadioButton() {
	newletterRadiobutton.click();
}

@FindBy(xpath="//input[@name='agree']")
private WebElement privacyPolicyCheckBox;

public void checkPrivacyPolicy() {
	privacyPolicyCheckBox.click();
}

@FindBy(css="input.btn.btn-primary")
private WebElement continueButton;

public void clickOnContinueButton() {
	continueButton.click();
}

@FindBy(xpath="//div[contains(@class,'alert-dismissible)]")
private WebElement duplicateEmailWaringMessage;

public String retrieveTextofDuplicateEmail() {
	String duplicateEmail = duplicateEmailWaringMessage.getText();
	return duplicateEmail;
}

@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
private WebElement duplicateEmailWarningEmail;

public String retriveTextofDuplicateEmail() {
	String duplicateEmail = duplicateEmailWarningEmail.getText();
	return duplicateEmail ;
}

@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
private WebElement privacyPolicyWarningMessage;

public String retriveTextofPrivacyPolicyWarningMessage() {
	String privacyPolicyWarning = privacyPolicyWarningMessage.getText();
	return privacyPolicyWarning  ;
}

@FindBy(xpath="//div[text()='First Name must be between 1 and 32 characters!']")
private WebElement firstNameWarningMessage;

public String retriveFirstNameWarninMessage() {
	String firstNameWarning = firstNameWarningMessage.getText();
	return firstNameWarning ;
}

@FindBy(xpath="//div[text()='Last Name must be between 1 and 32 characters!']")
private WebElement lastNameWarningMessage;

public String retriveLastNameWarninMessage() {
	String lastNameWarning = lastNameWarningMessage.getText();
	return lastNameWarning ;
}


@FindBy(xpath="//div[text()='E-Mail Address does not appear to be valid!']")
private WebElement emailWarningMessage;

public String retriveEmailWarninMessage() {
	String emailWarning = emailWarningMessage.getText();
	return emailWarning ;
}

@FindBy(xpath="//div[text()='Telephone must be between 3 and 32 characters!']")
private WebElement telephoneWarningMessage;

public String retriveTelephoneWarninMessage() {
	String telephoneWarning = telephoneWarningMessage.getText();
	return telephoneWarning ;
}
@FindBy(xpath="//div[text()='Password must be between 4 and 20 characters!']")
private WebElement passwordWarningMessage;

public String retrivePasswordWarninMessage() {
	String passwordWarning = passwordWarningMessage.getText();
	return passwordWarning ;
}


public AccountSuccesPage registerPageAllDetails(String firstNameText, String lastNameText, String emailText, String telephoneText, String passwordText, String confirmPasswordText  ) {
	firstNameField.sendKeys(firstNameText);
	lastNameField.sendKeys(lastNameText);
	emailField.sendKeys(emailText);
	telephoneField.sendKeys(telephoneText);
	passwordField.sendKeys(passwordText);
	confirmPasswordField.sendKeys(confirmPasswordText);
	newletterRadiobutton.click();
	privacyPolicyCheckBox.click();
	continueButton.click();
	return new AccountSuccesPage(driver);	
}

public AccountSuccesPage registerPageMandatoryDetails(String firstNameText, String lastNameText, String emailText, String telephoneText, String passwordText, String confirmPasswordText  ) {
	firstNameField.sendKeys(firstNameText);
	lastNameField.sendKeys(lastNameText);
	emailField.sendKeys(emailText);
	telephoneField.sendKeys(telephoneText);
	passwordField.sendKeys(passwordText);
	confirmPasswordField.sendKeys(confirmPasswordText);
	newletterRadiobutton.click();
	privacyPolicyCheckBox.click();
	continueButton.click();
	return new AccountSuccesPage(driver);	
}

public boolean retriveAllWarninMessage(String expectedPrivacyPolicyWrning ,String expectedFirstNameWarning, String expectedLastNameWarning,String expectedEmailWarning,String expectedTelephoneWarning,String expectedPasswordWarning ) {
	boolean privacyPolicyWarningStatus = privacyPolicyWarningMessage.getText().contains(expectedPrivacyPolicyWrning);
	boolean firstNameWarningStatus = firstNameWarningMessage.getText().contains(expectedFirstNameWarning);
	boolean lastNameWarningStatus = lastNameWarningMessage.getText().contains(expectedLastNameWarning);
	boolean emailWarningStatus =emailWarningMessage.getText().contains(expectedEmailWarning);
	boolean telephoneWarningStatus = telephoneWarningMessage.getText().contains(expectedTelephoneWarning);
	boolean passwordWarningStatus = passwordWarningMessage.getText().contains(expectedPasswordWarning);
	
	return privacyPolicyWarningStatus && firstNameWarningStatus &&  lastNameWarningStatus && emailWarningStatus && telephoneWarningStatus && passwordWarningStatus ;
}


}



