package Pages;
import org.openqa.selenium.WebDriver;

import base.BASEpage;

public class BookingflightPage extends BASEpage {
	public BookingflightPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	String cheapest_flight="//div[@class='fl ico15 chpFstFilt']//a[3]";
	String Book_button="//input[@value='BOOK']";
	String transit_check="//input[@id='impInfo']";
	String Travel_assistance="//input[@id='call_assistance']";
	
	
	
	public void booking() {		
		Waitandclick(cheapest_flight);
		Waitandclick(Book_button);
		Scrollpagedown();
		Scrollpagedown();
		Checkandclick(transit_check);
		Checkandclick(Travel_assistance);
	
	}
}
