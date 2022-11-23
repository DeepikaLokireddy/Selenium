package StepDefination;

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

public class task1 {
	WebDriver d;
	@Given("user is in new tours")
	public void user_is_in_new_tours() {
		System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
		d= new ChromeDriver();
		d.get("https://demo.guru99.com/test/newtours/index.php");
		d.manage().window().maximize();
	}

	@When("user need to enter username and password and click on submit")
	public void user_need_to_enter_username_and_password_and_click_on_submit() {
	    d.findElement(By.name("userName")).sendKeys("mercury");
	    d.findElement(By.name("password")).sendKeys("1235545");
	    d.findElement(By.name("submit")).click();   
	}

	@Then("navigate back to register page and capture the dropdown elements and store in xlsheet")
	public void navigate_back_to_register_page_and_capture_the_dropdown_elements_and_store_in_xlsheet() throws IOException {
		d.navigate().back();
		d.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]")).click();
		FileInputStream f=new FileInputStream("D://add3.xlsx");
		XSSFWorkbook wb= new XSSFWorkbook(f);
		XSSFSheet s= wb.getSheet("Sheet1");
		Row r=null;
		Cell c=null;
		WebElement drop = d.findElement(By.name("country"));
		List<WebElement> drop1=drop.findElements(By.tagName("option"));
		System.out.println(drop1.size());
		for(int i=0;i<drop1.size();i++) {
			String txt=drop1.get(i).getText();
			r=s.createRow(i);
			r.createCell(0).setCellValue(txt);
		}
		FileOutputStream f2 =new FileOutputStream("D://add3.xlsx");
		wb.write(f2);
		f2.close();
	}

	@And("user takes screenshot")
	public void user_takes_screenshot() throws IOException {
		File a=((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(a,new File("D://p1.png"));
		d.close();
	}


}
