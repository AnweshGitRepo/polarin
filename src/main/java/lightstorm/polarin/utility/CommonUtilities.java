package lightstorm.polarin.utility;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.Properties;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileInputStream;
import lightstorm.polarin.testBase.TestBase;

/**
 * @author Valuelabs
 * <h1> Common Functions</h1>
 * <p> purpose: This class is for common Functionality</p>
 * It is used to handle all the functionalities which can be used in other classes  
 *
 */

public class CommonUtilities extends TestBase {
	public static WebDriverWait wait;
	public static long PAGE_LOAD_TIME_OUT = 10;
	public static long IMPLICIT_WAIT = 10;
	
	// select Environment
	public static String getEnvironment() throws IOException {
		return  System.getProperty("env","uat") ;
	}
	// Select Browser 
	public static String selectBrowser() {
		return System.getProperty("browser", "chrome");
	}
	
	/**************************************************
	 * Sendkeys method Code
	 **************************************************/
	public static void sendkeys(WebElement element, String text) {
		// Select All String
		String selectstr = Keys.chord(Keys.CONTROL, "a");
		element.sendKeys(selectstr);
		// sending DELETE key
		element.sendKeys(Keys.DELETE);
		element.sendKeys(text);
	}

	/********************************************************
	 * Explicit Wait
	 *********************************************************/
	public static void setExplicitWait(Duration second) {
		wait = new WebDriverWait(driver, second);
	}

	/***********************************************************
	 * Screen Shot Code
	 *********************************************************/
	public static void takeScreenShotAtEndOfTheTest() {
		String fs = FileSystems.getDefault().getSeparator();
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		try {
			FileHandler.copy(scrFile, new File(currentDir +fs+"screenshot"+fs+ timestamp + "_screenshot.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/******************************************************
	 * Click On Element With Explicit wait
	 *******************************************************/
	public static WebElement ElementToBeClickable(WebElement ele, int time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	/*****************************************************
	 * Page Fully Loaded
	 ***************************************************/

	/*
	 * public static void waitForPageToLoad(WebElement element,long time) {
	 * ExpectedCondition<Boolean> pageLoadCondition = new
	 * ExpectedCondition<Boolean>() { public Boolean apply(WebDriver driver) {
	 * return ((JavascriptExecutor)
	 * driver).executeScript("return document.readyState").equals("complete"); } };
	 * wait = new WebDriverWait(driver, Duration.ofSeconds(time));
	 * wait.until(ExpectedConditions.visibilityOf(element)); }
	 */
	/***********************************************************
	 * Generate The Random Alphabetical String
	 ***********************************************************/
	public static String generateUniqueAlpahabeticalString(int len) {
		String uniqueName="Path"+RandomStringUtils.randomAlphabetic(len);
		return uniqueName;
	}
	
	/************************************************************
	 * Generate The Random Alphabetical Capital Letter String 
	 * ***********************************************************/
	 public static String generateUniqueAlphabeticalCapitalLetterString(int length){
	        StringBuilder sb = new StringBuilder();
	        Random random = new Random();
	        Set<Character> usedCharacters = new HashSet<>();

	        while (sb.length() < length) {
	            char randomChar = (char) (random.nextInt(26) + 'A'); // Generate a random uppercase letter

	            if (!usedCharacters.contains(randomChar)) {
	                sb.append(randomChar);
	                usedCharacters.add(randomChar);
	            }
	        }

	        return sb.toString();
	    }
	 
	 /**************************************************************
	  * Generate The Random Numeric Values
	  **************************************************************/
	 public static String generateUniqueNumericString() {
	        LocalDateTime now = LocalDateTime.now();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHH");
	        return now.format(formatter);
	    }
	 /**************************************************************
	  * Generate The Random Alphabetical Small Letter String 
	  **************************************************************/
	 public static String generateUniqueAlphabeticalSmallLetterString(int length) {
		 StringBuilder sb = new StringBuilder();
	        Random random = new Random();
	        Set<Character> usedCharacters = new HashSet<>();

	        while (sb.length() < length) {
	            char randomChar = (char) (random.nextInt(26) + 'a'); // Generate a random uppercase letter

	            if (!usedCharacters.contains(randomChar)) {
	                sb.append(randomChar);
	                usedCharacters.add(randomChar);
	            }
	        }
	        return sb.toString();
	 }
	 
	 
	 
}
