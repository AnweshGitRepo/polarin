package lightstorm.polarin.testCases;



import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import lightstorm.polarin.objectRepositories.DashBoardPage;
import lightstorm.polarin.objectRepositories.LoginPage;
import lightstorm.polarin.testBase.TestBase;

public class PolarinLoginTest extends TestBase {
	
  public LoginPage loginpage;
  public DashBoardPage dashboard;
	
	public PolarinLoginTest() {
		super();	
	}
	@BeforeClass
	public void setUp() {
		browserOpen();
		loginpage=new LoginPage();
		}
	
	@Test(priority=1)
	public void verify_Blank_login_Details() {
		loginpage.blankCreadencialEnter();
		loginpage.clickOnSignInButton();
		String blankEmailErrMsg=loginpage.blankEmailErrorMsg();
		Assert.assertEquals(blankEmailErrMsg, "Email cannot be blank");
		String blankPasswordErrMsg=loginpage.blankPasswordErrorMsg();
		Assert.assertEquals(blankPasswordErrMsg, "Invalid password");
	}
	@Test(priority = 2)
	public void verify_Invalid_Login_Details() throws InterruptedException {
		loginpage.inValid_Credentials_login("anwesh@gmail.com", "Password@123");	
		loginpage.clickOnSignInButton();
		String errormsg=loginpage.errormessage();
		Assert.assertEquals(errormsg, "User email or password is incorrect");
		loginpage.refreshBrowser();
	}
	@Test (priority = 3)
	public void verify_valid_Login_details() throws InterruptedException {
		dashboard=loginpage.valid_Credentials_login(prop.getProperty("loginUsername"), prop.getProperty("loginPassword"));
	}
	@AfterClass
	public void close_browser() {
		driver.close();	
	}
}
