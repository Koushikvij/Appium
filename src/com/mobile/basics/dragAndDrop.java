package com.mobile.basics;

import static io.appium.java_client.touch.offset.ElementOption.element;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;

import com.mobile.objects.APIDemo.HomePage;
import com.mobile.objects.APIDemo.Views;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class dragAndDrop extends Base{

	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver=getDriver("emulator");
		HomePage homePage=new HomePage(driver);
		Views view=new Views(driver);
		
		homePage.ViewLink.click();
		view.DragAndDropLink.click();
		
		//drag and drop
		TouchAction actions=new TouchAction(driver);
		WebElement sourceObj=view.DragObjects.get(0);
		WebElement destObj=driver.findElementsByClassName("android.view.View").get(2);
		//actions.longPress(longPressOptions().withElement(element(sourceObj))).moveTo(element(destObj)).release().perform();
		//Use the below syntax when we are not doing additional activities on a single element
		actions.longPress(element(sourceObj)).moveTo(element(destObj)).release().perform();
	
	}

}
