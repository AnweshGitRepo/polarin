package lightstorm.polarin.testBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.codeborne.selenide.WebDriverRunner;

import io.github.bonigarcia.wdm.WebDriverManager;
import lightstorm.polarin.extentReport.ExtentReportNG;
import lightstorm.polarin.utility.CommonUtilities;
import lightstorm.polarin.utility.WebEventListner;


@SuppressWarnings("deprecation")
public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver edriver;
	public static WebEventListner eventlistner;
	public static final Logger logg=Logger.getLogger(TestBase.class.getName());
	

	public TestBase() {
		String fs = FileSystems.getDefault().getSeparator();
		String log4jConfigPath=System.getProperty("user.dir")+fs+"src"+fs+"main"+fs+"resources"+fs+"log4j"+fs+"log4j.properties";
		PropertyConfigurator.configure(log4jConfigPath);
		try {
			String getEnv=CommonUtilities.getEnvironment();
			//String getEnv=System.getProperty("env","uat");
			prop = new Properties();
			
			if(getEnv.equals("dev")) {
			FileInputStream file = new FileInputStream(System.getProperty("user.dir")
					+ fs+"src"+fs+"main"+fs+"resources"+fs+"config"+fs+"dev"+"_config.properties");
			prop.load(file);
			}else if(getEnv.equals("uat")) {
				FileInputStream file = new FileInputStream(System.getProperty("user.dir")
						+ fs+"src"+fs+"main"+fs+"resources"+fs+"config"+fs+"uat"+"_config.properties");
				prop.load(file);
			}
		} catch (FileNotFoundException f) {
			f.printStackTrace();
		} catch (IOException i) {
			i.printStackTrace();
		}
	}

	public void browserOpen() {
		String browsername=CommonUtilities.selectBrowser();
	//	String browsername = System.getProperty("browser", "chrome");
	//	String browsername = prop.getProperty("browser");
		if (browsername.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			logg.info("Launching Chrome Browser");
		} else if (browsername.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			logg.info("Launching FireFoxBrowser");
		} else if (browsername.equals("msedge")) {
			driver = WebDriverManager.edgedriver().create();
			logg.info("Launching Microsoft Edge Browser");
		} else if (browsername.equals("chromeheadless")) {
			logg.info("Launching HeadLess ChromeBrowser");
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("--disable-gpu");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("--remote-debugging-port=9222");
			driver = new ChromeDriver(options);
			WebDriverRunner.setWebDriver(driver);	
		}else
		{
			System.out.println("Please go to config property File and check whether you have given proper browser name or not");
			logg.error("The browser name is not specified correctly");
		}
		edriver = new EventFiringWebDriver(driver);
		eventlistner = new WebEventListner();
		edriver.register(eventlistner);
		driver = edriver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(CommonUtilities.PAGE_LOAD_TIME_OUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(CommonUtilities.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		logg.info("Launching Url");
	}

	
}
