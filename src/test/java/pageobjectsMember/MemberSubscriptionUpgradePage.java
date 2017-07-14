package pageobjectsMember;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;




public class MemberSubscriptionUpgradePage {
	protected WebDriver driver;

	public MemberSubscriptionUpgradePage(WebDriver driver) {
		this.driver = driver;
	}

	public void closeWarning() {
		driver.findElement(By.xpath("html/body/div[3]/div/div/div[1]/div/div/div[3]/a")).click();
	}

	public void clickOnSubscription() {
		// To bring the focus on screen after registration

		/*
		 * String parentWindow = driver.getWindowHandle(); for(String winHandle
		 * : driver.getWindowHandles()){ driver.switchTo().window(parentWindow);
		 * }
		 */

		// Proceeding to Buy Subscription
		WebElement subcriptionLink = driver.findElement(By.xpath("//ul/li[2]/a/span[1]"));
		Actions builder = new Actions(driver);
		Action mouseOverSubscription = builder.moveToElement(subcriptionLink).build();
		mouseOverSubscription.perform();
	}

	public void clickOnPlanUpgrade() {
		// WebElement planUpgradeLink =
		// driver.findElement(By.xpath("html/body/header/div[1]/nav/div[2]/ul/li[2]/ul/li[2]/a"));
		WebElement planUpgradeLink = driver
				.findElement(By.xpath("html/body/header/div[1]/nav/div[2]/ul/li[2]/ul/li[1]/a"));

		Actions builder = new Actions(driver);
		Action mouseOverPlanUpgrade = builder.moveToElement(planUpgradeLink).build();
		mouseOverPlanUpgrade.perform();
	}

	// public void clickOnPlanUpgrade2() {
	// driver.findElement(By.xpath("html/body/header/div[1]/nav/div[2]/ul/li[2]/ul/li[2]/ul/li/a")).click();}

	public void clickOnPlanUpgrade2() {
		driver.findElement(By.xpath("html/body/header/div[1]/nav/div[2]/ul/li[2]/ul/li[1]/ul/li/a")).click();
	}

	public void selectPlan1() {
		driver.findElement(By.xpath("html/body/div[3]/div/div/div/div/div/div[2]/form/div[1]/div/input[1]")).click();
	}

	public void selectPlan2() {
		driver.findElement(By.xpath("html/body/div[3]/div/div/div/div/div/div[2]/form/div[1]/div/input[2]")).click();
	}

	public void selectPlan3() {
		driver.findElement(By.xpath("html/body/div[3]/div/div/div/div/div/div[2]/form/div[1]/div/input[3]")).click();
	}

	public void selectPlan4() {
		driver.findElement(By.xpath("html/body/div[3]/div/div/div/div/div/div[2]/form/div[1]/div/input[4]")).click();
	}

	public void enterTopupCreditstoUse(String topupCreditAmount) {
		driver.findElement(By.name("me_points")).clear();
		driver.findElement(By.name("me_points")).sendKeys(topupCreditAmount);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("$(arguments[0]).change();", driver.findElement(By.name("me_points")));
	}

	public void enterAdvertisingCreditstoUse(String advertisingCreditAmount) {
		driver.findElement(By.name("advertising_credit")).clear();
		driver.findElement(By.name("advertising_credit")).sendKeys(advertisingCreditAmount);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("$(arguments[0]).change();", driver.findElement(By.name("advertising_credit")));
	}
	
	public void enterBACredit(String baCreditAmount) {
		driver.findElement(By.name("ba_credit")).clear();
		driver.findElement(By.name("ba_credit")).sendKeys(baCreditAmount);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("$(arguments[0]).change();", driver.findElement(By.name("ba_credit")));
	}

	public void enterSecondaryPassword(String secondaryPassword) {
		driver.findElement(By.name("secondary_password")).sendKeys(secondaryPassword);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("$(arguments[0]).change();", driver.findElement(By.name("secondary_password")));
	}

	public void selectAgree() {
		driver.findElement(By.name("agreement")).click();
	}

	public void clickOnPurchase() {
		driver.findElement(By.partialLinkText("Purchase")).click();
	}

	public String readAmountToPay() {
		/*String amountToPay = driver
				.findElement(By.xpath("html/body/div[3]/div/div/div/div/div/div[2]/form/div[3]/div/p")).getText();*/
		String amountToPay = driver
		.findElement(By.xpath("html/body/div[3]/div/div/div/div/div/div[2]/form/div[4]/div/p")).getText();
		return amountToPay;
	}

	public String readAmountToPay2() {
		String amountToPay = driver
				.findElement(By.xpath("html/body/div[3]/div/div/div/div/div/div[2]/form/div[4]/div/p")).getText();
		return amountToPay;
	}

	public void clickOnCancelPurchaseButton() {
		driver.findElement(By.xpath("html/body/div[3]/div/div/div/div/div/div[2]/form/div[10]/a[2]")).click();
	}

	public void enterPurchaseOtp(String purchaseOtp) {
		driver.findElement(By.xpath("html/body/div[5]/div/div/div[2]/div/div/p[7]/input")).sendKeys(purchaseOtp);
	}

	public void clickOnConfirmPurchase() {
		driver.findElement(By.xpath("html/body/div[5]/div/div/div[3]/button[2]")).click();
	}

	public void upgradePackage(String currentPack, String upgradePack) {
		clickOnSubscription();
		clickOnPlanUpgrade();
		clickOnPlanUpgrade2();

		if (currentPack.equalsIgnoreCase("BA Starter") && upgradePack.equalsIgnoreCase("BA Professional")) {
			selectPlan1();
		}

		if (currentPack.equalsIgnoreCase("BA Starter") && upgradePack.equalsIgnoreCase("BA Regional")) {
			selectPlan2();
		}

		if (currentPack.equalsIgnoreCase("BA Starter") && upgradePack.equalsIgnoreCase("BA Global")) {
			selectPlan3();
		}

		if (currentPack.equalsIgnoreCase("Basic") && upgradePack.equalsIgnoreCase("Professional+")) {
			selectPlan1();
		}

		if (currentPack.equalsIgnoreCase("Basic") && upgradePack.equalsIgnoreCase("Enterprise+")) {
			selectPlan2();
		}

		if (currentPack.equalsIgnoreCase("Basic") && upgradePack.equalsIgnoreCase("Alliance")) {
			selectPlan3();
		}

		if (currentPack.equalsIgnoreCase("BA Professional") && upgradePack.equalsIgnoreCase("BA Regional")) {
			selectPlan1();
		}

		if (currentPack.equalsIgnoreCase("BA Professional") && upgradePack.equalsIgnoreCase("BA Global")) {
			selectPlan2();
		}

		if (currentPack.equalsIgnoreCase("BA Regional") && upgradePack.equalsIgnoreCase("BA Global")) {
			selectPlan1();
		}

		if (currentPack.equalsIgnoreCase("Entreprenuer+") && upgradePack.equalsIgnoreCase("Professional+")) {
			selectPlan1();
		}

		if (currentPack.equalsIgnoreCase("Entreprenuer+") && upgradePack.equalsIgnoreCase("Enterprise+")) {
			selectPlan2();
		}

		if (currentPack.equalsIgnoreCase("Entreprenuer+") && upgradePack.equalsIgnoreCase("Alliance")) {
			selectPlan3();
		}

		if (currentPack.equalsIgnoreCase("Professional+") && upgradePack.equalsIgnoreCase("Enterprise+")) {
			selectPlan1();
		}

		if (currentPack.equalsIgnoreCase("Professional+") && upgradePack.equalsIgnoreCase("Alliance")) {
			selectPlan2();
		}

		if (currentPack.equalsIgnoreCase("Enterprise+") && upgradePack.equalsIgnoreCase("Alliance")) {
			selectPlan1();
		}

	}

	public void upgradePackageOld(String currentPack, String upgradePack) {
		clickOnSubscription();
		clickOnPlanUpgrade();
		clickOnPlanUpgrade2();

		if (currentPack.equalsIgnoreCase("Entreprenuer") && upgradePack.equalsIgnoreCase("Basic")) {
			selectPlan1();
		}

		if (currentPack.equalsIgnoreCase("Entreprenuer") && upgradePack.equalsIgnoreCase("Professional")) {
			selectPlan2();
		}

		if (currentPack.equalsIgnoreCase("Entreprenuer") && upgradePack.equalsIgnoreCase("Enterprise")) {
			selectPlan3();
		}

		if (currentPack.equalsIgnoreCase("Entreprenuer") && upgradePack.equalsIgnoreCase("Alliance")) {
			selectPlan4();
		}

		if (currentPack.equalsIgnoreCase("Basic") && upgradePack.equalsIgnoreCase("Professional")) {
			selectPlan1();
		}

		if (currentPack.equalsIgnoreCase("Basic") && upgradePack.equalsIgnoreCase("Enterprise")) {
			selectPlan2();
		}

		if (currentPack.equalsIgnoreCase("Basic") && upgradePack.equalsIgnoreCase("Alliance")) {
			selectPlan3();
		}

		if (currentPack.equalsIgnoreCase("Professional") && upgradePack.equalsIgnoreCase("Enterprise")) {
			selectPlan1();
		}

		if (currentPack.equalsIgnoreCase("Professional") && upgradePack.equalsIgnoreCase("Alliance")) {
			selectPlan2();
		}

		if (currentPack.equalsIgnoreCase("Enterprise") && upgradePack.equalsIgnoreCase("Alliance")) {
			selectPlan1();
		}

	}

	public void enterPurchaseDetails(String secondaryPassword, String voucherPresent, String oldPack) {
		
		String amountToPayInString;
		double roundedTopUpCredit;
		double topupCreditAmount;
		double advCredit;
		double baCredit;
		double amountToPay;
		if (voucherPresent.equalsIgnoreCase("Y")) {
			amountToPayInString = readAmountToPay2();
			amountToPay = Double.parseDouble(amountToPayInString);
		} else {
			amountToPayInString = readAmountToPay();
			amountToPay = Float.parseFloat(amountToPayInString);
		}
		
				
		
		topupCreditAmount = Math.round(amountToPay*.65 * 100) / 100;
		advCredit = Math.round((amountToPay-topupCreditAmount)*0.5* 100)/100;
		baCredit = amountToPay-topupCreditAmount-advCredit;
		enterTopupCreditstoUse(String.valueOf(topupCreditAmount));
		enterAdvertisingCreditstoUse(String.valueOf(advCredit));
		enterBACredit(String.valueOf(baCredit));
		enterSecondaryPassword(secondaryPassword);
		selectAgree();

	}

	public void purchasePackage(String purchaseOtp) throws InterruptedException {

		clickOnPurchase();
		Thread.sleep(3000);
		enterPurchaseOtp(purchaseOtp);
		clickOnConfirmPurchase();

	}

	public void clickonCancelPurchase() {

		clickOnCancelPurchaseButton();

	}
}
