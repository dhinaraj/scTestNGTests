package pageobjectsMember;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class MemberRegistrationPage {
	protected WebDriver driver;

	

	public MemberRegistrationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterFullName(String fullName) {
		driver.findElement(By.name("fullname")).sendKeys(fullName);
	}

	public void enterNickName(String nickName) {
		driver.findElement(By.name("nickname")).sendKeys(nickName);
	}

	public void selectGenderMale() {
		Select genderDropDown = new Select(driver.findElement(By.name("gender")));
		genderDropDown.selectByIndex(1);
	}
	
	public void enterEmail(String email) {
		driver.findElement(By.name("email")).sendKeys(email);
	}

	public void selectExchangeRate() {
		Select exchangeRateDropDown = new Select(driver.findElement(By.name("exchange_rate_id")));
		exchangeRateDropDown.selectByVisibleText("SGD");
	}
	
	public void enterNationalId(String nationalId) {
		driver.findElement(By.name("national_id")).sendKeys(nationalId);
	}
	
	public void enterState(String state) {
		driver.findElement(By.name("state")).sendKeys(state);
	}
	
	public void enterCity(String city) {
		driver.findElement(By.name("city")).sendKeys(city);
	}
	
	public void enterAddress(String address) {
		driver.findElement(By.name("address")).sendKeys(address);
	}
	
	public void enterPostalCode(String postal_code) {
		driver.findElement(By.name("postal_code")).sendKeys(postal_code);
	}
	
	public void enterSecondaryPassword(String secondary_password) {
		driver.findElement(By.name("secondary_password")).sendKeys(secondary_password);
	}
	
	
	public void enterSecondaryConfirmPassword(String secondary_password_confirmation) {
		driver.findElement(By.name("secondary_password_confirmation")).sendKeys(secondary_password_confirmation);
	}
	
	public void acceptAgreement() {
		driver.findElement(By.name("agreement")).click();
	}
	
	public void clickOnSubmit() {
		driver.findElement(By.id("submit_btn")).click();
	}
	
	public void enterOTP(String registrationOtp) {
		driver.findElement(By.xpath("html/body/div[5]/div/div/div[2]/div/div/input")).sendKeys(registrationOtp);
	}

	
// Methods	
	public void clickOnSubmitRegistration() {
		driver.findElement(By.xpath("html/body/div[5]/div/div/div[3]/button[2]")).click();
	}
	
	public void completeRegistration(String fullName, String nickName, String email, String nationalId, String state,
			String city, String address, String postal_code, String secondary_password,
			String secondary_password_confirmation, String registrationOtp) throws InterruptedException  {
		enterFullName(fullName);
		enterNickName(nickName);
		selectGenderMale();
		enterEmail(email);
		selectExchangeRate();
		enterNationalId(nationalId);
		enterState(state);
		enterCity(city);
		enterAddress(address);
		enterPostalCode(postal_code);
		enterSecondaryPassword(secondary_password);
		enterSecondaryConfirmPassword(secondary_password_confirmation);
		acceptAgreement();;
		clickOnSubmit();
		
		Thread.sleep(3000);
		
		enterOTP(registrationOtp);
		clickOnSubmitRegistration();

	}
	
	
}
