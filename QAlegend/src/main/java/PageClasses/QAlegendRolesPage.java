package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QAlegendRolesPage {
	
	WebDriver driver;
	@FindBy(xpath = "(//i[@class='fa fa-briefcase'])[1]")
	WebElement Rolesbutton;
	
	@FindBy(xpath = "//a[@class='btn btn-block btn-primary']")
    WebElement Addrolebutton;
	
	@FindBy(id = "name")
	WebElement Rolenameox;
	
	@FindBy(xpath = "(//ins[@class='iCheck-helper'])[1]")
	WebElement Usertypebutton;
	
	@FindBy(xpath = "//button[text()='Save']")
	WebElement Rolessavebutton;
	
	@FindBy(xpath = "//input[@class='form-control input-sm']")
	WebElement Rolesearch;
	
	
	
	public QAlegendRolesPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}



	public void clickOnRolesOption() {
		
	PageUtilities.clickOnElement(Rolesbutton);
		
		
	}

	public void clickOnAddRolesOption() {
		PageUtilities.clickOnElement(Addrolebutton);
	}
	public void enterRoleNameOption(String rolename) {
		PageUtilities.enterText(Rolenameox, rolename);
		
	}
	public void clickOnUserTypeOption() {
		PageUtilities.clickOnElement(Usertypebutton);
}
	public void clickOnRolesSaveOption() {
		PageUtilities.clickOnElement(Rolessavebutton);
	}
	}
