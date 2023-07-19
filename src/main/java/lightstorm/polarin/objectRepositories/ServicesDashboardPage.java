package lightstorm.polarin.objectRepositories;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lightstorm.polarin.testBase.TestBase;
import lightstorm.polarin.utility.CommonUtilities;

public class ServicesDashboardPage extends TestBase {
	
	@FindBy(xpath="//table[@class='MuiTable-root css-1is2ke3']/tbody/tr/td[2]")
	private List<WebElement> getAllPortName;
	
	@FindBy(xpath="//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-nzhjjn']")
	private List<WebElement> clickthreeDotButton;
	
	@FindBy(xpath="//*[@class='MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters css-1mlwp09']")
	private List<WebElement> afterClickThreeDotMenu;
	
	@FindBy(xpath="//div/input[@id=':r23:']")
	private WebElement searchBoxtext;
	
	@FindBy(xpath="(//div[@class='MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input css-13fl7lf'])[2]")
	private WebElement clickOnLocationDropdown;
	
	@FindBy(xpath="")
	private WebElement elqe;
	@FindBy(xpath="")
	private WebElement eqle;
	@FindBy(xpath="")
	private WebElement elre;
	@FindBy(xpath="")
	private WebElement elie;
	
	

	public ServicesDashboardPage() {PageFactory.initElements(driver, this);}
	
	public void movetoelement() {
        new Actions(driver).moveToElement(searchBoxtext).perform();
	}
	
	public void serachDataInToSearchBar(String serchText) {
		CommonUtilities.sendkeys(searchBoxtext, serchText);
		for (int i = 1; i <= getAllPortName.size()-1; i++) {
			String allsub = getAllPortName.get(1).getText();
			if (allsub.contains(serchText)) {
				System.out.println("Search string found in the first cell of row " + i);
				 break; // If found, you can break out of the loop or perform further actions
			} else {
				System.out.println("Search Content not Found on First Index");
			}
		}
	}
	
	public void getAllCreatedPorts(String createdPort) {
		 for(WebElement allPortNames : getAllPortName ) {  
			  String port= allPortNames.getText();  
			  System.out.println(port);
			  if(port.equals(createdPort)) {
			  }
	     }
	}
	
	public void clickOnThreeDot(int num){
		for(int i=1;i<clickthreeDotButton.size()-1;i++) {	
		 clickthreeDotButton.get(num).click();
		}	
	}
	
	public void getTheAllActionsPerformAfterClickThreeDot(String selectAction ) {
		for(WebElement allActions:afterClickThreeDotMenu) {
			String actions=allActions.getText();
			System.out.println(actions);
			if(actions.equals(selectAction)) {	
			}
		}	
	}
}
