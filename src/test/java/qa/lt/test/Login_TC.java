package qa.lt.test;

import static org.junit.Assert.assertArrayEquals;

import java.io.IOException;
import java.io.ObjectInputFilter.Config;
import java.time.Duration;
import java.util.Properties;
import qa.lt.constants.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import qa.lt.Utility.ExcelUtility;
import qa.lt.base.BaseClass;
import qa.lt.page.LoginPage;

public class Login_TC extends BaseClass{
	    LoginPage loginpage;
	    public static Properties properties;
		
	    @BeforeMethod
		public void tearUp()
		{
			loginpage=new LoginPage(driver);
		}
		
	    @Test(priority=1)
		public void verify_url() throws IOException
		{
			String msg=loginpage.check_url();
			Assert.assertEquals(msg,Auto_constants.url_msg);
			System.out.println("User accessed the URL");
		}
		
	    @Test(priority=2)
		public void valid_admin() throws IOException
		{
			String User=ExcelUtility.getData(0,0);
			String Pwd=ExcelUtility.getData(0,1);
			
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			loginpage.check_login(User,Pwd);
			String msg=loginpage.valid();
			Assert.assertEquals(msg,Auto_constants.valid_user_msg);
			System.out.println("Admin can logged in");
		}
		
	    @Test(priority=3)
		public void valid_trainer() throws IOException
		{
			String User=ExcelUtility.getData(7,0);
			String Pwd=ExcelUtility.getData(7,1);
			
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			loginpage.check_login(User,Pwd);
			String msg=loginpage.valid();
			Assert.assertEquals(msg,Auto_constants.valid_user_msg);
			System.out.println("Trainer can logged in");
		}
		
	    @Test(priority=4)
		public void valid_pfficer() throws IOException
		{
			String User=ExcelUtility.getData(8,0);
			String Pwd=ExcelUtility.getData(8,1);
			
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			loginpage.check_login(User,Pwd);
			String msg=loginpage.valid();
			Assert.assertEquals(msg,Auto_constants.valid_user_msg);
			System.out.println("Placement officer can logged in");
		}
		
	    @Test(priority=5)
		public void invalid_pwd() throws IOException
		{
			String User=ExcelUtility.getData(1,0);
			String Pwd=ExcelUtility.getData(1,1);
			loginpage.check_login(User,Pwd);
			
			String txt=loginpage.wrong_pwd();
			Assert.assertEquals(txt,Auto_constants.invalid_pwd_msg);
			System.out.println(txt);
			
		}
		
	    @Test(priority=6)
		public void invalid_username() throws IOException
		{
			String User=ExcelUtility.getData(2,0);
			String Pwd=ExcelUtility.getData(2,1);
			loginpage.check_login(User,Pwd);
			
			String txt=loginpage.wrong_username();
			Assert.assertEquals(txt,Auto_constants.invalid_username_msg);
			System.out.println(txt);
		}
		
	    @Test(priority=7)
		public void blank_fields() throws IOException
		{
			String User=ExcelUtility.getData(4,0);
			String Pwd=ExcelUtility.getData(4,1);
			loginpage.check_login(User,Pwd);
			String txt=loginpage.blank();
			Assert.assertEquals(txt,Auto_constants.blank_fields_msg);
			System.out.println(txt);
		}
		
	    @Test(priority=8)
		public void blank_password() throws IOException
		{
			String User=ExcelUtility.getData(5,0);
			String Pwd=ExcelUtility.getData(5,1);
			loginpage.check_login(User,Pwd);
			String txt=loginpage.blank_pwd();
			Assert.assertEquals(txt,Auto_constants.blank_password_msg);
			System.out.println(txt);
		}
		
	    @Test(priority=9)
		public void blank_username() throws IOException
		{
			String User=ExcelUtility.getData(6,0);
			String Pwd=ExcelUtility.getData(6,1);
			loginpage.check_login(User,Pwd);
			String txt=loginpage.blank_user();
			Assert.assertEquals(txt,Auto_constants.blank_username_msg );
			System.out.println(txt);
		}
	    
		@Test(priority=10)
		public void astrik_check() throws IOException
		{
			boolean status=loginpage.pwd_mask();
			Assert.assertTrue(status,Auto_constants.astrik_check_msg );
			System.out.println("Password field is masked");
		}
		
		@AfterMethod
		public void clearMethod()
		{
			driver.close();
		}
}
