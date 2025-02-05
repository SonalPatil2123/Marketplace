package MarketPlace.Tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AllData {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		driver.get("https://mf.energymarketplace.in/");

		// Zoom out the page
		zoomOut(driver);

		driver.findElement(By.className("lucide-circle-user-round")).click();
		driver.findElement(By.cssSelector("input[placeholder='Email']:nth-child(2)")).sendKeys("ruta@gmail.com");
		driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("Test@1234");
		driver.findElement(By.cssSelector("[type*='submit']")).click();
		Thread.sleep(60000);

		// Navigate to Contact Page
		driver.findElement(By.xpath("//span[contains(text(), 'About Us')]")).click();
		Thread.sleep(40000);

		driver.findElement(By.cssSelector("a[href='/contact']")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Wait for dropdown to be clickable and click it
		WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.className("pt-2")));
		dropdown.click();
		Thread.sleep(40000);

		WebElement dropdown1 = driver.findElement(By.xpath("//span[contains(.,'Land Lease For Solar')]"));
		
		Thread.sleep(40000);

		dropdown1.click();
		
		
//		List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
//		for (WebElement iframe : iframes) {
//		    driver.switchTo().frame(iframe);
//		    try {
//		        WebElement element = driver.findElement(By.xpath("//span[contains(.,'Land Lease For Solar')]"));
//		        if (element.isDisplayed()) {
//		            System.out.println("Element found inside an iframe.");
//		            break;
//		        }
//		    } catch (Exception e) {
//		        driver.switchTo().defaultContent(); // Switch back to the main page
//		    }
//		}

		
	}

	public static void zoomOut(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='60%'"); // Adjust zoom percentage as needed
	}
}
