package com.processor.constants;

import java.io.InputStream;
import java.util.Properties;

import org.springframework.context.annotation.Configuration;
import org.yaml.snakeyaml.introspector.PropertyUtils;

@Configuration
public class EmpConstants {

	static Properties prop;

	static {
		prop = new Properties();
		try {
			ClassLoader loader = PropertyUtils.class.getClassLoader();
			InputStream inStream = loader.getResourceAsStream("employee.properties");
			prop.load(inStream);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static String getValue(String key) {
		return prop.getProperty(key);
	}

	public static final String EMP_NO;
	public static final String EMP_NAME;
	public static final String EMP_ADD;
	
	static {
		EMP_NO = prop.getProperty("EMP_NO");
		EMP_NAME = prop.getProperty("EMP_NAME");
		EMP_ADD = prop.getProperty("EMP_ADD");
	}

}
