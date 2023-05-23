package com.makemytrip.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;


public class ReadExcelFile {
	public static File file;
	public static FileInputStream fis;
	@DataProvider(name="bvttest")
	public String[][] readExcelFile(Method m) throws EncryptedDocumentException, IOException {
		String sheetname =m.getName();
		file= new File(System.getProperty("user.dir")+"\\testdata\\testdata.xlsx");
		fis=new FileInputStream(file);
		Workbook wb =WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetname);
		System.out.println("sheet name is " +sheetname);
		int TotalRows = sheet.getLastRowNum();
		System.out.println("total Rows"+ TotalRows);
		Row rows= sheet.getRow(0);
		int TotalColn = rows.getLastCellNum();
		System.out.println("total colon"+ TotalColn);
		
		DataFormatter dataformatter =new DataFormatter();
		String testdata[][] =new String[TotalRows][TotalColn];
		for (int i=1 ;i<TotalRows; i++) {
			for (int j=0;j<TotalColn;j++) {
				testdata[i-1][j]=dataformatter.formatCellValue(sheet.getRow(i).getCell(j));
			}
		}
		return testdata;
	}
	
}
