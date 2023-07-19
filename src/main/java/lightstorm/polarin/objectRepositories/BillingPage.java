package lightstorm.polarin.objectRepositories;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lightstorm.polarin.testBase.TestBase;
import lightstorm.polarin.utility.CommonUtilities;
import lightstorm.polarin.utility.UploadFileClass;

public class BillingPage extends TestBase {

	/***********************************************
	 * Billing Profiles
	 ***********************************************/
	/***************************************
	 * Billing Details Elements
	 *****************************************/
	@FindBy(xpath = "//*[contains(text(),'Add Billing Profile')]")
	private WebElement addBillingProfileForNewSubcription;
	@FindBy(xpath = "//button[contains(text(),'Add')]")
	private WebElement clickOnNewAddBilingProfileForExisting;
	@FindBy(name = "gstNo")
	private WebElement enterGSTnumber;
	@FindBy(xpath="//*[contains(text(),'Please enter valid GST number')]")
	private WebElement gstNumberInvalidErrorMsg;
	@FindBy(xpath="//*[contains(text(),'GST number is invalid')]")
	private WebElement gstNumberInvalidAfterVerify;
	@FindBy(xpath = "//button[contains(text(),'Verify')]")
	private WebElement verifyGSTnoBtn;
	@FindBy(name = "profileName")
	private WebElement billingLegalEntityName;
	@FindBy(name = "billingAddress")
	private WebElement addressOfBilling;
	@FindBy(xpath = "(//input[@class='MuiInputBase-input MuiInputBase-inputAdornedEnd css-mnn31'])[1]")
	private WebElement countryOfBilling;
	@FindBy(xpath = "//input[@class='MuiInputBase-input MuiInputBase-inputAdornedStart MuiAutocomplete-input MuiAutocomplete-inputFocused css-mnn31']")
	private WebElement selectCountryAndStateFrmDropDown;
	@FindBy(xpath = "(//input[@class='MuiInputBase-input MuiInputBase-inputAdornedEnd css-mnn31'])[2]")
	private WebElement stateOfBilling;
	@FindBy(name = "cityId")
	private WebElement cityOfBilling;
	@FindBy(name = "pinCode")
	private WebElement postalCodeOfBiling;
	@FindBy(xpath = "//*[@class='MuiTypography-root MuiTypography-h5 css-y2letl']")
	private WebElement uploadGSTdocument;
	@FindBy(xpath = "//*[contains(text(),'Next')]")
	private WebElement billingSubmitBtn;
	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
	private WebElement billingCancelBtn;
	/************************************************
	 * Billing Contact Elements
	 ************************************************/
	@FindBy(name = "billingContactName")
	private WebElement billingContactName;
	@FindBy(xpath="//*[contains(text(),'enter a valid contact name')]")
	private WebElement errorMessageAfterEnterInvalidName;
	@FindBy(name = "billingContactEmail")
	private WebElement billingEmailID;
	@FindBy(xpath="//*[contains(text(),'Please enter a valid email address')]")
	private WebElement errorMessageAfterEnterInvalidEmailID;
	@FindBy(name = "billingContactNumber")
	private WebElement billingContactNumber;
	@FindBy(xpath="//*[contains(text(),'enter a valid phone number')]")
	private WebElement errorMessageAfterEnterInvalidMobileNo;
	@FindBy(xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-fullWidth css-13fgtx3']")
	private WebElement billingDetailsCreateBtn;
	@FindBy(xpath = "//div[@class='MuiAlert-message css-1xsto0d']")
	private WebElement errorMessage;
	@FindBy(xpath = "//button[text()='Got it, Click to preview details']")
	private WebElement billingProfileSuccefullMessage;

	public BillingPage() {
		PageFactory.initElements(driver, this);
	}

	/******************************************************************
	 * Billing Details Methods
	 ******************************************************************/

	public void addBillingProfile() throws InterruptedException {
		try {
			clickOnNewAddBilingProfileForExisting.click();
		} catch (ElementNotInteractableException | NoSuchElementException no) {
			addBillingProfileForNewSubcription.click();
		}
	}

	public void enterTheGSTNumber(String gstNumb) throws InterruptedException {
		// gstNumber.sendKeys(gstNum);
		CommonUtilities.sendkeys(enterGSTnumber, gstNumb);
		verifyGSTnoBtn.click();
		Thread.sleep(1500);
	}
	public void enterTheGSTNumberNewmethod(String gstNumb) throws InterruptedException {
		// gstNumber.sendKeys(gstNum);
		CommonUtilities.sendkeys(enterGSTnumber, gstNumb);
		Thread.sleep(1500);
	}
	
	public String getErrorMessageIfEnterWorngGSTno() {
		return gstNumberInvalidErrorMsg.getText();
	}
	
	public String getErrorMessageAfterVerifyWrongGSTno() {
		return gstNumberInvalidAfterVerify.getText();
	}

	public void enterLegalEntityName(String billingname) {
		CommonUtilities.sendkeys(billingLegalEntityName, billingname);
	}

	public void enterbillingAddress(String billingaddres) {
		CommonUtilities.sendkeys(addressOfBilling, billingaddres);
	}

	public void selectBillingCountry(String selectCountry) throws InterruptedException {
		Thread.sleep(1500);
		countryOfBilling.click();
		CommonUtilities.sendkeys(selectCountryAndStateFrmDropDown, selectCountry);
		selectCountryAndStateFrmDropDown.sendKeys(Keys.DOWN);
		selectCountryAndStateFrmDropDown.sendKeys(Keys.ENTER);
	}

	public void selectBillingState(String selectState) {
		stateOfBilling.click();
		CommonUtilities.sendkeys(selectCountryAndStateFrmDropDown, selectState);
		selectCountryAndStateFrmDropDown.sendKeys(Keys.DOWN);
		selectCountryAndStateFrmDropDown.sendKeys(Keys.ENTER);
	}

	public void enterBillingCity(String cityofbiiling) {
		CommonUtilities.sendkeys(cityOfBilling, cityofbiiling);
	}

	public void enterBillingPostalCode(String postalcode) {
		CommonUtilities.sendkeys(postalCodeOfBiling, postalcode);
	}

	public void uploadGSTDocument(String gstDoc) throws InterruptedException {
		uploadGSTdocument.click();
		Thread.sleep(2000);
		UploadFileClass.uploadFileUsingRobotClass(gstDoc);
		Thread.sleep(1500);
		System.out.println("GST File Uploaded");
	}

	public void clickBillingSubmitCodeOrCancel() throws InterruptedException {
		Thread.sleep(1000);
		try {
			billingSubmitBtn.click();
		} catch (ElementNotInteractableException e) {
			billingCancelBtn.click();
		}
	}

	/********************************************************
	 * Billing Contact Methods
	 **********************************************************/
	public void enterbillingContatcName(String name) throws InterruptedException {
		Thread.sleep(1000);
		CommonUtilities.sendkeys(billingContactName, name);
		
	}
	public String getErrorMessageAftrEnterInvalidName() {
		return errorMessageAfterEnterInvalidName.getText();
	}
	
	public void enterbillingEmailAddress(String email) {
		CommonUtilities.sendkeys(billingEmailID, email);
	}
	public String getErrorMessageAftrEnterInvalidEmailID() {
		return errorMessageAfterEnterInvalidEmailID.getText();
	}

	public void enterMobileNumber(String number) {
		CommonUtilities.sendkeys(billingContactNumber, number);
	}
	
	public String getErrorMessageAftrEnterInvalidPhoneNumber() {
		return errorMessageAfterEnterInvalidMobileNo.getText();
	}


	public void clickOnCreateBtn() throws InterruptedException {
		Thread.sleep(1000);
		billingDetailsCreateBtn.click();
	}

	public String checkErrorMesagge() {
		return errorMessage.getText();
	}

	public void clickOnBillingProfileSuccesfulMessage() {
		CommonUtilities.ElementToBeClickable(billingProfileSuccefullMessage, 4);
		billingProfileSuccefullMessage.click();
	}

	public boolean isErrorMessageDisplayed() {
		return errorMessage.isDisplayed();
	}

}
