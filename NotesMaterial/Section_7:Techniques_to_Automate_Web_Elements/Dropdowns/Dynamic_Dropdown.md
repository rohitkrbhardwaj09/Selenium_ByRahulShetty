# Handle Dynamic dropdowns with WebDriver API

- Domain: https://rahulshettyacademy.com/dropdownsPractise/ 
- landing page : ![image](https://github.com/user-attachments/assets/7a682c3e-9856-4049-b556-4bfebbbf6c68)
  - Which works dynamically on select city option (Arrival city can be selected only after the selection of the Departure city)

- LP (view) : ![image](https://github.com/user-attachments/assets/37216960-9162-4fcc-a1fc-347768b9ffb9)
- LP (inspect) : ![image](https://github.com/user-attachments/assets/d5b051de-6aba-414e-b9cf-172a0720bd68)

---

**Program**:

```java
package section_7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dynamic_Dropdown {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		try {
			driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
			
			// opening up drop-down
			driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
			
			// departure city
			driver.findElement(By.xpath("//a[@value='BLR']")).click();
			
			// sleep to making it visible
			Thread.sleep(2000);
			
			// arrival city
			// there is 2 occurrence of Chennai(MAA), so in order to click 2nd written this way
			driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
```

**Output**:
![image](https://github.com/user-attachments/assets/2532dd81-8b61-479e-86cc-75a4e58e3fd8)

---

# Parent-child relationship locator to identify the object Uniquely (Section-7: lecture 56)


<h5>This is absolutely correct by sometime some orgranization doesn't encourage indexed value</h5>
> driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click(); 

<h6>so, What is its alternative?</h6>
<p>**Parent-child travel mechanism**</p>

- Depature (HTML): ![image](https://github.com/user-attachments/assets/70aaf4d3-08db-4cd3-b448-1ec2ad29a62e)
> //div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']
 
- Arrival (HTML): ![image](https://github.com/user-attachments/assets/a5f2792b-f57a-4356-aaea-cefbb111efff)
> //div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR 

**Program**:
```java
package section_7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dynamic_Dropdown {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		try {
			driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
			
			// opening up drop-down
			driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
			
			// arrival city
			driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']")).click();
			
			// sleep to making it visible
			Thread.sleep(2000);
			
			// departure city
			// there is 2 occurrence of Chennai(MAA), so in order to click 2nd written this way
			driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
```

**Output**:
![image](https://github.com/user-attachments/assets/4ac075d2-5d69-4696-9934-afb232734385)
