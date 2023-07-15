package base;

import java.io.File;
import java.nio.file.Paths;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Base {
	public static RequestSpecification request;
	public static Response response;
	public static File file;
	
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
}
