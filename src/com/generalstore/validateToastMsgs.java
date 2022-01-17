package com.generalstore;

import java.net.MalformedURLException;

import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class validateToastMsgs extends Base{

	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver=getDriver("emulator");
		
		//The default class name for toast message is android.widget.Toast
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		String toastMsgName = driver.findElementByXPath("//android.widget.Toast[1]").getAttribute("name");
		System.out.println("Encountered the following error message:");
		System.out.println(toastMsgName);		
		Assert.assertEquals("Please enter your name",toastMsgName);
	}

}
