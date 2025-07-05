package section_010;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandlesAssignment {

	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		try {
			driver.get("https://the-internet.herokuapp.com/");
			
			driver.findElement(By.cssSelector("a[href='/windows']")).click();
			String parent = driver.getWindowHandle();
			
			driver.findElement(By.cssSelector("a[href='/windows/new']")).click();
			
			Set<String> handles = driver.getWindowHandles();
			
			for (String handle : handles) {
				if(!handle.equals(parent)) {
					driver.switchTo().window(handle);
					System.out.println(driver.findElement(By.cssSelector(".example h3")).getText());
				}
			}
			
			driver.switchTo().window(parent);
			System.out.println(driver.findElement(By.cssSelector(".example h3")).getText());
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			driver.quit();
		}

	}

}
