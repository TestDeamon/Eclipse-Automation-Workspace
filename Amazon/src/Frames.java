import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Frames {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\David Alola\\Downloads\\Compressed\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4)); 
		driver.get("https://jqueryui.com/droppable/");
		System.out.println("Switch System to Frames to locate element");
		
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
		WebElement source = driver.findElement(By.id("draggable")); 
		WebElement target = driver.findElement(By.id("droppable"));
		
		Actions action = new Actions(driver); 
		
		action.dragAndDrop(source, target).build().perform(); 
		
		System.out.println("Dragged");
		
	}

}
