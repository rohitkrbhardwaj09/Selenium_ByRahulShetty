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
