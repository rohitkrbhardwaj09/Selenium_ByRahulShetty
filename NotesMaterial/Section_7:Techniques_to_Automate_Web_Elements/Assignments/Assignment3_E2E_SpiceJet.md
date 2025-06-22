## ✈️ SpiceJet End‑to‑End UI Automation (One‑Way Booking)

> **Site under test:** <https://rahulshettyacademy.com/dropdownsPractise/>
>
> Goal: Book a **one‑way** flight **DEL → MAA** for **5 Adult (Senior Citizen)** passengers on the **current date** and click **Search**, validating that the return‑date field stays disabled.

---

### 🔧 Dependencies
```xml
<!-- Selenium + TestNG + WebDriverManager -->
<dependencyManagement>
  <dependencies>
    <dependency>
      <groupId>org.seleniumhq.selenium</groupId>
      <artifactId>selenium-bom</artifactId>
      <version>4.33.0</version>
      <type>pom</type>
      <scope>import</scope>
    </dependency>
  </dependencies>
</dependencyManagement>

<dependencies>
  <dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
  </dependency>
  <dependency>
    <groupId>io.github.bonigarcia</groupId>
    <artifactId>webdrivermanager</artifactId>
    <version>6.1.0</version>
  </dependency>
  <dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>7.11.0</version>
    <scope>test</scope>
  </dependency>
</dependencies>
```

---

### 📝 Test Class (Java + TestNG)
```java
package spicejet;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.*;

public class SpiceJetEndToEndTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @Test
    public void bookOneWayFlight() {
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        // 1️⃣  Ensure ONE‑WAY is selected
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();

        // 2️⃣  ORIGIN = DEL
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='DEL']")).click();

        // 3️⃣  DESTINATION = MAA (second match in the list)
        new WebDriverWait(driver, Duration.ofSeconds(2))
             .until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@value='MAA'])[2]"))).click();

        // 4️⃣  Current date
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();

        // 5️⃣  Verify return‑date calendar is DISABLED (opacity 0.5)
        String style = driver.findElement(By.id("Div1")).getDomAttribute("style");
        Assert.assertTrue(style.contains("0.5"), "Return date should be disabled for one‑way trip");

        // 6️⃣  Open passenger picker
        driver.findElement(By.id("divpaxinfo")).click();

        // 7️⃣  Increase Adults to 5 (default is 1 → 4 extra clicks)
        for (int i = 1; i < 5; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }

        // 8️⃣  Close passenger picker
        driver.findElement(By.id("btnclosepaxoption")).click();

        // 9️⃣  Validate passenger label shows "5 Adult"
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");

        // 🔟  Select Senior Citizen discount checkbox
        driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).click();

        // 11️⃣ Click Search
        driver.findElement(By.cssSelector("input[value='Search']")).click();

        // 12️⃣ Basic wait for results page / banner
        new WebDriverWait(driver, Duration.ofSeconds(5))
             .until(ExpectedConditions.urlContains("Search"));
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}
```

---

### ✔️ What this script validates
| Step | Check |
|------|-------|
| Return‑date field | Ensures `style` contains `opacity: 0.5` after choosing **One‑Way** |
| Passenger picker  | Confirms label becomes **“5 Adult”** |
| Senior Citizen    | Checkbox clicked (`ctl00_mainContent_chk_SeniorCitizenDiscount`) |
| Search click      | Script reaches the results page (URL contains `Search`) |

Feel free to tweak passenger counts, origin/destination pairs, or add extra assertions for price/error banners. Let me know if you need a **JUnit** variant or additional logging! 🌟