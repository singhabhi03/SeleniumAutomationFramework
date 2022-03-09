package com.tmb.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.tmb.Constants.FrameworkConstants;

public final class DataProviderUtils {
	@DataProvider
	public static Object[] getData(Method m) {
		String testName = m.getName();
	List<Map<String, String>> list =	ExcelUtils.getTestDetails(FrameworkConstants.getDatasheet());
	List<Map<String, String>> iterationList = new ArrayList<>();
	for(int i=0;i<list.size();i++) {
		if(list.get(i).get("testname").equalsIgnoreCase(testName) && list.get(i).get("execute").equalsIgnoreCase("yes")) {
			iterationList.add(list.get(i));
			
		}
	}
		return iterationList.toArray();
		
	}

}
