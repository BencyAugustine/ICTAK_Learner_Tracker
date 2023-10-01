package qa.lt.page;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.lt.base.BaseClass;
import qa.lt.constants.Auto_constants;

public class AdminPage extends BaseClass{
	public  AdminPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public String uname;
	public String pass;
	
	@FindBy(xpath = "//ion-icon[@name=\"person-add-outline\"]")
	WebElement add;
	
	@FindBy(xpath ="//h3[contains(text(),'Add Users')]" )
	WebElement page_check;
	
	@FindBy(xpath = "//tbody/tr[1]/td[6]/button[1]/ion-icon[1]")
	WebElement update;
	
	@FindBy(xpath = "//tbody/tr[1]/td[7]/button[1]")
	WebElement delete_user;
	
	@FindBy(xpath = "//tbody/tr[1]")
	WebElement record;
	
	@FindBy(xpath="//input[@id='name']")
	WebElement name;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement email;
	
	@FindBy(xpath = "//input[@id='username']")
	WebElement username;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath = "//select[@name=\"roleInputs\"]")
	WebElement role;
	
	@FindBy(xpath = "//option[contains(text(),'Admin')]")
	WebElement role_select;
	
	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	WebElement submit_user;

	//add user message
	@FindBy(xpath = "//div[@id='swal2-html-container']")
	WebElement msg1;
	
	//back to dashBoard
	@FindBy(xpath="//button[contains(text(),'Back to Dashboard')]")
	WebElement back;
	
	//Name field
	@FindBy(xpath = "//th[contains(text(),'Name')]")
	WebElement name_obj;
	
	//blank name field
	@FindBy(xpath = "//p[contains(text(),'Must contain letters only')]")
	WebElement blank_name;
	
	//table web element
	@FindBy(xpath = "//table")
	WebElement table;
	
	//learners home page link
	@FindBy(xpath = "//span[contains(text(),'Learners')]")
	WebElement learners;
	
	//edit table title
	@FindBy(xpath = "//th[contains(text(),'Edit')]")
	WebElement edit_title;
	
	//Learners form title
	@FindBy(xpath = "//h3[contains(text(),\"Learner's form\")]")
	WebElement learner_form;
	
	//Learners form fieldssss....
	@FindBy(xpath = "//input[@id='learnerid']")
	WebElement learnerid;
	
	@FindBy(xpath="//input[@id='name']")
	WebElement learner_name;
	
	@FindBy(xpath = "//select[@name=\"course\"]")
	WebElement course;
	
	@FindBy(xpath = "//option[contains(text(),'ST')]")
	WebElement course_select;
	
	@FindBy(xpath = "//select[@name=\"project\"]")
	WebElement project;
	
	@FindBy(xpath = "//option[@value=\"KKEM\"]")
	WebElement project_select;
	
	@FindBy(xpath = "//select[@name=\"batch\"]")
	WebElement batch;
	
	@FindBy(xpath = "//option[@value=\"Jul_22\"]")
	WebElement batch_select;
	
	@FindBy(xpath = "//select[@name=\"cstatus\"]")
	WebElement course_status;
	
	@FindBy(xpath = "//option[@value=\"Qualified\"]")
	WebElement select_course_status;
	
	//blank field submission for learners form
	@FindBy(xpath = "//p[contains(text(),'Must contain letters,numbers and - only')]")
	WebElement blank_learners_msg;
	
	//back to learners home page
	@FindBy(xpath="//th[contains(text(),'Learner Id')]")
	WebElement page_check2;
	
	//bulk link verification 
	@FindBy(xpath = "//label[contains(text(),'Upload a CSV File :')]")
	WebElement upload_link;
	
	//add bulk_learners button 
	@FindBy(xpath = "//ion-icon[@name=\"cloud-upload\"]")
	WebElement bulk_link;
	
	//Edit learners link
	@FindBy(xpath = "//tbody/tr[2]/td[8]/button[1]")
	WebElement edit_lear_link;
	
	//update learners record
	@FindBy(xpath = "//tbody/tr[2]")
	WebElement update_record;
	
	//update learners project selection
	@FindBy(xpath = "//option[@value=\"KKEM\"]")
	WebElement update_project_select;
		
	//delete learners record
	@FindBy(xpath = "//tbody/tr[3]")
	WebElement delete_learner;
	
	//delete learners button
	@FindBy(xpath = "//tbody/tr[3]/td[9]")
	WebElement delete_learner_button;
	
	//Placement link check
	@FindBy(xpath = "//span[contains(text(),'Placement')]")
	WebElement placement_link;
	
	//placement link txt check
	@FindBy(xpath = "//th[contains(text(),'Update')]")
	WebElement placement_link_object;
	
	//update placement page button
	@FindBy(xpath = "//tbody/tr[4]/td[8]/button[1]")
	WebElement update_placement_button;
	
	//placement record
	@FindBy(xpath="//tbody/tr[4]")
	WebElement placement_record;
	
	//placement status
	@FindBy(xpath = "//select[@name=\"pstatus\"]")
	WebElement placement_status;
	
	//change placement status
	@FindBy(xpath = "//option[contains(text(),'Not Interested')]")
	WebElement change_placement_status;
	
	//Navigation 
	@FindBy(xpath = "//span[contains(text(),'›')]")
	WebElement next;
	
	//Next button navigation
	@FindBy(xpath="//span[contains(text(),'›')]")
	WebElement next_navig;
	
	//page count
	@FindBy(xpath = "//a[contains(text(),'10')]")
	WebElement page_count;
	
	//Choose file button
	@FindBy(xpath = "//input[@name=\"file\"]")
	WebElement choose_file;
	
	//file upload submit button
	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	WebElement file_upload_submit;
	
	//return to dashboard button
	@FindBy(xpath = "//button[contains(text(),'Return to Dashboard')]")
	WebElement return_to_dashboard_button;
	
	//save ok button
	@FindBy(xpath = "//button[contains(text(),'OK')]")
	WebElement save_update_ok;
	
	public String addUser_link()
	{
		add.click();
		String txt=page_check.getText();
		return txt;	
	}
	public String updateuser_link()
	{
		update.click();
		String txt=page_check.getText();
		return txt;
	}
	public int deleteuser_link()
	{
		String txt1=record.getText();
		delete_user.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String txt2=record.getText();
		if (txt1==txt2)
		return 1;
		else
		return 0;	        		
	}
	public String addUser_fun()
	{
		add.click();
		name.sendKeys(Auto_constants.user_name);
		email.sendKeys(Auto_constants.user_email);
		username.sendKeys(Auto_constants.login_user_name);		
		password.sendKeys(Auto_constants.login_pwd);
		role.click();
		role_select.click();
		submit_user.click();
		String txt=msg1.getText();
		return txt;
	}
	public String UserHome()
	{
		add.click();
		back.click();
		String txt=name_obj.getText();
		return txt;
		
	}
	public String blank_msg()
	{
		add.click();
		submit_user.click();
		String txt=blank_name.getText();
		return txt;
	}
	public boolean update_details()
	{
		boolean status=false;
		String txt1=record.getText();
		update.click();
		email.clear();
		email.sendKeys(Auto_constants.user_email);
		submit_user.click();
		String txt2=record.getText();
		if (txt1.equals(txt2))
		{
			status=false;
			return status;
		}
		else
		{
			status=true;
			return status;
		}	
	}
	public String le_home()
	{
		learners.click();
		String txt=edit_title.getText();
		return txt;
	}
	public String get_lear_title()
	{
		learners.click();
		add.click();
		String txt=learner_form.getText();
		return txt;
	}
	public String add_learners_fn()
	{
		learners.click();
		add.click();
		learnerid.sendKeys(Auto_constants.learner_id);
		learner_name.sendKeys(Auto_constants.lear_name);
		course.click();
		course_select.click();
		project.click();
		project_select.click();
		batch.click();
		batch_select.click();
		course_status.click();
		select_course_status.click();;
		submit_user.click();
		String txt=msg1.getText();
		return txt;
		
	}
	public String without_data_learner()
	{
		learners.click();
		add.click();
		submit_user.click();
		String txt=blank_learners_msg.getText();
		return txt;
		
	}
	public String Learner_Home()
	{
		learners.click();
		add.click();
		back.click();
		String txt=page_check2.getText();
		return txt;
	}
	public String bulk_link()
	{
		learners.click();
		bulk_link.click();
		String txt=upload_link.getText();
		return txt;
	}
	public String edit_link()
	{
		learners.click();
		edit_lear_link.click();
		String msg=learner_form.getText();
		return msg;	
	}
	public boolean edit_learners_fn()
	{
		boolean status= true;
		learners.click();
		String txt1=update_record.getText();
		System.out.println(txt1);
		edit_lear_link.click();
		project.click();
		update_project_select.click();
		submit_user.click();
		String txt2=update_record.getText();
		System.out.println(txt2);
		if(txt1==txt2)
			status=false;
		else
			status=true;
		return status;		
	}
	public String back_edit_learners()
	{
		learners.click();
		edit_lear_link.click();
		back.click();
		String txt=page_check2.getText();
		return txt;
		
	}
	public boolean delete_lerner_record() throws InterruptedException
	{
		boolean status=true;
		learners.click();
		String txt1=delete_learner.getText();
		delete_learner_button.click();
		Thread.sleep(2000);
		String txt2=delete_learner.getText();
		if (txt1==txt2)
		{
			status=false;
			return status;
		}
		else
		{
			status=true;
			return status;
		}	
	}
	public String placement_link_check()
	{
		placement_link.click();
		String txt=placement_link_object.getText();
		return txt;
	}
	public String update_click_check()
	{
		placement_link.click();
		update_placement_button.click();
		String txt=learner_form.getText();
		return txt;
	}
	public boolean pstatus_change() throws InterruptedException
	{
		boolean status=true;
		placement_link.click();
		String txt1=placement_record.getText();
		update_placement_button.click();
		placement_status.click();
		change_placement_status.click();
		submit_user.click();
		String txt2=placement_record.getText();
		if (txt1==txt2)
		{
			status=false;
			return status;
		}
		else
		{
			status=true;
			return status;		
		}	
	}
	public String back_update_placement()
	{
		placement_link.click();
		update_placement_button.click();
		back.click();
		String txt=placement_link_object.getText();
		return txt;
	}
	public boolean page_navigation()
	{
		int i=0;
		boolean status=false;
		//String count=next.getText();
		String count_page=page_count.getText();
		int number = Integer.parseInt(count_page);
		for(number=0;number<=10;number++)
		{
			List<WebElement>user_record=driver.findElements(By.xpath("//tbody"));
			for(WebElement ele :user_record)
			{
				next.click();
				i++;
			}
		}
		if(i==number)
		status=true;
		else
		status=false;
		return status;	
	}
	public String upload_csv_file() throws InterruptedException
	{
		learners.click();
		bulk_link.click();
	    choose_file.sendKeys("C:\\Users\\bency\\OneDrive\\Desktop\\ST_main_project\\internship\\learners_csv.csv");
	    file_upload_submit.click();
	    return_to_dashboard_button.click();
	    save_update_ok.click();
		return null;
		
	}
}
