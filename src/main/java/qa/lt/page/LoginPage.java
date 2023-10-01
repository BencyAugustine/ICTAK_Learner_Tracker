package qa.lt.page;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.lt.base.BaseClass;
import qa.lt.constants.Auto_constants;

public class LoginPage extends BaseClass{
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public static Properties properties;
	@FindBy(xpath = "//p[contains(text(),'ICTAK - Learner Tracker')]")
	WebElement url;
	
	@FindBy(xpath = "//input[@id='username']")
	WebElement user;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement pwd;
	
	@FindBy(xpath = "//button[contains(text(),'Login')]")
	WebElement Login_button;
	
	//admin Dashboard
	@FindBy(xpath = "//a[contains(text(),'LearnerTracker')]")
	WebElement admin_dash;
	
	//login wrong pwd message
	@FindBy(xpath = "//div[contains(text(),'Login Failed!!')]")
	WebElement err_msg;
	
	//login wrong username message
	@FindBy(xpath = "//div[contains(text(),'User not found !!')]")
	WebElement err_msg2;
	
	//Blank field msg
	@FindBy(xpath = "//small[contains(text(),'Please fill in all fields.')]")
	WebElement err_msg3;
	
	//Blank password field msg
	@FindBy(xpath = "//small[contains(text(),'Password is required.')]")
	WebElement err_msg4;
	
	//Blank username field msg
	@FindBy(xpath = "//small[contains(text(),'Username is required.')]")
	WebElement err_msg5;
	
	public String check_url()
	{
		String txt=url.getText();
		return txt;
	}
	
	public void check_login(String username,String password)
	{
		user.sendKeys(username);
		pwd.sendKeys(password);
		Login_button.click();
		
	}
	
	public String valid()
	{
		String txt=admin_dash.getText();
		return txt;	
	}
	
	public String  wrong_pwd()
	{
		String txt=err_msg.getText();
		return txt;
	}
	
	public String  wrong_username()
	{
		String txt=err_msg2.getText();
		return txt;
	}
	
	public String blank()
	{
		String txt=err_msg3.getText();
		return txt;		
	}
	
	public String blank_pwd()
	{
		String txt=err_msg4.getText();
		return txt;	
	}
	
	public String blank_user()
	{
		String txt=err_msg5.getText();
		return txt;
	}
	
	public boolean pwd_mask()
	{
		boolean status=false;
		String pwdvalue=pwd.getAttribute("type");
		//System.out.println("attribute value is"+pwdvalue);
		
		if(pwdvalue.equals(Auto_constants.passvalue))
		{
			 status=true;
			 return status;
		}
		else
		{
			status=false;
			 return status;
		}
	}
	
	
}
