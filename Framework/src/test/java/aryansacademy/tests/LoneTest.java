package aryansacademy.tests;

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

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String productName1 = "ZARA COAT 3";
		String productName2 = "ADIDAS ORIGINAL";
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		
		driver.findElement(By.id("userEmail")).sendKeys("aryxnsing@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Abcd@1234");
		driver.findElement(By.id("login")).click();
		
		
		
		
	
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		
		WebElement product1 = products.stream().filter(a->
		a.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName1)).findFirst().orElse(null);
		product1.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".toast-container"))));
		
//		WebElement product2 = products.stream().filter(a->
//		a.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName2)).findFirst().orElse(null);
//		product2.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".toast-container")));
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".toast-container")));
//		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".toast-container"))));
		

		driver.findElement(By.xpath("//button[contains(@routerlink, 'cart')]")).click();     // custom css could be [routerlink*='cart']
		
		List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match = cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName1));
		Assert.assertTrue(match);
		
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Select Country']")));
		Actions a = new Actions(driver);
//		WebElement count = (WebElement) By.cssSelector("input[placeholder='Select Country']");
		a.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")), "ind").build().perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		
		driver.findElement(By.cssSelector(".ta-item:nth-last-child(2)")).click();
		driver.findElement(By.cssSelector(".action__submit")).click();
		
		String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();	
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
		
	
		
		
		
//		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".odd button:last-of-type"))));
		
//		driver.findElement(By.cssSelector(".odd button:last-of-type")).click();
//		WebElement checkout = driver.findElement(By.cssSelector(".totalRow button"));
//		wait.until(ExpectedConditions.elementToBeClickable(checkout));
//		checkout.click();
//		
//		driver.findElement(By.cssSelector("input[placeholder*='Select']")).sendKeys("Ind");
//		
//		List<WebElement> countries = driver.findElements(By.cssSelector(".ta-item"));
//		
//		for(WebElement country : countries) {
//			if(country.getText().equalsIgnoreCase("India")) {
//				country.click();
//				break;
//			}
//		}
//		
//		driver.findElement(By)
//		driver.findElement(By.cssSelector(".action__submit")).click();
		System.out.println("success");
		
	}

}
