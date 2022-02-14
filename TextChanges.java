package Week4_Day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TextChanges {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); 
        driver.get("http://www.leafground.com/pages/TextChange.html");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(300));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Click ME')]")));
       WebElement alert1 =  driver.findElement(By.xpath("//button[contains(text(),'Click ME')]"));
       alert1.click();
       Alert alert11 = driver.switchTo().alert();
       String text = alert11.getText();
       alert11.accept();
       
       if(text.contains("Click ME!"))
       {
    		  System.out.println(text +" Text is verified" );
       }
       else
    	   
    	   System.out.println("Text is not verified" );
	} 

}
