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
		//sheetName = "searchValues1";
		sheetName = "Sheet1";
		//constraint = "Yes";
	  
  }
  
  @Test (dataProvider = "fetchItMan")
  public void LaunchPage(String searchVal) throws NullPointerException{
	  
	  new HomePage(driver, test)
	  //.clickHomeButton()
	  //.launchBlogPage()
	  .clickSearchButton()
	  .enterSearchInput(searchVal)
	  ;
	  
  }

}
