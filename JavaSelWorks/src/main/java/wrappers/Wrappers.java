package wrappers;

import org.openqa.selenium.WebElement;

public interface Wrappers {

	public void invokeApp(String browser);
	
	public void enterText(WebElement element, String data);
	
	public void getText(WebElement element);
	
	public void clickElement(WebElement element);
	
	public boolean verifyTitle(String value);
	
	public void switchToParent();
	
	public void switchToWindow(String value);
	
	public void quitApp();
	
}
