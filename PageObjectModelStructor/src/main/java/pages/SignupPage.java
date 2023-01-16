package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class SignupPage {

	/* @Author Yasser Arafat
	 * this class is to verify signup page
	 */
	private WebDriver driver;

	//1.OR Object Repository by locator
	private By signupBtn  = By.xpath("//a[normalize-space()='Sign Up']");
	private By firstName = By.xpath("//input[@id='FirstName']");
	private By surname = By.xpath("//input[@id='Surname']");
	private By e_post = By.xpath("//input[@id='E_post']");
	private By cell = By.xpath("//input[@id='Mobile']");
	private By userName = By.xpath("//input[@id='Username']");
	private By pwd = By.xpath("//input[@id='Password']");
	private By confirmPwd = By.xpath("//input[@id='ConfirmPassword']");
	private By submitBtn = By.xpath("//input[@id='submit']");

	//2.Constructor
	public SignupPage (WebDriver driver) {
		this.driver = driver;
	}

	//3. Actions
	public void setSignupTab() {
		Reporter.log("Verify the signup page");
		driver.findElement(signupBtn).click();	
		driver.findElement(firstName).sendKeys("Ali");
		driver.findElement(surname).sendKeys("Khan");
		driver.findElement(e_post).sendKeys("main st");
		driver.findElement(cell).sendKeys("202556666");
		driver.findElement(userName).sendKeys("KhanA");
		driver.findElement(pwd).sendKeys("123");
		driver.findElement(confirmPwd).sendKeys("123");
		driver.findElement(submitBtn).click();

	}
}
