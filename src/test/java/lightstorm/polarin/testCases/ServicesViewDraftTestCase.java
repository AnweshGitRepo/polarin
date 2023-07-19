package lightstorm.polarin.testCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import lightstorm.polarin.objectRepositories.DashBoardPage;
import lightstorm.polarin.objectRepositories.LoginPage;
import lightstorm.polarin.objectRepositories.ServicesViewDraftPage;
import lightstorm.polarin.testBase.TestBase;
//import lightstorm.polarin.utility.SoftAssertUtil;

/**
 * 
 * @author ValueLabs
 * <h1>Service Page Test Case</h1>
 * <p>Purpose: This Class Is use For Write Test Case on Service Page functionality</p>
 *
 */

public class ServicesViewDraftTestCase extends TestBase {
	LoginPage loginpage;
	DashBoardPage dashboard;
	ServicesViewDraftPage serviceviewdraftpage;

	public ServicesViewDraftTestCase() {
		super();
	}

	@BeforeClass
	public void setUp() throws InterruptedException {
		browserOpen();
		loginpage = new LoginPage();
		dashboard = loginpage.valid_Credentials_login(prop.getProperty("loginUsername"),
				prop.getProperty("loginPassword"));
		serviceviewdraftpage = dashboard.clickOnServiceviewDraftPage();
		//SoftAssertUtil.initializeSoftAssert();
	}

	@Test(priority=1)
	public void verify_that_user_should_be_able_to_see_all_Port_which_is_created_by_user_and_able_to_search_perticular_port_In_View_Draft() throws InterruptedException {
		serviceviewdraftpage.clickOnViewDraftButton();
		serviceviewdraftpage.selectPort();
		//servicepage.selectPortVRouterVConnection("Virtual Routers");
		serviceviewdraftpage.serachDataInToSearchBar("TestPortSix");
		serviceviewdraftpage.clickOnClearButton();
    	serviceviewdraftpage.searchByperticularSortingOrder("Sort New-Old");
		 
	}
	@Test(priority=2)
	public void verify_that_user_should_be_able_to_see_all_Virtual_Router_which_is_created_by_user_and_able_to_search_perticular_Virtual_Router_On_View_Draft() {
		serviceviewdraftpage.selectVirtulRouter();
		//servicepage.selectPortVRouterVConnection("Port");
		serviceviewdraftpage.serachDataInToSearchBar("Testing All");
		serviceviewdraftpage.clickOnClearButton();
		serviceviewdraftpage.searchByperticularSortingOrder("Sort New-Old");
	}
	
	@Test(priority=3)
	public void verify_that_user_should_be_able_to_see_all_Virtual_Connection_which_is_created_by_user_and_able_to_search_perticular_virtual_Connection_on_View_Draft() {
		serviceviewdraftpage.selectVirtualConnection();
		//servicepage.selectPortVRouterVConnection("Virtual Connections");	
		serviceviewdraftpage.serachDataInToSearchBar("VConeectionthree");
		serviceviewdraftpage.clickOnClearButton();
		serviceviewdraftpage.searchByperticularSortingOrder("Sort New-Old");	
	}
	
	@Test(priority = 4)
	public void verify_that_user_can_able_to_go_back_to_service_page() {
		serviceviewdraftpage.clickOnGoBackToServiceScreen();
	}
	
	@AfterClass
	public void closebrowser(){
		//driver.close();
	}
}
