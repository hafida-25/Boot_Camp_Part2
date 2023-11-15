package TestsCases;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.AccountPage;
import Pages.LandingPage;
import Pages.LoginPage;
import TestBase.TestBase;
import Utulities.Util;

public class LoginTest extends TestBase {
	
	public LoginTest() throws Exception {
		super();
	}
	
	
	public WebDriver driver;
	public LoginPage loginpage;
	public LandingPage landingpage;
	public AccountPage accountpage;
	
	  //setup browser
	@BeforeMethod
	public void launchURL() {
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
		landingpage = new LandingPage(driver);
		loginpage = landingpage.navigateToLoginPage();
		
	}
	// login with valid credentials
	@Test(priority=1)
	public void verifyLoginWithValidCredentials() {
		landingpage.clickOnMyAccountDropDown();
		loginpage=landingpage.selectLoginOption();
		loginpage.navigateToAccountPage(dataprop.getProperty("emailText"),dataprop.getProperty("passwordText"));
		//Assert.assertTrue(accountpage.validateEditAccountInfoLinkDisplayStatuts());
		String expectedUrl ="https://tutorialsninja.com/demo/index.php?route=account/account";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);	
		}
	
	
	// login with invalid password
	@Test(priority=2,enabled=false)
	public void verfiyLoginWithValidEmailAndInvalidPassword() {
		loginpage.navigateToAccountPage(dataprop.getProperty("emailText"), dataprop.getProperty("invalidPassword"));
		Assert.assertTrue(loginpage.retrieveTextOfLoginWarningMessage().contains(dataprop.getProperty("loginwarningMessage")));
	}
	
	
	

	// login with invalid email
	@Test(priority=3,enabled=false)
	public void verfiyLoginWithInvalidEmailAndvalidPassword() {
		loginpage.navigateToAccountPage(Util.emailWithDateTimeStamp(), dataprop.getProperty("passwordText"));
		Assert.assertTrue(loginpage.retrieveTextOfLoginWarningMessage().contains(dataprop.getProperty("loginwarningMessage")));
	}
	
	// login with invalid credentials
	@Test(priority=4,enabled=false)
	public void verfiyLoginWithInvalidCredentials() {
		loginpage.navigateToAccountPage(Util.emailWithDateTimeStamp(), dataprop.getProperty("invalidPassword"));
		Assert.assertTrue(loginpage.retrieveTextOfLoginWarningMessage().contains(dataprop.getProperty("loginwarningMessage")));
	}
	

	// login with No credentials
	@Test(priority=5,enabled=false)
	public void verfiyLoginWithInvalidNoCredentials() {
		loginpage.clickOnLoginButton();
		Assert.assertTrue(loginpage.retrieveTextOfLoginWarningMessage().contains(dataprop.getProperty("loginwarningMessage")));
	}
	
		
//close browser	
 
@AfterMethod
public void tearDown() {
	driver.quit();
}
}
	
	


