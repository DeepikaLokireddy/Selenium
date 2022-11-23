package TestDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class test1 {
		WebDriver d;
		// TODO Auto-generated method stub
		@Given("user is in newtours")
		public void user_is_in_newtours() {
		    System.out.println("Given");
		    System.setProperty("webdriver.chrome.driver","C://chromedriver.exe");
		    d=new ChromeDriver();
		    d.get("https://demo.guru99.com/selenium/newtours/");
		    d.manage().window().maximize();
		}

		@When("^user needs to enter (.*) and (.*)$")
		public void user_needs_to_enter_username_and_password(String uname,String password) {
			//System.out.println("when");
			d.findElement(By.name("userName")).sendKeys(uname);
			d.findElement(By.name("password")).sendKeys(password);
		}

		@Then("user clicks on signon button")
		public void user_clicks_on_signon_button() {
			//System.out.println("then");
			d.findElement(By.name("submit")).click();
			
		}

		@And("user navigate to homepage")
		public void user_navigate_to_homepage() {
			System.out.println("navigated to home page");
		}

	

	
}