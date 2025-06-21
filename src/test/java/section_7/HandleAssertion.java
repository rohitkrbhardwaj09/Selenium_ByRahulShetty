package section_7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleAssertion {

	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		try {
			driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
			
			Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

			// clicking on checkbox
			driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
			
			// after click on checkbox
			Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
			
			
			// counting all checkbox available on lp
			int checkboxCount = driver.findElements(By.cssSelector("input[type='checkbox']")).size();
			
			Assert.assertEquals(6, checkboxCount);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
