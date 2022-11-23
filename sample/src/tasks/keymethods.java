package tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class keymethods {
	ChromeDriver d;
	 public void Opening_Browser()
	{
		System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
		d= new ChromeDriver();
		
		
	}
	public void Navigate()
	{
		d.get("https://demo.guru99.com/test/newtours/");
		d.manage().window().maximize();
	}
	public void usernamenter()
	{
		d.findElement(By.name("userName")).sendKeys("deepikareddy");
	}
	public void passwordenter()
	{
		d.findElement(By.name("password")).sendKeys("123456");
	}
	public void click()
	{
		d.findElement(By.name("submit")).click();
	}
	/*public void close()
	{
		d.close();
	}*/
	

}
