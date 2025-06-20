# Handling Checkbox And Getting The Size Of Them

- Domain: https://rahulshettyacademy.com/dropdownsPractise/ 
- LP: ![image](https://github.com/user-attachments/assets/1bb6ba92-c672-41cb-a76c-f110f9437d5e)
- Have to handle these check boxes: ![image](https://github.com/user-attachments/assets/dd44cd89-4da3-4fbf-8b2f-05207050bf67)
- HTML: ![image](https://github.com/user-attachments/assets/1539f583-9dce-49fd-8a15-64a4bb676a9c)

---
**Program**:
```java
package section_7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Checkbox {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		try {
			driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

			// before click on checkbox
			System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
			
			// clicking on checkbox
			driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
			
			// after click on checkbox
			System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
			
			
			// counting all checkbox available on lp
			System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
```

**Output**: ![image](https://github.com/user-attachments/assets/080af535-6c94-4066-85f7-a2131edf30a6)
