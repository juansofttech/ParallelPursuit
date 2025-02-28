package com.github.T_ccbr_pll_NG.utils;

import com.github.T_ccbr_pll_NG.managers.GlobalDriverManager;
import com.github.T_ccbr_pll_NG.managers.PageObjectManager;

public class TestContext {

	private final GlobalDriverManager driverManager;
	private final PageObjectManager pageObjectManager;
	public ScenarioContext scenarioContext;

	public TestContext() {
		driverManager = new GlobalDriverManager();
		pageObjectManager = new PageObjectManager(driverManager.getDriver());
		scenarioContext = new ScenarioContext();
	}

	public GlobalDriverManager getDriverManager() {
		return driverManager;
	}

	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}

	public ScenarioContext getScenarioContext() {
		return scenarioContext;
	}

}
