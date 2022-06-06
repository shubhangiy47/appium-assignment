package page;

import java.time.Duration;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.PointOption;
import methods.MethodsClass;

public class MainPage {
	//public AndroidDriver<MobileElement> driver;
	public MainPage(AndroidDriver<MobileElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)),this);
	}
	
	@AndroidFindBy(id = "com.grubhub.android:id/welcome_button")
	private AndroidElement searchNearby;
	
	@AndroidFindBy(id = "com.grubhub.android:id/address_bar")
	private AndroidElement locationField;
	
	@AndroidFindBy(id = "com.grubhub.android:id/address_location_search_title")
	private AndroidElement yourLocation;
	
	@AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
	private AndroidElement permissionButton;
		
	MethodsClass m = new MethodsClass();
	
	public void goToEnterLocationPage(AndroidDriver<MobileElement> driver)
	{
		m.clickElement(searchNearby,driver);
		m.clickElement(locationField,driver);
		m.clickElement(yourLocation,driver);
		m.clickElement(permissionButton,driver);
	}
}
