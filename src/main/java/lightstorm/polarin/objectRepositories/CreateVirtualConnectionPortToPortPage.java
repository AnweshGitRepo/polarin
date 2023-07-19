package lightstorm.polarin.objectRepositories;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import lightstorm.polarin.testBase.TestBase;
import lightstorm.polarin.utility.CommonUtilities;
import lightstorm.polarin.utility.JavascriptExecutorUtils;

public class CreateVirtualConnectionPortToPortPage extends TestBase {
	WebDriverWait wait;

	@FindBy(xpath = "//button[text()='Create']")
	private WebElement clickOnCreateButton;

	@FindBy(xpath = "//p[contains(text(),' Create a Virtual Connection')]")
	private WebElement clickOnVirtualConnection;

	@FindBy(xpath = "//button[@value='PORT']")
	private WebElement selectPortA;

	@FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-1vyru6r']")
	private List<WebElement> allPort;

	@FindBy(xpath = "//button[text()='Next']")
	private WebElement nextButton;

	// @FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiCardActionArea-root
	// css-17ssz3p'])[1]")
	// private WebElement selectPortB;

	@FindBy(name = "name")
	private WebElement virtualConnectionName;

	@FindBy(name = "speed")
	private WebElement enterSpeed;

	@FindBy(xpath = "//input[@class='MuiSwitch-input']")
	private WebElement advanceSettingSwitchBtn;

	@FindBy(xpath = "//*[contains(text(),'Untagged')]")
	private WebElement vLANTypeUntagged;

	@FindBy(xpath = "//*[contains(text(),'Trunk')]")
	private WebElement vLANTypeTrunk;

	@FindBy(xpath = "//button[contains(text(),'Months')]")
	private List<WebElement> selectSubscriptionTerm;

	@FindBy(xpath = "//button[contains(text(),'PAYG')]")
	private WebElement clickOnPAYGSubscriptionTerm;
	// @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiToggleButton-root
	// MuiToggleButton-sizeMedium MuiToggleButton-standard
	// MuiToggleButtonGroup-grouped MuiToggleButtonGroup-groupedHorizontal
	// css-480ex8']")
	// private List<WebElement> allsubscriptionterm;

	@FindBy(xpath = "//button[contains(text(),'Upfront')]")
	private List<WebElement> selectPaymentOption;

	@FindBy(xpath = "(//*[@class='MuiTypography-root MuiTypography-h5 css-g1mnfr'])[2]")
	private WebElement subTotalForMonth;

	@FindBy(xpath = "(//*[@class='MuiTypography-root MuiTypography-h5 css-g1mnfr'])[4]")
	private WebElement totalAmount;

	@FindBy(xpath = "(//*[@class='MuiTypography-root MuiTypography-body2 css-cnyufv'])[2]")
	private WebElement upfrontPayment;

	@FindBy(xpath = "(//*[@class='MuiTypography-root MuiTypography-body2 css-cnyufv'])[4]")
	private WebElement youPayAmountEveryMonth;
	/**********************************
	 * Billing Profile Page
	 *************************/
	/*
	 * @FindBy(
	 * xpath="(//*[@class='MuiTypography-root MuiTypography-h4 css-1hibme8'])[1]")
	 * private WebElement clickOnAEndDetailsDropDown;
	 */

	@FindBy(xpath = "//*[@class='MuiTypography-root MuiTypography-h4 css-1hibme8']")
	private List<WebElement> clickOnDropDown;

	@FindBy(xpath = "(//*[@class='MuiTypography-root MuiTypography-h5 css-7n7i1w'])[4]")
	private WebElement youPayAmt;

	@FindBy(xpath = "(//*[@class='MuiTypography-root MuiTypography-h5 css-7n7i1w'])[10]")
	private WebElement aEndDetailsAmount;

	@FindBy(xpath = "(//*[@class='MuiTypography-root MuiTypography-h5 css-7n7i1w'])[16]")
	private WebElement bEndDetailsAmount;
	
	@FindBy(xpath="(//input[@type='text'])[1]")
	private WebElement clickOnBillingprofilefirst;
	
	@FindBy(xpath="(//input[@type='text'])[2]")
	private WebElement clickOnBillingprofileSecond;
	
	@FindBy(xpath="//input[@type='checkbox']")
	private WebElement checkBoxClickAggrement;
	/***************************************************************/

	public CreateVirtualConnectionPortToPortPage() {
		PageFactory.initElements(driver, this);
	}

	public void clickOnCreateButton() throws InterruptedException {
		try {
			clickOnCreateButton.click();
		} catch (StaleElementReferenceException element) {
			clickOnCreateButton.click();
			element.printStackTrace();
		}
		Thread.sleep(1000);
	}

	public void selectTheVirtualConnection() throws InterruptedException {
		clickOnVirtualConnection.click();
		Thread.sleep(1000);
	}

	public void selectOrigintypePortOrPortA() throws InterruptedException {
		// selectPortA.click();
		JavascriptExecutorUtils.clickElementByJavaScript(selectPortA);
		Thread.sleep(1500);
	}

	public void selectPortAfromAllList(String textToClick) throws InterruptedException, IllegalAccessException {
		List<WebElement> allText = allPort;
		for (WebElement text : allText) {
			if (text.getText().equals(textToClick)) {
				text.click();
				break;
			}
			System.out.println(text);
		}
	}

	public void clickOnNextButton() {
		try {
			WebElement nextButtonEle = CommonUtilities.ElementToBeClickable(nextButton, 5);
			nextButtonEle.click();
		} catch (ElementClickInterceptedException e) {
			e.printStackTrace();
			System.out.println("Element is not Visible");
		}
	}

	public void virtualConnectionDetailsName(String connectionName) {
		CommonUtilities.sendkeys(virtualConnectionName, connectionName);
	}

	public void enterSpeed(String speedno) {
		CommonUtilities.sendkeys(enterSpeed, speedno);
	}

	public void selectVLANType(String selectVLANTtype) {
		if (vLANTypeUntagged.getText().equalsIgnoreCase(selectVLANTtype)) {
			vLANTypeUntagged.click();
		} else if (vLANTypeTrunk.getText().equalsIgnoreCase(selectVLANTtype)) {
			vLANTypeTrunk.click();
		}
	}

	public void selectSubscriptionTerm(String allSbuscriptionVC) {
		for (WebElement allSubscriptionVCr : selectSubscriptionTerm) {
			String subscriptionRouter = allSubscriptionVCr.getText();
			String getPAYGtext = clickOnPAYGSubscriptionTerm.getText();
			if (subscriptionRouter.equals(allSbuscriptionVC)) {
				allSubscriptionVCr.click();
				break;
			} else if (getPAYGtext.equals(allSbuscriptionVC)) {
				clickOnPAYGSubscriptionTerm.click();
			}
			System.out.println(subscriptionRouter);
		}

	}

	public void selectPayment(String paymentselection) {
		for (WebElement allPaymentVC : selectPaymentOption) {
			String paymentVC = allPaymentVC.getText();
			if (paymentVC.equals(paymentselection)) {
				allPaymentVC.click();
				break;
			}
			System.out.println(paymentVC);
		}

	}

	public String subtotalforPerticularMonths() throws InterruptedException {
		Thread.sleep(1500);
		return subTotalForMonth.getText();
	}

	public String TotalAmount() throws InterruptedException {
		Thread.sleep(1000);
		return totalAmount.getText();
	}

	public String upfrontPayment() throws InterruptedException {
		Thread.sleep(1000);
		return upfrontPayment.getText();
	}

	public String youPayAmountEveryMonth() {
		return youPayAmountEveryMonth.getText();
	}

	/***********************
	 * Billing profile
	 *********************************************/

	public void clickOnDropDowan(String clickDropDown) {
		for (WebElement allPaymentVC : clickOnDropDown) {
			String paymentVC = allPaymentVC.getText();
			if (paymentVC.equals(clickDropDown)) {
				allPaymentVC.click();
				break;
			}
			System.out.println(paymentVC);
		}
	}
	
	public String getVCYouPayAmount() {
		return youPayAmt.getText();
	}

	public String AEndDetailsAmount() {
		return aEndDetailsAmount.getText();
	}

	public String BEndDetailsAmount() {
		return bEndDetailsAmount.getText();
	}

	public void chooseBillingProfileFromGivenBills() {
	// choose Billing Profile code need here 
    }
	
	public void clickOnUserAggrementCheckBox() throws InterruptedException {
		Thread.sleep(1000);
		checkBoxClickAggrement.click();
	}
}
