# 🧾 Static Dropdown in Selenium (Java) 

## ✅ What is a Static Dropdown?

<h5>A static dropdown is a dropdown element defined using the `&lt;select&gt;` HTML tag. The options are fixed and do not change dynamically.</h5>

```html
<select id="dropdown-example">
  <option value="option1">Option 1</option>
  <option value="option2">Option 2</option>
</select>
```

---

## 🛠 How to Handle Static Dropdown in Selenium?

<h5>Selenium provides the `&lt;select&gt;` class to work with static dropdowns.</h5>

**📦 Import Required Package**
```java
import org.openqa.selenium.support.ui.Select;
```
### ✅ Constructor
```java
Select(WebElement element)
```
<h6>- Initializes the Select object using a dropdown `&lt;select&gt;` WebElement.</h6>

## 🎯 Selection Methods
| Method                             | Description                                                       |
| ---------------------------------- | ----------------------------------------------------------------- |
| `selectByIndex(int index)`         | Selects option by zero-based index.                               |
| `selectByValue(String value)`      | Selects option by the `value` attribute.                          |
| `selectByVisibleText(String text)` | Selects option based on the visible text between `<option>` tags. |

## 🔄 Deselection Methods (only for multi-select dropdowns)
| Method                               | Description                                                       |
| ------------------------------------ | ----------------------------------------------------------------- |
| `deselectByIndex(int index)`         | Deselects option at given index.                                  |
| `deselectByValue(String value)`      | Deselects option with matching `value`.                           |
| `deselectByVisibleText(String text)` | Deselects option with visible text.                               |
| `deselectAll()`                      | Deselects all selected options. (Only for multi-select dropdowns) |

> ⚠️ Throws `UnsupportedOperationException` if used on single-select dropdowns. 

## 🔍 Retrieval Methods 
| Method                     | Return Type        | Description                                  |
| -------------------------- | ------------------ | -------------------------------------------- |
| `getOptions()`             | `List<WebElement>` | Returns all options in the dropdown.         |
| `getAllSelectedOptions()`  | `List<WebElement>` | Returns all selected options (multi-select). |
| `getFirstSelectedOption()` | `WebElement`       | Returns the first selected option.           |


## ❓ Utility Method
Method | Return type | Description
--- | --- | ---
`isMultiple()` | `boolean` | Return `true` if dropdown allows multiple selection


---

## [Practice site](https://rahulshettyacademy.com/dropdownsPractise/) : https://rahulshettyacademy.com/dropdownsPractise/ 

---

**Example**: Handling currency drop down
Landing Page: [img]![image](https://github.com/user-attachments/assets/2a9e1846-124b-47a3-99b3-ab8b83e1739d)
HTML View: [img]![image](https://github.com/user-attachments/assets/fa60f77c-6c17-4e3d-ae7f-c984118c2e8c)

```java
package section_7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Static_dropdown {

	public static void main(String[] args) {
		
		
		/* ---------- 1. Set‑up ChromeDriver automatically ---------- */
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		try {
			/* ---------- 2. Open the practice page that has a <select> dropdown ---------- */
			driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
			
			/*----------- 3. Dropdown with select tag ------------------- */
			WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
			
			/*----------- 4. Creating object of select class ------------*/
			Select dropdown = new Select(staticDropdown);
			dropdown.selectByIndex(3);
			//dropdown.selectByValue("USD");
			//dropdown.selectByContainsVisibleText("USD");
			
			/*----------- 5. Verifying it is selected or not ------------*/
			System.out.println(dropdown.getFirstSelectedOption().getText());
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			driver.close();
		}
		
	}

}
```