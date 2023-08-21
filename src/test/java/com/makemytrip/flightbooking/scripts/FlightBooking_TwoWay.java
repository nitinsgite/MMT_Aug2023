package com.makemytrip.flightbooking.scripts;

import org.testng.annotations.Test;
import com.makemytrip.base.BaseClass;
import com.makemytrip.pages.HomePage;

public class FlightBooking_TwoWay extends BaseClass {

	public HomePage homePage = null;

	@Test
	public void flightBooking() throws InterruptedException 
	{
		homePage = new HomePage(driver);
		homePage.searchFlightsReturn("Bengaluru, India", "Dubai, United Arab Emirates", "August 2023", "25", "August", "29");
		homePage.cheapestFlightRates();
	}
}
