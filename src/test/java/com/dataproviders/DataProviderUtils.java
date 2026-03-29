package com.dataproviders;

import java.util.Iterator;

import org.testng.annotations.DataProvider;

import com.api.utils.CSVReaderUtil;
import com.dataproviders.api.bean.UserBean;

public class DataProviderUtils {
	
	@DataProvider(name="LoginAPIDataProvider",parallel=true)  //if i am not giving a name to the dataProvider. then name of the data provider is method name 
	public static Iterator<UserBean> LoginAPIDataProvider() {
		
		return CSVReaderUtil.loadCSv("testData/LoginCreds.csv");
		
	}
	
	//Data provider needs to return something!!
	//[]
	//[][]
	//Iterator<>
}
