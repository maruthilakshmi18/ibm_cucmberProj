package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddcustomerPage {

	public WebDriver ldriver;
	
	public AddcustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
	}
	
	//By lnkCustomers_menu=By.xpath("//a[@href='#']//span[contains(text(),'Customers')]");
	//By lnkCustomers_menuitem=By.xpath("//span[@class='menu-item-title'][contains(text(),'Customers')]");
	
	//By lnkCustomers_menu=By.xpath("//a[contains(@href,'List')]//descendant::p[contains(text(),' Customers')]");
	
	@FindBy(xpath="//p[text()[normalize-space()='Customers']]")
	WebElement lnkCustomers_menu;
	
	//By lnkCustomers_menu=By.xpath("//p[text()[normalize-space()='Customers']]");
	
	//By lnkCustomers_menu=By.xpath("//p[text()[normalize-space()='Customers']]");
	@FindBy(xpath="//p[text()=' Customers']")
	WebElement lnkCustomers_menuitem;
	
	//By lnkCustomers_menuitem=By.xpath("//p[text()=' Customers']");
	//By lnkCustomers_menuitem=By.xpath("//span[@class='menu-item-title'][contains(text(),'Customers')]");
	
	@FindBy(xpath="//a[@href='/Admin/Customer/Create']")
	WebElement btnAddnew;
	
	
	//By btnAddnew=By.xpath("//a[@href='/Admin/Customer/Create']"); //Add new
	
	@FindBy(xpath="//input[@id='Email']")
	WebElement txtEmail;
		
//	By txtEmail=By.xpath("//input[@id='Email']");
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement txtPassword;
	
	//By txtPassword=By.xpath("//input[@id='Password']");
	
	
	@FindBy(xpath="(//div[@class='k-multiselect-wrap k-floatwrap'])[2]")
	WebElement txtcustomerRoles;
	
	//By txtcustomerRoles=By.xpath("(//div[@class='k-multiselect-wrap k-floatwrap'])[2]");
	
	@FindBy(xpath="//li[contains(text(),'Administrators')]")
	WebElement lstitemAdministrators;
	
	//By lstitemAdministrators=By.xpath("//li[contains(text(),'Administrators')]");
	
	@FindBy(xpath="//li[contains(text(),'Registered')]")
	WebElement lstitemRegistered;
	
	//By lstitemRegistered=By.xpath("//li[contains(text(),'Registered')]");
	
	@FindBy(xpath="//li[contains(text(),'Guests')]")
	WebElement lstitemGuests;
	
//	By lstitemGuests=By.xpath("//li[contains(text(),'Guests')]");
	
	@FindBy(xpath="//li[contains(text(),'Vendors')]")
	WebElement lstitemVendors;
	
	@FindBy(xpath="//*[@id='VendorId']")
	WebElement drpmgrOfVendor;
	
	
	//By drpmgrOfVendor=By.xpath("//*[@id='VendorId']");
	
	@FindBy(xpath="Gender_Male")
	WebElement rdMaleGender;
	
	//By rdMaleGender=By.id("Gender_Male");

	@FindBy(xpath="Gender_Female")
	WebElement rdFeMaleGender;
	
	//By rdFeMaleGender=By.id("Gender_Female");
	
	@FindBy(xpath="//input[@id='FirstName']")
	WebElement txtFirstName;
	
	//By txtFirstName=By.xpath("//input[@id='FirstName']");
	
	@FindBy(xpath="//input[@id='LastName']")
	WebElement txtLastName;
	//By txtLastName=By.xpath("//input[@id='LastName']");
	
	@FindBy(xpath="//input[@id='DateOfBirth']")
	WebElement txtDob;
	
	//By txtDob=By.xpath("//input[@id='DateOfBirth']");
	
	@FindBy(xpath="//input[@id='Company']")
	WebElement txtCompanyName;
	
	//By txtCompanyName=By.xpath("//input[@id='Company']");
	
	@FindBy(xpath="//textarea[@id='AdminComment']")
	WebElement txtAdminContent;
		
	//By txtAdminContent=By.xpath("//textarea[@id='AdminComment']");
	
	
	@FindBy(xpath="//button[@name='save']")
	WebElement btnSave;
	
	//By btnSave=By.xpath("//button[@name='save']");
	
	//Actions Methods
			
	public String getPageTitle()
	{
		return ldriver.getTitle();
	}
	
	public void clickOnCustomersMenu() throws InterruptedException {
		lnkCustomers_menu.click();
		Thread.sleep(1000);
	}

	public void clickOnCustomersMenuItem() throws InterruptedException {
		lnkCustomers_menuitem.click();
		Thread.sleep(1000);
	}
	
	public void clickOnAddnew() throws InterruptedException {
		btnAddnew.click();
		Thread.sleep(3000);
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void setPassword(String password)
	{
		txtPassword.sendKeys(password);
	}
	
	
	public void setCustomerRoles(String role) throws InterruptedException 
		{
			if(!role.equals("Vendors")) //If role is vendors should not delete Register as per req.
			{
			ldriver.findElement(By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[2]")).click();
			}
			
			txtcustomerRoles.click();
						
			WebElement listitem;
			
			Thread.sleep(3000);
						
			if(role.equals("Administrators"))
			{
				listitem=lstitemAdministrators; 
			}
			else if(role.equals("Guests"))
			{
				listitem=lstitemGuests;
			}
			else if(role.equals("Registered"))
			{
				listitem=lstitemRegistered;
			}
			else if(role.equals("Vendors"))
			{
				listitem=lstitemVendors;
			}
			else
			{
				listitem=lstitemGuests;
			}
						
			//listitem.click();
			//Thread.sleep(3000);
			
			JavascriptExecutor js = (JavascriptExecutor)ldriver;
			js.executeScript("arguments[0].click();", listitem);
			
	}

	public void setManagerOfVendor(String value)
	{
		Select drp=new Select(drpmgrOfVendor);
		drp.selectByVisibleText(value);
	}
	
	public void setGender(String gender)
	{
		if(gender.equals("Male"))
		{
			rdMaleGender.click();
		}
		else if(gender.equals("Female"))
		{
			rdFeMaleGender.click();
		}
		else
		{
			rdMaleGender.click();//Default
		}
		
	}
	
	public void setFirstName(String fname)
	{
		txtFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		txtLastName.sendKeys(lname);
	}
	
	public void setDob(String dob)
	{
		txtDob.sendKeys(dob);
	}
	
	public void setCompanyName(String comname)
	{
		txtCompanyName.sendKeys(comname);
	}
	
	public void setAdminContent(String content)
	{
		txtAdminContent.sendKeys(content);
	}
	
	public void clickOnSave()
	{
		btnSave.click();
	}
	
}
