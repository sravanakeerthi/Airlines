package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.Select;

import Utilities.ExcelProcess;
import Utilities.LoadElement;

public abstract class BASEpage {
		
	protected  WebDriver driver;
	protected BASEpage(WebDriver driver){
		this.driver=driver;
	}

	
	protected enum BY_TYPE {

        BY_XPATH, BY_LINKTEXT, BY_ID, BY_CLASSNAME,
        BY_NAME, BY_CSSSELECTOR, BY_PARTIALLINKTEXT, BY_TAGNAME
	};
	
	 protected By getLocator(String locator, BY_TYPE type) {

	        switch (type) {
	            case BY_XPATH:

	                return By.xpath(locator);

	            case BY_LINKTEXT:
	                return By.linkText(locator);
	            case BY_ID:

	                return By.id(locator);

	            case BY_CSSSELECTOR:
	                return By.cssSelector(locator);
	            case BY_CLASSNAME:

	                return By.className(locator);

	            case BY_NAME:
	                return By.name(locator);

	            case BY_PARTIALLINKTEXT:
	                return By.partialLinkText(locator);

	            case BY_TAGNAME:
	                return By.tagName(locator);

	        }
	        throw new IllegalArgumentException("Invalid By Type, Please provide correct locator type");

	    }
	 public WebElement findele(String path) {
		
		 return driver.findElement(By.xpath(path));
	 }
	 public void Click(String path) {		
		 findele(path).click();
     }
	 
	 public void Waitandclick(String presence) {
		waitingfor(driver);
		Click(presence);
		
	 }
	 public void Dropdown(String element,String given,Object org) {
		 
	        Select x=new Select(findele(element));
	        String value="value";
	        String index="index";
	        String visible="visible";
	       
	        if(visible.equalsIgnoreCase(given))
	        {
	        	//select by visible text
		        x.selectByVisibleText((String) org);
		        
	        }
	        else if(index.equalsIgnoreCase(given))
	        {
	        	 //select by index
		        x.selectByIndex((Integer) org);
		       
	        }
	        else if(value.equalsIgnoreCase(value)) {
	        	 
		        //select by value
		        x.selectByValue((String) org);
		       
	        }
	        
	 }
	 public static void waitingfor(WebDriver driver)  {
			System.out.println(" logs");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			while(true) {
				LogEntries logs = driver.manage().logs().get(LogType.PERFORMANCE);
						 int length=  logs.getAll().size();
						 if(length>0) {
							 if(logs.getAll().get(length-1).getMessage().contains("loadingFinished")==true) {
						        	try {
										Thread.sleep(500);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} 
						        	LogEntries logs2 = driver.manage().logs().get(LogType.PERFORMANCE);
						        	 int lengt=  logs2.getAll().size();
						        	 if(lengt>0) {
						        		 if(logs2.getAll().get(lengt-1).getMessage().contains("loadingFinished")==true) {
						        			 break;
						 		       	}
						        	 }
						        	 else {
						        		 break;
						        	 }
						     }
					 }
					   else {
							 break;
							 
					  }
		     }        	
		        		        
		}       
	 public void Scrollpagedown() {
		 
		 JavascriptExecutor js= (JavascriptExecutor) driver;
		   // This  will scroll down the page by  1000 pixel vertical		
	        js.executeScript("window.scrollBy(0,500)");
	  	 }
	 
	 
	 public void Presenceofelement() {
		 
		 waitingfor(driver);
		 
		 
	 }
	 public  void Checkandclick(String x) {
		 while(true) {
			 Scrollpagedown();
		 if(findele(x).isDisplayed()==true) {
			 Click(x);
			 break;
					 
		 }
		 }
	 }
	 private Object[] dateformat(String date) {
		 Object[] n= date.split("\\.");
		  return n;
		 
	 }
	  
	 public void selectdates(String day,String month,String year,String visible,String givendate) {
		 
		Object[] b= dateformat(givendate);
		
		Dropdown(day, visible,b[0]);
		Dropdown(month, visible,b[1].toString());
		Dropdown(year, visible,b[2]);
		
		 
	 }

}
