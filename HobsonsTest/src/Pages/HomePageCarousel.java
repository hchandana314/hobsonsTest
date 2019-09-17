package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindAll;

public class HomePageCarousel {
	WebDriver driver;
	
	@FindBy(xpath="//ul[@id='home-carousel']//div//div//div[@class='owl-item active']//li//div//h4 | //ul[@id='home-carousel']//div//div//div[@class='owl-item cloned active']//li//div//h4")
	List<WebElement> items;
	
	@FindBy(xpath="//ul[@id='home-carousel']//div[@class='owl-next'][contains(text(),'next')]")
	WebElement NextButton;
	
	@FindBy(xpath="//ul[@id='home-carousel']//div[@class='owl-prev'][contains(text(),'prev')]")
	WebElement PrevButton;

	public HomePageCarousel (WebDriver driver) {
		this.driver=driver;
		
		//Initialize Elements
		PageFactory.initElements(driver, this);
	}
	
	public void Next(){
		// Clicking on the Next Arrow of the Carousel
		NextButton.click();

	}
	
	public void Prev(){
		// Clicking on the Previous Arrow of the Carousel
		PrevButton.click();
	}
	
	public ArrayList getItemsList(){
		//Get Active Item text from the Carousel
		ArrayList<String> list1 = new ArrayList<String>();
		String name;
		for (WebElement element : items) {

			name = (element.getText());
			list1.add(name);
			
		}
		return list1;
	}
}
