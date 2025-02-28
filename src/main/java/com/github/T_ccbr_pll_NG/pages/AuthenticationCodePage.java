package com.github.T_ccbr_pll_NG.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthenticationCodePage extends BasePage {

	public AuthenticationCodePage(WebDriver miDriver) {
		super(miDriver);
	}

	@FindBy(css = "[class='btn-primary btn btn-block']")
	private WebElement verifyButton;

	public boolean isTheButtonVisible() {
		return verifyButton.isDisplayed();
	}

}
