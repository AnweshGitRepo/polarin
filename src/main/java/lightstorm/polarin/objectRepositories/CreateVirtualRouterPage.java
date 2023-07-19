package lightstorm.polarin.objectRepositories;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lightstorm.polarin.testBase.TestBase;
import lightstorm.polarin.utility.CommonUtilities;

public class CreateVirtualRouterPage extends TestBase {
	/***********************************************
	 * Router Location
	 ***********************************************/
	@FindBy(xpath = "(//*[contains(text(),'Create')])[1]")
	private WebElement clickOnCreateBtnOnServicePage;

	@FindBy(xpath = "//p[contains(text(),'Create a Virtual Router')]")
	private WebElement clickOnVirtualRouter;

	@FindBy(xpath = "//*[@class='MuiTypography-root MuiTypography-body2 MuiListItemText-primary css-u12yly']")
	private List<WebElement> allPort;

	@FindBy(xpath = "//button[contains(text(),'Next')]")
	private WebElement clickOnNextButton;

	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
	private WebElement cancelBtn;

	/*********************************************
	 * Router Details
	 ***********************************************/
	@FindBy(name = "virtualRouterName")
	private WebElement virtualRouterName;

	@FindBy(name = "rateLimit")
	private WebElement ratelimit;

	@FindBy(xpath = "//div[@class='MuiInputBase-root MuiInputBase-colorPrimary MuiInputBase-formControl css-p2l6k8']")
	private WebElement clickonSpeed;

	@FindBy(xpath = "//li[contains(text(),'Gbps')]")
	private WebElement gbpsSpeed;

	@FindBy(xpath = "//li[contains(text(),'Mbps')]")
	private WebElement mbpsSpeed;

	@FindBy(xpath = "//button[@class='MuiButtonBase-root MuiToggleButton-root MuiToggleButton-sizeMedium MuiToggleButton-standard MuiToggleButtonGroup-grouped MuiToggleButtonGroup-groupedHorizontal css-n9kpce']")
	private List<WebElement> subscriptionTermPlan;

	// @FindBy(xpath = "//button[contains(text(),'Months')]") private
	// List<WebElement> subscriptionTermPlan;

	@FindBy(xpath = "//button[contains(text(),'Upfront')]")
	private List<WebElement> paymentType;

	@FindBy(xpath = "(//*[@class='MuiTypography-root MuiTypography-h5 css-g1mnfr'])[2]")
	private WebElement subTotalAmount;

	@FindBy(xpath = "(//*[@class='MuiTypography-root MuiTypography-body2 css-a5bbuo'])[2]")
	private WebElement discountInPercent;

	@FindBy(xpath = "(//div[@class='css-9jay18'])[3]")
	private WebElement totalAmountforPriseSummery;

	@FindBy(xpath = "(//*[@class='MuiTypography-root MuiTypography-body2 css-cnyufv'])[2]")
	private WebElement upfrontPaymentVR;

	@FindBy(xpath = "(//*[@class='MuiTypography-root MuiTypography-body2 css-cnyufv'])[4]")  
	private WebElement youPayAmountEveryMonth;

	/********************* CheckOut ***************************************/
	@FindBy(xpath = "//input[@class='MuiInputBase-input MuiInputBase-inputAdornedEnd css-mnn31']")
	                 
	private WebElement selectBillingProfile;
	
	@FindBy(xpath = "//input[@class='MuiInputBase-input MuiInputBase-inputAdornedStart MuiAutocomplete-input MuiAutocomplete-inputFocused css-mnn31']")
	private WebElement chooseBillingProfile;
	
	@FindBy(xpath="//*[@class='MuiTypography-root MuiTypography-h4 css-1hibme8']")
	private WebElement clickOnRouterdetails;

	@FindBy(xpath = "(//*[@class='MuiTypography-root MuiTypography-h5 css-7n7i1w'])[4]")
	private WebElement totalAmountOnCheckOutPageText;
	
	@FindBy(xpath = "//input[@class='PrivateSwitchBase-input css-1m9pwf3']")
	private WebElement serviceAggrementCheckBox;

	@FindBy(xpath = "//div[@class='MuiAlert-message css-1xsto0d']")
	private WebElement errorMessage;

	@FindBy(xpath = "//button[contains(text(),'Order')]")
	private WebElement orderPlace;
	
	@FindBy(xpath="//button[contains(text(),'Back to Services screen')]")
	private WebElement vCCreatedSuccessfullyMessage;
	
	@FindBy(xpath="//*[contains(text(),'Port created')]")
	private WebElement portcreatedSuccesMessage;

	public CreateVirtualRouterPage() {
		PageFactory.initElements(driver, this);
	}

	/************************************************
	 * Router Location
	 ***********************************************/
	public void clickOnCreateBtn() {
		try {
			clickOnCreateBtnOnServicePage.click();
		} catch (StaleElementReferenceException stl) {
			clickOnCreateBtnOnServicePage.click();
			stl.printStackTrace();
		}
	}

	public void selectVertualRouterLink() {
		clickOnVirtualRouter.click();
	}

	public void selectRouterLocation(String clickAllPortText) throws InterruptedException, IllegalAccessException {
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
		if (clickOnNextButton.isDisplayed()) {
			clickOnNextButton.click();
			System.out.println("Click On Submit Button");
		} else {
			cancelBtn.click();
			System.out.println("Click on Cancel Button");
		}

	}

	/************************************************
	 * Router Details
	 ***********************************************/
	public void enterVirtualRoutername(String routname) {
		CommonUtilities.sendkeys(virtualRouterName, routname);
	}

	public void enterTheRateLimit(String rateSpeed) {
		CommonUtilities.sendkeys(ratelimit, rateSpeed);
	}

	public void selectGbpsOrMbps(String speedBand) throws InterruptedException {
		clickonSpeed.click();
		Thread.sleep(1000);
		if (gbpsSpeed.getText().equalsIgnoreCase(speedBand)) {
			gbpsSpeed.click();
		} else if (mbpsSpeed.getText().equalsIgnoreCase(speedBand)) {
			mbpsSpeed.click();
		} else {
			System.out.println("Error: Please Enter the Proper BandWith");
		}
	}

	public void selectRouterSubscriptionTearm(String subscription) {
		for (WebElement allSubscriptionRouter : subscriptionTermPlan) {
			String subscriptionRouter = allSubscriptionRouter.getText();
			if (subscriptionRouter.equals(subscription)) {
				allSubscriptionRouter.click();
				break;
			}
			System.out.println(subscriptionRouter);
		}
	}

	public void selectRouterPayment(String paymentplan) {
		for (WebElement allPaymentPlanRouter : paymentType) {
			String paymentPlanRouter = allPaymentPlanRouter.getText();
			if (paymentPlanRouter.equals(paymentplan)) {
				allPaymentPlanRouter.click();
				break;
			}
			System.out.println(paymentPlanRouter.toString());
		}
	}

	public String getTheSubTotalAmount() throws InterruptedException {
		Thread.sleep(1000);
		return subTotalAmount.getText();
	}

	public String getTheDiscount() throws InterruptedException {
		Thread.sleep(800);
		return discountInPercent.getText();
	}

	
	  public String getTheTotalAmount() throws InterruptedException {
	  Thread.sleep(600); 
	  String str=totalAmountforPriseSummery.getText();
	   return str.replaceAll("[^0-9]", "");
	  }
	 
	
	public String UpfrontPaymentInVR() throws InterruptedException {
		Thread.sleep(400);
		return upfrontPaymentVR.getText();
	}

	public String youPayAmounteverymonth() throws InterruptedException {
		Thread.sleep(200);
		return youPayAmountEveryMonth.getText();
	}

	/********************* CheckOut ***************************************/

	public void selectBillingProfile() {
		selectBillingProfile.click();
	}
	
	public void chooseBillingProfileFromDropdown(String selBillingProfileName) throws InterruptedException {
		Thread.sleep(1000);
		CommonUtilities.sendkeys(chooseBillingProfile, selBillingProfileName);
		chooseBillingProfile.sendKeys(Keys.DOWN);
		Thread.sleep(500);
		chooseBillingProfile.sendKeys(Keys.ENTER);
	}

	public String checkTotalAmount() throws InterruptedException {
		clickOnRouterdetails.click();
		Thread.sleep(1000);
		String inputString=totalAmountOnCheckOutPageText.getText();
		Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(inputString);

        StringBuilder numericValues = new StringBuilder();
        while (matcher.find()) {
            numericValues.append(matcher.group());
        }

        return numericValues.toString();
    }
	
	public void clickOnServiceAggrement() {
		if (!serviceAggrementCheckBox.isSelected()) {
			serviceAggrementCheckBox.click();
		}else {
			System.out.println("Check Box is not Able to Click");
		}
	}
	public void clickOnorderBtutton() {
	orderPlace.click();
	}
	
	public boolean isErrorMessageDisplayedWhenOrderBtnClick() {
		return errorMessage.isDisplayed();
	}
	
	public String checkErrorMesaggeafterClkOrder() {
		return errorMessage.getText();
	}
	
	public void virtualConnectionCreatedSuccessfullyMessage() {
	String portcreate=	portcreatedSuccesMessage.getText();
	if(portcreate.equals("Port created!")) {
	WebElement SuccessfullyMessage=CommonUtilities.ElementToBeClickable(vCCreatedSuccessfullyMessage, 4);
	SuccessfullyMessage.click();
		}else {
			System.out.println("Port Is not Created" );
		}
	}

}
