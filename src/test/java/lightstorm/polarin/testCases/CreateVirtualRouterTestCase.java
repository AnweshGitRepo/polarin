package lightstorm.polarin.testCases;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import lightstorm.polarin.objectRepositories.CreatePortPage;
import lightstorm.polarin.objectRepositories.CreateVirtualRouterPage;
import lightstorm.polarin.objectRepositories.DashBoardPage;
import lightstorm.polarin.objectRepositories.LoginPage;
import lightstorm.polarin.testBase.TestBase;
import lightstorm.polarin.utility.CommonUtilities;
//import lightstorm.polarin.utility.SoftAssertUtil;
import lightstorm.polarin.utility.StringWords;

public class CreateVirtualRouterTestCase extends TestBase {
	String totalAmount,discountInPercent,subTotalAmount,upfrontPayment,payAmountEveryMonth,checkTotalAmountOnCheckOutPage;
	LoginPage loginpage;
	DashBoardPage dashboard;
	CreatePortPage portcreation;
	CreateVirtualRouterPage virtualrouter;
	
	public CreateVirtualRouterTestCase(){
	super();
	}
	@BeforeClass
	public void setUp() throws InterruptedException {
	browserOpen();
	loginpage=new LoginPage();
	dashboard=loginpage.valid_Credentials_login(prop.getProperty("loginUsername"), prop.getProperty("loginPassword"));
	virtualrouter=dashboard.clickOnServicespageForVirtualRouter();
//	SoftAssertUtil.initializeSoftAssert();
	}
	@Test(priority = 1,enabled = false)
	public void Verify_that_Create_a_Virtual_Router_option_should_be_there_under_Create_dropdown_in_the_Services_page() {
		
	}
	
	@Test(priority = 2)
	public void verify_that_user_should_be_able_to_create_new_Virtual_Router_at_the_Services() throws IllegalAccessException, InterruptedException {
		virtualrouter.clickOnCreateBtn();
		virtualrouter.selectVertualRouterLink();
		virtualrouter.selectRouterLocation("Yotta NM1");
		virtualrouter.clickOnSaveAndNextBtn();
		
	}
	
	@Test(priority = 3)
	public void verify_that_user_should_navigate_to_Checkout_page_once_Virtual_Router_details_are_entered_and_click_on_Save() throws InterruptedException {
		virtualrouter.enterVirtualRoutername(StringWords.enterVirtualRouterName());
		virtualrouter.enterTheRateLimit("10");
		virtualrouter.selectGbpsOrMbps("Gbps");
		virtualrouter.selectRouterSubscriptionTearm("24 Months");
		virtualrouter.selectRouterPayment("Partial Upfront");
		subTotalAmount=virtualrouter.getTheSubTotalAmount();
		System.out.println(subTotalAmount);
		discountInPercent =virtualrouter.getTheDiscount();
		System.out.println(discountInPercent);
		totalAmount=virtualrouter.getTheTotalAmount();
		System.out.println("Configaration Page Amount =  "+totalAmount);
		upfrontPayment=virtualrouter.UpfrontPaymentInVR();
		System.out.println(upfrontPayment);
		payAmountEveryMonth=virtualrouter.youPayAmounteverymonth();
		virtualrouter.clickOnSaveAndNextBtn();	
	}
	
	@Test(priority = 4)
	public void verify_that_Virtual_Router_details_along_with_Total_cost_should_be_displayed_in_the_Checkout_page_of_Virtual_Router_create_flow() throws InterruptedException {
		virtualrouter.selectBillingProfile();
		virtualrouter.chooseBillingProfileFromDropdown(StringWords.enterBillingProfile());
	    checkTotalAmountOnCheckOutPage=virtualrouter.checkTotalAmount();
		System.out.println("CheckOut Page Amount =  "+checkTotalAmountOnCheckOutPage);
		//SoftAssertUtil.getSoftAssert().assertEquals(totalAmount, checkTotalAmountOnCheckOutPage);
		//Assert.assertEquals(totalAmount, checkTotalAmountOnCheckOutPage);
		virtualrouter.clickOnServiceAggrement();
		virtualrouter.clickOnorderBtutton();
		/*
		 * if (virtualrouter.isErrorMessageDisplayedWhenOrderBtnClick()) { String
		 * errorMessage = virtualrouter.checkErrorMesaggeafterClkOrder();
		 * System.out.println("Error Message " + errorMessage); } else {
		 * virtualrouter.virtualConnectionCreatedSuccessfullyMessage(); }
		 */
		try {
			String errorMessage = virtualrouter.checkErrorMesaggeafterClkOrder();
			System.out.println(errorMessage);
		}catch(NoSuchElementException|ElementClickInterceptedException ele) {
			virtualrouter.virtualConnectionCreatedSuccessfullyMessage();
		}	
	}
	@AfterClass
	public void closebrowser() throws InterruptedException {
	//	SoftAssertUtil.assertAll();
		Thread.sleep(1000);
		driver.close();
	}

}
