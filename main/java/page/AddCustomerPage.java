package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class AddCustomerPage extends BasePage{
	
	WebDriver driver;
	
	
	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
		
	}
	
//	Library Element
	@FindBy(how = How.XPATH, using = "//input[@id='account']") 
	WebElement FULLNAME_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id=\"cid\"]") 
	WebElement COMPANY_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//input[@id='email']") 
	WebElement EMAIL_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//input[@id='phone']") 
	WebElement PHONE_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//input[@id='address']") 
	WebElement ADDRESS_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//input[@id='city']") 
	WebElement CITY_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//input[@id='state']") 
	WebElement STATE_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//input[@id='zip']") 
	WebElement ZIPCODE_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id=\"country\"]") 
	WebElement COUNTRY_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id='submit']") 
	WebElement SUBMIT_BUTTON_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id=\"summary\"]") 
	WebElement SUMMARY_BUTTON_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[3]/ul/li[2]/a") WebElement CLICK_LIST_CUSTOMER_BUTTON;
	
	
//	Interactive Method
	String enteredName;
	
	public void insertfullname(String fullname) throws InterruptedException {
		Thread.sleep(2000);
		int genNum = randomGenerator(999);
		enteredName = fullname + genNum;
		FULLNAME_FIELD_LOCATOR.sendKeys(enteredName);	
	}
	
	public void insertCompanyName(String companyName) {
		selectDropDown(COMPANY_FIELD_LOCATOR, companyName);	
	}

	public void insertEmailAddress(String email) {
		int genNum = randomGenerator(999);
		EMAIL_FIELD_LOCATOR.sendKeys(genNum + email);
	}
	
	public void insertPhone(String phone) {
		int genNum = randomGenerator(999);
		PHONE_FIELD_LOCATOR.sendKeys(phone + genNum);
	}
	
	public void insertAddress(String Address) {
		ADDRESS_FIELD_LOCATOR.sendKeys(Address);
	}
	public void insertCity(String City) {
		CITY_FIELD_LOCATOR.sendKeys(City);
	}
	
	public void insertState(String State) {
		STATE_FIELD_LOCATOR.sendKeys(State);
	}
	
	public void insertZipcode(String Zipcode) {
		ZIPCODE_FIELD_LOCATOR.sendKeys(Zipcode);
	}
	
	public void insertCountry(String Country) {
		COUNTRY_FIELD_LOCATOR.sendKeys(Country);
		
	}
	
	public void clicksubmit() {
		SUBMIT_BUTTON_LOCATOR.click();
		waitForElement(driver, 7, SUMMARY_BUTTON_LOCATOR );
	}
	
	//tbody/tr[1]/td[3]
	//tbody/tr[2]/td[3]
	//tbody/tr[3]/td[3]
	//tbody/tr[i]/td[3]
	//tbody/tr[9]/td[7]/a[2]
	
	public void verifyEnteredName() {
		String before_xpath = "//tbody/tr[";
		String after_xpath = "]/td[3]";
		
		for(int i=1; i <= 10; i++) {
			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			/*
			 * System.out.println(name); Assert.assertEquals(name, enteredName,
			 * "Entered name does not exist"); break;
			 */
	
			if(name.contains(enteredName)) {
				System.out.println("entered name exist");
				driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[7]/a[2]")).click();
				driver.switchTo().alert().accept();
				driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/button[2]")).click();
				
			}
			
		
		
	}
	
}

	
}
