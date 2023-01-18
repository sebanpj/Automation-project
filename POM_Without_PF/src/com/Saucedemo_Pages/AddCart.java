package com.Saucedemo_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddCart {
	//Declaring variables globally
	WebDriver driver;
	 //Locator for MoveToCart,CheckOut,FirstName,LastName,Zipcode,Continue,Finish and Complete.
	By MoveToCart = By.xpath("//*[@id=\"shopping_cart_container\"]/a");
	By CheckOut = By.id("checkout");
	By FirstName = By.id("first-name");
	By LastName = By.id("last-name");
	By Zipcode = By.id("postal-code");
	By Continue = By.id("continue");
	By Finish = By.name("finish");
	By Complete = By.className("title");
	//Applying Constructor
	public AddCart(WebDriver driver) {
		this.driver = driver;
	}
//Method to give actions and SendKeys
	public void Click() {
		driver.findElement(MoveToCart).click();
		driver.findElement(CheckOut).click();
		driver.findElement(FirstName).sendKeys("V.Udita");
		driver.findElement(LastName).sendKeys("Taras");
		driver.findElement(Zipcode).sendKeys("521101");
		driver.findElement(Continue).click();
		driver.findElement(Finish).click();
		driver.findElement(Complete);
	}

}
