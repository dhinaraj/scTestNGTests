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

public class SponsorBonusTests5 extends TestBaseSetup {

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
	
	



	private String adminUserName = "dhina5";
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
	        	


	        
	        	{"1234500582","812867546","1234500581","BA Starter","498742","498742","NO"},
	        	{"1234500583","812867546","1234500582","BA Starter","567989","567989","NO"},
	        	{"1234500584","812867546","1234500583","BA Professional","700669","700669","NO"},
	        	
	        	{"1234500586","812867546","1234500585","BA Regional","861732","861732","NO"},
	        	{"1234500587","812867546","1234500586","BA Starter","985011","985011","NO"},
	        	{"1234500588","812867546","1234500587","BA Professional","561435","561435","NO"},
	        	

	        	{"1234500591","212548716","212548716","BA Starter","692490","692490","NO"},
	        	{"1234500592","212548716","1234500591","BA Starter","361338","361338","NO"},
	        	
	        	{"1234500594","212548716","1234500593","BA Professional","314498","314498","NO"},
	        	
	        	{"1234500596","212548716","1234500595","BA Regional","796298","796298","NO"},
	        	{"1234500597","212548716","1234500596","BA Starter","454598","454598","NO"},
	        	
	        	
	        	{"1234500600","212548716","1234500599","BA Global","068308","068308","NO"},
	        	
	        	
	        	
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