package section_015;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocator {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		WebElement name = driver.findElement(By.name("name"));
		
		// above
		System.out.println(driver.findElement(with(By.tagName("label")).above(name)).getText());

		// below
     	WebElement labeldob = driver.findElement(By.cssSelector("label[for='dateofBirth']"));
     	driver.findElement(with(By.tagName("input")).below(labeldob)).click();
     	
     	// clicking on the checkbox 
     	WebElement chckBox = driver.findElement(By.cssSelector("label[for='exampleCheck1']"));
     	driver.findElement(with(By.tagName("input")).toLeftOf(chckBox)).click();
	}

}
