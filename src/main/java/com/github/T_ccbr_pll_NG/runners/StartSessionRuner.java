package com.github.T_ccbr_pll_NG.runners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/com/github/T_ccbr_pll_NG/features/start_Session.feature", glue = "com.github.T_ccbr_pll_NG.stepdefinitions", plugin = {
		"pretty", "summary", "html:target/cucumber-reports.html", "json:target/json_result.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, monochrome = true, dryRun = false)
public class StartSessionRuner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}