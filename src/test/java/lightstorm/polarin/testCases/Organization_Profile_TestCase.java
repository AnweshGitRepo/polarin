package lightstorm.polarin.testCases;

import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import lightstorm.polarin.objectRepositories.ApprovedOrganisationProfilePage;
import lightstorm.polarin.objectRepositories.DashBoardPage;
import lightstorm.polarin.objectRepositories.LoginPage;
import lightstorm.polarin.objectRepositories.OrganizationProfilePage;
import lightstorm.polarin.objectRepositories.UserProfilePage;
import lightstorm.polarin.testBase.TestBase;
//import lightstorm.polarin.utility.SoftAssertUtil;
import lightstorm.polarin.utility.UploadFileClass;

public class Organization_Profile_TestCase extends TestBase {
    String checkProfileIsApproved;
	DashBoardPage dashboard;
	LoginPage loginpage;
	OrganizationProfilePage organizationprofile;
	ApprovedOrganisationProfilePage approvedorgprofile;
	
	public Organization_Profile_TestCase() {super();}
	
	@BeforeClass
	public void setUp() throws InterruptedException {
		browserOpen();
		loginpage=new LoginPage();
	    dashboard=loginpage.valid_Credentials_login(prop.getProperty("loginUsername"), prop.getProperty("loginPassword"));
	    organizationprofile=dashboard.clickOnOrganizationBtn();
	    approvedorgprofile=new ApprovedOrganisationProfilePage();
	}
	@Test(priority = 1,dependsOnMethods = "precondition", enabled = true)
	public void verify_that_Organization_Details_are_created_under_Organization_profile() throws InterruptedException {
		organizationprofile.clickOnCompleteProfileOrganizationBtn();
		organizationprofile.enterTheLegalEntity("TestOrganization Pvt Ltd");
		organizationprofile.enterMobileNumber("9822113300");
		organizationprofile.enterthePanDetailsOfOrganization("AERFR734AW");
		organizationprofile.uploadProofOfIdentity(System.getProperty("user.dir")+"\\TestDataDocs\\pancard.png");
		organizationprofile.clickOnSaveAndNextButtonOrCancelButtonOfOrgDetails();
		organizationprofile.clickOnOrgDetilsSuccesfulyUpdatedBtn();
	}
	@Test(priority = 2,dependsOnMethods = "precondition", enabled= true)
	public void verify_that_Organization_Address_details_are_created_under_Organization_profile() throws InterruptedException {
		organizationprofile.clickOnAddressButtonOrEditButton();
		organizationprofile.registerAddress("High Tech City Gachiboli");
		organizationprofile.enterCountry(prop.getProperty("Organization_Address_country"));
		organizationprofile.enterTheState(prop.getProperty("Organization_Address_State"));
		organizationprofile.enterTheCity("Hyderabad");
		organizationprofile.enterThePostalCode("400005");
		organizationprofile.removeUploadedAddressProofFile();
		if(prop.getProperty("Organization_Address_country").equals("India")) { 
	    organizationprofile.uploadAddressProof(System.getProperty("user.dir")+"\\TestDataDocs\\addressproof.jpg");
		}else{
	    organizationprofile.uploadAddressProof(System.getProperty("user.dir")+"\\TestDataDocs\\addressproof.jpg");
	    organizationprofile.uploadDeclarationDocument(System.getProperty("user.dir")+"\\TestDataDocs\\DeclarationDoc.png");
		}
		//organizationprofile.AddresssaveAndNextBtnOrCancelBtn();
	}
	@Test(priority = 3,dependsOnMethods = "precondition",enabled = true)
	public void verify_that_Authorized_Signatory_details_are_created_under_Organization_profile() throws InterruptedException{
		organizationprofile.clickOnauthorizedSignatoryEditBtn();
		organizationprofile.enterTheAuthorizedSignatoryName("Sathish Kumar");
		organizationprofile.enterTheAuthorizedSignatoryEmailId("sathish.kumar@gmail.com");
		organizationprofile.enterTheAuthorizedSignatoryPhoneNumber("9870823652");
		organizationprofile.selectTheAuthorizedSignatoryDocumetType("Aadhaar");
		organizationprofile.enterTheAuthorizedSignatoryDocumetNumber("12341234512345");
		organizationprofile.clickOnAuthorizedSignatoryLetterofAuthorization(System.getProperty("user.dir")+"\\TestDataDocs\\Letter_of_Authorization.pdf");
		organizationprofile.clickOnAuthorizedSignatoryProofofIdentity(System.getProperty("user.dir")+"\\TestDataDocs\\ProofofIdentity.jpg");
		organizationprofile.clickOnAuthorizedSignatoryUpdateButtons();	
	}
	
	@Test(priority = 4)
	public void verify_That_organization_Details_are_able_to_See_After_Profile_Created() {
	    checkProfileIsApproved=approvedorgprofile.checkorganizationProfileIsApprovide();
		System.out.println("Check the Profile ApprovedOrNot = "+checkProfileIsApproved);
		
		String printCountryName=approvedorgprofile.getCountryName();
		System.out.println("Country  = "+printCountryName);
		
		String printLegalEntity=approvedorgprofile.getLegalEntity();
		System.out.println("Legal Entity = "+printLegalEntity);
		
		String printOrganizationName=approvedorgprofile.getOrgName();
 		System.out.println("Organisation Name = "+printOrganizationName);
 		
 		String printOrganizationAddress =approvedorgprofile.getOrgAddress();
		System.out.println("Organisation Address  = "+printOrganizationAddress);
		
		String printOrgCity=approvedorgprofile.getOrgCity();
		System.out.println("Organisation City = "+printOrgCity);
 		
		String prinytOrgState=approvedorgprofile.getOrgState();
		System.out.println("Organisation State = "+prinytOrgState);
		
		String printOrgPostalCode=approvedorgprofile.getOrgPostalCode();
		System.out.println("Organisation Postal Code = "+printOrgPostalCode);
	}
	@Test(priority = 5)
	public void verify_That_Authorised_Signatory_Details_are_able_to_See_After_Profile_Created() {
		String PrintAuthorisedSignatoryName=approvedorgprofile.getAuthSignName();
		System.out.println("Authorised Signatory Name = "+PrintAuthorisedSignatoryName);
		
		String printeAuthorisedSignatoryEmail=approvedorgprofile.getAuthSignEmail();
		System.out.println("Authorised Signatory Email = "+printeAuthorisedSignatoryEmail);
	}
	
	@Test
    public void precondition() {
        // If the condition is not met, throw an exception to fail the test
		
        if (!checkProfileIsApproved.equals("Profile Approved")) {
        	throw new SkipException("Condition not met, skipping further test cases.");
        }else {
        	System.out.println("Condition Met Execute All Create profile TestCase");
        }
        	
        }
	 
 @AfterClass
public void browserClose() throws InterruptedException{
	// SoftAssertUtil.assertAll();
	 Thread.sleep(1000);
	driver.close();
}
}
