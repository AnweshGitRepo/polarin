package lightstorm.polarin.objectRepositories;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import lightstorm.polarin.testBase.TestBase;
import lightstorm.polarin.utility.CommonUtilities;
import lightstorm.polarin.utility.UploadFileClass;

public class UserProfilePage extends TestBase {

	// @FindBy(xpath = "(//div[@class='MuiListItemIcon-root css-qwko1u'])[5]")
	// WebElement userProfile;

	@FindBy(xpath = "(//*[@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-1in44b7'])[1]")
	private WebElement userProfile;

	@FindBy(xpath = "(//*[@class='MuiTypography-root MuiTypography-body1 css-92pcgx'])[1]")
	private WebElement personalDetails;

	// @FindBy( xpath="(//*[@class='MuiTypography-root MuiTypography-body1
	// MuiListItemText-primary css-5wu9kr'])[5]" )
	// WebElement profileTab;

	@FindBy(xpath = "(//p[@class='MuiTypography-root MuiTypography-body1 css-92pcgx'])[3]")
	private WebElement signOutButton;

	@FindBy(xpath = "//*[@id=\"__next\"]/main/div/div/div[1]/div/button[1]")
	private WebElement profileImageUploadBtn;

	@FindBy(xpath = "(//button[contains(text(),'Remove')])[1]")
	private WebElement profileImageRemoveBtn;	
	
	@FindBy(xpath = "(//*[@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-c96n5t'])[1]")
	private WebElement persnolInfoEditButton;
	
	@FindBy(name = "name")
	private WebElement peronalInfoName;
	
	@FindBy(xpath = "//*[@class='MuiTypography-root MuiTypography-body1 css-jc35um']")
	private WebElement blankNameEnterErrorMessage;
	
	@FindBy(name = "phone")
	private WebElement personalInfoPhone;
	
	@FindBy(xpath = "//*[contains(text(),'Update')]")
	private WebElement personalInfoUpdateBtn;
	
	@FindBy(xpath = "(//span[@class='MuiTouchRipple-root css-w0pj6f'])[18]")
	private WebElement personalInfoCancelBtn;
	
	@FindBy(xpath = "//p[contains(text(),'Drag & drop JPEG/PNG Image Here, or browse')]")
	private WebElement dragandDropPageImage;
	
	@FindBy(xpath = "//button[contains(text(),'Save & Next')]")
	private WebElement saveAndNextBtn;
	
	@FindBy(xpath = "(//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedEnd css-1uvydh2'])[1]")
	private WebElement oldPassword;
	
	@FindBy(xpath = "(//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedEnd css-1uvydh2'])[2]")
	private WebElement newPassword;
	
	@FindBy(xpath = "(//*[@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-c96n5t'])[2]")
	private WebElement passwordInfoEditBtn;
	
	@FindBy(xpath = "(//button[contains(text(),'Cancel')])[1]")
	private WebElement passwordEditCancelButton;
	
	@FindBy(xpath = "//button[contains(text(),'Save & Next')]")
	// @FindBy(xpath="(//*[@class='MuiTouchRipple-root css-w0pj6f'])[31]")
	private WebElement imageSaveAndNextButton;
	
	@FindBy(xpath = "//div[@class='MuiAlert-message css-1xsto0d']")
	private WebElement errorMessageIfyouinsertWrongPassword;
	
	@FindBy(xpath = "(//*[@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-vubbuv'])[5]")
	private WebElement editPhotoCancelButton;
	
	@FindBy(xpath = "(//button[contains(text(),'Remove')])[1]")
	private WebElement removeImageButton;

	public UserProfilePage() {
		PageFactory.initElements(driver, this);
	}

	public void clickOnUserProfileTab() {
		userProfile.click();
	}

	// public void clickOnProfileTab() {
	// profileTab.click();
	// }
	public void clickOnLogOutTab() {
		signOutButton.click();
	}

	public void clickOnEditPersonalInformation() {
		persnolInfoEditButton.click();
	}

	public String getErrorMessageAfterEnterBlankName() {
		return blankNameEnterErrorMessage.getText();
	}

	public void enterNameInTextBox(String fullname) {
		CommonUtilities.sendkeys(peronalInfoName, fullname);
	}

	public void enterThePhoneNumber(String phonenumber) {
		CommonUtilities.sendkeys(personalInfoPhone, phonenumber);
	}

	public void clickOnUpdateBtn() {
		WebElement personaInfoUpdate = CommonUtilities.ElementToBeClickable(personalInfoUpdateBtn, 5);
		personaInfoUpdate.click();
	}

	public void clickOnCancelButoon() {
		WebElement personalInfoCancel = CommonUtilities.ElementToBeClickable(personalInfoCancelBtn, 5);
		personalInfoCancel.click();
	}

	public void clickOnUploadImageBtn() {
		WebElement profileImageUpload = CommonUtilities.ElementToBeClickable(profileImageUploadBtn, 5);
		profileImageUpload.click();
	}

	public void clickdragAndDropImageBrowserBtn(String path) throws InterruptedException {
		Thread.sleep(1000);
		dragandDropPageImage.click();
		Thread.sleep(2000);
		UploadFileClass.uploadFileUsingRobotClass(path);
		Thread.sleep(2000);
		imageSaveAndNextButton.click();
		Thread.sleep(1000);
	}

	public void passwordInfoEditBtn() {
		WebElement passwordInfoEdit = CommonUtilities.ElementToBeClickable(passwordInfoEditBtn, 5);
		passwordInfoEdit.click();
	}

	public void enterOldPassword(String oldpass) {
		oldPassword.sendKeys(oldpass);
	}

	public void enterNewPassword(String newPass) {
		newPassword.sendKeys(newPass);
	}

	public void passwordEditCancelButton() {
		WebElement passwordEditCancelBtn = CommonUtilities.ElementToBeClickable(passwordEditCancelButton, 5);
		passwordEditCancelBtn.click();
	}

	public void removeProfileImageButton() {
		WebElement removeImageBtn = CommonUtilities.ElementToBeClickable(removeImageButton, 5);
		removeImageBtn.click();
		System.out.println("Uploaded Profile Picture  Removed");
	}
 
	public String errorMessageAfterWrongPass() {
		return errorMessageIfyouinsertWrongPassword.getText();
	}
}
