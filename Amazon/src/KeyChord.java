import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import graphql.Assert;

public class KeyChord {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\David Alola\\Downloads\\Compressed\\chromedriver_win32\\chromedriver.exe");

		ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		
		
		List<WebElement> discountLinks = driver.findElements(By.cssSelector("table.gf-t td:nth-child(1) li a"));
		
		//This will scroll the web page till end.
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        /*
		//This will scroll the page till the element is found		
        js.executeScript("arguments[0].scrollIntoView();", discountLinks.get(1));
        */
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4)); 
        wait.until(ExpectedConditions.visibilityOf(discountLinks.get(1))); 
        
        //Keychord
        String keys = Keys.chord(Keys.CONTROL, Keys.ENTER);
        
        Thread.sleep(3000);
        
		//Print out Link Texts 
        for(WebElement discountLink : discountLinks) {
        	if(discountLink.getText().equalsIgnoreCase("Discount Coupons")) {
        		continue; 
        	}else {
        		discountLink.sendKeys(keys);
        	}
        	System.out.println(discountLink.getText());
        }
        

        
            Set<String> handles = driver.getWindowHandles();
            Iterator<String> it = handles.iterator();
            
            while(it.hasNext()) {
              	driver.switchTo().window(it.next());
            	System.out.println(driver.getTitle());
            }
   

//		driver.quit();
	}

}
