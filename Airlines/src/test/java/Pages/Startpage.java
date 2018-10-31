package Pages;
import org.openqa.selenium.WebDriver;
import base.BASEpage;

public class Startpage extends BASEpage {
	private WebDriver driver;

	public Startpage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;		
	}

	 public void LaunchPage(String url) {		 
		 driver.get(url);
	 }	

}
