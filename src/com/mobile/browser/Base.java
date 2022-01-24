package com.mobile.browser;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Base {

	public static AndroidDriver<AndroidElement> getDriver(String deviceType) throws MalformedURLException{
		// Setting the properties of Android Driver
		DesiredCapabilities cap = new DesiredCapabilities();
		if(deviceType.equalsIgnoreCase("emulator"))
		{
			//Emulator based approach
			cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel4");			
		}
		else if(deviceType.equalsIgnoreCase("realdevice"))
		{
			//Physical Device based approach
			cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Device");
		}
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 20);
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		
		//Instantiates the driver object and then deploys the APK file in the emulator and installs and launches the same
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;		
	}
}
