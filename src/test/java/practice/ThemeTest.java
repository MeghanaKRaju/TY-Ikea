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

public class ThemeTest {
	@Test
	public void themeTest() throws URISyntaxException, MalformedURLException, InterruptedException
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
		
		//driver.activateApp("com.ingka.ikea.app");
		Thread.sleep(5000);
		
		WebElement ele = driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='Profile and settings']"));
		
		//click on profile
		((JavascriptExecutor)driver).executeScript("mobile:clickGesture",
				ImmutableMap.of("elementId",((RemoteWebElement)ele).getId()));
		
		Thread.sleep(3000);
		
		//scroll till theme
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector())"
				+ ".scrollIntoView(text(\"Theme\"))"));
		
		Thread.sleep(2000);
		//click on theme
		WebElement theme = driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='Theme']"));
		
		((JavascriptExecutor)driver).executeScript("mobile:clickGesture",
				ImmutableMap.of("elementId",((RemoteWebElement)theme).getId()));

		//click on dark
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Dark']")).click();
		
		
		
		
	}

}
