package section_012;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Title: Table Structure Verification (Rows, Columns, Specific Cell Value)
 * 
 * Description:
 * This program performs the following:
 * 1. Identifies a specific HTML table on the page.
 * 2. Counts the number of rows and columns in the table.
 * 3. Extracts the text from a specific cell (3rd row, 2nd column).
 */
public class Assignment1 {

    public static void main(String[] args) {

        // Step 1: Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            // Step 2: Navigate to the practice site
            driver.manage().window().maximize();
            driver.get("https://rahulshettyacademy.com/AutomationPractice/");
            System.out.println("Opened Automation Practice page.");

            // Step 3: Locate the table by name attribute
            WebElement table = driver.findElement(By.cssSelector("table[name='courses']"));

            // Step 4: Count number of rows in the table body
            List<WebElement> rowList = table.findElements(By.cssSelector("tbody tr"));
            int rowCount = rowList.size();
            System.out.println("Number of rows in the table: " + rowCount);

            // Step 5: Count number of columns from the first row using <th> elements
            List<WebElement> colList = table.findElements(By.cssSelector("tbody tr:first-child th"));
            int colCount = colList.size();
            System.out.println("Number of columns in the table: " + colCount);

            // Step 6: Fetch the text of the 3rd row and 2nd column
            String cellValue = table.findElement(By.cssSelector("tbody tr:nth-child(3) td:nth-child(2)")).getText();
            System.out.println("Value at (Row 3, Column 2): " + cellValue);

        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Step 7: Close the browser
            driver.quit();
            System.out.println("Browser closed.");
        }
    }
}
