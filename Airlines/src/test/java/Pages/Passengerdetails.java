package Pages;

import org.openqa.selenium.WebDriver;
import base.BASEpage;

 public class Passengerdetails extends BASEpage{
	 String first_name="//input[@id='AdultfirstName1']";
	 String Adult_title="//select[@id='Adulttitle1']";
     String last_name="//input[@id='AdultlastName1']";
	 String dobday="//select[@id='Adultdob_day1']";
	 String dobmonth="//select[@id='Adultdob_month1']";
	 String dobyr="//select[@id='Adultdob_year1']";
	 String countryname="//select[@id='Adultnational1']";
	 String passportnumber="//input[@id='Adultpassport1']";
	 String Expiryday="//select[@id='Adultexp_day1']";
	 String Expirymonth="//select[@id='Adultexp_month1']";
	 String Expiryyear="//select[@id='Adultexp_year1']";
	 String emailadd="//input[@id='email']";
	 String mobienum="//input[@id='mobile']";
	 String visatype="//select[@id='AdultvisaType1']";
	 
	 String procced="//button[contains(text(),'Proceed to Payment')]";
	 



	public Passengerdetails(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void customerdetails(String title,String givenname,String surname,String dateofbirth,String passport,String country,String Expiry,String visa,String email,String mobile) {
		String visib = "visible";
		Scrollpagedown();
		Dropdown(Adult_title,visib,title);
		findele(first_name).sendKeys(givenname);
		findele(last_name).sendKeys(surname);
		waitingfor(driver);
		selectdates(dobday, dobmonth, dobyr, visib, dateofbirth);
		findele(passportnumber).sendKeys(passport);
		Dropdown(countryname, visib, country);
		selectdates(Expiryday, Expirymonth, Expiryyear, visib, Expiry);
		Dropdown(visatype, visib, visa);
		findele(emailadd).sendKeys(email);
		findele(mobienum).sendKeys(mobile);
		Click(procced);
		
		
	
		
	}
	
	

}
