package com.github.T_ccbr_pll_NG.stepdefinitions;

import static org.testng.Assert.assertTrue;

import com.github.T_ccbr_pll_NG.pages.AuthenticationCodePage;
import com.github.T_ccbr_pll_NG.pages.LogInPage;
import com.github.T_ccbr_pll_NG.utils.TestContext;
import com.github.T_ccbr_pll_NG.utils.utilssecurity.Mycypher;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DefinitionStartSession {

	TestContext testContext;
	LogInPage loginPage;
	AuthenticationCodePage homePage;
	Mycypher cypher;

	public DefinitionStartSession(TestContext context) throws Exception {
		testContext = context;
		loginPage = testContext.getPageObjectManager().getLoginPage();
		homePage = testContext.getPageObjectManager().getHomePage();
		cypher = new Mycypher();
	}

	@When("User enters username as {string} and password as {string}")
	public void user_enters_username_as_and_password_as(String username, String psswd) {
		loginPage.setCredentials(username, cypher.decrypt(psswd));
	}

	@Then("The user has been successfully authenticated")
	public void userHaBeenSuccessfullyAuthenticated() {
		assertTrue(homePage.isTheButtonVisible());
	}
}
