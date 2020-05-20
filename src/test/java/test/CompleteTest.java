package test;

import java.awt.AWTException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pageObject.ApprovedTimeSheet;
import pageObject.CreateTimeSheet;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.TimeSheet;
import utility.BaseClass;

public class CompleteTest extends BaseClass {
	
  @Test(priority=1)
  public void main() throws AWTException, InterruptedException {
	  
	  LoginPage l=new LoginPage(driver);
	  l.login();
	  
	  TimeSheet t = new TimeSheet(driver);
	  t.testPage();
	  
	  ApprovedTimeSheet a =new ApprovedTimeSheet(driver);
	  a.approvedTSheet();
	  
	  CreateTimeSheet c=new CreateTimeSheet(driver);
	  c.testCreateTimeSheet();
	  
  }
}
