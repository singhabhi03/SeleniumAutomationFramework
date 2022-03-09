package com.tmb.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.tmb.Constants.FrameworkConstants;

public final class ExcelUtils {

	private ExcelUtils() {

	}

	public static List<Map<String, String>> getTestDetails() {
		List<Map<String, String>> list = null;
		FileInputStream fip = null;
		try {
			fip = new FileInputStream(FrameworkConstants.getExcelpath());
			XSSFWorkbook wb = new XSSFWorkbook(fip);
			XSSFSheet sh = wb.getSheet("RUNMANAGER");

			int lastRowNum = sh.getLastRowNum();
			int lastColNumb = sh.getRow(0).getLastCellNum();
			System.out.println(lastColNumb +"******"+lastRowNum);
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

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		finally {
			try {
				if(Objects.nonNull(fip)) {
					fip.close();
				}
			
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}

		return list;

	}
}
