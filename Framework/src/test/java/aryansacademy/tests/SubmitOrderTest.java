package aryansacademy.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import aryansacademy.TestComponents.BaseTest;
import aryansacademy.pageobjects.CartPage;
import aryansacademy.pageobjects.CheckoutPage;
import aryansacademy.pageobjects.ConfirmationPage;
import aryansacademy.pageobjects.LandingPage;
import aryansacademy.pageobjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderTest extends BaseTest {

		@Test
		public void submitOrder() throws IOException
		{
		String productName1 = "ZARA COAT 3";
//		String productName2 = "ADIDAS ORIGINAL";
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	
		ProductCatalogue productCatalogue = landingPage.loginApplication("aryxnsing@gmail.com", "Abcd@1234");
	
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName1);
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.verifyProductDisplay(productName1);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goTocheckout();
		checkoutPage.selectCountry("india");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		
		String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));

//		System.out.println("success");
	}

}
