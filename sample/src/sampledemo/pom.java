package sampledemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class pom {
	WebDriver d;
	By uname=By.name("userName");
	By pwd=By.name("password");
	By submit=By.name("submit");
	By button=By.linkText("REGISTER");
	pom(WebDriver d)
	{
		this.d=d;
	}
	public void uname(String u)
	{
		d.findElement(uname).sendKeys(u);
	}
	public void pwd(String p)
	{
		d.findElement(pwd).sendKeys(p);
	}
	public void submit()
	{
		d.findElement(submit).click();
	}
	public void register()
	{
		d.findElement(button).click();
	}

}
