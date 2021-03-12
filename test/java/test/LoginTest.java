package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class LoginTest {
	
	WebDriver driver;
	ExcelReader exlread = new ExcelReader("src\\main\\java\\data\\TestData.xlsx");
	String userName = exlread.getCellData("Login", "UserName", 2);
	String password = exlread.getCellData("Login", "Password", 2);
	
	@Test
	public void validUserShouldBeAbleToLogin() {
		
		driver = BrowserFactory.init();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(userName);
		loginPage.insertPassword(password);
		loginPage.clickonSigninButton();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardHeader();
		
		BrowserFactory.tearDown();
	}

}
