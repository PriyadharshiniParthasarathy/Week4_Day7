package Week4_Day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Toy_with_Tables {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); 
        driver.get("http://www.leafground.com/pages/table.html");
     
        //Get the count of number of columns
        List <WebElement> Columns = driver.findElements(By.tagName("th"));
        System.out.println("No of Columncount "+Columns.size());
        
        //Get the count of number of rows
        List <WebElement> rows = driver.findElements(By.tagName("tr"));
        System.out.println("No of Rowscount "+rows.size());
        
        //Get the progress value of "Learn to interact with Elements"
        WebElement Percent = driver.findElement(By.xpath("//td[text()='Learn to interact with Elements']/following::td[1]"));
      //  String Percentage = Percent.getText();
        System.out.println("Progress value for Learn to interact with Elements - " +Percent.getText());
        
        //Check the vital task for the least completed progress
        List <WebElement> Progress = driver.findElements(By.xpath("//td[2]"));
       List<Integer> numberlist = new ArrayList <Integer>();
        for(WebElement webElement : Progress)
        {
        	String WebElement1 = webElement.getText().replace("%","");
        	numberlist.add(Integer.parseInt(WebElement1));
        }
        System.out.println("Final List - " +numberlist); 
        int smallvalue = Collections.min(numberlist);
        System.out.println("Smallest value is - " +smallvalue);
        String smallvalue_String = Integer.toString(smallvalue)+"%";
        String Finalxpath ="//td[normalize-space()="+"\""+smallvalue_String+"\""+"]"+"//following::td[1]//input";
        System.out.println(Finalxpath);
      WebElement Checkbox = driver.findElement(By.xpath(Finalxpath));
      Checkbox.click();
 

}
}
