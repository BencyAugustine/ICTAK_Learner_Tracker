package qa.lt.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.lt.Utility.ExcelUtility;
import qa.lt.base.BaseClass;
import qa.lt.constants.Auto_constants;
import qa.lt.page.AdminPage;
import qa.lt.page.LoginPage;
import qa.lt.page.Logout;

public class Logout_TC extends BaseClass{
	  LoginPage loginpage;
	  AdminPage adminpage;
	  Logout logout;
	  @BeforeMethod
	  public void tearup()
	  {
		  loginpage=new LoginPage(driver);
		  adminpage=new AdminPage(driver); 
		  logout=new Logout(driver);
	  }
  @Test(priority=1)
  public void admin_logout() throws IOException
  {
	  String User=ExcelUtility.getData(0,0);
	  String Pwd=ExcelUtility.getData(0,1);
	  loginpage.check_login(User,Pwd);
	  String msg=logout.user_signout();
	  Assert.assertEquals(msg,Auto_constants.user_logout);
  }
  @Test(priority=2)
  public void trainer_logout() throws IOException
  {
	  String User=ExcelUtility.getData(7,0);
	  String Pwd=ExcelUtility.getData(7,1);
	  loginpage.check_login(User,Pwd);
	  String msg=logout.user_signout();
	  Assert.assertEquals(msg,Auto_constants.user_logout);
  }
  @Test(priority=3)
  public void pofficer_logout() throws IOException
  {
	  String User=ExcelUtility.getData(8,0);
	  String Pwd=ExcelUtility.getData(8,1);
	  loginpage.check_login(User,Pwd);
	  String msg=logout.user_signout();
	  Assert.assertEquals(msg,Auto_constants.user_logout);
  }
  @AfterMethod
 	public void clearMethod()
 	{
 		driver.close();
 	}
}
