package com.actitime.generics;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib {
	public  String getPropertyData(String key) throws IOException {
		FileInputStream fis=new FileInputStream("./data/commondata.properties");
			Properties p=new Properties();
			p.load(fis);
			String value = p.getProperty(key);
			return value;
	}
	public String getExcelData(String sheetname,int row,int cell) throws EncryptedDocumentException, IOException, InvalidFormatException {
		FileInputStream fis=new FileInputStream("./data/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetname).getRow(row).getCell(cell).toString();
		return value;
			}
	public void setExcelData(String sheetname,int row,int cell,String setvalue) throws EncryptedDocumentException, IOException, InvalidFormatException {
		FileInputStream fis=new FileInputStream("./data/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetname).getRow(row).getCell(cell).setCellValue(setvalue);
		FileOutputStream fos=new FileOutputStream("./data/TestScriptData.xlsx");
		wb.write(fos);
		wb.close();
	}
}
