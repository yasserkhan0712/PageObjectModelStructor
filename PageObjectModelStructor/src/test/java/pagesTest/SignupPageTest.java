package pagesTest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import listeners.ExtentReportListener;

@Listeners({ExtentReportListener.class})
public class SignupPageTest extends BaseTest{

	@Test (priority = 0, description = "Verify the Sign up Page" )
	public void signupPage() {
		signup.setSignupTab();
				
	}
	
	
}
