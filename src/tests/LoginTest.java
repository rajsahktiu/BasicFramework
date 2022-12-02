package tests;

import org.testng.annotations.Test;

import data.DataFiles;
import pages.LoginPage;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest {

	LoginPage lp = new LoginPage();
	DataFiles df = new DataFiles();
	
	@BeforeMethod
	public void beforeMethod() throws IOException {
		
		lp.openBrowser();
		lp.openLoginPage();

		// open browser
		// open scotiaBank Login Page
	}

	@AfterMethod
	public void afterMethod() {

		lp.closeBrowser();// close browser
	}

	@Test(priority = 1)
	public void loginWithSpecialXharEmailTest() throws InterruptedException {

		lp.login(df.emailWithSpecialChar, df.wrongPassword);

		String expectedError = df.specialCharEmailError;
		String actualError = lp.readEmailError();

		Assert.assertEquals(actualError, expectedError);

		// enter email with special char
		// wrong password
		// verify Error message
	}

	@Test(priority = 2)
	public void loginWithEmptyEmailTest() throws InterruptedException {

		lp.login("", df.wrongPassword);

		String expectedError = df.emptyEmailError;
		String actualError = lp.readEmailError();

		Assert.assertEquals(actualError, expectedError);

		// enter empty email
		// wrong password
		// verify Error message
	}

	@Test(priority = 3)
	public void loginWithEmptyPasswordTest() throws InterruptedException {

		lp.login(df.wrongEmail, "");

		String expectedError = df.emptyPasswordError;
		String actualError = lp.readPasswordError();

		Assert.assertEquals(actualError, expectedError);

		// enter wrong email
		// empty password
		// verfify Error message

	}

	@Test(priority = 4)
	public void loginWithWrongEmailPasswordTest() throws InterruptedException {

		lp.login(df.wrongEmail, df.wrongPassword);

		String expectedError = df.globalError;
		String actualError = lp.readGlobalError();

		Assert.assertEquals(actualError, expectedError);

		// enter email with special char
		// wrong password
		// verify Error message
	}

}
