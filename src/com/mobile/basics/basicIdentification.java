package com.mobile.basics;

import java.net.MalformedURLException;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class basicIdentification extends Base{
	
	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver=getDriver("realdevice");
		//xpath syntax
		//tagname[@attributename='value']
		driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
		driver.findElementById("android:id/checkbox").click();
		driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		driver.findElementByClassName("android.widget.EditText").click();
		driver.findElementByClassName("android.widget.EditText").sendKeys("Hello World");
		driver.findElementsByClassName("android.widget.Button").get(1).click();
	}

}
