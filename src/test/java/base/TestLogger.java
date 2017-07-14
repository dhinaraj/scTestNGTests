package base;

import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;

import base.ExtentTestManager;


public class TestLogger extends TestBaseSetup {
    public static void log(final String message) {
          Reporter.log(message + "<br>", true);
          ExtentTestManager.getTest().log(LogStatus.INFO, message + "<br>");  // new
    }
}