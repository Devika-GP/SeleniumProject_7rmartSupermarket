package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;


public class FileUploadUtility {
	public void fileUploadUsingSendkeys(WebElement element, String filepath) {
		element.sendKeys(filepath);
	}
	
	public void fileUploadUsingRobotClass(WebElement element, String path) throws AWTException {
		
		//to store file path, we use StringSelection class
		//it stores file path as text
		StringSelection filepath = new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null); //to copy filepath to clipboard (same as ctrl+C)
		
		//robot class-> to perform keyboard actions
		Robot r = new Robot();
		r.delay(2500); //time to upload
		
		//to press ctrl + v, pressing each key one after one
		r.keyPress(KeyEvent.VK_CONTROL); //pressing Ctrl key
		r.keyPress(KeyEvent.VK_V); //pressing V key
		
		//releasing keys one by one
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		
		//pressing enter to upload file
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
}
