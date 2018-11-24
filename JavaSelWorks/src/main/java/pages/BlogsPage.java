package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapper;

public class BlogsPage extends ProjectWrapper{
	
	//Page's constructor
	public BlogsPage(WebDriver driver, ExtentTest test) {
		this.driver=driver;
		this.test=test;
		if(verifyTitle("Blogs Archives | TOOLSQA")) {
			PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
		}else {
			reportStep("The page loaded is not Blogs Page", "FAIL");
		}
	}
	
	//WebElements identified
		
	//Page's methods
	
	
	

}
