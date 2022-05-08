package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import ro.altom.altunitytester.AltUnityDriver;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;

public class BaseTest {

    static AndroidDriver appiumDriver;
    static WebDriverWait wait;

    static ExtentReports extent;
    ExtentSparkReporter reporter;
    ExtentTest logger;
    public static AltUnityDriver driver;

    @BeforeSuite
    public void attachReport() {
        extent = new ExtentReports();
        reporter = new ExtentSparkReporter("./Reports/AutomationReport"+ String.valueOf(new File("./Reports").list().length + 1) +".html");
        extent.attachReporter(reporter);
    }

    @BeforeClass
    public void setup() throws IOException, InterruptedException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "myPhone");
        caps.setCapability("udid", "RZ8M83LC0FL"); //DeviceId from "adb devices" command
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "10.0");
        caps.setCapability("skipUnlock","true");
        //caps.setCapability("appPackage", "com.LokumGames.ZulaMobile");
        //caps.setCapability("appActivity","com.google.firebase.MessagingUnityPlayerActivity");
        caps.setCapability("noReset","false");
        caps.setCapability("autoGrantPermissions","true");
        caps.setCapability("newCommandTimeout", "900");
        appiumDriver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        wait = new WebDriverWait(appiumDriver, 60);
        appStartAndroid("com.LokumGames.ZulaMobile","com.google.firebase.MessagingUnityPlayerActivity","com.google.firebase.MessagingUnityPlayerActivity");
        Thread.sleep(20000);
        PropFileReader properties = new PropFileReader();
        driver = new AltUnityDriver(properties.getProperty("deviceIp"), 13000, ";", "&", true);
    }

    public void appStartAndroid(String appPackage,String appActivity,String setAppActivity) {
        Activity activity = new Activity(appPackage,appActivity);
        activity.setAppWaitActivity(setAppActivity);

        appiumDriver.startActivity(activity);

        long startTime = System.currentTimeMillis();
        while(System.currentTimeMillis() - startTime < 30000) {
            if (appiumDriver.currentActivity().equals(setAppActivity))
                break;
        }
    }

    @BeforeMethod
    public void beforeMethod(Method method){
        logger = extent.createTest(method.getName());
        logger.info("Test has started successfully!");

    }


    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            logger.info("Test is Failed!");
            String encodeString = ExtentReportUtilities.encodeFileToBase64Binary(ExtentReportUtilities.testScreenshot(driver));
            logger.fail(result.getThrowable().getLocalizedMessage(), MediaEntityBuilder.createScreenCaptureFromBase64String(encodeString).build());
            ExtentReportUtilities.deleteScreenshotFiles();
        }

        else if(result.getStatus()==ITestResult.SUCCESS)
        {
            logger.info("Test was Successful");

        }
    }

    @AfterClass
    public void afterClass() {
        driver.stop();
        appiumDriver.terminateApp("com.LokumGames.ZulaMobile");

    }

    @AfterSuite
    public void afterSuite()  {
        extent.flush();
    }

}
