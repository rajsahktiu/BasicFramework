package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	/*WebElement email = driver.findElement(By.id("usernameInput-input"));
	WebElement password = driver.findElement(By.name("password"));
	WebElement signInButton = driver.findElement(By.id("signIn"));
	WebElement emailError = driver.findElement(By.id("UsernameTextField__errors-usernameInput"));
	WebElement passwordError = driver.findElement(By.id("PasswordTextField__errors-password"));
	WebElement globalError = driver.findElement(By.id("globalError")); */
	
	@FindBy(id = "usernameInput-input")
	public WebElement email;
	
	@FindBy(name = "password")
	public WebElement password;
	
	@FindBy(id = "signIn")
	public WebElement signInButton;
	
	@FindBy(id = "globalError")
	public WebElement globalError;
	
	@FindBy(id = "UsernameTextField__errors-usernameInput")
	public WebElement emailError;
	
	@FindBy(id = "PasswordTextField__errors-password")
	public WebElement passwordError;
	
	public void openBrowser() throws IOException {
		
		FileInputStream B = new FileInputStream("C:\\testing\\browser.properties");
		Properties browser = new Properties();
		browser.load(B);
		
		String P = browser.getProperty("browser");
	
		if(P.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");
			driver = new FirefoxDriver(); 
		} else if (P.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\SeleniumJars\\chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			System.setProperty("webdriver.safari.driver", "C:\\SeleniumJars\\safaridriver.exe");
			driver = new SafariDriver();
		}
		
		PageFactory.initElements(driver, this);
		
	}
	
	public void openLoginPage() {
		driver.get("https://auth.scotiaonline.scotiabank.com/online?oauth_key=k3f_LQqV5Mk&oauth_key_signature=eyJraWQiOiJrUFVqdlNhT25GWUVDakpjMmV1MXJvNGxnb2VFeXJJb2tCbU1oX3BiZXNVIiwidHlwIjoiSldUIiwiYWxnIjoiUlMyNTYifQ.eyJyZWZlcmVyIjoiaHR0cHM6XC9cL3d3dy5zY290aWFiYW5rLmNvbVwvIiwib2F1dGhfa2V5IjoiazNmX0xRcVY1TWsiLCJjb25zZW50X3JlcXVpcmVkIjpmYWxzZSwicmVkaXJlY3RfdXJpIjoiaHR0cHM6XC9cL3d3dy5zY290aWFvbmxpbmUuc2NvdGlhYmFuay5jb21cL29ubGluZVwvbGFuZGluZ1wvb2F1dGhsYW5kaW5nLmJucyIsImV4cCI6MTY2MTcxNzM3NCwiaWF0IjoxNjYxNzE2MTc0LCJqdGkiOiJjYjMxMTY1MC04ZDFiLTQ1ZDEtYmY5OC1hMzU0ZWJmYTI4MTYiLCJjbGllbnRfaWQiOiI4ZWU5MGMzOS0xYzUyLTRmZjQtOGFlNi1hN2I1NGM1Mzk5MzMiLCJjbGllbnRfbWV0YWRhdGEiOnsiQ2hhbm5lbElEIjoiU09MIiwiQXBwbGljYXRpb25Db2RlIjoiSDcifSwiaXNzdWVyIjoiaHR0cHM6XC9cL3Bhc3Nwb3J0LnNjb3RpYWJhbmsuY29tIn0.xMUNewhLdyvSzG69TsIVsrnoj6xneSXrXHOASqTazLPfYzrV0CXJYWxQ-PSs08QWvhqI5-TJw8829IRdcY0zwFNNFWlvU8MocfNyJs0JleGzANNA1V2OmEv2rEKjALM6uUFOa181_ZWAMeoMkgjtJowUVKU90Xz3W0_XCKzpJ3CQDc4EZZrLc7QoIaWQc9dV4L44RuszYPvjZab1OrdqCzn7VHYmhsA7LLQzxrMcMbciWibP3_4j4VJ1NA_eUQmbqAcrLy4J1UAdRltkG3Nd5AJ1YbfB8McZzrtjwqdBjsUbAYRnNUHqcDHhohdA8VHyRiVOKkT63amg0w5h6Bzzgw&preferred_environment=");
			
	}
	
	public void closeBrowser() {
		driver.quit();
	}
	
	public void login(String a, String b) throws InterruptedException {
		email.sendKeys(a);
		password.sendKeys(b);
		signInButton.click();

		Thread.sleep(2000);
	}
	
	public String readEmailError() {
		String actualError = emailError.getText();
		System.out.println(actualError);
		return actualError;
	}
	
	public String readPasswordError() {
		String actualError = passwordError.getText();
		System.out.println(actualError);
		return actualError;
	}
	
	public String readGlobalError() {
		String actualError = globalError.getText();
		System.out.println(actualError);
		return actualError;

	}
}
