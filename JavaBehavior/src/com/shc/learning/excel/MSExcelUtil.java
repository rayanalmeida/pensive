package com.shc.learning.excel;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class MSExcelUtil {


	private String inputFile;
	private String outputFile;

	public void setInputFile(String inputFile) {
		this.inputFile = inputFile;
	}
	
	public void setOutputFile(String outputFile) {
		this.outputFile = outputFile;
	}

	public void read() throws IOException  {
		try {
			File inputWorkbook = new File(inputFile);
			HSSFWorkbook book = new HSSFWorkbook(new FileInputStream(inputWorkbook));
			int i = book.getSheetIndex("OMS Status With Description");
			HSSFSheet sheet1 = book.getSheetAt(i);
			sheet1 = book.getSheet("OMS Status With Description");

			Iterator<Row> rows = sheet1.iterator();
			OutputStream fo = new BufferedOutputStream(new FileOutputStream(outputFile));
			Writer writer = new OutputStreamWriter(fo);
			while(rows.hasNext()) {
				Row row = rows.next();
				Iterator<Cell> cells = row.cellIterator();
				while(cells.hasNext()) {
					Cell cell = cells.next();
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_BLANK:
						writer.write(",");
					case Cell.CELL_TYPE_BOOLEAN:
					case Cell.CELL_TYPE_ERROR:
					case Cell.CELL_TYPE_FORMULA:
					case Cell.CELL_TYPE_NUMERIC:
						writer.write(String.valueOf(cell.getNumericCellValue()));
						writer.write(",");
					case Cell.CELL_TYPE_STRING:
						writer.write(cell.getStringCellValue());
						writer.write(",");
					}
				}
				writer.write("\n");
			}
			writer.flush();writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws IOException {
		MSExcelUtil test = new MSExcelUtil();
		test.setInputFile("D://Documents//OMS//OMS//Description - OMS status.xls");
		test.setOutputFile("D://Documents//OMS//OMS//OMS status.csv");
		test.read();
	}
}
