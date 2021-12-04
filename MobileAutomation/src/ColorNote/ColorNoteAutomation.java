package ColorNote;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class ColorNoteAutomation {
	 AndroidDriver driver;

	@BeforeTest
    public void Setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();        
        caps.setCapability(MobileCapabilityType.PLATFORM, "Android");

        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Android 7");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability("autoLaunch", true);

        //Prevent App from clearing data when app is closed
        caps.setCapability(MobileCapabilityType.NO_RESET, true);
        caps.setCapability(MobileCapabilityType.FULL_RESET, false);
        caps.setCapability("autoGrantPermissions", true);
        caps.setCapability("appPackage", "com.socialnmobile.dictapps.notepad.color.note");
        caps.setCapability("appActivity", "com.socialnmobile.colornote.activity.Main");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
    }
	
	
	@Test
	public void test() {
		
	}

	@AfterTest
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
}
