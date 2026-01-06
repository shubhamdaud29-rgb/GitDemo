package StepDescriptio;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import SeleniumFramwork.LoginPage;
import SeleniumFramwork.SatandAloneTest;
import SeleniumFramwork.productCatolog;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDiscription extends SatandAloneTest {

	productCatolog produCat;
	WebDriver driver;
	@Given ("I landed on Ecommerce Page")
	public void landed_on_Ecommerce_Page() throws IOException
	{
		driver = intilizeDriver();
	}
	
	@Given ("^Logged in with username (.+) and Password (.+)$")
	public void looged_in_with_username_and_password(String username, String password) throws InterruptedException
	{	
		LoginPage lp = new LoginPage(driver);
		lp.loginTo(username,password);
	}
	@When ("^I add product (.+) to Cart$")
	public void add_product_to_Cart(String productname) throws InterruptedException
	{
		produCat = new productCatolog(driver); 
		produCat.selectProdu(productname);
		produCat.addProduct();
	}
	@And ("^Checkout (.+) and submit the order$")
	public void checkout_and_submit_the_order(String productname)
	{
		Boolean flag = produCat.productCartCheck(productname);
		Assert.assertTrue(flag);
		produCat.checkOutProduct();
		produCat.addressSelect();
	}
	@Then ("{string} message is dispplayed on ConfirmationPage")
	public void message_is_displayed_on_ConfirmationPage(String thnxMsg)
	{
		Assert.assertEquals(produCat.orderConfirmation(), thnxMsg);
	}
	
}
