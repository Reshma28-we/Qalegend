package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utilities.PageUtilities;

public class QAlegendContactsPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "(//i[@class='fa fa-address-book'])[1]")
	WebElement Contactsbutton;
	
	@FindBy(xpath = "(//i[@class='fa fa-star'])[1]")
	WebElement Suppliersbutton;
	
	@FindBy(xpath = "//button[@class='btn btn-block btn-primary btn-modal']")
	WebElement Addsupplierbutton;
	
	@FindBy(xpath = "(//*[@id='contact_type'])[2]")
	WebElement Contacttypebox;
    
    @FindBy(id = "name")
    WebElement Suppliername;
    
    @FindBy(id = "supplier_business_name")
    WebElement Businessname;
    
    @FindBy(id = "contact_id")
    WebElement Contactid;
    
    @FindBy(id = "tax_number")
    WebElement Taxnumber;
    
    @FindBy(id="opening_balance")
    WebElement Openingbalance;

    @FindBy(name = "pay_term_type")
    WebElement Payterm;
    
    @FindBy(id = "mobile")
    WebElement Mobilenumber;
    
    @FindBy(id = "city")
    WebElement City;
    
    @FindBy(xpath = "//button[text()='Save']")
    WebElement Supplierssavebutton;
    
    

public QAlegendContactsPage(WebDriver driver) {
	// TODO Auto-generated constructor stub
	this.driver=driver;
	PageFactory.initElements(driver, this);
}




public void clickOnContactsOption() {
	
	PageUtilities.clickOnElement(Contactsbutton);
}
public void clickOnSuppliersOption() {
	PageUtilities.clickOnElement(Suppliersbutton);
}
public void clickOnAddSupplierOption() {
	PageUtilities.clickOnElement(Addsupplierbutton);
}
public void insertSuppliersDetails(String con,String name,String Business,String contactidnumber,String tax,String balance,
		String mobile,String cityname) {
	
	PageUtilities.dropdownSelectByVisibleText(Contacttypebox, con);//check
	PageUtilities.enterText(Suppliername, name);
	PageUtilities.enterText(Businessname, Business);
	PageUtilities.enterText(Contactid, contactidnumber);
	PageUtilities.enterText(Taxnumber, tax);
	PageUtilities.enterText(Openingbalance, balance);
	PageUtilities.enterText(Mobilenumber, mobile);
	PageUtilities.enterText(City, cityname);
	
}
public void supplierSaveOption() {
	PageUtilities.clickOnElement(Supplierssavebutton);
}
}









