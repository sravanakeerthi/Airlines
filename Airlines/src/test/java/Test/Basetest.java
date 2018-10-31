package Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;



abstract class Basetest {
	public static WebDriver driver;
	
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DharaniKesav\\Desktop\\s12\\chromedriver.exe");
	 	LoggingPreferences logPrefs = new LoggingPreferences();
	 	logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
	    ChromeOptions options=new ChromeOptions();
	    options.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
     	driver= new ChromeDriver(options);
     	driver.manage().window().maximize();
	}
	
//	@AfterClass
//	public void tear() {
//		driver.quit();
//	}
	protected static  Sheet Getfile(File f1) {

		 Workbook wb;
		 try {
			wb = Workbook.getWorkbook(f1);
			Sheet rs=wb.getSheet(0);
			return rs;
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	 
	protected static  String sheetprocess(Sheet rs,String data) {
		
		int i=0;
		int j=0;
		int count =0;
		while(true) {
			if(rs.getCell(j, i).getContents().contains(data)==true){
				count=i++;
				break;
			}
			count=i++;
		}
	String RES=rs.getCell(j+1, count).getContents();
	 
	return RES;
	
	}
	
	
 public static   String getdata(File f1 ,String data) {
		Sheet rs=Getfile(f1);
		String result=sheetprocess(rs, data);
		return result;
	
   }
 public static String[][] gettable(File file, int sheetname) {
	 String [][] tabArray=null;
	 //Access the required test data sheet
	 
	 Workbook book;
	try {
		book = Workbook.getWorkbook(file);
	    Sheet r=book.getSheet(sheetname);
		 int Start_row =1;
		 int Start_column=0;
		 System.out.println(r.getRows());
		 int totalrows=r.getRows();
		 int totalcolumns=r.getColumns();
		 
		 System.out.println(totalrows +" &&&" + totalcolumns);
		  tabArray = new String[totalrows-1][totalcolumns];
		  int ci,cj;
	     ci=0;
	     for (int i=Start_row;i<=totalrows-1
	    		 ;i++, ci++) {           	  
	    	 cj=0;
        	   for (int j=Start_column;j<=totalcolumns-1;j++, cj++){
        		   tabArray[ci][cj]=getCellData(r,i,j);
        		   System.out.println(tabArray[ci][cj]);  

				}
          }
	    
	}
	catch (BiffException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	 return(tabArray);
	       	
 }
 private static String getCellData(Sheet rs,int i, int j) {
		// TODO Auto-generated method stub
	 
			Cell cell = rs.getCell(j, i);
			System.out.println(cell.getType());
			String CellData = cell.getContents();
		return CellData ;
 }
 
	 
 }

	 







