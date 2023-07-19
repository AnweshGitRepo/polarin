package lightstorm.polarin.objectRepositories;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import lightstorm.polarin.testBase.TestBase;
import lightstorm.polarin.utility.CommonUtilities;

public class CreateVirtualConnectionPortToVirtualRouterPage extends TestBase {
	@FindBy(xpath = "//button/div/span[text()='Virtual Router']")
	private WebElement clickOnVirtualRouter;

	@FindBy(xpath = "//*[@class='MuiTypography-root MuiTypography-body1 css-1vyru6r']")
	private List<WebElement> chooseAnyOneVirtualRouterGivenList;

	/******************** BGP Peering *********************************/
	@FindBy(name = "peerIPV4Address")
	private WebElement enterPeerIPV4Address;

	@FindBy(name = "peerASN")
	private WebElement enterpeerASN;

	@FindBy(name = "bgpAuthenticationKey")
	private WebElement enterBGPAuthenticationKey;

	@FindBy(xpath = "//input[@class='MuiInputBase-input MuiInputBase-inputAdornedEnd css-mnn31']")
	private WebElement clickOnOriginBillingProfile;

	@FindBy(xpath = "(//input[@type='text'])[2]")
	private WebElement clickOnDestinationBillingProfile;

	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement checkBoxSelecting;

	@FindBy(xpath = "//input[@class='MuiInputBase-input MuiInputBase-inputAdornedStart MuiAutocomplete-input MuiAutocomplete-inputFocused css-mnn31']")
	private WebElement chooseBillingProfilefromDropdowan;

	public CreateVirtualConnectionPortToVirtualRouterPage() {
		PageFactory.initElements(driver, this);
	}

	public void clickOnVirtualRouterIcon() {
		clickOnVirtualRouter.click();
	}

	public void selectVirtualRouterfromDataCenter(String selVrouter) {
		List<WebElement> allText = chooseAnyOneVirtualRouterGivenList;
		for (WebElement text : allText) {
			if (text.getText().equals(selVrouter)) {
				text.click();
				break;
			}
			System.out.println(text);
		}
	}

	public void enterTheTextPeerIPV4Address(String iPAddress) {
		CommonUtilities.sendkeys(enterPeerIPV4Address, iPAddress);
	}

	public void enterThePeerASN(String peerAsn) {
		CommonUtilities.sendkeys(enterpeerASN, peerAsn);
	}

	public void enterBGPAuthenticationKey(String strBGPAuthetication) {
		CommonUtilities.sendkeys(enterBGPAuthenticationKey, strBGPAuthetication);
	}

	public void clickOnOriginBillingProfile() {
		clickOnOriginBillingProfile.click();
	}

	public void clickOnDestinationBillingAndChooseProfile(String selBillingProfileName) throws InterruptedException {
		if (clickOnDestinationBillingProfile.isDisplayed()) {
			clickOnDestinationBillingProfile.click();
			Thread.sleep(1000);
			CommonUtilities.sendkeys(chooseBillingProfilefromDropdowan, selBillingProfileName);
			chooseBillingProfilefromDropdowan.sendKeys(Keys.DOWN);
			Thread.sleep(500);
			chooseBillingProfilefromDropdowan.sendKeys(Keys.ENTER);
			// Code to select an option from the dropdown
		} else {
			// Handle the case when the dropdown is not visible
			System.out.println("Destination Billing profile is not shown for the ");
		}
	}

	public void selectCheckBox() {
		checkBoxSelecting.click();
	}

}
