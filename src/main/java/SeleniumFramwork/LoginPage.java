package SeleniumFramwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ReusableCode.ParentClassCode;

public class LoginPage extends ParentClassCode {
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public void loginTo(String mailid,String passwrd) throws InterruptedException
	{
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys(mailid);
		driver.findElement(By.id("userPassword")).sendKeys(passwrd);
		driver.findElement(By.id("login")).click();
		//Thread.sleep(3000);
	}
	
	public String errorMessage()
	{
		waitVisiblityOf(By.cssSelector("[class*='flyInOut']"));
		return  driver.findElement(By.cssSelector("[class*='flyInOut']")).getText();
	}

}
