package com.makemytrip.selenium.utils;

public class DynamicXPathCreator 
{

	public String xpathForDateOnDatePicker = "//div[text()='<MONTH_YEAR>']/parent::div/following-sibling::div//p[text()='<DATE>']";
	public String getXpathForDateOnDatePicker(String monthYear, String date) {
		return xpathForDateOnDatePicker.replaceAll("<MONTH_YEAR>", monthYear).replaceAll("<DATE>", date);
	}
	
	public String xpathForReturnDateOnDatePicker = "//div[text()='<RETMONTH_YEAR>']/parent::div/following-sibling::div//p[text()='<RET_DATE>']";
	public String getXpathForReturnDateOnDatePicker(String returnmonthYear, String returndate) {
		return xpathForReturnDateOnDatePicker.replaceAll("<RETMONTH_YEAR>", returnmonthYear).replaceAll("<RET_DATE>", returndate);
	}
	

	public String xpathForSuggestionsDropdown = "//p[text()='POPULAR CITIES']/parent::div/following-sibling::ul[@role='listbox']//li//p[text()='<CITY_NAME>']";
	////ul[@role='listbox']//li//p[text()='<CITY_NAME>']
	//p[text()='POPULAR CITIES']/parent::div[@class='react-autosuggest__section-title']/following-sibling::ul[@role='listbox']//child::li/child::div/child::div/child::p[text()='<CITY_NAME>']
	//ul[@role='listbox']//li//p[text()='<CITY_NAME>
	//p[text()='POPULAR CITIES']/parent::div[@class='react-autosuggest__section-title']/following-sibling::ul[@role='listbox']/child::li[@id='react-autowhatever-1-section-1-item-9']//child::div//p[text()='<CITY_NAME>']
	public String getXpathForSuggestionsDropdown(String cityName) {
		return xpathForSuggestionsDropdown.replaceAll("<CITY_NAME>", cityName);
	}

}
