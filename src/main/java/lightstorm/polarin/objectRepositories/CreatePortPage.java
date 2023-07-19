package lightstorm.polarin.objectRepositories;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lightstorm.polarin.testBase.TestBase;
import lightstorm.polarin.utility.CommonUtilities;

public class CreatePortPage extends TestBase {
	/******* Port Location ***********************************************/
	@FindBy(xpath = "//button[text()='Create']")
	private WebElement createButtonele;

	@FindBy(xpath = "//p[contains(text(),'Create a Port')]")
	private WebElement clickoncreatePortLink;

	// @FindBy(css = "p.css-92pcgx") private List<WebElement> createPortBtnele;

	@FindBy(xpath = "//input[@class='MuiInputBase-input MuiInputBase-inputAdornedStart MuiAutocomplete-input MuiAutocomplete-inputFocused css-mnn31']")
	private WebElement searchPortByLocation;

	@FindBy(xpath = "//*[@class='MuiTypography-root MuiTypography-body2 MuiListItemText-primary css-u12yly']")
	private List<WebElement> allPort;

	@FindBy(xpath = "//button[contains(text(),'Next')]")
	private WebElement saveAndNextBtn;

	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
	private WebElement cancelBtn;

	@FindBy(xpath = "(//*[@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-vubbuv'])[21]")
	private WebElement crossCancelButton;

	/*********************************************************
	 * Configure Port
	 ***********************************************/
	@FindBy(name = "portName")
	private WebElement portNameTextBox;
	
	@FindBy(xpath="//*[contains(text(),'name must be unique')]")
	private WebElement portNameEnterSameErrorMsg;

	@FindBy(xpath = "//button[@class='MuiButtonBase-root MuiTab-root MuiTab-textColorPrimary css-1edfv2d']")
	private WebElement portSpeedInGBBtn;

	@FindBy(xpath = "//button[contains(text(),'GE')]")
	private List<WebElement> portSpeedSelection;

	@FindBy(xpath = "//button[contains(text(),'Months')]")
	private List<WebElement> subscriptionselection;

	@FindBy(xpath = "//button[contains(text(),'Upfront')]")
	private List<WebElement> paymentModeselection;

	@FindBy(xpath = "(//div[@class='css-9jay18'])[1]")
	private WebElement subTotalForMonth;

	@FindBy(xpath = "(//*[@class='MuiTypography-root MuiTypography-h5 css-g1mnfr'])[2]")
	private WebElement subTotalAmountWithOutDicounted;

	@FindBy(xpath = "(//div[@class='css-9jay18'])[2]")
	private WebElement discountInPercentage;

	@FindBy(xpath = "(//div[@class='css-9jay18'])[3]")
	private WebElement totalAmmount;

	@FindBy(xpath = "(//div[@class='css-j0iiqq'])[1]")
	private WebElement upfrontPayment;

	@FindBy(xpath = "(//div[@class='css-j0iiqq'])[2]")
	private WebElement youPayAmounteverymonth;
	
	@FindBy(xpath="//div[@class='MuiAlert-message css-1xsto0d']")
	private WebElement errorMessagePortAlreadyExit;

	/***************************************************************************************
	 * CheckOut Page
	 ***************************************************************************************/
	@FindBy(xpath = "//input[@class='MuiInputBase-input MuiInputBase-inputAdornedEnd css-mnn31']")
	private WebElement billingSearchButton;

	@FindBy(xpath = "//input[@class='MuiInputBase-input MuiInputBase-inputAdornedStart MuiAutocomplete-input MuiAutocomplete-inputFocused css-mnn31']")
	private WebElement searchBillingProfile;

	@FindBy(xpath = "//*[contains(text(),'Port Details')]")
	private WebElement clickOnPortDetails;

	@FindBy(xpath = "//div/h5[@class='MuiTypography-root MuiTypography-h5 css-7n7i1w']")
	private WebElement checkoutpageTotalAmount;

	@FindBy(xpath = "//button[contains(text(),'Order')]")
	private WebElement clickOnOrderPlace;

	@FindBy(xpath = "//input[@class='PrivateSwitchBase-input css-1m9pwf3']")
	private WebElement clickOnCheckBoxForiAgreeServices;

	@FindBy(xpath = "//button[contains(text(),'Back to Services screen')]")
	private WebElement portCreatedPopUpMessage;

	public CreatePortPage() {
		PageFactory.initElements(driver, this);
	}

	/****************************************************************************
	 * Port Creation & Location Selection
	 ****************************************************************************/
	public void clickOnCreateBtn() throws InterruptedException {
		try {
			createButtonele.click();
		} catch (StaleElementReferenceException element) {
			createButtonele.click();
			element.printStackTrace();
		}
	}

	public void selectCreatePortLink() {
		clickoncreatePortLink.click();
	}

	public void selectPortLocation() {
		CommonUtilities.sendkeys(searchPortByLocation, "Mumbai");
	}

	public List<String> getSearchResultText() {
		List<String> resultTexts = new ArrayList<>();
		for (WebElement result : allPort) {
			resultTexts.add(result.getText());
		}
		return resultTexts;
	}

	public void clickOnSearchResult(String clickAllPortText) throws IllegalAccessException, InterruptedException {
		List<WebElement> allText = allPort;
		for (WebElement text : allText) {
			if (text.getText().equals(clickAllPortText)) {
				text.click();
				break;
			}
			System.out.println(allText);
		}
	}

	public void clickOnSaveAndNextBtn() {
		saveAndNextBtn.click();
	}

	/*************************************************
	 * Configure Port
	 **********************************************/
	public void clickOnCancelBtn() {
		cancelBtn.click();
	}

	public void enterPortNameinTextBox(String portname) {
		CommonUtilities.sendkeys(portNameTextBox, portname);
	}
	
	public String getUniqueNameErrorMessage() {
		return portNameEnterSameErrorMsg.getText();
	}

	public void selectPortSpeed(String pspeed) {
		for (WebElement allSpeedPort : portSpeedSelection) {
			String speed = allSpeedPort.getText();
			if (speed.equals(pspeed)) {
				allSpeedPort.click();
				break;
			}
			System.out.println(speed);
		}
	}

	public void selectSubscriptionterm(String subscription) {
		for (WebElement allSubscriptionPort : subscriptionselection) {
			String subscriptionport = allSubscriptionPort.getText();
			if (subscriptionport.equals(subscription)) {
				allSubscriptionPort.click();
				break;
			}
			System.out.println(subscriptionport);
		}
	}

	public void selectPayment(String payment) {
		for (WebElement allPaymentOption : paymentModeselection) {
			String paymentPort = allPaymentOption.getText();
			if (paymentPort.equals(payment)) {
				allPaymentOption.click();
				break;
			}
			System.out.println(paymentPort);
		}
	}

	public String subTotalFromMonthWise() throws InterruptedException {
		Thread.sleep(1000);
		return subTotalForMonth.getText();
	}

	public String totalAmountWithOutDiscounted() throws InterruptedException {
		Thread.sleep(1500);
		return subTotalAmountWithOutDicounted.getText();
	}

	public String paymentDiscount() throws InterruptedException {
		Thread.sleep(600);
		return discountInPercentage.getText();
	}

	public String totalAmountAfterDiscount() throws InterruptedException {
		Thread.sleep(500);
		return totalAmmount.getText();
	}

	public String upfrontPayment() throws InterruptedException {
		Thread.sleep(400);
		return upfrontPayment.getText();
	}

	public String youPayAmounteverymonth() throws InterruptedException {
		Thread.sleep(300);
		return youPayAmounteverymonth.getText();
	}

	public void clickNextButton() {
		if (saveAndNextBtn.isDisplayed()) {
			saveAndNextBtn.click();
			System.out.println("Next Button is clicked");
		} else {
			cancelBtn.click();
		}
	}

	public String getErrorIfPortIsAlreadyExit() {
		return errorMessagePortAlreadyExit.getText();
	}
	/***********************************************************
	 * CheckOut
	 ***********************************************************/

	public void selectBillingProfile(String selBillingProfile) throws InterruptedException {
		billingSearchButton.click();
		Thread.sleep(1000);
		CommonUtilities.sendkeys(searchBillingProfile, selBillingProfile);
		searchBillingProfile.sendKeys(Keys.DOWN);
		Thread.sleep(500);
		searchBillingProfile.sendKeys(Keys.ENTER);
	}

	public void clickOnPortDetails() {
		clickOnPortDetails.click();
	}

	public String totalAmountOnCheckOutPage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String element = checkoutpageTotalAmount.getText();
		return (String) js.executeScript("return arguments[0].innerText;", element);
	}

	public void clickOnorderBtutton() {
		clickOnOrderPlace.click();
	}

	public void portCreationSuccesfullmessagePopUp() {
		portCreatedPopUpMessage.click();
	}

	public void clickOnIAggreementBtnAndOrderPlaced() throws InterruptedException {
		if (!clickOnCheckBoxForiAgreeServices.isSelected()) {
			clickOnCheckBoxForiAgreeServices.click();
			Thread.sleep(1000);
			clickOnOrderPlace.click();
		} else {
			cancelBtn.click();
		}
	}
}
