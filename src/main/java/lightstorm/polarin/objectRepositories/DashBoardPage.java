package lightstorm.polarin.objectRepositories;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import lightstorm.polarin.testBase.TestBase;
import lightstorm.polarin.utility.CommonUtilities;

public class DashBoardPage extends TestBase {
	WebDriverWait wait;
	/****************************************************/
	@FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-1257hhi']")
	private WebElement userNameLabel;
	@FindBy(xpath = "(//p[@class='MuiTypography-root MuiTypography-body1 css-s5ze71'])[1]")
	private WebElement CloudToCloudConnection;
	@FindBy(xpath = "(//p[@class='MuiTypography-root MuiTypography-body1 css-s5ze71'])[2]")
	private WebElement DCToCloudConnection;
	@FindBy(xpath = "(//p[@class='MuiTypography-root MuiTypography-body1 css-s5ze71'])[3]")
	private WebElement DCToDC_Connection;
	@FindBy(xpath = "(//p[@class='MuiTypography-root MuiTypography-body1 css-s5ze71'])[4]")
	private WebElement internetExchConnction;
	/***************************
	 * SideBarNavigation
	 *****************************************************/

	@FindBy(xpath = "//div[@class='MuiBox-root css-15illud']")
	private WebElement sideBarNavigationCloseBtn;
	@FindBy(xpath = "(//*[@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-1in44b7'])[1]")
	private WebElement userProfile;
	@FindBy(xpath = "(//*[@class='MuiTypography-root MuiTypography-body1 css-92pcgx'])[1]")
	private WebElement personalDetails;
	@FindBy(xpath = "(//div[@class='MuiListItemIcon-root css-qwko1u'])[4]")
	private WebElement billingMainEle;
	@FindBy(xpath = "(//*[contains(text(),'Billing')])[2]")
	private WebElement billingChildEle;
	@FindBy(xpath = "(//div[@class='MuiListItemIcon-root css-qwko1u'])[3]")
	private WebElement organizationProfile;
	@FindBy(xpath = "//*[contains(text(),'User Management')]")
	private WebElement userManagement;
	@FindBy(xpath = "(//*[@class='MuiTypography-root MuiTypography-body1 MuiListItemText-primary css-1i73w6w'])[1]")
	private WebElement organizationProfilechildtab;
	@FindBy(xpath = "(//div[@class='MuiListItemIcon-root css-qwko1u'])[2]")
	private WebElement activeLogs;
	@FindBy(xpath = "(//div[@class='MuiListItemIcon-root css-qwko1u'])[1]")
	private WebElement services;
	@FindBy(xpath = "(//div[@class='MuiListItemText-root css-tuasyg'])[2]")
	private WebElement childSubscriptionsAndInvoicesBtn;

	public DashBoardPage() {
		PageFactory.initElements(driver, this);
	}

	public String DashboardPageTitle() {
		return driver.getTitle();
	}

	public boolean verifiedCorrectUserName() {
		return userNameLabel.isDisplayed();
	}

	public UserProfilePage clickOnUserMyProfileBtn() throws InterruptedException {
		userProfile.click();
		Thread.sleep(500);
		personalDetails.click();
		return new UserProfilePage();
	}

	public OrganizationProfilePage clickOnOrganizationBtn() throws InterruptedException {
		organizationProfile.click();
		Thread.sleep(500);
		organizationProfilechildtab.click();
		return new OrganizationProfilePage();
	}

	public UserManagementPage clickOnUserManagementBtn() {
		organizationProfile.click();
		userManagement.click();
		return new UserManagementPage();
	}

	public BillingPage clickOnBillingBtn() throws InterruptedException {
		billingMainEle.click();
		Thread.sleep(1000);
		billingChildEle.click();
		return new BillingPage();
	}

	public SubscriptionsAndInvoicesPage clickOnSubscriptionAndInvoiceBtn() throws InterruptedException {
		billingMainEle.click();
		Thread.sleep(500);
		childSubscriptionsAndInvoicesBtn.click();
		return new SubscriptionsAndInvoicesPage();
	}

	public CreatePortPage clickOnServicesForPort() {
		services.click();
		return new CreatePortPage();
	}
	public ServicesViewDraftPage clickOnServiceviewDraftPage() {
	WebElement servicesviewDraftpage=CommonUtilities.ElementToBeClickable(services, 5);
		servicesviewDraftpage.click();
		return new ServicesViewDraftPage();
	}
	
	public ServicesDashboardPage clickOnServicePage() {
	WebElement servicespage=CommonUtilities.ElementToBeClickable(services, 5);	
	servicespage.click();
	return new ServicesDashboardPage();
	}

	public CreateVirtualRouterPage clickOnServicespageForVirtualRouter() {
		services.click();
		return new CreateVirtualRouterPage();
	}

	public CreateVirtualConnectionPortToPortPage clickOnServicePageForVertualConnection() {
		services.click();
		return new CreateVirtualConnectionPortToPortPage();
	}
	
	public ServiceCreationPage clickOnServicePageForShowAllServiceCreation() {
	 WebElement showAllServicePage=CommonUtilities.ElementToBeClickable(services, 5);
      showAllServicePage.click();
 return new ServiceCreationPage();
	}

}
