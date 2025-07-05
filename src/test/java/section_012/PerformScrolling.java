package section_012;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This script demonstrates scrolling actions in a webpage using JavaScriptExecutor in Selenium.
 * - Scrolls the main page vertically.
 * - Scrolls inside a fixed header table (with overflow scroll).
 */
public class PerformScrolling {

    public static void main(String[] args) throws InterruptedException {

        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            // Maximize the browser window
            driver.manage().window().maximize();

            // Navigate to the target webpage
            driver.get("https://rahulshettyacademy.com/AutomationPractice/");

            // Create a JavaScriptExecutor instance from WebDriver
            JavascriptExecutor js = (JavascriptExecutor) driver;

            // Scroll the main page vertically by 500 pixels
            js.executeScript("window.scrollBy(0, 500)");
            System.out.println("Scrolled main page down by 500px");

            // Pause to observe the scroll
            Thread.sleep(3000);

            // Scroll inside the table (having class 'tableFixHead') vertically by 1500 pixels
            js.executeScript("document.querySelector('.tableFixHead').scrollTop = 1500");
            System.out.println("Scrolled inside the table vertically by 1500px");

        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close the browser after completion
            driver.quit();
            System.out.println("Browser closed.");
        }
    }
}
