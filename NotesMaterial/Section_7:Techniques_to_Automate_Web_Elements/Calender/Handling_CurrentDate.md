## 🗕️ Handling Calendar Date (Current Date) in Selenium

### 🌟 Objective
Automate **selecting the current date** from a calendar widget on a webpage.

---

### 🧠 Key Concept
Most calendar widgets **highlight the current date** with a **unique CSS class** like:
```
.ui-state-default.ui-state-highlight.ui-state-active
```
This helps identify the current date **without hardcoding** the day/month/year.

---

### 🔍 Locator Strategy
Use **CSS Selector** based on the unique class:

```css
.ui-state-default.ui-state-highlight.ui-state-active
```

To use it in Selenium:
```java
driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
```

> 🔸 Replace spaces with dots when using class names in CSS selectors.

---

### 🧪 Example Steps

```java
// 1. Enter From and To cities
driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).sendKeys("Bengaluru");
driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).sendKeys("Chennai");

// 2. Select current date from calendar
driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
```

---

### 📜 Notes

- **Calendar auto-opens** once "To" city is selected. No need to click calendar explicitly.
- Current date always has the **highlight class** which makes it **uniquely identifiable**.
- This method selects the **current date dynamically** (e.g., 20th today, 21st tomorrow).

---

### ❓ What about future dates?
Selecting a future date (e.g., *March 13*) is more complex:
- Class names for future dates are **not unique** (e.g., `.ui-state-default` is common for all).
- Requires:
  - Looping through date elements
  - Comparing displayed text
  - Handling **month/year navigation**

> 🚫 Instructor advises: **Don’t try future date selection now**  
> ✅ Covered in detail in a **later section** of the course (after ~30 videos)

---

### 🧠 Extra Tips
| What | How |
|------|-----|
| CSS selector for class | `.` + class name |
| CSS selector for ID | `#` + ID name |
| Multiple classes | Replace spaces with `.` |

---

### ✅ Summary
- You can **dynamically select the current date** using a **unique class-based CSS selector**.
- Future date handling will be explained **in a later module**, as it involves looping and advanced DOM interaction.
