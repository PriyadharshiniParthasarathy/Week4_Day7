package Week4_Day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Element_Appears {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.get("http://www.leafground.com/pages/appear.html"); 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		WebElement Button = driver.findElement(By.xpath("//button[@id='btn']//b[1]"));
		wait.until(ExpectedConditions.visibilityOfAllElements(Button));
		System.out.println(Button.getText());
		
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source_file = screenshot.getScreenshotAs(OutputType.FILE);
		File Dest_file =  new File (".\\src\\main\\resources\\Element_Appears.png");
		FileHandler.copy(source_file, Dest_file);
		

	}

}
