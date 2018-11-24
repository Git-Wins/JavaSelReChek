package sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestOne {

	public static void main(String[] args) {
		
		WebDriver driver;
		String appUrl = "http://toolsqa.com/";	
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.get(appUrl);
		//driver.findElement(By.linkText("Blogs")).click();
		driver.findElement(By.xpath("//*[@id='primary-menu']/li[6]/a/span/span")).click();
	}

}
