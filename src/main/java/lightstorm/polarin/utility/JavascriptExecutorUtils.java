package lightstorm.polarin.utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import lightstorm.polarin.testBase.TestBase;

public class JavascriptExecutorUtils extends TestBase {

	public static void clickElementByJavaScript(WebElement elemenet) {
		JavascriptExecutor jsExecute=(JavascriptExecutor)driver;
		jsExecute.executeScript("arguments[0].click()", elemenet);
	}
	
	public static void sendElementByJavaScript(WebElement element){
		
	}
	
}
