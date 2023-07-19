package lightstorm.polarin.testCases;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import lightstorm.polarin.objectRepositories.CreatePortPage;
import lightstorm.polarin.objectRepositories.CreateVirtualRouterPage;
import lightstorm.polarin.objectRepositories.DashBoardPage;
import lightstorm.polarin.objectRepositories.LoginPage;
import lightstorm.polarin.testBase.TestBase;
//import lightstorm.polarin.utility.SoftAssertUtil;
import lightstorm.polarin.utility.StringWords;

public class CreatePortTestCase extends TestBase {

	String subTotalMonthWise, diccountonPayment, totalAmountafterDiscount, upfrontPayment, youPayAmountMonthWise,
			totalAmountbeforDiscount, totalAmountOnCheckOutPage;

	LoginPage loginpage;
	DashBoardPage dashboard;
	CreatePortPage portcreation;
	CreateVirtualRouterPage virtualrouter;

	public CreatePortTestCase() {
		super();
	}

	@BeforeClass
	public void setUp() throws InterruptedException {
		browserOpen();
		loginpage = new LoginPage();
		dashboard = loginpage.valid_Credentials_login(prop.getProperty("loginUsername"),
				prop.getProperty("loginPassword"));
		portcreation = dashboard.clickOnServicesForPort();
		// SoftAssertUtil.initializeSoftAssert();
		virtualrouter = new CreateVirtualRouterPage();
	}

	@Test(priority = 1)
	public void verify_that_Create_a_Port_option_should_be_there_under_Create_dropdown_in_the_Services_page() {
		try {
			portcreation.clickOnCreateBtn();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		portcreation.selectCreatePortLink();
	}

	@Test(priority = 2)
	public void verify_that_user_should_be_able_to_select_location_and_Next_button_should_be_enabled_immediately()
			throws InterruptedException, IllegalAccessException {
		// portcreation.selectPortLocation();
		// portcreation.getSearchResultText("CtrlS Bengaluru DC");
		portcreation.clickOnSearchResult(StringWords.enterTheActivePortLocation());
		portcreation.clickOnSaveAndNextBtn();
	}

	@Test(priority = 3)
	public void verify_the_details_that_user_should_provide_under_Create_a_Port_section() throws InterruptedException {
		portcreation.enterPortNameinTextBox(StringWords.enterThePortName());
		
		try {
			String errormessage = portcreation.getUniqueNameErrorMessage();
			System.out.println(errormessage);
			int index1 = 3;
			while (index1 > 0) {
				System.out.println("Errror Message"+errormessage);	
					if (errormessage.equals("Port name must be unique")) {
						portcreation.enterPortNameinTextBox(StringWords.enterThePortName());
					Thread.sleep(2000);
					System.out.println("enter the send Port name ");
						portcreation.clickOnSaveAndNextBtn();
						System.out.println("Click On next button ");
						index1--;
						System.out.println("While got called " + index1);
						continue;
					} else {
						break;
					}
			} 
		}catch (NoSuchElementException ele) {
				System.out.println("There is no Error Message");
			}
			
			/*for (int i = 0; i < 2; i++) {
				if (errormessage.equals("Port name must be unique")) {
					portcreation.enterPortNameinTextBox(StringWords.enterThePortName());
					break;
				} else {
					System.out.println("Got unique Port");
				}
			}
		} catch (NoSuchElementException ele) {
			System.out.println("There is no Error Message");
		}*/
		 
		portcreation.selectPortSpeed("10 GE");
		portcreation.selectSubscriptionterm("12 Months");
		portcreation.selectPayment("No Upfront");
		subTotalMonthWise = portcreation.subTotalFromMonthWise();
		System.out.print("Subtotal for 12 Months: = " + subTotalMonthWise);
		totalAmountbeforDiscount = portcreation.totalAmountWithOutDiscounted();
		System.out.println("****************Total Amount of Disc  " + totalAmountbeforDiscount);
		diccountonPayment = portcreation.paymentDiscount();
		System.out.println(diccountonPayment);
		totalAmountafterDiscount = portcreation.totalAmountAfterDiscount();
		System.out.print("Total: = " + totalAmountafterDiscount);
		upfrontPayment = portcreation.upfrontPayment();
		System.out.println(upfrontPayment);
		youPayAmountMonthWise = portcreation.youPayAmounteverymonth();
		System.out.println("Payment Wise Amount = " + youPayAmountMonthWise);
		portcreation.clickOnSaveAndNextBtn();
		/*
		 * try { String portExistErrorMsg = portcreation.getErrorIfPortIsAlreadyExit();
		 * int index = 3; while (index > 0) {
		 * System.out.println("Errror Message"+portExistErrorMsg); if
		 * (portExistErrorMsg.equals("Port already exist")) {
		 * portcreation.enterPortNameinTextBox(StringWords.enterThePortName());
		 * Thread.sleep(2000); System.out.println("enter the send Port name ");
		 * portcreation.clickOnSaveAndNextBtn();
		 * System.out.println("Click On next button "); index--;
		 * System.out.println("While got called " + index); continue; } else { break; }
		 * } } catch (NoSuchElementException ele) {
		 * System.out.println("Got The Unique Port");
		 * 
		 * }
		 */
		
	}
	@Test(priority = 4, enabled = false)
	public void verify_that_user_should_be_able_to_select_Billing_Profile_in_the_Checkout_page()
			throws InterruptedException {
		portcreation.selectBillingProfile(StringWords.enterBillingProfile());
	}

	@Test(priority = 5,enabled = false)
	public void verify_that_Port_details_along_with_Total_cost_should_be_displayed_in_the_Checkout_page_of_Port_create_flow()
			throws InterruptedException {
		portcreation.clickOnPortDetails();
		totalAmountOnCheckOutPage = portcreation.totalAmountOnCheckOutPage();
		System.out.println("CheckOut Amount = " + totalAmountOnCheckOutPage);
		// SoftAssertUtil.getSoftAssert().assertEquals(totalAmountbeforDiscount,
		// totalAmountOnCheckOutPage);
		portcreation.clickOnIAggreementBtnAndOrderPlaced();
		/*
		 * if (virtualrouter.isErrorMessageDisplayedWhenOrderBtnClick()) { String
		 * errorMessage = virtualrouter.checkErrorMesaggeafterClkOrder();
		 * System.out.println("Error Message " + errorMessage); } else {
		 * virtualrouter.virtualConnectionCreatedSuccessfullyMessage(); }
		 */
		try {
			String errorMessage = virtualrouter.checkErrorMesaggeafterClkOrder();
			System.out.println(errorMessage);
		} catch (NoSuchElementException | ElementClickInterceptedException ele) {
			virtualrouter.virtualConnectionCreatedSuccessfullyMessage();
		}

	}

	@AfterClass
	public void closeBrowser() {
		// SoftAssertUtil.assertAll();
		// driver.close();
	}
}
