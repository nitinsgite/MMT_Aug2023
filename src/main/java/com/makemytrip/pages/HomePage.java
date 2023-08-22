package com.makemytrip.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.makemytrip.selenium.utils.DynamicXPathCreator;
import com.makemytrip.selenium.utils.SeleniumUtils;

public class HomePage {

	WebDriver driver;
	public DynamicXPathCreator dpCreator = null;
	public SeleniumUtils selUtils= null;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		selUtils=new SeleniumUtils(driver);
		dpCreator = new DynamicXPathCreator();
	}

	public By lblFromCity = By.xpath("//input[@id='fromCity']");
	public By textFieldFrom = By.xpath("//input[@placeholder='From']");
	public By lblToCity = By.xpath("//input[@id='toCity']");
	public By textFieldTo = By.xpath("//input[@placeholder='To']");
	public By btnSearch = By.xpath("//a[text()='Search']");
	public By lblCheapestPrice = By.xpath("//div[@id='listing-id']//div[@class='clusterContent']/div/div[1]//*[contains(@class,'ViewPrice')]");
	public By cheapestflightName = By.xpath("//div[@id='listing-id']//div[@class='clusterContent']/div/div[1]//*[contains(@class, 'boldFont blackText airlineName')]");
	public By lnkNotificationClose = By.xpath("//a[contains(@id,'notification-close-div')]");
	public By DepDateclick = By.xpath("//input[@id='departure']");
	public By ReturnDateclick = By.xpath("//span[text()='Return']");
	//public By DepartureDate = By.xpath("//label[@for='departure']");
	//public By datePickerWrapper = By.xpath("//label[@for='departure']");
	public String frameName = "notification-frame-~251430519";
	public By modalLogin = By.xpath("//div[@class='headerOuter']");
	public By PopupClose = By.xpath("//button[text()='OKAY, GOT IT!']");
			

	public void selectFrom(String fromCity) {
		selUtils.click(lblFromCity,"From City Label");
		selUtils.enterText(textFieldFrom, fromCity, "From City Text Field");
		selUtils.jsClick(By.xpath(dpCreator.getXpathForSuggestionsDropdown(fromCity)), "From city");
		//driver.findElement(By.xpath(dpCreator.getXpathForSuggestionsDropdown(fromCity))).click();
	}

	public void selectTo(String toCity) throws InterruptedException {
		driver.findElement(lblToCity).click();
		driver.findElement(textFieldTo).sendKeys(toCity);
		//Thread.sleep(1000);
		selUtils.jsClick(By.xpath(dpCreator.getXpathForSuggestionsDropdown(toCity)), "To city");
		//driver.findElement(By.xpath(dpCreator.getXpathForSuggestionsDropdown(toCity))).click();
	}

	public void selectDepartureDate(String monthYear, String date) {
		//WebElement element = driver.findElement(DepartureDate);
		//driver.findElement(datePickerWrapper).click();
		//driver.findElement(DepDateclick).click();
		selUtils.jsClick(By.xpath(dpCreator.getXpathForDateOnDatePicker(monthYear, date)), "Departure date");
		//driver.findElement(By.xpath(dpCreator.getXpathForDateOnDatePicker(monthYear, date))).click();
		
		//JavascriptExecutor executor = (JavascriptExecutor) driver;
		//executor.executeScript("arguments[0].click();", element);
		//driver.findElement(By.xpath(dpCreator.getXpathForDateOnDatePicker(monthYear, date))).click();
	}
	
	public void SelectReturnDate(String returnmonthYear, String returndate) throws InterruptedException {
		driver.findElement(ReturnDateclick).click();
		Thread.sleep(2000);
		selUtils.jsClick(By.xpath(dpCreator.getXpathForReturnDateOnDatePicker(returnmonthYear, returndate)), "Return date");
		//driver.findElement(By.xpath(dpCreator.getXpathForReturnDateOnDatePicker(returnmonthYear, returndate))).click();
		
		/*WebElement element = driver.findElement(ReturnDate);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);*/
		//driver.findElement(ReturnDate).click();
		//driver.findElement(DepartureDate).sendKeys(Keys.ESCAPE);
		
	}

	public void clickSearch() {
		driver.findElement(btnSearch).click();
	}
	
	public void CloseOverlay() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(PopupClose).click();
		Thread.sleep(3000);	
	}

	public void searchFlights(String fromCity, String toCity, String monthYear, String date) throws InterruptedException {
		//closeNotification();
		selectFrom(fromCity);
		selectTo(toCity);
		selectDepartureDate(monthYear, date);
		clickSearch();
		Thread.sleep(10000);
		CloseOverlay();
	}
	
	public void searchFlightsReturn(String fromCity, String toCity, String monthYear, String date, String returnmonthYear, String returndate) throws InterruptedException {
		//closeNotification();
		selectFrom(fromCity);
		selectTo(toCity);
		selectDepartureDate(monthYear, date);
		SelectReturnDate(returnmonthYear, returndate);
		clickSearch();
		Thread.sleep(20000);
		CloseOverlay();
	}

	public void cheapestFlightRates() throws InterruptedException {
		Thread.sleep(10000);
		String cheapestRates = driver.findElement(lblCheapestPrice).getText();
		String chpFlightName = driver.findElement(cheapestflightName).getText();
		
		System.out.println("The lowest price for your search is " + cheapestRates);
		System.out.println("The flight name of the lowest price is " + chpFlightName);
	}

	//Add below snippet if notifications is displayed (Ensure you add the notification name to the variable
	public void closeNotification() throws InterruptedException {
		Thread.sleep(5000);
		driver.switchTo().frame(frameName);
		if (driver.findElement(lnkNotificationClose).isDisplayed()) {
			driver.findElement(lnkNotificationClose).click();
		}
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		selUtils.jsClick(modalLogin, "Modal Login");
	}

}
