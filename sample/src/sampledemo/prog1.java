package sampledemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.collect.Table.Cell;

public class prog1 {

	public static void main(String[] args) throws IOException {
  System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
  ChromeDriver d= new ChromeDriver();
  d.get("https://demo.guru99.com/test/newtours/");
  d.manage().window().maximize();
  FileInputStream f3=new FileInputStream("D://Book1.xlsx");
  XSSFWorkbook wb=new XSSFWorkbook(f3);
  XSSFSheet xs= wb.getSheet("book");
  Row r= null;
  Cell c=null;
  FileInputStream f1=new FileInputStream("C:\\Users\\HARSHITHA\\eclipse-workspace\\sample\\src\\sampledemo\\p1.properties");
  Properties p1=new Properties();
  p1.load(f1);
  pom p=new pom(d);
  p.uname(p1.getProperty("username"));
  p.pwd(p1.getProperty("password"));
  p.submit();
  p.register();
  File f2=((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
  FileUtils.copyFile(f2,new File("D://newtask.png"));
  WebElement drop=d.findElement(By.name("country"));
  List<WebElement>drop1=drop.findElements(By.tagName("option"));
  for(int i=0;i<drop1.size();i++)
  {
	 r=xs.createRow(i);
	 r.createCell(0).setCellValue(drop1.get(i).getText());
  }
  FileOutputStream f4=new FileOutputStream("D://Book1.xlsx");
  wb.write(f4);

  
	}

}
