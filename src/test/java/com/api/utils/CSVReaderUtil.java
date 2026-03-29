package com.api.utils;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.dataproviders.api.bean.UserBeam;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class CSVReaderUtil {

	/*
	 * Constructor is private
	 * 
	 * static- static method! Job: Help me Read the CSV file and map it a Bean
	 * 
	 * 
	 * 
	 */

	private CSVReaderUtil() {

		// No one can create object of CSVReaderUtil outSide the class
		// Singleton class Constructor are private
	}

	public static void loadCSv(String pathOfCSVFile) {

		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(pathOfCSVFile);
		InputStreamReader isr = new InputStreamReader(is);
		CSVReader csvReader = new CSVReader(isr);// CSVReader constructor

		CsvToBean<UserBeam> csvToBean = new CsvToBeanBuilder(csvReader).withType(UserBeam.class)
				.withIgnoreEmptyLine(true).build();

		List<UserBeam> userList = csvToBean.parse();
		System.err.println(userList);

	}

}
