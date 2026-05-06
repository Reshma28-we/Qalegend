package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QAlegendVariations {
	
	WebDriver driver;
	
	@FindBy(xpath = "//span[text()='Variations']")
	WebElement VariationsButton;
	
	@FindBy(xpath = "//button[@class='btn btn-block btn-primary btn-modal']")
	WebElement AddVariationsButton;
	
	@FindBy(id = "name")
	WebElement Variationnamefield;
	
	@FindBy(xpath = "(//input[@class='form-control'])[2]")
	WebElement Addvariationvaluesfield;
	
	@FindBy(xpath = "//button[text()='Save']")
	WebElement variationsavebutton;
	
	
	public QAlegendVariations(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnVariationsoption() {
		
		PageUtilities.clickOnElement(VariationsButton);
	}
     public void clickOnAddVariationsoption() {
		
		PageUtilities.clickOnElement(AddVariationsButton);
	}
     public void insertVariationDetails(String variationname,String variationvalue) {
 		
 		PageUtilities.enterText(Variationnamefield, variationname);
 		PageUtilities.enterText(Addvariationvaluesfield, variationvalue);
}
     public void clickOnSaveVariationOption() {
    	 PageUtilities.clickOnElement(variationsavebutton);
    	 	 
    	 
     }
     }
