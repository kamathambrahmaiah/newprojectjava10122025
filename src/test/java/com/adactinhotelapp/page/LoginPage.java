package com.adactinhotelapp.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	// WebElements and Methods on WebElement

	@FindBy(xpath = "//input[@name='username']")
	WebElement userNameTextbox;

	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordTextbox;

	@FindBy(xpath = "//input[@name='login']")
	WebElement loginButton;

	public void enteruserNameTextbox(String text) {
		userNameTextbox.sendKeys(text);
	}

	public void enterpasswordTextbox(String text) {
		passwordTextbox.sendKeys(text);
	}

	public void clickloginButton() {
		loginButton.click();;
	}
}
