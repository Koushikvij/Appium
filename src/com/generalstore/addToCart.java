package com.generalstore;

import java.net.MalformedURLException;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.testng.Assert;

import com.mobile.objects.Browser.LandingPage;
import com.mobile.objects.GeneralStore.CartPage;
import com.mobile.objects.GeneralStore.FormPage;
import com.mobile.objects.GeneralStore.ProductDetailPage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class addToCart extends Base{

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		AndroidDriver<AndroidElement> driver=getDriver("emulator");
		FormPage formPage=new FormPage(driver);
		ProductDetailPage pdp=new ProductDetailPage(driver);
		CartPage cart=new CartPage(driver);
		LandingPage landing=new LandingPage(driver);
		Utilities util=new Utilities(driver);
		
		//to hide the keyboard
		driver.hideKeyboard();
		formPage.nameField.sendKeys("Hello");
		formPage.FemaleRadioBtn.click();
		
		//Handling spinner utility
		formPage.CountrySpinner.click();
		util.scrollIntoView("Argentina");		
		formPage.Argentina.click();
		formPage.LetsShopButton.click();
		
		//Clicking the right Add to Cart Button
		pdp.clickAddtoCartOfItemByID("Jordan 6 Rings");
		//pdp.clickAddtoCartOfItemByID(driver,"Air Jordan 4 Retro");
		
		//Click Cart button
		pdp.appBarAddtoCartBtn.click();
		util.waitForElement(cart.productName.get(0));

		int count=cart.productName.size();
		int matchCount=0;
		for(int i=0;i<count;i++)
		{
			String itemName=cart.productName.get(i).getText();
			if(itemName.equalsIgnoreCase("Jordan 6 Rings") || itemName.equalsIgnoreCase("Air Jordan 4 Retro"))
				matchCount++;
		}
		if(matchCount==2)
			System.out.println("Both items matches successfully");
		else if(matchCount==1)
			System.out.println("Only one item matches successfully");
		else
			System.out.println("Both items match Failed");
		
		int priceCount=cart.productPrice.size();
		double sum=0;
		for(int j=0; j<priceCount;j++)
		{
			String priceAmt=cart.productPrice.get(j).getText();
			sum=sum+Double.parseDouble(priceAmt.substring(1));
		}
		double totalAmt=Double.parseDouble(cart.totalAmount.getText().substring(1));
		System.out.println("Sum = "+sum+"  totalAmt="+totalAmt);
		Assert.assertEquals(totalAmt, sum);
		
		//Long Press
		util.LongPress(cart.termsButton);
		util.waitForElement(cart.alertTitle);
		System.out.println(cart.alertTitle.isDisplayed());
		cart.alertCloseBtn.click();
		
		//Tap check box
		util.Tap(cart.checkBox);		
		
		//Click Proceed button
		cart.ProceedBtn.click();		
		Thread.sleep(10000);

		//Switch Context
		Set<String> contextNames = driver.getContextHandles();
		for (String contextName : contextNames) {
		    System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
		}
		driver.context((contextNames.toArray())[2].toString()); // set context to WEBVIEW_1

		//do some web testing
		landing.searchBox.sendKeys("Hello");
		landing.searchBox.sendKeys(Keys.ENTER);
		
		//code to press the back button on the Android device
		util.AndroidMove("BACK");
		
		// do more native testing if we want
		driver.context((contextNames.toArray())[0].toString());
	}
}
