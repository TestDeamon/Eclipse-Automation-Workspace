import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import graphql.Assert;
import static org.openqa.selenium.support.locators.RelativeLocator.with;
public class sslCertification {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\David Alola\\Downloads\\Compressed\\chromedriver_win32\\chromedriver.exe");

		DesiredCapabilities caps = new DesiredCapabilities(); 
		caps.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		
		ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        chromeOptions.merge(caps); 
        
        WebDriver driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		
		driver.switchTo().newWindow(WindowType.TAB); 
		
		
/*		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		String destination = "C:\\Users\\David Alola\\eclipse-workenvironment\\Amazon\\src\\Screenshot\\"+"error.png"; 
		//copy file to temp directory
	    FileUtils.copyFile(src, new File(destination));
		
	    WebElement passwordField = driver.findElement(By.id("password"));
	    WebElement emailAddressField = driver.findElement(with(By.tagName("input"))
	    .above(passwordField));
*/	    
	}

}
