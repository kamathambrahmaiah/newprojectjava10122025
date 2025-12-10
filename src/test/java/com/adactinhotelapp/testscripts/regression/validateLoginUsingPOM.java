package com.adactinhotelapp.testscripts.regression;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.adactinhotelapp.base.BaseTest;
import com.adactinhotelapp.page.LoginPage;
import com.adactinhotelapp.page.SearchHotelPage;

public class validateLoginUsingPOM extends BaseTest{
	@Test
	public void validateLoginTest() {
		
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		
		loginpage.enteruserNameTextbox("brahmaiahkamatham");
		loginpage.enterpasswordTextbox("Brahmam@19");
		loginpage.clickloginButton();
		
		SearchHotelPage  searchhotelpage = PageFactory.initElements(driver, SearchHotelPage.class);
		
		searchhotelpage.validateTitle("Adactin.com - Search Hotel");
		
	}

}
