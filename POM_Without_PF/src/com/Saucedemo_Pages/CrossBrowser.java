package com.Saucedemo_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CrossBrowser {

	public static WebDriver driver;
	
	 public static String browser="Chrome";
	  public void CrossBr() {
		//public static void main(String[] args) {
			// TODO Auto-generated method stub
			 if (browser.equalsIgnoreCase("Chrome")) {
		            System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		            driver = new ChromeDriver();
		            
		        } else if (browser.equalsIgnoreCase("Firefox")) {
		            System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
		            driver = new FirefoxDriver();

		        } else  {
		            System.setProperty("webdriver.edge.driver", ".\\drivers\\msedgedriver.exe");
		            driver = new EdgeDriver();

		        }
}
}

