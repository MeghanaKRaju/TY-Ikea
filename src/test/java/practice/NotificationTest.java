package practice;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class NotificationTest {

	@Test
	public void notificationTest() throws URISyntaxException, MalformedURLException, InterruptedException
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
		driver.findElement(AppiumBy.accessibilityId("Inbox")).click();
		
		Thread.sleep(2000);
		//click on notification settings
		driver.findElement(AppiumBy.accessibilityId("Notification settings")).click();
		
		Thread.sleep(2000);
		//status check
		boolean status = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='IKEA Family offers']")).isDisplayed();
		System.out.println(status);
	}
		
}
