package aryansacademy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aryansacademy.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
//	WebElement userEmail = driver.findElement(By.id("userEmail"));   //outdated way to set locator
	
	//PageFactory (class) --provides annotation and methods to set locators easily
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public String getErrorMessage() {
		
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
	
	public ProductCatalogue loginApplication(String email, String pass) {
		userEmail.clear();
		userEmail.sendKeys(email);
		userPassword.clear();
		userPassword.sendKeys(pass);
		submit.click();
		
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
	}
	
	

}
