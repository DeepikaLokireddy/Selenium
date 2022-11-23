package Stepdefinition;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class test3 {

	     WebDriver d;
	    FileInputStream f1;
	    
		@Given("user is in new tours")
		public void user_is_in_new_tours() {
		    System.setProperty("webdriver.chrome.driver","c://chromedriver.exe");
		    d= new ChromeDriver();
		    d.get("https://demo.guru99.com/test/newtours/");
		    d.manage().window().maximize();
		    }

		@When("user need to enter username and password")
		public void user_need_to_enter_username_and_password() throws IOException {
		   
			FileInputStream f1=new FileInputStream("D:\\eclipseworkspace\\testing\\src\\test\\java\\Stepdefinition\\p1.properties");
			Properties p2=new Properties();
			p2.load(f1);
			d.findElement(By.name("userName")).sendKeys(p2.getProperty("username"));
			d.findElement(By.name("password")).sendKeys(p2.getProperty("password"));
			
			
		}

		@Then("user clicks on submit button")
		public void user_clicks_on_submit_button() {
		    d.findElement(By.name("submit")).click();
		}

		@And("user takes screenshot and close the page")
		public void user_takes_screenshot_and_close_the_page() throws IOException {
		    File f2=((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
		    Files.copy(f2,new File("D://newfile.png"));
		}


	}
