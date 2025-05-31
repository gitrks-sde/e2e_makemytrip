package e2e.pageobjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import e2emakemytrip.utilities.BaseClass;
import e2emakemytrip.utilities.CommonActions;

public class TicketPage extends BaseClass {

	WebDriver driver;
	
	public TicketPage()
	{
		this.driver = super.driver;		
		PageFactory.initElements(driver, this);
		initElementMap();
	}
	
	@FindBy(xpath = "//span[@data-testid='coachmark-overlay-button']")
	WebElement coachmark;
	
	@FindBy(xpath = "(//button[contains(@id,'bookbutton-RKEY')])[1]")
	WebElement firstViewFare;
	
	public void closeCoachmark()
	{
		clickIfElementExist(coachmark);
	}
	
	public void getTicketInfo()
	{
		List<WebElement> flightCodes=driver.findElements(By.xpath("//p[@class='fliCode']"));
		Map<String, String> flightInfo=new HashMap<String, String>();
		
		for(WebElement ele:flightCodes)
		{
			String flightcode=ele.getText();
			WebElement fliName=driver.findElement(By.xpath("//p[text()='"+flightcode+"']/preceding-sibling::p"));
			String flightName=fliName.getText();
			flightInfo.put(flightcode, flightName);
		}
		logger.info(flightInfo);
		
	}

	public void clickOnViewFare() {
		
		clickOnElement(firstViewFare);
	}
	
	public void clickOnBookNow(String ttype)
	{
		WebElement booknow=driver.findElement(By.xpath("//p[text()='"+ttype+"']/../../../div[3]/div/button[text()='BOOK NOW']"));
		clickOnElement(booknow);
	}
	private Map<String, WebElement> elementMap;

    private void initElementMap() {
        elementMap = new HashMap<>();
        elementMap.put("viewFare", firstViewFare);

    }

    public WebElement getElement(String elementName) {
        WebElement element = elementMap.get(elementName);
        if (element == null) {
            throw new IllegalArgumentException("Element not found: " + elementName);
        }
        return element;
    }
}
	
