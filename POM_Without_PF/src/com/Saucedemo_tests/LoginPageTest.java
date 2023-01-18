package com.Saucedemo_tests;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import com.Saucedemo_Pages.CrossBrowser;
import com.Saucedemo_Pages.HomePage;
import com.Saucedemo_Pages.LoginPage;

import bsh.util.ClassBrowser;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageTest {
	//Declaring variables globally
	WebDriver driver;
	LoginPage lp;
	HomePage hp;
	public static String browser = "Chrome";

	@BeforeMethod
	public void setUp() {      
       //Performing the CROSS BROWSER testing.
		if (browser.equalsIgnoreCase("Chrome")) {
			 WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			//System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else {
			WebDriverManager.edgedriver().setup();
			//System.setProperty("webdriver.edge.driver", ".\\drivers\\msedgedriver.exe");
			driver = new EdgeDriver();

		}
        //Launching the application
		driver.get("https://www.saucedemo.com");
		//Maximizing the window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Creating object of LoginPage and driver instance is passed as parameter to construct of LoginPage.
		lp = new LoginPage(driver);

	}
    //Using @ test annotation of testng.
	@Test
	public void verifyLogo() {
		boolean flag = lp.validateLogo();
		// Verify that success Message is displayed.
		Assert.assertTrue(flag);
		System.out.println("Logo verification successful");

	}
//Using @ test annotation of testng and parameters to the data provider.
	@Test(dataProvider = "datatest")
	public void verifyLogin(String uname , String passwd) throws Exception {

	    hp = lp.login(uname , passwd);
	    System.out.println("Details entered successful");
	     			
	}

	//@return object[][] where first column contains valid details and second column contains invalid details.
	@DataProvider(name = "datatest")   
    public Object[][] Swag(){
        Object[][] obj = new Object[2][2];
        obj [0][0] = "standard_user";
        obj [0][1] = "secret_sauce";
        obj [1][0] = "standard_user";
        obj [1][1] = "secret_sauc";
        return obj;     
	}
	
	@AfterMethod
	public void tearDown() {
		//closing the driver.
		driver.close();

	}
}
