package aryansacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import aryansacademy.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {
	
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css=".cartSection h3")
	private List<WebElement> cartProducts;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutEle;
	

	public boolean verifyProductDisplay(String productName1) {
		Boolean match = cartProducts.stream()
				.anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName1));
		return match;
	}
	
	public CheckoutPage goTocheckout() {
		checkoutEle.click();
		
		return new CheckoutPage(driver);
	}
	
	
	
	
	
	

	
	

}
