package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.APIResouces;
import resources.TestDataBuild;
import resources.Utils;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;

public class LibraryAPIs extends Utils {
	RequestSpecification request;
	static Response response;
	static String ID;

	TestDataBuild data = new TestDataBuild();

	@Given("Add Book Payload with {string}{string} {int} {string}")
	public void add_book_payload_with(String name, String isbn, int aisle, String author) throws FileNotFoundException {
		request = given().spec(requestSpecification()).body(data.AddBook_Payload(name, isbn, aisle, author));

	}

	@When("Calls {string} Using {string} Http Request")
	public void calls_using_http_request(String resource, String HttpMethoad) {
		String APIresource=APIResouces.valueOf(resource).getResource();
		
		if(HttpMethoad.equalsIgnoreCase("POST"))
			response = request.when().post(APIresource);
		else if(HttpMethoad.equalsIgnoreCase("GET"))
			response = request.when().get(APIresource);
	}

	@Then("The API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(int statusCode) {
		assertEquals(response.getStatusCode(), statusCode);
		System.out.println(response.asString());
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key, String value) {
		//System.out.println(getJsonValue(response, key));
		//System.out.println("Value:"+value);
		assertEquals(getJsonValue(response, key), value);
	}
	@Given("Get Book Payload")
	public void get_book_payload() throws FileNotFoundException {
		ID=getJsonValue(response, "ID");
	    request= given().spec(requestSpecification()).queryParam("ID", ID);
	}
	@Given("Delete Book Payload")
	public void delete_book_payload() throws FileNotFoundException {
		System.out.println(ID);
	    request=given().spec(requestSpecification()).body(data.getDelete_Payload(ID));
		//request = given().spec(requestSpecification()).body(data.DeleteBook_payload(ID));
	}


}
