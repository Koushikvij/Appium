package com.generalstore;

import java.net.MalformedURLException;

import org.testng.Assert;

import com.mobile.objects.GeneralStore.FormPage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class validateToastMsgs extends Base{

	public static void main(String[] args) throws MalformedURLException {
		startServer();
		AndroidDriver<AndroidElement> driver=getDriver("emulator");
		FormPage formPage=new FormPage(driver);
		
		//The default class name for toast message is android.widget.Toast
		formPage.LetsShopButton.click();		
		String toastMsgName = formPage.ToastMessage.getAttribute("name");
		System.out.println("Encountered the following error message:");
		System.out.println(toastMsgName);		
		Assert.assertEquals("Please enter your name",toastMsgName);
		stopServer();
	}

}
