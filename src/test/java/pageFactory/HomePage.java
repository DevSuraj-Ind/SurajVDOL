package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.Utils;

public class HomePage extends Utils {

	@FindBy(xpath = "//span[text()='Device Management']")
	WebElement btnAssetMgmtTab;

	@FindBy(xpath = "//span[text()='Device Management']")
	WebElement txtAssetMgmtHeaderTitle;

	@FindBy(xpath = "//a[text()=' Status Overview ']")
	WebElement btnStatusOverviewTab;

	@FindBy(xpath = "//a[text()=' Subscription / Accounts ']")
	WebElement btnSubscriptionAccountTab;

	@FindBy(xpath = "//a[text()=' Device Pool Management ']")
	WebElement btnDevicePoolMgmtTab;

	@FindBy(xpath = "//a[text()=' Reports ']")
	WebElement btnReportsTab;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void verifyAssetMgmtTabIsVisible() {
		Assert.assertTrue(verifyElementIsDisplayed(btnAssetMgmtTab, 25), "Asset Mgmt. tab is not Displayed");

	}

	public void clickAssetMgmt() {
		Assert.assertTrue(verifyElementIsDisplayed(btnAssetMgmtTab, 25), "Asset Mgmt. tab is not Displayed");

		btnAssetMgmtTab.click();
	}

	public void verifyAssetMgmtScreenIsDisplayed() {
		waitUntillElementIsVisible(txtAssetMgmtHeaderTitle, 15);
		Assert.assertEquals(txtAssetMgmtHeaderTitle.getText(), "DEVICE MANAGEMENT");

	}

	public void verifyStatusOverviewTabIsVisible() {
		Assert.assertTrue(verifyElementIsDisplayed(btnStatusOverviewTab, 10), "Status Overview Tab is not Displayed");

	}

	public void verifySubscriptionAccountTabIsVisible() {

		Assert.assertTrue(verifyElementIsDisplayed(btnSubscriptionAccountTab, 10),
				"Subscription Account Tab is not Displayed");

	}

	public void verifyDevicePoolMgmtTabIsVisible() {
		Assert.assertTrue(verifyElementIsDisplayed(btnDevicePoolMgmtTab, 10),
				"Device Pool management tab is not visible");

	}
	
	public DevicePoolManagementPage clickDevicePoolMgmtTab() {
		Assert.assertTrue(verifyElementIsDisplayed(btnDevicePoolMgmtTab, 10), "Device Pool Mgmt. Tab is not Displayed");
		btnDevicePoolMgmtTab.click();
		return new DevicePoolManagementPage(driver);
	}

	public void verifyReportsTabIsVisible() {
		Assert.assertTrue(verifyElementIsDisplayed(btnReportsTab, 10), "Reports tab is not Displayed");

	}
	
	public DevicePoolManagementPage clickSubscrptionMgmt() {
		Assert.assertTrue(verifyElementIsDisplayed(btnSubscriptionAccountTab, 10), "Subscription/Accounts Tab is not Displayed");
		btnSubscriptionAccountTab.click();
		return new DevicePoolManagementPage(driver);
	}

}
