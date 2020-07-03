
package com.tieto.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropUtills {

	public static String getValueFromKey(String fileDeatil,String key) throws IOException {
		FileInputStream file = new FileInputStream("fileDeatil");
		Properties prop = new Properties();
		prop.load(file);
		
		return prop.getProperty(key);
		}

}
