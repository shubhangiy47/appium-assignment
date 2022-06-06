package base;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import listeners.ListenersClass;

@Listeners(ListenersClass.class)
public class BaseClass {
	public AndroidDriver<MobileElement> driver;
	
	@BeforeSuite
	@Parameters( {"device"} )
	public void setupDriver(@Optional("Emulator") String deviceName) throws MalformedURLException 
	{
		DesiredCapabilities cap = new DesiredCapabilities();
		
		/*if(deviceName.equalsIgnoreCase("Emulator"))
			System.out.println("****************Emulator code executed**********");
		else if(deviceName.equalsIgnoreCase("RealDevice"))
			System.out.println("************RealDevice code executed*************");
		
		URL appiumURL = new URL("http://127.0.0.1:4723/wd/hub/");
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName","sdk_gphone_x86");
		cap.setCapability("platformVersion", "11");
		cap.setCapability("app", "C:\\\\Users\\\\002YHZ744\\\\Downloads\\\\Grubhub Local Food Delivery_v2022.16_apkpure.com.apk");
		driver = new AndroidDriver<MobileElement>(appiumURL, cap);*/
		
		if(deviceName.equalsIgnoreCase("Emulator"))
		{
			System.out.println("****************Emulator code executed**********");
			URL appiumURL = new URL("http://127.0.0.1:4723/wd/hub/");
			cap.setCapability("platformName", "Android");
			cap.setCapability("deviceName","sdk_gphone_x86");
			cap.setCapability("platformVersion", "11");
			cap.setCapability("app", "C:\\\\Users\\\\002YHZ744\\\\Downloads\\\\Grubhub Local Food Delivery_v2022.16_apkpure.com.apk");
			driver = new AndroidDriver<MobileElement>(appiumURL, cap); 
		}
		else if(deviceName.equalsIgnoreCase("RealDevice"))
		{
			System.out.println("************RealDevice code executed*************");
			URL appiumURL = new URL("http://127.0.0.1:4723/wd/hub/");
			cap.setCapability("platformName","Android");
			cap.setCapability("appium:platformVersion","11.0");
			cap.setCapability("appium:deviceName","OnePlus 6");
			cap.setCapability("appium:app","C:/Users/002YHZ744/Downloads/ApiDemos-debug.apk");
			driver = new AndroidDriver<MobileElement>(appiumURL, cap); 
		}
		else if(deviceName.equalsIgnoreCase("BrowserStack"))
		{
			System.out.println("************BrowserStack code executed*************");
			cap.setCapability("appium:deviceName", "Samsung Galaxy S8 Plus");
			cap.setCapability("platformName", "Android");
			cap.setCapability("appium:platformVersion", "7.0");
			cap.setCapability("appium:app", "bs://4cf2474528f89fd0aad605bd956b80c20ecaf36f");
			cap.setCapability("appium:device", "Samsung Galaxy S8 Plus");
			cap.setCapability("appium:ensureWebviewsHavePages", true);
			cap.setCapability("appium:nativeWebScreenshot", true);
			//cap.setCapability("bstack:options", {"source":"appiumdesktop"});
			cap.setCapability("appium:newCommandTimeout", 3600);
			cap.setCapability("appium:connectHardwareKeyboard", true);

			String userName = "shubhangiyadav_5PDgwf";
			String accessKey = "qQzeedTm2KGysEk5qVCJ";

			driver = new AndroidDriver<MobileElement>(new URL
					("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), cap);
		}	  
	}
	@AfterSuite
	public void closeDriver() {
		driver.quit();
	}


}
