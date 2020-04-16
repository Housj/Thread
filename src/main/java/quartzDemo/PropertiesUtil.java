package quartzDemo;

import java.io.IOException;
import java.util.Properties;

/**
 * properties工具类
 * 
 * @author Lee
 * 
 */
public class PropertiesUtil {

	public static Properties properties = new Properties();
	public static String hdbFile = "hdb.properties";

	static {
		try {
			properties.load(PropertiesUtil.class.getClassLoader().getResourceAsStream(hdbFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String get(String key) {
		return properties.getProperty(key, "");
	}
}
