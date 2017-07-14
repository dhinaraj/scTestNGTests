package pageobjectsMember;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class MemberLandingPage {
	protected WebDriver driver;
	
	private By popUpCloseButton = By.xpath(".//*[@id='basic']/div/div/div[3]/a");
	private By rewardsLink = By.xpath("//ul/li[3]/a/span[1]");
	private By crpReportLink = By.xpath("html/body/header/div[1]/nav/div[2]/ul/li[3]/ul/li[1]/a");
	private By profileLink = By.xpath("html/body/header/div[1]/nav/div[2]/ul/li[3]/ul/li[1]/a");
	private By logoutLink = By.xpath("html/body/header/div[1]/nav/div[2]/ul/li[3]/ul/li[1]/a");
	private String memberURL = "https://demometalk.plus65.local/user";
	
	public MemberLandingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void navigateToMemberURL() {
		driver.navigate().to(memberURL);;
	}
	
	public void closePopUpAfterLogin() {
		driver.findElement(popUpCloseButton).click();
	}

	
	public void clickOnRewards() {
		try {
			System.out.println("clicking on Rewards");
			WebElement rewardsLink1 = driver.findElement(rewardsLink);
			Actions builder = new Actions(driver);
			  Action mouseOverSubscription = builder
			          .moveToElement(rewardsLink1)
			          .build();
			mouseOverSubscription.perform();
			WebElement crpLink = driver.findElement(crpReportLink);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void MemberLogout(String memberURL) {
		driver.navigate().to(memberURL);;
	}
	
}
