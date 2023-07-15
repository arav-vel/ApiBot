package steps;

import static constants.Constants.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.InputStream;

import base.Base;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateIncident extends Base{
	
	
	@Given("create body using {string} data file")
	public void createBodyUsingDataFile(String fileName) {
		request = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body(new File(getFileFromResources(BODY_TEST_DATA_PATH+fileName)));
	}
	@When("Hit the request with POST method.")
	public void hitTheRequestWithPOSTMethod() {
		response = request.post("/incident");
	}
	@Then("The status code should be {int}")
	public void theStatusCodeShouldBe(int actualStatusCode) {
		assertEquals(response.getStatusCode(), actualStatusCode);
	}
	@Then("and the response time should be less than a seconds.")
	public void andTheResponseTimeShouldBeLessThanASeconds() {
		assertTrue(response.getTime()>2000);
	}

}
