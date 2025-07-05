package section_010;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsDemo {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.com/");
		
		Actions action = new Actions(driver);
		
		
		
		WebElement move = driver.findElement(By.cssSelector("#nav-link-accountList"));
		//composite action
		//action.moveToElement(driver.findElement(By.cssSelector("#nav-link-accountList"))).build().perform();
		
		//targeting search and entering HELLO and then selecting that keyword
		action.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		
		// opening by hovering the clicking right click
		action.moveToElement(move).contextClick().build().perform();

		
	}

}
