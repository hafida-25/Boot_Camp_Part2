package TestsCases;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.LandingPage;
import Pages.SearchPage;
import TestBase.TestBase;

public class SearchTest extends TestBase {

	public SearchTest() throws Exception {
		super();
		
	}
	public WebDriver driver;
	public LandingPage landingpage;
	public SearchPage searchpage;
	
	@BeforeMethod
	public void launchURL() {
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
		landingpage = new LandingPage(driver);
		//driver.get("https://tutorialsninja.com/demo");
	}
	
@Test(priority=1)
public void searchProductTest() {
	landingpage=new LandingPage(driver);
	searchpage=landingpage.navigateToSearchPage(dataprop.getProperty("validProduct"));
	Assert.assertTrue(searchpage.displayStatusValidProduct());
	
}
 // search with no product
@Test(priority=2)
public void verifySearchWithInvalidProduct() {
	landingpage=new LandingPage(driver);
	searchpage=landingpage.navigateToSearchPage(dataprop.getProperty("invalidProduct"));
	Assert.assertTrue(searchpage.displayStatusInvalidProduct());
	
}
 //search with no valid product
@Test(priority=3)
public void verifySearchWithNovalidProduct() {
	landingpage=new LandingPage(driver);
	searchpage=landingpage.clickOnSearchButton();
	Assert.assertTrue(searchpage.displayStatusInvalidProduct());
	
}


@AfterMethod
public void tearDown() {
	driver.quit();
}

}
