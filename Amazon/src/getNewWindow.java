import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class getNewWindow {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\David Alola\\Downloads\\Compressed\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4)); 
		driver.get("https://accounts.google.com/SignUp?hl=en");
		
		System.out.println(driver.getTitle()); 
		
		//Click Help link 
		driver.findElement(By.cssSelector("a[href*='/accounts?hl']")).click(); 
		
		System.out.println(driver.getTitle());
		
		Set<String> els = driver.getWindowHandles(); 
		
		Iterator<String> ids = els.iterator();
		
		String parentId = ids.next(); 
		String childId = ids.next();
		System.out.println(parentId+"\n"+childId);
		
		driver.switchTo().window(childId); 
		
		
		System.out.println("Switched window: "+driver.getTitle());
		
		

	}

}
