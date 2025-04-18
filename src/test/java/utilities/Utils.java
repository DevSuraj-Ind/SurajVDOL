package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.time.Duration;
import java.util.Properties;

import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import pageFactory.DevicePoolManagementPage;
import pageFactory.HomePage;
import pageFactory.LoginPage;
import pojos.AuthResponse;

public class Utils {

	public static WebDriver driver;
	public static LoginPage loginPage;
	public HomePage homePage;
	public DevicePoolManagementPage devicePoolMgmtPage;
	public static Logger logger;
	public FrameworkConfig config;
	public RequestSpecBuilder spec;
	public static RequestSpecification specBuildAPI;
	public static RequestSpecification specBuildLoginAPI;
	public String deviceSrNo;

	public static PrintStream print() throws FileNotFoundException {
		FileOutputStream fos = new FileOutputStream("logging.txt");
		PrintStream log = new PrintStream(fos);
		return log;
	}

	public String getPropertyData(String key) throws IOException {
		Properties property;
		property = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\uie50231\\eclipse-workspace\\skrAPIAutomation\\src\\test\\resources\\Global.properties");
		property.load(fis);
		return property.getProperty(key);
	}

	public static String getRandomDeviceSRno() {

		long randomNum = 10000000 + (int) (Math.random() * 10000000);
		String staticPart = "1982.031010000128702130F";
		String randomNumString = Integer.toString((int) randomNum);
		String deviceSRNo = staticPart + randomNumString;
		return deviceSRNo;

	}

	public void browserSetup() {
		config = ConfigFactory.create(FrameworkConfig.class);
		logger = LogManager.getLogger("VDOL_QA_Automation");
		logger.info("Starting Browser");
		System.out.println(config.browser());
		String browserType = config.browser();

		if (browserType.equalsIgnoreCase("Chrome")) {

			WebDriverManager.chromedriver().browserVersion("127.0.6533.100").setup();
			driver = new ChromeDriver();

		}

		else if (browserType.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();

	}

	public void waitUntillElementIsVisible(WebElement ele, long timeOutInSeconds) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
		wait.until(ExpectedConditions.visibilityOf(ele));

	}

	public void waitUntillExpectedTitleIsDisplayed(String expectedTitle, long timeOutInSeconds) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
		Boolean flag = wait.until(ExpectedConditions.titleIs(expectedTitle));
		if (flag) {
			System.out.println("Expected Title is displayed");
		} else {
			System.out.println("Expected Title is not displayed");
		}
	}

	public String getTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public boolean verifyElementIsDisplayed(WebElement ele, long maxWaitTime) {
		boolean result = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(maxWaitTime));
			wait.until(ExpectedConditions.visibilityOf(ele));
			result = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public void screenshot() throws IOException {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(srcFile, new File("./screenshots/test.png"));
	}

}
