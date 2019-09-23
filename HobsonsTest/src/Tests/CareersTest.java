package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Pages.Careers;
import Pages.MenuOptions;

public class CareersTest {
	WebDriver driver;

	@BeforeMethod
	public void setup() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Test\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Launch Website
		driver.get("http://hobsons.com/");

		// Maximize the browser
		driver.manage().window().maximize();

		// scroll down to view careers
		WebElement CareersLink = driver.findElement(By.xpath("//div/ul/li/a[contains(text(),'Careers')]"));

		// wait till link displayed
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(CareersLink));

		// Click on Careers link
		js.executeScript("arguments[0].scrollIntoView();", CareersLink);
		CareersLink.click();
		Thread.sleep(5000);
	}

	@Test
	public void VerifyCincinnatiAddress() throws InterruptedException {
		Careers cLoc = new Careers(driver);
		cLoc.CareersPageOpen();
		String CincinnatiAddress = cLoc.getCincinnatiAddress();
		Assert.assertTrue(CincinnatiAddress.contains(
				"https://www.google.com/maps/place/400+E+Business+Way+%23400Cincinnati,+Sharonville,+OH+45241"));
	}

	@Test
	public void VerifyArlingtonAddress() throws InterruptedException {
		Careers cLoc = new Careers(driver);
		cLoc.CareersPageOpen();
		String CincinnatiAddress = cLoc.getArlingtonAddress();
		Assert.assertTrue(CincinnatiAddress
				.contains("https://www.google.com/maps/place/3033+Wilson+Blvd+%23500Arlington,+Arlington,+VA+22201"));
	}

	@AfterMethod
	public void close() {
		 driver.quit();
	}

}
