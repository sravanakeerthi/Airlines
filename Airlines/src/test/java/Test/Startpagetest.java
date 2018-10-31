package Test;
import org.testng.annotations.Test;

import Pages.BookingflightPage;
import Pages.FlightSearchPage;
import Pages.Startpage;
import Utilities.LoadElement;
import base.BASEpage;


public class Startpagetest extends Basetest{
	
	@Test
	public void start() {
	String url="https://www.goibibo.com/"; 
	 
	driver.get(url);
//	Startpage c=new Startpage(driver);
//	c.LaunchPage("url");
  }
	
	@Test(dependsOnMethods= {"start"},alwaysRun=true)
	public void fs() {
		FlightSearchPage b =new FlightSearchPage(driver);
		b.roundtripsearch("FRA", "MAA");
		b.journeydates();
		b.passengers();
		b.journeyclass();
		
		}
	@Test(dependsOnMethods= {"fs"},alwaysRun=true)
	public void book() {
		BookingflightPage bk=new BookingflightPage(driver);
		bk.booking();
	
	}
}
