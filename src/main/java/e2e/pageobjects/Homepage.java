package e2e.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import e2emakemytrip.utilities.BaseClass;
import e2emakemytrip.utilities.CommonActions;

public class Homepage extends BaseClass {

	WebDriver driver;

	public Homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	CommonActions cActions = new CommonActions();

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

	public void clickToCloseLoginFrame() {
		cActions.clickIfElementExist(closeIcon);
		cActions.clickIfElementExist(closeAd);
	}

	public void selectFromLocation(String from) throws InterruptedException {
		fromCity.click();
		fromInput.sendKeys(from.substring(0, 3));
		Thread.sleep(5000);

		List<WebElement> fromlist = driver
				.findElements(By.xpath("//span[@class='autoCompleteTitle ']"));

		for (WebElement ele : fromlist) {

			if (ele.getText().contains(from)) {
				logger.info("Selected location " + ele.getText());
				ele.click();
				break;
			}
		}
	}

	public void selectToLocation(String to) throws InterruptedException {
		
		
		cActions.waitForElementToVisible(toCity, driver);
		//clickIfElementExist(toCity);
		toInput.sendKeys(to.substring(0, 3));
		
		Thread.sleep(5000);

		List<WebElement> tolist = driver
				.findElements(By.xpath("//span[@class='autoCompleteTitle ']"));

		for (WebElement ele : tolist) {

			if (ele.getText().contains(to)) {
				logger.info("Selected location " + ele.getText());
				ele.click();
				break;
			}
		}

	}
	
	public void clickOnSearchButton()
	{
		cActions.clickOnElement(searchIcon);
	}
	
	public void selectToday()
	{
		today.click();
	}

}
