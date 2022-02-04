package com.generalstore;

import java.io.File;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Base {
	
	public static AppiumDriverLocalService service;

	public static void startServer()
	{
		boolean serverStatus=checkIfServerIsRunning(4723);
		if(serverStatus)
		{
			service.stop();
		}
		service=AppiumDriverLocalService.buildDefaultService();
		service.start();
	}
	
	public static void stopServer()
	{
		service.stop();
	}

	public static boolean checkIfServerIsRunning(int port)
	{
		boolean isServerRunning=false;
		ServerSocket serverSocket;
		try {
			serverSocket=new ServerSocket(port);
			serverSocket.close();
		}
		catch(Exception e)
		{
			isServerRunning=true;
		}
		finally
		{
			serverSocket=null;
		}
		return isServerRunning;
	}
	
	

	public static AndroidDriver<AndroidElement> getDriver(String deviceType) throws MalformedURLException{
		// Setting the properties of Android Driver
		File appDir=new File("src");
		File app=new File(appDir, "General-Store.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		if(deviceType.equalsIgnoreCase("emulator"))
		{
			//Emulator based approach
			cap.setCapability(MobileCapabilityType.DEVICE_NAME,"KoushikAndroid");			
		}
		else if(deviceType.equalsIgnoreCase("realdevice"))
		{
			//Physical Device based approach
			cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Device");
		}
		//cap.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 20);
		cap.setCapability(MobileCapabilityType.APP,app.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		
		//Instantiates the driver object and then deploys the APK file in the emulator and installs and launches the same
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;		
	}
}
