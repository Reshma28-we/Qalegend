package QAlegendTestCases;

import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import AutomationCore.BaseClass;
import PageClasses.QAlegendBrandsPage;
import PageClasses.QAlegendContactsPage;
import PageClasses.QAlegendCustomerGroupsPage;
import PageClasses.QAlegendCustomersPage;
import PageClasses.QAlegendHomePage;
import PageClasses.QAlegendLoginPage;
import PageClasses.QAlegendProductsPage;
import PageClasses.QAlegendRolesPage;
import PageClasses.QAlegendSalesCommissionPage;
import PageClasses.QAlegendUserPage;
import PageClasses.QAlegendVariations;
import Utilities.ExcelUtility;

public class TestCases extends BaseClass{
	
	WebDriver driver;
	QAlegendLoginPage loginpage;
	QAlegendHomePage homepage;
	QAlegendUserPage userpage;
	QAlegendRolesPage rolepage;
	QAlegendSalesCommissionPage salescommissionpage;
	QAlegendContactsPage contactspage;
	QAlegendCustomersPage customerpage;
	QAlegendCustomerGroupsPage customergroupspage;
	QAlegendProductsPage productspage;
	QAlegendBrandsPage brandspage;
	QAlegendVariations variationpage;
	Properties prop;//prop obj declaration properties is class
	FileReader reader;
	
	@BeforeMethod(groups = {"smoketest","regression"})
	@Parameters({"Browser"})
	public void initialization(String browser) throws Exception
	{
	prop=new Properties();
	reader=new FileReader(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\TestData.properties");
	prop.load(reader);
	driver = browserIntialization(browser);// open browser
	driver.get(prop.getProperty("url"));
	driver.manage().window().maximize(); // to maximize the page
    loginpage=new QAlegendLoginPage(driver);	
    homepage=new QAlegendHomePage(driver);
    userpage=new QAlegendUserPage(driver);
    rolepage=new QAlegendRolesPage(driver);
    salescommissionpage=new QAlegendSalesCommissionPage(driver);
    contactspage=new QAlegendContactsPage(driver);
    customerpage=new QAlegendCustomersPage(driver);
    customergroupspage=new QAlegendCustomerGroupsPage(driver);
    productspage=new QAlegendProductsPage(driver);
    brandspage=new QAlegendBrandsPage(driver);
    variationpage=new QAlegendVariations(driver);
  
 
   
}
	@Test
	public void createUser() throws IOException {      
		loginpage.loginToQAlegend(prop.getProperty("username"),prop.getProperty("password"));
		homepage.clickOnEndTour();
		homepage.clickOnUserManagementOption();
		homepage.clickOnUserAction();
		userpage.clickOnUserAddOption();
		Random rand=new Random();//to avoid duplicate  reshma name two times is there it becomes duplicate so avoid that along with name 
		//one number will generate so it wont get duplicated
		int randomnumber=rand.nextInt(10000);
		String prefix=ExcelUtility.getString(1,0,"//src//main//java//resources//Userdetails.xlsx", "Sheet1");
		String firstname=randomnumber+ExcelUtility.getString(1,1,"//src//main//java//resources//Userdetails.xlsx", "Sheet1")+randomnumber;
		String lastname=ExcelUtility.getString(1,2,"//src//main//java//resources//Userdetails.xlsx", "Sheet1");
		String email=randomnumber+ExcelUtility.getString(1,3,"//src//main//java//resources//Userdetails.xlsx", "Sheet1");
		String username=randomnumber+ExcelUtility.getString(1,4,"//src//main//java//resources//Userdetails.xlsx", "Sheet1");
		String password=randomnumber+ExcelUtility.getString(1,5,"//src//main//java//resources//Userdetails.xlsx", "Sheet1");
		String confirmpassword=randomnumber+ExcelUtility.getString(1,6,"//src//main//java//resources//Userdetails.xlsx", "Sheet1");
		String salescommissionpercentage=ExcelUtility.getNumeric(1,7,"//src//main//java//resources//Userdetails.xlsx", "Sheet1");
		//userpage.insertUserQAlegend("Mrs","Reshma", "Devi", "Reshmadevi20@gmail.com", "Reshma", "Reshma@28", "Reshma@28","2");
		userpage.insertUserQAlegend(prefix,firstname, lastname, email, username, password, confirmpassword,salescommissionpercentage);
		userpage.clickOnSaveButton();
		userpage.enterUserToSearch("Reshma");
		userpage.deleteUser();
		userpage.enterUserToSearch("Reshma");
		Assert.assertEquals(userpage.validatingTheMessage(), "No matching records found");
		
	
	}
	@Test
	public void addRole() {
		loginpage.loginToQAlegend(prop.getProperty("username"),prop.getProperty("password"));
		homepage.clickOnEndTour();
		homepage.clickOnUserManagementOption();
		rolepage.clickOnRolesOption();
		rolepage.clickOnAddRolesOption();
		rolepage.enterRoleNameOption("ReshmaTester");
		rolepage.clickOnUserTypeOption();
		rolepage.clickOnRolesSaveOption();
		
	}
	@Test
	public void commissionPage() throws IOException {
		loginpage.loginToQAlegend(prop.getProperty("username"),prop.getProperty("password"));
		homepage.clickOnEndTour();
		homepage.clickOnUserManagementOption();
		salescommissionpage.salesCommissionAgentOption();
		salescommissionpage.clickOnAddSalesCommissionOption();
		Random rand=new Random();
		int randomnumber=rand.nextInt(10000);
		String prefix=ExcelUtility.getString(1,0,"//src//main//java//resources//Userdetails.xlsx", "Sheet2");
		String firstname=randomnumber+ExcelUtility.getString(1,1,"//src//main//java//resources//Userdetails.xlsx", "Sheet2")+randomnumber;
		String lastname=ExcelUtility.getString(1,2,"//src//main//java//resources//Userdetails.xlsx", "Sheet2");
		String email=randomnumber+ExcelUtility.getString(1,3,"//src//main//java//resources//Userdetails.xlsx", "Sheet2");
		String contactno=ExcelUtility.getNumeric(1,4,"//src//main//java//resources//Userdetails.xlsx", "Sheet2");
		String address=ExcelUtility.getString(1,5,"//src//main//java//resources//Userdetails.xlsx", "Sheet2");
		String salescommissionpercentage =ExcelUtility.getNumeric(1,6,"//src//main//java//resources//Userdetails.xlsx", "Sheet2");
		salescommissionpage.insertSalesCommisionDetails(prefix, firstname, lastname, email, contactno, address, salescommissionpercentage);
		salescommissionpage.clickOnCommissionSaveOption();
			
		
	}
	@Test
	public void contactsPage() throws IOException {
		loginpage.loginToQAlegend(prop.getProperty("username"),prop.getProperty("password"));
		homepage.clickOnEndTour();
		homepage.clickOnUserManagementOption();
		contactspage.clickOnContactsOption();
		contactspage.clickOnSuppliersOption();
		contactspage.clickOnAddSupplierOption();
		Random rand=new Random();
		int randomnumber=rand.nextInt(10000);
		String contacttype=ExcelUtility.getString(1,0,"//src//main//java//resources//Userdetails.xlsx", "Sheet3");
		String name=randomnumber+ExcelUtility.getString(1,1,"//src//main//java//resources//Userdetails.xlsx", "Sheet3")+randomnumber;
		String businessname=ExcelUtility.getString(1,2,"//src//main//java//resources//Userdetails.xlsx", "Sheet3");
		String contactid=ExcelUtility.getNumeric(1,3,"//src//main//java//resources//Userdetails.xlsx", "Sheet3");
		String taxnumber=ExcelUtility.getString(1,4,"//src//main//java//resources//Userdetails.xlsx", "Sheet3");
		String openingbalance=ExcelUtility.getNumeric(1,5,"//src//main//java//resources//Userdetails.xlsx", "Sheet3");
		String mobile =ExcelUtility.getNumeric(1,6,"//src//main//java//resources//Userdetails.xlsx", "Sheet3");
		String city =ExcelUtility.getString(1,7,"//src//main//java//resources//Userdetails.xlsx", "Sheet3");
	    contactspage.insertSuppliersDetails(contacttype,name, businessname, contactid, taxnumber, openingbalance, mobile, city);
	    contactspage.supplierSaveOption();
	}
	@Test
	public void customersPage() throws IOException {
		loginpage.loginToQAlegend(prop.getProperty("username"),prop.getProperty("password"));
		homepage.clickOnEndTour();
		homepage.clickOnUserManagementOption();
		contactspage.clickOnContactsOption();
		customerpage.clickOnCustomerOption();
		customerpage.clickonAddCustomerOption();
		Random rand=new Random();
		int randomnumber=rand.nextInt(10000);
		String name=randomnumber+ExcelUtility.getString(1,0,"//src//main//java//resources//Userdetails.xlsx", "Sheet4")+randomnumber;
		String customercontactid=ExcelUtility.getNumeric(1,1,"//src//main//java//resources//Userdetails.xlsx", "Sheet4");
		String customertaxnumber=ExcelUtility.getString(1,2,"//src//main//java//resources//Userdetails.xlsx", "Sheet4");
		String customeropeningbalance=ExcelUtility.getNumeric(1,3,"//src//main//java//resources//Userdetails.xlsx", "Sheet4");
		String customermobile =ExcelUtility.getNumeric(1,4,"//src//main//java//resources//Userdetails.xlsx", "Sheet4");
		String customercity =ExcelUtility.getString(1,5,"//src//main//java//resources//Userdetails.xlsx", "Sheet4");
		customerpage.insertCustomerDetails(name, customercontactid, customertaxnumber, customeropeningbalance, customermobile, customercity);
		customerpage.clickOnCustomerSaveButton();
	}
	@Test
	public void customersGroupsPage() {
		loginpage.loginToQAlegend(prop.getProperty("username"),prop.getProperty("password"));
		homepage.clickOnEndTour();
		homepage.clickOnUserManagementOption();
		contactspage.clickOnContactsOption();
		customergroupspage.clickOnCustomerGroupOption();
		customergroupspage.clickOnAddCustomerGroupOption();
		customergroupspage.insertCustomerGroupsDetails(prop.getProperty("CustomerGroupName"),prop.getProperty("CalculationPercentage"));
		customergroupspage.clickOnCustomerGroupSaveOption();
		
	}
	@Test
	public void productsPage() throws IOException {
		loginpage.loginToQAlegend(prop.getProperty("username"),prop.getProperty("password"));
		homepage.clickOnEndTour();
		homepage.clickOnUserManagementOption();
		productspage.clickOnProductsOption();
		productspage.clickOnListProductsOption();
		productspage.clickOnAddProductsOption();
		Random rand=new Random();
		int randomnumber=rand.nextInt(10000);
		String productname=ExcelUtility.getString(1,0,"//src//main//java//resources//Userdetails.xlsx", "Sheet5");
		//String brand=ExcelUtility.getString(1,1,"//src//main//java//resources//Userdetails.xlsx", "Sheet5");
		//String unit=ExcelUtility.getString(1,2,"//src//main//java//resources//Userdetails.xlsx", "Sheet5");
		//String customeropeningbalance=ExcelUtility.getNumeric(1,3,"//src//main//java//resources//Userdetails.xlsx", "Sheet4");
		//String customermobile =ExcelUtility.getNumeric(1,4,"//src//main//java//resources//Userdetails.xlsx", "Sheet4");
		//String customercity =ExcelUtility.getString(1,5,"//src//main//java//resources//Userdetails.xlsx", "Sheet4");
		productspage.insertProductsDetails(productname, productname, productname, productname, productname, productname, productname, productname, productname);
		
	}
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void variationPage() {
		loginpage.loginToQAlegend(prop.getProperty("username"),prop.getProperty("password"));
		homepage.clickOnEndTour();
		homepage.clickOnUserManagementOption();
		productspage.clickOnProductsOption();
		variationpage.clickOnVariationsoption();
		variationpage.clickOnAddVariationsoption();
		variationpage.insertVariationDetails(prop.getProperty("VariationName"),prop.getProperty("Addvariationvalues"));
		variationpage.clickOnSaveVariationOption();
	}
	
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void brandsPage() {
		loginpage.loginToQAlegend(prop.getProperty("username"),prop.getProperty("password"));
		homepage.clickOnEndTour();
		homepage.clickOnUserManagementOption();
		productspage.clickOnProductsOption();
		brandspage.clickOnBrandOption();
		brandspage.clickOnAddBrandOption();
		brandspage.insertBrandDetails(prop.getProperty("Brandname"),prop.getProperty("Shortdescription"));
		brandspage.clickOnSaveBrandButton();
	
		
	}
}