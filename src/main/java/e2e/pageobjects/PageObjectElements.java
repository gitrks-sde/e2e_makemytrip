package e2e.pageobjects;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import e2emakemytrip.utilities.BaseClass;

public class PageObjectElements extends BaseClass {

	WebDriver driver;
	public PageObjectElements()
	{
		this.driver=super.driver;
		PageFactory.initElements(driver,this);
		initElementMap();
	}
	
	private Map<String, WebElement> elementMap;
	
	@FindBy(xpath = "//span[@class='logSprite icClose']")
	WebElement closeIcon;

	@FindBy(xpath = "//span[text()='From']/following-sibling::input")
	WebElement fromInput;

	@FindBy(xpath = "//span[text()='To']/following-sibling::input")
	WebElement toInput;

	@FindBy(xpath = "//span[text()='From']/following-sibling::p[text()='Enter city or airport']")
	WebElement fromCity;

	@FindBy(xpath = "//span[text()='To']/following-sibling::p[text()='Enter city or airport']")
	WebElement toCity;
	
	@FindBy(xpath = "//span[text()='SEARCH FLIGHTS']")
	WebElement searchIcon;
	
	@FindBy(xpath = "//div[contains(@class,'selected')]")
	WebElement today;
	
	@FindBy(xpath = "//div[@data-id='dweb_pip_id']/p[1]")
	WebElement closeAd;
	
	@FindBy(xpath = "//span[@data-testid='coachmark-overlay-button']")
	WebElement coachmark;
	
	@FindBy(xpath = "(//button[contains(@id,'bookbutton-RKEY')])[1]")
	WebElement firstViewFare;


    private void initElementMap() {
        elementMap = new HashMap<>();
        elementMap.put("viewFare", firstViewFare);
        elementMap.put("search", searchIcon);
        elementMap.put("closePopup", closeIcon);
        elementMap.put("closeAd", closeAd);

    }

    public WebElement getElement(String elementName) {
        WebElement element = elementMap.get(elementName);
        if (element == null) {
            throw new IllegalArgumentException("Element not found: " + elementName);
        }
        return element;
    }
    
    public void enterFrom(String location)
    {
    	fromInput.sendKeys(location);
    }
}
