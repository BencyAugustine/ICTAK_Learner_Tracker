package qa.lt.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	public WebDriver driver;
	public static Properties properties;
	
	@BeforeMethod
	public void init()
	{
		/*String browser=properties.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		if(browser.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		if(browser.equalsIgnoreCase("fox"))
		{
			driver=new FirefoxDriver();
		}*/
		driver=new ChromeDriver();
		driver.get(properties.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	public BaseClass()
	{
		properties=new Properties();
		File file=new File(System.getProperty("user.dir")+"/src/main/java/qa/lt/config/config.properties");
		try {
			FileInputStream  inputStream=new FileInputStream(file);
			properties.load(new InputStreamReader(inputStream,Charset.forName("UTF-8")));
		} catch (FileNotFoundException fie) {
			fie.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
