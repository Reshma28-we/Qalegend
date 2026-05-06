package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QAlegendUserPage {

	WebDriver driver;
	@FindBy(xpath = "//a[@class='btn btn-block btn-primary']")
	WebElement UserAddOption;
	
	@FindBy(id = "surname")
	WebElement Surnamebox;
	
	@FindBy(id = "first_name")
	WebElement Firstnamebox;
	
	@FindBy(id = "last_name")
	WebElement Lastnamebox;
	
	@FindBy(id="email")
	WebElement Emailbox;
	
	@FindBy(id="username")
	WebElement Usernamebox;
	
	@FindBy(id="password")
	WebElement Passwordbox;
	
	@FindBy(id = "confirm_password")
	WebElement Confirmpasswordbox;
	
	@FindBy(id = "cmmsn_percent")
	WebElement Salescommissionbox;
	
	@FindBy(id = "submit_user_button")
	WebElement Submituserbuttonoption;
	
	@FindBy(xpath = "//input[@class='form-control input-sm']")
	WebElement searchButton;
	
	@FindBy(xpath = "//button[@class='btn btn-xs btn-danger delete_user_button']")
	WebElement deleteButton;
	
	@FindBy(xpath = "//button[text()='OK']")
	WebElement areYouSureDeletebutton;
	
	@FindBy(xpath = "//td[@class='dataTables_empty']")
	WebElement DeletedErrorDetector;
	
	
	
	
	public QAlegendUserPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}






	public void clickOnUserAddOption() {
		
		PageUtilities.clickOnElement(UserAddOption);
	}
	
	public void insertUserQAlegend(String surname,String firstname,String lastname,String email,
			String username,String password,String confirmpassword,String salescommission ) {
		
		PageUtilities.enterText(Surnamebox, surname);
		PageUtilities.enterText(Firstnamebox, firstname);
		PageUtilities.enterText(Lastnamebox, lastname);
		PageUtilities.enterText(Emailbox, email);
		PageUtilities.enterText(Usernamebox, username);
		PageUtilities.enterText(Passwordbox, password);
		PageUtilities.enterText(Confirmpasswordbox, confirmpassword);
		PageUtilities.enterText(Salescommissionbox, salescommission);
				
		
		
	}
	public void clickOnSaveButton() {
		PageUtilities.clickOnElement(Submituserbuttonoption);
	}

	public void enterUserToSearch(String username) {
		PageUtilities.enterText(searchButton, username);
	
}
	public void deleteUser() {
		PageUtilities.clickOnElement(deleteButton);
		PageUtilities.clickOnElement(areYouSureDeletebutton);
	}
	public String validatingTheMessage() {
		return(PageUtilities.getElementText(DeletedErrorDetector));
	}
}









