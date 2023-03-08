package org.fashionatte.de.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	Properties properties;
	public ReadConfig() {
		File src= new File("./configurations/config.properties");
	
	try {
		FileInputStream fis = new FileInputStream(src);
		properties =new Properties();
		properties.load(fis);
	} catch (FileNotFoundException e) {
		System.out.println(e.getMessage());
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	}


	public String getHomePageTitle() {return properties.getProperty("homePageTitle");}
	public String getApplicationURL() {return properties.getProperty("webSiteURL");}
	public String getProductListingPageTitle1() {return properties.getProperty("productListPageTitle1");}
	public String getProductListingPageTitle2() {return properties.getProperty("productListPageTitle2");}
	public String getLoginPageTitle() {return properties.getProperty("loginPageTitle");}


}
