package utilities;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Helper;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class TestBase extends AbstractTestNGCucumberTests {
    public static WebDriver appiumDriver;
    public static WebDriver driver;

    public static String downloadPath = System.getProperty("user.dir") + "\\Downloads";



    @BeforeSuite
    @Parameters({"browser"})
    public void startDriver(@Optional("chrome-headless") String browser) throws MalformedURLException {
        //setUpAppiumDriver();
        setUpSeleniumDriver(browser);
    }


    @AfterSuite
    public void stopDriver() {
        driver.quit();
    }


    // take screenshot when test case fail and add it in the Screenshot folder
    @AfterMethod
    public void screenshotOnFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Failed!");
            System.out.println("Taking Screenshot....");
            Helper.captureScreenshot(driver, result.getName());
        }
    }



    private void setUpAppiumDriver() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities(); // creating an object

        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,"12");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy A72");
        //caps.setCapability("appPackage", "com.mnasat.nashmi");
        caps.setCapability(MobileCapabilityType.APP, "C:/Users/Lenovo/Downloads/Shgardi/src/main/java/Apk/shgardi_User_v1.84.apk");
        appiumDriver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
    }

    private void setUpSeleniumDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            System.out.println("Chrome Browser is Started" + driver.hashCode());

        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            System.out.println("Chrome Browser is Started" + driver.hashCode());

        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            System.out.println("Chrome Browser is Started" + driver.hashCode());
        }

        // headless browser testing
        else if (browser.equalsIgnoreCase("chrome-headless")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--window-size=1920,1080");
            driver = new ChromeDriver(options);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
    }



    public static FirefoxOptions firefoxOption() {
        FirefoxOptions option = new FirefoxOptions();
        option.addPreference("browser.download.folderList", 2);
        option.addPreference("browser.download.dir", downloadPath);
        option.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
        option.addPreference("browser.download.manager.showWhenStarting", false);
        option.addPreference("pdfjs.disabled", true);
        return option;
    }

    public static ChromeOptions chromeOption() {
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default.content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadPath);
        options.setExperimentalOption("prefs", chromePrefs);
        options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        return options;
    }
}
