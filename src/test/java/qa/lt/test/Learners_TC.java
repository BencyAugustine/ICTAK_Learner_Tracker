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

public class Learners_TC extends BaseClass{
	LoginPage loginpage;
	AdminPage adminpage;
	
	@BeforeMethod
	public void tearup() throws IOException
	{
		loginpage=new LoginPage(driver);
		adminpage=new AdminPage(driver);
		String User=ExcelUtility.getData(7,0);
		String Pwd=ExcelUtility.getData(7,1);
		loginpage.check_login(User,Pwd);
	}
	
	//add learners button click navigated to lerners form
	@Test(priority=1)
	public void addlearners_link()
	{
		 String msg=adminpage.get_lear_title();
		 Assert.assertEquals(msg,Auto_constants.addlearners_link_msg);
		 System.out.println("Add learners button click navigated to lerners form");
	}
	//add new learners to the list
    @Test(priority=2)
    public void add_learners()
    {
    	String msg=adminpage.add_learners_fn();
    	Assert.assertEquals(msg,Auto_constants.add_learners_msg);
  	    System.out.println(msg);
    }
    // Trainer cannot add new Learners without filling required field
    @Test(priority=3)
    public void add_learner_without_fill()
    {
  	  String msg=adminpage.without_data_learner();
  	  Assert.assertEquals(msg,Auto_constants.add_learner_without_fill_msg);
  	 System.out.println("Trainer cannot add new Learners without filling required field");
    }
    // Trainer can navigates to Learners Homepage from add new Learners form
	@Test(priority=4)
	public void BackTo_AddLearners()
	{
	  String msg=adminpage.Learner_Home();
	  Assert.assertEquals(msg,Auto_constants.backto_addlearners_msg);
	  System.out.println("BackToDashBoard button navigated to Learners Home page");
	}
	  
	//Upload bulk learners button is clickable at the point
	@Test(priority=5)
	public void upload_bulk_user_link()
	{
	   String msg=adminpage.bulk_link();
	   Assert.assertEquals(msg,Auto_constants.upload_bulk_user_link_msg);  
	   System.out.println("Upload bulk learners button is clickable at the point");
	}
	//Edit learners link
	@Test(priority=6)
    public void edit_learn_link()
    {
	  String msg=adminpage.edit_link();
	  Assert.assertEquals(msg,Auto_constants.addlearners_link_msg);
	  System.out.println("Edit learners button is clickable at the point");
    }
	//Edit learners functionality
	@Test(priority=7)
    public void edit_learners_submit()
    {
	  Boolean status=adminpage.edit_learners_fn();
	  Assert.assertTrue(status,Auto_constants.update_users_details_msg);
	  System.out.println("Updated!");	  
    }
	//BackToDashBoard button  in the Edit Learners page is clickable at the point
	@Test(priority=8)
	public void BackTo_EditLearners()
	{
	  String msg=adminpage.back_edit_learners();
	  Assert.assertEquals(msg,Auto_constants.backto_addlearners_msg);
	  System.out.println("BackToDashBoard button navigated to Learners Home page");
	}
	//Trainer can delete Learners details from the list
	@Test(priority=9)
	public void delete_lerners() throws InterruptedException
	{
	   Boolean status=adminpage.delete_lerner_record();
	   Assert.assertTrue(status,Auto_constants.delete_lerners_msg);
	   System.out.println("Record deleted");
	}
	@AfterMethod
	public void clearMethod()
	{
		driver.close();
	}
	
}
