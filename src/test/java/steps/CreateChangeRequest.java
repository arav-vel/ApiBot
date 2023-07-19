package steps;

import base.Base;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import static constants.Constants.*;

public class CreateChangeRequest extends Base{
	
	@Given("create body by passing data {string} as String")
	public void createBodyByPassingDataAsString(String bodyData) {
		request = RestAssured
				.given()
				.contentType(CONTENT_TYPE_JSON)
				.body(bodyData);
	}

}
