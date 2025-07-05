package section_011;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalnderUI {

	public static void main(String[] args) {
		
		
		String monthNumber = "06";
		String date = "15";
		String year = "2027";
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.cssSelector(".react-date-picker__wrapper")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click(); 
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
		driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(monthNumber)-1).click();
		driver.findElement(By.xpath("//abbr[text()='"+date+"']")).click();
		
		String value=driver.findElement(By.cssSelector("input[name='date']")).getDomAttribute("value");
		String[] valueDate = value.split("-");

		if (valueDate[0].trim().equals(year)) {
		    if (valueDate[1].trim().equals(monthNumber)) {
		        if (valueDate[2].trim().equals(date)) {
		            System.out.println("Date Matched");
		            System.out.println("Test Passed");
		        }
		    }
		} else {
		    System.out.println("Date not matched");
		    System.out.println("Test Case Failed");
		}

		
		driver.close();
		
	}

}
