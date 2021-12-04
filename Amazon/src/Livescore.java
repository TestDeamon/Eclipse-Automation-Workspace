import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
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

public class Livescore {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\David Alola\\Downloads\\Compressed\\chromedriver_win32\\chromedriver.exe");

		ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        WebDriver driver = new ChromeDriver(chromeOptions);
       
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		
		try {			
			driver.switchTo().newWindow(WindowType.TAB); 
			driver.get("http://www.livescore.com");
							
			WebElement premierLeagueTitle = driver.findElement(By.cssSelector("div[id='7126__category-header']")); 
			premierLeagueTitle.click(); 
			
					
			//SEE ALL 
			WebElement seeAll = driver.findElement(By.cssSelector(".LeagueTableTab_showButton__L9Gck a")); 
			seeAll.click(); 
			
			//Team column for Premier League
			List<WebElement> teams = driver.findElements(By.xpath("//table[@class='LeagueTableTab_table__3PvYS'] /tbody/tr/td/div[@class='LeagueTableTab_teamBadge__ISokE']")); 

			int count = 1; 
			for(WebElement team : teams) {
				System.out.println("Team "+count+ ": "+team.getText());
				if(team.getText().equalsIgnoreCase("Arsenal")) {
					team.click(); 
					
				}
			}
			

				
			
		}finally {
			driver.quit();
		}

	}

}
