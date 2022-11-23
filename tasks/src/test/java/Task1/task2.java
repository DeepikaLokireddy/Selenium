package Task1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class task2 {
	WebDriver d;
	@Given("user is in amazon page")
	public void user_is_in_amazon_page() {
	    System.setProperty("webdriver.chrome.driver","C://chromedriver.exe");
	    d= new ChromeDriver();
	    d.get("https://www.amazon.in/?tag=msndeskabkin-21&hvadid=72705384568100&hvqmt=e&hvbmt=be&hvdev=c&ref=pd_sl_5twasf2d2w_e");
	    d.manage().window().maximize();
	    
	}

	@When("user needs to get url and get title")
	public void user_needs_to_get_url_and_get_title() {
	    System.out.println(d.getCurrentUrl());
	    System.out.println(d.getTitle());
	}

	@Then("get links frpm dropdown and navigate back and capture the dropdown elements and store in xlsheet")
	public void get_links_frpm_dropdown_and_navigate_back_and_capture_the_dropdown_elements_and_store_in_xlsheet() throws IOException {
		FileInputStream f=new FileInputStream("D://add3.xlsx");
		XSSFWorkbook wb= new XSSFWorkbook(f);
		XSSFSheet s= wb.getSheet("Sheet1");
		Row r=null;
		Cell c=null;
		WebElement drop = d.findElement(By.xpath("//*[@id='searchDropdownBox']"));
		List<WebElement> drop1=drop.findElements(By.tagName("option"));
		System.out.println(drop1.size());
		for(int i=0;i<drop1.size();i++) {
			String lin=drop1.get(i).getText();
			drop1.get(i).click();
			String url=d.getCurrentUrl();
			String tit=d.getTitle();
			r=s.createRow(i);
			r.createCell(0).setCellValue(lin);
			r.createCell(1).setCellValue(tit);
			r.createCell(2).setCellValue(url);
			d.navigate().back();
			drop=d.findElement(By.xpath("//*[@id='searchDropdownBox']"));
			drop1=drop.findElements(By.tagName("option"));
		}
		FileOutputStream f2 =new FileOutputStream("D://add3.xlsx");
		wb.write(f2);
		f2.close();
	}
	@And("user takes screenshot of the page")
	public void user_takes_screenshot_of_the_page() throws IOException {
		File a=((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(a,new File("D://p1.png"));
		d.close();
	
	}
	


}
