import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import graphql.Assert;

public class AutoSuggestion {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\David Alola\\Downloads\\Compressed\\chromedriver_win32\\chromedriver.exe");


		DesiredCapabilities caps = new DesiredCapabilities(); 
		caps.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        chromeOptions.merge(caps); 
        
        
        WebDriver driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		
		WebElement oneWay = driver.findElement(By.cssSelector(".widgetSection [class='makeFlex'] li[data-cy='oneWayTrip']")); 
		
		WebElement roundTrip = driver.findElement(By.cssSelector(".widgetSection [class='makeFlex'] li[data-cy='roundTrip']")); 
		
		WebElement from = driver.findElement(By.id("fromCity")); 
		
		Actions action = new Actions(driver); 

		//Enter from location 
		from.click();
		
		//Enter pune 
		WebElement fromField = driver.findElement(By.cssSelector("div[class$='autoSuggestPlugin '] input[type='text']"));
		fromField.sendKeys("del");
		Thread.sleep(2000);
		List<WebElement> fromCities = driver.findElements(By.cssSelector(".calc60 p[class$='blackText']")); //Pune, India
		for(WebElement city : fromCities) {
			System.out.println(city.getText());
			if(city.getText().contains("Delhi")) {
				city.click();
				break;
			}
		}
		
		
		WebElement toCity = driver.findElement(By.id("toCity"));
				
		//Enter TO location 		
		action.moveToElement(toCity).click().build().perform(); 
		
		//Enter pune 
		WebElement toCityField = driver.findElement(By.cssSelector("div[class$='spaceBetween'] input[type='text']"));
		
		List<WebElement> toCityList = driver.findElements(By.cssSelector(".calc60 p[class$='blackText']")); //Bangkok, Thailand
		
		toCityField.sendKeys("san");
		Thread.sleep(2000);
		System.out.println("________________________________");
		for(WebElement city : toCityList) {
			
			System.out.println(city.getText());
			if(city.getText().contains("San Antonio")) {
				city.click();
				break;
			}
		}
		Thread.sleep(5000);
//		driver.quit();
		
	}

}
