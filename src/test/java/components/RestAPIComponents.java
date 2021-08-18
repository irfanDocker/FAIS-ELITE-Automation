package components;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAPIComponents {
	
	// GET request validation with Response body and HTTP code validation

			public static void restGETRequest(String baseURI, String resourceURI, String validationNode) {
				try {

					// Specify the base URL to the RESTful web service

					RestAssured.baseURI = baseURI;
					RequestSpecification httpRequest = RestAssured.given();
					Response response = httpRequest.request(Method.GET, resourceURI);
					String responseBody = response.getBody().asString();

					int responseCode = response.getStatusCode();
					System.out.println(responseCode);

					// Response code validation

					if (responseCode == 200) {
						System.out.println("GET request was successfull for: " + baseURI + resourceURI);
					} else {
						System.err.println("GET request failed for: " + baseURI + resourceURI);
					}

					// Response body validation

					if (responseBody.contains(validationNode)) {
						System.out.println("Validation for " + validationNode + " was successful");
					} else {
						System.err.println("Validation for " + validationNode + " failed");
					}

				} catch (Exception e) {
					System.out.println(e);
				}
			}

			// GET request validation with response HTTP code validation only
			public static int restGETRequest(String baseURI, String resourceURI) {
				int responseCode = 0;
				try {
					// Specify the base URL to the RESTful web service
					RestAssured.baseURI = baseURI;
					RequestSpecification httpRequest = RestAssured.given();
					Response response = httpRequest.request(Method.GET, resourceURI);
					responseCode = response.getStatusCode();
//					System.out.println(responseCode);
					// Response code validation
				} catch (Exception e) {
					System.out.println(e);
				}
				return responseCode;
			}

			// POST request validation with Response body and HTTP code validation

			public static void restPOSTRequest(String baseURI, String resourceURI, String jsonReqBody, String contentType,
					String validationNode) {
				try {

					RestAssured.baseURI = baseURI;

					Response r = RestAssured.given().contentType(contentType).body(jsonReqBody).when().post(resourceURI);

					String body = r.getBody().asString();

					int responseCode = r.getStatusCode();
					System.out.println(responseCode);

					// System.out.println(body);

					if (responseCode == 200) {
						System.out.println("POST request was successfull for: " + baseURI + resourceURI);
					} else {
						System.err.println("POST request failed for: " + baseURI + resourceURI);
					}

					if (body.contains(validationNode)) {
						System.out.println("Validation for " + validationNode + " was successful");
						;
					} else {
						System.err.println("Validation for " + validationNode + " failed");
					}
				} catch (Exception e) {
					System.out.println(e);
				}
			}

			// GET request validation with response HTTP code validation only

			public static void restPOSTRequest(String baseURI, String resourceURI, String jsonReqBody, String contentType) {
				try {

					RestAssured.baseURI = baseURI;

					Response r = RestAssured.given().contentType(contentType).body(jsonReqBody).when().post(resourceURI);

					// String body = r.getBody().asString();

					int responseCode = r.getStatusCode();
					System.out.println(responseCode);
					// System.out.println(body);

				} catch (Exception e) {
					System.out.println(e);
				}
			}
}
