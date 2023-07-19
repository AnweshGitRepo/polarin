package lightstorm.polarin.objectRepositories;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lightstorm.polarin.testBase.TestBase;
import lightstorm.polarin.utility.CommonUtilities;

public class SubscriptionsAndInvoicesPage extends TestBase {
	static String serchBytext;
	
    @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiTab-root MuiTab-textColorPrimary Mui-selected css-11rf4w']")
    private WebElement subscriptionsBtn;
    
    @FindBy(xpath ="//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedStart css-1ixds2g']")
    private WebElement searchTextBox;
   
    @FindBy(xpath="(//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-formControl css-18zet09'])[1]")
    private WebElement sortBySpecificOrder;
    
    @FindBy(xpath = "//li[@class='MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters css-1hdmjwj']")
    List<WebElement> allSortByorderAndProductTypeOrd;
   
    @FindBy(xpath = "(//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-formControl css-18zet09'])[2]")
    private WebElement searchByProductType;
    
   // @FindBy(xpath = "//li[@class='MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters css-1hdmjwj']")
   // List<WebElement> allproductType;
    
    @FindBy(xpath="")
    private WebElement searchBySelectingDatec;
    
    @FindBy(xpath="//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-formControl css-9iusu2']")
    private WebElement searchByBillingProfile;
    
    @FindBy(xpath = "")
    List<WebElement> allBillingprofile;
    
    @FindBy(xpath="//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-formControl css-596chp']")
    private WebElement searchByTearm;
   
    @FindBy(xpath = "//*[@class='MuiTypography-root MuiTypography-body1 MuiListItemText-primary css-kcm22x']")
    List<WebElement> allSearchTearm;
    
    @FindBy(xpath = "//input[@class='PrivateSwitchBase-input css-1m9pwf3']")
    private WebElement tearmCheckBox;
    
    @FindBy(xpath="//button[contains(text(),'Clear')]") 
    private WebElement clearButton;
    
    @FindBy(xpath="//table[@class='MuiTable-root css-skdle8']/tbody/tr/td[1]")
    private List<WebElement> allSubscriptions;
    
    /*******************************Invoice*************************************/
    @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiTab-root MuiTab-textColorPrimary css-11rf4w']")
    private WebElement clickOnInvoiceBtn;
    
    @FindBy(xpath = "//div[@class='MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input css-13fl7lf']")
    private WebElement invoiceSortingByOrder;
    
    //@FindBy(xpath="")
	public SubscriptionsAndInvoicesPage() {
	PageFactory.initElements(driver,this);
	}
	
	public void clickOnsubscriptionsBtn() throws InterruptedException {
	 WebElement subscriptionsButton=CommonUtilities.ElementToBeClickable(subscriptionsBtn, 5);
		subscriptionsButton.click();
	}
	public void searchByEnteredText(String serchBytext) throws InterruptedException {
	CommonUtilities.sendkeys(searchTextBox, serchBytext);
	Thread.sleep(1000);
	for(int i=0;i<allSubscriptions.size();i++) {
		String allsub=allSubscriptions.get(0).getText();
		
		if(allsub.contains(serchBytext)) {
			System.out.println("Search string found in the first cell of row " + i);
           // break; // If found, you can break out of the loop or perform further actions
		}else {
			System.out.println("Search Content not Found on First Index");
		}
		}
	}
	
	/*
	 * public void verifySearchElementIsworkingOrNot(String subcription) { for(int
	 * i=0;i<allSubscriptions.size();i++) { String
	 * allsub=allSubscriptions.get(0).getText(); System.out.println(allsub); }
	 * 
	 * 
	 * 
	 * }
	 */
	public void searchBySorting(String sorting) throws InterruptedException{
	sortBySpecificOrder.click();
	for(WebElement allSorting : allSortByorderAndProductTypeOrd ) {   
		  String sort= allSorting.getText();
		  if(sort.equals(sorting)) {
			  allSorting.click();
			  break;
		  }
	  System.out.println(sort); }
	Thread.sleep(1000);
	}
	public void searchByproductType(String byProduct) throws InterruptedException {
	searchByProductType.click();
	for(WebElement allProduct : allSortByorderAndProductTypeOrd ) {  
		  String product= allProduct.getText();
		  if(product.equals(byProduct)) {
			  allProduct.click();
			  break;
		  }
	  System.out.println(product); }
	Thread.sleep(1000);
	}
	public void searchBybillingProfile() throws InterruptedException {
	searchByBillingProfile.click();	
	Thread.sleep(1000);
	}
	
	public void searchByTearm(String allbytearm ) throws InterruptedException {
    searchByTearm.click();
    Thread.sleep(1000);
    for(WebElement allTearmsSort : allSearchTearm ) {  
		  String tearms= allTearmsSort.getText();
		  if(tearms.equals(allbytearm)) {
			  allTearmsSort.click();
			  break;
		  }
	  System.out.println(tearms); }
    Thread.sleep(1000);
	}
	
	public void clearAllSorting() throws InterruptedException {
		//Thread.sleep(1000);
	WebElement clearbutton=	CommonUtilities.ElementToBeClickable(clearButton, 5);
	clearbutton.click();
	}
	/*******************************Invoice*************************************/
	public void clickOnInvoiceButton() throws InterruptedException {
	WebElement clickOnInvoiceButton=CommonUtilities.ElementToBeClickable(clickOnInvoiceBtn, 5);
	clickOnInvoiceButton.click();
	//Thread.sleep(1000);
	}
	public void invoiceSearchBySortingOrder(String invSorting) throws InterruptedException {
	invoiceSortingByOrder.click();
	for(WebElement allSorting : allSortByorderAndProductTypeOrd ) {   
		  String sort= allSorting.getText();
		  if(sort.equals(invSorting)) {
			  allSorting.click();
			  break;
		  }
	  System.out.println(sort); }
	Thread.sleep(1000);	
	}
	public void invoiceSearchByDate() {
		
	}
	public void invoiceSearchByStatus(String allbyStatus) throws InterruptedException {
	searchByBillingProfile.click();
	 for(WebElement allStatusSort : allSearchTearm ) {  
		  String status= allStatusSort.getText();
		  if(status.equals(allbyStatus)) {
			  allStatusSort.click();
			  break;
		  }
	  System.out.println(status); }
   Thread.sleep(1000);	
	}
}
