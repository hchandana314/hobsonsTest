package Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.MenuOptions;


public class MenuOptionsTest {

	WebDriver driver;

	@BeforeSuite
	public void setup() {

		System.setProperty("webdriver.chrome.driver", "C:\\Test\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();

		// Launch Website
		driver.get("http://hobsons.com/");

		// Maximize the browser
		driver.manage().window().maximize();
	}

	@Test
	public void SolutionsMenuItems() throws InterruptedException {
		MenuOptions menu = new MenuOptions(driver);
		menu.CheckHomePageForSolutionsMenuItems();
	}

	@Test
	public void ServicesMenuItems() throws InterruptedException {
		MenuOptions menu = new MenuOptions(driver);
		menu.CheckHomePageForServicesMenuItems();
	}

	@Test
	public void ResourcesMenuItems() throws InterruptedException {
		MenuOptions menu = new MenuOptions(driver);
		menu.CheckHomePageForResourcesMenuItems();
	}

	@Test
	public void AboutMenuItems() throws InterruptedException {
		MenuOptions menu = new MenuOptions(driver);
		menu.CheckHomePageForAboutMenuItems();
	}

	@Test
	public void BlogMenuItems() throws InterruptedException {
		MenuOptions menu = new MenuOptions(driver);
		menu.CheckHomePageForBlogMenuItems();
	}

	@AfterSuite
	public void close() {
		driver.quit();
	}
}
