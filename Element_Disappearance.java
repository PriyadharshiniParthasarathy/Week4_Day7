package Week4_Day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Element_Disappearance {

		public static void main(String[] args) {
			WebDriverManager.chromedriver().setup(); 
			ChromeDriver driver = new ChromeDriver();
			driver.manage().window().maximize(); 
			driver.get("http://www.leafground.com/pages/disapper.html"); 
			WebElement Text = driver.findElement(By.xpath("//Strong[contains(text(),'I know you can do it! Button is disappeared')]"));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//b[contains(text(),'disappear')]")));
		
		if(Text.isDisplayed())
		{
			System.out.println("----"+Text.getText()+"-----");
		}
	
				}

		
			}


