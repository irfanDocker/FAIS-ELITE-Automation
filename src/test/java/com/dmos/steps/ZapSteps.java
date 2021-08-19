package com.dmos.steps;

import static org.junit.Assert.assertFalse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import components.RestAPIComponents;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.thucydides.core.steps.ScenarioSteps;

public class ZapSteps extends ScenarioSteps {

	@Given("^Zap is launched$")
	public void Zap_is_launched() throws Throwable {

		Runtime.getRuntime().exec(
				"cmd /c start \"\" /d\"C:\\Program Files\\OWASP\\Zed Attack Proxy\\\" \"zap.bat\" -daemon -port 8090 -config api.key=1234");
		Thread.sleep(20000);
	}

	@Given("^Extract ZAP Alerts$")
	public void Extract_ZAP_Alerts() throws Throwable {

		RestAssured.baseURI = "http://localhost:8090";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET,
				"/HTML/core/view/alertsSummary/?zapapiformat=HTML&apikey=1234&formMethod=GET&baseurl=");
		String responseBody = response.getBody().asString();

		// int responseCode = response.getStatusCode();
		Document doc = Jsoup.parseBodyFragment(responseBody);
		int HighAlerts = Integer.parseInt(doc.getElementsContainingOwnText("High").next().text());
		String MediumAlerts = doc.getElementsContainingOwnText("Medium").next().text();
		String LowAlerts = doc.getElementsContainingOwnText("Low").next().text();



		
		
		assertFalse("High Alerts found within digiRoomz Security Test", HighAlerts > 0);

	}

	@Then("^Exit ZAP$")
	public void Exit_ZAP() throws Throwable {
		RestAPIComponents.restGETRequest("http://localhost:8090",
				"/JSON/core/action/shutdown/?zapapiformat=JSON&apikey=1234&formMethod=GET");
	}
	
}
