package lightstorm.polarin.objectRepositories;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import lightstorm.polarin.testBase.TestBase;
import lightstorm.polarin.utility.CommonUtilities;

public class LoginPage extends TestBase {

	/*All Object Repository*/
	
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="(//button[contains(text(),'Sign In')])[1]")
	WebElement SinInBtn;
	
	@FindBy(xpath="//div[@class='MuiAlert-message css-1pxa9xg-MuiAlert-message']")
	WebElement error_message;
	
	@FindBy(xpath="//p[@class='MuiTypography-root MuiTypography-body1 css-jc35um']")
	WebElement usernameErrorMsg;
	
	@FindBy(xpath="//p[@class='MuiTypography-root MuiTypography-body1 css-u5q6fm-MuiTypography-root']")
	WebElement passwordErrorMessage;
	
	@FindBy(xpath = "(//*[@class='MuiTypography-root MuiTypography-body1 css-jc35um'])[1]")
	WebElement blankEmailIderror;
	
	@FindBy(xpath = "//*[contains(text(),'Invalid password')]")
	WebElement blankPasswordError;
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle() {
		
		return driver.getTitle();
	}
	public void inValid_Credentials_login(String invaliduser, String invalidpassw) throws InterruptedException {
		CommonUtilities.sendkeys(username, invaliduser);
		CommonUtilities.sendkeys(password, invalidpassw);
		
	}
	public DashBoardPage valid_Credentials_login(String validuser,String validpass ) throws InterruptedException {
		username.clear();
		username.sendKeys(validuser);
		password.clear();
		password.sendKeys(validpass);
		SinInBtn.click();
		return new DashBoardPage();
	}
	
	public String errormessage() {
		return error_message.getText();
	}
	
	public String userNameErrorMsg() {
		return usernameErrorMsg.getText();
	}
	
	public String userPasswordErrorMsg() {
		return passwordErrorMessage.getText();
	}
	
	
	public String blankEmailErrorMsg() {
		return blankEmailIderror.getText();
	}
	public String blankPasswordErrorMsg() {
		return blankPasswordError.getText();
	} 
	public void clickOnSignInButton() {
		SinInBtn.click();
		
	}
	
	public void blankCreadencialEnter() {
		username.sendKeys("");
		password.sendKeys("");
		
	}
	
	public void refreshBrowser() {
		driver.navigate().refresh();
	}
	
}
