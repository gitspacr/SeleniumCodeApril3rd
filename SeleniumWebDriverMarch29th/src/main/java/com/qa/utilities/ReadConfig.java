package com.qa.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties prop;

	public ReadConfig() {

		try {
			File file = new File("./config/config.properties");
			FileInputStream fis = new FileInputStream(file);
			prop = new Properties();

			prop.load(fis);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public String readData() {
		try {
			String getURL = prop.getProperty("url");
			System.out.println(getURL);
			return getURL;

		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;
	}

}
