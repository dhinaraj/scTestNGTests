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

public class SponsorBonusTests3 extends TestBaseSetup {

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
	
	



	private String adminUserName = "dhina3";
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
	        	

	        	{"1234500541","61590567","61590567","BA Starter","125702","125702","NO"},
	        	
	        	{"1234500547","61590567","1234500546","BA Starter","739103","739103","NO"},
	        	
	        	{"1234500549","61590567","1234500548","BA Regional","427500","427500","NO"},
	        	{"1234500550","61590567","1234500549","BA Global","624308","624308","NO"},

	        	{"1234500551","61811707","61811707","BA Starter","031947","031947","NO"},
	        	{"1234500552","61811707","1234500551","BA Starter","159630","159630","NO"},
	        	{"1234500553","61811707","1234500552","BA Starter","813824","813824","NO"},
	        	{"1234500554","61811707","1234500553","BA Professional","266927","266927","NO"},
	        	{"1234500555","61811707","1234500554","BA Professional","099430","099430","NO"},
	        	{"1234500556","61811707","1234500555","BA Regional","343438","343438","NO"},
	        	{"1234500557","61811707","1234500556","BA Starter","253117","253117","NO"},
	        	{"1234500558","61811707","1234500557","BA Professional","209692","209692","NO"},
	        	{"1234500559","61811707","1234500558","BA Regional","019711","019711","NO"},
	        	{"1234500560","61811707","1234500559","BA Global","421364","421364","NO"},

	        	
	        	
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