package tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseClass;
import page.MainPage;
import page.searchResturant;

public class SmokeTest extends BaseClass{	
	@Test
	public void firstMthod() throws InterruptedException
	{
		MainPage mainPage = new MainPage(driver);
		searchResturant searchResturant = new searchResturant(driver);
		mainPage.goToEnterLocationPage(driver);
		searchResturant.searchResturantPage(driver);
		searchResturant.addItemsPage(driver);
		searchResturant.removeItems(driver);
		searchResturant.checkPricing(driver);
	}

}
