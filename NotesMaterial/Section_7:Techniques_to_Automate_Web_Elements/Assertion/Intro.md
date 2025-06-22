# ✅ Assertions in Selenium using TestNG 
## 📌 What is an Assertion?
- An assertion is a validation point that checks whether the actual result from the application matches the expected result.

- If the assertion fails, the test fails automatically, and no further steps are executed.

## 🔧 Why Use TestNG for Assertions?
- TestNG is a testing framework that provides features like assertions, test configuration, parallel execution, etc.

- In this lecture, we’re using only the assertion feature of TestNG.

- Assertions help avoid checking results manually through console logs.

## 🔌 Adding TestNG to Project 
> If you're not using Maven, follow this:
1. Go to https://mvnrepository.com

2. Search for TestNG

3. Download a .jar file (e.g., testng-6.9.4.jar)

4. In Eclipse:

  - Right-click project → Build Path → Configure Build Path

  - Go to Libraries → Add External JARs → Select the downloaded .jar

  - Click Apply and Close

> If you're using Maven, just add this to your pom.xml:
```xml
<dependency>
  <groupId>org.testng</groupId>
  <artifactId>testng</artifactId>
  <version>7.9.0</version>
  <scope>test</scope>
</dependency>
```

## ✅ Common Assertion Methods 
| Method                                  | Use Case                            | Explanation                   |
| --------------------------------------- | ----------------------------------- | ----------------------------- |
| `Assert.assertTrue(condition)`          | Validates that condition is `true`  | Fails if condition is `false` |
| `Assert.assertFalse(condition)`         | Validates that condition is `false` | Fails if condition is `true`  |
| `Assert.assertEquals(actual, expected)` | Validates that two values are equal | Fails if not equal            |

> All assertions are from:
```java
import org.testng.Assert;
```

## 🧪 Sample Use Case: Checkbox
```java
// Check if checkbox is NOT selected (before clicking)
Assert.assertFalse(driver.findElement(By.id("checkbox-id")).isSelected());

// Click the checkbox
driver.findElement(By.id("checkbox-id")).click();

// Now verify it is selected
Assert.assertTrue(driver.findElement(By.id("checkbox-id")).isSelected());
```

## 🧪 Use Case: Verifying checkbox (e.g., 6 checkboxes )
```java

```

## ❌ What Happens When Assertion Fails?
- TestNG will stop execution at the point of failure.

- Error message will show what was expected vs. actual.

**Example**:
java.lang.AssertionError: expected [6] but found [5]


## 💡 Tips
- Use assertions instead of System.out.println() for validations.

- Assertions provide a clean, readable and reliable way to validate test output.

- While learning, instructor uses println() often, but in real projects, use assertions consistently.

## 🧪 Summary: When to Use What
| You Expect...         | Use                                     |
| --------------------- | --------------------------------------- |
| A value to be `true`  | `Assert.assertTrue(...)`                |
| A value to be `false` | `Assert.assertFalse(...)`               |
| Two values to match   | `Assert.assertEquals(actual, expected)` |


---

**Program**:
```java
package section_7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleAssertion {

	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		try {
			driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
			
			Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

			// clicking on checkbox
			driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
			
			// after click on checkbox
			Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
			
			
			// counting all checkbox available on lp
			int checkboxCount = driver.findElements(By.cssSelector("input[type='checkbox']")).size();
			
			Assert.assertEquals(6, checkboxCount);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
```
