package testsAdminPortal;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBaseSetup;
import pageobjectsAdmin.AdminBasePage;
import pageobjectsAdmin.AdminUsersPage;
import pageobjectsAdmin.ReferralMapPage;

public class AdminBasePageTest extends TestBaseSetup {
	private WebDriver driver;
	private AdminUsersPage AdminMemberSearchPage;
	private AdminBasePage basePage;
	private ReferralMapPage createAccountPage;
		
		@BeforeClass
		public void setUp() {
			driver=getDriver();
			basePage = new AdminBasePage(driver);
		}
		
		@Test
		public void verifyAdminBasePage() {
			System.out.println("Create An Account page test...");
			basePage.getPageTitle();
			
		}
		
		@Test
		public void verifySignInFunction() throws InterruptedException {
			System.out.println("Sign In functionality details...");
			Assert.assertTrue(basePage.verifyBasePageTitle("SecureCom Media"), "Sign In page title doesn't match");
			basePage.login("dhina2", "casuarina1", "");
		}
		
}