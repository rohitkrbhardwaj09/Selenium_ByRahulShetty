package section_015;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.jar.Attributes.Name;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleWindow {

	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		// Invoking Multiple windows/Tabs from selenium using one driver instance
		
		// Scenario:
		// Navigate to: https://rahulshettyacademy.com/angularpractice/ 
		
		// Fill the "name" field with the first course name available at
		// https://rahulshettyacademy.com
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		String parentWindow = driver.getWindowHandle();

		driver.switchTo().newWindow(WindowType.TAB);
		
		driver.get("https://rahulshettyacademy.com");
		
		Set<String> handles =  driver.getWindowHandles();
		
		for (String handle : handles) {
			if(!handle.equals(parentWindow)) {
				driver.switchTo().window(handle);
			}
		}
		
		List<WebElement> courses = driver.findElements(By.cssSelector("#courses-block .inner-box"));
		
		String courseName = courses.get(0).findElement(By.cssSelector("#courses-block .inner-box h2")).getText();

		driver.switchTo().window(parentWindow);
		
		WebElement name = driver.findElement(By.xpath("//div[@class='form-group']//input[@name='name']"));
		name.sendKeys(courseName);
		
		File file = name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("logo.png"));
		
		// Get height and width
		System.out.println(name.getRect().getDimension().getHeight());
		System.out.println(name.getRect().getDimension().getWidth());
	}

}
