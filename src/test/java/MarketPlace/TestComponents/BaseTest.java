package MarketPlace.TestComponents;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import MarketPlace.PageObject.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	public LandingPage landingPage;


	public WebDriver initializeDriver() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//java//MarketPlace//reasources//GlobalData.properties");
		prop.load(fis);                           
		String browserName = System.getProperty("browser") != null ? System.getProperty("browser")
				: prop.getProperty("browser");

		
		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		WebDriverManager.edgedriver().setup();

		switch (browserName.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			
			break;

			
		case "firefox":
			driver = new FirefoxDriver();
			break;

		case "edge":
			driver = new EdgeDriver();
			break;

		default:
			throw new IllegalArgumentException("Unsupported browser: " + browserName);
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		return driver;
	}

	   @BeforeMethod(alwaysRun = true)
	 public LandingPage launchApplication() throws IOException {
	        driver = initializeDriver();
	        landingPage = new LandingPage(driver);
	        landingPage.goTo();
	        return landingPage;

	    }
	
	
	    // DataReader method to read Login data
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
			// read json to string
			String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);

			ObjectMapper mapper = new ObjectMapper();
			List<HashMap<String, String>> data = mapper.readValue(jsonContent,
					new TypeReference<List<HashMap<String, String>>>() {
					});
			return data;

		}
	 

	 //Capture Screenshot for test data
	 public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			String destinationFile = System.getProperty("user.dir") + "/reports/" + testCaseName + ".png";
			FileUtils.copyFile(source, new File(destinationFile));
			return destinationFile;
		}


	 // DataProvider for Contact Us form data
	    @DataProvider
	    public Object[][] getContactUsData() throws IOException {
	        List<HashMap<String, String>> contactUsData = getContactUsDataToMap(System.getProperty("user.dir") + "//src//test//java//MarketPlace//data//ContactUs.json");
	        return new Object[][] { { contactUsData.get(0) }, { contactUsData.get(1) } };
	    }

	    
	    
	    // DataReader method to read Contact Us data
	    public List<HashMap<String, String>> getContactUsDataToMap(String filePath) throws IOException {
	        String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
	        ObjectMapper mapper = new ObjectMapper();
	        return mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {});
	    }
	 
	 
}
