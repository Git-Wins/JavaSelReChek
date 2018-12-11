package wrappers;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import utils.DataInputProvider;
import utils.DataInputProviderConstraint;

public class ProjectWrapper extends GenericWrappers{

	public String browserName;
	public String sheetName;
	public String constraint;
	
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
	
	@DataProvider(name="fetch")
	public Object[][] getData(){
		Object[][] dataFetched = DataInputProvider.fetchData(sheetName, constraint);
		return dataFetched;		
	}
	
	@DataProvider(name="fetchItMan")
	public Object[][] getExcelData(){
		Object[][] excelDataFetched = DataInputProviderConstraint.fetchExcelData(sheetName);
		return excelDataFetched;		
	}

}
