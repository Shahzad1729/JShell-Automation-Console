import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.support.*;
import java.time.*;
import java.util.*;

import java.net.URL;


public void clickStartOnElement(WebElement element) {
		Dimension screenDim = element.getSize();
		Point location = element.getLocation();

		// Start of the element (slightly inside from the left edge)
		int x = location.x + (int)(screenDim.getWidth() * 0.1);
		int y = location.y + (screenDim.getHeight() / 2);

		System.out.println("Clicking on (x,y) : "+"("+x+","+y+")");

		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence actionList = new Sequence(finger, 1);
		actionList.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x, y));
		actionList.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		actionList.addAction(new Pause(finger, Duration.ofSeconds(1)));
		actionList.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		((AndroidDriver) driver).perform(Arrays.asList(actionList));
	}



public static void scrollUp(int scrollTime, String scrollFrom) {
		Dimension screenDim = driver.manage().window().getSize();

		Double screenWidthHalf = screenDim.getWidth() * 0.5;
		int screenWidthHalfInt = screenWidthHalf.intValue();

		Double screenHeightLowerDouble = screenDim.getHeight() * 0.8;
		int screenHeightLowerInt = screenHeightLowerDouble.intValue();

		Double screenHeightUpperDouble = 0.0;
		if (scrollFrom.equalsIgnoreCase("full")) {
			screenHeightUpperDouble = screenDim.getHeight() * 0.25;
		} else if (scrollFrom.equalsIgnoreCase("middle")) {
			screenHeightUpperDouble = screenDim.getHeight() * 0.5;
		} else {
			
		}

		int screenHeightUpperInt = screenHeightUpperDouble.intValue();


		// Updated code
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence actionList = new Sequence(finger, 1);
		actionList.addAction(finger.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), screenWidthHalfInt, screenHeightUpperInt));
		actionList.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		actionList.addAction(finger.createPointerMove(Duration.ofSeconds(scrollTime), PointerInput.Origin.viewport(), screenWidthHalfInt, screenHeightLowerInt));
		actionList.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		((AndroidDriver) driver).perform(Arrays.asList(actionList));
	}
	
	public void scrollWithRelease(int screenWidthHalfInt, int screenHeightLowerInt, int screenHeightUpperInt,
			int scrollTime) {
	
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence actionList = new Sequence(finger, 1);
		actionList.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), screenWidthHalfInt, screenHeightLowerInt));
		actionList.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		actionList.addAction(finger.createPointerMove(Duration.ofSeconds(scrollTime), PointerInput.Origin.viewport(), screenWidthHalfInt, screenHeightUpperInt));
		actionList.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		((AndroidDriver) driver).perform(Arrays.asList(actionList));

	}

public void scrollDown(int scrollTime, String scrollTill) {
		Dimension screenDim = driver.manage().window().getSize();

		Double screenWidthHalf = screenDim.getWidth() * 0.5;
		int screenWidthHalfInt = screenWidthHalf.intValue();

		Double screenHeightLowerDouble = screenDim.getHeight() * 0.8;
		int screenHeightLowerInt = screenHeightLowerDouble.intValue();
		int screenHeightUpperInt = 0;
		if (scrollTill.equalsIgnoreCase("full")) {
			Double screenHeightUpperDouble = screenDim.getHeight() * 0.2;
			screenHeightUpperInt = screenHeightUpperDouble.intValue();
		} else if (scrollTill.equalsIgnoreCase("half")) {
			Double screenHeightUpperDouble = screenDim.getHeight() * 0.5;
			screenHeightUpperInt = screenHeightUpperDouble.intValue();
		} else if (scrollTill.equalsIgnoreCase("oneThird")) {
			Double screenHeightUpperDouble = screenDim.getHeight() * 0.65;
			screenHeightUpperInt = screenHeightUpperDouble.intValue();
		}
		scrollWithRelease(screenWidthHalfInt, screenHeightLowerInt, screenHeightUpperInt, scrollTime);
	}


// W3C-compliant desired capabilities
DesiredCapabilities caps = new DesiredCapabilities();

caps.setCapability("platformName", "Android");
caps.setCapability("appium:appPackage", "com.rws.gausamriddhi.sit1");
caps.setCapability("appium:appActivity", "com.rws.gausamriddhi.ui.splash.SplashActivity");
caps.setCapability("appium:udid", "127.0.0.1:6555");
caps.setCapability("appium:platformVersion", "12.0.0");
caps.setCapability("appium:automationName", "uiautomator2");
caps.setCapability("appium:ensureWebviewsHavePages", true);
caps.setCapability("appium:nativeWebScreenshot", true);
caps.setCapability("appium:newCommandTimeout", 3600);
caps.setCapability("appium:connectHardwareKeyboard", true);

// Start the Appium session
AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), caps);