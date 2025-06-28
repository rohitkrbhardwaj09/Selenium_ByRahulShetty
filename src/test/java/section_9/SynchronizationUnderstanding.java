package section_9;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SynchronizationUnderstanding {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		String[] itemToBuy = { "Pomegranate", "Raspberry", "Strawberry", "Water Melon" };
		
		addItemsToCart(driver, itemToBuy);

		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		
		driver.findElement(By.cssSelector("div[class='cart-preview active'] button[type='button']")).click();
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoCode")));
		driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
		
		driver.findElement(By.className("promoBtn")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoInfo")));
		
		
		String successText = driver.findElement(By.className("promoInfo")).getText();
		//System.out.println(successText);
		
		if(successText.equalsIgnoreCase("Code applied ..!")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='wrapperTwo']//div//select")));
		
		Select options = new Select(driver.findElement(By.xpath("//div[@class='wrapperTwo']//div//select")));
		options.selectByVisibleText("Angola");
		
		driver.findElement(By.className("chkAgree")).click();
		
		driver.findElement(By.xpath("//button[normalize-space()='Proceed']")).click();
		
		String placed = driver.findElement(By.xpath("//span[contains(text(),'Thank you, your order has been placed successfully')]")).getText();
		
		if (placed.contains("Thank you")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertFalse(false);
		}
		

	}
	
	public static void addItemsToCart(WebDriver driver, String[] itemToBuy) {
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < products.size(); i++) {
			String[] prod = products.get(i).getText().split("-");
			String productName = prod[0].trim();

			List<String> itemToBuyList = Arrays.asList(itemToBuy);

			
			int count=0;
			if (itemToBuyList.contains(productName)) {
				count++;
				driver.findElements(By.cssSelector("div[class='product-action']>button")).get(i).click();
				if(count==itemToBuy.length) {
					break;
				}
			}

		}
	}

}
