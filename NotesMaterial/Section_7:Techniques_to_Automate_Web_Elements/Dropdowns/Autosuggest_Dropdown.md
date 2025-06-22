# Handling auto-suggestive dropdown using Selenium

- Domain: https://rahulshettyacademy.com/dropdownsPractise/
- Landing Page: ![image](https://github.com/user-attachments/assets/bca09304-0160-40be-bd0a-c00933d0908c)
- Handling Element: Country - ![image](https://github.com/user-attachments/assets/29eedd6d-25a5-4749-883b-8880d034cb2c)
- HTML : ![image](https://github.com/user-attachments/assets/af87a6a9-b48c-40c2-b97f-9f8e62f0a8a9)
> driver.findElement(By.id("autosuggest")).sendKeys("ind");
 
- HTML (with search options 'ind'): ![image](https://github.com/user-attachments/assets/c39efc6f-d123-4822-83d4-38c880d8c1b3)
> driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

- As there we are getting multiple options and options indexing are not fixed then, store all the options in a List, and will traverse and check individully
```java
    List<WebElement> options =  driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
			
			for (WebElement option : options) {
				if(option.getText().equalsIgnoreCase("India")) {
					option.click();
					break;
				}
			}
```

---

**Program**:
```java
package section_7;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Autosuggest_dropdown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		try {
			driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
			
			driver.findElement(By.id("autosuggest")).sendKeys("ind");
			
			Thread.sleep(3000);
			
			List<WebElement> options =  driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
			
			for (WebElement option : options) {
				if(option.getText().equalsIgnoreCase("India")) {
					option.click();
					break;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
```

**Output**: ![image](https://github.com/user-attachments/assets/03b10afb-866d-4ee3-9a27-fcd1eb85b2e7)
