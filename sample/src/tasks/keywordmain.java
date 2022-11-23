package tasks;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class keywordmain {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		keymethods k1=new keymethods();
		FileInputStream f1=new FileInputStream("D://keys.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(f1);
		XSSFSheet xs=wb.getSheet("Sheet1");
		Row r=null;
		Cell c=null;
		Iterator<Row>row=xs.iterator();
		for(int i=0;row.hasNext()!=false;i++)
		{
		r=xs.getRow(i);
		c=r.getCell(2);
		String s1=c.getStringCellValue();
		switch(s1)
		{
		case "Opening_Browser":
			k1.Opening_Browser();
			//break;
		case "Navite":
			k1.Navigate();
			//break;
		case "User_Name ":
			k1.usernamenter();
			//break;
		case "Password":
			k1.passwordenter();
			//break;
		case "Click":
			k1.click();
			//break;
		/*ase "Close":
			k1.close();
			//break;
			*/

		
			
		}
		

	}
	}
}
