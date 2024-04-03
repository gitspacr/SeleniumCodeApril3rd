package com.qa.testdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ReadDataFromExcel {

	@DataProvider(name="supplyData")
	public String[][] excelTestData() throws Exception, IOException {
		
		File file =new File("./TestData/TestData1.xlsx");
		System.out.println(file.exists());
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sh=wb.getSheet("Sheet1");
		int noOfRows=sh.getPhysicalNumberOfRows();
		System.out.println(noOfRows);
		System.out.println(sh.getLastRowNum());
		int noOfCol=sh.getRow(0).getLastCellNum();
		System.out.println(noOfCol);
		
		String[][] passData=new String[noOfRows-1][noOfCol];
		for(int i=0;i<noOfRows-1;i++) {
			for(int j=0;j<noOfCol;j++) {
				
				DataFormatter df=new DataFormatter();
				passData[i][j] =df.formatCellValue(sh.getRow(i+1).getCell(j));
				
			}
			System.out.println(" ");
		}
		wb.close();
		fis.close();
		
		return passData;
	}
}
