package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Careers {
	WebDriver driver;

	@FindBy(xpath = "//*[@id='careers-locations']/h2/strong")
	WebElement careerLocs;

	// @FindBy(xpath="//*[text()='Cincinnati, OH']")
	@FindBy(xpath = "//a[contains(text(),'Cincinnati, OH')]")
	WebElement Cincinnati;

	@FindBy(xpath = "//a[contains(text(),'Arlington, VA')]")
	WebElement Arlington;
	
	@FindBy(xpath="//input[@id='searchboxinput']")
	WebElement GoogleMapsSearch;
	

	public Careers(WebDriver driver) {
		this.driver = driver;

		// Initialize Elements
		PageFactory.initElements(driver, this);
	}

	public boolean CareersPageOpen() {
		return careerLocs.isDisplayed();
	}

	public String getAddress(WebElement element) throws InterruptedException {
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();

		// wait for page to load and click on location to open in
		// google maps
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
		//scroll to the end
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView();", element);
		 
		//Click on Address
		 element.click();
		
		// Switch to new window opened 
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
			Thread.sleep(5000);
			}
		wait.until(ExpectedConditions.visibilityOf(GoogleMapsSearch));
		return driver.getCurrentUrl();
	}

	public String getArlingtonAddress() throws InterruptedException {
		return this.getAddress(Arlington);
	}
	public String getCincinnatiAddress() throws InterruptedException {
		return this.getAddress(Cincinnati);
	}
}
