package utility;


import org.testng.annotations.DataProvider;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;


public class BaseClass {
	public WebDriver driver;
	

 /* @DataProvider
  public Object[][] dp() throws IOException, BiffException {
	  FileInputStream f=new FileInputStream("");
	  Workbook w=Workbook.getWorkbook(f);
	  Sheet s=w.getSheet("Sheet1");
	  int rw=s.getRows();
	  int col=s.getColumns();
	  String[][] input=new String[rw][col];
	  for(int i=0;i<rw;i++) {
		  for(int j=0;j<col;j++) {
			  Cell c=s.getCell(j,i);
			  input [j][i]=c.getContents();
		  }
		  
	  }
	  
	  return input;
   
  }*/
  @BeforeClass
  public void beforeClass() {
	  
	  System.setProperty("webdriver.chrome.driver","D:\\\\chromedriver_win32\\\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("http://qabible.in/payrollapp/site/login");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @AfterClass
  public void afterClass() {
	 // driver.close();
  }

}
