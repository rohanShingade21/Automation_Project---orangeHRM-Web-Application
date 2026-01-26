package com.crm.FileUtilityClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromProperty {
public static String readProperty(String key) throws IOException {
	Properties prop=new Properties();
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Configuration.properties");
	prop.load(fis);
	return prop.getProperty(key);
}
}
