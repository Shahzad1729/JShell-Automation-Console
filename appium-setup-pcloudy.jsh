import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.support.*;
import java.time.*;
import java.util.*;


public void listFilesInDirectory(String remoteDirPath) throws IOException, IOException {
		Process process = new ProcessBuilder("adb", "shell", "ls", "-l", remoteDirPath)
				.redirectErrorStream(true)
				.start();

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
			String line;
			System.out.println("Files in " + remoteDirPath + ":");
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		}
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


public void swipeLeft(WebElement element, int time) {
		
		Dimension screenDim = element.getSize();
		Point location = element.getLocation();

		int x = location.x + screenDim.getWidth() / 2;
		int y = location.y + screenDim.getHeight() / 2;

		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence actionList = new Sequence(finger, 1);
		actionList.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x, y));
		actionList.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		actionList.addAction(finger.createPointerMove(Duration.ofMillis(time), PointerInput.Origin.viewport(), 0, y));
		actionList.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		((AndroidDriver) driver).perform(Arrays.asList(actionList));
	}
	
	
	public void swipeLeftToElement(WebElement fromElement, WebElement toElement, int durationMs) {

    // Get center of start element
    Dimension fromSize = fromElement.getSize();
    Point fromLoc = fromElement.getLocation();
    int startX = fromLoc.x + (fromSize.getWidth() / 2);
    int startY = fromLoc.y + (fromSize.getHeight() / 2);

    // Get center of target (toElement)
    Dimension toSize = toElement.getSize();
    Point toLoc = toElement.getLocation();
    int endX = toLoc.x + (toSize.getWidth() / 2);
    int endY = toLoc.y + (toSize.getHeight() / 2);  // Typically same Y, but this is more robust

    // Create swipe gesture from start to end point
    PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
    Sequence swipe = new Sequence(finger, 1);

    swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
    swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
    swipe.addAction(finger.createPointerMove(Duration.ofMillis(durationMs), PointerInput.Origin.viewport(), endX, endY));
    swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

    ((AndroidDriver) driver).perform(Arrays.asList(swipe));
}

	
	
	
	
			String appPackage = "";
			String appActivity = "";
			String apkName = "";
			
			
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			
            capabilities.setCapability("appium:pCloudy_Username", "");
			capabilities.setCapability("appium:pCloudy_ApiKey", "");
			
			capabilities.setCapability("appium:pCloudy_ApplicationName", apkName);
			capabilities.setCapability("appium:pCloudy_DurationInMinutes", 100);
			capabilities.setCapability("appium:pCloudy_DeviceFullName", "GOOGLE_Pixel7Pro_Android_13.0.0_2d207");
			capabilities.setCapability("appium:platformName", "Android");
			capabilities.setCapability("appium:platformVersion", "12.0.0");
			capabilities.setCapability("appium:newCommandTimeout", 600);
			capabilities.setCapability("appium:launchTimeout", 90000);
			capabilities.setCapability("appium:automationName", "uiautomator2");
			capabilities.setCapability("appium:appPackage", appPackage);
			capabilities.setCapability("appium:appActivity", appActivity);
			capabilities.setCapability("appium:noSign",true);
			capabilities.setCapability("appium:noReset", true);
			capabilities.setCapability("appium:uiautomator2ServerLaunchTimeout", 200000);
			capabilities.setCapability("appium:uiautomator2ServerInstallTimeout", 120000);
			capabilities.setCapability("appium:ignoreHiddenApiPolicyError", true);
			capabilities.setCapability("appium:adbExecTimeout", 95000);
			capabilities.setCapability("appium:androidInstallTimeout", 100000);
			capabilities.setCapability("appium:appiumVersion", "2.0.0");
			capabilities.setCapability("appium:pCloudy_EnableVideo", "true");
			capabilities.setCapability("appium:pCloudy_EnablePerformanceData", "true");
			capabilities.setCapability("appium:pCloudy_EnableDeviceLogs", "true");
			capabilities.setCapability("appium:pCloudy_WildNet", "false");

			AndroidDriver driver = new AndroidDriver(new URL("https://example.com/appiumcloud/wd/hub"), capabilities);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			System.out.println("Driver created");
			

	
	


