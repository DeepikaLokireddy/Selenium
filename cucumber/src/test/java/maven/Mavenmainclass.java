package maven;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;

public class Mavenmainclass {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C://chromedriver.exe");
		ChromeDriver d= new ChromeDriver();
		d.get("https://demo.guru99.com/selenium/newtours/");
		
		d.manage().window().maximize();
		pom1 a = new pom1(d);
		a.uname();
		a.pwd();
		a.submit();
		Thread.sleep(2000);
		d.close();
		
	}

}
