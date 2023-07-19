package lightstorm.polarin.testCases;
import org.openqa.selenium.WebElement;
/**
 * 
 * @author ValueLabs
 * <h1>Service Page Test Case</h1>
 * <p>Purpose: This Class Is use For Write Test Case on Service Page functionality</p>
 *
 */
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import lightstorm.polarin.objectRepositories.DashBoardPage;
import lightstorm.polarin.objectRepositories.LoginPage;
import lightstorm.polarin.objectRepositories.ServicesDashboardPage;
import lightstorm.polarin.testBase.TestBase;
//import lightstorm.polarin.utility.SoftAssertUtil;

public class ServicesDashboardTestCase extends TestBase {
	LoginPage loginpage;
	DashBoardPage dashboard;
	ServicesDashboardPage servicepage;
	public ServicesDashboardTestCase() {
		super();
	}
	@BeforeClass
	public void setUp() throws InterruptedException {
		browserOpen();
		loginpage = new LoginPage();
		dashboard = loginpage.valid_Credentials_login(prop.getProperty("loginUsername"),
				prop.getProperty("loginPassword"));
		servicepage = dashboard.clickOnServicePage();
		//SoftAssertUtil.initializeSoftAssert();	
		}
	
	@Test
	public void verify_that_user_should_be_able_to_see_all_Port_which_is_created_by_user_and_able_to_search_perticular_port_On_Service_Page() throws InterruptedException {
		//servicepage.movetoelement();
		servicepage.serachDataInToSearchBar("PortNameNewfive");
		//servicepage.getAllCreatedPorts("PortNameNewfive");
		servicepage.clickOnThreeDot(1);
		Thread.sleep(2000);
		servicepage.getTheAllActionsPerformAfterClickThreeDot("Add Connection");
	}
	
	@Test
	public void verify_that_user_should_be_able_to_see_all_Virtual_Router_which_is_created_by_user_and_able_to_search_perticular_Virtual_Router_On_Service_Page() {
		
	}
	
	@Test
	public void verify_that_user_should_be_able_to_see_all_Virtual_Connection_which_is_created_by_user_and_able_to_search_perticular_virtual_Connection_on_Service_Page() {
	
		
	}
	@AfterClass
	public void closeBrowser() {
		
			
		
	}
	
	
	
}
