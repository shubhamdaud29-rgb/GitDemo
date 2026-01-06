package SeleniumFramwork;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import ReusableCode.ParentClassCode;

public class productCatolog extends ParentClassCode {

	WebDriver driver;
	
	public productCatolog(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void selectProdu(String produ) throws InterruptedException
	{
		Thread.sleep(3000);
		waitForEleVisubleAll(By.xpath("//*[@id=\'products\']/div[1]/div[2]/div"));
		List<WebElement> listProd = driver.findElements(By.xpath("//*[@id=\"products\"]/div[1]/div[2]/div"));
		listProd.stream().filter(prod->prod.findElement(By.tagName("b")).getText().contains(produ)).forEach(prod->prod.findElement(By.cssSelector("Button.w-10")).click());	
	}
	
	public void addProduct()
	{
		waitForEleVisubleAll(By.cssSelector("#toast-container"));
		waitinvisibilityOf(By.cssSelector(".ng-animating"));
		driver.findElement(By.xpath("/html/body/app-root/app-dashboard/app-sidebar/nav/ul/li[4]/button")).click();
	}
	public boolean productCartCheck(String produ)
	{
		List<WebElement> shoppedProds = driver.findElements(By.xpath("/html/body/app-root/app-profile/div/div[2]/ul/li/div/div[1]/h3"));
		boolean prodCheck = shoppedProds.stream().anyMatch(shoppedProd -> shoppedProd.getText().equalsIgnoreCase(produ)); 
		return prodCheck;
	}
	
	public void checkOutProduct()
	{
		windowscroll();
		WebElement button = elementToBeClickable(By.xpath("/html/body/app-root/app-profile/div/div[3]/ul/li[3]/button"));
		button.click();
	}
	
	public void addressSelect()
	{
		driver.findElement(By.xpath("/html/body/app-root/app-order/section/div/div/div[2]/div/div/div[3]/div[2]/div[2]/div/div[1]/div/input")).sendKeys("Ind");
		waitVisiblityOf(By.xpath("/html/body/app-root/app-order/section/div/div/div[2]/div/div/div[3]/div[2]/div[2]/div/div[1]/div/section/button/span"));
		List<WebElement> countrySearch = driver.findElements(By.xpath("/html/body/app-root/app-order/section/div/div/div[2]/div/div/div[3]/div[2]/div[2]/div/div[1]/div/section/button/span"));
		countrySearch.stream().filter(ctrySrc ->ctrySrc.getText().equalsIgnoreCase("India")).findFirst().ifPresent(ctrySrc->ctrySrc.click());
	}
	
	public String orderConfirmation()
	{
		driver.findElement(By.xpath("/html/body/app-root/app-order/section/div/div/div[2]/div/div/div[3]/div[2]/div[2]/div/div[2]/a")).click();
		waitVisiblityOf(By.xpath("//*[@id=\"htmlData\"]/tbody/tr[4]/td"));
		return driver.findElement(By.xpath("//*[@id=\"htmlData\"]/tbody/tr[4]/td/table/tbody/tr/td/table/tbody/tr[1]/td/h1")).getText();
	}
	public boolean goToOrdrePage(String orderProductName)
	{
		driver.findElement(By.xpath("/html/body/app-root/app-dashboard/app-sidebar/nav/ul/li[3]/button")).click();
		waitVisiblityOf(By.xpath("/html/body/app-root/app-myorders/div[1]/table/tbody/tr/td[2]"));
		List<WebElement> orderProduct = driver.findElements(By.xpath("/html/body/app-root/app-myorders/div[1]/table/tbody/tr/td[2]"));
		boolean flag = orderProduct.stream().anyMatch(ordProd->ordProd.getText().equalsIgnoreCase(orderProductName));
		return flag;
		
	}
	
}
