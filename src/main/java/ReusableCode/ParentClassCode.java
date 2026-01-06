package ReusableCode;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ParentClassCode {
	
	 WebDriver driver;
	 WebDriverWait wait;
	
	public ParentClassCode( WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	
	
	public void waitForEleVisubleAll(By path)
	{
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(path));
	}
	public void waitinvisibilityOf(By path)
	{
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(path)));
	}
	public void waitVisiblityOf(By path)
	{
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(path)));
	}
	public WebElement elementToBeClickable(By path)
	{
		return wait.until(ExpectedConditions.elementToBeClickable(path));
	}
	public void windowscroll()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scroll(0,800)");
	}
}
