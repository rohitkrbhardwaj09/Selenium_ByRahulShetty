package section_007;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alert_withConfirm {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("name")).sendKeys("Rohit Bhardwaj");

		driver.findElement(By.id("confirmbtn")).click();

		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		// alert.accept();
		alert.dismiss();
	}

}
