package section_7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Checkbox_Assignment1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		try {
			
			driver.get("https://rahulshettyacademy.com/AutomationPractice/");
			
			// 1. Check the first Checkbox and verify if it is successfully checked and Uncheck it again to verify if it is successfully Unchecked 
			Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected());
			driver.findElement(By.id("checkBoxOption1")).click();
			Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected());
			driver.findElement(By.id("checkBoxOption1")).click();
			Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected());
			
			// 2. How to get the Count of number of check boxes present in the page
			int checkboxCount = driver.findElements(By.cssSelector("input[type='checkbox']")).size();
			Assert.assertEquals(3, checkboxCount);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
