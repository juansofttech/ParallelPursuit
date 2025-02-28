package com.github.T_ccbr_pll_NG.managers;

import com.github.T_ccbr_pll_NG.dataprov.MyConfigFileReader;

public class FileReaderManager {

	private static final FileReaderManager fileReaderManager = new FileReaderManager();
	private static MyConfigFileReader configFileReader;

	private FileReaderManager() {
	}

	public static FileReaderManager getInstance() {
		return fileReaderManager;
	}

	public MyConfigFileReader getConfigFileReader() {
		return (configFileReader == null) ? new MyConfigFileReader() : configFileReader;
	}

}
