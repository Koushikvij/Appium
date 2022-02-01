package com.mobile.basics;

import java.net.MalformedURLException;

import com.mobile.objects.APIDemo.HomePage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class scrollDemo extends Base{

	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver=getDriver("emulator");
		HomePage homePage=new HomePage(driver);
		homePage.ViewLink.click();
				
		//scroll
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Radio Group\"));");
		
	}

}
