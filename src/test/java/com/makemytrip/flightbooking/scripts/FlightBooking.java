package com.makemytrip.flightbooking.scripts;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.makemytrip.base.BaseClass;
import com.makemytrip.pages.HomePage;

public class FlightBooking extends BaseClass {

	public HomePage homePage = null;

	@Test
	public void flightBooking() throws InterruptedException {
		extentTest=extentReport.createTest("Flight Booking");
		homePage = new HomePage(driver);
		homePage.searchFlights("New Delhi, India", "Mumbai, India", "August 2023", "25");
		extentTest.log(Status.PASS, "Flight Searched Successfully");
		homePage.cheapestFlightRates();
		extentTest.log(Status.PASS, "Found Cheapest Rates");
		extentReport.flush();
	}
}
