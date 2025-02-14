package com.testngTest;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class SecondTest extends BaseClass {

	@Test(groups = {"firstGroup"})
	@Parameters({"browser","url"})
  public void fistTestInSecondTestClass() {
		driver.get("https://flipkart.com");
		FluentWait wt = new FluentWait(driver);
		wt.withTimeout(Duration.ofSeconds(20))
		  .pollingEvery(Duration.ofMillis(500))
		  .ignoring(NoSuchElementException.class) 
		  .ignoring(ElementNotInteractableException.class);
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div[1]/div/div/div/div[2]/div[1]/div/div[1]/div/div/div/div/div[1]/a[1]")));
		 
	  System.out.println("first test in Second Test class"+ driver.getTitle());
  }
	
}
