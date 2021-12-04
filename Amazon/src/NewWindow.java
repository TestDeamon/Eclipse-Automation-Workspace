import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class NewWindow {

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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4)); 
		
		driver.get("https://www.google.co.in/");
		String fh = driver.getWindowHandle(); 
		System.out.println("------------------------------");
		System.out.println("First handle: "+fh);
		System.out.println("------------------------------");
		
		driver.switchTo().newWindow(WindowType.TAB); 
		driver.get("https://www.selenium.dev/documentation/webdriver/locating_elements/"); 
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String script = "return document.getElementById(\"locating-one-element\").textContent;";
		String sh = driver.getWindowHandle(); 
		System.out.println("------------------------------");
		System.out.println("Second handle: "+sh);
		System.out.println("------------------------------");
		String value = (String) js.executeScript(script);
		System.out.println("Value: "+value);
		
		Set<String> handles = driver.getWindowHandles(); 
		Iterator<String> it = handles.iterator();
		
		String google = it.next();
		String seleniumDev = it.next();

		System.out.println(handles.size());
		
		driver.switchTo().window(google);
		WebElement input = driver.findElement(By.name("q")); 
		input.sendKeys(value, Keys.ENTER); 
		
		String path = System.getProperty("user.dir"); 
		System.out.println("--------------------------------\n"+path);
		WebElement field = driver.findElement(By.cssSelector("div.SDkEP")); 
		File file = field.getScreenshotAs(OutputType.FILE);
//		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		FileUtils.copyFile(file, new File(path+"\\src\\Screenshot\\error1.jpeg"));
		
		Thread.sleep(3000);
		
		

	}

}
