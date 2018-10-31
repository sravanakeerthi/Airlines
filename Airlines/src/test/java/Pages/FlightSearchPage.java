package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import base.BASEpage;


public class FlightSearchPage extends BASEpage {
	

	public FlightSearchPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	static String btn_roundtrip= "//input[@id='gi_roundtrip_label']";
    String orgin_field ="//input[@id='gosuggest_inputSrc']";
    String destination_field= "//input[@id='gosuggest_inputDest']";
	String frankfurt_select= "//li[@id='react-autosuggest-1-suggestion--0' and @class='react-autosuggest__suggestion']//span[@class='txtTransUpper ico14 greyLt']";
    String Chennai_select= "//li[@id='react-autosuggest-1-suggestion--0' and @class='react-autosuggest__suggestion']//span[contains(text(),\"Chennai\")]";
    
    String calenclick="//input[@class='form-control inputTxtLarge widgetCalenderTxt']";
    String start_date="//div[@id='fare_20181029']";
    String return_date="//div[@id='fare_20181031']";
    String traveller="//span[@id='pax_label']";
    String numoftravellers="//button[@id='adultPaxPlus']";
    String travnumclose="//a[@id='pax_close']";
    String travclass="//select[@id='gi_class']";
    String journeyclass="Economy";
    String search="//button[@id='gi_search_btn' and contains(text(),'Get Set Go')]";

    public  void roundtripsearch(String origin,String destiny) {
    Click(btn_roundtrip);
    findele(orgin_field).sendKeys(origin);
    Waitandclick(frankfurt_select);
    findele(destination_field).sendKeys(destiny);
    Waitandclick(Chennai_select);
    }
    
    
    
    public  void journeydates() {
    	//Click(calenclick);
    	Click(start_date);
    	Click(return_date);
  }

    public void passengers() {
    	Click(traveller);
        Click(numoftravellers);
        Click(travnumclose);
    	}
    
    public void journeyclass() {
       	Select f= new Select(findele(travclass));
        f.selectByVisibleText("Economy");
        Click(search);

    }


	

}
