package testsAdminPortal;

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

public class ChangeTopUpBonus extends TestBaseSetup {

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

	 @DataProvider(name = "changeTopUpBonus")
	  public static Object[][] purcahseData() {
	 
	        return new Object[][] { 

	        	{"711683","15%"},
	        	{"1234500201","15%"},
	        	{"1234500202","10%"},
	        	{"1234500203","5%"},
	        	{"1234500204","4%"},
	        	{"1234500205","3%"},
	        	{"1234500206","2%"},
	        	{"1234500207","1%"},
	        	{"1234500208","0%"},
	        	{"56276341","15%"},
	        	{"1234500209","15%"},
	        	{"1234500210","15%"},
	        	{"1234500211","0%"},
	        	{"1234500212","10%"},
	        	{"1234500213","5%"},
	        	{"1234500214","0%"},
	        	{"1234500215","3%"},
	        	{"1234500216","0%"},
	        	{"212548716","15%"},
	        	{"1234500217","15%"},
	        	{"1234500218","4%"},
	        	{"1234500219","10%"},
	        	{"1234500220","5%"},
	        	{"1234500221","0%"},
	        	{"1234500222","3%"},
	        	{"1234500223","5%"},
	        	{"1234500224","2%"},
	        	{"812867546","15%"},
	        	{"1234500225","10%"},
	        	{"1234500226","0%"},
	        	{"1234500227","4%"},
	        	{"1234500228","4%"},
	        	{"1234500229","2%"},
	        	{"1234500230","1%"},
	        	{"1234500231","2%"},
	        	{"1234500232","1%"},
	        	
	        };
	 
	  }
	
	
	@Test(dataProvider = "changeTopUpBonus")

	public void buyFirstPackage(String meTalkId, String topUpPercent) throws InterruptedException {


		basePage.login(adminUserName, adminPassword, captcha);
		adminMemberSearchPage.findUser(meTalkId);
		adminMemberSearchPage.changeTopUpBonus(topUpPercent);
		Thread.sleep(5000);
		
		
	}

	

}