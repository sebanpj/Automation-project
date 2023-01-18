package com.Saucedemo_Pages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage{
	//Declaring variables globally
  WebDriver driver;
  //Locator for userName,password,loginBtn and logo.
  By userName = By.id("user-name");
  By password = By.id("password");
  By loginBtn = By.id("login-button");
  By logo = By.xpath("//*[@id=\"root\"]/div/div[1]");
  //Applying Constructor
  public LoginPage (WebDriver driver) {
      this.driver = driver; 
  }
  //Method to find logo.
  public boolean validateLogo () {
      driver.findElement(logo).isDisplayed();
      return true; 
      
  }
  //Method to find elements and entering the uname and passwd.
  public HomePage login(String uname , String passwd) {
      driver.findElement(userName).sendKeys(uname);
      driver.findElement(password).sendKeys(passwd);
      //Method to find and click on the loginBtn
      driver.findElement(loginBtn).click();

      //Method to return to HomePage
      return new HomePage(driver);
      
  }
}

