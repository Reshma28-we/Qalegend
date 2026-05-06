package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QAlegendCustomersPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "(//i[@class='fa fa-star'])[2]")
	WebElement Customerbox;
	
	@FindBy(xpath = "//button[@class='btn btn-block btn-primary btn-modal']")
	WebElement Addcustomerbutton;
	
	@FindBy(id = "contact_type")
	WebElement Contacttype;
	
	@FindBy(id = "name")
	WebElement Customername;
	
	@FindBy(id = "contact_id")
	WebElement Customercontactid;
	
	@FindBy(id = "tax_number")
	WebElement Customertaxnumber;
	
	@FindBy(id = "opening_balance")
	WebElement Customeropeningbalance;
	
	@FindBy(id = "mobile")
	WebElement Customermobilenumer;
	
	
	@FindBy(id="city")
	WebElement Customercity;
	
	@FindBy(xpath = "//button[text()='Save']")
	WebElement Customersavebutton;



	public QAlegendCustomersPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}



	public void clickOnCustomerOption() {
		PageUtilities.clickOnElement(Customerbox);
	}
	public void clickonAddCustomerOption() {
		PageUtilities.clickOnElement(Addcustomerbutton);
	}
 
	public void insertCustomerDetails(String customername,String contactid,String taxnumber,String openingbalance,
			String mobile,String city) {
	
		PageUtilities.enterText(Customername, customername);
		PageUtilities.enterText(Customercontactid, contactid);
		PageUtilities.enterText(Customertaxnumber, taxnumber);
		PageUtilities.enterText(Customeropeningbalance, openingbalance);
		PageUtilities.enterText(Customermobilenumer, mobile);
		PageUtilities.enterText(Customercity, city);
		
		
	}
	public void clickOnCustomerSaveButton() {
		PageUtilities.clickOnElement(Customersavebutton);
		
		
	}
	
	
}
