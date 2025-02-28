package com.github.T_ccbr_pll_NG.stepdefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.github.T_ccbr_pll_NG.managers.FileReaderManager;
import com.github.T_ccbr_pll_NG.utils.TestContext;
import com.google.inject.Inject;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	TestContext testContext;
	WebDriver webDriver;

	@Inject
	public Hooks(TestContext context) {
		testContext = context;
	}

	@Before
	public void setUp() {
		webDriver = testContext.getDriverManager().getDriver();
		webDriver.get(FileReaderManager.getInstance().getConfigFileReader().getUrl());
	}

	@After
	public void tearDown(Scenario scenario) {

		if (scenario.isFailed()) {
			try {
				byte[] screenshot = ((TakesScreenshot) testContext.getDriverManager().getDriver())
						.getScreenshotAs(OutputType.BYTES);
				scenario.attach(screenshot, "image/png", "screenshot");
			} catch (WebDriverException noSupportScreenshot) {
				System.err.println(noSupportScreenshot.getMessage());
			}
		}
		testContext.getDriverManager().closeDriver();
	}

}
