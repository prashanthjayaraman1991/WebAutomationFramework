package com.automation.utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvier {
	XSSFWorkbook wb;

	/**
	 * Constructor which initializes the Execl file used to read test data
	 */
	public ExcelDataProvier() {
		File src = new File(System.getProperty("user.dir") + "/TestData/TestData.xlsx");

		try {
			FileInputStream fis = new FileInputStream(src);

			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("exception in reading the TestData.xlsx file." + e.getMessage());
		}

	}

	/**
	 * returns the data stored in the row and column number passed as parameters
	 * 
	 * @param sheetIndex
	 * @param row
	 * @param col
	 * @return
	 */
	public String getStringData(int sheetIndex, int row, int col) {
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(col).getStringCellValue();
	}

	/**
	 * returns the data stored in the row and column number passed as parameters
	 * 
	 * @param sheetIndex
	 * @param row
	 * @param col
	 * @return
	 */
	public String getStringData(String sheetName, int row, int col) {
		return wb.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();
	}

	/**
	 * returns the data stored in the row and column number passed as parameters
	 * 
	 * @param sheetIndex
	 * @param row
	 * @param col
	 * @return
	 */
	public Double getNumericValue(String sheetName, int row, int col) {
		return wb.getSheet(sheetName).getRow(row).getCell(col).getNumericCellValue();
	}
}
