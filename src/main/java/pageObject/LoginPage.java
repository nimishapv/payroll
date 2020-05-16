package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(name="LoginForm[username]")
	WebElement user;
	@FindBy(name="LoginForm[password]")
	WebElement pass;
	@FindBy(name="login-button")
	WebElement button;
	
	
	/*public void Login(String n,String p)
	{
		user.sendKeys(n);
		pass.sendKeys(p);
		button.click();
	}*/
	
	public void login() {
		
		user.sendKeys("carol");
		pass.sendKeys("1q2w3e4r");
		button.click();

		  
		  WebDriverWait w=new WebDriverWait(driver,30);
		  w.until(ExpectedConditions.urlContains("http://qabible.in/payrollapp/site/index"));
		  
		  System.out.println("Login success");
		/*if (url.equals("http://qabible.in/payrollapp/site/login")) {
			driver.get("http://qabible.in/payrollapp/site/index");
		}*/
	}
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	

}
