package SeleniumFramwork.Basetest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basetest {

	public WebDriver driver;
	public WebDriver intilizeDriver() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\SeleniumFramwork\\resources\\GlobalData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		if (browserName.equals("edge"))
		{
			//WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
		}
		if (browserName.equals("chrome"))
		{
			//Chrome Code
		}
		if (browserName.equals("firefox"))
		{
			//firefox Code
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
		}
	
	public List<HashMap<String, String>> getJsonContent(String jsonFilePath) throws IOException
	{
		//read json file to string 
		String jsonConnect = FileUtils.readFileToString(new File(jsonFilePath),StandardCharsets.UTF_8);
		
		//String to HashMap-Jackson datbind
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonConnect, new TypeReference<List<HashMap<String, String>>>(){
		});
		return data;
	}
	
	public String getScreenShot(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file =	new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
		
	}
	
	@AfterMethod
	public void clsoeDriver()
	{
		driver.close();
	}
	
}
