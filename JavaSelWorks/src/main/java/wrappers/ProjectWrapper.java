package wrappers;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class ProjectWrapper extends GenericWrappers{

	public String browserName;
	
	@BeforeSuite
	public void beforeSuite() {
		startResult();
	}
	
	@BeforeMethod
	public void beforeTest() {
		test = startTestCase(testCaseName, testDescription);
		test.assignAuthor(authors);
		test.assignCategory(category);
		invokeApp(browserName);
	}
	
	@AfterMethod
	public void afterTest() {
		endTestcase();
		quitApp();
	}
	
	@AfterSuite
	public void afterSuite() {
		endResult();
	}
	
	/*@DataProvider(name="fetchData")
	public Object[][] getData(){
		return DataInputProvider.getSheet(dataSheetName);		
	}*/

}
