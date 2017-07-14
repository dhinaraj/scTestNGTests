package pageobjectsAdmin;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminBasePage {
	
	private WebDriver driver;
	
	
    private void enterMeTalkId(String id) { driver.manage().window().maximize();  driver.findElement(By.name("metalk_id")).sendKeys(id);}
    private void enterPassword(String password) {  driver.findElement(By.name("password")).sendKeys(password);}
    private void enterCaptcha(String captcha) {  driver.findElement(By.name("user-captcha")).sendKeys(captcha);}
    private void clickOnLogin(){  driver.findElement(By.xpath("/html/body/div[1]/form/div[5]/div[1]/button")).click();}
    
    

	public AdminBasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void adminLoginPage(String adminURL) {
		driver.navigate().to(adminURL);;
	}

	public String getPageTitle(){
		String title = driver.getTitle();
		return title;
	}
	
	public boolean verifyBasePageTitle(String expectedTitle) {
		return getPageTitle().contains(expectedTitle);
	}


	 public void login(String meTalkId, String password, String captcha) {
		  enterMeTalkId(meTalkId);
		  enterPassword(password);
		  enterCaptcha(captcha);
		  clickOnLogin();
	    }
}
