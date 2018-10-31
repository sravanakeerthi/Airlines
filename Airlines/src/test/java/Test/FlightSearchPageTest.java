package Test;

import java.io.File;
import org.testng.annotations.Test;
import Pages.FlightSearchPage;

public class FlightSearchPageTest extends Basetest{
	File f1=new File("C:\\Users\\DharaniKesav\\Desktop\\s12\\testdata3.xls");
	
	@Test
	public void start() {
	String url="https://www.goibibo.com/"; 
	driver.get(url);
    }
	
	@Test(dependsOnMethods= {"FlightSearcgPageTest.start"},alwaysRun=true)
	public void fs() {
		FlightSearchPage b =new FlightSearchPage(driver);
		b.roundtripsearch(getdata(f1, "origin"), getdata(f1,"destination"));
		b.journeydates();
		b.passengers();
		b.journeyclass();
		
     }

}
