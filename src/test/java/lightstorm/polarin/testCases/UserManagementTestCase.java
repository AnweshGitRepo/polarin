package lightstorm.polarin.testCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import lightstorm.polarin.objectRepositories.DashBoardPage;
import lightstorm.polarin.objectRepositories.LoginPage;
import lightstorm.polarin.objectRepositories.UserManagementPage;
import lightstorm.polarin.testBase.TestBase;

public class UserManagementTestCase extends TestBase {
	DashBoardPage dashboard;
	LoginPage loginpage;
	UserManagementPage usermanage;
	public UserManagementTestCase() {super();}
	
	@BeforeClass
	public void setUp() throws InterruptedException {
		browserOpen();
		loginpage=new LoginPage();
	    dashboard=loginpage.valid_Credentials_login(prop.getProperty("loginUsername"), prop.getProperty("loginPassword"));
	    usermanage=dashboard.clickOnUserManagementBtn();
	}
	
	@Test(priority = 1,enabled = true)
	public void verify_that_user_can_Add_User_and_can_be_set_role() {
		usermanage.clickOnAddUserBtn();
		usermanage.enterValidEmailId("anwesh.gs+8@lightstorm.in");
		usermanage.selectRoleForUser("Finance Admin");
		usermanage.clickOnSendInvitation();
		usermanage.clickOnDiscartBtn();	
		usermanage.useraddedsuccessfully();
	}
	
	@Test(priority = 2 ,enabled= true)
	public void verify_That_user_can_see_all_user_on_user_management() {
		usermanage.searchUserByRole("System Admin");
		usermanage.searchUserBySorting("Sort New-Old");
		usermanage.searchUserByEmailId("anwesh.gs+8@lightstorm.in");
		usermanage.clearSearchArea();
	}
	@AfterClass
	public void browserClose() {
		//driver.close();
	}
	
}
