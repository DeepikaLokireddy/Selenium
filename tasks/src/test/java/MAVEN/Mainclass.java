package MAVEN;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.chrome.ChromeDriver;

public class Mainclass {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		FileInputStream f=new FileInputStream("C:\\Users\\sai vijaya lakshmi\\eclipse-workspace\\TASKS\\src\\test\\java\\MAVEN\\sample1");
		Properties p=new Properties();
		p.load(f);
		System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
		ChromeDriver d= new ChromeDriver();
		d.get(p.getProperty("url"));
		d.manage().window().maximize();
		objrepos a= new objrepos(d);
		a.uName(p.getProperty("UName"));
		a.pwd(p.getProperty("passWord"));
		a.submit();
		a.back();
		Thread.sleep(2000);
		a.screenshot();
		d.close();

	}

}
