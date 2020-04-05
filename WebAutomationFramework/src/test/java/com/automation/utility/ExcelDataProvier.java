package com.automation.utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvier {
	XSSFWorkbook wb;

	public ExcelDataProvier() {
		File src = new File("./TestData/TestData.xlsx");

		try {
			FileInputStream fis = new FileInputStream(src);

			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("exception in reading the TestData.xlsx file." + e.getMessage());
		}

	}
	
	public String getStringData(int sheetIndex, int row, int col) {
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(col).getStringCellValue();	
		}
	
	public String getStringData(String sheetName, int row, int col) {
	return wb.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();	
	}
	
	public Double getNumericValue(String sheetName, int row, int col) {
		return wb.getSheet(sheetName).getRow(row).getCell(col).getNumericCellValue();
	}
}
