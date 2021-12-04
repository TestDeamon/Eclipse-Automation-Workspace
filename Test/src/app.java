import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class app {
	AndroidDriver driver;
	
	@Test
	public void setup() throws MalformedURLException, InterruptedException {
	       DesiredCapabilities caps = new DesiredCapabilities();        
	       caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	       caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
	       caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Android 7");
	       caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
	       caps.setCapability("autoLaunch", true);

	       //Prevent App from clearing data when app is closed
	       caps.setCapability(MobileCapabilityType.NO_RESET, true);
	       caps.setCapability(MobileCapabilityType.FULL_RESET, false);
	       caps.setCapability("autoGrantPermissions", true);
	       caps.setCapability("appPackage", "com.google.android.apps.tasks");
	       caps.setCapability("appActivity", "com.google.android.apps.tasks.ui.TaskListsActivity");
	       driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
	       caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 20);
		
	       
	       Thread.sleep(7000);
	       
	       
	       driver.quit();
	}
}
