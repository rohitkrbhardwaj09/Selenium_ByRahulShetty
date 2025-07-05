package section_011;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		driver.findElement(By.id("checkBoxOption2")).click();
		
		String checkedText = driver.findElement(By.id("checkBoxOption2")).getAttribute("value");
		
		WebElement  dropdown = driver.findElement(By.id("dropdown-class-example"));
		Select options = new Select(dropdown);
		options.selectByValue(checkedText);
		
		driver.findElement(By.id("name")).sendKeys(checkedText);
		driver.findElement(By.id("alertbtn")).click();
		
		Alert a = driver.switchTo().alert();
		if(a.getText().contains(checkedText)) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
	}

}
