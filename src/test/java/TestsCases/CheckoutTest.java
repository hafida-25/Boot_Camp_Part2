package TestsCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.CheckoutPage;
import TestBase.TestBase;

public class CheckoutTest extends TestBase {

	public CheckoutTest() throws Exception {
		super();
		
	}

	public WebDriver driver;
	
	
	@BeforeMethod
	public void launchURL() {
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
		
	}
	@Test(priority=1)
	public void checkoutTest() {
		CheckoutPage checkoutpage = new  CheckoutPage(driver);
		
		checkoutpage.enterProductNameInSearchBox("Palm Treo Pro");
		checkoutpage.clickOnSearchButton();
		checkoutpage.clickOnAddCartButton();
		checkoutpage.clickOnCheckoutButton();
		checkoutpage.choseCheckoutOption();
		checkoutpage.clickOnContinueButton();
		
		}
	
	@Test(priority=2,enabled=false)
	public void verifyCheckoutWithNoPersonalDetails() {
		CheckoutPage checkoutpage = new  CheckoutPage(driver);
		checkoutpage.enterProductNameInSearchBox("Palm Treo Pro");
		checkoutpage.clickOnSearchButton();
		checkoutpage.clickOnAddCartButton();
		checkoutpage.clickOnCheckoutButton();
		checkoutpage.choseCheckoutOption();
		checkoutpage.clickOnContinueButton();
		checkoutpage.clickOnContineButtonGuest();
		Assert.assertTrue(checkoutpage.retriveAllWarninMessage( dataprop.getProperty("firstNameWarningMessage"), dataprop.getProperty("lastNameWarningMessage"),
				dataprop.getProperty("emailWarningMessage"), dataprop.getProperty("telephoneWarningMessage"), dataprop.getProperty("adressWarningMessage"),dataprop.getProperty("cityWarningMessage"), dataprop.getProperty("postcodeWarningMessage"), dataprop.getProperty("regiontWarningMessage")));
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
}
