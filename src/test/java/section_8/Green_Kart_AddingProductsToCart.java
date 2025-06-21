package section_8;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Green_Kart_AddingProductsToCart {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();

		String[] itemToBuy = { "Pomegranate", "Raspberry", "Strawberry", "Water Melon" };

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
