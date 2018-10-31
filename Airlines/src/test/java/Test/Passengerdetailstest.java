package Test;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.BookingflightPage;
import Pages.FlightSearchPage;
import Pages.Passengerdetails;

public class Passengerdetailstest extends Basetest {
File f1=new File("C:\\Users\\DharaniKesav\\eclipse-workspace\\Airlines\\src\\main\\java\\testdata\\Book1.xls");
File f2= new File("C:\\Users\\DharaniKesav\\eclipse-workspace\\Airlines\\src\\main\\java\\testdata\\testdata3.xls");
int  sheetname= 0;
	
	@Test
	public void start() {
	String url="https://www.goibibo.com/"; 
	driver.get(url);
    }
	
	@Test(dependsOnMethods= {"Passengerdetailstest.start"},alwaysRun=true)
	public void fs() {
		FlightSearchPage b =new FlightSearchPage(driver);
		b.roundtripsearch(getdata(f2, "origin"), getdata(f2,"destination"));
		b.journeydates();
		b.passengers();
		b.journeyclass();
		
     }
@Test(dependsOnMethods= {"Passengerdetailstest.fs"},alwaysRun=true)
	public void book() {
		BookingflightPage bk=new BookingflightPage(driver);
		
		bk.booking();
		System.out.println("exit");
		}
	
	//()
	@Test(dataProvider="readdata",dependsOnMethods= {"Passengerdetailstest.book"})
	public void passenger(String title,String givenname,String surname,String dateofbirth,String passport,String country,String Expiry,String visa,String email,String mobile ) {
		System.out.println("passenger");
		Passengerdetails customer= new Passengerdetails(driver);
		System.out.println(title);
		customer.customerdetails( title,givenname,surname,dateofbirth,passport,country, Expiry,visa,email,mobile);
		
	}
	@DataProvider(name="readdata")
	public Object[][] exceldata() {
		Object[][] testArray=gettable(f1, sheetname);
		return testArray;
	}
	


}
