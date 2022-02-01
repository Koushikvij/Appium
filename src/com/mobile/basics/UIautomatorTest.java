package com.mobile.basics;

import java.net.MalformedURLException;

import com.mobile.objects.APIDemo.HomePage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class UIautomatorTest extends Base{

	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver=getDriver("emulator");
		HomePage homePage=new HomePage(driver);
		homePage.ViewLink.click();
		//driver.findElementByAndroidUIAutomator("attribute('value')"); -- format for UIAutomator identifier
		//driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		homePage.ViewLink.click();
		//validate clickable feature for all options
		//syntax to use the property values
		//driver.findElementsByAndroidUIAutomator("new UiSelector().property_name(value)");
		int Object_Count = driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)").size();
		System.out.println(Object_Count);
		if(Object_Count == 0)
		{
			System.out.println("All options under Views have Clickable property set to False");
		}
		else
		{
			System.out.println("Some of the options under Views have Clickable property set to True");
		}
	}

}
