import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.support.*;
import java.time.*;
import java.util.*;

import java.net.URL;

import java.net.MalformedURLException;



// W3C-compliant desired capabilities
DesiredCapabilities capabilities=new DesiredCapabilities();
capabilities.setCapability(CapabilityType.PLATFORM_NAME,"windows");
capabilities.setCapability(CapabilityType.BROWSER_NAME,"chrome");

RemoteWebDriver driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);

driver.get("https://jcms.sit1.cats.jvts.net/portal/login");
driver.manage().window().maximize();