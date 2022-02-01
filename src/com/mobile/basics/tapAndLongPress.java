package com.mobile.basics;

import java.net.MalformedURLException;

import com.mobile.objects.APIDemo.HomePage;
import com.mobile.objects.APIDemo.Views;
import com.mobile.objects.APIDemo.Views_ExpandableList;
import com.mobile.objects.APIDemo.Views_ExpandableList_CustomAdaptor;

import static java.time.Duration.ofSeconds;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class tapAndLongPress extends Base{

	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver=getDriver("emulator");
		HomePage homePage=new HomePage(driver);
		Views views=new Views(driver);
		Views_ExpandableList expList=new Views_ExpandableList(driver);
		Views_ExpandableList_CustomAdaptor customadaptor=new Views_ExpandableList_CustomAdaptor(driver);
		
		homePage.ViewLink.click();
		
		//Tap
		TouchAction actions=new TouchAction(driver);
		actions.tap(tapOptions().withElement(element(views.ExpandableListLink))).perform();
		expList.CustomAdapterLink.click();
		
		//Long Press
		actions.longPress(longPressOptions().withElement(element(customadaptor.PeopleNamesLink)).withDuration(ofSeconds(2))).release().perform();
		System.out.println(customadaptor.SampleMenuLink.isDisplayed());
	}

}
