package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

public class HomePage {
	WebDriver driver;
	
	
	/* public void hp() {
		driver.get("http://qabible.in/payrollapp/site/index");
	}*/
	
	@FindBy(xpath="//a[@href=\"/payrollapp/timesheet/index\"]")
	WebElement timesheet;
	
	public void Home() {
		// String url=driver.getCurrentUrl();
			//System.out.println("From homepage ----"+url);
		//WebDriverWait w=new WebDriverWait(driver,60);
		//w.until(ExpectedConditions.elementToBeClickable(timesheet));
		TimeSheet t=new TimeSheet(driver);
		t.loadPage();
		t.buttonAlerts();
	}
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

}
