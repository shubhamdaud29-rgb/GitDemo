package SeleniumFramwork;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.decorators.WebDriverDecorator;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import ReusableCode.ParentClassCode;
import SeleniumFramwork.Basetest.Basetest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SatandAloneTest extends Basetest {

	String shoppingProduct = "IPHONE 13 PRO";
	
	@Test(dataProvider = "getData",retryAnalyzer=RerunTest.class)
	public void submitOrder(HashMap<String, String> input) throws InterruptedException, IOException
	{
		//Declaration 
		//WebDriverManager.edgedriver().setup();
		WebDriver driver = intilizeDriver();
		
		//Login page
		LoginPage lp = new LoginPage(driver);
		lp.loginTo(input.get("email"),input.get("pwd"));
		//select item
		productCatolog produCat = new productCatolog(driver);
		produCat.selectProdu(shoppingProduct);
		
		//Product added
		produCat.addProduct();
		
		//Validate product in cart
		Boolean flag = produCat.productCartCheck(shoppingProduct);
		Assert.assertTrue(flag);
		
		produCat.checkOutProduct();
		//Select country from drop-down
		produCat.addressSelect();
		
		//Place order and validate order success 
		Assert.assertEquals(produCat.orderConfirmation(), "THANKYOU FOR THE ORDER.");
		
	}
	
	@Test
	public void errorValidation() throws IOException, InterruptedException
	{
		WebDriver driver = intilizeDriver();
		LoginPage lp = new LoginPage(driver);
		lp.loginTo("shiv123@gmail.com","Shiv@127856");
		Assert.assertEquals("Incorrect email or password.", lp.errorMessage());
	}

	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String, String>> data = getJsonContent(System.getProperty("user.dir")+"\\src\\test\\java\\TestData\\TestData.json");
		
		System.out.println(data.get(0));
		
		return new Object [][] {{data.get(0)},{data.get(1)}};
	}
	
}
