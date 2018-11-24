package wrappers;

import utils.Reporter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GenericWrappers extends Reporter implements Wrappers{
	
	public WebDriver driver;
	public String appUrl;
	public String primWdwHndle;
	
	public GenericWrappers() {
		
		Properties prop = new Properties();
		
		try {
			prop.load(new FileInputStream(new File("./src/main/resources/config.properties")));
			appUrl = prop.getProperty("URL");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void invokeApp(String browser) {
		
		try {
			if(browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			}else if(browser.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			}
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
			driver.get(appUrl);
			
			primWdwHndle = driver.getWindowHandle();
			reportStep("The browser has launched successfully", "PASS");
		
		} catch (Exception e) {
			e.printStackTrace();
			reportStep("The "+browser+" launch has Failed", "FAIL");
		}
	}

	public void enterText(WebElement element, String data) {
		
		
	}

	public void getText(WebElement element) {
		// TODO Auto-generated method stub
		
	}

	public void clickElement(WebElement element) {
		try {
			element.click();
			reportStep("The element is clicked.", "PASS");
		} catch (Exception e) {
			reportStep("The element could not be clicked.", "FAIL");
		}
		
	}

	public boolean verifyTitle(String value) {
		boolean titleState = false;
		
		try {
			if(driver.getTitle().equalsIgnoreCase(value)) {
				titleState = true;
				reportStep("The right page has been laoded", "PASS");
			}else {
				reportStep("Incorrect page laoded", "FAIL");
			}
		} catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
		
		return titleState;
	}

	public void switchToParent() {
		// TODO Auto-generated method stub
		
	}

	public void switchToWindow(String value) {
		// TODO Auto-generated method stub
		
	}

	public void quitApp() {
		try {
			driver.quit();
		} catch (Exception e) {
			reportStep("The browser could not be closed.", "FAIL");
		}		
	}

	public long takeSnap() {
		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L; 
		try {
			FileUtils.copyFile(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE) , new File("./reports/images/"+number+".jpg"));
		} catch (WebDriverException e) {
			reportStep("The browser has been closed.", "FAIL");
		} catch (IOException e) {
			reportStep("The snapshot could not be taken", "WARN");
		}
		return number;
	}

}
