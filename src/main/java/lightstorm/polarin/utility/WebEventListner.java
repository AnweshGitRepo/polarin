package lightstorm.polarin.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import lightstorm.polarin.testBase.TestBase;

public class WebEventListner extends TestBase implements WebDriverEventListener {

	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Before Navigation :"+url);
		// TODO Auto-generated method stub
		
	}
	public void afterNavigateTo(String URL, WebDriver driver) {
		System.out.println("After Navigation :"+URL);
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	
	public void afterNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Finding Element  :"+by.toString());
		// TODO Auto-generated method stub
		
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Found The Element :"+by.toString());
		// TODO Auto-generated method stub
		
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("Clicking on element: "+element+"==="+element.toString());
		// TODO Auto-generated method stub
		
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("Clicked on element: "+element+"==="+element.toString());
		// TODO Auto-generated method stub
		
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		System.out.println("Value of the "+element.toString()+"before any changes made");
		
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		System.out.println("Element Value Changed to: "+element.toString());
		
	}

	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	
	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	
	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void onException(Throwable throwable, WebDriver driver) {
		
		System.out.println("Exception Occured :" + throwable);
		try {
			CommonUtilities.takeScreenShotAtEndOfTheTest();
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
	}

	public void beforeGetText(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterGetText(WebElement element, WebDriver driver, String text) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		// TODO Auto-generated method stub
		
	}

}
