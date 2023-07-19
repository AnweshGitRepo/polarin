package lightstorm.polarin.objectRepositories;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import lightstorm.polarin.testBase.TestBase;
import lightstorm.polarin.utility.CommonUtilities;
import lightstorm.polarin.utility.UploadFileClass;

public class OrganizationProfilePage extends TestBase {

	/*****************************************************
	 * Organization Details
	 ****************************************************/
	@FindBy(xpath = "(//div[@class='MuiAvatar-root MuiAvatar-circular MuiAvatar-colorDefault css-fc7tsg'])[1]")
	private WebElement editOrganizationDetailsBtn;
	@FindBy(xpath = "//button[contains(text(),'Complete Organization Profile')]")
	private WebElement completeOrganizationProfile;
	@FindBy(name = "org_name")
	private WebElement legalEntityName;
	@FindBy(xpath = "(//input[@class='MuiInputBase-input MuiOutlinedInput-input css-1x5jdmq'])[2]")
	private WebElement mobileNumber;
	@FindBy(xpath = "(//input[@class='MuiInputBase-input MuiOutlinedInput-input css-1x5jdmq'])[3]")
	private WebElement organizationPanNumber;
	@FindBy(xpath = "//div[@class='css-gj02z8']")
	private WebElement clickuploadProofOfIdentity;
	@FindBy(xpath = "(//div[@class='css-gj02z8'])[1]")
	private WebElement clickuploadProofOfIdentityAfterEdit;
	@FindBy(xpath = "//button[starts-with(@class,'MuiButtonBase-root MuiButton-root MuiButton-text')]")
	private WebElement cancellOrgProfButton;
	@FindBy(xpath = "//button[contains(text(),'Save & Next')]")
	private WebElement saveAndNextBtn;
	@FindBy(xpath = "//button[contains(text(),'Got it, Click to preview details')]")
	private WebElement updateOrgDetails;
	/***************************************************
	 * Organization Address
	 ****************************************************/
	@FindBy(xpath = "(//div[@class='MuiAvatar-root MuiAvatar-circular MuiAvatar-colorDefault css-fc7tsg'])[2]")
	private WebElement editOrganizationAddressBtn;
	@FindBy(name = "address")
	private WebElement ragisterAddres;
	@FindBy(xpath = "(//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedEnd css-1uvydh2'])[1]")
	private WebElement selectCountry;
	@FindBy(xpath = "//input[@class='MuiInputBase-input MuiInputBase-inputAdornedStart MuiAutocomplete-input MuiAutocomplete-inputFocused css-mnn31']")
	private WebElement selectSearchCountryOrState;
	@FindBy(xpath = "(//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedEnd css-1uvydh2'])[2]")
	private WebElement selectState;
	@FindBy(name = "cityId")
	private WebElement enterCity;
	@FindBy(name = "postalCode")
	private WebElement enterPostalcode;
	@FindBy(xpath = "(//div[@class='css-gj02z8'])[1]")
	private WebElement ProofOfAddress;
	@FindBy(xpath = "//div[@class='css-gj02z8']")
	private WebElement declarationDocumentUpload;
	@FindBy(xpath = "(//button[contains(text(),'Cancel')])")
	private WebElement orgAddressCancelButton;
	@FindBy(xpath = "//button[contains(text(),'Add Organization Addres')]")
	private WebElement clickOrganizationAddressBtm;
	@FindBy(xpath = "//button[contains(text(),'Update')]")
	private WebElement updateOrganizationDetailsBtn;
	@FindBy(xpath = "//*[@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium MuiAvatar-fallback css-13y7ul3']")
	private WebElement editProofOfIdentities;
	@FindBy(xpath = "(//div[@class='MuiAvatar-root MuiAvatar-circular MuiAvatar-colorDefault css-fc7tsg'])[4]")
	private WebElement removeProofAddUploadedfile;
	/********************************
	 * Authorized Signatory
	 ********************************************************/
	@FindBy(xpath = "(//div[@class='MuiAvatar-root MuiAvatar-circular MuiAvatar-colorDefault css-fc7tsg'])[3]")
	private WebElement authorizedSignatoryEditBtna;
	@FindBy(name = "authName")
	private WebElement authorizedSignatoryName;
	@FindBy(xpath = "(//input[@class='MuiInputBase-input MuiOutlinedInput-input css-1x5jdmq'])[3]")
	private WebElement authorizedSignatoryPhoneNumber;
	@FindBy(name = "authEmail")
	private WebElement authorizedSignatoryEmailId;
	@FindBy(xpath = "//div[@class='MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input css-13fl7lf']")
	private WebElement authorizedSignatoryDocumentType;
	@FindBy(xpath = "(//li[@class='MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters css-1hdmjwj'])[1]")
	private WebElement selectPanDocumetType;
	@FindBy(xpath = "(//li[@class='MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters css-1hdmjwj'])[2]")
	private WebElement selectAadharDocumetType;
	@FindBy(name = "authIdentityDocumentNumber")
	private WebElement authorizedSignatoryIdentityDocumentNumber;
	@FindBy(xpath = "(//*[contains(text(),'Drag & drop your files here, or browse.')])[1]")
	private WebElement authorizedSignatoryUploadLetterofAuthorization;
	@FindBy(xpath = "//*[contains(text(),'Drag & drop your files here, or browse.')]")
	private WebElement authorizedSignatoryUploadProofOfIdentity;
	@FindBy(xpath = "//button[contains(text(),'Update')]")
	private WebElement authorizedSignatoryUpadateButton;
	@FindBy(xpath = "(//button[contains(text(),'Cancel')])[1]")
	private WebElement authorizedSignatoryCancelButton;

	/*******************************************************************
	 * Organisation Profile Approved
	 *****************************************************************/
	public OrganizationProfilePage() {
		PageFactory.initElements(driver, this);
	}

	/*******************************************
	 * Organization Details
	 **************************************/
	public void clickOnCompleteProfileOrganizationBtn() {
		if (editOrganizationDetailsBtn.isDisplayed()) {
			editOrganizationDetailsBtn.click();
		} else {
			completeOrganizationProfile.click();
		}

	}

	public void enterTheLegalEntity(String orgName) {
		CommonUtilities.sendkeys(legalEntityName, orgName);
	}

	public void enterMobileNumber(String mobNumber) {
		CommonUtilities.sendkeys(mobileNumber, mobNumber);
	}

	public void enterthePanDetailsOfOrganization(String panDetaila) {
		CommonUtilities.sendkeys(organizationPanNumber, panDetaila);
	}

	public void uploadProofOfIdentity(String pathfile) throws InterruptedException {
		editProofOfIdentities.click();
		clickuploadProofOfIdentityAfterEdit.click();
		// clickuploadProofOfIdentity.click();
		UploadFileClass.uploadFileUsingRobotClass(pathfile);
		Thread.sleep(1000);
	}

	public void clickOnSaveAndNextButtonOrCancelButtonOfOrgDetails() throws InterruptedException {
		try {
			saveAndNextBtn.click();
		} catch (ElementNotInteractableException e) {
			updateOrganizationDetailsBtn.click();
		}
	}

	public void clickOnOrgDetilsSuccesfulyUpdatedBtn() {
		updateOrgDetails.click();
	}

	/******************************************
	 * Organization Address
	 **************************************/
	public void clickOnAddressButtonOrEditButton() {
		try {
			clickOrganizationAddressBtm.click();
		} catch (ElementNotInteractableException | NoSuchElementException ele) {
			editOrganizationAddressBtn.click();
		}
	}

	public void registerAddress(String address) {
		CommonUtilities.sendkeys(ragisterAddres, address);
	}

	public void enterCountry(String country) throws InterruptedException {
		selectCountry.click();
		Thread.sleep(500);
		CommonUtilities.sendkeys(selectSearchCountryOrState, country);
		selectSearchCountryOrState.sendKeys(Keys.DOWN);
		Thread.sleep(500);
		selectSearchCountryOrState.sendKeys(Keys.ENTER);

	}

	public void enterTheState(String state) throws InterruptedException {
		selectState.click();
		Thread.sleep(500);
		CommonUtilities.sendkeys(selectSearchCountryOrState, state);
		Thread.sleep(500);
		selectSearchCountryOrState.sendKeys(Keys.DOWN);
		Thread.sleep(500);
		selectSearchCountryOrState.sendKeys(Keys.ENTER);
	}

	public void enterTheCity(String city) {
		CommonUtilities.sendkeys(enterCity, city);
	}

	public void enterThePostalCode(String postalCode) {
		CommonUtilities.sendkeys(enterPostalcode, postalCode);
	}

	public void removeUploadedAddressProofFile() {
		removeProofAddUploadedfile.click();
	}

	public void uploadAddressProof(String addressProffpath) throws InterruptedException {
		ProofOfAddress.click();
		Thread.sleep(1000);
		UploadFileClass.uploadFileUsingRobotClass(addressProffpath);
		Thread.sleep(1000);
		System.out.println("Address Proof Uploaded ");
	}

	public void uploadDeclarationDocument(String documentPath) throws InterruptedException {
		declarationDocumentUpload.click();
		Thread.sleep(1000);
		UploadFileClass.uploadFileUsingRobotClass(documentPath);
		Thread.sleep(1000);
		System.out.println("Declaration Documents Uploaded");
	}

	public void AddresssaveAndNextBtnOrCancelBtn() {
		try {
			saveAndNextBtn.click();
		} catch (ElementNotInteractableException | NoSuchElementException exp) {
			orgAddressCancelButton.click();
		}
	}

	/***********************
	 * Authorized Signatory
	 **************************************/

	public void clickOnauthorizedSignatoryEditBtn() {
		authorizedSignatoryEditBtna.click();
	}

	public void enterTheAuthorizedSignatoryName(String name) {
		authorizedSignatoryName.sendKeys(name);
	}

	public void enterTheAuthorizedSignatoryEmailId(String emailid) {
		authorizedSignatoryEmailId.sendKeys(emailid);
	}

	public void enterTheAuthorizedSignatoryPhoneNumber(String mobilenum) throws InterruptedException {
		Thread.sleep(1000);
		authorizedSignatoryPhoneNumber.sendKeys(mobilenum);
	}

	public void selectTheAuthorizedSignatoryDocumetType(String documenttyp) throws InterruptedException {
		authorizedSignatoryDocumentType.click();
		Thread.sleep(1000);
		if (documenttyp.equalsIgnoreCase("PAN")) {
			selectPanDocumetType.click();
		} else if (documenttyp.equalsIgnoreCase("Aadhaar")) {
			selectAadharDocumetType.click();
		} else {
			System.out.println("Enter the Proper Document Name");
		}
	}

	public void enterTheAuthorizedSignatoryDocumetNumber(String docNumber) {
		authorizedSignatoryIdentityDocumentNumber.sendKeys(docNumber);
	}

	public void clickOnAuthorizedSignatoryLetterofAuthorization(String pathfile) throws InterruptedException {
		authorizedSignatoryUploadLetterofAuthorization.click();
		Thread.sleep(1000);
		UploadFileClass.uploadFileUsingRobotClass(pathfile);
		Thread.sleep(1000);
	}

	public void clickOnAuthorizedSignatoryProofofIdentity(String path) throws InterruptedException {
		authorizedSignatoryUploadProofOfIdentity.click();
		Thread.sleep(1000);
		UploadFileClass.uploadFileUsingRobotClass(path);
		Thread.sleep(1000);
	}

	public void clickOnAuthorizedSignatoryUpdateButtons() {
		try {
			authorizedSignatoryUpadateButton.click();
		} catch (ElementNotInteractableException | NoSuchElementException exp) {
			authorizedSignatoryCancelButton.click();
		}
	}
}
