package page;

import java.time.Duration;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;
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

public class searchResturant extends BaseClass{
	//AndroidDriver<MobileElement> driver;
	public searchResturant(AndroidDriver<MobileElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)),this);
	}
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.cardview.widget.CardView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.FrameLayout")
	private AndroidElement searchBar1;
	
	@AndroidFindBy(id = "com.grubhub.android:id/search_query_input_fused")
	private AndroidElement searchBar2;
	
	@AndroidFindBy(id = "com.grubhub.android:id/autocomplete_restaurant_name")
	private AndroidElement resturantSuggestion;
	
	@AndroidFindBy(xpath = "//androidx.cardview.widget.CardView[@content-desc=\"Large Pizza - Cheese. $8.39. 100% Real® Mozzarella made from whole milk piled on our signature sauce made from vine-ripened, California tomatoes.\"]/android.view.ViewGroup/android.widget.ImageView")
	private AndroidElement largePizzaCheese;
	
	@AndroidFindBy(id = "com.grubhub.android:id/add_button")
	private AndroidElement addButton;
	
	//@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/androidx.cardview.widget.CardView/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ImageView[1]")
	//private AndroidElement chickenWings;
	//@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/androidx.cardview.widget.CardView/android.view.ViewGroup/android.widget.Button")
	//private AndroidElement chickenWings;
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/androidx.cardview.widget.CardView/android.view.ViewGroup/android.widget.ImageView[1]")
	private AndroidElement chickenWings;
	
	@AndroidFindBy(xpath ="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.TextView")
	private AndroidElement grubhubGoodsButton;
	
	@AndroidFindBy(id = "com.grubhub.android:id/order_button_bg")
	private AndroidElement viewOrderButton;
	
	@AndroidFindBy(xpath ="//android.widget.RelativeLayout[@content-desc=\"1 Chicken Wings - Buffalo (5 piece) $8.99 \"]/android.widget.LinearLayout[1]/android.widget.TextView")
	private AndroidElement removeChickenWingsItem;
	
	@AndroidFindBy(xpath ="(//android.widget.LinearLayout[@content-desc=\"Delete Item Button\"])[2]/android.widget.TextView")
	private AndroidElement deleteFoodItemButton;
	
	@AndroidFindBy(id = "com.grubhub.android:id/cookbook_button_bar_primary_button")
	private AndroidElement removeButton;
	
	@AndroidFindBy(id = "com.grubhub.android:id/cart_item_price")
	private AndroidElement checkPrice;
	
	MethodsClass m = new MethodsClass();
	
	public void searchResturantPage(AndroidDriver<MobileElement> driver) throws InterruptedException
	{
		m.clickElement(searchBar1,driver);
		m.clickElement(searchBar2,driver);
		m.enterText(searchBar2, "Grubhub goods",driver);
		m.clickElement(resturantSuggestion,driver);	
	}
	public void addItemsPage(AndroidDriver<MobileElement> driver) throws InterruptedException
	{
		m.clickElement(largePizzaCheese,driver);
		m.clickElement(addButton,driver);
		Thread.sleep(6000);
		m.scrollViaCordinates(driver);
		m.clickElement(chickenWings,driver);
		m.clickElement(addButton,driver);
	}	
	public void removeItems(AndroidDriver<MobileElement> driver)
	{
		m.clickElement(viewOrderButton, driver);
		m.clickElement(removeChickenWingsItem, driver);
		m.clickElement(deleteFoodItemButton, driver);
		m.clickElement(removeButton, driver);
	}
	public void checkPricing(AndroidDriver<MobileElement> driver) throws InterruptedException
	{
		System.out.println("*********The price of the product is : "+m.getText(checkPrice, driver));
	}
}
