package regressiontests;

import org.testng.annotations.Test;

import e2e.pageobjects.Homepage;
import e2e.pageobjects.TicketPage;
import e2emakemytrip.utilities.BaseClass;

public class getFlightDetails extends BaseClass{

	@Test
	public void getFlightInfo() throws InterruptedException
	{
		Homepage homepage=new Homepage(driver);
		
		homepage.clickToCloseLoginFrame();
		homepage.selectFromLocation("Chennai");
		Thread.sleep(3000);
		homepage.selectToLocation("Delhi");
		homepage.clickOnSearchButton();
		
		TicketPage ticketPage=new TicketPage();
		ticketPage.closeCoachmark();
		ticketPage.getTicketInfo();
	}
}
