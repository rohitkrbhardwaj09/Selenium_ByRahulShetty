package section_007;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Custom_dropdown {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		try {
			// 1. opening url
			driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
			
			// 2. clicking on passenger drop-down
			driver.findElement(By.id("divpaxinfo")).click();
			
			// after click on the drop down, it may take 1 or 2 second to open properly so to prevent from error
			// will use wait,
			Thread.sleep(3000); // not recommended to use Thread, use wait()
			
			// 3. suppose, we have a add 5 adults, so will locate the + icon to add adults
			/*
			driver.findElement(By.id("hrefIncAdt")).click(); //added 1 adult (click again to add one more)
			driver.findElement(By.id("hrefIncAdt")).click(); 
			driver.findElement(By.id("hrefIncAdt")).click();
			driver.findElement(By.id("hrefIncAdt")).click(); */ //4 adults added (total 5 now, 1 was already added)
			
			// but this is not a good practice, repeating the same statement multiple times, instead of this 
			// we will use looping statement
			int i=1;
			while(i<5) {
				driver.findElement(By.id("hrefIncAdt")).click(); 
				i++;
			}
			
			// 4. clicking on DONE to add
			driver.findElement(By.id("btnclosepaxoption")).click();
			
			// 5. verifying
			System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			driver.close();
		}

	}

}
