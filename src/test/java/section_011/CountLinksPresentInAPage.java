package section_011;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CountLinksPresentInAPage {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		String parent = driver.getWindowHandle();
		
		// Requirement: 1
		// Give me the count of links present on a page
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		// Requirement: 2
		// Now, Give me the count of links present on Footer only
		WebElement footer = driver.findElement(By.id("gf-BIG"));
		System.out.println(footer.findElements(By.tagName("a")).size());
		
		// Requirement: 3
		// Open each link present in most left column in footer in new tab and get their title print on console
		List<WebElement> links = driver.findElements(By.cssSelector("table[class='gf-t'] tr td:first-child ul li>a"));
		
		String clickOnLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
		
		for (WebElement link : links) {
			link.sendKeys(clickOnLink);
		}
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			if(!handle.equals(parent)) {
				driver.switchTo().window(handle);
				System.out.println(driver.getTitle());
			}
		}
		
	}

}
