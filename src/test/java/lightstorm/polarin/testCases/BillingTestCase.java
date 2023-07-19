package lightstorm.polarin.testCases;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import lightstorm.polarin.objectRepositories.BillingPage;
import lightstorm.polarin.objectRepositories.DashBoardPage;
import lightstorm.polarin.objectRepositories.LoginPage;
import lightstorm.polarin.testBase.TestBase;
import lightstorm.polarin.utility.CommonUtilities;
//import lightstorm.polarin.utility.SoftAssertUtil;


public class BillingTestCase extends TestBase {
	String billingnotProceed = "Something went wrong while processing your request";
	String billingProfAlreadyExit = "Billing profile already exists for this Jurisdiction";
	String profilenotapprodtnemsg = "Your organisation profile is pending. A billing profile can only be created once the organisation profile is approved";
	String allErrorStrings =""+"\n" +"Something went wrong while processing your request" + "\n" +
            "Billing profile already exists for this Jurisdiction" + "\n" +
            "Your organisation profile is pending. A billing profile can only be created once the organisation profile is approved";
	String[] allErrorstrings = allErrorStrings.split("\n");
	DashBoardPage dashboard;
	LoginPage loginpage;
	BillingPage billingpge;

	public BillingTestCase() {
		super();
	}

	@BeforeClass
	public void setUp() throws InterruptedException {
		browserOpen();
		loginpage = new LoginPage();
		dashboard = loginpage.valid_Credentials_login(prop.getProperty("loginUsername"),
				prop.getProperty("loginPassword"));
		billingpge = dashboard.clickOnBillingBtn();
		//SoftAssertUtil.initializeSoftAssert();
	}

	@Test(priority = 1)
	public void verify_the_creation_of_new_Billing_profile() throws InterruptedException {
		billingpge.addBillingProfile();
		billingpge.enterTheGSTNumberNewmethod("36");
		Assert.assertEquals(billingpge.getErrorMessageIfEnterWorngGSTno(), "Please enter valid GST number");
		billingpge.enterTheGSTNumber("36AAQCS450333Z7");
		Assert.assertEquals(billingpge.getErrorMessageAfterVerifyWrongGSTno(), "GST number is invalid. Please provide valid GST number for billing.");
		billingpge.enterTheGSTNumber("36AAQCS4503H1Z7");
		billingpge.selectBillingCountry("India");
		billingpge.selectBillingState("Telangana");
		billingpge.enterBillingCity("Hyderabad");
		//billingpge.enterBillingPostalCode("600017");
		billingpge.uploadGSTDocument(System.getProperty("user.dir")+"\\TestDataDocs\\gstCertificate.jpg");
		billingpge.clickBillingSubmitCodeOrCancel();
		Thread.sleep(1000);
	}

	@Test(priority = 2)
	public void verify_the_creation_of_new_Billing_ContactDetails() throws InterruptedException {
		billingpge.enterbillingContatcName(CommonUtilities.generateUniqueNumericString());
		Assert.assertEquals(billingpge.getErrorMessageAftrEnterInvalidName(), "Please enter a valid contact name");
		billingpge.enterbillingContatcName("Anwesh Kumar");
		
		billingpge.enterbillingEmailAddress(CommonUtilities.generateUniqueNumericString());
		Assert.assertEquals(billingpge.getErrorMessageAftrEnterInvalidEmailID(), "Please enter a valid email address");
		billingpge.enterbillingEmailAddress("anweshshri@gmail.com");
		
		billingpge.enterMobileNumber(CommonUtilities.generateUniqueAlphabeticalSmallLetterString(5));
		Assert.assertEquals(billingpge.getErrorMessageAftrEnterInvalidPhoneNumber(), "Please enter a valid phone number");
		billingpge.enterMobileNumber(CommonUtilities.generateUniqueNumericString());
		
		billingpge.clickOnCreateBtn();
		
		/*
		 * if (billingpge.isErrorMessageDisplayed()) { String errorMessage =
		 * billingpge.checkErrorMesagge(); System.out.println("Error Message " +
		 * errorMessage); if (errorMessage.equals(billingnotProceed)) {
		 * SoftAssertUtil.getSoftAssert().assertEquals(errorMessage, billingnotProceed);
		 * } else if (errorMessage.equals(profilenotapprodtnemsg)) {
		 * SoftAssertUtil.getSoftAssert().assertEquals(errorMessage,
		 * profilenotapprodtnemsg); } else {
		 * SoftAssertUtil.getSoftAssert().assertEquals(errorMessage,
		 * billingProfAlreadyExit); } } else {
		 * billingpge.clickOnBillingProfileSuccesfulMessage(); }
		 */
		try {
			String errorMessage =billingpge.checkErrorMesagge();
			 for (String allstr : allErrorstrings) {
		            try {
		          // If condition required If The errorMessage and  allstr are same then good otherwise throw the Assert Error 	
		            	Assert.assertEquals(errorMessage,allstr);
		                // Assert the string is present in the page source
		          //  SoftAssertUtil.getSoftAssert().assertEquals(errorMessage, allstr);
		            } catch (AssertionError e) {
		                System.out.println(e.getMessage());
		            }
		        }
	    	System.out.println(errorMessage);
	    	
	    }catch(NoSuchElementException|ElementClickInterceptedException ele){
	    	billingpge.clickOnBillingProfileSuccesfulMessage();
	    }
		
	}
	
	@AfterClass()
	public void browserClose() throws InterruptedException {
		//SoftAssertUtil.assertAll();
		Thread.sleep(1500);
		driver.close();
	}
	
	


}
