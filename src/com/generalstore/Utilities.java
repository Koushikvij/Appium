package com.generalstore;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Utilities {
	AndroidDriver<AndroidElement> driver;
	public Utilities(AndroidDriver<AndroidElement> driver)
	{
		this.driver=driver;
	}

	public void AndroidMove(String direction)
	{
		switch(direction.toUpperCase().trim())
		{
			case "BACK":
				driver.pressKey(new KeyEvent(AndroidKey.BACK));
			case "FORWARD":
				driver.pressKey(new KeyEvent(AndroidKey.FORWARD));
		}
	}
	
	public void Tap(WebElement element)
	{
		waitForElement(element);	
		TouchAction actions=new TouchAction(driver);	
		actions.tap(tapOptions().withElement(element(element))).perform();
		actions=null;		
	}
	
	public void LongPress(WebElement element)
	{
		waitForElement(element);	
		TouchAction actions=new TouchAction(driver);
		actions.longPress(longPressOptions().withElement(element(element)).withDuration(ofSeconds(3))).release().perform();
		actions=null;		
	}
	
	public void scrollIntoView(String scrollText)
	{
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+scrollText+"\"));");		
		//This type of scrolling is not working in some OSs and to avoid this we have the below command
		//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + scrollText + "\").instance(0))"));   
	}
	
	public boolean waitForElement(WebElement targetResourceElement)
	{
		boolean isElementPresent;
		try{
			MobileElement mobileElement =  (MobileElement) targetResourceElement;
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(mobileElement));
			isElementPresent = mobileElement.isDisplayed();
			return isElementPresent;	
		}catch(Exception e){
			isElementPresent = false;
			System.out.println(e.getMessage());
			return isElementPresent;
		}
	}
}
