package resources;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	static RequestSpecification request;

	public RequestSpecification requestSpecification() throws FileNotFoundException {

		if (request == null) {
			PrintStream stream = new PrintStream(new FileOutputStream("logging.txt"));
			request = new RequestSpecBuilder().setBaseUri("http://216.10.245.166")
					.addFilter(RequestLoggingFilter.logRequestTo(stream))
					.addFilter(ResponseLoggingFilter.logResponseTo(stream)).setContentType(ContentType.JSON).build();
			return request;
		}
		return request;
	}

	public String getJsonValue(Response response, String key) {
		JsonPath js = new JsonPath(response.asString());
		//System.out.println(response.asString());
		return js.get(key).toString();
	}

}
