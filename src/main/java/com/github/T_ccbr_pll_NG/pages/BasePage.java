package com.github.T_ccbr_pll_NG.pages;

import static org.openqa.selenium.support.PageFactory.initElements;

import org.openqa.selenium.WebDriver;

public class BasePage {

	protected WebDriver miDriver;

	public BasePage(WebDriver miDriver) {
		this.miDriver = miDriver;
		initElements(miDriver, this);
	}

}
