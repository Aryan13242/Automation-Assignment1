package aryansacademy.tests;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import aryansacademy.TestComponents.BaseTest;
import aryansacademy.pageobjects.CartPage;
import aryansacademy.pageobjects.ProductCatalogue;

public class ErrorValidationsTest extends BaseTest {

	@Test
	public void LoginErrorValidation() throws IOException {
		String productName1 = "ZARA COAT 3";

		landingPage.loginApplication("aryxnsig@gmail.com", "Abcd@124");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
	}
	
	@Test
	public void ProductErrorValidation() throws IOException,InterruptedException { 
		String productName1 = "ZARA COAT 3";
		ProductCatalogue productCatalogue = landingPage.loginApplication("qawsed.s.1428@gmail.com", "Abcd@1234");
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName1); 
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match =	cartPage.verifyProductDisplay("ZARA COAT 33"); 
		Assert.assertFalse(match);
	}
	
	

}
