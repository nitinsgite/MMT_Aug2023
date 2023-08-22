package com.makemytrip.flightbooking.scripts;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.makemytrip.base.BaseClass;
import com.makemytrip.pages.HomePage;

public class FlightBooking_TwoWay extends BaseClass {

	public HomePage homePage = null;

	@Test
	public void flightBooking() throws InterruptedException 
	{
		extentTest=extentReport.createTest("Flight Booking - Two Way");
		homePage = new HomePage(driver);
		homePage.searchFlightsReturn("Bengaluru, India", "Dubai, United Arab Emirates", "August 2023", "25", "August", "29");
		extentTest.log(Status.PASS, "Flight search successfully completed");
		homePage.cheapestFlightRates();
		extentTest.log(Status.PASS, "Found Cheapest Rates");
	}
}
