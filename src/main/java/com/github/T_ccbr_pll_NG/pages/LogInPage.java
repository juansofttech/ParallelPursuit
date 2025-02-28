package com.github.T_ccbr_pll_NG.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends BasePage {

	public LogInPage(WebDriver miDriver) {
		super(miDriver);
	}

	@FindBy(id = "login_field")
	private WebElement usernameInput;
	@FindBy(name = "password")
	private WebElement psswdInput;
	@FindBy(name = "commit")
	private WebElement signInButton;

	public void setCredentials(String username, String psswd) {
		setUserName(username);
		setPassword(psswd);
		clickOnButton();
	}

	public void setUserName(String username) {
		usernameInput.sendKeys(username);
	}

	public void clickOnButton() {
		signInButton.click();
	}

	public void setPassword(String psswd) {
		psswdInput.sendKeys(psswd);

	}

}
