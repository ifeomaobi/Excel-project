package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddCustomerTest {
	
	WebDriver driver;
	
	ExcelReader exlread = new ExcelReader("src\\main\\java\\data\\TestData.xlsx");
	String userName = exlread.getCellData("Login", "UserName", 2);
	String password = exlread.getCellData("Login", "Password", 2);
	String fullname = exlread.getCellData("Contactinfo", "FullName", 2);
	String companyname = exlread.getCellData("Contactinfo", "CompanyName", 2);
	String email = exlread.getCellData("Contactinfo", "EmailAddress", 2);
	String phone = exlread.getCellData("Contactinfo", "Phone", 2);
	String address = exlread.getCellData("Contactinfo", "Address", 2);
	String city = exlread.getCellData("Contactinfo", "City", 2);
	String country = exlread.getCellData("Contactinfo", "Country", 2);
	String state = exlread.getCellData("Contactinfo", "State", 2);
	String zip = exlread.getCellData("Contactinfo", "ZipCode", 2);
	
	
	
	@Test
	public void validUserShouldBeAbleToAddCustomer() throws InterruptedException {
		
		driver = BrowserFactory.init();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(userName);
		loginPage.insertPassword(password);
		loginPage.clickonSigninButton();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardHeader();
		dashboardPage.clickOnCustomerButton();
		dashboardPage.clickOnAddCustomerButton();
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.insertfullname(fullname);
		addCustomerPage.insertCompanyName(companyname);
		addCustomerPage.insertEmailAddress(email);
		addCustomerPage.insertPhone(phone);
		addCustomerPage.insertAddress(address);
		addCustomerPage.insertCountry(country);
		addCustomerPage.insertCity(city);
		addCustomerPage.insertState(state);
		addCustomerPage.insertZipcode(zip);
		addCustomerPage.clicksubmit();
		
		dashboardPage.clickonListCustomerButton();
		addCustomerPage.verifyEnteredName();
	}

}
