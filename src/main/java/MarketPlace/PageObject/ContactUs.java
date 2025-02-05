package MarketPlace.PageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import MarketPlace.AbstractClass.AbstractComponent;

public class ContactUs extends AbstractComponent {

	WebDriver driver;

	public ContactUs(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		zoomOut();
	}

	@FindBy(css = "a[href='/contact']")
	WebElement ContactUs;

	@FindBy(css = "input[qa-data='name']")
	WebElement Name;

	@FindBy(css = "input[qa-data='phoneNumber']")
	WebElement PhoneNumber;

	@FindBy(css = "input[qa-data='email']")
	WebElement Email;

//	@FindBy(className="pt-2")
	@FindBy(css = ".pt-2")
	WebElement QueryType;

//	@FindBy(className="text-gray-700")
	@FindBy(css = "input[placeholder='Select files to attach']")
	WebElement Attachment;

	@FindBy(css = "textarea[placeholder='Enter your query description']")
	WebElement Description;

	@FindBy(xpath = "//button[normalize-space()='Submit']")
	WebElement SubmitForm;
	
	@FindBy(css ="button[type='submit']")
	WebElement Requestsubmit;


	public void ClickOnContactUs() {
		ContactUs.click();

	}

	public void ContactInfo(String name, String number, String email, String queryType, String description, String filePath) {

		// Fill in the contact information
		Name.sendKeys(name);
		PhoneNumber.sendKeys(number);
		Email.sendKeys(email);


//         Click to open the dropdown
		QueryType.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

	    // Dynamic XPath based on 'queryType' value
	    String dynamicXPath = "//span[contains(.,'" + queryType + "')]";

	    try {
	        WebElement queryOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dynamicXPath)));
	        queryOption.click();
	    } catch (TimeoutException e)
	    {
	        System.out.println("Query type option not found: " + queryType);
	    }
		
		

		// Fill in the description and attachment
		Description.sendKeys(description);
		Attachment.sendKeys(filePath);
		SubmitForm.click();
		Requestsubmit.click();

	}


}


