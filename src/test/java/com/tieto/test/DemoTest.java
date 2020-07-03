package com.tieto.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DemoTest {
	

	
	@Test
	public void excelRead() throws IOException {

		FileInputStream file = new FileInputStream("testdata/OpenEMRData.xlsx");

		XSSFWorkbook book = new XSSFWorkbook(file);

		XSSFSheet sheet = book.getSheet("validCredentialData");

		int rowCount=sheet.getPhysicalNumberOfRows();
		
		XSSFRow rowCheck=sheet.getRow(0);
		int cellCount=rowCheck.getPhysicalNumberOfCells();
		
		Object [][] main =new Object[rowCount][cellCount];
		
		for (int r =1; r < rowCount; r++) {
			XSSFRow row = sheet.getRow(r);
			for (int c = 0; c < cellCount; c++) {
				XSSFCell cell = row.getCell(c);
				DataFormatter format = new DataFormatter();
				String cellValue = format.formatCellValue(cell);
				System.out.println(cellValue);
			    main[r-1][c]=cellValue;
			}
		}

		book.close();
		file.close();

	}

	// john,john123
	// peter,peter123
	// paul,paul123
//	@DataProvider
//	public Object[][] fillFormData() {
//		Object[][] main = new Object[3][2];
//		main[0][0] = "john";
//		main[0][1] = "john123";
//
//		main[1][0] = "peter";
//		main[1][1] = "peter123";
//
//		main[2][0] = "paul";
//		main[2][1] = "paul123";
//
//		return main;
//
//	}

//	@DataProvider
//	public Object[][] invalidCredetials() {
//		Object[][] main = new Object[1][4];
//		main[0][0] = "admin1";
//		main[0][1] = "pass";
//		main[0][2] = "English (Indian)";
//		main[0][3] = "Invalid username or password";
//
//		
//
//		return main;
//
//	}

//	@Test(dataProvider ="fillFormData" )
//	public void fillFormTest(String username, String password) {
//
//		System.out.println(username + password);
//	}

//	@Test(dataProvider="invalidCredetials")
//	public void invaidTest(String username,String password,String langauge,String expectedValue)
//{
//	System.out.println(username+password+langauge+expectedValue);
//}
}
