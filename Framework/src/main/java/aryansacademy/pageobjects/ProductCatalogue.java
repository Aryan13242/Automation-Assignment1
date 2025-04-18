package aryansacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import aryansacademy.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {

	WebDriver driver;

	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

	// PageFactory (class) --provides annotation and methods to set locators easily
	@FindBy(css = ".mb-3")
	List<WebElement> products;

	@FindBy(css = ".toast-container")
	WebElement spinner;

	By productsBy = By.cssSelector(".mb-3");
	By addToCart = By.xpath("//div[@class='card-body']/button[2]");
	By toastMessage = By.cssSelector(".toast-container");

	public List<WebElement> getProductList() {
		waitForElementToAppear(productsBy);
		return products;
	}

	public WebElement getProductElementByName(String productName1) {

		WebElement product1 = getProductList().stream()
				.filter(a -> a.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName1)).findFirst()
				.orElse(null);
		return product1;
	}

	public void addProductToCart(String productName) {
		WebElement prod = getProductElementByName(productName);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(spinner);
	}

}
