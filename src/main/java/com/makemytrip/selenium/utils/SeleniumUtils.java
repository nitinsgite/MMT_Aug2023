package com.makemytrip.selenium.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;
import com.makemytrip.base.BaseClass;

public class SeleniumUtils {

	WebDriver driver;
	public SeleniumUtils(WebDriver driver) {
		this.driver = driver;
	}
	
	public void click(By locator,String locName) {
		driver.findElement(locator).click();
		BaseClass.extentTest.log(Status.PASS, "Clicked successfully on "+locName);
	}
	
	
	public void enterText(By locator,String text,String locName) {
		driver.findElement(locator).sendKeys(text);
		BaseClass.extentTest.log(Status.PASS, "Clicked successfully on "+locName);
	}
	
	public void jsClick(By locator, String locName) {
		WebElement element = driver.findElement(locator);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		BaseClass.extentTest.log(Status.PASS, "Clicked successfully on "+locName);
	}
	
}
