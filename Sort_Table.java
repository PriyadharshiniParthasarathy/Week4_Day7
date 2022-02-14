package Week4_Day1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sort_Table {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); 
        driver.get("http://www.leafground.com/pages/sorttable.html");
        
        //First get all the values of names and stored in lists
  List <WebElement> Name = driver.findElements(By.xpath("//td[2]"));
  List<String> numberlist = new ArrayList <String>();
  System.out.println("Names list1----------------");
  for(WebElement webElement :Name)
  {
	  String Name1 = webElement.getText();
	  numberlist.add(Name1);
	  System.out.println(Name1);
  }

  
  //Click on the Name header
 WebElement Sort = driver.findElement(By.xpath("//th[2]"));
 Sort.click();
 
 //Again get all the values of names and stored in lists
 List <WebElement> Name3 = driver.findElements(By.xpath("//td[2]"));
 List<String> numberlist1 = new ArrayList <String>();
 System.out.println("Names list2----------------");
 for(WebElement webElement1 :Name3)
 {
	  String Name4 = webElement1.getText();
	  numberlist1.add(Name4); 
	  System.out.println(Name4);
 }
 
 if(numberlist.equals(numberlist1))
 {
	 System.out.println("Both the lists are equal"); 
 }
 
 else
	 System.out.println("Both the lists are not equal"); 
 
	TakesScreenshot screenshot = (TakesScreenshot) driver;
	File source_file = screenshot.getScreenshotAs(OutputType.FILE);
	File Dest_file =  new File (".\\src\\main\\resources\\Sorttable.png");
	FileHandler.copy(source_file, Dest_file);
	}
	


}
