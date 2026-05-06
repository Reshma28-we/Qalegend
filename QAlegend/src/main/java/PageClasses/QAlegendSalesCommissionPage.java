package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QAlegendSalesCommissionPage {

	
	WebDriver driver;
	@FindBy(xpath = "//i[@class='fa fa-handshake-o']")
	WebElement SalesCommissionAgentbutton;

	@FindBy(xpath = "//button[@class='btn btn-primary btn-modal pull-right']")
	WebElement Addsalescommissionbutton;
	
	@FindBy(id = "surname")
	WebElement Prefixbutton;
	
	@FindBy(id = "first_name")
	WebElement Firstnamebutton;
	
	@FindBy(id = "last_name")
	WebElement Lastnamebutton;
	
	@FindBy(id = "email")
	WebElement Emailbutton;
	
	@FindBy(id = "contact_no")
	WebElement Contactnumberbutton;
	
	@FindBy(id = "address")
	WebElement Addressbutton;
	
	@FindBy(id = "cmmsn_percent")
	WebElement Commissionpercentagebutton;
	
	@FindBy(xpath = "//button[text()='Save']")
	WebElement Commissionsavebutton;

public QAlegendSalesCommissionPage(WebDriver driver) {
	// TODO Auto-generated constructor stub
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

public void salesCommissionAgentOption() {
	
	PageUtilities.clickOnElement(SalesCommissionAgentbutton);
}
public void clickOnAddSalesCommissionOption() {
	PageUtilities.clickOnElement(Addsalescommissionbutton);
}
public void insertSalesCommisionDetails(String prefix,String firstname,String lastname,String email,
String contactno,String address,String commissionpercentage) {
	
	PageUtilities.enterText(Prefixbutton, prefix);
	PageUtilities.enterText(Firstnamebutton, firstname);
	PageUtilities.enterText(Lastnamebutton, lastname);
	PageUtilities.enterText(Emailbutton, email);
	PageUtilities.enterText(Contactnumberbutton, contactno);
	PageUtilities.enterText(Addressbutton, address);
	PageUtilities.enterText(Commissionpercentagebutton, commissionpercentage);
}
public void clickOnCommissionSaveOption() {
	
	PageUtilities.clickOnElement(Commissionsavebutton);
}
}