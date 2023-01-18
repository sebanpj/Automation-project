package com.Saucedemo_tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Saucedemo_Pages.AddCart;
import com.Saucedemo_Pages.HomePage;
import com.Saucedemo_Pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddCartTest {
	//Declaring variables globally
	WebDriver driver;
    LoginPage lp;
    HomePage hp;
    AddCart ad;
    @BeforeMethod
    public void setUp() {
    	WebDriverManager.chromedriver().setup();
         //System.setProperty("webdriver.chrome.driver",".\\Drivers\\chromedriver.exe");
           driver = new ChromeDriver();
           driver.get("https://www.saucedemo.com");
           driver.manage().window().maximize();
           driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
         ad = new AddCart(driver);
         lp = new LoginPage(driver);
    }
  //Using @ test annotation of testng and parameters to the data provider.
    @Test(dataProvider = "Swag")
	public void Cart (String uname, String passwd) {
		hp = lp.login(uname, passwd);
		//Testing the Click methods.
    ad.Click();
    //Getting the text to console.
   String Complete = driver.findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/h2")).getText();
    System.out.println(Complete);
    }
    
    @AfterMethod
	public void tearDown() {
    	//closing the driver.
		driver.close();

	}
  //@return object[][] where first column contains valid details
	@DataProvider
	public Object[][] Swag() {
		Object[][] obj = new Object[1][2];
		obj[0][0] = "standard_user";
		obj[0][1] = "secret_sauce";

		return obj;
	}
     
}
