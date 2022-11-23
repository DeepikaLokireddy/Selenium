package maven;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class pom1 {
	WebDriver d;
	By uName =By.name("userName");
	By password=By.name("password");
	By Button=By.name("submit");
	public pom1(WebDriver d){
		this.d= d;
	}
	
	
	public void uname() {
		d.findElement(uName).sendKeys("Admin");
		
	}
	public void pwd() {
		d.findElement(password).sendKeys("Admin@123");
	}
	public void submit() {
		d.findElement(Button).click();
	}
}
