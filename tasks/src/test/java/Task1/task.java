/*Test scenario : 3
		Opening chrome browser 
		Navigate to dezlearn.com 
		Capture the entire web table 
		Get the row fields as well as column fields 
		Get the title and url of the page 
		Capture the screenshot 
	Close the browser 
*/


package Task1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class task {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
		ChromeDriver d= new ChromeDriver();
		d.get("https://www.dezlearn.com/webtable-example/");
		d.manage().window().maximize();
		String a="//*[@id=\"post-9373\"]/div/div/div/div/section/div/div/div/div/div/section/div/div/div/div/div/div/div/table/tbody/tr[";
		String b="]/td[";
		for(int j=2;j<=7;j++) {
		    for(int i=1;i<=2;i++) {
			String e=a+j+b+i+"]";
			System.out.print(d.findElement(By.xpath(e)).getText()+"\t");			
		}
		System.out.println();
		}
		d.close();
	}

}


////*[@id="post-9373"]/div/div/div/div/section/div/div/div/div/div/section/div/div/div/div/div/div/div/table/tbody/tr[2]/td[1]
////*[@id="post-9373"]/div/div/div/div/section/div/div/div/div/div/section/div/div/div/div/div/div/div/table/tbody/tr[7]/td[1]
////*[@id="post-9373"]/div/div/div/div/section/div/div/div/div/div/section/div/div/div/div/div/div/div/table/tbody/tr[2]/td[2]
////*[@id="post-9373"]/div/div/div/div/section/div/div/div/div/div/section/div/div/div/div/div/div/div/table/tbody/tr[2]/td[3]


