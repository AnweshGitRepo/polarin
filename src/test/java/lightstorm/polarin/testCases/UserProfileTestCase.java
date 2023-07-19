package lightstorm.polarin.testCases;

import java.awt.AWTException;
import java.net.SocketException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import lightstorm.polarin.objectRepositories.DashBoardPage;
import lightstorm.polarin.objectRepositories.LoginPage;
import lightstorm.polarin.objectRepositories.UserProfilePage;
import lightstorm.polarin.testBase.TestBase;
import lightstorm.polarin.utility.CommonUtilities;
//import lightstorm.polarin.utility.SoftAssertUtil;
import lightstorm.polarin.utility.UploadFileClass;

public class UserProfileTestCase extends TestBase {

	DashBoardPage dashboard;
	LoginPage loginpage;
	UserProfilePage userprofile;
	UploadFileClass uploadfile;
	
	public UserProfileTestCase() {super();}
	
	@BeforeClass
	public void setUp() throws InterruptedException {
		browserOpen();
		loginpage=new LoginPage();
	    dashboard=loginpage.valid_Credentials_login(prop.getProperty("loginUsername"), prop.getProperty("loginPassword"));
	    userprofile=dashboard.clickOnUserMyProfileBtn();
	  //  SoftAssertUtil.initializeSoftAssert();
	}
	@Test(priority = 1,enabled = true)
	public void verify_that_profile_picture_is_uploaded_successfully() throws InterruptedException, AWTException{
		userprofile.removeProfileImageButton();
		userprofile.clickOnUploadImageBtn();
		userprofile.clickdragAndDropImageBrowserBtn(System.getProperty("user.dir")+prop.getProperty("ProfileImagePath"));
		
	}
	@Test(priority = 2,enabled = true)
	public void verify_that_name_and_phone_number_are_updated_in_profile_page() throws InterruptedException {
		Thread.sleep(1500);
		userprofile.clickOnEditPersonalInformation();
		Thread.sleep(500);
		userprofile.enterNameInTextBox("");
		String errormsgenterblnkname=userprofile.getErrorMessageAfterEnterBlankName();
		System.out.println(errormsgenterblnkname);
		Assert.assertEquals(userprofile.getErrorMessageAfterEnterBlankName(), "name must be at least 2 characters");
		// SoftAssertUtil.getSoftAssert().assertEquals(errormsgenterblnkname, "name must be at least 2 characters");
		userprofile.enterNameInTextBox("anwesh Shrikhande");
		userprofile.enterThePhoneNumber(CommonUtilities.generateUniqueAlphabeticalSmallLetterString(5));
		String errormsgenterblnkPhno=userprofile.getErrorMessageAfterEnterBlankName();
		System.out.println(errormsgenterblnkPhno);
		Assert.assertEquals(errormsgenterblnkPhno, "Invalid Phone");
		//SoftAssertUtil.getSoftAssert().assertEquals(errormsgenterblnkPhno, "Invalid Phone");
		userprofile.enterThePhoneNumber(CommonUtilities.generateUniqueNumericString());
		userprofile.clickOnUpdateBtn();
	}
	@Test(priority = 3, enabled = true)
	public void verify_that_password_is_updated_in_Security_section_of_user_profile_page() throws InterruptedException {
		Thread.sleep(1500);
		userprofile.passwordInfoEditBtn();
		userprofile.enterOldPassword(prop.getProperty("New_Password"));
		userprofile.enterNewPassword(prop.getProperty("loginPassword"));
		userprofile.clickOnUpdateBtn();
		String errorMsgAftPutWrongPass=userprofile.errorMessageAfterWrongPass();
		System.out.println(errorMsgAftPutWrongPass);
		Assert.assertEquals(errorMsgAftPutWrongPass, "New password cannot be one of the 6 old passwords");
	//	SoftAssertUtil.getSoftAssert().assertEquals(errorMsgAftPutWrongPass, "Access denied for update password");
		userprofile.passwordEditCancelButton();
		userprofile.passwordInfoEditBtn();
		userprofile.enterOldPassword(prop.getProperty("loginPassword"));
		userprofile.enterNewPassword(prop.getProperty("New_Password"));
		//userprofile.clickOnUpdateBtn();
		userprofile.passwordEditCancelButton();
	}
	@AfterClass
	public void closeBrowser() {
	//	SoftAssertUtil.assertAll();
		driver.close();
		
	}
	
}
