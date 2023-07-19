package hooks;

import base.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import static constants.Constants.*;

public class Hooks extends Base {
	
	/*
	 * This cucumber @Before method sets the baseURI and Authentication.
	 * It is called before every scenario starts.
	 */
	@Before
	public void beforeScenario(){ 
		loadProperties();
		RestAssured.baseURI = INTERNET_PROTOCOL+SERVER+RESOURCE;
		try {
			if(AUTH_TYPE.equalsIgnoreCase(AUTH_TYPE_BASIC)) {				
				RestAssured.authentication = RestAssured.basic(BASIC_USERNAME, BASIC_PASSWORD);
			}else if((AUTH_TYPE).equalsIgnoreCase(AUTH_TYPE_OAUTH2)) {
				RestAssured.authentication = RestAssured.oauth2(getOAuthAccessToken());
			}else if((AUTH_TYPE).equalsIgnoreCase(AUTH_TYPE_JWT)) {
				RestAssured.authentication = RestAssured.oauth2("");//TBD
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/*
	 * This cucumber @After method logs the status code of the service call.
	 * It is called after every scenario ends.
	 */
	@After
	public void afterScenario(){ 
		response.then().log().status();
	}
}
