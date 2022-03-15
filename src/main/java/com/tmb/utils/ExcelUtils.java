package com.tmb.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.tmb.Constants.FrameworkConstants;
import com.tmb.exception.FrameworkException;
import com.tmb.exception.InvalidPathForExcelException;

public final class ExcelUtils {

	private ExcelUtils() {

	}

	public static List<Map<String, String>> getTestDetails(String sheetName) {
		List<Map<String, String>> list = null;

		try (FileInputStream fip = new FileInputStream(FrameworkConstants.getExcelpath())) {

			XSSFWorkbook wb = new XSSFWorkbook(fip);
			XSSFSheet sh = wb.getSheet(sheetName);

			int lastRowNum = sh.getLastRowNum();
			int lastColNumb = sh.getRow(0).getLastCellNum();
			System.out.println(lastColNumb + "******" + lastRowNum);
			Map<String, String> map = null;
			list = new ArrayList<>();

			for (int i = 1; i <= lastRowNum; i++) {
				map = new HashMap<>();
				for (int j = 0; j < lastColNumb; j++) {

					String key = sh.getRow(0).getCell(j).getStringCellValue();
					String value = sh.getRow(i).getCell(j).getStringCellValue();
					map.put(key, value);
				}
				list.add(map);
			}

		} catch (FileNotFoundException e) {

			throw new InvalidPathForExcelException("Excel file you are trying to read is not found");
		} catch (IOException e) {

			throw new FrameworkException("Some IO exception happened while reading excel file");
			
		}

		return list;

	}
}
