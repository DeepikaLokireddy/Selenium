package Stepdefinition;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class test4 {
	WebDriver d;
	
	@Given("user open newtours website")
	public void user_open_newtours_website() {
	    System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
	    d=new ChromeDriver();
	    d.get("https://demo.guru99.com/test/newtours/");
	    d.manage().window().maximize();
	}

	@When("user clicks on regiser button")
	public void user_clicks_on_regiser_button() {
	    d.findElement(By.linkText("REGISTER")).click();
	    
	}

	@Then("user neds to get country names from drop down")
	public void user_neds_to_get_country_names_from_drop_down() throws IOException {
		FileInputStream f1=new FileInputStream("D://dp.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(f1);
		XSSFSheet xs=wb.getSheet("work");
		Row r= null;
		Cell c=null;
		
	    WebElement d1=d.findElement(By.name("country"));
	    List<WebElement> drop1=d1.findElements(By.tagName("option"));
	    for(int i=0;i<drop1.size();i++)
	    {
	    	System.out.println(drop1.get(i).getText());
	    	r=xs.createRow(i);
	    	r.createCell(0).setCellValue(drop1.get(i).getText());
	    	drop1.get(i).click();
	    	if(!drop1.get(i).isSelected())
	    	{
	    		r.createCell(0).setCellValue("Fail");
	    	}
	    	else
	    	{
	    		r.createCell(0).setCellValue("pass");
	    	}
	    	
	    	
	    }
	    FileOutputStream f2=new FileOutputStream("D://dp.xlsx");
	    wb.write(f2);
	    f2.close();
	}

	@And("user need to navigate to home page")
	public void user_need_to_navigate_to_home_page() {
	    d.navigate().back();
	}

	@And("user needs to close the browser")
	public void user_needs_to_close_the_browser() {
	    d.close();
	}


}
