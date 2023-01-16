package browserFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	/*
	 * @Author Yasser Arafat
	 * this class initiate webdriver and config file
	 * @return this method will return webdriver
	 * */
	 
	WebDriver driver;
	public Properties prop;
	public String configPath = "./src/main/resources/configuration/config.properties";
	
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();
	
	public WebDriver init_driver(Properties prop) {
		
		String browserName = prop.getProperty("browser").trim();
		
		if (browserName.equalsIgnoreCase("chrome")) {
			//WebDriverManager.chromedriver().setup();
			tldriver.set(new ChromeDriver());			
		} else if (browserName.equalsIgnoreCase("firefox")) {
			tldriver.set(new FirefoxDriver());	
		} else {
			System.out.println("browser name is missing");
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url").trim());
		System.out.println("The browser name is > " + browserName);
		System.out.println("The webpage is > " + prop.getProperty("url"));
		return getDriver();
	}
	
	public static synchronized WebDriver getDriver() {
		return tldriver.get();
	}
	
public Properties init_prop() throws FileNotFoundException {
	
	FileInputStream ip = null;
	ip = new FileInputStream(configPath);
	 prop = new Properties();
	try {
		prop.load(ip);
	} catch (IOException e) {
		e.printStackTrace();
	}
	return prop;
}
// this method capture screenshots


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
	
}




