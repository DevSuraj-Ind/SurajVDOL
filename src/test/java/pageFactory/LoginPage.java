package pageFactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Utils;

public class LoginPage extends Utils {

	//WebDriver ldriver; 
	//HomePage homePage=new HomePage(null);

	@FindBy(css="#mat-input-0")
	private WebElement txtAccount;

	@FindBy(css="#mat-input-1")
	private WebElement txtUsername;

	@FindBy(css="#mat-input-2")
	private WebElement txtPassword;

	@FindBy(css=".mat-raised-button>.mat-button-wrapper")
	private WebElement btnLogin;
	
	@FindBy(xpath="//span[text()='Device Management']")
	WebElement btnAssetMgmtTab;

	public LoginPage(WebDriver driver){
		//this.ldriver=driver;
		PageFactory.initElements(driver,this);
	}

	public void enterAccount(String account) {
		waitUntillElementIsVisible(txtAccount,10);
		txtAccount.clear();
		txtAccount.sendKeys(account);
	}

	public void enterUsername(String username) {
		txtUsername.clear();
		txtUsername.sendKeys(username);
	}

	public void enterPassword(String password) {
		txtPassword.clear();
		txtPassword.sendKeys(password);
	}

	public HomePage clickLogin() {
		
		btnLogin.click();
		return new HomePage(driver);
	}
	
	public HomePage validLogin(String account, String username,String password) {
		
		waitUntillElementIsVisible(txtAccount,10);
		enterAccount(account);
		
		enterUsername(username);
		
		enterPassword(password);
		
		btnLogin.click();
		
		return new HomePage(driver);		
		
	}


}
