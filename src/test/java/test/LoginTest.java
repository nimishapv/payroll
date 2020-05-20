package test;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.TimeSheet;
import utility.BaseClass;

public class LoginTest extends BaseClass {
	
  @Test(priority=0)
  public void first() {
		  LoginPage l=new LoginPage(driver);
		  l.login();
  }
}
