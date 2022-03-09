package com.tmb.listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import com.tmb.Constants.FrameworkConstants;
import com.tmb.utils.ExcelUtils;

public class MethodInterceptor  implements IMethodInterceptor{
	
	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {

	List<Map<String, String>> list = null;
	try {
		list = ExcelUtils.getTestDetails(FrameworkConstants.getRunmanagersheet());
	} catch (Exception e) {

		e.printStackTrace();
	}

	List<IMethodInstance> result = new ArrayList<>();
System.out.println(list.size()+"*****"+methods.size());
	for (int i = 0; i < methods.size(); i++) {
		for (int j = 0; j < list.size(); j++) {
			System.out.println(methods.get(i).getMethod().getMethodName());
			if (methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list.get(j).get("testname"))
					&& list.get(j).get("execute").equalsIgnoreCase("yes")) {
				methods.get(i).getMethod().setDescription(list.get(i).get("Description"));
				

				result.add(methods.get(i));

			}

		}
	}

	return result;
}


}
