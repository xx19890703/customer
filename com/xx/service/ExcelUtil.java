package com.xx.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelUtil {

	public void exportExcel(String name,String[] headers,Integer[] widths,String[][] lists ) throws Exception {
		HSSFWorkbook workBook = new HSSFWorkbook();
		HSSFSheet sheet = workBook.createSheet(name);

		// 设置单元格的宽度(0:表示第一行的第一个单元格，1：第一行的第二个单元格)
		for(int i=0;i<headers.length;i++){
			sheet.setColumnWidth((short) i, widths[i]);
		}
		
		// 创建一个单元格，从0开始
		HSSFRow row = sheet.createRow((short) 0);

		HSSFCell cell[] = new HSSFCell[headers.length];
		for (int i = 0; i < headers.length; i++) {
			cell[i] = row.createCell(i);
			cell[i].setCellValue(headers[i]);
		}

			// 循环list中的数据
			for (int i = 0; i < lists.length; i++) {
				String[] values = lists[i];
				HSSFRow dataRow = sheet.createRow(i + 1);
				HSSFCell data[] = new HSSFCell[headers.length];
				for (int j = 0; j < values.length; j++) {
					data[j] = dataRow.createCell(j);
					data[j].setCellValue(lists[i][j]);
				}

				try {
					// 输出成XLS文件
					FileOutputStream fos = new FileOutputStream("D:/"+name+".xls");
					// 写入数据，并关闭文件
					workBook.write(fos);
					fos.close();

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	}

}
