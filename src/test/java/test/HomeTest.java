package test;

import org.testng.annotations.Test;

import pageObject.HomePage;
import utility.BaseClass;

public class HomeTest extends BaseClass {
  @Test
  public void THome() {
	  
	 //System.out.println( driver.getCurrentUrl());
	 
	  HomePage h=new HomePage(driver);
	  //h.hp();
	  h.Home();
	  
  }
}
