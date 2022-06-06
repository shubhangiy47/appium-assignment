package methods;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.PointOption;

public class MethodsClass{
	
	public void clickElement(AndroidElement ele,AndroidDriver<MobileElement> driver)
	{
		AndroidElement ele1 = waitForElementToLoad(ele,driver);
		ele1.click();
	}
	public String getText(AndroidElement ele,AndroidDriver<MobileElement> driver)
	{
		AndroidElement ele1 = waitForElementToLoad(ele,driver);
		String text = ele1.getText();
		return text;
	}
	
	public void enterText(AndroidElement ele,String text,AndroidDriver<MobileElement> driver)
	{
		AndroidElement ele1 = waitForElementToLoad(ele,driver);
		ele1.sendKeys(text);
	}
	public void scrollViaCordinates(AndroidDriver<MobileElement> driver) {
		
		TouchAction action = new TouchAction(driver);
		action.longPress(LongPressOptions.longPressOptions().withPosition(new PointOption().
				withCoordinates(415, 1811)))
				.moveTo(new PointOption().withCoordinates(422, 276)).release().perform();
	}
	
	public AndroidElement waitForElementToLoad(AndroidElement ele,AndroidDriver<MobileElement> driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		AndroidElement ele1 = (AndroidElement) wait.until(ExpectedConditions.visibilityOf(ele));
		return ele1;
	}
}
