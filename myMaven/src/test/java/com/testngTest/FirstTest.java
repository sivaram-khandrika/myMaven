package com.testngTest;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.restassured.response.*;
import static io.restassured.RestAssured.*;
import net.bytebuddy.NamingStrategy.Suffixing.BaseNameResolver.ForGivenType;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
public class FirstTest extends BaseClass{
	
  @Test(groups = {"firstGroup"})
   public void checkBoxSelectionTest() {
	  
	 
	  driver.get("https://formstone.it/components/checkbox/");
	  WebDriverWait wt = new WebDriverWait(driver,Duration.ofSeconds(20));
	  wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"example-0\"]/div/div[1]/form/fieldset/div/div/input[@type='checkbox']")));
	  WebElement sE= driver.findElement(By.xpath("//*[@id=\"example-0\"]/div/div[1]/form"));
	  JavascriptExecutor js = (JavascriptExecutor)driver;
	  js.executeScript("arguments[0].scrollIntoView();", sE);
	  //driver.findElement(By.xpath("//*[@id=\"example-0\"]/div/div[1]/form/fieldset[4]/div/div/input[@type='checkbox']")).click();
	  List<WebElement> checkedBoxes = driver.findElements(By.xpath("//*[@id=\"example-0\"]/div/div[1]/form/fieldset/div/div/input[@type='checkbox']"));
	  for (int i= 0;i<checkedBoxes.size(); i++) {
		  int j = i+1;
		  WebElement e = driver.findElement(By.xpath("//*[@id=\"example-0\"]/div/div[1]/form/fieldset["+j+"]/div/div/input[@type='checkbox']"));
		  if(!(e.isSelected())) {
			 String s = "";
			 if(j ==1 || j==3) {
				 s="//*[@id=\"example-0\"]/div/div[1]/form/fieldset["+j+"]/label";
			 }else {
				 s="//*[@id=\"example-0\"]/div/div[1]/form/fieldset["+j+"]/div/label";
			 }
			  WebElement e1= driver.findElement(By.xpath(s));
			 System.out.println(e1.getText());
		  };
	  }
  }
  
  @Test(groups = {"firstGroup"})
  public void AlertAndWindowHandleTests() {
	  driver.get("https://demo.guru99.com/test/delete_customer.php");
	 
	  File sh = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	  File dest =new File("D:\\Screenshots\\test.png");
	  try {
		FileUtils.copyFile(sh, dest);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  driver.findElement(By.name("cusid")).click();
	  //driver.findElement(By.name("cusid")).sendKeys("123");
	  JavascriptExecutor js  = (JavascriptExecutor)driver;
	  js.executeScript("document.getElementsByName('cusid')[0].value='1000'");
	  driver.findElement(By.name("submit")).click();
	  Alert alert = driver.switchTo().alert();
	  //WebElement e  = driver.findElement(By.name("submit"));
	  
	  Assert.assertEquals(alert.getText(), "Do you really want to delete this Customer?");
	  
	  alert.dismiss();
	  }
  	@Test(groups = {"firstGroup"})
  	public void SSOUsingRobot() {
  		driver.get("http://www.edureka.co");
  		driver.findElement(By.xpath("//button[text()='Log in']")).click();
  		driver.findElement(By.name("email")).sendKeys("siva.k@abc.com");
  		
  	}
  	
  	//@Test(groups= {"firstGroup"})
  	public void BrokenLinks() {
  		driver.get("http://restservicestesting.blogspot.in/");
  		List<String> href = new ArrayList<String>();
  		List<WebElement> links = driver.findElements(By.tagName("a"));
  		for(WebElement e: links) {
  			String att=e.getDomAttribute("href");
  			if(att!=null) {
  				href.add(att);
  			}
  		}
  		for(String l: href) {
  			
  			if (returnStatusCode(l)!=200) {
  				System.out.println(l+ " : is not a broken link");
 				
  			}else {
  				System.out.println(l+ " : is a broken link");
  			}
  		}
  	}
  	public int returnStatusCode(String url) {
  		//return (given().when().get(url)).statusCode();
  		Response rs = given().when().get(url);
  		return rs.statusCode();
  		
  	}
  	
  	@Test(groups= {"second"})
  	public void RegularExpression() {
  		List<String> names = List.of("LOKES", "Jav30", "LOar1NDIA", "LOKESH123","123","abcd");

  		String regex = "^[a-zA-Z0-9]{1,5}$";

  		Pattern pattern = Pattern.compile(regex);

  		for (String name : names) {
  		  Matcher matcher = pattern.matcher(name);
  		  System.out.println(matcher.matches());
  		}
  	}
}
