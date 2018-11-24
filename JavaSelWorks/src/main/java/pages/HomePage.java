package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapper;

public class HomePage extends ProjectWrapper{
	
	//Page's constructor
	public HomePage(WebDriver driver, ExtentTest test) {
		this.driver=driver;
		this.test=test;
		if(verifyTitle("QA Automation Tools Tutorial")) {
			PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
		}else {
			reportStep("The page loaded is not Home Page", "FAIL");
		}
	}
	
	
	//WebElements identified
	@FindBy(how=How.LINK_TEXT, using="HOME")
	private WebElement HomeButton;
	
	@FindBy(how=How.XPATH, using="//*[@id='primary-menu']/li[6]/a/span/span")
	private WebElement BlogsButton;
	
	
	//Page's methods
	public HomePage clickHomeButton() {
		clickElement(HomeButton);
		return this;
	}
	
	public BlogsPage launchBlogPage() {
		clickElement(BlogsButton);
		return new BlogsPage(driver, test);
	}

}
