package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	
		
		public WebDriver driver;

		public CheckoutPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//input[@name='search']")
		private WebElement searchBox;
		
		public void enterProductNameInSearchBox(String validProduct) {
			searchBox.sendKeys(validProduct);
			
		}
		
		@FindBy(css="button.btn.btn-default.btn-lg")
		private WebElement searchButton;
		
		public void clickOnSearchButton() {
			searchButton.click();
			
		}
		

		@FindBy(xpath="//span[text()='Add to Cart' and contains(@class,'hidden-xs hidden-sm hidden-md')]")
	     private WebElement addCartButton;
		
		public void clickOnAddCartButton() {
			addCartButton.click();
		}
		
		@FindBy(xpath="//span[text()='Checkout' and contains (@class,'hidden-xs hidden-sm hidden-md')]")
		private WebElement checkoutButton;
		
		public void clickOnCheckoutButton() {
			checkoutButton.click();
		}
		
		
		@FindBy(xpath="//input[@name='account' and @value='guest']")
		private WebElement checkoutOptions;
		
		public void choseCheckoutOption() {
			checkoutOptions.click();
		}

		@FindBy(xpath="//input[@id='button-account']")
		private WebElement continueButton;
		
         public void clickOnContinueButton() {
        	 continueButton.click();
         }
         
         @FindBy(xpath="//input[@id='button-guest']")
         private WebElement continueButtonGuest;
        
         public void clickOnContineButtonGuest() {
        	 continueButtonGuest.click();
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


         @FindBy(xpath="//div[text()='E-Mail address does not appear to be valid!']")
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
         @FindBy(xpath="//div[text()='Address 1 must be between 3 and 128 characters!']")
         private WebElement adressWarningMessage;

         public String retriveAdressWarninMessage() {
         	String adressWarning = adressWarningMessage.getText();
         	return adressWarning ;
         }

         
         @FindBy(xpath="//div[text()='City must be between 2 and 128 characters!']")
         private WebElement cityWarningMessage;

         public String retriveCityWarninMessage() {
         	String cityWarning = cityWarningMessage.getText();
         	return cityWarning ;
         }
         
         
         @FindBy(xpath="//div[text()='Postcode must be between 2 and 10 characters!']")
         private WebElement postCodeWarningMessage;
         
         public String retrivePostCodeWarninMessage() {
          	String postCodeWarning = postCodeWarningMessage.getText();
          	return postCodeWarning ;
          }
         
         @FindBy(xpath="//div[text()='Please select a region / state!']")
         private WebElement regionWarningMessage;
         
         public String retriveRegionWarninMessage() {
          	String regionWarning = regionWarningMessage.getText();
          	return regionWarning ;
          }
         public boolean retriveAllWarninMessage(String expectedFirstNameWarning, String expectedLastNameWarning,String expectedEmailWarning,String expectedTelephoneWarning,String expectedAdressWarning ,String expectedCityWarning,String expectedPostCodeWarning, String expectedRegionWarning ) {
        		
        		boolean firstNameWarningStatus = firstNameWarningMessage.getText().contains(expectedFirstNameWarning);
        		boolean lastNameWarningStatus = lastNameWarningMessage.getText().contains(expectedLastNameWarning);
        		boolean emailWarningStatus =emailWarningMessage.getText().contains(expectedEmailWarning);
        		boolean telephoneWarningStatus = telephoneWarningMessage.getText().contains(expectedTelephoneWarning);
        		boolean adressWarningStatus = adressWarningMessage.getText().contains(expectedAdressWarning);
        		boolean cityWarningStatus = cityWarningMessage.getText().contains(expectedCityWarning);
        		boolean postCodeWarningStatus = postCodeWarningMessage.getText().contains(expectedPostCodeWarning);
        		boolean regionWarningStatus = regionWarningMessage.getText().contains(expectedRegionWarning);
        		return firstNameWarningStatus &&  lastNameWarningStatus && emailWarningStatus && telephoneWarningStatus && adressWarningStatus && cityWarningStatus && postCodeWarningStatus && regionWarningStatus;
        	}

}
