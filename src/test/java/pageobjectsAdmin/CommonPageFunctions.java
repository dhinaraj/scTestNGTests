package pageobjectsAdmin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



/**
 * Created by Dhinakaran on 09/02/17.
 */

public class CommonPageFunctions {
	
	private WebDriver driver;
	
	public CommonPageFunctions(WebDriver driver) {
		this.driver = driver;
	}
	
	public String switchToNewWindow()
	{
		String parentWindow = driver.getWindowHandle();
		for(String winHandle : driver.getWindowHandles()){
			if(!winHandle.equals(parentWindow))
			{
			driver.switchTo().window(winHandle);
			}
		}
		
		return parentWindow;
	}
	
	public void focusOnParentWindow()
	{
		String parentWindow = driver.getWindowHandle();
		for(String winHandle : driver.getWindowHandles()){
			if(!winHandle.equals(parentWindow))
			{
			driver.switchTo().window(parentWindow);
			}
		}

	}
	
	
	public void closeNewWindowAndReturn(String parentWindow)
	{

			driver.close();
			driver.switchTo().window(parentWindow);

	}
	
	public boolean checkElementPresentByXpath(String elementId) {
        try {
        	driver.findElement(By.xpath(elementId));
            return true;

        } catch (Exception e) {
        	System.out.println("Element you are looking for is not present");
        	return false;
        }
    }
	
	public boolean checkElementPresentByLinkText(String elementId) {
        try {
        	driver.findElement(By.linkText(elementId));
            return true;

        } catch (Exception e) {
        	System.out.println("Element you are looking for is not present");
        	return false;
        }
    }
	

}
