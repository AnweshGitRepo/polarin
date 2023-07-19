package lightstorm.polarin.utility;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import org.openqa.selenium.WebElement;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import java.awt.AWTException;
import java.awt.Robot;
import lightstorm.polarin.testBase.TestBase;

public class UploadFileClass extends TestBase {

	public static void uploadfileUsingSendKeys(WebElement element,String pathOfFile) {
		element.sendKeys(pathOfFile);	
	}
	public static void uploadFileUsingRobotClass(String imagepath) throws  InterruptedException {
		StringSelection strSel=new StringSelection(imagepath);
		Clipboard clipboardr=Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboardr.setContents(strSel,null);
		// Create an Object for Robot class
		Robot robot=null;
		try {
	    robot=new Robot();
		} catch(AWTException awt) {
	    	awt.printStackTrace();
	    }
		robot.delay(250);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(150);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	   // robot.delay(150);
	    System.out.println("File Uploaded Successfully");
	 }
	}
