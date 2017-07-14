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

public class SponsorBonusTests extends TestBaseSetup {

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
	
	



	private String adminUserName = "dhina1";
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
	        	//{"11111100001","110502785","110502785","BA Starter","983156","983156","NO"},
	        	//{"11111100002","11111100001","11111100001","BA Starter","740539","740539","NO"},
	        	/*{"11111100003","11111100002","11111100002","BA Professional","289886","289886","NO"},
	        	{"11111100004","11111100003","11111100003","BA Professional","168678","168678","NO"},
	        	{"11111100005","11111100004","11111100004","BA Regional","975085","975085","NO"},
	        	{"11111100006","11111100005","11111100005","BA Regional","152228","152228","NO"},
	        	{"11111100007","11111100006","11111100006","BA Global","103256","103256","NO"},
	        	{"11111100008","11111100007","11111100007","BA Global","113293","113293","NO"},*/
	        	/*{"11111100009","11111100008","11111100008","BA Global","609477","609477","NO"},
	        	{"11111100010","11111100009","11111100009","BA Starter","374872","374872","NO"},
	        	{"11111100011","11111100010","11111100010","BA Professional","497710","497710","NO"},
	        	{"11111100012","11111100011","11111100011","BA Regional","630956","630956","NO"},
	        	{"11111100013","11111100012","11111100012","BA Global","678007","678007","NO"},
	        	{"11111100014","11111100013","11111100013","BA Starter","368315","368315","NO"},*/
	        	/*{"11111100015","11111100014","11111100014","BA Professional","042430","042430","NO"},
	        	{"11111100016","11111100015","11111100015","BA Regional","789561","789561","NO"},
	        	{"11111100017","11111100016","11111100016","BA Global","624620","624620","NO"},
	        	{"11111100018","11111100017","11111100017","BA Starter","387187","387187","NO"},
	        	{"11111100019","11111100018","11111100018","BA Professional","824655","824655","NO"},
	        	{"11111100020","11111100019","11111100019","BA Regional","250504","250504","NO"},
	        	{"11111100021","11111100020","11111100020","BA Starter","583549","583549","NO"},
	        	{"11111100022","11111100021","11111100021","BA Starter","601164","601164","NO"},*/
	        	/*{"11111100023","11111100022","11111100022","BA Professional","192911","192911","NO"},
	        	{"11111100024","11111100023","11111100023","BA Regional","703179","703179","NO"},
	        	{"11111100025","11111100024","11111100024","BA Global","795845","795845","NO"},
	        	{"11111100026","11111100025","11111100025","BA Starter","394648","394648","NO"},
	        	{"11111100027","11111100026","11111100026","BA Starter","518724","518724","NO"},
	        	{"11111100028","11111100027","11111100027","BA Professional","134425","134425","NO"},
	        	{"11111100029","11111100028","11111100028","BA Regional","596913","596913","NO"},
	        	{"11111100030","11111100029","11111100029","BA Professional","882377","882377","NO"},*/
	        	

	        	
	        	
	        	
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
		//adminMemberSearchPage.adjustCredit();
		//adminMemberSearchPage.findUser(meTalkId);
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
	
		Thread.sleep(6000);
		
		
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