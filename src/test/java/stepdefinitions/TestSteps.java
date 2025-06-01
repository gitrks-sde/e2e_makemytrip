package stepdefinitions;

import e2e.pageobjects.Homepage;
import e2e.pageobjects.PageObjectElements;
import e2e.pageobjects.TicketPage;
import e2emakemytrip.utilities.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestSteps extends BaseClass{
	
	
	@Before
	public void loadGoIbibo()
	{
		loadBrowser();
		Homepage homepage = new Homepage(driver);
		homepage.clickToCloseLoginFrame();
	}
	@Given("user landed on homepage")
	public void user_landed_on_homepage() {
		loadBrowser(); 
	}
	
	@When("user selects {string} as From location")
	public void user_selects_from_location(String from) throws InterruptedException {
		Homepage homepage = new Homepage(driver);

		homepage.selectFromLocation(from);

	}

	@When("user selects {string} as To location")
	public void user_selects_to_location(String to) throws InterruptedException {
		Homepage homepage = new Homepage(driver);
		homepage.selectToLocation(to);
	}

	@Then("validate tickets are loaded")
	public void validate_tickets_are_loaded() throws InterruptedException {
		

	}
	
	@Then("user selects Todays date")
	public void user_selects_Todays_date()
	{
		Homepage homepage = new Homepage(driver);
		homepage.selectToday();
		
	}
	
	@Then("verify the available tickets")
	public void verify_the_available_tickets()
	{
		TicketPage ticketPage=new TicketPage();
		ticketPage.closeCoachmark();
		ticketPage.getTicketInfo();
	}
	
	@And("close the browser")
	public void close_the_browser() throws InterruptedException {
		closeConnection();
	}
	
	@Then("user clicks on {string} Book now")
	public void user_clicks_on_Book_now(String ttype)
	{
		TicketPage ticketPage=new TicketPage();
		ticketPage.clickOnBookNow(ttype.toUpperCase());
	}
	
	@When("user clicks on {string} button")
	public void user_clicks_on_button(String locator)
	{
		PageObjectElements pElements=new PageObjectElements();
		clickOnElement(pElements.getElement(locator));
	}
	
	@When("user enter {string} as from location")
	public void user_enter_from_location(String from)
	{
		PageObjectElements pElements=new PageObjectElements();
		pElements.enterFrom(from);
	}
	
	@After
	public void endTest(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			byte[] screenshot=takeScreeshot(driver);
			scenario.attach(screenshot, "image/png", "failed");
			driver.quit();
		}
	}
	
	//@AfterStep
	public void iWillExecuteAfterEachStep(Scenario scenario)
	{
		
			byte[] screenshot=takeScreeshot(driver);
			scenario.attach(screenshot, "image/png", "success");
	}

}
