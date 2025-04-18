package stepDefinitions;

import java.io.FileNotFoundException;
import java.time.Duration;

import org.aeonbits.owner.ConfigFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import pageFactory.LoginPage;
import utilities.FrameworkConfig;
import utilities.Utils;

public class Hooks extends Utils {

	@Before(value = "@API")
	public void api() throws FileNotFoundException {
		config = ConfigFactory.create(FrameworkConfig.class);
		specBuildLoginAPI = RestAssured.given().log().all().baseUri(config.APILoginURL())
				.contentType("application/json\r\n").filter(RequestLoggingFilter.logRequestTo(Utils.print()))
				.filter(ResponseLoggingFilter.logResponseTo(Utils.print()));

		specBuildAPI = RestAssured.given().log().all().baseUri(config.APIBaseURL()).contentType("application/json\r\n")
				.filter(RequestLoggingFilter.logRequestTo(Utils.print()))
				.filter(ResponseLoggingFilter.logResponseTo(Utils.print()));
	}

	@Before(value = "@UI")
	public void uI() {
		browserSetup();
		loginPage = new LoginPage(driver);
		logger.info("Browser Opened successfully");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		logger.info("Launch URL");
		driver.get(config.uRL());
	}

	@After(value = "@UI")
	public void uIAfter() {
		driver.close();
		driver.quit();
		logger.info("Browser is closed");
	}

}
