package aryansacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aryansacademy.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent {
	
	WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input[placeholder='Select Country']")
	WebElement countryDropdown;
	
	@FindBy(css=".ta-item:nth-last-child(2)")
	WebElement selection;
	
	@FindBy(css=".action__submit")
	WebElement submitButton;
	
	By dropDownResults = By.cssSelector(".ta-results");
	
	public void selectCountry(String countryName) {
		Actions a = new Actions(driver);
		a.sendKeys(countryDropdown, countryName).build().perform();
		waitForElementToAppear(dropDownResults);
		selection.click();
		
	}
	
	public ConfirmationPage submitOrder() {
		submitButton.click();
		return new ConfirmationPage(driver);
	}

}
