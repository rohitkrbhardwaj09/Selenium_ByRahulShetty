package section_007;

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
