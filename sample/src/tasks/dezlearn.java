package tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class dezlearn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
		ChromeDriver d= new ChromeDriver();
		d.get("https://www.dezlearn.com/webtable-example/");
		String first="//*[@id=\"post-9373\"]/div/div/div/div/section/div/div/div/div/div/section/div/div/div/div/div/div/div/table/tbody/tr[";
		String last="]/td[";
		String e="]";
		for(int i=2;i<=7;i++)
		{
			int j=1;
			String c=first+i+last+j+e;
			System.out.print(d.findElement(By.xpath(c)).getText()+"\t");
			int k=2;
			String d1=first+i+last+k+e;
			System.out.println(d.findElement(By.xpath(d1)).getText());
		}
		}

	}

