package section_010;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandles {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		String parentWindow = driver.getWindowHandle();
		driver.findElement(By.className("blinkingText")).click();
		
		Set<String> windows = driver.getWindowHandles(); //[Parent, Child]
		
		String username = "";
		for (String window : windows) {
			if(!window.equals(parentWindow)) {
				driver.switchTo().window(window);
				username = driver.findElement(By.cssSelector("p[class='im-para red']")).getText().split("at")[1].trim().split(" ")[0];
				
			}
		}
		driver.switchTo().window(parentWindow);
		
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys("learning");
		
		driver.findElement(By.cssSelector("input[value='admin']")).click();
		
		WebElement userinfo = driver.findElement(By.cssSelector("select[data-style='btn-info']"));
		Select select = new Select(userinfo);
		select.selectByVisibleText("Teacher");
		
		driver.findElement(By.cssSelector("#terms")).click();
		
		driver.findElement(By.id("signInBtn")).click();
		
	}
}