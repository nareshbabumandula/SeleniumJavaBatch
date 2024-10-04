package com.util;

import java.util.Properties;
import java.io.*;

public class PropertyUtil {

	public static String getProperty(String key) throws IOException {
		FileReader fr = new FileReader("./Config.properties");
		Properties prop = new Properties();
		prop.load(fr);
		return prop.getProperty(key);
	}


}
