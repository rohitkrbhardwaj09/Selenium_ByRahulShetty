package section_7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calender_ValidateEnabledORDisabled {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		try {
			driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

			// 1. check for one way enabled or not, if disabled, enable it
			System.out.println(driver.findElement(By.className("picker-second")).getDomAttribute("style"));
			driver.findElement(By.className("picker-second")).click();
			System.out.println(driver.findElement(By.className("picker-second")).getDomAttribute("style"));
			
			if(driver.findElement(By.className("picker-second")).getDomAttribute("style").contains("1")) {
				System.out.println("It is enabled");
				Assert.assertTrue(true);
			}else {
				System.out.println("It is disabled");
				Assert.assertTrue(false);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
