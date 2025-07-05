package section_007;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Autosuggest_dropdown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		try {
			driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
			
			driver.findElement(By.id("autosuggest")).sendKeys("ind");
			
			Thread.sleep(3000);
			
			List<WebElement> options =  driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
			
			for (WebElement option : options) {
				if(option.getText().equalsIgnoreCase("India")) {
					option.click();
					break;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
