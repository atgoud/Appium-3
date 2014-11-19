package com.demo.recipe;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.io.File;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import pageObject.Recipes;
import utils.Log;

/**
 * @author raj
 *
 */
public class TestRecipe {
	
	private AppiumDriver driver;

	
	@Before 
	public void setUp() throws Exception{
		//Setup Appium with Details 
		 File appDir = new File("/Users/raj/Downloads/iPhoneCoreDataRecipes/Build/Release-iphonesimulator");
		 File app = new File(appDir, "Recipes.app");
		 final DesiredCapabilities capabilities = new DesiredCapabilities();
		 capabilities.setCapability("automationName", "Appium");
		 capabilities.setCapability("platformName", "iOS");
		 capabilities.setCapability("deviceName", "iPad 2");
		 capabilities.setCapability("autoAcceptAlerts", "true");
		 capabilities.setCapability("noReset", "true");
		 capabilities.setCapability("app", app.getAbsolutePath());
		 capabilities.setCapability("bundleId", "com.example.apple-samplecode");
		 driver = new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities) {
			public MobileElement scrollToExact(String arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			public MobileElement scrollTo(String arg0) {
				// TODO Auto-generated method stub
				return null;
			}
		};
		
		Log.log("Launching the device Simulator ");
		 
			
	}
	
	@After
	public void tearDown() throws Exception{
		 Log.log("closing the app  ");
		//driver.quit();
	}
	
	@Test
	public void testAddRecipes() throws InterruptedException {
		 final Recipes nativeapp= new Recipes(driver);
		 	nativeapp.isDisplyed();
		 	Thread.sleep(1000);
		 	nativeapp.addRecipe("RICE");
		 	//nativeapp.editRecipeDetails("BrownRice", "100G");
	}

}
