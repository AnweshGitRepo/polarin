package lightstorm.polarin.objectRepositories;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;
import lightstorm.polarin.testBase.TestBase;
import lightstorm.polarin.utility.CommonUtilities;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateVirtualConnectionPortToCloudPage extends TestBase {

	WebDriverWait wait;
	/*****************************************************************
	 * A Origin Elements
	 ****************************************************************/
	@FindBy(xpath = "(//div[@class='css-f6wjpr'])[2]")
	private WebElement clickOnCloudOrigin;

	@FindBy(xpath = "//input[@class='MuiInputBase-input MuiInputBase-inputAdornedStart MuiAutocomplete-input MuiAutocomplete-inputFocused css-mnn31']")
	private WebElement selectCloudProviderService;

	@FindBy(xpath = "//div[@class='MuiListItemText-root css-1tsvksn']")
	private List<WebElement> chooseAnyOneCloudProviderServicesList;
	/********************************************************************
	 * AWS Elements
	 ********************************************************************/
	@FindBy(xpath = "(//input[@class='MuiInputBase-input MuiInputBase-inputAdornedEnd css-mnn31'])[2]")
	private WebElement clickInterconnectlocation;

	@FindBy(xpath = "//input[@class='MuiInputBase-input MuiInputBase-inputAdornedStart MuiAutocomplete-input MuiAutocomplete-inputFocused css-mnn31']")
	private List<WebElement> selectInterconnectLocationGivenList;

	@FindBy(xpath = "//input[@class='MuiInputBase-input css-mnn31']")
	private WebElement enterAWSAccountID;
	/*************************************************************************
	 * Google Cloud Elements
	 *************************************************************************/
	@FindBy(name = "googlePairingKey")
	private WebElement pairingKeyInGoogleCloud;

	/*************************************************************************
	 * AZURE Elements
	 *************************************************************************/
	@FindBy(name = "azureServiceKey")
	private WebElement enterTheAzureServiceKey;

	@FindBy(name = "peerVlanId")
	private WebElement enterAzurePEERVlanID;

	@FindBy(name = "Azure Peering Type")
	private WebElement radioBtnSelectAzurePeeringType;

	@FindBy(name = "Azure Microsoft Peering")
	private WebElement radioBtnSelectMicrosoftPeering;

	@FindBy(name = "ipAddress")
	private WebElement enterAzureIPV4Address;

	@FindBy(name = "customerASN")
	private WebElement enterAzureCustomerASN;

	@FindBy(id = "mui-component-select-routingRegistryName")
	private WebElement clickOnPeeringDropDown;

	@FindBy(xpath = "//li[@class='MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters css-6lgxa6']")
	private List<WebElement> selectAllPeeringNamesfFrmList;

	@FindBy(xpath = "//*[@class='MuiTypography-root MuiTypography-body1 css-1nw7sf']")
	private WebElement errorMessageAfterEnterServicekey;

	/******************************************************
	 * Oracle cloud Elements
	 ******************************************************/
	@FindBy(name = "ocid")
	private WebElement enterOracalServicekeyOrOCIDkey;

	@FindBy(xpath = "//button[contains(text(),'Verify')]")
	private WebElement clickOnVerifyBtnOracal;

	@FindBy(xpath = "MuiFormHelperText-root MuiFormHelperText-sizeMedium MuiFormHelperText-contained MuiFormHelperText-filled css-5415mt")
	private WebElement errorMessageifOCIDNotVerify;
	/*********************************************************************
	 * Virtual Connection Details Elements
	 ********************************************************************/
	@FindBy(xpath = "//div[@class='MuiSelect-select MuiSelect-outlined MuiInputBase-input css-k3mz41']")
	private WebElement clickOnRateLimitsdropDown;

	@FindBy(xpath = "//li[@class='MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters css-6lgxa6']")
	private List<WebElement> selectRateLimitsfromList;

	@FindBy(xpath = "(//*[@class='MuiTypography-root MuiTypography-h5 css-g1mnfr'])[1]")
	private WebElement subtotalforPerticularMonth;

	@FindBy(xpath = "(//*[@class='MuiTypography-root MuiTypography-h5 css-g1mnfr'])[2]")
	private WebElement subTotalAmountVr;

	@FindBy(xpath = "(//*[@class='MuiTypography-root MuiTypography-h5 css-g1mnfr'])[4]")
	private WebElement totalAmount;

	@FindBy(xpath = "(//*[@class='MuiTypography-root MuiTypography-body2 css-cnyufv'])[4]")
	private WebElement youPayAmounteverymonth;

	@FindBy(xpath = "//button[contains(text(),'Next')]")
	private WebElement clickOnNextButton;
	/**********************************************************
	 * New Subscriptions Page
	 *********************************************************/
	//@FindBy(xpath = "(//*[@class='MuiTypography-root MuiTypography-h4 css-1hibme8'])[1]")
	//private WebElement clickOnVirtualConnectionOnNewSubscriptionPage;
	@FindBy(xpath = "//h4[text()='Virtual Connection']")
	private WebElement clickOnVirtualConnectionOnNewSubscriptionPage;
	
	//@FindBy(xpath = "(//*[@class='MuiTypography-root MuiTypography-h5 css-7n7i1w'])[6]")
	//private WebElement youPayVirtualConnectionOnNewSubscriptionPage;
	@FindBy(xpath = "//div[@class='MuiAccordionDetails-root css-1qmx01o']//div[2]//div[2]/h5")
	private WebElement youPayVirtualConnectionOnNewSubscriptionPage;
	
	//@FindBy(xpath = "(//*[@class='MuiTypography-root MuiTypography-h4 css-1hibme8'])[2]")
	//private WebElement clickOnAEndDetailsOnNewSubscriptionPage;
    @FindBy(xpath = "//h4[text()='B End Details']")
    private WebElement clickOnAEndDetailsOnNewSubscriptionPage;
	
	//@FindBy(xpath = "(//*[@class='MuiTypography-root MuiTypography-h5 css-7n7i1w'])[10]")
	//private WebElement youPayAEndDetailsOnNewSubscriptionPage;
	@FindBy(xpath = "//div[@class='MuiCollapse-root MuiCollapse-vertical MuiCollapse-entered css-c4sutr']//div[4]//div[2]//h5")
	private WebElement youPayAEndDetailsOnNewSubscriptionPage;
	
	@FindBy(xpath = "//input[@class='MuiInputBase-input MuiInputBase-inputAdornedEnd css-mnn31']")
	private WebElement clickOnSelectBillingProfile;

	@FindBy(xpath = "(//input[@type='text'])[2]")
	private WebElement selectBillingProfileDromDropDown;

	@FindBy(xpath = "//*[@class='MuiTypography-root MuiTypography-h4 css-hwsf2q']")
	private WebElement newSubscriptionText;

	/********************************************************************************************/
	public CreateVirtualConnectionPortToCloudPage() {
		PageFactory.initElements(driver, this);
	}

	/****************************************************
	 * Common Methods
	 ****************************************************/
	public void clickOnCloudIcon() {
		clickOnCloudOrigin.click();
	}

	public void selectCloudServiceProvider(String cloudService) {
		List<WebElement> allText = chooseAnyOneCloudProviderServicesList;
		for (WebElement text : allText) {
			if (text.getText().equals(cloudService)) {
				text.click();
				break;
			}
			System.out.println(text);
		}
	}

	public void clickOnVerifyButton() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(clickOnVerifyBtnOracal));
		element.click();
	}

	/***************************************************
	 * AWS Cloud
	 **************************************************/
	public void clickOnInterConnectlocation() {
		clickInterconnectlocation.click();
	}

	public void selectConnectionLocationFromDropDown(String locationDC) throws InterruptedException {
		Thread.sleep(1000);
		CommonUtilities.sendkeys(selectCloudProviderService, locationDC);
		selectCloudProviderService.sendKeys(Keys.DOWN);
		Thread.sleep(500);
		selectCloudProviderService.sendKeys(Keys.ENTER);
	}

	public void enterAWSAccountID(String entrAWSActNo) {
		CommonUtilities.sendkeys(enterAWSAccountID, entrAWSActNo);
	}

	/*************************************
	 * Google Cloud
	 *************************************/

	public void enterThePairingKeygoogleCloud(String pairingKey) {
		CommonUtilities.sendkeys(pairingKeyInGoogleCloud, pairingKey);
	}

	/***************************************
	 * Oracle Cloud
	 *************************************/
	public void enterTheOCIDOrServiceKey(String ocidEnter) {
		CommonUtilities.sendkeys(enterOracalServicekeyOrOCIDkey, ocidEnter);
	}

	public String errorMessageifOCIDNotVerify() {
		return errorMessageifOCIDNotVerify.getText();
	}

	/***************************************
	 * AZURE Service Key
	 ***************************************/
	public void enterTheServiceKeyForAzurePort(String serviceKey) {
		CommonUtilities.sendkeys(enterTheAzureServiceKey, serviceKey);
	}

	public void enterThePeerVLANIDForAzurePort(String peerVLANPort) {
		CommonUtilities.sendkeys(enterAzurePEERVlanID, peerVLANPort);
	}

	public String enterErrorMessageAfterEnterWorngAzureServiceKey() {
		return errorMessageAfterEnterServicekey.getText();
	}

	public void clickOnRadioBtnAzurePeeringType() {
		radioBtnSelectAzurePeeringType.click();
	}

	public void clickOnAzureMicroSoftPeeringRadioBtn() {
		radioBtnSelectMicrosoftPeering.click();
	}

	public void enterTheIPV4AddressAzure(String ipv4address) {
		CommonUtilities.sendkeys(enterAzureIPV4Address, ipv4address);
	}

	public void enterCustomeASNServiceAzure(String customerASN) {
		CommonUtilities.sendkeys(enterAzureCustomerASN, customerASN);
	}

	public void clickOnPeering() {
		clickOnPeeringDropDown.click();
	}

	public void selectPeeringfromList(String peeringName) {
		List<WebElement> allText = selectAllPeeringNamesfFrmList;
		for (WebElement text : allText) {
			if (text.getText().equals(peeringName)) {
				text.click();
				break;
			}
			System.out.println(text);
		}
	}

	/*************************************************
	 * Virtual Connection Details Methods
	 *************************************************/
	public void clickOnRateLimits() {
		clickOnRateLimitsdropDown.click();
	}

	public void selectRateLimitsfromList(String rateLimits) {
		List<WebElement> allText = selectRateLimitsfromList;
		for (WebElement text : allText) {
			if (text.getText().equals(rateLimits)) {
				text.click();
				break;
			}
			System.out.println(text);
		}
	}

	public String subTotalAmountForMonthAWS() throws InterruptedException {
		Thread.sleep(10000);
		String subtotalforPerMonth = subtotalforPerticularMonth.getText();
		return subtotalforPerMonth.replaceAll("[^0-9]", "");
	}

	public String subTotalAmountForAWS() throws InterruptedException {
		Thread.sleep(500);
		String subTotalAmount = subTotalAmountVr.getText();
		return subTotalAmount.replaceAll("[^0-9]", "");
	}

	public String TotalAmountForAWS() throws InterruptedException {
		Thread.sleep(500);
		String totalAmount1 = totalAmount.getText();
		return totalAmount1.replaceAll("[^0-9]", "");
	}

	public String youPayVeryMonthAmount() throws InterruptedException {
	    Thread.sleep(500);
		String youpayAmtevymoth = youPayAmounteverymonth.getText();
		return youpayAmtevymoth.replaceAll("[^0-9]", "");
	}

	/*************************************************
	 * New Subscriptions Page Methods
	 *************************************************/
	public void clickOnVirtualConnectionDetailsDropDown() {
		clickOnVirtualConnectionOnNewSubscriptionPage.click();
	}
	public boolean isDisplayedVirtualConnectionDetails() {
		return clickOnVirtualConnectionOnNewSubscriptionPage.isDisplayed();
	}
	
	public String getTheYouPayAmountOnvirtualConnectionDetailsPage() throws InterruptedException {
		Thread.sleep(1000);
		String youPaymentText = youPayVirtualConnectionOnNewSubscriptionPage.getText();
		return youPaymentText.replaceAll("[^0-9]", "");
	}

	public void clickOnAEndDetails() throws InterruptedException {
		Thread.sleep(500);
		WebElement clickOnAEndDetailsDropDone=CommonUtilities.ElementToBeClickable(clickOnAEndDetailsOnNewSubscriptionPage, 5);
				clickOnAEndDetailsDropDone.click();
	}
	
	public boolean isDispalayedAEndDetails() {
		try {
		return clickOnAEndDetailsOnNewSubscriptionPage.isDisplayed();
		}catch(Exception c) {
			c.printStackTrace();
			System.out.println("Element Is not ");
			return false;
		}
		
	}

	public String getYouPayAmountFromAEndDetailsPage() throws InterruptedException {
		Thread.sleep(1000);
		String getpayment = youPayAEndDetailsOnNewSubscriptionPage.getText();
		return getpayment.replaceAll("[^0-9]", "");
	}

	public void clickOnBillingForProfileSelect() {
		try {
			WebElement billingProfileSelect =CommonUtilities.ElementToBeClickable(clickOnSelectBillingProfile, 5);
			billingProfileSelect.click();
		}catch(Exception ele) {
			ele.printStackTrace();
		}
		
	}

	public void selectBillingProfileFormDropDown(String billingprofile) throws InterruptedException {
		CommonUtilities.sendkeys(selectBillingProfileDromDropDown, billingprofile);
		Thread.sleep(1000);
		selectBillingProfileDromDropDown.sendKeys(Keys.DOWN);
		Thread.sleep(500);
		selectBillingProfileDromDropDown.sendKeys(Keys.ENTER);
	}
	
	
}
