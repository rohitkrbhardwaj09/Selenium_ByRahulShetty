# Validating if UI elements are disabled or enabled with attributes

- Domain to test: https://rahulshettyacademy.com/dropdownsPractise/

- LP: Have to check here Return Date calender status; is enabled or disabled
  - ![image](https://github.com/user-attachments/assets/c447f2c1-9d30-47ab-9bb4-a953675c79d7)

- On one way view return date is disabled
  - ![image](https://github.com/user-attachments/assets/b71bd0d6-e90f-4e91-9173-84e288fbad38)
  - HTML: ![image](https://github.com/user-attachments/assets/4c7d71ec-4728-42f7-8aeb-053ef2335378)

- Enabled on Round Trip
  - ![image](https://github.com/user-attachments/assets/b846067a-633f-42ac-9277-2bdf2f938ab3)

---
## Validating Enabled/Disabled Elements in Selenium (UI-based)

### ❓ Objective:

Check whether a UI element (like return date field) is enabled or disabled based on a user action like selecting "Round Trip" or "One Way" radio buttons.

---

### 🔹 Issue with `isEnabled()`

* `isEnabled()` method is supposed to return `true` if the element is enabled, otherwise `false`.
* But in modern web applications, this method is **inconsistent**.
* Some elements **look** disabled on the UI but are **still clickable**, confusing Selenium.

#### Example:

Before clicking on radio button:

```java
driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled(); // Returns true (even if it looks disabled)
```

---

### 🔹 Reliable Approach Using HTML Attributes

1. Inspect the element's parent `<div>`.
2. Look for changes in attributes when toggling between options (e.g., check `style` attribute).

#### Observation:

* When **disabled**, `style="opacity: 0.5"`
* When **enabled**, `style="opacity: 1"`

---

### ✅ Selenium Code Using `getDomAttribute`

```java
// Click on RoundTrip radio button
WebElement roundTrip = driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1"));
roundTrip.click();

// Get the style attribute from the return date calendar's parent div
String styleAttribute = driver.findElement(By.id("Div1")).getDomAttribute("style");
System.out.println("Style attribute: " + styleAttribute);

// Check if it contains '1' which means enabled
if (styleAttribute.contains("1")) {
    System.out.println("Return date field is enabled");
    Assert.assertTrue(true);
} else {
    System.out.println("Return date field is disabled");
    Assert.assertTrue(false); // Fails the test
}
```

> 💡 `getAttribute()` is deprecated. Use `getDomAttribute()` instead.

---

### 🧪 Output Behavior:

* When `style` contains `opacity: 1`, it means the field is enabled.
* When `style` contains `opacity: 0.5`, it means disabled.

### 📝 Notes:

* This workaround works for dynamic UI states not accurately reflected by `isEnabled()`.
* Always inspect the element for attribute changes like `style`, `class`, or `aria-disabled`.

---

### 🚀 Next Steps:

Use this technique in end-to-end test flow combining dropdowns, calendars, checkboxes, passengers, and clicking on search.

---

**Program**
```java
package section_7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calender_ValidateEnabledORDisabled {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		try {
			driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

			System.out.println(driver.findElement(By.className("picker-second")).getDomAttribute("style"));
			driver.findElement(By.className("picker-second")).click();
			System.out.println(driver.findElement(By.className("picker-second")).getDomAttribute("style"));
			
			if(driver.findElement(By.className("picker-second")).getDomAttribute("style").contains("1")) {
				System.out.println("It is enabled");
				Assert.assertTrue(true);
			}else {
				System.out.println("It is disabled");
				Assert.assertTrue(false);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
```

**Output**: 
 - ![image](https://github.com/user-attachments/assets/4321409c-6d35-4163-affd-adfd5ba5ba46)
 
