package section_012;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TableHandling {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            // Maximize the window and open the URL
            driver.manage().window().maximize();
            driver.get("https://rahulshettyacademy.com/AutomationPractice/");

            // Locate the table with fixed header
            WebElement table = driver.findElement(By.className("tableFixHead"));

            // Get all cells in the last column (Amount column)
            List<WebElement> amountCells = table.findElements(By.cssSelector("tbody tr td:last-child"));

            int calculatedSum = 0;

            // Loop through each cell and add the value to calculatedSum
            for (WebElement cell : amountCells) {
                String cellText = cell.getText();
                try {
                    calculatedSum += Integer.parseInt(cellText);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number format in cell: " + cellText);
                }
            }

            // Get the total displayed on the UI and parse the integer part
            String totalText = driver.findElement(By.className("totalAmount")).getText(); // e.g. "Total Amount Collected: 296"
            int displayedTotal = Integer.parseInt(totalText.split(":")[1].trim());

            // Compare calculated sum with displayed total
            if (calculatedSum == displayedTotal) {
                System.out.println("Test Passed: Calculated sum (" + calculatedSum + ") matches displayed total (" + displayedTotal + ")");
            } else {
                System.out.println("Test Failed: Calculated sum (" + calculatedSum + ") does NOT match displayed total (" + displayedTotal + ")");
            }

        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Always close the browser
            driver.quit();
        }
    }
}
