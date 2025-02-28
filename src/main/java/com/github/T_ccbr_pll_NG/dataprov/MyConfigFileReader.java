package com.github.T_ccbr_pll_NG.dataprov;

import static com.github.T_ccbr_pll_NG.enums.EnvType.LOCAL;
import static com.github.T_ccbr_pll_NG.enums.EnvType.REMOTE;
import static com.github.T_ccbr_pll_NG.enums.NameDriverType.CHROME;
import static com.github.T_ccbr_pll_NG.enums.NameDriverType.FIREFOX;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.github.T_ccbr_pll_NG.enums.EnvType;
import com.github.T_ccbr_pll_NG.enums.NameDriverType;
import com.github.T_ccbr_pll_NG.utils.utilssecurity.Mycypher;

public class MyConfigFileReader {
	private final Properties properties;
	Mycypher cypher;

	public MyConfigFileReader() {
		BufferedReader bufferedReader;
		FileReader fileReader;
		String propertyFilePath = "config/configuration.properties";

		try {
			fileReader = new FileReader(propertyFilePath);
			bufferedReader = new BufferedReader(fileReader);
			properties = new Properties();
			cypher = new Mycypher();

			try {
				properties.load(bufferedReader);
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("configuration.properties not found at " + propertyFilePath);
		}
	}

	public String getUrl() {
		String url = properties.getProperty("site");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the config file.");
	}

	public long getTime() {
		String timeout = properties.getProperty("timeout");
		if (timeout != null) {
			return Long.parseLong(timeout);
		} else {
			throw new RuntimeException("timeout not specified in the config file.");
		}
	}

	public NameDriverType getBrowserName() {
		String browserName = properties.getProperty("browser");

		switch (browserName) {
		case "chrome":
			return CHROME;
		case "firefox":
			return FIREFOX;

		default:
			throw new RuntimeException("Browser name key value in configuration file is not matched: " + browserName);
		}
	}

	public EnvType getEnvType() {
		String environmentName = properties.getProperty("environment");

		switch (environmentName) {
		case "local":
			return LOCAL;
		case "remote":
			return REMOTE;
		default:
			throw new RuntimeException(
					"Environment type key value in configuration file is not matched: " + environmentName);
		}
	}

}
