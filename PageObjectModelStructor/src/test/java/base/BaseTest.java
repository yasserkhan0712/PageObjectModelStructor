package base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import browserFactory.DriverFactory;
import listeners.ExtentReportListener;
import pages.SignupPage;

public class BaseTest {

	WebDriver driver;
	DriverFactory df;
	protected Properties prop;
	protected SignupPage signup;
	protected ExtentReportListener reports;
	
	public String getScreenshot(String methodName) {
		Calendar cal = Calendar.getInstance();
		java.util.Date time = cal.getTime();
		String timeStamp = time.toString().replace(":", "").replace(" ", ".");
		
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis()+".png";
		String path = System.getProperty("user.dir") + "/screenshots/"+methodName+timeStamp + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(srcFile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
	
	
@BeforeTest
public void setupEnviornment() throws FileNotFoundException {
	df = new DriverFactory();
	prop = df.init_prop();
	driver = df.init_driver(prop);
	signup = new SignupPage(driver);
	reports = new ExtentReportListener();
	

}
@AfterTest
public void teardown() {
	
	
	
}


}

