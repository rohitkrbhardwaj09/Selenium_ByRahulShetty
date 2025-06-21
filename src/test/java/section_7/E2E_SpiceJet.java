package section_7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class E2E_SpiceJet {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		try {
			driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");
			
			// OneWay
			WebElement oneWay = driver.findElement(By.name("ctl00$mainContent$rbtnl_Trip"));
			
			if(!oneWay.isSelected()) {
				oneWay.click();
			}
			
			// From
			driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
			driver.findElement(By.cssSelector("div[id*='originStation'] ul li a[value='BLR']")).click();	
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("div[id*='destinationStation'] ul li a[value='MAA']")).click();
			driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();
			//System.out.println(driver.findElement(By.id("Div1")).getDomAttribute("style"));
			if(driver.findElement(By.id("Div1")).getDomAttribute("style").contains("0.5")) {
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
			}
			
			driver.findElement(By.id("divpaxOptions")).click();
			
			WebElement adult = driver.findElement(By.id("#hrefIncAdt"));
			int noOfAdult = 3;
			int i = 1;
			while(i < noOfAdult) {
				adult.click();
				i++;
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
