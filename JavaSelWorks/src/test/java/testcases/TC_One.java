package testcases;

import org.testng.annotations.Test;

import pages.HomePage;
import wrappers.ProjectWrapper;

import org.testng.annotations.BeforeClass;

public class TC_One extends ProjectWrapper{
		
  @BeforeClass
  public void beforeClass() {
	  
	  	browserName = "chrome";
		testCaseName = "TC_Onee-LaunchHomePage";
		testDescription = "Just launching the page";
		category = "Smoke";
		authors = "Winston A";
	  
  }
  
  @Test
  public void LaunchPage() throws NullPointerException{
	  
	  new HomePage(driver, test)
	  .clickHomeButton()
	  .launchBlogPage()
	  ;
	  
  }

}
