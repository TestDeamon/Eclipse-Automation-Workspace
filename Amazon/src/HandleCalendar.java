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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import graphql.Assert;

public class HandleCalendar {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\David Alola\\Downloads\\Compressed\\chromedriver_win32\\chromedriver.exe");


		ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        WebDriver driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		//Implicit Wait 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		
		driver.get("https://www.path2usa.com/travel-companions");
		

		WebElement from = driver.findElement(By.cssSelector("input#travel_from")); 
		WebElement to = driver.findElement(By.cssSelector("input#travel_to"));
		
		
		WebElement nameBtw = driver.findElement(By.cssSelector("select#datebetween"));
		WebElement airline = driver.findElement(By.cssSelector("select#travel_airline"));
		
		WebElement date = driver.findElement(By.id("travel_date"));
		
		WebElement language = driver.findElement(By.id("travel_language"));
		WebElement search = driver.findElement(By.cssSelector(".foot-right button"));
		
		
		Actions action = new Actions(driver); 

		//Enter from location 
		action.moveToElement(from).click().sendKeys("Che").build().perform();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		List<WebElement> fromOptions = driver.findElements(By.cssSelector("div#ajax_listOfOptions div"));
		wait.until(ExpectedConditions.visibilityOf(fromOptions.get(1))); 
		
//		action.moveToElement(from).click().sendKeys("Che", Keys.ENTER).build().perform();
		 
		
		for(WebElement option : fromOptions) {
			System.out.println(option.getText());
			if(option.getText().contains("Chennai")) {
				option.click();
				break;
			}
		}
		
		//Enter to location 
		action.moveToElement(to).click().sendKeys("hou", Keys.ENTER).build().perform();
		List<WebElement> toOptions = driver.findElements(By.cssSelector("div#ajax_listOfOptions div")); 
		
		for(WebElement option : toOptions) {
			System.out.println(option.getText());
			if(option.getText().contains("George")) {
				option.click();
				break;
			}
		}
		
		date.click();
		
		WebElement month = driver.findElement(By.cssSelector("div.datepicker-days .datepicker-switch")); 
		WebElement next = driver.findElement(By.cssSelector("div.datepicker-days .next")); 
		


		while(!month.getText().contains("January")) {
			next.click(); 
		}
		
		List<WebElement> days = driver.findElements(By.cssSelector("tr td[class='day']")); 
		for(WebElement day : days) {
			if(day.getText().equals("4")) {
				day.click();
				break; 
			}
		}
		//Select Week 
		Select s = new Select(nameBtw); 
		s.selectByValue("2W"); 
		
		//SELECT AIRLINE 
		Select al = new Select(airline); 
		al.selectByVisibleText("Air Canada"); 
		
		//SELECT LANGUAGE
		Select lang = new Select(language); 
		lang.selectByValue("Gujarati"); 
		
		
		search.click();
		
		Thread.sleep(5000);
//		driver.quit();
		
	}

}
