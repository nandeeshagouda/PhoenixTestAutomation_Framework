package com.demo.csv;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class ReadCSVFile {

	public static void main(String[] args) throws IOException, CsvException {
		// TODO Auto-generated method stub
		//Code to read the CSV file in java!!  [IMP interview QA]
		
		InputStream is=Thread.currentThread().getContextClassLoader().getResourceAsStream("testData/LoginCreds.csv");
//		File csvFile=new File("D:\\Automation\\PhoenixTestAutomation_Framework\\src\\main\\resources\\testData\\LoginCreds.csv");
//		FileReader fr=new FileReader(csvFile);
		InputStreamReader isr=new InputStreamReader(is);
		CSVReader csvReader=new CSVReader(isr);//CSVReader constructor
		//Requires a Reader!! 
		
		List<String[]>dataList=csvReader.readAll();
		
		for(String[] dataArray:dataList) {
			System.out.println(dataArray[0]);//First Col data
			System.out.println(dataArray[1]);//second Col data
		}

	}

}
