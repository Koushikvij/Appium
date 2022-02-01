package com.mobile.basics;

import static java.time.Duration.ofSeconds;
import java.net.MalformedURLException;

import com.mobile.objects.APIDemo.HomePage;
import com.mobile.objects.APIDemo.Views;
import com.mobile.objects.APIDemo.Views_DateWidgets;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class swipedemo extends Base{

	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver=getDriver("emulator");
		HomePage homePage=new HomePage(driver);
		Views views=new Views(driver);
		Views_DateWidgets datewidgets= new Views_DateWidgets(driver);
		
		homePage.ViewLink.click();
		views.DateWidgetsLink.click();
		datewidgets.InlineLink.click();
		datewidgets.Link9.click();
		
		//swipe
		TouchAction actions=new TouchAction(driver);
		actions.longPress(longPressOptions().withElement(element(datewidgets.Link15)).withDuration(ofSeconds(2))).moveTo(element(datewidgets.Link45)).release().perform();
	}

}
