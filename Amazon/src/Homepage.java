import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Homepage {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\David Alola\\Downloads\\Compressed\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://amazon.com");
		
		//Implicit Wait 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement signin = driver.findElement(By.cssSelector("#nav-tools a:nth-child(2) .nav-line-2")); 
		WebElement signInMenu = new WebDriverWait(driver, Duration.ofSeconds(3))
		        .until(ExpectedConditions.visibilityOf(signin));
		
		Actions action = new Actions(driver); 
		action.moveToElement(signin).build().perform();
		
		WebElement account = driver.findElement(By.cssSelector("#nav-al-your-account a.nav-link.nav-item:nth-child(2) span"));
		System.out.println(account.getText());
		if(account.getText().equalsIgnoreCase("Account")) {
			account.click(); 
		}else {
			System.out.println("Could not find element: "+account.getAttribute("text"));
		}
		
		WebElement el = new WebDriverWait(driver, Duration.ofSeconds(3))
		        .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//div[@class='a-column a-span9 a-span-last']/h2)[2]"))));
		Thread.sleep(5000); 
		
		System.out.println(el.isDisplayed()); 
		System.out.println(el.getText()); 
	
		
		//Explicit Wait 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		
		driver.quit();
		
	}

}
