package com.infragistics.data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.infragistics.extensions.StringList;

public class CsvDataProvider {
	
	public static StringList LoadData(String fileName){
		
		StringList data = new StringList();
		BufferedReader reader = null;
		String line = "";
		System.out.println("Loading Data from: " + fileName + " started...");
		int itemsCount = 0;
		try {
			
			InputStream in = FinancialDataSample.class.getResourceAsStream(fileName);
		    reader = new BufferedReader(new InputStreamReader(in));
			//reader.readLine(); // skip first line
			while((line = reader.readLine()) != null){
		    	
				data.add(line);
		        itemsCount++;
			}
		} catch (FileNotFoundException e) {
			System.out.println("Loading data failed on finding: " + fileName);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Loading data failed on reading: " + fileName);
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Loading data failed on error: " + fileName);
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					System.out.println("Loading data failed on closing: " + fileName);
					e.printStackTrace();
				}
			}
			System.out.println("Loading data from: " + fileName + " completed with " + itemsCount + " items.");
		}
		return data;
	}
}
