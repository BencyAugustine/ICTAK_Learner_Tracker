package qa.lt.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import org.testng.Assert;

import qa.lt.Utility.ExcelUtility;
import qa.lt.base.BaseClass;
import qa.lt.constants.Auto_constants;
import qa.lt.page.AdminPage;
import qa.lt.page.LoginPage;

public class Admin_TC extends BaseClass{
  LoginPage loginpage;
  AdminPage  adminpage;
 
  @BeforeMethod
  public void tearUp() throws IOException
  {
	  loginpage=new LoginPage(driver);
	  String User=ExcelUtility.getData(0,0);
	  String Pwd=ExcelUtility.getData(0,1);
	  loginpage.check_login(User,Pwd);
	  adminpage=new AdminPage(driver);
  }
  
  @Test(priority=1)
  public void add_link() {
	  String msg =adminpage.addUser_link();
	  Assert.assertEquals(msg,Auto_constants.admin_add_link_msg);
	  System.out.println("Navigated to Add Users page");
  }
  
  @Test(priority=2)
  public void update_link()
  {
	  String msg=adminpage.updateuser_link();
	  Assert.assertEquals(msg,Auto_constants.admin_add_link_msg);
	  System.out.println("Navigated to Update Users page");	  		  
  }
  
  @Test(priority=3)
  public void delete_link()
  {
	  int msg=adminpage.deleteuser_link();
	  Assert.assertEquals(msg, 0);
	  System.out.println("Deleted");	  		  
  }
  
  @Test(priority=4)
  public void add_user()
  {
	  String txt=adminpage.addUser_fun();
	  Assert.assertEquals(txt, Auto_constants.admin_add_user_msg);
	  System.out.println(txt);
  }
  
  @Test(priority=5)
  public void BackTo_UserHome()
  {
	  String msg=adminpage.UserHome();
	  Assert.assertEquals(msg,Auto_constants.backTo_userhome_msg);
	  System.out.println("BackToDashBoard button navigated to users Home page");
  }
  
  @Test(priority=6)
  public void without_fill_adduser()
  {
	  String msg=adminpage.blank_msg();
	  Assert.assertEquals(msg,Auto_constants.without_fill_adduser_msg);
	  System.out.println("Admin cannot register new user without filling required field");
  }
  
  @Test(priority=7)
  public void update_users_details()
  {
	  boolean status=adminpage.update_details();
	  Assert.assertTrue(status,Auto_constants.update_users_details_msg);
	  System.out.println("Updated !");
  }
  
  //Learners link in admin page
  @Test(priority=8)
  public void learners_Home()
  {
	 String msg=adminpage.le_home();
	 Assert.assertEquals(msg,Auto_constants.learners_Home_msg);
	 System.out.println("Navigated to learners home page");
  }
  
  //add learners button click navigated to lerners form
  @Test(priority=9)
  public void addlearners_link()
  {
	  String msg=adminpage.get_lear_title();
	  Assert.assertEquals(msg,Auto_constants.addlearners_link_msg);
	  System.out.println("Navigated to learners form page");
  }
  
  //add new learners to the list
  @Test(priority=10)
  public void add_learners()
  {
	  String msg=adminpage.add_learners_fn();
	  Assert.assertEquals(msg,Auto_constants.add_learners_msg );
	  System.out.println(msg);
  }
  
  // Admin cannot add new Learners without filling required field
  @Test(priority=11)
  public void add_learner_without_fill()
  {
	  String msg=adminpage.without_data_learner();
	  Assert.assertEquals(msg,Auto_constants.add_learner_without_fill_msg);
	  System.out.println("Admin cannot add new Learners without filling required field");
  }
  
  // Admin can navigates to Learners Homepage from add new Learners form
  @Test(priority=12)
  public void BackTo_AddLearners()
  {
	  String msg=adminpage.Learner_Home();
	  Assert.assertEquals(msg,Auto_constants.backto_addlearners_msg);
	  System.out.println("BackToDashBoard button navigated to Learners Home page");
  }
  
  
  //Upload bulk learners button is clickable at the point
  @Test(priority=13)
  public void upload_bulk_user_link()
  {
	  String msg=adminpage.bulk_link();
	  Assert.assertEquals(msg,Auto_constants.upload_bulk_user_link_msg);  
	  System.out.println("Upload bulk learners button is clickable at the point");
  }
  
  //Edit learners link
  @Test(priority=14)
  public void edit_learn_link()
  {
	  String msg=adminpage.edit_link();
	  Assert.assertEquals(msg,Auto_constants.addlearners_link_msg);
	  System.out.println("Edit learners button is clickable at the point");
  }
  
  //Edit learners functionality
  @Test(priority=15)
  public void edit_learners_submit()
  {
	  Boolean status=adminpage.edit_learners_fn();
	  Assert.assertTrue(status,Auto_constants.update_users_details_msg);
	  System.out.println("Updated!");	  
  }
  
  //BackToDashBoard button  in the Edit Learners page is clickable at the point
  @Test(priority=16)
  public void BackTo_EditLearners()
  {
	  String msg=adminpage.back_edit_learners();
	  Assert.assertEquals(msg,Auto_constants.backto_addlearners_msg);
	  System.out.println("BackToDashBoard button navigated to Learners Home page");
  }
  
  //Admin can delete Learners details from the list
  @Test(priority=17)
  public void delete_lerners() throws InterruptedException
  {
	  Boolean status=adminpage.delete_lerner_record();
	  Assert.assertTrue(status,Auto_constants.delete_lerners_msg);
	  System.out.println("Record deleted");
  }
  
  //Placement link in admin page
  @Test(priority=18)
  public void placemment_link()
  {
	  String msg=adminpage.placement_link_check();
	  Assert.assertEquals(msg,Auto_constants.placemment_link_msg);
	  System.out.println("Placement link in admin page navigated to placement home page");
  }
  
  //update button in placement page is clickable at the point
  @Test(priority=19)
  public void update_click()
  {
	  String msg=adminpage.update_click_check();
	  Assert.assertEquals(msg,Auto_constants.addlearners_link_msg);
	  System.out.println("Update button click navigated to Learners form");
  }
  
  //Admin can update placement status of Learners  
  @Test(priority=20)
  public void update_pstatus() throws InterruptedException
  {
	  boolean status=adminpage.pstatus_change();
	  Assert.assertTrue(status,Auto_constants.update_users_details_msg);
	  System.out.println("placement status is updated");
  }
  
  //Admin can navigate from update Learners form to DashBoard  
  @Test(priority=21)
  public void Back_updateplacement()
  {
	  String txt=adminpage.back_update_placement();
	  Assert.assertEquals(txt,Auto_constants.placemment_link_msg);
	  System.out.println("BackToDashBoard button navigated to Placement Home page");
  }
  
   //page navigation on admin_users page
  @Test(priority=22)
  public void admin_user_navigation()
  {
	  boolean status=adminpage.page_navigation();
	  Assert.assertTrue(status,Auto_constants.admin_user_navigation);
	  System.out.println("Table navigation is possible");
  }
  
  @AfterMethod
	public void clearMethod()
	{
		driver.close();
	}
 //upload csv file
  /*@Test(priority=23)
  public void upload_csv() throws InterruptedException
  {
	  String txt=adminpage.upload_csv_file();
  }
  
  
  //created new user can log in
  @Test(priority=23)
  public void new_user_check()
  {
	  adminpage.addUser_fun();
	  
  }*/
}
