package testsMemberPortal;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.TestLogger;
import base.ExtentTestManager;
import base.TestBaseSetup;
import pageobjectsAdmin.AdminBasePage;
import pageobjectsAdmin.AdminUsersPage;
import pageobjectsAdmin.CommonPageFunctions;
import pageobjectsAdmin.ReferralMapPage;
import pageobjectsMember.MemberLandingPage;
import pageobjectsMember.MemberRegistrationPage;
import pageobjectsMember.MemberSubscriptionPage;
import pageobjectsMember.MemberSubscriptionUpgradePage;

public class SponsorBonusTests4 extends TestBaseSetup {

	private WebDriver driver;
	private AdminBasePage basePage ;
	private AdminUsersPage adminMemberSearchPage;
	private MemberRegistrationPage memberRegistrationPage ;
	private MemberSubscriptionPage memberSubscriptionPage;
	private MemberSubscriptionUpgradePage memberSubscriptionUpgradePage;
	private CommonPageFunctions commomPageFunctions;
	private MemberLandingPage memberLandingPage;
	
	@Parameters({ "browserType", "adminURL", "memberURL" })
	@BeforeMethod
	public void setUp(String browserType, String adminURL, String memberURL) {
		driver=getDriver();
		basePage = new AdminBasePage(driver);
		adminMemberSearchPage = new AdminUsersPage(driver);
		memberRegistrationPage = new MemberRegistrationPage(driver);
		memberSubscriptionPage = new MemberSubscriptionPage(driver);
		memberSubscriptionUpgradePage = new MemberSubscriptionUpgradePage(driver);
		commomPageFunctions = new CommonPageFunctions(driver);
		memberLandingPage = new MemberLandingPage(driver);
		
	}
	
	



	private String adminUserName = "dhina4";
	private String adminPassword = "casuarina1";
	private String captcha = "12345";
	private String meTalkId;



	private String fullName = "Dhinakaran";
	private String nickName = "Dhina";
	private Random rand = new Random();
	private int value = rand.nextInt(500000);
	private String emailAppender = Integer.toString(value);
	private String email = "dhinaplus65testing+" + emailAppender + "@gmail.com";
	private String nationalId = "test" + emailAppender;
	private String state = "Thailand";
	private String city = "Thailand";
	private String address = "Thailand";
	private String postalCode = "12345";
	private String secondaryPassword = "1234qwer";
	private String secondaryPasswordConfirmation = "1234qwer";

	 @DataProvider(name = "SponsorBonusPurchaseData")
	  public static Object[][] purcahseData() {
	 
	        return new Object[][] { 
	        	

	        	

	        	/*{"1234500561","111537","111537","BA Starter","437318","437318","NO"},
	        	{"1234500562","111537","1234500561","BA Starter","645894","645894","NO"},
	        	{"1234500563","111537","1234500562","BA Starter","421875","421875","NO"},
	        	{"1234500564","111537","1234500563","BA Professional","288458","288458","NO"},
	        	{"1234500565","111537","1234500564","BA Professional","619103","619103","NO"},
	        	{"1234500566","111537","1234500565","BA Regional","346087","346087","NO"},
	        	{"1234500567","111537","1234500566","BA Starter","942421","942421","NO"},
	        	{"1234500568","111537","1234500567","BA Professional","974051","974051","NO"},
	        	{"1234500569","111537","1234500568","BA Regional","670415","670415","NO"},
	        	{"1234500570","111537","1234500569","BA Global","376397","376397","NO"},
	        	

	        	{"1234500571","712096666","712096666","BA Starter","622320","622320","NO"},
	        	{"1234500572","712096666","1234500571","BA Starter","114357","114357","NO"},
	        	{"1234500573","712096666","1234500572","BA Starter","544950","544950","NO"},
	        	{"1234500574","712096666","1234500573","BA Professional","117169","117169","NO"},
	        	{"1234500575","712096666","1234500574","BA Professional","697326","697326","NO"},
	        	{"1234500576","712096666","1234500575","BA Regional","188311","188311","NO"},
	        	{"1234500577","712096666","1234500576","BA Starter","323868","323868","NO"},
	        	{"1234500578","712096666","1234500577","BA Professional","523019","523019","NO"},
	        	{"1234500579","712096666","1234500578","BA Regional","031857","031857","NO"},
	        	{"1234500580","712096666","1234500579","BA Global","726468","726468","NO"},*/

	        	
	        	
	        };
	 
	  }
	 
	 @DataProvider(name = "SponsorBonusPurchaseUpgrade")
	  public static Object[][] upgradeData() {
	 
	        return new Object[][] { 
	        	
	        
	        };
	 
	  }

	
	
	
	@Test(dataProvider = "SponsorBonusPurchaseData")
	// New User Purchase
	public void buyFirstPackage(String meTalkId, String referrerId, String placementID, String subscriptionPack, String registrationOtp,String purchaseOtp, String voucherApplied) throws InterruptedException {

		//Registration -- Comment out if registration is not required
		basePage.login(adminUserName, adminPassword, captcha);
		adminMemberSearchPage.findUser(meTalkId);
		adminMemberSearchPage.adjustCredit();
		adminMemberSearchPage.findUser(meTalkId);
		adminMemberSearchPage.login();
		/*memberRegistrationPage.completeRegistration(fullName, nickName, email, nationalId, state, city, address,
				postalCode, secondaryPassword, secondaryPasswordConfirmation, registrationOtp);*/
		
		//Purchase
		/*basePage.login(adminUserName, adminPassword, captcha);
		adminMemberSearchPage.findUser(meTalkId);
		adminMemberSearchPage.adjustCredit();
		adminMemberSearchPage.findUser(meTalkId);
		adminMemberSearchPage.login();*/
		memberSubscriptionPage.selectFirstPackage(subscriptionPack);
		memberSubscriptionPage.enterPurchaseDetailsOld(subscriptionPack, referrerId, placementID, secondaryPassword,
				voucherApplied);
		memberSubscriptionPage.purchasePackage(purchaseOtp);
	
		Thread.sleep(5000);
		
		
	}

	//@Test (dataProvider = "SponsorBonusPurchaseUpgrade")
	// Upgrade
	public void upgradePackage(String meTalkId, String currentPack, String newPack, String upgradeOtp, String voucherPresent ) throws InterruptedException {

		basePage.login(adminUserName, adminPassword, captcha);
		adminMemberSearchPage.findUser(meTalkId);
		adminMemberSearchPage.login();
		memberSubscriptionUpgradePage.closeWarning();
		memberLandingPage.navigateToMemberURL();
		memberSubscriptionUpgradePage.upgradePackage(currentPack, newPack);
		memberSubscriptionUpgradePage.enterPurchaseDetails(secondaryPassword, voucherPresent, currentPack);
		memberSubscriptionUpgradePage.purchasePackage(upgradeOtp);
		Thread.sleep(5000);
	}

}