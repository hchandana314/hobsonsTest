package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class MenuOptions {
	WebDriver driver;
	
	//locators for Solutions items
	@FindBy(xpath="//a[contains(text(),'Solutions')]")
	WebElement Solutions;
	
	@FindBy(xpath="//a[contains(text(),'College and Career Readiness')]")
	WebElement CCReadiness;
	
	@FindBy(xpath="//a[contains(text(),'California')]")
	WebElement California;

	@FindBy(xpath="//a[contains(text(),'Michigan')]")
	WebElement Michigan;
	
	@FindBy(xpath="//a[contains(text(),'Texas')]")
	WebElement Texas;
	
	@FindBy(xpath="//a[contains(text(),'Pennsylvania')]")
	WebElement Pennsylvania;
	
	@FindBy(xpath="//a[contains(text(),'Illinois')]")
	WebElement Illinois;
	
	@FindBy(xpath="//a[contains(text(),'Florida')]")
	WebElement Florida;
	
	@FindBy(xpath="//a[contains(text(),'Match and Fit')]")
	WebElement MatchFit;
	
	@FindBy(xpath="//a[contains(text(),'Student Success and Advising')]")
	WebElement StudentSuccessAdvising;

	//locators for Services items
	@FindBy(xpath="//a[contains(text(),'Services')]")
	WebElement Services;
	
	//locators for Resources items
	@FindBy(xpath="//a[contains(text(),'Resources')]")
	WebElement Resources;

	@FindBy(xpath="//a[contains(text(),'All')]")
	WebElement All;
	
	@FindBy(xpath="//a[contains(text(),'Webinars')]")
	WebElement Webinars;
	
	@FindBy(xpath="//a[contains(text(),'Events')]")
	WebElement Events;
	
	@FindBy(xpath="//a[contains(text(),'Case Studies')]")
	WebElement CaseStudies;
	
	@FindBy(xpath="//a[contains(text(),'White Papers')]")
	WebElement WhitePapers;
	
	@FindBy(xpath="//a[contains(text(),'Blog')]")
	WebElement Blog;
	
	@FindBy(xpath="//a[contains(text(),'Press Releases')]")
	WebElement PressReleases;

	@FindBy(xpath="//a[contains(text(),'Press Coverage')]")
	WebElement PressCoverage;
	
	@FindBy(xpath="//a[contains(text(),'Videos')]")
	WebElement Videos;
	
	//locators for About items
	
	@FindBy(xpath="//a[contains(text(),'About')]")
	WebElement About;
	
	@FindBy(xpath="//a[contains(text(),'Company')]")
	WebElement Company;
	
	@FindBy(xpath="//a[contains(text(),'Partnerships')]")
	WebElement Partnerships;

	@FindBy(xpath="//a[contains(text(),'Careers')]")
	WebElement Careers;
	
	@FindBy(xpath="//a[contains(text(),'Media Kit')]")
	WebElement MediaKit;
	
	@FindBy(xpath="//a[contains(text(),'Contact Us')]")
	WebElement ContactUs;
	
	//locators for Blog items
	@FindBy(xpath="//li/a[contains(text(),'Blog')]")
	WebElement Blog2;
		
	public MenuOptions (WebDriver driver) {
		this.driver=driver;
		
		//Initialize Elements
		PageFactory.initElements(driver, this);
	}
	
	public void MouseHoverOver(WebElement element) throws InterruptedException
	{
		Actions actions = new Actions(driver);
		 actions.moveToElement(element).perform();
		 Thread.sleep(3000);
		 System.out.println("Done Mouse hover on "+ element +"from Menu");
	}
	
	public void CheckHomePageForSolutionsMenuItems() throws InterruptedException {
		MouseHoverOver(Solutions);
		Solutions.isDisplayed();
		CCReadiness.isDisplayed();
		California.isDisplayed();
		Michigan.isDisplayed();
		Texas.isDisplayed();
		Pennsylvania.isDisplayed();
		Illinois.isDisplayed();
		Florida.isDisplayed();
		MatchFit.isDisplayed();
		StudentSuccessAdvising.isDisplayed();
	}
	
	
	public void CheckHomePageForServicesMenuItems() throws InterruptedException {
		MouseHoverOver(Services);
		Services.isDisplayed();
	}

	public void CheckHomePageForResourcesMenuItems() throws InterruptedException {
		MouseHoverOver(Resources);
		Resources.isDisplayed();
		All.isDisplayed();
		Webinars.isDisplayed();
		Events.isDisplayed();
		CaseStudies.isDisplayed();
		WhitePapers.isDisplayed();
		Blog.isDisplayed();
		PressReleases.isDisplayed();
		PressCoverage.isDisplayed();
		Videos.isDisplayed();
	}
	
	public void CheckHomePageForAboutMenuItems() throws InterruptedException {
		MouseHoverOver(About);
		About.isDisplayed();
		Company.isDisplayed();
		Partnerships.isDisplayed();
		Careers.isDisplayed();
		MediaKit.isDisplayed();
		ContactUs.isDisplayed();
	}
	
	public void CheckHomePageForBlogMenuItems() throws InterruptedException {
		MouseHoverOver(Blog2);
		Blog2.isDisplayed();
	}
	
}
