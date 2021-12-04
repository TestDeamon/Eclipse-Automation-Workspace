import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import graphql.Assert;

public class ChainCommand {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\David Alola\\Downloads\\Compressed\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://amazon.com");
		
		//Implicit Wait 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		WebElement searchBox = driver.findElement(By.cssSelector("#twotabsearchtextbox")); 
		Actions action = new Actions(driver); 

		
		action.moveToElement(searchBox).click().keyDown(Keys.SHIFT).sendKeys("bags").build().perform();
		
		
		
		Thread.sleep(5000);
		driver.quit();
		
	}

}
