
## 🚨 Handling JavaScript Alerts in Selenium (Java)

### 🧠 Why Alerts Are Special
- Browser pop‑ups created by `alert()`, `confirm()`, or `prompt()` **aren’t part of the HTML DOM** → you can’t locate them with `By.id`, X‑Path, etc.
- Selenium must **switch context** from the normal page to the alert before interacting.

```java
Alert alert = driver.switchTo().alert();
```

---

### 🔷 Types of JS Alerts
| Type | Dialog Buttons | Selenium Actions |
|------|----------------|------------------|
| **Simple Alert** (`alert()`) | OK | `accept()` |
| **Confirm** (`confirm()`) | OK • Cancel | `accept()` ↔ OK<br>`dismiss()` ↔ Cancel |
| **Prompt** (`prompt()`) | Text field • OK • Cancel | `sendKeys()` + `accept()` / `dismiss()` |

---

### 📑 Core API (org.openqa.selenium.Alert)
| Method | Purpose |
|--------|---------|
| `getText()` | Returns alert message |
| `accept()` | Clicks *OK* / *Yes* |
| `dismiss()` | Clicks *Cancel* / *No* |
| `sendKeys(String)` | Types text into **prompt** alerts |

> Always call `driver.switchTo().alert()` first; otherwise `NoAlertPresentException` is thrown.

---

### 🛠️ Example 1 – Simple Alert
```java
// Trigger alert on page
driver.findElement(By.id("alertbtn")).click();

Alert alert = driver.switchTo().alert();
System.out.println("Message: " + alert.getText());
alert.accept();       // clicks OK
```

**Program**:
```java
package section_7;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts_withOK {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("name")).sendKeys("Rohit Bhardwaj");
		driver.findElement(By.id("alertbtn")).click();
		
		Alert alert =  driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		

	}

}
```
**Output**: ![image](https://github.com/user-attachments/assets/345ac7b6-3bdf-4fc1-930d-ab20b2ed7c41)

### 🛠️ Example 2 – Confirm (Cancel path)
```java
driver.findElement(By.id("confirmbtn")).click();

Alert alert = driver.switchTo().alert();
String txt = alert.getText();
Assert.assertTrue(txt.contains("confirm"));
alert.dismiss();      // clicks Cancel / No
```
**Program:**
```java
package section_7;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alert_withConfirm {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("name")).sendKeys("Rohit Bhardwaj");
		
		driver.findElement(By.id("confirmbtn")).click();

		Alert alert= driver.switchTo().alert();
		System.out.println(alert.getText());
		//alert.accept();
		alert.dismiss();
	}
}
```
**Output**: ![image](https://github.com/user-attachments/assets/b16ecef7-2791-4f94-bcbd-8e9bf86f607b)



### 🛠️ Example 3 – Prompt with Input
```java
driver.findElement(By.id("promptbtn")).click();
Alert alert = driver.switchTo().alert();
alert.sendKeys("Hello");
alert.accept();
```

---

### ⏳ Waiting for Alerts
```java
new WebDriverWait(driver, Duration.ofSeconds(5))
        .until(ExpectedConditions.alertIsPresent());
```

---

### ⚠️ Gotchas & Tips
- **No HTML locators**: right‑click + *Inspect* won’t work on JS alerts.
- Use **`accept()` for positive actions** (OK / Yes), **`dismiss()` for negative** (Cancel / No).
- **OS‑level dialogs** (HTTP auth, file uploads) aren’t JS alerts → handle with tools like **AutoIt** or the OS‑specific API.
- For unsaved‑changes pop‑ups, the same Alert API applies once the dialog is JavaScript‑based.

---

### 📝 Recap Workflow
1. Trigger action that opens alert.
2. `driver.switchTo().alert()` to grab the alert handle.
3. Validate or log `getText()` if needed.
4. Interact with `accept()`, `dismiss()`, or `sendKeys()`.
5. Control returns automatically to the main page.

Use this template whenever your web tests hit unexpected pop‑ups!
