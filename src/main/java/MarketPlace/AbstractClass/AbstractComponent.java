package MarketPlace.AbstractClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {

	WebDriver driver;

	private static final int TIMEOUT = 60;

	public AbstractComponent(WebDriver driver) 
	{
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	
	
	public void zoomOut() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='50%'");
	}


	@FindBy(css="li:nth-child(2)")
	WebElement AboutUs;
	
	
	
	public void aboutUsAcess() 
	{
		
		AboutUs.click();
	
	}

	
	
	
	
	
	
	public void waitForElementToVisible(By findBy)
	{

		WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(TIMEOUT));
		wait.until(ExpectedConditions.visibilityOfElementLocated (findBy));

	}


	public void waitForwebElementToAppear(WebElement findBy)
	{

		WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(TIMEOUT));
		wait.until(ExpectedConditions.visibilityOf(findBy));

	}
	
	
	
}
