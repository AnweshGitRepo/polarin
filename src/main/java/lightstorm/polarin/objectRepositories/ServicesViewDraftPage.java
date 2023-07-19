package lightstorm.polarin.objectRepositories;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lightstorm.polarin.testBase.TestBase;
import lightstorm.polarin.utility.CommonUtilities;

public class ServicesViewDraftPage extends TestBase {
	// @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiTab-root
	// MuiTab-textColorPrimary css-11rf4w']")
	// private List<WebElement> portVRouterVConnection;

	@FindBy(xpath = "//button[text()='Virtual Connection']")
	private WebElement selectVirtualConnction;

	@FindBy(xpath = "//button[text()='Port']")
	private WebElement selectPort;

	@FindBy(xpath = "//button[text()='Virtual Router']")
	private WebElement selectVirtualRouter;

	@FindBy(xpath = "//input[@type='text']")
	private WebElement searchTextBox;

	@FindBy(xpath = "(//div[@class='MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input css-13fl7lf'])[1]")
	private WebElement sortingByGivenOrder;

	@FindBy(xpath = "//li[@class='MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters css-1hdmjwj']")
	List<WebElement> allSortByOrderAndProductTypeOrd;

	@FindBy(xpath = "(//div[@class='MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input css-13fl7lf'])[2]")
	private WebElement searchByLocationName;

	@FindBy(xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-fullWidth css-a0mgr2']")
	private WebElement clearButton;

	@FindBy(xpath = "//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-nzhjjn']")
	private WebElement clickOnthreeDotsForEdit;

	@FindBy(xpath = "//li[@class='MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters css-1mlwp09']")
	private List<WebElement> editOptionsSelect;

	@FindBy(xpath = "//table[@class='MuiTable-root css-1is2ke3']//tbody/tr/td[2]")
	private List<WebElement> allNames;

	@FindBy(xpath = "//table[@class='MuiTable-root css-1is2ke3']//tbody/tr/td[8]")
	private List<WebElement> allthreeDots;

	@FindBy(xpath = "//table[@class='MuiTable-root css-1is2ke3']//tbody/tr/td[6]")
	private List<WebElement> allStatus;

	@FindBy(xpath = "//button[contains(text(),'View Draft')]")
	private WebElement clickOnViewDraft;

	@FindBy(xpath = "//button[@class='MuiButtonBase-root MuiTab-root MuiTab-textColorPrimary Mui-selected css-11rf4w']")
	private WebElement checkIfPortIsSelected;
	
	@FindBy(xpath="//button[text()='Go back to Services screen']")
	private WebElement clickOnGoBackToServiceScreen;

	public ServicesViewDraftPage() {
		PageFactory.initElements(driver, this);
	}

	/*
	 * public void selectPortVRouterVConnection(String searchPort) { for(WebElement
	 * allProduct : portVRouterVConnection ) { String product= allProduct.getText();
	 * if(product.equals(searchPort)) { allProduct.click(); break; }
	 * System.out.println(product); } }
	 */

	public void selectPort() {
		selectPort.click();
	}

	public void selectVirtulRouter() {
		selectVirtualRouter.click();
	}

	public void selectVirtualConnection() {
		selectVirtualConnction.click();
	}

	public void serachDataInToSearchBar(String serchText) {
		CommonUtilities.sendkeys(searchTextBox, serchText);
		for (int i = 0; i < allNames.size(); i++) {
			String allsub = allNames.get(0).getText();
			if (allsub.contains(serchText)) {
				System.out.println("Search string found in the first cell of row " + i);
				// break; // If found, you can break out of the loop or perform further actions
			} else {
				System.out.println("Search Content not Found on First Index");

			}
		}
	}

	public void searchByperticularSortingOrder(String sorting) {
		sortingByGivenOrder.click();
		for (WebElement allSorting : allSortByOrderAndProductTypeOrd) {
			String sort = allSorting.getText();
			if (sort.equals(sorting)) {
				allSorting.click();
				break;
			}
			System.out.println(sort);
		}
	}

	public void clickOnClearButton() {
		clearButton.click();
	}

	public void clickOnViewDraftButton() {
		WebElement viewDraftBtn = CommonUtilities.ElementToBeClickable(clickOnViewDraft, 3);
		viewDraftBtn.click();
	}
	
	public void clickOnGoBackToServiceScreen() {
		CommonUtilities.ElementToBeClickable(clickOnGoBackToServiceScreen, 3);
	}

}
