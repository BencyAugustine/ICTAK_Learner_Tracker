package qa.lt.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.lt.page.AdminPage;
import qa.lt.page.LoginPage;
import qa.lt.Utility.ExcelUtility;
import qa.lt.base.BaseClass;
import qa.lt.constants.Auto_constants;

public class Placement_TC extends BaseClass{
  LoginPage loginpage;
  AdminPage adminpage;
  @BeforeMethod
  public void tearup() throws IOException
  {
	  loginpage=new LoginPage(driver);
	  adminpage=new AdminPage(driver);
	  String User=ExcelUtility.getData(8,0);
	  String Pwd=ExcelUtility.getData(8,1);
	  loginpage.check_login(User,Pwd);
  }
  //update button in placement page is clickable at the point
  @Test(priority=1)
  public void update_click()
  {
	  String msg=adminpage.update_click_check();
	  Assert.assertEquals(msg,Auto_constants.addlearners_link_msg);
	  System.out.println("Update button click navigated to Learners form");
  }
  //Pofficer can update placement status of Learners  
  @Test(priority=2)
  public void update_pstatus() throws InterruptedException
  {
	  boolean status=adminpage.pstatus_change();
	  Assert.assertTrue(status,Auto_constants.update_users_details_msg);
	  System.out.println("placementb status is updated");
  }
  //Pofficer can navigate from update Learners form to DashBoard  
  @Test(priority=3)
  public void Back_updateplacement()
  {
	  String txt=adminpage.back_update_placement();
	  Assert.assertEquals(txt,Auto_constants.placemment_link_msg);
	  System.out.println("BackToDashBoard button navigated to Placement Home page");
  }
  @AfterMethod
	public void clearMethod()
	{
		driver.close();
	}
}
