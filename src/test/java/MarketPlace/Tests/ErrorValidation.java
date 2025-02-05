package MarketPlace.Tests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import MarketPlace.PageObject.LandingPage;
import MarketPlace.TestComponents.BaseTest;

public class ErrorValidation extends BaseTest {

    @Test(groups = {"ErrorHandling"})
    public void LoginErrorValidation() throws IOException, InterruptedException {
    	

        // Perform login action
        landingPage.loginApplication("abcd@gmail.com", "Iamking@000.");
        
        // Wait and get the error message
        String actualErrorMessage = landingPage.getErrorMessage();
        
        // Assert the error message
        Assert.assertEquals(actualErrorMessage, "user nots found", "Error message did not match!");

    }
}
