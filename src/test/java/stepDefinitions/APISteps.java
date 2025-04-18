package stepDefinitions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.aeonbits.owner.ConfigFactory;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pageFactory.LoginPage;
import pojos.AddPayload;
import pojos.AddResponse;
import pojos.AuthResponse;
import utilities.FrameworkConfig;
import utilities.TestDataBuild;
import utilities.Utils;

public class APISteps extends Utils {

	RequestSpecification request;
	Response response;
	ObjectMapper objectMapper = new ObjectMapper();
	AddResponse[] addResponseArray;
	TestDataBuild assignData = new TestDataBuild();
	AuthResponse authResponseObj = new AuthResponse();
	AddResponse addResponseObj = new AddResponse();

	@Given("the login api and payload having account as {string} username as {string} and password as {string}")
	public void setup(String account, String username, String password) throws IOException {
		assignData.authPayloadbuild(account, username, password);
		request = specBuildLoginAPI.basePath("login").body(assignData.authPayload);

	}

	@When("User sends Post https Request to login API")

	public void httpRequest() {
		response = request.post();
		System.out.println("Response Time in Millisecond: " + response.time());
		System.out.println("Resonse -" + response.asString());

	}

	@Then("Verify status code is 200 and token is generated")
	public void validate() {

		response.then().statusCode(200).log().all().time(Matchers.lessThanOrEqualTo(20000L));
		authResponseObj = response.getBody().as(AuthResponse.class);
		Assert.assertNotNull(authResponseObj.getToken());
		Assert.assertEquals(authResponseObj.getToken().length(), 36);

	}

	@Then("Verify status code is 401")
	public void validateInvalidLogin() {
		response.then().statusCode(401).log().all().time(Matchers.lessThanOrEqualTo(2000L));

	}

	@Given("Add APi and payload having device SR no, devicetype as {int}, publicKey as {string}, publicKeyType as {string}")
	public void add_api_and_payload_having_device_sr_no_devicetype_as_public_key_as_public_key_type_as(int devicetype,
			String publicKey, String publicKeyType) throws FileNotFoundException, IOException 
	{
		assignData.addPayloadDataSetup(devicetype, publicKeyType, publicKey);
		List<AddPayload> deviceList = new ArrayList<AddPayload>();
		deviceList.add(assignData.addPayload);
		request = specBuildAPI.basePath("asset-management-service/v1/device/bulk/add")
				.header("Authorization", authResponseObj.getToken()).body(deviceList);
	}

	@When("User sends Post request to Add API")
	public void user_sends_post_request_to_add_api() {
		response = request.when().post();

	}

	@Then("Status code should be 200 and user validates response body")
	public void status_code_should_be_and_user_validates_response_body() {
		response.then().statusCode(201).log().all().time(Matchers.lessThanOrEqualTo(20000L));
		addResponseArray = response.getBody().as(AddResponse[].class);
		Assert.assertEquals(addResponseArray[0].getDeviceSerialNo(), assignData.addPayload.getDeviceSerialNo());
		Assert.assertEquals(addResponseArray[0].getDeviceType(), assignData.addPayload.getDeviceType());
		Assert.assertEquals(addResponseArray[0].getPublicKey(), assignData.addPayload.getPublicKey());
		Assert.assertEquals(addResponseArray[0].getPublicKeyType(), assignData.addPayload.getPublicKeyType());
	}

}
