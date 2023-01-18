package com.Saucedemo_tests;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Saucedemo_Pages.HomePage;
import com.Saucedemo_Pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePageTest {
	//Declaring variables globally
	WebDriver driver;
	LoginPage lp;
	HomePage hp;

	@BeforeMethod
	public void setUp() {
	     WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// hp = new HomePage(driver);
		//Creating object of LoginPage and driver instance is passed as parameter to construct of LoginPage.
		lp = new LoginPage(driver);

	}
    // Calling the LoginPage again Using @ test annotation of testng and parameters to the data provider.
	@Test(dataProvider = "Swag")
	public void check(String uname, String passwd) {
		hp = lp.login(uname, passwd);
		boolean flag = hp.action();
		// Verify that action done.
		Assert.assertTrue(flag);
		System.out.println("Action done successfully");
	}
	@Test(dataProvider = "Swag")
	public void validateCart(String uname, String passwd) throws Exception {
		hp = lp.login(uname, passwd);
		hp.perform();
		//Taking the screenshot that AddToCart has clicked.
		WebElement perform = driver.findElement(By.id("remove-sauce-labs-backpack"));
		//call getScreenshotAs method to create image file
		File src = perform.getScreenshotAs(OutputType.FILE);
		//Moving the file to the destination place
		File trg = new File(".\\Screenshots\\element.png");
		//Copy the file at target
		FileUtils.copyFile(src, trg);
		System.out.println("Screenshot has taken successfully");
	}
	  public static void WritingTheDataToExcel(String[] args) throws IOException {
		  
			//writing the data to excel 
		  //Create a blank workbook
			  XSSFWorkbook workbook = new XSSFWorkbook();
			  //Create sheet and name it.
			  XSSFSheet workSheet = workbook.createSheet("Products");
			  //create a row
			  XSSFRow row = workSheet.createRow(3);
			  //create a cell
			  XSSFCell cell = row.createCell(2);
			  XSSFCell cell1 = row.createCell(3);
			  
			  //writing the data into sheet
			  cell.setCellValue("Sauce Labs Backpack");
			  cell1.setCellValue("$29.99");
			  
			  //.xlsx is the format for excel sheets..
			  //writing the workbook into the file..
			  FileOutputStream fos = new FileOutputStream(".\\DataFile\\Ordered.xlsx");
			  workbook.write(fos); 
			  fos.flush(); 
			  workbook.close();
			  System.out.println("Details enterd to the excel");
			 
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
