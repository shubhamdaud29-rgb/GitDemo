package SeleniumFramwork;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
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
import org.testng.annotations.Test;

import ReusableCode.ParentClassCode;
import SeleniumFramwork.Basetest.Basetest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OderConform extends SatandAloneTest {


	@Test (dependsOnMethods= {"submitOrder"})
	public void OrderConformation() throws IOException, InterruptedException
	{
		WebDriver driver = intilizeDriver();
		LoginPage lp = new LoginPage(driver);
		lp.loginTo("shiv123@gmail.com","Shiv@123456");
		productCatolog produCat = new productCatolog(driver); 
		boolean flag = produCat.goToOrdrePage(shoppingProduct);
		Assert.assertTrue(flag);
	}
	
	
}

