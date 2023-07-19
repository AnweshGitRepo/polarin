package lightstorm.polarin.testCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import lightstorm.polarin.objectRepositories.DashBoardPage;
import lightstorm.polarin.objectRepositories.LoginPage;
import lightstorm.polarin.objectRepositories.SubscriptionsAndInvoicesPage;
import lightstorm.polarin.testBase.TestBase;

public class SubscriptionsAndInvoicesTestCase extends TestBase {
	DashBoardPage dashboard;
	LoginPage loginpage;
	SubscriptionsAndInvoicesPage subscribandinvoice;
	public SubscriptionsAndInvoicesTestCase() {
		super();
	}
	
	@BeforeClass
	public void setUp() throws InterruptedException {
		browserOpen();
		loginpage=new LoginPage();
	    dashboard=loginpage.valid_Credentials_login(prop.getProperty("loginUsername"), prop.getProperty("loginPassword"));
	    subscribandinvoice=dashboard.clickOnSubscriptionAndInvoiceBtn();
	}
	@Test(priority = 1,enabled = true)
	public void verify_user_can_search_subscription_using_different_search_criteria() throws InterruptedException {
		subscribandinvoice.clickOnsubscriptionsBtn();
	}
	
	@Test(priority = 2,enabled = true)
	public void verify_user_can_search_subscription_using_search_TextBox_criteria() throws InterruptedException {
		subscribandinvoice.searchByEnteredText("HelloTest");
		subscribandinvoice.clearAllSorting();
	}
	@Test(priority = 3,enabled = true)
	public void verify_user_can_search_subscription_using_search_Alphabet_Order_Or_Old_and_new_Order_criteria() throws InterruptedException {
		subscribandinvoice.searchBySorting("Sort New-Old");
		subscribandinvoice.clearAllSorting();
	}
	
	@Test(priority = 4,enabled = true)
	public void verify_user_can_search_subscription_using_product_Type_criteria() throws InterruptedException {
		subscribandinvoice.searchByproductType("Virtual Connection");
		subscribandinvoice.clearAllSorting();
	}
	
	@Test(priority = 5,enabled = true)
	public void verify_user_can_search_subscription_using_Billing_Profile_criteria() {	
		
	}
	
	@Test(priority = 6,enabled = true)
	public void verify_user_can_search_subscription_using_Tearm_criteria() throws InterruptedException {
		subscribandinvoice.searchByTearm("12 Months");
		driver.navigate().refresh();
	}
	
	@Test( priority = 7, enabled = true)
	public void verify_user_can_search_Invoice_using_search_TextBox_criteria() throws InterruptedException {
		subscribandinvoice.clickOnInvoiceButton();
		subscribandinvoice.searchByEnteredText("anwesh.gs@lightstorm.in");
	}
	
	@Test(priority =8)
	public void verify_user_can_search_Invoice_using_search_Alphabet_Order_Or_Old_and_new_Order_criteria() throws InterruptedException {
		subscribandinvoice.invoiceSearchBySortingOrder("Sort Z-A");
		subscribandinvoice.clearAllSorting();
	}
	@Test( priority = 9, enabled = true)	
	public void verify_user_can_Search_Invoice_using_Status_criteria() throws InterruptedException {
		subscribandinvoice.invoiceSearchByStatus("Pending");
		driver.navigate().refresh();	
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}
	
}
