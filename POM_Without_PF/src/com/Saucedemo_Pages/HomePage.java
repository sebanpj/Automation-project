package com.Saucedemo_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePage {
	//Declaring variables globally
	WebDriver driver;
	 //Locator for Name,AddToCart and MenuBtn
	By Name = By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select");
	By AddToCart = By.id("add-to-cart-sauce-labs-backpack");
	By MenuBtn = By.id("react-burger-menu-btn");
	//Applying Constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
     //Method to find Name
	public boolean action() {
        //Instantiating a new Action object
		Actions act = new Actions(driver);
		driver.findElement(Name).click();
		act.sendKeys(Keys.ARROW_DOWN).click();
		return true;
	}
    //Method to find AddToCart
	public AddCart perform() {
		driver.findElement(AddToCart).click();
		//Method to return to AddToCart
		return new AddCart(driver);
		
	}
	
		
		
		
		
	
}


