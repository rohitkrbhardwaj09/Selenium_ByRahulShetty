package section_009;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));	
		WebElement usertype = driver.findElement(By.cssSelector("input[value='admin']"));
		WebElement user = driver.findElement(By.cssSelector("select[data-style='btn-info']"));
		Select options = new Select(user);
		WebElement term = driver.findElement(By.id("terms"));
		WebElement submitBtn = driver.findElement(By.id("signInBtn"));
		
		username.sendKeys("rahulshettyacademy");
		password.sendKeys("learning");
		usertype.click();
		options.selectByVisibleText("Teacher");
		term.click();
		submitBtn.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='card h-100']")));
		
		List<String> productList= new ArrayList<String>();
		
		List<WebElement> productNames = driver.findElements(By.cssSelector("h4.card-title"));
		
		for (WebElement productName : productNames) {
			String name = productName.getText();
			productList.add(name);
		}
		

		
		
	}
}
