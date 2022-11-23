package Task1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class test3 {
	WebDriver d;
	@Given("Opening chrome browser  & Navigate to newtours.demoaut.com")
	public void opening_chrome_browser_navigate_to_newtours_demoaut_com() {
	    System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
	    d= new ChromeDriver();
	    d.get("https://demo.guru99.com/test/newtours/");
	    d.manage().window().maximize();
	    
	}

	@When("Get the title & url of the page")
	public void get_the_title_url_of_the_page() {
	    System.out.println(d.getTitle());
	    System.out.println(d.getCurrentUrl());
	}

	@Then("Check the expected title to actual title of the page & Count all links and store in excelsheet")
	public void check_the_expected_title_to_actual_title_of_the_page_count_all_links_and_store_in_excelsheet() {
		Row r=null;
		Cell c=null;
		try {
			FileInputStream f=new FileInputStream("D:\\new.xlsx");
			XSSFWorkbook wb=new XSSFWorkbook(f);
			XSSFSheet ws=wb.getSheet("new");
			WebElement s=d.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/table"));
			List<WebElement>s1=s.findElements(By.tagName("a"));
			System.out.println("NO OF LINKS ARE : "+s1.size());
			for(int i=0;i<s1.size();i++) {
				String a=s1.get(i).getText();
				System.out.println(a);
				r=ws.getRow(i);
				r.createCell(0).setCellValue(a);
				String expurl=r.getCell(1).getStringCellValue();
				r=ws.createRow(i);
				r.createCell(1).setCellValue(expurl);
				s1.get(i).click();
				Thread.sleep(200);
				String acurl=d.getCurrentUrl();
				
				r.createCell(2).setCellValue(acurl);
				d.navigate().back();
				s=d.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/table"));
				s1=s.findElements(By.tagName("a"));
				
				if(expurl.equals(acurl)) {
					r.createCell(3).setCellValue("pass");
				}
				else {
					r.createCell(3).setCellValue("fail");
				}
			}
			FileOutputStream f1=new FileOutputStream("D:\\new.xlsx");
			wb.write(f1);
			f1.close();
		}
		catch(Exception e)
		{
			System.out.print(e);
			r.createCell(3).setCellValue("link not found");
		
		}
	}

	@Then("Take the screenshot & Close the browser")
	public void take_the_screenshot_close_the_browser() throws IOException {
		File a=((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(a,new File("D://p2.png"));
		d.close();
	
	}
}
