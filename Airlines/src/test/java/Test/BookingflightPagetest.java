package Test;

import java.io.File;

import org.testng.annotations.Test;

import Pages.BookingflightPage;
import Pages.FlightSearchPage;
import Pages.Passengerdetails;

public class BookingflightPagetest extends Basetest {
File f1=new File("C:\\Users\\DharaniKesav\\Desktop\\s12\\testdata3.xls");
	
	@Test
	public void start() {
	String url="https://www.goibibo.com/"; 
	driver.get(url);
    }
	
	@Test(dependsOnMethods= {"BookingflightPagetest.start"},alwaysRun=true)
	public void fs() {
		FlightSearchPage b =new FlightSearchPage(driver);
		b.roundtripsearch(getdata(f1, "origin"), getdata(f1,"destination"));
		b.journeydates();
		b.passengers();
		b.journeyclass();
		
     }
	@Test(dependsOnMethods= {"BookingflightPagetest.fs"},alwaysRun=true)
	public void book() {
		BookingflightPage bk=new BookingflightPage(driver);
		bk.booking();
	}
	


}
