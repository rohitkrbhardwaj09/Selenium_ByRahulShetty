# Assignment: UI(Dropdowns,EditBoxes,Error Valdiation) Assignment

<h3> This Practise Assignment helps you to get hands free on Dropdown handling using Select and Edit boxes, links & button selections.</h3>

- Domain: https://rahulshettyacademy.com/angularpractice/

**Program**:
```java
package section_7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UI_Assignment2 {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		try {
			
			driver.get("https://rahulshettyacademy.com/angularpractice/");
			
			WebElement name = driver.findElement(By.cssSelector("div[class='form-group']>input[name='name']"));
			WebElement email = driver.findElement(By.cssSelector("input[name='email']"));
			WebElement password = driver.findElement(By.id("exampleInputPassword1"));
			WebElement chkBox = driver.findElement(By.id("exampleCheck1"));
			WebElement gender = driver.findElement(By.id("exampleFormControlSelect1"));
			WebElement empStatus = driver.findElement(By.cssSelector(".form-group>div>input[class*='check-input'][value='option2']"));
			WebElement dob = driver.findElement(By.cssSelector("input[type='date']"));
			WebElement submit = driver.findElement(By.cssSelector("input[value='Submit']"));
			
			name.sendKeys("Rohit Bhardwaj");
			email.sendKeys("Rohit@gmail.com");
			password.sendKeys("Rohit@123");
			chkBox.click();
			Select genderOptions = new Select(gender);
			genderOptions.selectByVisibleText("Male");
			empStatus.click();
			dob.sendKeys("05/09/1996");
			submit.click();
			
			String successText= driver.findElement(By.className("alert-success")).getText();
			if(successText.contains("Success")){
				System.out.println("Success");
			}else {
				System.out.println("Something went wrong");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
```
**Output**: 
- ![image](https://github.com/user-attachments/assets/c5853b77-25f1-463a-bc37-640cde0729f4)
- ![image](https://github.com/user-attachments/assets/9306fb7d-2388-479d-81d5-bc863134f05c)