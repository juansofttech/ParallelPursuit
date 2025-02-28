package com.github.T_ccbr_pll_NG.managers;

import org.openqa.selenium.WebDriver;

import com.github.T_ccbr_pll_NG.pages.AuthenticationCodePage;
import com.github.T_ccbr_pll_NG.pages.LogInPage;

public class PageObjectManager {

	private WebDriver webDriver;

	private AuthenticationCodePage homePage;
	private LogInPage loginPage;

	public PageObjectManager(WebDriver webDriver) {
		super();
		this.webDriver = webDriver;
	}

	// Short Hand If...Else
	public AuthenticationCodePage getHomePage() {
		return (homePage == null) ? homePage = new AuthenticationCodePage(webDriver) : homePage;
	}

	// General If...Else
	public LogInPage getLoginPage() {

		if (loginPage == null) {
			loginPage = new LogInPage(webDriver);
		}
		return loginPage;
	}

}
