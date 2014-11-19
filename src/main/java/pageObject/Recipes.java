package pageObject;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Log;

/**
 * @author raj
 *
 */
public class Recipes {
	
	  protected AppiumDriver driver;
	  protected WebDriverWait wait;
	
	public Recipes(final AppiumDriver driver) {
		this.driver=driver;
		wait= new WebDriverWait(driver, 30);
		}
	
	
	/**
	 * Method for Page Verfication
	 */
	public void isDisplyed( ){
		try {
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("Recipes")));
			Log.logPass("Page Has been Loaded");	
		} catch (Exception e){
			Log.logFail("Page not loaded ");
		}
		
	}

	/**
	 * @param recipename
	 * @Method for adding Recipe Here 
	 */
	public void addRecipe(String recipename){
		try {
			driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[3]")).click();
			Log.log("Adding New recipe "+recipename);
			WebElement recipe=driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextField[1]/UIATextField[1]"));
			recipe.sendKeys(recipename);
			save();
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("Ingredients")));
			Log.logPass("Recipe has been sucessfully added");
		} catch (Exception e){
			Log.logFail("something went wrong while adding the recipe "   + recipename);
			
		}
		
	}
	
	/**
	 * 
	 */
	public void editRecipeDetails(String ingredient ,String amount ){
		try {
			editdetails();
			Log.log("Adding the Ingredient ");
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("Insert Add Ingredient")));
			driver.findElement(By.name("Insert Add Ingredient")).click();
			driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIATextField[1]/UIATextField[1]")).sendKeys(ingredient);
			driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIATextField[1]")).sendKeys(amount);
			save();
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("Ingredients")));
			Log.logPass("sucessfully added the Ingredient as "+ingredient +"\n"  + amount);
			done();
			backToRecipes();
			Log.log("Returing back to the Main Page ");
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("Recipes")));
			Log.logPass("Sucessfully Return to Main Page ");
			
			
		} catch (Exception e){
			Log.logFail("went wrong while adding the Recipe Details");
		}
		
		
	}
	
	
	/**
	 * Method for go Back to recipes Page
	 */
	public void backToRecipes(){
		driver.findElement(By.name("Recipes")).click();
	}
	
	
	/**
	 * Method for Update the Recipes 
	 */
	public void save (){
		driver.findElement(By.name("Save")).click();
	}
	
	/**
	 * @Method for edit details
	 */
	public void editdetails(){
		driver.findElement(By.name("Edit")).click();
		
	}
	
	/**
	 * Method for Clicking ON Done 
	 */
	public void done(){
		
		driver.findElement(By.name("Done")).click();
	}
	
	
	
}
