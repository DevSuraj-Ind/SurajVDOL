package pageFactory;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.Utils;

public class DevicePoolManagementPage extends Utils {

	@FindBy(css = ".mat-tooltip-trigger.mat-menu-trigger.transparent.icon.status.ng-star-inserted")
	WebElement btnAddNewDeviceToPool;

	@FindBy(xpath = "//span[text()='add devices to Device Pool']")
	WebElement optionAddDeviceToDevicePool;

	@FindBy(xpath = "//span[text()='Bulk upload of device (CSV file) to Device Pool']")
	WebElement optionAddBulkDeviceToDevicePool;

	@FindBy(xpath = "//*[@class='add-device-to-pool__container']")
	WebElement dialogBoxAddDevicesToDevicePoolManually;

	@FindBy(xpath = "//mat-dialog-container//h2[@id='mat-dialog-title-0']")
	WebElement titleAddDevicesToDevicePoolManually;

	@FindBy(xpath = "//mat-label/span[text()='Device Type']")
	WebElement matLabelBtnDevicetype;

	@FindBy(xpath = "(//div[@class='first-box']/div/mat-form-field/div/div/div/mat-select)[1]")
	WebElement btnDevicetype;

	@FindBy(xpath = "//span[@class='mat-option-text']")
	List<WebElement> optionsDeviceTypeInAddDevicesToDevicePoolBox;

	@FindBy(xpath = "//span/span[text()='DLD4G']")
	WebElement defaultDeviceType;

	@FindBy(xpath = "//span[@class='mat-option-text']")
	List<WebElement> optionsPublicKeyTypeInAddDevicesToDevicePoolBox;

	@FindBy(xpath = "(//div[@class='first-box']/div/mat-form-field/div/div/div/mat-select)[2]")
	WebElement btnPublicKeytype;

	@FindBy(xpath = "//mat-label/span[text()='Public Key Type']")
	WebElement matLabelBtnPublicKeytype;

	@FindBy(xpath = "//div[contains(@class,'mat-form-field-infix')]/input[contains(@id,'mat-input') and @maxlength='32']")
	WebElement textBoxDeviceSrNoManualAdditionScreen;

	@FindBy(xpath = "//*[@id='mat-input-4']")
	WebElement txtBoxPublicKey;

	@FindBy(xpath = "//span[text()='SAVE']")
	WebElement btnSaveManualAdditionSceen;

	@FindBy(xpath = "//*[@class='add-device-to-pool__container']/*/*/*/*/*/mat-row/mat-cell[3]/*/span")
	WebElement matCellSRNODeviceTableManualAdditionScreen;

	@FindBy(xpath = "//*[@class='add-device-to-pool__container']/*[@class='mat-dialog-actions footer']/footer/tis-button/button")
	WebElement btnAddDevice;

	@FindBy(xpath = "//input[@placeholder='Search Device s/n']")
	WebElement txtBoxSearchDeviceSrNo;

	@FindBy(xpath = "//button[@aria-label='search']")
	WebElement btnSearchDeviceSrNo;

	@FindBy(xpath = "(//vdo-cell)[2]/span")
	WebElement searchResultDeviceSrNo;
	
	@FindBy(xpath="//*[text()=' Clear all Filters ']")
	WebElement btnClearAllFilters;
	////*[@id='mat-badge-content-1']

	public DevicePoolManagementPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickOnAddDeviceToDevicePoolBtn() {
		waitUntillElementIsVisible(btnAddNewDeviceToPool, 20);
		btnAddNewDeviceToPool.click();
	}

	public void selectAddDeviceToDevicePoolOption() {

		waitUntillElementIsVisible(optionAddDeviceToDevicePool, 10);
		optionAddDeviceToDevicePool.click();
	}

	public void selectAddBulkDeviceToDevicePoolOption() {

		waitUntillElementIsVisible(optionAddBulkDeviceToDevicePool, 10);
		optionAddBulkDeviceToDevicePool.click();
	}

	public void verifyAddDevicesToDevicePoolManuallyDialogBoxIsDisplayed() {

		Assert.assertTrue(verifyElementIsDisplayed(optionAddBulkDeviceToDevicePool, 10),
				"Add Devices to Device Pool Dialog Box is not Displayed");

	}

	public void clickDeviceType() {
		Assert.assertTrue(verifyElementIsDisplayed(matLabelBtnDevicetype, 10), "Device Type field is not displayed");
		btnDevicetype.click();
	}

	public void clickPublicKeyType() {

		Assert.assertTrue(verifyElementIsDisplayed(matLabelBtnPublicKeytype, 10),
				"Public Key mat label is not displayed");
		Assert.assertTrue(verifyElementIsDisplayed(btnPublicKeytype, 10), "Public Key field is not displayed");
		btnPublicKeytype.click();

	}

	public void selectDeviceType(String deviceType) throws InterruptedException {

		Assert.assertTrue(verifyElementIsDisplayed(defaultDeviceType, 25), "Default Device type is not populated");
		clickDeviceType();
		boolean flag = false;
		Thread.sleep(1000);
		for (WebElement ele : optionsDeviceTypeInAddDevicesToDevicePoolBox) {
			Assert.assertTrue(verifyElementIsDisplayed(ele, 10), "Selected Device not displayed");
			if (ele.getText().equalsIgnoreCase(deviceType)) {
				ele.click();
				flag = true;
				break;
			}
		}

		Assert.assertTrue(flag, "Selected Device Type not found");
	}

	public void selectPublicKeyType(String publicKeytype) {
		clickPublicKeyType();
		boolean flag = false;
		for (WebElement ele : optionsPublicKeyTypeInAddDevicesToDevicePoolBox) {
			Assert.assertTrue(verifyElementIsDisplayed(ele, 10), "Selected Device not displayed");
			if (ele.getText().equalsIgnoreCase(publicKeytype)) {
				ele.click();
				flag = true;
				break;
			}
		}
		Assert.assertTrue(flag, "Selected Device Type not found");
	}

	public void enterDeviceSRNO(String deviceSR) {
		Assert.assertTrue(verifyElementIsDisplayed(textBoxDeviceSrNoManualAdditionScreen, 10),
				"Device SR no. Text box not displayed");
		textBoxDeviceSrNoManualAdditionScreen.clear();
		textBoxDeviceSrNoManualAdditionScreen.sendKeys(deviceSR);
	}

	public void enterPublicKey(String publicKey) {
		txtBoxPublicKey.clear();
		//txtBoxPublicKey.sendKeys(publicKey);
		txtBoxPublicKey.sendKeys("-----BEGIN PUBLIC KEY-----\r\n"
				+ "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA2eSYu23f3i2w4kzqIp5u\r\n"
				+ "PEEDzhsg9r5F2tXUjVhzGdyf75FxXVvOHR8ZUYFHF3wTBWp/6ldyY8oZPhll85j+\r\n"
				+ "glL1FCPTzxRlT3EjuI+br5zyzAdesgJoM97b11T2fr2eLlL6V/Chwn9I0P+F/yyj\r\n"
				+ "cMh6GTAz9bd5JtYngmm6aMv3oz7D/arA5rBryDOCC4VA4wJahWAdBEb8Bmk5/65h\r\n"
				+ "92fCyv5gNOFACH3pKgZRXbliKhEAr4SmFlLHIfyCeh9HookV8RbQ03hOaNVnt7q/\r\n"
				+ "rQlxQD+8eA6KVyYWMJCkgP/BnviU9lEbcSK56VNQRk5GPFVNue1pE4rEP08BlWS4\r\n" + "iQIDAQAB\r\n"
				+ "-----END PUBLIC KEY-----");
	}

	public void clickSave() {

		// Assert.assertTrue(btnSaveManualAdditionSceen.isEnabled(),"Save Button is not
		// enabled");
		btnSaveManualAdditionSceen.click();
	}

	public void verifyAddedDeviceIsDisplayedInDisplayTableOfManualAdditionOfDeviceScreen(String SRNo) {
		String txt = matCellSRNODeviceTableManualAdditionScreen.getText();
		Assert.assertEquals(txt, SRNo);
	}

	public void verifyAddDeviceToDevicePoolManuallyDialogueBoxIsDisplayed() {
		Assert.assertTrue(verifyElementIsDisplayed(dialogBoxAddDevicesToDevicePoolManually, 5));

	}

	public void clickOnAdd() {
		btnAddDevice.click();
	}

	public void searchDeviceSrNo(String SRNo) throws InterruptedException {
		Assert.assertTrue(verifyElementIsDisplayed(txtBoxSearchDeviceSrNo, 10));
		txtBoxSearchDeviceSrNo.clear();
		txtBoxSearchDeviceSrNo.sendKeys(SRNo);
		txtBoxSearchDeviceSrNo.sendKeys(Keys.ENTER);
		// btnSearchDeviceSrNo.click();
		//Assert.assertTrue(verifyElementIsDisplayed(searchResultDeviceSrNo, 10), "Searched device not found");
		Assert.assertTrue(verifyElementIsDisplayed(btnClearAllFilters, 5),"Clear all filters button not found");
		Thread.sleep(2000);
		String actDevice = searchResultDeviceSrNo.getText();
		Assert.assertEquals(actDevice, SRNo, "Searched device not found");

	}

}
