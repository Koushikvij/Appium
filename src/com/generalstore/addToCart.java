package com.generalstore;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class addToCart extends Base{

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		AndroidDriver<AndroidElement> driver=getDriver("emulator");
		//to hide the keyboard
		driver.hideKeyboard();

		driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Hello");
		driver.findElementByXPath("//android.widget.RadioButton[@text='Female']").click();
		
		//Handling spinner utility
		driver.findElementById("android:id/text1").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");		
		//This type of scrolling is not working in some OSs and to avoid this we have the below command
		//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + containedText + "\").instance(0))"));   
		
		driver.findElementByXPath("//android.widget.TextView[@text='Argentina']").click();
		
		//Let's Shop Button
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		
		//Searching for a product in the PDP and scrolling into view
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
                + ".resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView("
                + "new UiSelector().text(\"Jordan 6 Rings\"));");
		
		//Clicking the right Add to Cart Button
		boolean blnFlag=clickAddtoCartOfItemByID(driver,"com.androidsample.generalstore:id/productName","Jordan 6 Rings");
		if(!blnFlag)
		{
			System.out.println("Item Not Found !");
		}
		
		//Click Cart button
		driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
		waitForElementByID(driver,"com.androidsample.generalstore:id/productName");
		String lastpageText=driver.findElementById("com.androidsample.generalstore:id/productName").getText();
		System.out.println(lastpageText);
		Assert.assertEquals("Jordan 6 Rings", lastpageText);
	}
	
	public static boolean clickAddtoCartOfItemByID(AndroidDriver<AndroidElement> driver,String listID, String itemName)
	{
		int itemCount=driver.findElementsById(listID).size();
		int index=0;
		boolean blnFlag=false;
		for(index=0;index<itemCount;index++)
		{
			String itmName=driver.findElementsById(listID).get(index).getText();
			if(itmName.equalsIgnoreCase(itemName))
			{
				blnFlag=true;
				break;
			}
		}
		if(blnFlag==true)	
		{
			driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(index).click();
			return blnFlag;
		}
		else
			return blnFlag;
	}
	
	public static boolean waitForElementByID(AndroidDriver<AndroidElement> driver, String targetResourceId)
	{
		boolean isElementPresent;
		try{
			MobileElement mobileElement =  (MobileElement) driver.findElementById(targetResourceId);
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
