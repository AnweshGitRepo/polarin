package lightstorm.polarin.testCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import lightstorm.polarin.objectRepositories.DashBoardPage;
import lightstorm.polarin.objectRepositories.LoginPage;
import lightstorm.polarin.objectRepositories.OrganizationProfilePage;
import lightstorm.polarin.objectRepositories.UserProfilePage;
import lightstorm.polarin.testBase.TestBase;

public class PolarinDashBoardTest extends TestBase {
	DashBoardPage dashboard;
	LoginPage loginpage;
	UserProfilePage userprofile;
	OrganizationProfilePage organizationprof;

	public PolarinDashBoardTest() {
		super();	
	}
	@BeforeClass(enabled=false)
	public void setUp() throws InterruptedException {
		browserOpen();
		loginpage=new LoginPage();
	    dashboard=loginpage.valid_Credentials_login(prop.getProperty("loginUsername"), prop.getProperty("loginPassword"));
	}
	@Test
	public void verifyHomePageTitle() {
		dashboard.verifiedCorrectUserName();	
	}
	@Test(enabled = false)
	public void verifyUserProfileLink() throws InterruptedException {
		userprofile=dashboard.clickOnUserMyProfileBtn();	
	}
	
	@Test(enabled = false)
	public void verifyOrganizationprofileLink() throws InterruptedException {
		organizationprof=dashboard.clickOnOrganizationBtn();
	}
	@AfterClass(enabled = false)
	public void browserClose() {
	driver.close();	
	}
	
}
