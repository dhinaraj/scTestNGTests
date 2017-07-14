package pageobjectsAdmin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReferralMapPage {

	private WebDriver driver;
	private By referralNetworLink = By.xpath("html/body/div[3]/div[1]/div/ul/li[6]/a/span[1]");
	private By referralMapLink = By.xpath("html/body/div[3]/div[1]/div/ul/li[6]/ul/li[1]/a");
	private By userName = By.xpath("html/body/div[3]/div[2]/div/div/form/div[1]/div/input");
	private By levelsToShow = By.xpath("html/body/div[3]/div[2]/div/div/form/div[2]/div/input");
	
	public ReferralMapPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void showReferralListing() {
		driver.findElement(referralNetworLink).click();
		driver.findElement(referralMapLink).click();
		driver.findElement(userName).sendKeys("514226");
		driver.findElement(levelsToShow).click();
	}
	
	
}