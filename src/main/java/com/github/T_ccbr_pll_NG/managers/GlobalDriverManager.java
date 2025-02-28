package com.github.T_ccbr_pll_NG.managers;

import static org.openqa.selenium.chrome.ChromeDriverService.createDefaultService;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import com.github.T_ccbr_pll_NG.enums.EnvType;
import com.github.T_ccbr_pll_NG.enums.NameDriverType;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GlobalDriverManager {
	private WebDriver webDriver;
	private static NameDriverType driverType;
	private static EnvType environmentType;

	public GlobalDriverManager() {
		driverType = FileReaderManager.getInstance().getConfigFileReader().getBrowserName();
		environmentType = FileReaderManager.getInstance().getConfigFileReader().getEnvType();
	}

	private WebDriver createLocalDriver() {
		switch (driverType) {
		case CHROME:
			WebDriverManager.chromedriver().setup();
			initializeAndGetChromeDriver();
			break;
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.addArguments("--headless");
			webDriver = new FirefoxDriver(firefoxOptions);
			break;
		case EDGE:
			WebDriverManager.edgedriver().setup();
			webDriver = new EdgeDriver();
			break;
		case SAFARI:
			webDriver = new SafariDriver();
			break;
		}
		long time = FileReaderManager.getInstance().getConfigFileReader().getTime();

		webDriver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		webDriver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
		webDriver.manage().timeouts().setScriptTimeout(time, TimeUnit.SECONDS);
		return webDriver;
	}

//	mv to other class*

	public WebDriver initializeAndGetChromeDriver() {
		try {
			System.setProperty("webdriver.chrome.driver", (new File(
					System.getProperty("user.dir") + "/src/test/java/com/github/T_ccbr_pll_NG/binaries/chromedriver")
					.getCanonicalPath()));

			System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, (new File(
					System.getProperty("user.dir") + "/src/test/java/com/github/T_ccbr_pll_NG/binaries/chromedriver")
					.getCanonicalPath()));
			ChromeDriverService service = createDefaultService();
			service.start();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			options.addArguments("--test-type");
			options.addArguments("--disable-extensions");
			options.addArguments("--ignore-certificate-errors");
			options.addArguments("--disable-popup-blocking");
			options.addArguments("--allow-running-insecure-content");
			options.addArguments("--disable-translate");
			options.addArguments("--always-authorize-plugins");
			options.addArguments("--disable-infobars");
			options.addArguments("--enable-automation");
			options.setExperimentalOption("useAutomationExtension", false);

			webDriver = new ChromeDriver(service, options);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return webDriver;
	}

	private WebDriver createRemoteDriver() {
		throw new RuntimeException("Remote web driver is not yet implemented");
	}

	private WebDriver createDriver() {
		switch (environmentType) {
		case LOCAL:
			webDriver = createLocalDriver();
			break;
		case REMOTE:
			webDriver = createRemoteDriver();
			break;
		}
		return webDriver;
	}

	public WebDriver getDriver() {
		if (webDriver == null)
			webDriver = createDriver();
		return webDriver;
	}

	public void closeDriver() {
		webDriver.close();
		webDriver.quit();
	}

}
