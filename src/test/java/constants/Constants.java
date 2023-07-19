package constants;

import base.Base;
import io.restassured.http.ContentType;

public class Constants extends Base {
	
	//path Constants
	public static final String BODY_TEST_DATA_PATH = "bodyTestData/";
	public static final String PROPERTY_FILE = "config.properties";
	public static final String INCIDENT_TABLE_PATH="/incident";
	
	//General Properties	
	public static final String SERVER = prop.getProperty("server");
	public static final String RESOURCE = prop.getProperty("resource");
	public static final String AUTH_TYPE = prop.getProperty("authType");
	public static final String INTERNET_PROTOCOL = prop.getProperty("internetProtocal");
	
	//Basic Auth Properties
	public static final String BASIC_USERNAME = prop.getProperty("username");
	public static final String BASIC_PASSWORD = prop.getProperty("password");
	
	//OAuth Properties
	public static final String OAUTH_USERNAME = prop.getProperty("oauthUsername");
	public static final String OAUTH_PASSWORD = prop.getProperty("oauthPassword");
	public static final String OAUTH_GRANT_TYPE = prop.getProperty("grant_type");
	public static final String OAUTH_CLIENT_ID= prop.getProperty("client_id");
	public static final String OAUTH_CLIENT_SECRET= prop.getProperty("client_secret");
	public static final String OAUTH_PATH=prop.getProperty("oauthPath");
	
	//Test Constants
	public static final String AUTH_TYPE_BASIC = "basic";
	public static final String AUTH_TYPE_OAUTH2 = "oauth2";
	public static final String AUTH_TYPE_JWT = "jwt";
	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";
	public static final String GRANT_TYPE = "grant_type";
	public static final String CLIENT_ID= "client_id";
	public static final String CLIENT_SECRET= "client_secret";
	public static final String ACCESS_TOKEN="access_token";
	public static final ContentType CONTENT_TYPE_JSON = ContentType.JSON;

	
	
	
}
