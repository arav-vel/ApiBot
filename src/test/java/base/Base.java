package base;

import static constants.Constants.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Base {
	public static RequestSpecification request;
	public static Response response;
	public static File file;
	public static String accessToken;
	public static 	Properties prop;
	
	
	/*
	 * Gets the path of file the given in the resource folder
	 *  @param  fileName
	 *  		Name of the file present in the resource folder.
	 *  @return Path of the file
	 *  
	 */
	public static String getFileFromResources(String fileName) {
	    String filePath = "";
	    ClassLoader classLoader = Base.class.getClassLoader();
	    try {
	      filePath = Paths.get(classLoader.getResource(fileName).toURI()).toString();
	    } catch (Exception e) {
	      System.err.println(e.getLocalizedMessage());
	    }
	    return filePath;
	  }
	
	/*
	 * Gets the property file
	 *  @return properties present in the property file
	 *  
	 */
	public static Properties loadProperties() {
		prop = new Properties();
		try {
			prop.load(new FileInputStream(new File(getFileFromResources(PROPERTY_FILE))));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	
	/*
	 * This method is a post service call to generate the OAuth token for the ServiceNow.
	 *  @return This returns the access token which is the Oauth2.0 token. 
	 *  
	 */
	public static String getOAuthAccessToken() {
		return RestAssured
							.given()
							.formParam(GRANT_TYPE, OAUTH_GRANT_TYPE) 
							.formParam(CLIENT_ID, OAUTH_CLIENT_ID) 
							.formParam(CLIENT_SECRET,OAUTH_CLIENT_SECRET) 
							.formParam(USERNAME,OAUTH_USERNAME)
							.formParam(PASSWORD,OAUTH_PASSWORD)
							.post(INTERNET_PROTOCOL+SERVER+OAUTH_PATH)
							.then()
							.statusCode(200)
				            .extract().response().jsonPath().getString(ACCESS_TOKEN);
		
	}
}
