package section_014;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableDemo {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		// 1. click on veg/fruit name column
		// 2. capture all the element to list
		// 3. capture text of all web element into new list
		// 4. sort in the list of step 3 - > sorted list
		// 5. compare original list with the sorted list
		
		
		driver.findElement(By.cssSelector("th[role='columnheader']:first-child")).click();
		
		List<WebElement> elementsList = driver.findElements(By.xpath("//tbody//td[1]"));
		List<String> originalList = elementsList.stream().map(item -> item.getText()).collect(Collectors.toList());
		
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		
		Assert.assertTrue(originalList.equals(sortedList));
		
		
		List<String> price;
		// scan the name column with getText() -> Beans -> print the price of the Rice
		do {
		List<WebElement> rows = driver.findElements(By.xpath("//tr//td[1]"));
		price =  rows.stream().filter(s->s.getText().contains("Rice")).map(s -> getPriceVeggie(s)).collect(Collectors.toList());
		
		price.forEach(a->System.out.println(a));
		
		if(price.size()<1) {
			driver.findElement(By.cssSelector("li a[aria-label='Next']")).click();
		}
		}while(price.size()<1);
		
	}

	private static String getPriceVeggie(WebElement s) {
		
		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		
		return priceValue;
	}

}
