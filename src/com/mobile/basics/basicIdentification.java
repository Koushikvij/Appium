package com.mobile.basics;

import java.net.MalformedURLException;

import com.mobile.objects.APIDemo.HomePage;
import com.mobile.objects.APIDemo.Preference_Dependencies;
import com.mobile.objects.APIDemo.Preferences;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class basicIdentification extends Base{
	
	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver=getDriver("realdevice");
		//xpath syntax
		//tagname[@attributename='value']
		HomePage HP=new HomePage(driver);
		Preferences Pref=new Preferences(driver);
		Preference_Dependencies Pref_Def=new Preference_Dependencies(driver);
		
		HP.PreferenceLink.click();
		Pref.PreferenceDependenciesLink.click();
		Pref_Def.checkBox.click();
		Pref_Def.layout.click();
		Pref_Def.layoutEdit.click();
		Pref_Def.layoutEdit.sendKeys("Hello World");
		Pref_Def.layoutButtons.get(1).click();
	}

}
