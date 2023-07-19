package lightstorm.polarin.objectRepositories;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lightstorm.polarin.testBase.TestBase;

public class ApprovedOrganisationProfilePage extends TestBase {
	@FindBy(xpath = "//h5[contains(text(),'Profile Approved')]")
	private WebElement checkOrganizationProfileIsApproved;

	@FindBy(xpath = "(//*[@class='MuiTypography-root MuiTypography-body1 css-35fpnk'])[1]")
	private WebElement getcountryText;

	@FindBy(xpath = "(//*[@class='MuiTypography-root MuiTypography-body1 css-35fpnk'])[2]")
	private WebElement getLegalEntityText;

	@FindBy(xpath = "(//*[@class='MuiTypography-root MuiTypography-body1 css-35fpnk'])[3]")
	private WebElement getOrgNameText;

	@FindBy(xpath = "(//*[@class='MuiTypography-root MuiTypography-body1 css-35fpnk'])[4]")
	private WebElement getOrgAddressText;

	@FindBy(xpath = "(//*[@class='MuiTypography-root MuiTypography-body1 css-35fpnk'])[5]")
	private WebElement getOrgCityText;

	@FindBy(xpath = "(//*[@class='MuiTypography-root MuiTypography-body1 css-35fpnk'])[6]")
	private WebElement getOrgStateText;

	@FindBy(xpath = "(//*[@class='MuiTypography-root MuiTypography-body1 css-35fpnk'])[7]")
	private WebElement getPostalCodeText;
	/********************************************
	 * Authorised Signatory Details
	 *********************************/
	@FindBy(xpath = "(//*[@class='MuiTypography-root MuiTypography-body1 css-35fpnk'])[8]")
	private WebElement getAuthorisedSingNameText;

	@FindBy(xpath = "(//*[@class='MuiTypography-root MuiTypography-body1 css-35fpnk'])[9]")
	private WebElement getAuthorisedSingEmailText;

	public ApprovedOrganisationProfilePage() {
		PageFactory.initElements(driver, this);
	}

	public String checkorganizationProfileIsApprovide() {
		return checkOrganizationProfileIsApproved.getText();
	}

	public String getCountryName() {
		return getcountryText.getText();
	}

	public String getLegalEntity() {
		return getLegalEntityText.getText();
	}

	public String getOrgName() {
		return getOrgNameText.getText();
	}
	
	public String getOrgAddress() {
		return getOrgAddressText.getText();
	}
	
	public String getOrgCity() {
		return getOrgCityText.getText();
	}
	
	public String getOrgState() {
		return getOrgStateText.getText();
	}
	
	public String getOrgPostalCode() {
		return getPostalCodeText.getText();
	}
	public String getAuthSignName() {
		return getAuthorisedSingNameText.getText();
	}
	
	public String getAuthSignEmail() {
		return getAuthorisedSingEmailText.getText();
	}

}
