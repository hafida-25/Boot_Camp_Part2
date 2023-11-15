package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
public WebDriver driver;

public SearchPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

@FindBy(linkText="Palm Treo Pro")
private WebElement validProduct;

public boolean displayStatusValidProduct() {
	boolean displayStatus = validProduct.isDisplayed();
	return displayStatus;
}

@FindBy(xpath="//p[text()='There is no product that matches the search criteria.']")
private WebElement InvalideProductMessage;

public boolean displayStatusInvalidProduct() {
	boolean displayStatus = InvalideProductMessage.isDisplayed();
	return displayStatus;
}

@FindBy(xpath="//p[text()='There is no product that matches the search criteria.']")
private WebElement NovalideProductMessage;

public boolean displayStatusNovalidProduct() {
	boolean displayStatus = NovalideProductMessage.isDisplayed();
	return displayStatus;
}
}
