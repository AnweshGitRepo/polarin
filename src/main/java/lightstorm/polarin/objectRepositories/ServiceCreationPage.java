package lightstorm.polarin.objectRepositories;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lightstorm.polarin.testBase.TestBase;
import lightstorm.polarin.utility.CommonUtilities;

public class ServiceCreationPage extends TestBase {
	@FindBy(xpath="//p[text()='Show all services']")
	private WebElement selectShowAllServices;
	
	@FindBy(xpath="//div/span[@class='MuiTypography-root MuiTypography-body2 MuiCardHeader-title css-1ib10wz']")
	private List<WebElement> allServiceCreationList;
	
	@FindBy(xpath="(//button[text()='Get Started'])[3]")
	private WebElement getStartButton;
	
	@FindBy(xpath="(//button[text()='Cancel'])[5]")
	private WebElement clickOnCancelButton;
	
	@FindBy(xpath="")
	private WebElement elemiet;
	
	@FindBy(xpath="")
	private WebElement elqemeet;
	
	@FindBy(xpath="")
	private WebElement eleqmet;
	
	@FindBy(xpath="")
	private WebElement elemeqt;
	
	public ServiceCreationPage() {PageFactory.initElements(driver, this);}
	
	public void selectShowAllService() {
	WebElement clickonShowAllmenu=	CommonUtilities.ElementToBeClickable(selectShowAllServices, 3);
	clickonShowAllmenu.click();
	}

	public void selectServices(String sel){
		List<WebElement> allText = allServiceCreationList;
		for (WebElement text : allText) {
			if (text.getText().equals(sel)) {
				text.click();
				break;
			}
			System.out.println(allText);
		}
	}
		
	}
	
	
	

