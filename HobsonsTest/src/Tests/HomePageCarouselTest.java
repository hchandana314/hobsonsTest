package Tests;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.HomePageCarousel;
import Pages.MenuOptions;

public class HomePageCarouselTest {
	WebDriver driver;

	@BeforeMethod
	public void setup() throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Test\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Launch Website
		driver.get("http://hobsons.com/");

		// Maximize the browser
		driver.manage().window().maximize();
		Thread.sleep(10000);
		//scroll down to view carousel
		js.executeScript("window.scrollBy(0,1000)");

	}

	@Test
	public void TestNextArrow() throws InterruptedException {
		HomePageCarousel hpnav = new HomePageCarousel(driver);
		// Items loaded in the Carousel
		ArrayList list1 = hpnav.getItemsList();

		// Click next button
		hpnav.Next();

		// New Items get loaded in the Carousel after the Click
		ArrayList list2 = hpnav.getItemsList();

		// Comparing the Two Array Lists before and after clicking next arrow
		System.out.println(list1);
		System.out.println(list2);
		Assert.assertFalse(list1.equals(list2));
	}
	
	@Test
	public void TestPrevArrow() throws InterruptedException {
		HomePageCarousel hpnav = new HomePageCarousel(driver);
		// Items loaded in the Carousel
		ArrayList list1 = hpnav.getItemsList();

		// Click next button
		hpnav.Prev();

		// New Items get loaded in the Carousel after the Click
		ArrayList list2 = hpnav.getItemsList();

		// Comparing the Two Array Lists before and after clicking Prev arrow
		System.out.println(list1);
		System.out.println(list2);
		Assert.assertFalse(list1.equals(list2));
	}
	
	@AfterMethod
	public void close() {
		driver.quit();
	}
}