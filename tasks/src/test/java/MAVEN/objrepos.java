package MAVEN;

import java.io.File;
import java.io.FileInputStream;
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

public class objrepos {
	WebDriver d;
	By uame =By.name("userName");
	By password=By.name("password");
	By Button=By.name("submit");
	By button2=By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]");

	public objrepos(WebDriver d){
		this.d= d;
	}
	public void uName(String u) {
		d.findElement(uame).sendKeys(u);
		
	}
	public void pwd(String pass) {
		d.findElement(password).sendKeys(pass);
	}
	public void submit() {
		d.findElement(Button).click();
	}
	public void back() throws IOException {
		d.navigate().back();
		d.findElement(button2).click();
		FileInputStream f=new FileInputStream("D://add2.xlsx");
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
		FileOutputStream f2 =new FileOutputStream("D://add2.xlsx");
		wb.write(f2);
		f2.close();
	}
	public void screenshot() throws IOException {
		
		File a=((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(a,new File("D://p.png"));
	}
	
	
}
