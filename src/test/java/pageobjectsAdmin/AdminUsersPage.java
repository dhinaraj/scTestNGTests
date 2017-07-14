package pageobjectsAdmin;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;



public class AdminUsersPage {

private WebDriver driver;
private String adminURl = "https://demometalk.plus65.local/admin/login";

public AdminUsersPage(WebDriver driver) {
	this.driver = driver;
}

//Elements
public void clickOnUsers() { 
	driver.findElement(By.xpath("html/body/div[3]/div[1]/div/ul/li[1]/a")).click();
	
}

public void navigateToAdminURL() { 
	driver.navigate().to(adminURl);
}

public void enterMetalkID(String meTalkID) { 
	driver.findElement(By.name("metalk_id")).sendKeys(meTalkID);
	
}

public void clickOnFilterButton() { 
	driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div/div[1]/div/div[2]/div/form/div[10]/button")).click();
	
}

public void clickOnAdjustCreditButton() { 
	driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div/div[2]/table/tbody/tr[1]/td[15]/a[6]")).click();
	
}

public void enterAdditionalTopUpCredit() { 
	driver.findElement(By.name("me_points_adjustment")).clear();
	driver.findElement(By.name("me_points_adjustment")).sendKeys("50000");
	
}

public void enterRemarks() { 
	driver.findElement(By.name("remarks")).clear();
	driver.findElement(By.name("remarks")).sendKeys("test");
	
}

public void clickOnSaveCreditChanges() { 
	driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div/form/div[5]/div/button")).click();
	
}

public void clickOnLoginButton() { 
	driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div/div[2]/table/tbody/tr[1]/td[15]/a[1]")).click();
	
}

public void clickOnChangeTopUpBonus() { 
	driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div/div[2]/table/tbody/tr[1]/td[15]/a[9]")).click();
	
}

public void selectTopUpBonusPercent(String topUpPercent) { 
	
	Select serviceLineDropDown = new Select(
			driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div/form/div[2]/div/select")));
	serviceLineDropDown.selectByVisibleText(topUpPercent);

	
}

public void saveTopUpBonusChange() { 

			driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div/form/div[3]/div/button")).click();

}


//Methods
public void findUser(String meTalkID) {
  clickOnUsers();
  enterMetalkID(meTalkID);
  clickOnFilterButton();
}


public void adjustCredit() {
  clickOnAdjustCreditButton();
  enterAdditionalTopUpCredit();
  enterRemarks();
  clickOnSaveCreditChanges();
}


public void login() {
 clickOnLoginButton();
}

public void changeTopUpBonus(String topUpPercent) {
	 clickOnChangeTopUpBonus();
	 selectTopUpBonusPercent(topUpPercent);
	 saveTopUpBonusChange();
	}
		
}