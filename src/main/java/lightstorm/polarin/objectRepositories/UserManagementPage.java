package lightstorm.polarin.objectRepositories;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import lightstorm.polarin.testBase.TestBase;

public class UserManagementPage extends TestBase {

	/*********************************************************
	 * Add User
	 *****************************************************/
	@FindBy(xpath = "(//*[contains(text(),'Add User')])[1]")
	private WebElement addUserBtn;
	@FindBy(name = "email")
	private WebElement enterEmailId;
	@FindBy(xpath = "//li[@class='MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters css-1hdmjwj']")
	private List<WebElement> alluserRoles;
	@FindBy(xpath = "//button[contains(text(),'Send Invitation')]")
	private WebElement sendInvitationBtn;
	@FindBy(xpath = "//*[contains(text(),'Discard')]")
	private WebElement discardAddUserTab;
	@FindBy(xpath = "//div[contains(text(),'This account already has a user with the email address provided.')]")
	private WebElement errrorMessage;

	/**************************************************************
	 * User Management
	 *****************************************************************/
	@FindBy(xpath = "//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedStart css-1ixds2g']")
	private WebElement userSearchTextBox;
	@FindBy(xpath = "//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-formControl css-1cs2n1e']")
	private WebElement userSelectRole;
	@FindBy(xpath = "(//div[@class='MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input css-13fl7lf'])[2]")
	private WebElement userSearchBySorting;
	@FindBy(xpath = "//button[contains(text(),'Clear')]")
	private WebElement userClearBtn;
	@FindBy(xpath = "(//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-formControl css-q77mzh'])[1]")
	private WebElement searchByRole;
	@FindBy(xpath = "(//button[contains(text(),'Done')])[6]")
	private WebElement userCreatedDoneBtn;

	/**************************************************************************/
	public UserManagementPage() {
		PageFactory.initElements(driver, this);
	}

	public void clickOnAddUserBtn() {
		addUserBtn.click();
	}

	public void enterInvalidEmailId(String emialid) {
		enterEmailId.sendKeys(emialid);
	}

	public void enterValidEmailId(String emailIdval) {
		enterEmailId.sendKeys(emailIdval);
	}

	public void selectRoleForUser(String role1) {
		System.out.println("something");
		userSelectRole.click();
		System.out.println("done");
		for (WebElement allRole : alluserRoles) {

			String rolerole = allRole.getText();

			if (rolerole.equals(role1)) {
				allRole.click();
				break;
			}
			System.out.println(rolerole);
		}

	}

	public void clickOnSendInvitation() {
		sendInvitationBtn.click();
	}

	public void clickOnDiscartBtn() {
		discardAddUserTab.click();
	}

	public String errorMessage() {
		return errrorMessage.getText();
	}

	public void useraddedsuccessfully() {
		userCreatedDoneBtn.click();
	}

	/***************************************************
	 * UserManagement Search
	 *************************************************/
	public void searchUserByEmailId(String searchemailid) {
		userSearchTextBox.sendKeys(searchemailid);
	}

	public void searchUserByRole(String roleuser) {
		searchByRole.click();
		for (WebElement allRole : alluserRoles) {

			String rolerole = allRole.getText();

			if (rolerole.equals(roleuser)) {
				allRole.click();
				break;
			}
			System.out.println(rolerole);
		}
	}

	public void searchUserBySorting(String sorting) {
		userSearchBySorting.sendKeys(sorting);
		for (WebElement allRole : alluserRoles) {

			String rolerole = allRole.getText();

			if (rolerole.equals(sorting)) {
				allRole.click();
				break;
			}
			System.out.println(rolerole);
		}

	}

	public void clearSearchArea() {
		userClearBtn.click();
	}

}
