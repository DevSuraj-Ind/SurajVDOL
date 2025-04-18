package stepDefinitions;

import java.io.IOException;

import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageFactory.LoginPage;
import utilities.FrameworkConfig;
import utilities.Utils;

public class UISteps extends Utils {

	@Given("User launch browser")
	public void user_launch_browser() {
		browserSetup();
		loginPage = new LoginPage(driver);
		logger.info("Browser Opened successfully");
	}

	@When("User opens URL")
	public void user_opens_url() {

		logger.info("Launch URL");
		driver.get(config.uRL());
	}

	@When("User enters Account as {string} Username as {string} and Password as {string}")
	public void user_enters_account_username_and_password(String account, String username, String password)
			throws IOException {
		logger.info("User Logs in");
		homePage = loginPage.validLogin(account, username, password);
		screenshot();
	}

	@Then("Asset mgmt. tab should be visible")
	public void asset_mgmt_tab_should_be_visible() throws IOException {

		homePage.verifyAssetMgmtTabIsVisible();
		screenshot();
		logger.info("Login successful");

		// Assert.assertEquals(homePage.verifyAssetMgmtTabIsVisible(), true);
		// System.out.println(driver.findElement(By.xpath("//p[@class='profile-title']")).getText());

	}

	@When("User Click on asset mgmt. tab")
	public void click_on_asset_mgmt_tab() {
		logger.info("Click on asset mgmt.");
		homePage.clickAssetMgmt();
	}

	@Then("Asset mgmt. screen should be displayed")
	public void asset_mgmt_screen_should_be_displayed() {
		homePage.verifyAssetMgmtScreenIsDisplayed();
		logger.info("Asset Mgmt screen is displayed");
	}

	@Then("StatusOverview tab should be visible")
	public void status_overview_tab_should_be_visible() {
		homePage.verifyStatusOverviewTabIsVisible();
		logger.info("Verified that Status Overview tab is visible");
	}

	@Then("SubscriptionAccount tab should be visible")
	public void subscription_account_tab_should_be_visible() {
		homePage.verifySubscriptionAccountTabIsVisible();
		logger.info("Verified that Subscription tab is visible");
	}

	@Then("Device Pool Management tab should be visible")
	public void device_pool_management_tab_should_be_visible() {
		homePage.verifyDevicePoolMgmtTabIsVisible();
		logger.info("Verified that Device Pool Mgmt tab is visible");
	}

	@Then("Reports tab should be visible")
	public void reports_tab_should_be_visible() {
		homePage.verifyReportsTabIsVisible();
		logger.info("Verified that Reports tab is visible");
	}

	@Then("Close the Browser")
	public void close_the_browser() {
		driver.close();
		driver.quit();
		logger.info("Browser is closed");
	}

	@When("User clicks on Device Pool Management tab")
	public void user_clicks_on_device_pool_management_tab() {
		devicePoolMgmtPage = homePage.clickDevicePoolMgmtTab();
	}

	@When("User clicks on add devices to device pool button")
	public void user_clicks_on_add_devices_to_device_pool_button() {
		devicePoolMgmtPage.clickOnAddDeviceToDevicePoolBtn();
	}

	@When("User selects add device to device pool manually option")
	public void user_selects_add_device_to_device_pool_manually_option() {
		devicePoolMgmtPage.selectAddDeviceToDevicePoolOption();
	}

	@And("User selects deviceType {string}")
	public void user_selects_and(String deviceType) throws InterruptedException {
		devicePoolMgmtPage.selectDeviceType(deviceType);

	}

	@Then("Add Device To Device Pool manually dialog box should be launched")
	public void Add_Device_To_Device_Pool_manually_dialog_box_should_be_launched() {
		devicePoolMgmtPage.verifyAddDeviceToDevicePoolManuallyDialogueBoxIsDisplayed();
	}

	@When("User selects publicKeyType {string}")
	public void user_selects_public_key_type(String publicKeyType) {
		devicePoolMgmtPage.selectPublicKeyType(publicKeyType);
	}

	@When("User enters device SRNo")
	public void user_enters_device_sr_no() {
		deviceSrNo = getRandomDeviceSRno();
		devicePoolMgmtPage.enterDeviceSRNO(deviceSrNo);

	}

	@When("User enters public key {string}")
	public void user_enters_public_key(String publicKey) {
		devicePoolMgmtPage.enterPublicKey(publicKey);

	}

	@When("User clicks on save")
	public void user_clicks_on_save() {
		devicePoolMgmtPage.clickSave();
	}

	@Then("The same device no. should be added in device Panel")
	public void the_same_device_no_should_be_added_in_device_panel() {
		devicePoolMgmtPage.verifyAddedDeviceIsDisplayedInDisplayTableOfManualAdditionOfDeviceScreen(deviceSrNo);
	}

	@When("User clicks on Add")
	public void user_Clicks_on_Add() {
		devicePoolMgmtPage.clickOnAdd();
	}

	@Then("Device should be present in device pool")
	public void device_should_be_present_in_device_pool() throws InterruptedException {
		devicePoolMgmtPage.searchDeviceSrNo(deviceSrNo);
	}

}
