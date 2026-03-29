package com.demo.csv;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class ReadCSVFile {

	public static void main(String[] args) throws IOException, CsvException {
		// TODO Auto-generated method stub
		//Code to read the CSV file in java!!  [IMP interview QA]
		
		File csvFile=new File("D:\\Automation\\PhoenixTestAutomation_Framework\\src\\main\\resources\\testData\\LoginCreds.csv");
		FileReader fr=new FileReader(csvFile);
		CSVReader csvReader=new CSVReader(fr);//CSVReader constructor
		//Requires a Reader!! 
		
		List<String[]>dataList=csvReader.readAll();
		
		for(String[] dataArray:dataList) {
			for(String data:dataArray) {
				System.out.print(data+" ");
			}
			System.out.println("");
		}

	}

}
