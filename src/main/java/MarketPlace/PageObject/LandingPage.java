package MarketPlace.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import MarketPlace.AbstractClass.AbstractComponent;


public class LandingPage extends AbstractComponent  {
	
	WebDriver driver;

	public LandingPage(WebDriver driver) {

		super(driver);
		this.driver=driver;
		PageFactory.initElements (driver, this);
		zoomOut();
	}
	
	
	@FindBy(className="lucide-circle-user-round")
	WebElement Login;

	@FindBy(css="input[placeholder='Email']:nth-child(2)")
	WebElement userEmail;

	@FindBy(css="input[placeholder='Password']")
	WebElement Password;
	
	@FindBy(css="[type*='submit']")
	WebElement submit;

	@FindBy(css="li[role='status']")
	WebElement errorMessage;
	
	
	
	public void loginApplication(String email, String password) 
	{
		Login.click();
		userEmail.sendKeys(email);
		Password.sendKeys(password);
		submit.click();
	
	}

	
	

	public void goTo() 
	{
		// TODO Auto-generated method stub
		driver.get("https://mf.energymarketplace.in/");
	}



	public String getErrorMessage()
	{
		// TODO Auto-generated method stub
		waitForwebElementToAppear(errorMessage);
		return errorMessage.getText();
		}



      
//      public static void main(String[] args) {
//          System.out.println("Landing Page Test");
//          // Add WebDriver initialization and call methods for testing here if needed.
//      }
}
