package qa.lt.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;

import qa.lt.base.BaseClass;

public class Logout extends BaseClass{
	public  Logout(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//a[@id='basic-nav-dropdown']")
	WebElement admin;

	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	WebElement signout;
	
	@FindBy(xpath = "//label[contains(text(),'Username')]")
	WebElement signIn_page;
		
	public String user_signout()
	{
		admin.click();
		signout.click();
		String txt=signIn_page.getText();
		return txt;
		
	}
	@AfterMethod
	public void clearMethod()
	{
		driver.close();
	}

}
