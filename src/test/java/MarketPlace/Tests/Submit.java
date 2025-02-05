package MarketPlace.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import MarketPlace.PageObject.ContactUs;
import MarketPlace.PageObject.LandingPage;
import MarketPlace.TestComponents.BaseTest;

public class Submit extends BaseTest {

	@Test(dataProvider = "getData")
	public void Login(HashMap<String, String> input) throws IOException {

		Submit test = new Submit(); // Create an instance of Submit to access BaseTest methods

//		landingPage.loginApplication(input.get("email"), input.get("password")); // Perform login using credentials
//		System.out.println("Test completed successfully!");

		// Contactus(input);
		
		
		try {
            // Perform login using credentials
            landingPage.loginApplication(input.get("email"), input.get("password"));
            System.out.println("Test completed successfully!");
        } catch (Exception e) {
            System.err.println("Login failed: " + e.getMessage());
        }
    

	}
	

	
	@Test(dataProvider = "getContactUsData")
	public void Contactus(HashMap<String, String> input) throws IOException {

		ContactUs contactUs = new ContactUs(driver);
		contactUs.ClickOnContactUs(); // Click on Contact Us

		// Fill in the contact form, including the query type (dropdown)
		
		contactUs.ContactInfo(input.get("name"), input.get("number"), input.get("email"), input.get("queryType"), input.get("description"),input.get("filePath"));
        
        System.out.println("Contact Us form submitted successfully!");
        
	}

	

	
	
	private TakesScreenshot driver() {
		// TODO Auto-generated method stub
		return null;
	}

	@DataProvider
	public Object[][] getData() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//MarketPlace//data//LoginData.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };

	}

}
