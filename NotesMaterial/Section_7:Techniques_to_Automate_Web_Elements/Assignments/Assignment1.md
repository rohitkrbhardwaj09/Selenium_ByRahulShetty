# Checkbox Exercise

## Questions for this assignment

<h2>Navigate to Below URL: https://rahulshettyacademy.com/AutomationPractice/ </h2>
<h4>There are 3 Checkboxes displayed in the Page. Refer below image</h4>
![image](https://github.com/user-attachments/assets/6951534b-5f6a-48b3-945a-f46bc83c95f3)


https://rahulshettyacademy.com/AutomationPractice/

<h3>1. Check the first  Checkbox and verify if it is successfully checked and Uncheck it again to verify if it is successfully Unchecked</h3>

<h3>2. How to get the Count of number of check boxes present in the page</h3>

HTML View: ![image](https://github.com/user-attachments/assets/4cb030cb-7b3f-42ea-ac4b-ab2a6930fd00)

--- 

**Program**: 
```java
package section_7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Checkbox_Assignment1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		try {
			
			driver.get("https://rahulshettyacademy.com/AutomationPractice/");
			
			// 1. Check the first Checkbox and verify if it is successfully checked and Uncheck it again to verify if it is successfully Unchecked 
			Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected());
			driver.findElement(By.id("checkBoxOption1")).click();
			Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected());
			driver.findElement(By.id("checkBoxOption1")).click();
			Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected());
			
			// 2. How to get the Count of number of check boxes present in the page
			int checkboxCount = driver.findElements(By.cssSelector("input[type='checkbox']")).size();
			Assert.assertEquals(3, checkboxCount);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
```