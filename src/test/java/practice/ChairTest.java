package practice;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class ChairTest {
	
	@Test
	public void chairTest() throws URISyntaxException, MalformedURLException, InterruptedException
	{
		DesiredCapabilities dc= new DesiredCapabilities();
		dc.setCapability("platformName", "Android");
		dc.setCapability("automationName", "uiautomator2");
		dc.setCapability("deviceName", "onePlus Nord");
		dc.setCapability("UDID", "5c9af887");
		dc.setCapability("noReset", true);
		dc.setCapability("autoGrantPermission", true);
		dc.setCapability("hiddenApiPolicy", true);
		dc.setCapability("platformVersion", "12");
		dc.setCapability("appPackage", "com.ingka.ikea.app");
		dc.setCapability("appActivity", ".splash.FirstEntryActivity");
		
		URI uri= new URI("http://localhost:4723");
		URL u = uri.toURL();
		AndroidDriver driver= new AndroidDriver(u, dc);
		driver.activateApp("com.ingka.ikea.app");
		
	Thread.sleep(5000);
		
	//scroll to furniture
	
	driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector())"
						+ ".scrollIntoView(text(\"Furniture\"))"));
			
	Thread.sleep(2000);
	WebElement furniture = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Furniture']"));
	
	((JavascriptExecutor)driver).executeScript("mobile:clickGesture",
			ImmutableMap.of("elementId",((RemoteWebElement)furniture).getId()));
	
	Thread.sleep(2000);
		
	//click on category
	WebElement category = driver.findElement(AppiumBy.xpath("//android.widget.RadioButton[@text='Category']"));
	((JavascriptExecutor)driver).executeScript("mobile:clickGesture",
			ImmutableMap.of("elementId",((RemoteWebElement)category).getId()));
	
	Thread.sleep(3000);	
	//click on chair checkbox
	WebElement chairBox = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Chairs']/following-sibling::android.view.View"));
	((JavascriptExecutor)driver).executeScript("mobile:clickGesture",
			ImmutableMap.of("elementId",((RemoteWebElement)chairBox).getId()));
	
	Thread.sleep(2000);	
	
	//click on view
	WebElement viewBtn = driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id='com.ingka.ikea.app:id/view_filtered_content']"));
	((JavascriptExecutor)driver).executeScript("mobile:clickGesture",
			ImmutableMap.of("elementId",((RemoteWebElement)viewBtn).getId()));
	
	Thread.sleep(3000);
	
	//scroll to product
	
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector())"
							+ ".scrollIntoView(text(\"MAMMUT\"))"));
		
	Thread.sleep(3000);

	
	//click on product
	WebElement prod = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='mammut']"));;
	
	((JavascriptExecutor)driver).executeScript("mobile:clickGesture",
			ImmutableMap.of("elementId",((RemoteWebElement)prod).getId()));
	
	Thread.sleep(3000);
	
	//click on chair image
	
	WebElement chairImage = driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@resource-id='com.ingka.ikea.app:id/product_image']"));
	
	((JavascriptExecutor)driver).executeScript("mobile:clickGesture",
			ImmutableMap.of("elementId",((RemoteWebElement)chairImage).getId()));
	
	Thread.sleep(3000);
	
	//swipetoleft
	WebElement image = driver.findElement(AppiumBy.id("com.ingka.ikea.app:id/image"));
	
	((JavascriptExecutor)driver).executeScript("mobile:swipeGesture",
			ImmutableMap.of("elementId",((RemoteWebElement)image).getId(),"direction","left",
					"percent",0.75));
	
	Thread.sleep(3000);
	//pinch Open

	WebElement image2 = driver.findElement(AppiumBy.id("com.ingka.ikea.app:id/image"));
	((JavascriptExecutor)driver).executeScript("mobile:pinchOpenGesture",
			ImmutableMap.of("elementId",((RemoteWebElement)image2).getId(),
					"percent",0.75));
	
	Thread.sleep(2000);
	//pinch Close
	((JavascriptExecutor)driver).executeScript("mobile:pinchCloseGesture",
			ImmutableMap.of("elementId",((RemoteWebElement)image2).getId(),
					"percent",0.75));
	}

}
