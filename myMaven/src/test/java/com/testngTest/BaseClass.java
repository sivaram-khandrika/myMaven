package com.testngTest;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

public class BaseClass {
  public WebDriver driver;
  
 
  @BeforeMethod(groups= {"firstGroup","second"})
 
  @Parameters({"browser"})
  public void Test(String browser) {
	  switch(browser.toLowerCase()){
	  case "chrome":
		  //WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
		  break;
	  case "edge" :
		  WebDriverManager.edgedriver();
		  driver = new EdgeDriver();
		  break;
	  default :
		  System.out.println("Invalid brouswer");
  }
  driver.manage().window().maximize();
   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
  }
  
  @AfterMethod(groups= {"firstGroup","second"})
  public void TeadDown() {
	  driver.close();
	  driver.quit();
  }

}
