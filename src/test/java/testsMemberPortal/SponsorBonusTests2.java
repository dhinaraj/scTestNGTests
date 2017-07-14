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

public class SponsorBonusTests2 extends TestBaseSetup {

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
	
	



	private String adminUserName = "dhina2";
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
	        	
	        	//{"11111100031","110502785","110502785","BA Starter","327277","327277","NO"},
	        	/*{"11111100032","11111100031","11111100031","BA Starter","892461","892461","NO"},
	        	{"11111100033","11111100032","11111100032","BA Professional","005999","005999","NO"},
	        	{"11111100034","11111100033","11111100033","BA Professional","512113","512113","NO"},
	        	{"11111100035","11111100034","11111100034","BA Regional","592730","592730","NO"},
	        	{"11111100036","11111100035","11111100035","BA Regional","430167","430167","NO"},
	        	{"11111100037","11111100036","11111100036","BA Global","380790","380790","NO"},*/
	        	/*{"11111100038","11111100037","11111100037","BA Global","342248","342248","NO"},
	        	{"11111100039","11111100038","11111100038","BA Global","500721","500721","NO"},
	        	{"11111100040","11111100039","11111100039","BA Starter","171344","171344","NO"},
	        	{"11111100041","11111100040","11111100040","BA Professional","498414","498414","NO"},
	        	{"11111100042","11111100041","11111100041","BA Regional","253322","253322","NO"},
	        	{"11111100043","11111100042","11111100042","BA Global","367691","367691","NO"},
	        	{"11111100044","11111100043","11111100043","BA Starter","541623","541623","NO"},
	        	{"11111100045","11111100044","11111100044","BA Professional","730975","730975","NO"},
	        	{"11111100046","11111100045","11111100045","BA Regional","415266","415266","NO"},*/
	        	//{"11111100047","11111100046","11111100046","BA Global","792025","792025","NO"},
	        	/*{"11111100048","11111100047","11111100047","BA Starter","361020","361020","NO"},
	        	{"11111100049","11111100048","11111100048","BA Professional","184347","184347","NO"},
	        	{"11111100050","11111100049","11111100049","BA Regional","620718","620718","NO"},
	        	{"11111100051","11111100050","11111100050","BA Starter","259876","259876","NO"},
	        	{"11111100052","11111100051","11111100051","BA Starter","545757","545757","NO"},
	        	{"11111100053","11111100052","11111100052","BA Professional","293496","293496","NO"},
	        	{"11111100054","11111100053","11111100053","BA Regional","414959","414959","NO"},
	        	{"11111100055","11111100054","11111100054","BA Global","621793","621793","NO"},*/
	        	//{"11111100056","11111100055","11111100055","BA Starter","528506","528506","NO"},
	        	/*{"11111100057","11111100056","11111100056","BA Starter","151627","151627","NO"},
	        	{"11111100058","11111100057","11111100057","BA Professional","456796","456796","NO"},
	        	{"11111100059","11111100058","11111100058","BA Regional","448833","448833","NO"},*/
	        	{"11111100060","11111100059","11111100059","BA Professional","895065","895065","NO"},

	        	
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