package test;

import java.awt.AWTException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pageObject.ApprovedTimeSheet;
import pageObject.CreateTimeSheet;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.PendingTimeSheet;
import pageObject.TimeSheet;
import utility.BaseClass;

public class CompleteTest extends BaseClass {
	LoginPage l;
	TimeSheet t;
	 ApprovedTimeSheet a;
	 CreateTimeSheet c;
	 PendingTimeSheet p;
	 
  @Test(priority=0)
  public void LoginPageTest(){
	  
	l=new LoginPage(driver);
	l.login(); }
  @Test(priority=1)
  public void TimeSheetTest() {
	  t = new TimeSheet(driver);
	  t.testPage();
  }
  @Test(priority=2)
  public void ApprovedTimeSheetTest() {
	 a =new ApprovedTimeSheet(driver);
	  a.approvedTSheet();
  }  
  @Test(priority=3)
  public void CreateTimeSheet() throws AWTException, InterruptedException {
	 c=new CreateTimeSheet(driver);
	  c.testCreateTimeSheet();
	  
  }
  
  @Test(priority=4)
  public void pendingTimeSheetTest() throws InterruptedException {
	  p=new PendingTimeSheet(driver);
	  p.pendingTimeSheetLoad();
	  p.viewPendingTimeSheetDetails();
	  p.updatePendingTimeSheetDetails();
	  p.confirmTimeSheetDetails();
  }
  
  
}
