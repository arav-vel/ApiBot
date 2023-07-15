package hooks;

import static constants.Constants.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import base.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;

public class Hooks extends Base {
	
	@Before
	public void setUp() throws FileNotFoundException, IOException{ 
		Properties prop = new Properties();
		prop.load(new FileInputStream(new File(getFileFromResources(PROPERTY_FILE))));
		try {
			if(prop.getProperty(AUTH_TYPE).equalsIgnoreCase(AUTH_TYPE_BASIC)) {
				RestAssured.baseURI = INTERNET_PROTOCOL+prop.getProperty(SERVER)+prop.getProperty(RESOURCE);
				RestAssured.authentication = RestAssured.basic(prop.getProperty(USERNAME), prop.getProperty(PASSWORD));
			}else if(prop.getProperty(AUTH_TYPE).equalsIgnoreCase(AUTH_TYPE_OAUTH2)) {
				RestAssured.authentication = RestAssured.oauth2(prop.getProperty("oauth2"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@After
	public void tearDown(){ 
		response.then().log().status();
	}
}
