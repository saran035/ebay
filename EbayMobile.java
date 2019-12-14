package pkg_ebay;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

public class EbayMobile {
	
	WebDriver driver;

	@BeforeClass
	public void setUp() throws MalformedURLException{

		//Set up desired capabilities and pass the Android app-activity and app-package to Appium
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability("platformVersion", "4.4.2");
		capabilities.setCapability("deviceName","Emulator");
		capabilities.setCapability("platformName","Android");
	   
	   capabilities.setCapability("appPackage", "com.android.ebay");
	// This package name of your app (you can get it from apk info app)
		capabilities.setCapability("appActivity","com.android.ebay.mobile"); // This is Launcher activity of your app (you can get it from apk info app)	
		capabilities.setCapability("noReset", "true"); 
		
	//Create RemoteWebDriver instance and connect to the Appium server
	 //It will launch the Calculator App in Android Device using the configurations specified in Desired Capabilities
	   driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}

	@Test
	public void testCal() throws Exception {

	   //locate the Text on the calculator by using By.name()
	   WebElement username=driver.findElement(By.xpath("div[@id='username']"));
	   username.sendKeys("samplelogin");
	   WebElement password=driver.findElement(By.xpath("div[@id='password']"));
	   password.sendKeys("login@123");	   
	   WebElement loginbtn=driver.findElement(By.xpath(""div[@id='loginbutton']""));
	   loginbtn.click();

	}

	@AfterClass
	public void teardown(){
		//close the app
		driver.quit();
	}

}
