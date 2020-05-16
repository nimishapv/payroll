package test;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.TimeSheet;
import utility.BaseClass;

public class CompleteTest extends BaseClass {
	
  @Test
  public void main() {
	  
	  LoginPage l=new LoginPage(driver);
	  l.login();
	  
	  HomePage h=new HomePage(driver);
	  String url=driver.getCurrentUrl();
	  System.out.println("from logintest ---"+url);
	  h.Home();	 
	  
  }
}
